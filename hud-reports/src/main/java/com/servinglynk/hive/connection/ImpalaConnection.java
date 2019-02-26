package com.servinglynk.hive.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servinglynk.hmis.warehouse.Properties;

public class ImpalaConnection {
    private static String driverName = "com.cloudera.impala.jdbc41.Driver";
    private static Connection connection = null;

	public static Connection getConnection() throws SQLException {
	     try {
	            // Register driver and create driver instance
	            Class.forName(driverName);
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        }

	       
		if (connection == null) {
			connection = DriverManager.getConnection(Properties.IMPALA_DRIVER_URL, Properties.IMPALA_USERNAME, Properties.IMPALA_PASSWORD);
			 // get connection
	        System.out.println("connecting to db");
	        // create statement

		}
		if (connection.isClosed()) {
			throw new SQLException("connection could not initiated");
		}
		return connection;
	}
	
public static void main (String args[]) throws Exception {
	Properties props = new Properties();
	props.generatePropValues();
	props.printProps();
	Connection con = getConnection();
	Statement stmt = con.createStatement();

	ResultSet rs = stmt.executeQuery("select personalid from mo0010.client limit 10");

	System.out.println("\n== Begin Query Results ======================");

	// print the results to the console
	while (rs.next()) {
		// the example query returns one String column
		System.out.println(rs.getString(1));
	}
	System.out.println("== End Query Results =======================\n\n");
}
}