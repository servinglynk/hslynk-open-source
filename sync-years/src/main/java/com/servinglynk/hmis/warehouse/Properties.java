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
    public static String COMMON_TABLES;
    public static String PROJECT_GRP_WITH_CLIENT_IDS;
    public static String SLIM_TABLES;
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

    public void generatePropValues(String propFileName) throws IOException {

        InputStream in = null;
        try {
            java.util.Properties prop = new java.util.Properties();

            in = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (in != null) {
                prop.load(in);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            POSTGRESQL_DB_HOST = getProperty("posgresql.db.host",prop);
            POSTGRESQL_DB_PORT = getProperty("posgresql.db.port",prop);
            POSTGRESQL_DB_DATABASE = getProperty("posgresql.db.database",prop);
            POSTGRESQL_DB_USERNAME = getProperty("posgresql.db.username",prop);
            POSTGRESQL_DB_PASSWORD = getProperty("posgresql.db.password",prop);
            HBASE_MASTER = getProperty("hbase.master",prop);
            HBASE_ZOOKEEPER_QUORUM = getProperty("hbase.zookeeper.quorum",prop);
            HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT = getProperty("hbase.zookeeper.property.clientPort",prop);
            PROJECT_GRP_WITH_CLIENT_IDS =  getProperty("sync.proj-grp.withIdentifier",prop);
            COMMON_TABLES = getProperty("common.tables",prop);
            SLIM_TABLES =  getProperty("slim.tables",prop);
            SYNC_2017_SCHEMA = getProperty("sync2017.schema",prop);
            SYNC_2017_INCLUDE_TABLES = getProperty("sync2017.includetables",prop);
            SYNC_2017_EXCLUDE_TABLES = getProperty("sync2017.excludetables",prop);
            SYNC_2017_PERIOD = Integer.valueOf(getProperty("sync2017.period",prop));
            
            SYNC_2016_SCHEMA = getProperty("sync2016.schema",prop);
            SYNC_2016_INCLUDE_TABLES = getProperty("sync2016.includetables",prop);
            SYNC_2016_EXCLUDE_TABLES = getProperty("sync2016.excludetables",prop);
            SYNC_2016_PERIOD = Integer.valueOf(getProperty("sync2016.period",prop));

            SYNC_2015_SCHEMA = getProperty("sync2015.schema",prop);
            SYNC_2015_INCLUDE_TABLES = getProperty("sync2015.includetables",prop);
            SYNC_2015_EXCLUDE_TABLES = getProperty("sync2015.excludetables",prop);
            SYNC_2015_PERIOD = Integer.valueOf(getProperty("sync2015.period",prop));

            SYNC_2014_SCHEMA = getProperty("sync2014.schema",prop);
            SYNC_2014_INCLUDE_TABLES = getProperty("sync2014.includetables",prop);
            SYNC_2014_EXCLUDE_TABLES = getProperty("sync2014.excludetables",prop);
            SYNC_2014_PERIOD = Integer.valueOf(getProperty("sync2014.period",prop));


        } catch (Exception e) {
            System.out.println("Exception: " + e);
            throw e;
        } finally {
            if(in != null){
                in.close();
            }
        }

    }
    
    private String getProperty(String property,java.util.Properties prop) {
    	try {
    		return prop.getProperty(property);
    	}catch(NullPointerException e) {
    		return  "";
    	}
    }

    public void printProps() {
        System.out.println(POSTGRESQL_DB_HOST);
        System.out.println(POSTGRESQL_DB_PORT);
        System.out.println(POSTGRESQL_DB_DATABASE);
        System.out.println(POSTGRESQL_DB_USERNAME);
        System.out.println(POSTGRESQL_DB_PASSWORD);
        System.out.println(HBASE_MASTER);
        System.out.println(COMMON_TABLES);
        System.out.println(HBASE_ZOOKEEPER_QUORUM);
        System.out.println(HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
        System.out.println(SYNC_2016_SCHEMA);
        System.out.println(SYNC_2016_INCLUDE_TABLES);
        System.out.println(SYNC_2016_EXCLUDE_TABLES);
    }

}
