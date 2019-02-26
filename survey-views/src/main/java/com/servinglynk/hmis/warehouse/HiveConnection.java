package com.servinglynk.hmis.warehouse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveConnection {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
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
			connection = DriverManager.getConnection(Properties.HIVE_DRIVER_URL, Properties.HIVE_USERNAME, Properties.HIVE_PASSWORD);
	        // create statement

		}
		if (connection.isClosed()) {
			throw new SQLException("connection could not initiated");
		}
		return connection;
	}
}