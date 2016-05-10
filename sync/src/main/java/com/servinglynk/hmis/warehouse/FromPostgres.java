package com.servinglynk.hmis.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FromPostgres extends Logging{

	public static void main(String args[]) throws Exception {
		new FromPostgres().RunSync();
	}

	public void RunSync() throws Exception {
		//	syncClient(date,Client.class);
		log.info("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		long startNanos = System.nanoTime();
		// Sync Table Start
		BaseProcessor baseProcessor = new BaseProcessor();
		log.info("Get list of bulkupload");
		final BulkUpload upload = BaseProcessor.getExportIDFromBulkUpload();
		String schema = baseProcessor.getSchemaFromYear(upload);
		log.info("Get map of hmisTypes");
		UUID syncUid = baseProcessor.insertSyncStartTime(schema);
		final Map<String, String> hmisTypes = BaseProcessor.loadHmisTypeMap(schema);
		java.util.Map<String, Integer> tableSyncList = new HashMap<>();


		log.info("Create tables in HBASE");
		long startCreateTables = System.nanoTime();
		CreateTable.createTables(upload);
		log.info("Time taken to complete create table in seconds: " +
				TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startCreateTables) / 1000);

		long startSyncTables = System.nanoTime();
		int availableCores = Runtime.getRuntime().availableProcessors();
		int cores = (availableCores > 5) ? 5 : availableCores -1;
		ExecutorService executor = Executors.newFixedThreadPool(cores);
		final Map<String, Class<? extends BaseModel>> tables = upload.getYear() == 2015 ? BaseProcessor.getAlltablesV2015() : BaseProcessor.getAlltablesV2014();
		int count = 0;
		for (final String tableName : tables.keySet()) {
			final String tempName = tableName;
			log.info("[" + tempName + "] Processing table number: " + count);
			count++;
			executor.submit(new Runnable() {
				@Override
				public void run() {
					try {
						log.info("[" + tableName + "] Start thread  for: " + tableName);
						Class<? extends BaseModel> temp = tables.get(tempName);
						long startNanosTable = System.nanoTime();
						BaseProcessor aff = new BaseProcessor<>();
						aff.syncToHBASE(temp, tempName, null, upload, hmisTypes);
						log.info("[" + tableName + "]Time taken to complete Sync for '" + tempName + "' in seconds: " +
								TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanosTable) / 1000);
						log.info("[" + tableName + "]End thread for: " + tableName);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.HOURS);
		log.info("Time taken to complete sync on all tables in seconds: " +
				TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startSyncTables) / 1000);

		try {
			baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid,schema);
			baseProcessor.updateBulkUpload( upload.getId());
			log.info("Time taken to run the program in seconds: " +
					TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) / 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void threadSleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}