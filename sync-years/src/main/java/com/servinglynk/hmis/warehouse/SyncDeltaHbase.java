package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class SyncDeltaHbase extends Logging {


    private SyncHBaseProcessor syncHBaseImport;
    private VERSION version;
    private int syncPeriod;
    private int year;
    private String syncSchema;
    private String includeTables;
    private String excludeTables;
    private Status status;
    private Logger logger;
    private boolean purgeRecords;
	private String projectGroupCode;
	private String commonTables;
	private String projGrpWithIdentifier;
    public SyncDeltaHbase(VERSION version, Logger logger, Status status, boolean purgeRecords) throws Exception {
        this.version = version;
        this.logger = logger;
        this.status = status;
        this.purgeRecords = purgeRecords;
        this.syncHBaseImport = new SyncHBaseProcessor();
        this.commonTables = Properties.COMMON_TABLES;
        this.projGrpWithIdentifier = Properties.PROJECT_GRP_WITH_CLIENT_IDS;
        switch (version) {
	        case V2020:
	            syncPeriod = Properties.SYNC_2020_PERIOD;
	            syncSchema = Properties.SYNC_2020_SCHEMA;
	            includeTables = Properties.SYNC_2020_INCLUDE_TABLES;
	            excludeTables = Properties.SYNC_2020_EXCLUDE_TABLES;
	            year = 2020;
	            break;
	        case V2017:
	            syncPeriod = Properties.SYNC_2017_PERIOD;
	            syncSchema = Properties.SYNC_2017_SCHEMA;
	            includeTables = Properties.SYNC_2017_INCLUDE_TABLES;
	            excludeTables = Properties.SYNC_2017_EXCLUDE_TABLES;
	            year = 2017;
	            break;
            case V2016:
                syncPeriod = Properties.SYNC_2016_PERIOD;
                syncSchema = Properties.SYNC_2016_SCHEMA;
                includeTables = Properties.SYNC_2016_INCLUDE_TABLES;
                excludeTables = Properties.SYNC_2016_EXCLUDE_TABLES;
                year = 2016;
                break;
            case V2015:
                syncPeriod = Properties.SYNC_2015_PERIOD;
                syncSchema = Properties.SYNC_2015_SCHEMA;
                includeTables = Properties.SYNC_2015_INCLUDE_TABLES;
                excludeTables = Properties.SYNC_2015_EXCLUDE_TABLES;
                year = 2015;
                break;
            case V2014:
                syncPeriod = Properties.SYNC_2014_PERIOD;
                syncSchema = Properties.SYNC_2014_SCHEMA;
                includeTables = Properties.SYNC_2014_INCLUDE_TABLES;
                excludeTables = Properties.SYNC_2014_EXCLUDE_TABLES;
                year = 2014;
                break;
            default:
                throw new NotImplementedException();
        }

    }

    public void sync(boolean delta) throws Exception {
        log.info("Start a new sync for " + version.name() + " uploads");
        syncTablesToHBase(delta);
        log.info("Sync Completed.");
    }

    private void syncTablesToHBase(boolean delta) throws Exception {

        log.info("Get list of bulkupload for schema: " + syncSchema);
        // list of than 10 uploads
        List<String> projectGroupCodes = SyncPostgresProcessor.getAllProjectGroupCodes(logger);
      
        List<String> tables = getTablesToSync();
        if(tables.size() < 1){
            logger.error("Cannot run sync for schema " + syncSchema + ". No tables found in it");
            System.exit(1);
        }
        log.info("ProjectGroupCodes  size: " + projectGroupCodes.size());
        for (String projectGroupCode : projectGroupCodes) {
            try {
            	String appenderName = "sync-" + syncSchema + "-" + status.name() + "-" + projectGroupCode;
                FileAppender appender = new FileAppender();
                appender.setName(appenderName);
                appender.setFile("logs/" + appenderName + ".log");
                appender.setImmediateFlush(true);
                appender.setAppend(true);
                appender.setLayout(new PatternLayout());
                appender.activateOptions();

                logger.addAppender(appender);
                logger.info("\n#######################################################\n");
                logger.info("######Start new sync for ProjectGroupCode: " + projectGroupCode + "######");
                logger.info("\n#######################################################\n");

                logger.info("Create tables in HBASE");
//                if(!delta) {
//                	tables.forEach(table -> syncHBaseImport.dropHBASETable(table + "_" + projectGroupCode));
//                }
                tables.forEach(table -> syncHBaseImport.createHBASETable(table + "_" + projectGroupCode, logger));
                if( StringUtils.contains(projGrpWithIdentifier, projectGroupCode)) {
                	 syncClientWithIdenfifiers(projectGroupCode);
                }
                
                logger.info("Create tables done");
                SyncPostgresProcessor.updateCreateFlag(projectGroupCode, version, logger);
                Map<String, String> hmisTypes = loadHmisTypeMap(syncSchema);
                for (final String tableName : tables) {
                    final String tempName = tableName;
                    logger.info("[" + tempName + "] Processing table : " + tempName);
                        try {
                            syncTable(tempName, tempName + "_" + projectGroupCode, hmisTypes, projectGroupCode,delta, logger);
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
              }
            } catch (Exception ex) {
                logger.error(ex);
            } finally {
            }
        }
        if(StringUtils.isBlank(commonTables)) {
        	commonTables = "hmis_type,question";
        }
        if(StringUtils.isNotBlank(commonTables)) {
        	String[] split = commonTables.split(",");
        	for (String tableName : split) {
        		String hbaseTable =tableName+"_"+syncSchema;
        		syncHBaseImport.createHBASETable(hbaseTable, logger);
        		syncCommonTable(tableName, hbaseTable, logger);
        	}
        }
    
        if (purgeRecords) {
            log.info("\n\n\n\n Mark rows as deleted");
           // cleanTables(toPurge, tables);
            log.info("Delete mark is done");
        }
    }
    
//    public void syncClientId(final String projectGroupCode) {
//		  log.info("Start sync for table: client_sec");
//	        ResultSet resultSet;
//	        PreparedStatement statement;
//	        Connection connection;
//	        String postgresTable ="client";
//	        try {
//	        	connection = SyncPostgresProcessor.getConnection();
//	        	statement = connection.prepareStatement("select id,dedup_client_id,first_name,last_name,convert_from(dob_decrypt(dob),'UTF-8') as dob ,convert_from(ssn_decrypt(ssn),'UTF-8') as ssn,parent_id,deleted from " + syncSchema + "."+postgresTable+" where deleted=false and   project_group_code =? ");
//	        	statement.setString(1,projectGroupCode);
//	        	resultSet = statement.executeQuery();
//			    while (resultSet.next()) {
//			    	System.out.println(resultSet.getString("id"));
//			    	System.out.println(resultSet.getString("dedup_client_id"));
//			    	System.out.println(resultSet.getString("first_name"));
//			    	System.out.println(resultSet.getString("last_name"));
//			    	System.out.println(resultSet.getString("dob"));
//			    	System.out.println(resultSet.getString("ssn"));
//			    	System.out.println(resultSet.getString("parent_id"));
//			    	System.out.println(resultSet.getBoolean("deleted"));
//			    	System.out.println(year);
//			    }
//	        }catch(Exception e){
//	        	logger.error(" Error when adding the client"+e.getMessage());
//	        }
//	        
//	       	}
    
    private void syncClientWithIdenfifiers(final String projectGroupCode) {
		  log.info("Start sync for table: client_sec");
	        HTable htable;
	        ResultSet resultSet;
	        PreparedStatement statement;
	        Connection connection;
	        String message ="";
	        String postgresTable ="client";
	        try {
	        	connection = SyncPostgresProcessor.getConnection();
	        	String hbaseTableName = "client_sec" + "_" + projectGroupCode;
	        	htable = new HTable(HbaseUtil.getConfiguration(), hbaseTableName);
	        	statement = connection.prepareStatement("select id,dedup_client_id,first_name,last_name,convert_from(dob_decrypt(dob),'UTF-8') as dob ,convert_from(ssn_decrypt(ssn),'UTF-8') as ssn,parent_id,deleted,source_system_id from " + syncSchema + "."+postgresTable+" where deleted=false and   project_group_code =? ");
	        	statement.setString(1,projectGroupCode);
	        	resultSet = statement.executeQuery();
				List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable);
			    List<String> existingKeysInPostgres = new ArrayList<>();
			    syncHBaseImport.createHBASETable(hbaseTableName, logger);
			    List<Put> putsToUpdate = new ArrayList<>();
			    List<Put> putsToInsert = new ArrayList<>();
			    List<String> putsToDelete = new ArrayList<>();
			    boolean isRecordAlreadyExist = false;
			    while (resultSet.next()) {
			    	isRecordAlreadyExist = false;
			    	String key = resultSet.getString("id");
			    	if(existingKeysInHbase.contains(key)) {
			    		isRecordAlreadyExist = true;
			    	}
			    	Put p = new Put(Bytes.toBytes(key));
			    	addColumn(p, "id",resultSet.getString("id"),isRecordAlreadyExist);
			    	addColumn(p, "dedup_client_id",resultSet.getString("dedup_client_id"),isRecordAlreadyExist);
			    	addColumn(p, "first_name",resultSet.getString("first_name"),isRecordAlreadyExist);
			    	addColumn(p, "last_name",resultSet.getString("last_name"),isRecordAlreadyExist);
			    	addColumn(p, "dob",resultSet.getString("dob"),isRecordAlreadyExist);
			    	addColumn(p, "ssn",resultSet.getString("ssn"),isRecordAlreadyExist);
			    	addColumn(p, "source_system_id",resultSet.getString("source_system_id"),isRecordAlreadyExist);
			    	addColumn(p, "parent_id",resultSet.getString("parent_id"),isRecordAlreadyExist);
			    	addColumn(p, "deleted",String.valueOf(resultSet.getBoolean("deleted")),isRecordAlreadyExist);
			    	addColumn(p, "year",String.valueOf(year),isRecordAlreadyExist);
			    	 if (isRecordAlreadyExist) {
                       putsToUpdate.add(p);
                       if (putsToUpdate.size() > syncHBaseImport.batchSize) {
                           htable.put(putsToUpdate);
                           putsToUpdate.clear();
                       }
                   } else {
                       putsToInsert.add(p);
                       if (putsToInsert.size() > syncHBaseImport.batchSize) {
                           htable.put(putsToInsert);
                           putsToInsert.clear();
                       }
                   }
               existingKeysInPostgres.add(key);
			    }
			    logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
	            if (putsToDelete.size() > 0) {
	                syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
	            }
	            logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
              if (putsToInsert.size() > 0) {
                  htable.put(putsToInsert);
                  htable.flushCommits();
              }
              logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
              if (putsToUpdate.size() > 0) {
                  htable.put(putsToUpdate);
                  htable.flushCommits();
              }
              SyncPostgresProcessor.hydrateSyncTable(syncSchema, "client_sec", "COMPLETED", message,projectGroupCode);
	        }catch(Exception e){
	        	e.printStackTrace();
	        	logger.error(" Error when adding the client"+e.getMessage());
	        }
	        
	       	}
	
	private static void addColumn(Put p, String column, String value,boolean isRecordAlreadyExist) {
		if(StringUtils.isNotBlank(value)) {
			if(isRecordAlreadyExist) {
				p.add(Bytes.toBytes("CF"),
		                Bytes.toBytes(column),
		                Bytes.toBytes(value));
			}else {
				p.addColumn(Bytes.toBytes("CF"),
		                Bytes.toBytes(column),
		                Bytes.toBytes(value));
			}
		}
	}
    /***
	 * Loads the Hmistype into a hashMap so that I canbe retrieved from there instead of querying the tables.
	 *
	 * @return Map<String,String>
	 */
	public static Map<String, String> loadHmisTypeMap(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String, String> hmisTypeMap = new HashMap<String, String>();
		try {
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement("SELECT name, value,description FROM " + schema + ".hmis_type");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				String key = name.toLowerCase().trim() + "_" + resultSet.getString(2).trim();
				String desc = resultSet.getString(3);
				hmisTypeMap.put(key, desc);
			}
			return hmisTypeMap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	private void syncCommonTable(String postgresTable, String hbaseTable,Logger logger) {
        log.info("Start sync for table: " + postgresTable);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        String message ="";
        Long insertCount =0L;
        Long updateCount =0L;
        Long deleteCount =0L;
        try {
        	 connection = SyncPostgresProcessor.getConnection();
        	 String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable ;
             statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
        	 htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
        	 List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable);
        	 
        	  List<Put> putsToUpdate = new ArrayList<>();
              List<Put> putsToInsert = new ArrayList<>();
              List<String> putsToDelete = new ArrayList<>();
              while (resultSet.next()) {
                  String key = resultSet.getString("id");
               	Map<String, String> columnMap = SyncPostgresProcessor.getColumnsForTable(postgresTable, syncSchema);
                Put p = new Put(Bytes.toBytes(key));
                if(columnMap != null) {
                Set<String> columns =  columnMap.keySet();
                for (String column : columns) {
                    String columnTypeName = columnMap.get(column);
                    String value = getValue(resultSet,column, columnTypeName);
                          
                          if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value)) {
                              addColumn(column,value,p,key,existingKeysInHbase);
                          }
                      }
                      if (existingKeysInHbase.contains(key)) {
                          putsToUpdate.add(p);
                          if (putsToUpdate.size() > syncHBaseImport.batchSize) {
                              htable.put(putsToUpdate);
                              putsToUpdate.clear();
                          }
                      } else {
                          putsToInsert.add(p);
                          if (putsToInsert.size() > syncHBaseImport.batchSize) {
                              htable.put(putsToInsert);
                              putsToInsert.clear();
                          }
                      }
                  deleteCount += putsToDelete.size();
                }
              }
              logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
              if (putsToDelete.size() > 0) {
                  syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
              }
              insertCount += putsToInsert.size();
              logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
              if (putsToInsert.size() > 0) {
                  htable.put(putsToInsert);
                  htable.flushCommits();
              }
              updateCount += putsToUpdate.size();
              logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
              if (putsToUpdate.size() > 0) {
                  htable.put(putsToUpdate);
                  htable.flushCommits();
              }
          message = " Records inserted : "+insertCount +" updated :"+ updateCount+ " deleted :"+ deleteCount;
          SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "COMPLETED", message,projectGroupCode);
        }catch (Exception ex) {
            logger.error(ex);
            SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "ERROR", "Error in sync process "+ex.getMessage(),projectGroupCode);
        }

        log.info("Sync done for table: " + postgresTable);
	}
	
	
	private void syncCommonTableTest(String postgresTable, String hbaseTable,Logger logger) {
        log.info("Start sync for table: " + postgresTable);
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        String message ="";
        try {
        	 connection = SyncPostgresProcessor.getConnection();
        	 String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable ;
             statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
        	 
              while (resultSet.next()) {
                  String key = resultSet.getString("id");
               	Map<String, String> columnMap = SyncPostgresProcessor.getColumnsForTable(postgresTable, syncSchema);
                if(columnMap != null) {
                Set<String> columns =  columnMap.keySet();
                for (String column : columns) {
                    String columnTypeName = columnMap.get(column);
                    String value = getValue(resultSet,column, columnTypeName);
                    System.out.println("Column :"+column +" value:"+value);
                 }
                }
              }
          SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "COMPLETED", message,projectGroupCode);
        }catch (Exception ex) {
            logger.error(ex);
            SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "ERROR", "Error in sync process "+ex.getMessage(),projectGroupCode);
        }

        log.info("Sync done for table: " + postgresTable);
	}
	
	
    private void syncTable(String postgresTable, String hbaseTable,  Map<String, String> hmisTypes,String projectGroupCode,boolean delta,Logger logger) {
        log.info("Start sync for table: " + postgresTable);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        String message ="";
        Map<String, DedupClientDob> clientDedupMap = new HashMap<>();
        try {
        	connection = SyncPostgresProcessor.getConnection();
        	if(StringUtils.equals("enrollment", postgresTable) || StringUtils.equals("client", postgresTable)) {
            	clientDedupMap = loadDedupClientMap(syncSchema, projectGroupCode,logger);
            }
            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
            boolean empty = true;
            int count = 0;
            Long insertCount =0L;
            Long updateCount =0L;
            Long deleteCount =0L;
            while(true) {
            	empty = true;
            	int limit = 20000;
            	String deltaQuery = "";
            	if(delta) {
            		deltaQuery="and date_updated >= (select date_created from "+syncSchema+".sync where sync_table='"+postgresTable+"' and project_group_code='"+projectGroupCode+"' order by date_updated  desc limit 1 ) ";
            	}
                String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable +" where project_group_code = ? and parent_id is null "+deltaQuery+" limit ?  offset ?";
                statement = connection.prepareStatement(sql);
                statement.setString(1,projectGroupCode);
                statement.setInt(2, 20000);
                int offset = limit*count++;
                statement.setInt(3,offset);
                resultSet = statement.executeQuery();
             
                List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable);
                List<String> existingKeysInPostgres = new ArrayList<>();

                List<Put> putsToUpdate = new ArrayList<>();
                List<Put> putsToInsert = new ArrayList<>();
                List<String> putsToDelete = new ArrayList<>();
                while (resultSet.next()) {
                    Boolean markedForDelete = resultSet.getBoolean("deleted");
                    String key = resultSet.getString("id");
                    empty = false;
                    if (markedForDelete) {
                        if (existingKeysInHbase.contains(key)) {
                            putsToDelete.add(key);
                            if (putsToDelete.size() > syncHBaseImport.batchSize) {
                                syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
                                putsToDelete.clear();
                            }
                        } else {
                            log.debug("Skip row with key: " + key);
                            continue;
                        }
                    } else {
                    	Map<String, String> columnMap = SyncPostgresProcessor.getColumnsForTable(postgresTable, syncSchema);
                        Put p = new Put(Bytes.toBytes(key));
                        if(columnMap != null) {
                        Set<String> columns =  columnMap.keySet();
                        for (String column : columns) {
                            String columnTypeName = columnMap.get(column);
                            String value = getValue(resultSet,column, columnTypeName);
                            if(StringUtils.equals("dob",column))   {
                            	DedupClientDob dedupClientDob = clientDedupMap.get(key);
                            	if(dedupClientDob != null) {
                            		 addColumn("age",String.valueOf(dedupClientDob.getAge()),p,key,existingKeysInHbase);
                            	}
                            }
                            if(StringUtils.equals("client_id", column) && StringUtils.isNotBlank(value)) {
                            	DedupClientDob dedupClientDob = clientDedupMap.get(value);
                            	if(dedupClientDob != null && dedupClientDob.getDedupClientId() !=null) {
                            			if(StringUtils.isNotBlank(dedupClientDob.getDedupClientId())) {
                            				addColumn("dedup_client_id",dedupClientDob.getDedupClientId(),p,key,existingKeysInHbase);
                            			}
                                			addColumn("ageatentry",String.valueOf(dedupClientDob.getAge()),p,key,existingKeysInHbase);
                            	}
                            }
                            if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value)) {
                                addColumn(column,value,p,key,existingKeysInHbase);
                                // Add a new column for description for enums
                                if(StringUtils.equalsIgnoreCase("USER-DEFINED", columnTypeName)) {
                                	String descKey = column.toLowerCase().trim()+"_"+value.trim();
                                	String description = getDescriptionForHmisType(hmisTypes, descKey);
                                	if(StringUtils.isNotBlank(description)) {
                                		 addColumn(column+"_desc",description,p,key,existingKeysInHbase);
                                	}
                                }
                            }
                        } 
                        addColumn("year",String.valueOf(syncSchema.substring(1, syncSchema.length())),p,key,existingKeysInHbase);
                        if (existingKeysInHbase.contains(key)) {
                            putsToUpdate.add(p);
                            if (putsToUpdate.size() > syncHBaseImport.batchSize) {
                                htable.put(putsToUpdate);
                                putsToUpdate.clear();
                            }
                        } else {
                            putsToInsert.add(p);
                            if (putsToInsert.size() > syncHBaseImport.batchSize) {
                                htable.put(putsToInsert);
                                putsToInsert.clear();
                            }
                        }
                    }
                    existingKeysInPostgres.add(key);
                  }
                }
                deleteCount += putsToDelete.size();
                logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
                if (putsToDelete.size() > 0) {
                    syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
                }
                insertCount += putsToInsert.size();
                logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
                if (putsToInsert.size() > 0) {
                    htable.put(putsToInsert);
                    htable.flushCommits();
                }
                updateCount += putsToUpdate.size();
                logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
                if (putsToUpdate.size() > 0) {
                    htable.put(putsToUpdate);
                    htable.flushCommits();
                }
                if(empty){
                	break;
                }
            }
            message = " Records inserted : "+insertCount +" updated :"+ updateCount+ " deleted :"+ deleteCount;
            SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "COMPLETED", message,projectGroupCode);
        } catch (Exception ex) {
            logger.error(ex);
            SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "ERROR", "Error in sync process "+ex.getMessage(),projectGroupCode);
        }

        log.info("Sync done for table: " + postgresTable);
    }
    
    private static void addColumn(String column,String value,Put p,String key,List<String> existingKeysInHbase) {
    	 if (existingKeysInHbase.contains(key) && StringUtils.isNotBlank(value)) {
    		 p.add(Bytes.toBytes("CF"),
                     Bytes.toBytes(column),
                     Bytes.toBytes(value));
    	 }else {
    		 p.addColumn(Bytes.toBytes("CF"),
                     Bytes.toBytes(column),
                     Bytes.toBytes(value));
    	 }
    	
    }
    
    private static String getValue(ResultSet resultSet, String column, String columnTypeName) {
    	try {
    		Object object = resultSet.getObject(column);
        	if(object !=null) {
        		return  object.toString();
        	}
    	}catch(Exception e) {
    		// eat the exception
    	}
    	
    	return null;
//    	if(StringUtils.equalsIgnoreCase("boolean", columnTypeName)) {
//    		Boolean bool = (Boolean) resultSet.getBoolean(column);
//    		return  bool!= null ? bool.toString() : null;
//    	}
//    	if(StringUtils.equalsIgnoreCase("integer", columnTypeName)) {
//    		 int intValue = resultSet.getInt(column);
//    		return esultSet.getInt(column)) : null;
//    	}	
//    		
//    	case "timestamp":
//    	case "date":
	}

	public static int getRecordCount(String projectGroupCode,String syncSchema,String postgresTable) {
    	ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		int count =0;
		try {
    	 connection = SyncPostgresProcessor.getConnection();
         statement = connection.prepareStatement("SELECT count(*) as cnt FROM " + syncSchema + "." + postgresTable +" where project_group_code = ? ");
         statement.setString(1,projectGroupCode);
         while (resultSet.next()) {
        	 count = resultSet.getInt("cnt") ;
        	 break;
         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;
    }
	 /***
		 * Loads the Hmistype into a hashMap so that I canbe retrieved from there instead of querying the tables.
		 *
		 * @return Map<String,String>
		 */
		public static Map<String, DedupClientDob> loadDedupClientMap(String schema,String projectGroupCode, Logger logger) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			Map<String, DedupClientDob> clientDedupClientMap = new HashMap<String, DedupClientDob>();
			try {
				connection = SyncPostgresProcessor.getConnection();
				statement = connection.prepareStatement("SELECT id,dedup_client_id,convert_from(dob_decrypt(dob),'UTF-8') as dob FROM " + schema + ".client where project_group_code=?");
				statement.setString(1, projectGroupCode);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					UUID id = (UUID) resultSet.getObject(1);
					UUID dedupClientId = (UUID) resultSet.getObject(2);
					String dob = (String) resultSet.getObject(3);
					DedupClientDob dedupDob = new DedupClientDob(dedupClientId !=null ?dedupClientId.toString() : null, getAge(dob));
					clientDedupClientMap.put(id.toString(), dedupDob );
				}
				return clientDedupClientMap;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
						//connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return null;
		}
		
    public static int getAge(String dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.parse(dob.substring(0,10),formatter);
				Period p = Period.between(dateOfBirth, currentDate);
				return p.getYears();
			}
		}catch(Exception e) {
		}
		return 0;
	}
	private String getDescriptionForHmisType(final Map<String, String> hmisTypes, String key) {
    	return hmisTypes.get(key);
    }

    private List<String> getTablesToSync() throws Exception {
        log.info("Get tables to sync");
        List<String> tables = new ArrayList<String>();

        try {
            if (includeTables.trim().length() < 1) {
                try {
                    tables = SyncPostgresProcessor.getAllTablesFromPostgres(syncSchema);
                }catch (Exception ex){
                    logger.warn("No tables found in postgres database:  ", ex);
                    throw ex;
                }
            } else {
                try {
                    for (String table : includeTables.split(",")) {
                        tables.add(table);
                    }
                } catch (Exception ex){
                    logger.warn("Unable to include tables specified in property file", ex);
                    throw ex;
                }

            }
        }catch (Exception ex){
            logger.warn("Unable to get tables", ex);
        }

        try {
            if (excludeTables.trim().length() > 0) {
                for (String table : excludeTables.split(",")) {
                    tables.remove(table);
                }
            }
        }catch (Exception ex){
            logger.warn("Unable to exclude tables specified in property file", ex);
        }

        log.info("Found " + tables.size() + " tables to sync");
        tables.forEach(table -> log.info("Table to sync: " + table));
        return tables;
    }

    public void cleanTables(Set<String> toClean, List<String> tables) {
        try {

            for (final String tableName : tables) {
                final String tempName = syncSchema + "." + tableName;
                log.info("[" + tempName + "] Processing table : " + tempName);
                    try {
                        long startNanosTable = System.nanoTime();

                        for (String exportId : toClean) {
                            log.info("[" + tableName + "] Process export_id: " + exportId);
                            SyncPostgresProcessor.markRowsForDeletion(tempName, exportId, logger);
                        }

                        log.info("[" + tempName + "]Time taken to mark for delete rows for '" + tempName + "' in seconds: " +
                                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanosTable) / 1000);
                    } catch (Exception ex) {
                        logger.error(ex);
                    }
            }
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    public static void threadSleep(long period) {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    public static void main(String args[]) throws Exception {
    	 Logger logger = Logger.getLogger(SyncLiveDelta.class.getName());
         Properties props = new Properties();
         props.generatePropValues("application.conf");
         props.printProps();
         new SyncDeltaHbase(VERSION.V2017, logger, Status.LIVE, true);
         
    }

   
}
