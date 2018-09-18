package com.servinglynk.hmis.warehouse;


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
            statement = connection.prepareStatement("SELECT distinct(project_group_code) FROM base.hmis_project_group where active=true");
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
              statement = connection.prepareStatement("SELECT project_group_code,id FROM base.hmis_project_group where active=true");
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
    public static List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='"+schemaName+"'");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                tables.add(resultSet.getString("table_name"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }
    
    public static String getPrimaryKeyColumn(String tableName, String schema) {
    	 String primaryKey = "";
         ResultSet resultSet = null;
         PreparedStatement statement = null;
         Connection connection = null;
         try{
             connection = getConnection();
             statement = connection.prepareStatement("select column_name from information_schema.columns where table_schema=? and table_name=? and ordinal_position=1");
             statement.setString(1, schema);
             statement.setString(2, tableName);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
            	 primaryKey = resultSet.getString("column_name");
             }
         }catch (Exception ex){
             logger.error(" Error getting metadata for table "+tableName + "schema :"+schema);
         }
         return primaryKey;
	}
    public static Map<String,String> getColumnsForTable(String tableName, String schema) {
    	Map<String,String> columns = new HashMap<>();
         ResultSet resultSet = null;
         PreparedStatement statement = null;
         Connection connection = null;
         try{
             connection = getConnection();
             statement = connection.prepareStatement("select column_name,data_type from information_schema.columns where table_schema=? and table_name=?");
             statement.setString(1, schema);
             statement.setString(2, tableName);
             resultSet = statement.executeQuery();
             while (resultSet.next()){
            	 columns.put(resultSet.getString("column_name"),resultSet.getString("data_type"));
             }
         }catch (Exception ex){
             logger.error(" Error getting metadata for table "+tableName + "schema :"+schema);
         }
         return columns;
	}
    public static void hydrateSyncTable(String schemaName,String tableName,String status,String message,String projectGroupCode){
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("insert into "+schemaName+".sync (sync_table,status,description,project_group_code,date_created,date_updated)  values (?,?,?,?,?,?)");
            statement.setString(1, tableName);
            statement.setString(2,status);
            statement.setString(3,message);
            statement.setString(4,projectGroupCode);
            statement.setTimestamp(5, getCUrrentTimestamp());
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.executeUpdate();
        }catch (SQLException ex) {
            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);

        } finally {

            try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException ex) {
            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
            }
        }
    }


    private static Timestamp getCUrrentTimestamp() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return currentTimestamp;

    }
}
