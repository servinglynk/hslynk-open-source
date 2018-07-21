package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public SyncDeltaHbase(VERSION version, Logger logger, Status status, boolean purgeRecords) throws Exception {
        this.version = version;
        this.logger = logger;
        this.status = status;
        this.purgeRecords = purgeRecords;
        this.syncHBaseImport = new SyncHBaseProcessor();

        switch (version) {
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
                tables.forEach(table -> syncHBaseImport.createHBASETable(table + "_" + projectGroupCode, logger));
                logger.info("Create tables done");
                SyncPostgresProcessor.updateCreateFlag(projectGroupCode, version, logger);
                Map<String, String> hmisTypes = loadHmisTypeMap(syncSchema);
                for (final String tableName : tables) {
                    final String tempName = tableName;
                    logger.info("[" + tempName + "] Processing table : " + tempName);
                        try {
                            syncTable(tempName, tempName + "_" + projectGroupCode, hmisTypes, projectGroupCode,delta);
                        } catch (Exception ex) {
                            logger.error(ex);
                        }
              }
            } catch (Exception ex) {
                logger.error(ex);
            } finally {
            }
        }

        if (purgeRecords) {
            log.info("\n\n\n\n Mark rows as deleted");
           // cleanTables(toPurge, tables);
            log.info("Delete mark is done");
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

	
    private void syncTable(String postgresTable, String hbaseTable,  Map<String, String> hmisTypes,String projectGroupCode,boolean delta) {
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
            	clientDedupMap = loadDedupClientMap(syncSchema, projectGroupCode);
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
                String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable +" where project_group_code = ? "+deltaQuery+" limit ?  offset ?";
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
                        ResultSetMetaData metaData = resultSet.getMetaData();
                        Put p = new Put(Bytes.toBytes(key));
                        for (int i = 1; i < metaData.getColumnCount(); i++) {
                            String column = metaData.getColumnName(i);
                            String value = resultSet.getString(i);
                            String columnTypeName = metaData.getColumnTypeName(i);
                            if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value)) {
                                p.addColumn(Bytes.toBytes("CF"),
                                        Bytes.toBytes(column),
                                        Bytes.toBytes(value));
                                if((StringUtils.equals("client", postgresTable) && StringUtils.equals("dob", column)) || StringUtils.equals("client_id", column)) {
                                	DedupClientDob dedupClientDob = clientDedupMap.get(key);
                                	if(dedupClientDob != null) {
                                			if(StringUtils.isNotBlank(dedupClientDob.getDedupClientId())) {
                                				p.addColumn(Bytes.toBytes("CF"),
                                                        Bytes.toBytes("dedup_client_id"),
                                                        Bytes.toBytes(dedupClientDob.getDedupClientId()));
                                			}
                                			p.addColumn(Bytes.toBytes("CF"),
                                                    Bytes.toBytes("ageatentry"),
                                                    Bytes.toBytes(String.valueOf(dedupClientDob.getAge())));
                                	}
                                }
                                // Add a new column for description for enums
                                if(columnTypeName.contains(syncSchema)) {
                                	String description = getDescriptionForHmisType(hmisTypes, column.toLowerCase().trim()+"_"+value.trim());
                                	if(StringUtils.isNotBlank(description)) {
                                		 p.addColumn(Bytes.toBytes("CF"),
                                                 Bytes.toBytes(column+"_desc"),
                                                 Bytes.toBytes(description));
                                	}
                                }
                            }
                        }
                        p.addColumn(Bytes.toBytes("CF"),
                                Bytes.toBytes("year"),
                                Bytes.toBytes(String.valueOf(syncSchema.substring(1, syncSchema.length()))));
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
		public static Map<String, DedupClientDob> loadDedupClientMap(String schema,String projectGroupCode) {
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
    

    public static void main(String args[]) {
        String date = "1970-01-01 00:00:00.000000 +00:00:00";
    	//default, ISO_LOCAL_DATE

        System.out.println(getAge(date));
    }

   
}
