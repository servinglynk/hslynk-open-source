package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

public class CocCodeFix {
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
    
	public static void getAllTablesFromPostgres(String projectGroupCode) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT project_coc_id from v2014.enrollment_coc WHERE coc_code is null and project_group_code='"+projectGroupCode+"' group by project_coc_id");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            UUID projectCocId = (UUID) resultSet.getObject("project_coc_id"); 
            if(projectCocId != null)
            	getAllTablesFromPostgres(projectCocId);
            }
        }catch (Exception ex){
            throw ex;
        }
    }
	
	public static void getAllTablesFromPostgres(UUID projectCocId) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT coccode from v2014.projectcoc WHERE id='"+projectCocId+"'");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            String cocCode =(String)resultSet.getString("coccode");
            updateCocCode(projectCocId,cocCode);
            }
        }catch (Exception ex){
            throw ex;
        }
    }
	
	private static void updateCocCode(UUID projectCocId, String cocCode) {
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try {
	            connection = getConnection();
	            statement = connection.prepareStatement("UPDATE v2014.enrollment_coc SET date_updated=?, coc_code=? where project_coc_id=?");
	            Timestamp currentTimestamp = getCUrrentTimestamp();
	            statement.setTimestamp(1, currentTimestamp);
	            statement.setString(2, cocCode);
	            statement.setObject(3, projectCocId);
	            int status = statement.executeUpdate();
	            System.out.println("Updated projectcocoid::"+projectCocId);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	e.printStackTrace();
	        } finally {
	            if (statement != null) {
	                try {
	                    statement.close();
	                    //connection.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                }
	            }
	        }
	    }
	   
	 private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;

	    }
	public static void main(String args[]) throws Exception {
		int count =0;
		  Logger logger = Logger.getLogger(Stats.class.getName());
	        Properties props = new Properties();
	        props.generatePropValues();
	        props.printProps();
		List<String> schemas = new ArrayList<>();
		schemas.add("v2014");
		schemas.add("v2015");
		schemas.add("v2016");
		schemas.add("v2017");
		schemas.add("base");
		schemas.add("survey");
		schemas.add("housing_inventory");
		List<String> projectGroups = new ArrayList<>();
		projectGroups.add("BD0005");
		projectGroups.add("HO0002");
		projectGroups.add("MO0010");
		projectGroups.add("SR0012");
		projectGroups.add("IL0009");
		
		for(String projectGroupCode : projectGroups) {
				getAllTablesFromPostgres(projectGroupCode);
				System.out.println("Count in project group "+ projectGroupCode);
			}
	}

}