package com.servinglynk.hmis.warehouse;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Properties {

    public static String HBASE_MASTER;
    public static String HBASE_ZOOKEEPER_QUORUM;
    public static String HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT="2181";
    public static String IMPALA_USERNAME;
    public static String IMPALA_PASSWORD;
    public static String IMPALA_DRIVER_URL;


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
