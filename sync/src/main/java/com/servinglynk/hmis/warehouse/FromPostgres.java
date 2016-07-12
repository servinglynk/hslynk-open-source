package com.servinglynk.hmis.warehouse;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class FromPostgres extends Logging {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(FromPostgres.class.getName());
		new Properties().generatePropValues();
		System.out.println(Properties.POSTGRESQL_DB_HOST);
		System.out.println(Properties.POSTGRESQL_DB_PORT);
		System.out.println(Properties.POSTGRESQL_DB_USERNAME);
		System.out.println(Properties.POSTGRESQL_DB_PASSWORD);
		System.out.println(Properties.HBASE_MASTER);
		System.out.println(Properties.HBASE_ZOOKEEPER_QUORUM);
		System.out.println(Properties.HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
		while (true) {
			new FromPostgres().RunSync(logger);
		}
	}

	public void RunSync(Logger logger) throws Exception {
		//	syncClient(date,Client.class);
		log.info("Start a new sync");
		log.info("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
		long startNanos = System.nanoTime();
		// Sync Table Start
		BaseProcessor baseProcessor = new BaseProcessor();
		log.info("Get list of bulkupload");
		// list of than 10 uploads
		List<BulkUpload> allUploads = BaseProcessor.getExportIDFromBulkUpload();
		final List<BulkUpload> uploads = new ArrayList<>();
		for (BulkUpload el : allUploads) {
			if (el.getStatus() == Status.STAGING || el.getStatus() == Status.LIVE) {
				uploads.add(el);
			}
		}

		log.info("Upload list size: " + uploads.size());
		for (BulkUpload upload : uploads) {
			FileAppender appender = new FileAppender();
			appender.setName("sync-" + upload.getId());
			appender.setFile("logs/sync-" + upload.getId() + ".log");
			appender.setImmediateFlush(true);
			appender.setAppend(true);
			appender.setLayout(new PatternLayout());
			appender.activateOptions();

			logger.addAppender(appender);
			logger.info("\n\n\n\n\n\nStart new sync for id: " + upload.getId());


			try {
				String schema = baseProcessor.getSchemaFromYear(upload);
				logger.info("Get map of hmisTypes");
				UUID syncUid = baseProcessor.insertSyncStartTime(schema);
				final Map<String, String> hmisTypes = BaseProcessor.loadHmisTypeMap(schema);
				java.util.Map<String, Integer> tableSyncList = new HashMap<>();

				logger.info("Create tables in HBASE");
				long startCreateTables = System.nanoTime();
				new CreateTable().createTables(upload, logger);
				logger.info("Time taken to complete create table in seconds: " +
						TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startCreateTables) / 1000);

				VERSION version = StringUtils.equals(schema, "v2014") ? VERSION.V2014 : VERSION.V2015;
				logger.info("set flag in postgres that tables are created for version " + version.name());
				baseProcessor.updateCreateFlag("", "", upload.getProjectGroupCode(), version);


				long startSyncTables = System.nanoTime();
				int availableCores = Runtime.getRuntime().availableProcessors();
				int cores = (availableCores > 5) ? 5 : availableCores - 1;
				ExecutorService executor = Executors.newFixedThreadPool(cores);
				final Map<String, Class<? extends BaseModel>> tables = StringUtils.equals(schema, "v2014") ? BaseProcessor.getAlltablesV2014() : BaseProcessor.getAlltablesV2015();
				int count = 0;
				for (final String tableName : tables.keySet()) {
					final String tempName = tableName;
					logger.info("[" + tempName + "] Processing table number: " + count);
					count++;
					executor.submit(() -> {
						try {
							logger.info("[" + tableName + "] Start thread  for: " + tableName);
							Class<? extends BaseModel> temp = tables.get(tempName);
							long startNanosTable = System.nanoTime();
							BaseProcessor aff = new BaseProcessor<>();
							aff.syncToHBASE(temp, tempName, null, upload, hmisTypes, logger);
							logger.info("[" + tableName + "]Time taken to complete Sync for '" + tempName + "' in seconds: " +
									TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanosTable) / 1000);
							logger.info("[" + tableName + "]End thread for: " + tableName);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					});
				}

				executor.shutdown();
				executor.awaitTermination(10, TimeUnit.HOURS);
				logger.info("Time taken to complete sync on all tables in seconds: " +
						TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startSyncTables) / 1000);

				try {
					baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid, schema);
					baseProcessor.updateBulkUpload(upload.getId());
					logger.info("Time taken to run the program in seconds: " +
							TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) / 1000);
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

		log.info("\n\n\n\n Mark rows as deleted");
		final Set<String> toPurge = new HashSet<>();
		for (BulkUpload el : allUploads) {
			if (el.getStatus() == Status.DELETED || el.getStatus() == Status.ERROR) {
				toPurge.add(el.getExportId().toString());
			}
		}
		cleanTables(toPurge);
		log.info("Delete mark is done");

		//log.info("Sleep 1 min before next sync");
		//threadSleep(60000);
	}

	public void cleanTables(Set<String> toClean) {
		try {
			int availableCores = Runtime.getRuntime().availableProcessors();
			int cores = (availableCores > 5) ? 5 : availableCores - 1;
			ExecutorService executor = Executors.newFixedThreadPool(cores);
			final Set<String> tables = new HashSet<>();
			for (String tblName : BaseProcessor.getAlltablesV2014().keySet()) {
				tables.add("v2014." + tblName);
			}
			for (String tblName : BaseProcessor.getAlltablesV2015().keySet()) {
				tables.add("v2015." + tblName);
			}

			int count = 0;
			for (final String tableName : tables) {
				final String tempName = tableName;
				log.info("[" + tempName + "] Processing table number: " + count);
				count++;
				executor.submit(() -> {
					try {
						log.info("[" + tableName + "] Start thread  for: " + tableName);
						long startNanosTable = System.nanoTime();

						for (String exportId : toClean) {
							log.info("[" + tableName + "] Process export_id: " + exportId);
							BaseProcessor.markRowsForDeletion(tempName, exportId);
						}

						log.info("[" + tableName + "]Time taken to mark for delete rows for '" + tempName + "' in seconds: " +
								TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanosTable) / 1000);
						log.info("[" + tableName + "]End thread for: " + tableName);
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