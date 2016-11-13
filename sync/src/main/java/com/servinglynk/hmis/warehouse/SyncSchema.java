package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SyncSchema extends Logging {


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

    public SyncSchema(VERSION version, Logger logger, Status status, boolean purgeRecords) throws Exception {
        this.version = version;
        this.logger = logger;
        this.status = status;
        this.purgeRecords = purgeRecords;
        this.syncHBaseImport = new SyncHBaseProcessor();

        switch (version) {
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

    public void sync() throws Exception {
        log.info("Start a new sync for " + version.name() + " uploads");
        syncTablesToHBase();
        log.info("Sync done. Wait " + syncPeriod + " minutes before running next sync");
        threadSleep(syncPeriod * 60 * 1000);
    }

    private void syncTablesToHBase() throws Exception {

        log.info("Get list of bulkupload for schema: " + syncSchema);
        // list of than 10 uploads
        List<BulkUpload> allUploads = SyncPostgresProcessor.getExportIDFromBulkUpload(year);
        final List<BulkUpload> uploads = new ArrayList<>();
        for (BulkUpload el : allUploads) {
            if (el.getStatus() == status) {
                uploads.add(el);
            }
        }
        List<String> tables = getTablesToSync();

        log.info("Upload list size: " + uploads.size());
        for (BulkUpload upload : uploads) {
            FileAppender appender = new FileAppender();
            String appenderName = "sync-" + syncSchema + "-" + status.name() + "-" + upload.getId();
            appender.setName(appenderName);
            appender.setFile("logs/" + appenderName + ".log");
            appender.setImmediateFlush(true);
            appender.setAppend(true);
            appender.setLayout(new PatternLayout());
            appender.activateOptions();

            logger.addAppender(appender);
            logger.info("\n\n\n\n\n\nStart new sync for id: " + upload.getId());

            try {
                logger.info("Create tables in HBASE");
                tables.forEach(table -> syncHBaseImport.createHBASETable(table + "_" + upload.getProjectGroupCode(), logger));
                logger.info("Create tables done");
                SyncPostgresProcessor.updateCreateFlag(upload.getProjectGroupCode(), version);

                int availableCores = Runtime.getRuntime().availableProcessors();
                int cores = (availableCores > 5) ? 5 : availableCores - 1;
                ExecutorService executor = Executors.newFixedThreadPool(cores);

                for (final String tableName : tables) {
                    final String tempName = tableName;
                    logger.info("[" + tempName + "] Processing table : " + tempName);
                    executor.submit(() -> {
                        try {
                            logger.info("[" + tempName + "] Start thread  for: " + tempName);
                            syncTable(tempName, tempName + "_" + upload.getProjectGroupCode());
                            logger.info("[" + tempName + "]End thread for: " + tempName);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                }

                executor.shutdown();
                executor.awaitTermination(10, TimeUnit.HOURS);

                try {
                    logger.info("Set status to LIVE for upload: " + upload.getId() + " with project group code: " + upload.getProjectGroupCode());
                    SyncPostgresProcessor.updateBulkUploadStatusToLive(upload.getId());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                threadSleep(1000);
            } catch (Exception ex) {
                logger.error(ex);
            } finally {
                logger.removeAppender(appender);
            }
        }

        if (purgeRecords) {
            log.info("\n\n\n\n Mark rows as deleted");
            final Set<String> toPurge = new HashSet<>();
            for (BulkUpload el : allUploads) {
                if (el.getStatus() == Status.DELETED || el.getStatus() == Status.ERROR) {
                    toPurge.add(el.getExportId().toString());
                }
            }
            cleanTables(toPurge, tables);
            log.info("Delete mark is done");
        }
    }

    private void syncTable(String postgresTable, String hbaseTable) {
        log.info("Start sync for table: " + postgresTable);
        HTable htable;
        ResultSet resultSet;
        PreparedStatement statement;
        Connection connection;
        try {
            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("SELECT * FROM " + syncSchema + "." + postgresTable);
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

        log.info("Sync done for table: " + postgresTable);
    }

    private List<String> getTablesToSync() throws Exception {
        log.info("Get tables to sync");
        List<String> tables = new ArrayList<String>();

        if (includeTables.trim().length() < 1) {
            tables = SyncPostgresProcessor.getAllTablesFromPostgres(syncSchema);
        } else {
            for (String table : includeTables.split(",")) {
                tables.add(table);
            }
        }
        if (excludeTables.trim().length() > 0) {
            for (String table : excludeTables.split(",")) {
                tables.remove(table);
            }
        }
        log.info("Found " + tables.size() + " tables to sync");
        tables.forEach(table -> log.info("Table to sync: " + table));
        return tables;
    }

    public void cleanTables(Set<String> toClean, List<String> tables) {
        try {
            int availableCores = Runtime.getRuntime().availableProcessors();
            int cores = (availableCores > 5) ? 5 : availableCores - 1;
            ExecutorService executor = Executors.newFixedThreadPool(cores);

            for (final String tableName : tables) {
                final String tempName = syncSchema + "." + tableName;
                log.info("[" + tempName + "] Processing table : " + tempName);
                executor.submit(() -> {
                    try {
                        log.info("[" + tempName + "] Start thread  for: " + tempName);
                        long startNanosTable = System.nanoTime();

                        for (String exportId : toClean) {
                            log.info("[" + tableName + "] Process export_id: " + exportId);
                            SyncPostgresProcessor.markRowsForDeletion(tempName, exportId);
                        }

                        log.info("[" + tempName + "]Time taken to mark for delete rows for '" + tempName + "' in seconds: " +
                                TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanosTable) / 1000);
                        log.info("[" + tempName + "]End thread for: " + tempName);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.HOURS);
        } catch (Exception ex) {
            ex.printStackTrace();
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
}
