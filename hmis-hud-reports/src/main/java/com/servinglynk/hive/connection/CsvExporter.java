package com.servinglynk.hive.connection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.Logging;
import com.servinglynk.hmis.warehouse.Properties;

public class CsvExporter  extends Logging {
	private BufferedWriter fileWriter;

	public void export(String schema, String table,String field, int reportId) throws ClassNotFoundException {

		String csvFileName = getFileName(table);

		try (Connection connection = SyncPostgresProcessor.getConnection()) {
			String sql = "SELECT * FROM ".concat(schema).concat(".").concat(table) +" where "+field+"="+reportId;

			Statement statement = connection.createStatement();
			ResultSet result = null;
			try {
				result = statement.executeQuery(sql);
			} catch(Exception e) {
				// Eat the exception
			}
			if(result != null) {
				fileWriter = new BufferedWriter(new FileWriter(schema+"/"+csvFileName));

				int columnCount = writeHeaderLine(result);

				while (result.next()) {
					String line = "";

					for (int i = 1; i <= columnCount; i++) {
						ResultSetMetaData metaData = result.getMetaData();
						String column = metaData.getColumnName(i);
						Object valueObject = result.getObject(column);
						String valueString = "";
						if(column.contains("ID") && valueObject != null) {
							valueString = valueObject.toString();
							if(valueString.length() == 36) {
								valueString = valueString.substring(0, valueString.indexOf("-"));
							}
						}

						if (valueObject instanceof String) {
							valueString = "\"" + escapeDoubleQuotes(valueString) + "\"";
						}

						line = line.concat(valueString);

						if (i != columnCount) {
							line = line.concat(",");
						}
					}

					fileWriter.newLine();
					fileWriter.write(line);
				}

				fileWriter.close();
			}

		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}

	}

	private String getFileName(String tableName) {
		if(StringUtils.contains(tableName, "Organization")) {
			return "Organization.csv";
		}
		if(StringUtils.contains(tableName, "ProjectCoC")) {
			return "ProjectCoC.csv";
		}
		if(StringUtils.contains(tableName, "Project")) {
			return "Project.csv";
		}
		if(StringUtils.contains(tableName, "Funder")) {
			return "Funder.csv";
		}
		if(StringUtils.contains(tableName, "Inventory")) {
			return "Inventory.csv";
		}
		if(StringUtils.isNotBlank(tableName)) {
			tableName = tableName.replaceAll("\"", "");
			String[] split = tableName.split("_");
			tableName = split[0].toUpperCase()+split[1];
		}
		return tableName+".csv";
	}

	private int writeHeaderLine(ResultSet result) throws SQLException, IOException {
// write header line containing column names
		ResultSetMetaData metaData = result.getMetaData();
		int numberOfColumns = metaData.getColumnCount();
		String headerLine = "";
		int columnCnt = 0;
// exclude the first column which is the ID field
		for (int i = 1; i <= numberOfColumns; i++) {
			String columnName = metaData.getColumnName(i);
			if(StringUtils.isNotBlank(columnName) && (!StringUtils.equals(columnName, "project_group_code") && !StringUtils.equals(columnName, "Step"))) {
				headerLine = headerLine.concat(columnName).concat(",");
				columnCnt++;
			}
			
			
		}

		fileWriter.write(headerLine.substring(0, headerLine.length() - 1));

		return columnCnt;
	}

	private String escapeDoubleQuotes(String value) {
		return value.replaceAll("\"", "\"\"");
	}

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.generatePropValues();
		CsvExporter exporter = new CsvExporter();
		Map<String,String> csvs = new HashMap<>();
		csvs.put("\"lsa_Calculated\"","\"ReportID\"");
		csvs.put("\"lsa_Exit\"","\"ReportID\"");
		csvs.put("\"lsa_Funder\"","\"ExportID\"");
		csvs.put("\"lsa_Inventory\"","\"ExportID\"");
		csvs.put("\"lsa_Organization\"","\"ExportID\"");
		csvs.put("\"lsa_Project\"","\"ExportID\"");
		csvs.put("\"lsa_ProjectCoC\"","\"ExportID\"");
		csvs.put("\"lsa_Person\"","\"ReportID\"");
		csvs.put("\"lsa_Report\"","\"ReportID\"");
		csvs.put("\"lsa_HouseHold\"","\"ReportID\"");
		for (Map.Entry<String,String> entry : csvs.entrySet())   {
			exporter.export("lsa",entry.getKey(),entry.getValue(),12345);
		}
	}
}