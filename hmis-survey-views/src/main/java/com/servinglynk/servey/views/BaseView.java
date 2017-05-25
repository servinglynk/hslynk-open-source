package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.servinglynk.hmis.warehouse.Properties;

public class BaseView {
	private static Connection connection = null;
	public static Connection getConnection() throws SQLException {
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
}