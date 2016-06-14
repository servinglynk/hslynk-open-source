package com.servinglynk.hmis.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

public class FromPostgres extends Logging{

	public static void main(String args[]) throws Exception {
		while(true)
		{
			System.out.println("Start a new sync");
			new FromPostgres().RunSync();
			System.out.printf("Sleep 1 min before another sync");
			threadSleep(60000);
		}
	}

	public void RunSync() throws Exception {
		//	syncClient(date,Client.class);
		log.info("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		long startNanos = System.nanoTime();
		// Sync Table Start
		BaseProcessor baseProcessor = new BaseProcessor();
		log.info("Get list of bulkupload");
		// list of than 10 uploads
		final List<BulkUpload> uploads = BaseProcessor.getExportIDFromBulkUpload();

		System.out.println("Upload list size: " + uploads.size());
		for (BulkUpload upload : uploads) {
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

			VERSION version = StringUtils.equals(schema, "v2014") ? VERSION.V2014 : VERSION.V2015;
			log.info("set flag in postgres that tables are created for version " + version.name());
			baseProcessor.updateCreateFlag("", "", upload.getProjectGroupCode(), version);


			long startSyncTables = System.nanoTime();
			int availableCores = Runtime.getRuntime().availableProcessors();
			int cores = (availableCores > 5) ? 5 : availableCores - 1;
			ExecutorService executor = Executors.newFixedThreadPool(cores);
			final Map<String, Class<? extends BaseModel>> tables = StringUtils.equals(schema, "v2014") ? BaseProcessor.getAlltablesV2014() : BaseProcessor.getAlltablesV2015();
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
				baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid, schema);
				baseProcessor.updateBulkUpload(upload.getId());
				log.info("Time taken to run the program in seconds: " +
						TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) / 1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadSleep(1000);
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