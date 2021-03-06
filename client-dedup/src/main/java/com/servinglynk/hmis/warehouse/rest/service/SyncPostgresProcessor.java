package com.servinglynk.hmis.warehouse.rest.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

public class SyncPostgresProcessor extends Logging{

    public static int batchSize = 1000;
    static final Logger logger = Logger.getLogger(SyncPostgresProcessor.class);
    private static Connection connection = null;
    static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + Properties.POSTGRESQL_DB_HOST + ":" + Properties.POSTGRESQL_DB_PORT + "/" + Properties.POSTGRESQL_DB_DATABASE,
                    Properties.POSTGRESQL_DB_USERNAME,
                    Properties.POSTGRESQL_DB_PASSWORD);
        }
        if (connection.isClosed()) {
            throw new SQLException("connection could not initiated");
        }
        return connection;
    }
    
    public static List<String> getAllProjectGroupCodes(Logger logger) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<String> projectGroupCodes = new ArrayList<String>();
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT distinct(project_group_code) FROM base.hmis_project_group where project_group_code not in ('TE0008','MO0006','TE0011','JP0005','FI0009','BA0007','PG0001','TE0003','CP0004')");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	projectGroupCodes.add(resultSet.getString(1));
            }

            return projectGroupCodes;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        return null;
    }
    public static Map<UUID,String> getAllProjectGroupId(Logger logger) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Map<UUID,String> projectGroupCodes = new HashMap<UUID,String>();
        
        try {
            connection = getConnection();
              statement = connection.prepareStatement("SELECT project_group_code,id FROM base.hmis_project_group where project_group_code not in ('TE0008','MO0006','TE0011','JP0005','FI0009','BA0007','PG0001','TE0003','CP0004')");
          //  statement = connection.prepareStatement("SELECT project_group_code,id FROM base.hmis_project_group where project_group_code  in ('MO0010')");

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	UUID id = (UUID) resultSet.getObject(2);
            	projectGroupCodes.put(id, resultSet.getString(1));
            }
            return projectGroupCodes;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            logger.error(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                    //connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                }
            }
        }
        return null;
    }

    private static Timestamp getCUrrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return currentTimestamp;

    }
}
