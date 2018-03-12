package com.servinglynk.hmis.warehouse;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateCESTables {

	public static void main(String args[]) throws Exception {
		 Properties props = new Properties();
		 props.generatePropValues();
		CreateCESTables cesTables = new CreateCESTables();
		String projectGroups = Properties.PROJECT_GROUPS;
		String[] split = projectGroups.split(",");
		for(String projectGroup : split) {
			cesTables.getFile("CESTables.sql",projectGroup);
			cesTables.getFile("HiveSQLCreateTable.sql",projectGroup);
			cesTables.getFile("HiveSQLCreateTable_v2015.sql",projectGroup);
		}
	}
	
	 private String getFile(String fileName,String projectGroupCode) {
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
