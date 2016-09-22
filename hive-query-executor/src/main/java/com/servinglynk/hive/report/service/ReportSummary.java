package com.servinglynk.hive.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.servinglynk.hive.connection.HiveConnection;


public class ReportSummary {

	/***
	 * Gets the type from hmis_type table so we can store readable values in HBASE.
	 *
	 * @return
	 */
	public static void getProject(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = HiveConnection.getConnection();
			statement = connection.prepareStatement("SELECT * FROM "+schema+".project");
			resultSet = statement.executeQuery();
			int count = 0;
		 while(resultSet.next()) {
				ResultSetMetaData metaData = resultSet.getMetaData();
				for(int i=1;i<metaData.getColumnCount();i++) {
					System.out.println(metaData.getColumnName(i)+":Field::"+resultSet.getString(i));
				}
		 }

			System.out.println(resultSet.getFetchSize());
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
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String args[]) {
		getProject("ho0002");
	}
}
