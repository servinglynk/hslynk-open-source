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

public class PurgeProjectGroup extends Logging {
	 private Logger logger;
	 
	 public PurgeProjectGroup(Logger logger) throws Exception {
	        this.logger = logger;
	    }
	 /***
	  * purge 
	  * @param projectGroupCode
	 * @throws Exception 
	  */
	public void purge(String projectGroupCode,String schema) throws Exception {
		List<String> allTablesFromPostgres = getAllTablesFromPostgres(schema);
		for(String tableName : allTablesFromPostgres) {
				purgeTable(tableName, projectGroupCode, schema);
		}
	}
	
	
	 private void purgeTable(String tableName, String projectGroupCode, String schema) {
		        PreparedStatement statement = null;
		        Connection connection = null;
		        try{
		        	logger.info(" Deleting table: "+tableName +" with in schema ::"+schema +" for projectGroup ::: "+projectGroupCode);
		            connection = getConnection();
		            StringBuilder builder = new StringBuilder();
		            builder.append("Delete FROM "+schema+"."+tableName);
		            
		            if(!StringUtils.equals("survey", schema)) {
		            	builder.append(" WHERE project_group_code='"+projectGroupCode+"'");
		            }
		            statement = connection.prepareStatement(builder.toString());
		            statement.executeLargeUpdate(builder.toString());
		            logger.info(" Deleted table: "+tableName);
		        }catch (Exception ex){
		            //ex.printStackTrace();
		        }
			}
					

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

		
		public List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
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
		
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(PurgeProjectGroup.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		List<String> schemas = new ArrayList<>();
		schemas.add("v2014");
		//schemas.add("v2015");
		schemas.add("v2016");
		schemas.add("base");
		PurgeProjectGroup view = new PurgeProjectGroup(logger);
		for(String schema : schemas) {
			logger.info("Starting purge on ::"+schema);
			view.purge("IL0009",schema);
		}
		
	}

}
