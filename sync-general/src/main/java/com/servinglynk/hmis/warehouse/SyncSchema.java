package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class SyncSchema extends Logging {


    private SyncHBaseProcessor syncHBaseImport;
    private int syncPeriod;
    private int year;
    private String syncSchemas;
    private Logger logger;
    private String[] ids;

    public SyncSchema(Logger logger) throws Exception {
        this.logger = logger;
        this.syncHBaseImport = new SyncHBaseProcessor();
        this.syncPeriod = Properties.SYNC_PERIOD;
        this.syncSchemas = Properties.SYNC_SCHEMAS;
    }

    public void sync(boolean delta) throws Exception {
        List<String> projectGroupCodes = SyncPostgresProcessor.getAllProjectGroupCodes(logger);
        for(String projectGroupCode : projectGroupCodes) {
        	 syncTablesToHBase(delta,projectGroupCode);
        }
        log.info("Sync process completed.");
    }

    private void syncTablesToHBase(boolean delta,String projectGroupCode) throws Exception {
        if (syncSchemas.trim().length() > 0) {
            String[] schemas = syncSchemas.split(",");
            for (String schema : schemas) {
                log.info("\n#############################################################\n");
                log.info("##########Start a new sync for schema " + schema + " #########");
                log.info("\n#############################################################\n");
                log.info("Start a new sync for schema " + schema);
                List<String> tables = getTablesToSync(schema);
                if (tables.size() < 1) {
                    logger.info("Skip sync for schema " + schema + ". No tables found in it");
                    continue;
                }
                FileAppender appender = new FileAppender();
                String appenderName = "sync-" + schema+"-"+projectGroupCode;
                appender.setName(appenderName);
                appender.setFile("logs/" + appenderName + ".log");
                appender.setImmediateFlush(true);
                appender.setAppend(true);
                appender.setLayout(new PatternLayout());
                appender.activateOptions();
                logger.addAppender(appender);

                try {
                    logger.info("Create tables in HBASE");
                    tables.forEach(table -> syncHBaseImport.createHBASETable(table + "_" + projectGroupCode, logger));
                    logger.info("Create tables done");
                    for (final String tableName : tables) {
                        logger.info("[" + tableName + "] Processing table : " + tableName);
                        try {
                            syncTable(tableName, tableName + "_" + projectGroupCode, schema,delta,projectGroupCode);
                        } catch (Exception ex) {
                           logger.error(ex);
                        }
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                } finally {
                    logger.removeAppender(appender);
                }
            }
        } else {
            throw new Exception("No schema to sync, please specify at least on schema");
        }
    }

    private void syncTable(String postgresTable, String hbaseTable, String syncSchema,boolean delta,String projectGroupCode) {
        log.info("Start sync for table: " + postgresTable);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        try {
            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
            connection = SyncPostgresProcessor.getConnection();
            boolean empty = true;
            String message ="";
            int count = 0;
            Long insertCount =0L;
            Long updateCount =0L;
            Long deleteCount =0L;
            while(true) {
            	int limit = 20000;
            	String deltaQuery = "";
            	if(delta) {
            		deltaQuery=" date_updated >= (select date_created from "+syncSchema+".sync where sync_table='"+postgresTable+"' and project_group_code='"+projectGroupCode+"' order by date_updated  desc limit 1 ) ";
            		if(StringUtils.equals("survey", syncSchema)) {
            			deltaQuery=" updated_at >= (select date_created from "+syncSchema+".sync where sync_table='"+postgresTable+"' order by updated_at  desc limit 1 ) ";
            		}
            	}
            	String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable +" where project_group_code = ? and "+deltaQuery+" limit ?  offset ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, projectGroupCode);
            statement.setInt(2, 20000);
            int offset = limit*count++;
            statement.setInt(3,offset);
            resultSet = statement.executeQuery();

            List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
            List<String> existingKeysInPostgres = new ArrayList<>();
            List<Put> putsToUpdate = new ArrayList<>();
            List<Put> putsToInsert = new ArrayList<>();
            List<String> putsToDelete = new ArrayList<>();
            while (resultSet.next()) {
                Boolean markedForDelete = false;
                empty = false;
                if(!StringUtils.equals("notificationdb", syncSchema)) {
	                try{
	                	markedForDelete = resultSet.getBoolean("deleted");
	                }catch (Exception ex){
	                    logger.error("table does not contained 'deleted' column", ex);
	                    markedForDelete = false;
	                }
                }
                ResultSetMetaData metaData = resultSet.getMetaData();
                String key = resultSet.getString("id");
                if(key.trim() == ""){
                    continue;
                }
                if (markedForDelete) {
                    if (existingKeysInHbase.contains(key)) {
                        putsToDelete.add(key);
                        if (putsToDelete.size() > syncHBaseImport.batchSize) {
                            syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
                            putsToDelete.clear();
                        }
                    } else {
                        log.debug("Skip row with key: " + key);
                        continue;
                    }
                } else {
                    Put p = new Put(Bytes.toBytes(key));
                    for (int i = 1; i < metaData.getColumnCount(); i++) {
                        String column = metaData.getColumnName(i);
                        String value = resultSet.getString(i);
                        if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value)) {
                            p.addColumn(Bytes.toBytes("CF"),
                                    Bytes.toBytes(column),
                                    Bytes.toBytes(value));
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
                }
                existingKeysInPostgres.add(key);
            }
            deleteCount += putsToDelete.size();
            logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
            if (putsToDelete.size() > 0) {
                syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
            }
            insertCount += putsToInsert.size();
            logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
            if (putsToInsert.size() > 0) {
                htable.put(putsToInsert);
            }
            updateCount += putsToUpdate.size();
            logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
            if (putsToUpdate.size() > 0) {
                htable.put(putsToUpdate);
            }
           break;
        }
        message = " Records inserted : "+insertCount +" updated :"+ updateCount+ " deleted :"+ deleteCount;
        SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "COMPLETED", message,projectGroupCode);
    } catch (Exception ex) {
        logger.error(ex);
        SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "ERROR", "Error in sync process "+ex.getMessage(),projectGroupCode);
    }

    log.info("Sync done for table: " + postgresTable);
    }

    public void syncBase(boolean delta) {
    	   Map<UUID,String> projectGroups = SyncPostgresProcessor.getAllProjectGroupId(logger);
    	   String postgresTable = "hmis_user";
           for(UUID projectGroupId : projectGroups.keySet()) {
        	   String projectGroupCode = projectGroups.get(projectGroupId);
        	   String hbaseTable = postgresTable +"_"+ projectGroupCode;
        	  	syncHBaseImport.createHBASETable( postgresTable +"_"+ projectGroupCode, logger);
        		syncTableBase(postgresTable, hbaseTable,"base",delta,projectGroupId,projectGroupCode);
        		logger.info(" syncing completed of hmis_user for project group code "+projectGroupCode);
           }
    }
    private void syncTableBase(String postgresTable, String hbaseTable, String syncSchema,boolean delta,UUID projectGroupId,String projectGroupCode) {
        log.info("Start sync for table: " + postgresTable);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        try {
            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
            connection = SyncPostgresProcessor.getConnection();
            boolean empty = true;
            String message ="";
            int count = 0;
            Long insertCount =0L;
            Long updateCount =0L;
            Long deleteCount =0L;
            while(true) {
            	int limit = 20000;
            	String deltaQuery = "";
            	if(delta) {
            		deltaQuery=" date_updated >= (select date_created from "+syncSchema+".sync where sync_table='"+postgresTable+"' and project_group_id='"+projectGroupId+"' order by date_updated  desc limit 1 ) ";
            		if(StringUtils.equals("survey", syncSchema)) {
            			deltaQuery=" updated_at >= (select date_created from "+syncSchema+".sync where sync_table='"+postgresTable+"' order by updated_at  desc limit 1 ) ";
            		}
            	}
            	String sql  = "SELECT * FROM " + syncSchema + "." + postgresTable +" where project_group_id = ? and "+deltaQuery+" limit ?  offset ?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1, projectGroupId);
            statement.setInt(2, 20000);
            int offset = limit*count++;
            statement.setInt(3,offset);
            resultSet = statement.executeQuery();

            List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
            List<String> existingKeysInPostgres = new ArrayList<>();
            List<Put> putsToUpdate = new ArrayList<>();
            List<Put> putsToInsert = new ArrayList<>();
            List<String> putsToDelete = new ArrayList<>();
            while (resultSet.next()) {
                Boolean markedForDelete = false;
                empty = false;
                if(!StringUtils.equals("notificationdb", syncSchema)) {
	                try{
	                	markedForDelete = resultSet.getBoolean("deleted");
	                }catch (Exception ex){
	                    logger.error("table does not contained 'deleted' column", ex);
	                    markedForDelete = false;
	                }
                }
                ResultSetMetaData metaData = resultSet.getMetaData();
                String key = resultSet.getString("id");
                if(key.trim() == ""){
                    continue;
                }
                if (markedForDelete) {
                    if (existingKeysInHbase.contains(key)) {
                        putsToDelete.add(key);
                        if (putsToDelete.size() > syncHBaseImport.batchSize) {
                            syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
                            putsToDelete.clear();
                        }
                    } else {
                        log.debug("Skip row with key: " + key);
                        continue;
                    }
                } else {
                    Put p = new Put(Bytes.toBytes(key));
                    for (int i = 1; i < metaData.getColumnCount(); i++) {
                        String column = metaData.getColumnName(i);
                        String value = resultSet.getString(i);
                        if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value) && !StringUtils.contains(column, "password")) {
                            p.addColumn(Bytes.toBytes("CF"),
                                    Bytes.toBytes(column),
                                    Bytes.toBytes(value));
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
                }
                existingKeysInPostgres.add(key);
            }
            deleteCount += putsToDelete.size();
            logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
            if (putsToDelete.size() > 0) {
                syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
            }
            insertCount += putsToInsert.size();
            logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
            if (putsToInsert.size() > 0) {
                htable.put(putsToInsert);
            }
            updateCount += putsToUpdate.size();
            logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
            if (putsToUpdate.size() > 0) {
                htable.put(putsToUpdate);
            }
           break;
        }
        message = " Records inserted : "+insertCount +" updated :"+ updateCount+ " deleted :"+ deleteCount;
        SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "COMPLETED", message,projectGroupCode);
    } catch (Exception ex) {
        logger.error(ex);
        SyncPostgresProcessor.hydrateSyncTable(syncSchema, postgresTable, "ERROR", "Error in sync process "+ex.getMessage(),projectGroupCode);
    }

    log.info("Sync done for table: " + postgresTable);
    }
    
    private List<String> getTablesToSync(String schema) throws Exception {
        log.info("Get tables to sync");
        List<String> tables = new ArrayList<>();
        try{
            tables = SyncPostgresProcessor.getAllTablesFromPostgres(schema);
            log.info("Found " + tables.size() + " tables to sync");
            tables.forEach(table -> log.info("Table to sync: " + table));
        }catch (Exception ex){
            logger.warn("No tables found: ", ex);
        }
        return tables;
    }
    
    public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(SyncSchema.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		props.printProps();
		SyncSchema sync = new SyncSchema(logger);
		sync.syncBase(true);
		sync.sync(true);
    }
}
