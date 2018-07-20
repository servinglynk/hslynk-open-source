package com.servinglynk.hmis.warehouse;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CreateCESTables  extends Logging {
	private String includeTables;
    private String excludeTables;
    final static Logger logger = Logger.getLogger(CreateCESTables.class);
	
	public CreateCESTables() {
		 includeTables = Properties.INCLUDE_TABLES;
		 excludeTables = Properties.EXCLUDE_TABLES;
	}
	
	public static void main(String args[]) throws Exception {
		 Properties props = new Properties();
		 props.generatePropValues();
		CreateCESTables cesTables = new CreateCESTables();
		String projectGroups = Properties.PROJECT_GROUPS;
		String[] split = projectGroups.split(",");
		for(String projectGroup : split) {
//			cesTables.createTable("CESTables.sql",projectGroup);
//			cesTables.createTable("HiveSQLCreateTable.sql",projectGroup);
//			cesTables.createTable("HiveSQLCreateTable_v2015.sql",projectGroup);
			cesTables.createHiveTables("v2017", projectGroup);
		}
		
	}
	
	 public void createHiveTables(String schema,String projectGroupCode) throws Exception {
		 List<String> tables = getTablesToSync(schema);
		 for(String tableName : tables) {
			 String sql = createHiveViews(schema, tableName, projectGroupCode);
			 System.out.println(sql+";");
	//		 dropHiveTable("drop table "+projectGroupCode+"."+tableName);
	//		 createHiveTable(sql);
		 }
	}

	public List<String> getTablesToSync(String schema) throws Exception {
	        logger.info("Get tables to sync");
	        List<String> tables = new ArrayList<String>();

	        try {
	            if (StringUtils.isEmpty(includeTables)) {
	                try {
	                    tables = SyncPostgresProcessor.getAllTablesFromPostgres(schema);
	                }catch (Exception ex){
	                    logger.warn("No tables found in postgres database:  ", ex);
	                    throw ex;
	                }
	            } else {
	                try {
	                    for (String table : includeTables.split(",")) {
	                        tables.add(table);
	                    }
	                } catch (Exception ex){
	                    logger.warn("Unable to include tables specified in property file", ex);
	                    throw ex;
	                }

	            }
	        }catch (Exception ex){
	            logger.warn("Unable to get tables", ex);
	        }

	        try {
	            if (StringUtils.isNotBlank(excludeTables)) {
	                for (String table : excludeTables.split(",")) {
	                    tables.remove(table);
	                }
	            }
	        }catch (Exception ex){
	            logger.warn("Unable to exclude tables specified in property file", ex);
	        }

	        log.info("Found " + tables.size() + " tables to sync");
	        tables.forEach(table -> log.info("Table to sync: " + table));
	        return tables;
	    }
	
	 public String createTable(String fileName,String projectGroupCode) {
			StringBuilder result = new StringBuilder("");
			//Get file from resources folder
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());

			try (Scanner scanner = new Scanner(file)) {

				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					String sql = line.replaceAll("ZPK0005",projectGroupCode);
					sql = sql.replaceAll(";","");
					
					createHiveTable(sql);
				}

				scanner.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return result.toString();

		  }
	 
	 
	 public static String createHiveViews(String schema,String tableName,String projectGroupCode) {
		  ResultSet resultSet;
	      PreparedStatement statement;
	      Connection connection;
	      StringBuilder firstPart = new StringBuilder("CREATE EXTERNAL TABLE IF NOT EXISTS "+projectGroupCode.toLowerCase()+"."+tableName+" ( ");
	      StringBuilder middlePart = new StringBuilder(" )  STORED BY \"org.apache.hadoop.hive.hbase.HBaseStorageHandler\"  WITH SERDEPROPERTIES   (\"hbase.columns.mapping\" = \"");
	      StringBuilder lastPart = new StringBuilder(") TBLPROPERTIES (\"hbase.table.name\" = \""+tableName+"_"+projectGroupCode+"\") ");
	      try {
	    	  connection = SyncPostgresProcessor.getConnection();
	    	  statement = connection.prepareStatement("select * from "+schema+"."+tableName +" limit 1");
		      resultSet = statement.executeQuery();
			  ResultSetMetaData metaData = resultSet.getMetaData();
	          for (int i = 1; i < metaData.getColumnCount(); i++) {
	              String column = metaData.getColumnName(i);
	              String columnTypeName = metaData.getColumnTypeName(i);
	              if(columnTypeName.contains("bool")) {
	            	  firstPart.append(column +" boolean ,");
	            	  addMiddlePart(middlePart, column);
	              }else  if(columnTypeName.contains("date") || columnTypeName.contains("time")) {
	            	  firstPart.append(column +" timestamp ,");
	            	  addMiddlePart(middlePart, column);
	              }else {
	            	  firstPart.append(column +" string ,");
	            	  addMiddlePart(middlePart, column);
	              }
	              if (StringUtils.isNotEmpty(column)) {
	            	  //If a table has a column called client_id then make sure you add dedup_client_id to it too.
	                  if(StringUtils.equals("client_id", column)) {
	                	  firstPart.append("dedup_client_id string ,");
		            	  addMiddlePart(middlePart, "dedup_client_id");
	                  }
	                  // Add a new column for description for enums
	                  if(columnTypeName.contains(schema)) {
	                	  firstPart.append(column+"_desc string ,");
		            	  addMiddlePart(middlePart, column+"_desc ");
	                  }
	             }
	          }
	          // add a column for the year field.
              firstPart.append("year string ");
        	  middlePart.append("CF:year\"");
	          
	      } catch (Exception e) {
	    	  // Need to take the print stack trace out
	    	  e.printStackTrace();
	      }
	      return firstPart.toString()+middlePart.toString()+lastPart.toString();
	 }
	 
	 public static void addMiddlePart(StringBuilder builder, String column) {
		 if(StringUtils.equalsIgnoreCase("id", column)) {
			 builder.append("");
			 builder.append(":key,");
		 }else {
			 builder.append("CF:"+column+", ");
		 }
		 
	 }
	 
	 public static void dropHiveTable(String sql) {
			Connection connection;
			try {
				connection = HiveConnection.getConnection();
				Statement stmt = connection.createStatement();
				// execute statement
				System.out.println(" Drop table::"+ sql);
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		}
	public static void createHiveTable(String sql) {
		Connection connection;
		try {
			connection = HiveConnection.getConnection();
			Statement stmt = connection.createStatement();
			// execute statement
			System.out.println(" Create Query::"+ sql);
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
}
