package com.servinglynk.hive.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveConnection {
	  private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	    public static void main(String[] args) throws SQLException {

	        try {
	            // Register driver and create driver instance
	            Class.forName(driverName);
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }

	        // get connection
	        System.out.println("connecting to db");

	        // with this you connect to hive server specifying a database e.g. default
	        //Connection con = DriverManager.getConnection("jdbc:hive2://ec2-52-25-176-93.us-west-2.compute.amazonaws.com:10000/default", "hive", "#HIVE#2016%s3cur3");


	        // with this you connect to hive server without specifying a database
	        Connection con = DriverManager.getConnection("jdbc:hive2://ec2-35-166-12-36.us-west-2.compute.amazonaws.com:10000/", "hdfs", "hdfs");
	        // create statement
	        Statement stmt = con.createStatement();


	        // create query
	        String query = "show databases";
	        // execute statement
	        System.out.println("Execute query: " + query);
	        ResultSet result = stmt.executeQuery(query);

	        System.out.println("");
	        System.out.println("#################### Print query results ###########################");
	        ResultSetMetaData rsmd = result.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();
	        while (result.next()) {
	            for (int i = 1; i <= columnsNumber; i++) {
	                if (i > 1) System.out.print(",  ");
	                String columnValue = result.getString(i);
	                System.out.print(columnValue + " " + rsmd.getColumnName(i));
	            }
	            System.out.println("");
	        }

	        con.close();
	    }
	    
	    private static Connection connection = null;

		public static Connection getConnection() throws SQLException {
		     try {
		            // Register driver and create driver instance
		            Class.forName(driverName);
		        } catch (ClassNotFoundException ex) {
		            ex.printStackTrace();
		        }

		        // get connection
		        System.out.println("connecting to db");
			if (connection == null) {
				connection = DriverManager.getConnection("jdbc:hive2://ec2-35-166-12-36.us-west-2.compute.amazonaws.com:10000/", "hive", "#HIVE#2016%s3cur3");
		        // create statement

			}
			if (connection.isClosed()) {
				throw new SQLException("connection could not initiated");
			}
			return connection;
		}
}