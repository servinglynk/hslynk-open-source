package com.servinglynk.hmis.warehouse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Properties {

    public static String POSTGRESQL_DB_HOST;
    public static String POSTGRESQL_DB_PORT;
    public static String POSTGRESQL_DB_DATABASE;
    public static String POSTGRESQL_DB_USERNAME;
    public static String POSTGRESQL_DB_PASSWORD;
    public static String HBASE_MASTER;
    public static String HBASE_ZOOKEEPER_QUORUM;
    public static String HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT="2181";
    
    public static String SYNC_2017_SCHEMA;
    public static String SYNC_2017_INCLUDE_TABLES;
    public static String SYNC_2017_EXCLUDE_TABLES;
    public static int SYNC_2017_PERIOD;
    
    public static String SYNC_2016_SCHEMA;
    public static String SYNC_2016_INCLUDE_TABLES;
    public static String SYNC_2016_EXCLUDE_TABLES;
    public static int SYNC_2016_PERIOD;

    public static String SYNC_2015_SCHEMA;
    public static String SYNC_2015_INCLUDE_TABLES;
    public static String SYNC_2015_EXCLUDE_TABLES;
    public static int SYNC_2015_PERIOD;

    public static String SYNC_2014_SCHEMA;
    public static String SYNC_2014_INCLUDE_TABLES;
    public static String SYNC_2014_EXCLUDE_TABLES;
    public static int SYNC_2014_PERIOD;

    public void generatePropValues() throws IOException {

        InputStream in = null;
        try {
            java.util.Properties prop = new java.util.Properties();
            String propFileName = "application.conf";

            in = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (in != null) {
                prop.load(in);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            POSTGRESQL_DB_HOST = prop.getProperty("posgresql.db.host");
            POSTGRESQL_DB_PORT = prop.getProperty("posgresql.db.port");
            POSTGRESQL_DB_DATABASE = prop.getProperty("posgresql.db.database");
            POSTGRESQL_DB_USERNAME = prop.getProperty("posgresql.db.username");
            POSTGRESQL_DB_PASSWORD = prop.getProperty("posgresql.db.password");
            HBASE_MASTER = prop.getProperty("hbase.master");
            HBASE_ZOOKEEPER_QUORUM = prop.getProperty("hbase.zookeeper.quorum");
            HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT = prop.getProperty("hbase.zookeeper.property.clientPort", "2181");
            
            SYNC_2017_SCHEMA = prop.getProperty("sync2017.schema");
            SYNC_2017_INCLUDE_TABLES = prop.getProperty("sync2017.includetables");
            SYNC_2017_EXCLUDE_TABLES = prop.getProperty("sync2017.excludetables");
            SYNC_2017_PERIOD = Integer.valueOf(prop.getProperty("sync2017.period"));
            
            SYNC_2016_SCHEMA = prop.getProperty("sync2016.schema");
            SYNC_2016_INCLUDE_TABLES = prop.getProperty("sync2016.includetables");
            SYNC_2016_EXCLUDE_TABLES = prop.getProperty("sync2016.excludetables");
            SYNC_2016_PERIOD = Integer.valueOf(prop.getProperty("sync2016.period"));

            SYNC_2015_SCHEMA = prop.getProperty("sync2015.schema");
            SYNC_2015_INCLUDE_TABLES = prop.getProperty("sync2015.includetables");
            SYNC_2015_EXCLUDE_TABLES = prop.getProperty("sync2015.excludetables");
            SYNC_2015_PERIOD = Integer.valueOf(prop.getProperty("sync2015.period"));

            SYNC_2014_SCHEMA = prop.getProperty("sync2014.schema");
            SYNC_2014_INCLUDE_TABLES = prop.getProperty("sync2014.includetables");
            SYNC_2014_EXCLUDE_TABLES = prop.getProperty("sync2014.excludetables");
            SYNC_2014_PERIOD = Integer.valueOf(prop.getProperty("sync2014.period"));


        } catch (Exception e) {
            System.out.println("Exception: " + e);
            throw e;
        } finally {
            if(in != null){
                in.close();
            }
        }

    }

    public void printProps() {
        System.out.println(POSTGRESQL_DB_HOST);
        System.out.println(POSTGRESQL_DB_PORT);
        System.out.println(POSTGRESQL_DB_DATABASE);
        System.out.println(POSTGRESQL_DB_USERNAME);
        System.out.println(POSTGRESQL_DB_PASSWORD);
        System.out.println(HBASE_MASTER);
        System.out.println(HBASE_ZOOKEEPER_QUORUM);
        System.out.println(HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
        System.out.println(SYNC_2016_SCHEMA);
        System.out.println(SYNC_2016_INCLUDE_TABLES);
        System.out.println(SYNC_2016_EXCLUDE_TABLES);
    }

}
