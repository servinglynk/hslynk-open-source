package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SyncSchema extends Logging{


    private SyncHBaseImport syncHBaseImport;
    private VERSION version;

    public SyncSchema(VERSION version) throws Exception {

        this.version = version;
        this.syncHBaseImport = new SyncHBaseImport();
    }

    public void sync() throws Exception {
        log.info("Start a new sync for " + version.name() + " uploads");
        syncTablesToHBase();
        log.info("Sync done. Wait " + Properties.SYNC_2016_PERIOD + " minutes before running next sync");
        threadSleep(Properties.SYNC_2016_PERIOD * 60 * 1000);
    }

    private void syncTablesToHBase() throws Exception {
        List<String> tables = getTablesToSync();
        tables.forEach(table -> {
            syncTable(table);
        });
    }

    private void syncTable(String table) {
        log.info("Start sync for table: " + table);
        String tableFinalName = table + "_" + Properties.SYNC_2016_SCHEMA;
        syncHBaseImport.createHBASETable(tableFinalName);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        try {
            htable = new HTable(HbaseUtil.getConfiguration(), tableFinalName);
            connection = PostgresUtil.getConnection();
            statement = connection.prepareStatement("SELECT * FROM " + Properties.SYNC_2016_SCHEMA + "." + table);
            resultSet = statement.executeQuery();

            List<String> existingKeys = syncHBaseImport.getAllKeyRecords(htable);

            List<Put> putsToUpdate = new ArrayList<>();
            List<Put> putsToInsert = new ArrayList<>();
            List<String> putsToDelete = new ArrayList<>();
            while (resultSet.next()) {
                Boolean markedForDelete = resultSet.getBoolean("deleted");
                String key = resultSet.getString("id");

                if (markedForDelete) {
                    if (existingKeys.contains(key)) {
                        putsToDelete.add(key);
                        if (putsToDelete.size() > syncHBaseImport.batchSize) {
                            syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
                            putsToDelete.clear();
                        }
                    } else {
                        log.warn("Skip row with key: " + key);
                        continue;
                    }
                } else {
                    ResultSetMetaData metaData = resultSet.getMetaData();
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
                    if (existingKeys.contains(key)) {
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

            }

            if (putsToDelete.size() > 0) {
                syncHBaseImport.deleteDataInBatch(htable, putsToDelete);
            }
            if (putsToInsert.size() > 0) {
                htable.put(putsToInsert);
            }
            if (putsToUpdate.size() > 0) {
                htable.put(putsToUpdate);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        log.info("Sync done for table: " + table);
    }

    private List<String> getTablesToSync() throws Exception {
        log.info("Get tables to sync");
        List<String> tables = new ArrayList<String>();
        switch (version) {
            case V2016:
                if(Properties.SYNC_2016_INCLUDE_TABLES.trim().length() < 1 ){
                    tables = getAllTablesFromPostgres(Properties.SYNC_2016_SCHEMA);
                }else{
                    for(String table : Properties.SYNC_2016_INCLUDE_TABLES.split(",")){
                        tables.add(table);
                    }
                }
                if(Properties.SYNC_2016_EXCLUDE_TABLES.trim().length() > 0){
                    for(String table : Properties.SYNC_2016_EXCLUDE_TABLES.split(",")){
                        tables.remove(table);
                    }
                }
                break;
            case V2015:
                throw new NotImplementedException();
            case V2014:
                throw new NotImplementedException();
            default:
                throw new NotImplementedException();
        }
        log.info("Found " + tables.size() + " tables to sync");
        tables.forEach(table->log.info("Table to sync: " + table));
        return tables;
    }

    private List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = PostgresUtil.getConnection();
            statement = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='"+schemaName+"'");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                tables.add(resultSet.getString("table_name"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }

    public static void threadSleep(long period) {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
