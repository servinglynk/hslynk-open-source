package com.servinglynk.hmis.warehouse;

import org.apache.log4j.Logger;

public class FromPostgresLive {
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
            new FromPostgres().RunSync(logger, Status.LIVE, true);
        }
    }
}
