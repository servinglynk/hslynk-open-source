package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	
	public static int getTableCount(String tableName,String projGrpCode,String schema) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT count(*) FROM "+schema+"."+tableName);
            
           // if(!StringUtils.equals("survey", schema)) {
            	builder.append(" WHERE project_group_code='"+projGrpCode+"'");
         //   }
            statement = connection.prepareStatement(builder.toString());
            
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	//System.out.println("Table Name :"+tableName + " count: "+resultSet.getInt(1));
            	return  resultSet.getInt(1);
            }
        }catch (Exception ex){
            //ex.printStackTrace();
            return 0;
        }
        return 0;
		
	}
	
	public static void main(String args[]) throws Exception {
		int count =0;
		  Logger logger = Logger.getLogger(Stats.class.getName());
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
		List<String> schemas = new ArrayList<>();
		schemas.add("v2014");
		schemas.add("v2015");
		schemas.add("v2016");
		schemas.add("v2017");
		schemas.add("base");
		schemas.add("survey");
		schemas.add("housing_inventory");
		schemas.add("notificationdb");
		List<String> projectGroups = new ArrayList<>();
//		projectGroups.add("BD0005");
//		projectGroups.add("HO0002");
//		projectGroups.add("MO0010");
//		projectGroups.add("MC0005");
//		projectGroups.add("SR0012");
//		projectGroups.add("IL0009");
		projectGroups.add("SA0005");
		
		for(String projectGroupCode : projectGroups) {
			for(String schema : schemas) {
				List<String> allTablesFromPostgres = getAllTablesFromPostgres(schema);
				count =0;
				for(String tableName : allTablesFromPostgres) {
					if(!tableName.equals("sync"))
						count = count + getTableCount(tableName, projectGroupCode, schema);
				}
				System.out.println("Count in project group "+ projectGroupCode+" and schema "+schema+ "::"+count);
			}
		}
	}

}