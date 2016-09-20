package com.servinglynk.hive.report.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hmis.warehouse.model.v2014.Project;


public class ReportSummary {

	/***
	 * Gets the type from hmis_type table so we can store readable values in HBASE.
	 *
	 * @return
	 */
	public static List<Project> getProject(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = HiveConnection.getConnection();
			statement = connection.prepareStatement("SELECT * FROM "+schema+".project");
			resultSet = statement.executeQuery();
			int count = 0;
		

			System.out.println(count);
			return null;
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
		return null;
	}
}
