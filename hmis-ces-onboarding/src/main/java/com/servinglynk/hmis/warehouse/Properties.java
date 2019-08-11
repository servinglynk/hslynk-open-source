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
            POSTGRESQL_DB_HOST = prop.getProperty("posgresql.db.host");
            POSTGRESQL_DB_PORT = prop.getProperty("posgresql.db.port");
            POSTGRESQL_DB_DATABASE = prop.getProperty("posgresql.db.database");
            POSTGRESQL_DB_USERNAME = prop.getProperty("posgresql.db.username");
            POSTGRESQL_DB_PASSWORD = prop.getProperty("posgresql.db.password");
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
    }

}