package com.servinglynk.hmis.warehouse;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class FromPostgresStaging {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(FromPostgresStaging.class.getName());
		new Properties().generatePropValues();
		logger.info(Properties.POSTGRESQL_DB_HOST);
		logger.info(Properties.POSTGRESQL_DB_PORT);
		logger.info(Properties.POSTGRESQL_DB_USERNAME);
		logger.info(Properties.POSTGRESQL_DB_PASSWORD);
		logger.info(Properties.HBASE_MASTER);
		logger.info(Properties.HBASE_ZOOKEEPER_QUORUM);
		logger.info(Properties.HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
		while (true) {
			new FromPostgres().RunSync(logger, Status.STAGING, false);
		}
	}
}