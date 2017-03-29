package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Stats {
	public static int batchSize = 1000;
    private static Connection connection = null;
    static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + "hmis-multischema-db.ct16elltavnx.us-west-2.rds.amazonaws.com" + ":" + "5432" + "/" + "hmis",
					"hmisdb1",
					"hmisdb1234");

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
	    List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT count(*) FROM "+schema+"."+tableName+" WHERE project_group_code='"+projGrpCode+"' ");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	System.out.println("Table Name :"+tableName + " count: "+resultSet.getInt(1));
            	return  resultSet.getInt(1);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }
        return 0;
		
	}
	
	public static void main(String args[]) throws Exception {
		int count =0;
		String schema ="v2016";
		String projectGroupCode ="MO0010";
		List<String> allTablesFromPostgres = getAllTablesFromPostgres(schema);
		for(String tableName : allTablesFromPostgres) {
			count = count + getTableCount(tableName, projectGroupCode, schema);
		}
		System.out.println("Count in "+schema+ "schema is:"+count);


	}

}