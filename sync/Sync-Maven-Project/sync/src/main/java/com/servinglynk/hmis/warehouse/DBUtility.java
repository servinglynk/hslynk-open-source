package com.servinglynk.hmis.warehouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

	/**
	 * Use this program to search the entire database for a given column name.
	 * The expected purpose of this program is to help find foreign keys that are not identified
	 * in the schema.
	 * Currently configured to search a Microsoft Access database.
	 */
	public class DBUtility {

	  // put the desired database field name here.
	  // the program will search all tables in the database for this name.
	  String colNameToSearchFor = "part_no";
	  
	  String catalog = "hmis";
	  String schema = "v2014";
	  List listOfTables = new ArrayList();

	  public static void main(String[] args)
	  {
	    new DBUtility();
	  }

	  public DBUtility()
	  {
	    try
	    {
	      // connect with the jdbc odbc bridge driver
	      // the jdbc odbc connection string
	      Connection con = getConnection();

	      // get the database metadata
	      DatabaseMetaData dmd = con.getMetaData();

	      // get a list of all tables
	      getListOfAllTables(listOfTables, dmd);

	      // see if you can find the column name in any tables
	      searchForColumnNameInTables(dmd);
	    }
	    catch (Exception e)
	    {
	      System.err.println("exception: " + e.getMessage());
	    }
	  }

	  private void searchForColumnNameInTables(DatabaseMetaData dmd) 
	  throws SQLException {
	    Iterator iter = listOfTables.iterator();
	    while (iter.hasNext()) {
	    	 String script = "";
	 	    String hbaseScript = "(\"hbase.columns.mapping\" = \":key,";
	 	    String finalQuery ="";
	      String tableName = (String) iter.next();
	      finalQuery ="CREATE EXTERNAL TABLE " +tableName+"(key string,";
	      java.sql.ResultSet rs = dmd.getColumns(catalog, schema, tableName, "%");
	      while (rs.next()) {
	        String colName = rs.getString(4);
	        String dataType = rs.getString(6);
	        System.out.println("Column :::" + colName.trim().toLowerCase()+" for table :"+tableName +" with datatype ::"+dataType );
	        if("timestamp".equals(dataType)) {
	        	script= script + colName.trim().toLowerCase() +" timestamp ,";
	        }else{
	        	script= script + colName.trim().toLowerCase() +" string ,";	
	        }
	        hbaseScript= hbaseScript +"CF:"+ colName.trim().toLowerCase()+","; 
	        if (colName.trim().toLowerCase().equals(colNameToSearchFor)){
	          System.out.println("found '" + colNameToSearchFor + "' in " + tableName );
	        }
	      }
	      script = script.substring(0, script.length() - 1) + ")";
	      finalQuery = finalQuery +script;
	      finalQuery= finalQuery +" STORED BY \'org.apache.hadoop.hive.hbase.HBaseStorageHandler\' WITH SERDEPROPERTIES ";
	      hbaseScript = hbaseScript.substring(0, hbaseScript.length() - 1) + "\")";
	      finalQuery = finalQuery + hbaseScript ;
	      finalQuery = finalQuery + " TBLPROPERTIES (\"hbase.table.name\" = \""+capitalizeFirstLetter(tableName)+"\");";
	      System.out.println("Final Query::"+finalQuery);
	      writeToFile(finalQuery);
	    }
	  }

	  private void getListOfAllTables(List listOfTables, DatabaseMetaData dmd) 
	  throws SQLException {
	    String[] tableTypes = {
	        "TABLE",
	        "VIEW",
	        "ALIAS",
	        "SYNONYM",
	        "GLOBAL TEMPORARY",
	        "LOCAL TEMPORARY",
	        "SYSTEM TABLE"};
	    ResultSet rs = dmd.getTables(catalog, schema, "%", tableTypes);

	    while (rs.next()) {
	      String tableName = rs.getString(3);
	      listOfTables.add(tableName);
	    }
	    rs.close();
	  }

	    public static Connection getConnection() throws SQLException {
    		Connection connection = DriverManager.getConnection(
    				"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
    				"hmisdb1234");
    		return connection;
    	}
	    public static void writeToFile(String content) {
	    	File file = new File("C:\\HMIS\\hmis-lynk-open-source\\sync\\src\\com\\seringlynk\\hmis\\warehouse\\HiveSQLCreateTable.sql");

	        FileWriter fileWriter;
	        try {
	            fileWriter = new FileWriter(file,true);
	            BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);
	        bufferFileWriter.append(content);
	        bufferFileWriter.newLine();
	        bufferFileWriter.close();
	        } catch (IOException ex) {
	        }

			System.out.println("Done");

	    }
	    
	    public static String capitalizeFirstLetter(String original) {
	        if (original == null || original.length() == 0) {
	            return original;
	        }
	        return original.substring(0, 1).toUpperCase() + original.substring(1);
	    }
}
