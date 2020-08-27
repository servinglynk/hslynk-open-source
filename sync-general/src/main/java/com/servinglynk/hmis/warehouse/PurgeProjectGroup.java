package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class PurgeProjectGroup extends Logging {
	 private Logger logger;
	 SyncHBaseProcessor syncHBaseImport;
	 
	 public PurgeProjectGroup(Logger logger) throws Exception {
	        this.logger = logger;
	     //   this.syncHBaseImport = new SyncHBaseProcessor();
	    }
	 /***
	  * purge 
	  * @param projectGroupCode
	 * @throws Exception 
	  */
	public void purge(String projectGroupCode) throws Exception {
		
		List<String> schemas = new ArrayList<>();
		schemas.add("v2014");
		schemas.add("v2015");
		schemas.add("v2016");
		schemas.add("v2020");
		schemas.add("base");
		schemas.add("survey");
		schemas.add("housing_inventory");
		schemas.add("notificationdb");
		
		for(String schema : schemas) {
			disableTriggers(schema);
			List<String> allTablesFromPostgres = getAllTablesFromPostgres(schema);
			for(String tableName : allTablesFromPostgres) {
				purgeTable(tableName, projectGroupCode, schema);
                // syncHBaseImport.dropHBASETable(tableName + "_" + projectGroupCode, logger);
			}
		}
		logger.info("Base schema purged for ..."+projectGroupCode);
	}
	
	  private List<String> getTablesToSync(String schema) throws Exception {
	        log.info("Get tables to sync");
	        List<String> tables = new ArrayList<>();
	        try{
	            tables = SyncPostgresProcessor.getAllTablesFromPostgres(schema);
	            log.info("Found " + tables.size() + " tables to sync");
	            tables.forEach(table -> log.info("Table to sync: " + table));
	        }catch (Exception ex){
	            logger.warn("No tables found: ", ex);
	        }
	        return tables;
	    }
	  
	public static List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
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
	//;
	 private void disableTriggers(String schema) {
	        Connection connection = null;
	        Statement statement =  null;
	        try{
	        	connection = SyncPostgresProcessor.getConnection();
	        	statement = connection.createStatement();
	        	logger.info(" Disabling triggers...");
		        statement.execute("SET session_replication_role = replica");
	        }catch (Exception ex){
	            ex.printStackTrace();
	        }finally {
	        }
		}
	 private void purgeTable(String tableName, String projectGroupCode, String schema) {
		        Connection connection = null;
		        Statement statement =  null;
		        try{
		        	connection = SyncPostgresProcessor.getConnection();
		        	statement = connection.createStatement();
		        	logger.info(" Deleting table: "+tableName +" with in schema ::"+schema +" for projectGroup ::: "+projectGroupCode);
			        statement.execute("Delete FROM "+schema+"."+tableName +" WHERE project_group_code='"+projectGroupCode+"'");
			        logger.info(" Deleted table: "+tableName);
		        }catch (Exception ex){
		            ex.printStackTrace();
		        }finally {
		        }
			}
		
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(PurgeProjectGroup.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		
		PurgeProjectGroup view = new PurgeProjectGroup(logger);
//		TE0008
//		TE0003
		//PP0021
		//IL0009
		//DP0003
		//BA0007
		//SP0022
		//MO0006
	    view.purge("DP0003");

	}

}
