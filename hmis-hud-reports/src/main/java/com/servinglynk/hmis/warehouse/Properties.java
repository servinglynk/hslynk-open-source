package com.servinglynk.hmis.warehouse;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

public class Properties {

    public static String HBASE_MASTER;
    public static String HBASE_ZOOKEEPER_QUORUM;
    public static String HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT="2181";
    public static String IMPALA_USERNAME;
    public static String IMPALA_PASSWORD;
    public static String IMPALA_DRIVER_URL;
    public static String POSTGRESQL_DB_HOST;
    public static String POSTGRESQL_DB_PORT;
    public static String POSTGRESQL_DB_DATABASE;
    public static String POSTGRESQL_DB_USERNAME;
    public static String POSTGRESQL_DB_PASSWORD;
    public static String APR_FILE_LOCATION;
    public static String LSA_FILE_LOCATION;
    public static String APR_CONFIG_LOCATION;
    public static String AWS_SECRET_KEY;
    public static String AWS_PUBLIC_KEY;

    public void generatePropValues() throws Exception {

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
            HBASE_MASTER = prop.getProperty("hbase.master");
            HBASE_ZOOKEEPER_QUORUM = prop.getProperty("hbase.zookeeper.quorum");
            HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT = prop.getProperty("hbase.zookeeper.property.clientPort", "2181");
            IMPALA_USERNAME = prop.getProperty("connection.username");
            IMPALA_PASSWORD = prop.getProperty("connection.password");
            IMPALA_DRIVER_URL= prop.getProperty("connection.url");
            
            POSTGRESQL_DB_HOST = prop.getProperty("posgresql.db.host");
            POSTGRESQL_DB_PORT = prop.getProperty("posgresql.db.port");
            POSTGRESQL_DB_DATABASE = prop.getProperty("posgresql.db.database");
            POSTGRESQL_DB_USERNAME = prop.getProperty("posgresql.db.username");
            POSTGRESQL_DB_PASSWORD = prop.getProperty("posgresql.db.password");
            
            AWS_PUBLIC_KEY = prop.getProperty("aws_access_key_id");
            AWS_SECRET_KEY = prop.getProperty("aws_secret_access_key");
            
            String aprLocation = prop.getProperty("app.apr.location");
            if(StringUtils.isBlank(aprLocation)) {
            	aprLocation =  "/home/ubuntu/hmis-hud-reports-2.0/";
            }
            APR_FILE_LOCATION = aprLocation;
            String lsaLocation = prop.getProperty("app.lsa.location");
            if(StringUtils.isBlank(lsaLocation)) {
            	lsaLocation =  "/home/ubuntu/hmis-hud-reports-2.0/";
            }
            LSA_FILE_LOCATION = lsaLocation;
            
            String aprConfigLocation = prop.getProperty("app.apr.config.location");
            if(StringUtils.isBlank(aprConfigLocation)) {
            	aprConfigLocation =  "/home/ubuntu/hmis-hud-reports-2.0/conf/";
            }
            APR_CONFIG_LOCATION = aprConfigLocation;
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
        System.out.println(IMPALA_DRIVER_URL);
        //System.out.println(HBASE_MASTER);
        System.out.println(HBASE_ZOOKEEPER_QUORUM);
        System.out.println(HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT);
    }

}
