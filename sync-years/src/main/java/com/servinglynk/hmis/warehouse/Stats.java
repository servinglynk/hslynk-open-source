package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Stats {
	public static int batchSize = 1000;
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
	
	public static Long getTableCount(String tableName,String projGrpCode,String schema) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT count(*) FROM "+schema+"."+tableName);
            
           // if(!StringUtils.equals("survey", schema)) {
            	builder.append(" WHERE project_group_code='"+projGrpCode+"'");
            	builder.append(" and  deleted=true");
         //   }
            statement = connection.prepareStatement(builder.toString());
            
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	//System.out.println("Table Name :"+tableName + " count: "+resultSet.getInt(1));
            	return  resultSet.getLong(1);
            }
        }catch (Exception ex){
            //ex.printStackTrace();
            return 0L;
        }
        return 0L;
		
	}
	
	public static void update(String tableName,String projGrpCode,String schema) {
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            StringBuilder builder = new StringBuilder();
            builder.append("update "+schema+"."+tableName);
            
           // if(!StringUtils.equals("survey", schema)) {
            	builder.append(" set deleted=true,date_updated=CURRENT_TIMESTAMP WHERE project_group_code='"+projGrpCode+"'");
         //   }
            statement = connection.prepareStatement(builder.toString());
            
           int executeUpdate = statement.executeUpdate();
           System.out.println(" Table name "+tableName+" update status:"+executeUpdate);
        }catch (Exception ex){
            //ex.printStackTrace();
        }
	}
	public static void main(String args[]) throws Exception {
		Long count =0L;
		  Logger logger = Logger.getLogger(Stats.class.getName());
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
	        SyncPostgresProcessor.populateDB();
	        //	hydrateDBCount(schemaName, count, month, year, dateCreated, dateUpdated);
	        }

}