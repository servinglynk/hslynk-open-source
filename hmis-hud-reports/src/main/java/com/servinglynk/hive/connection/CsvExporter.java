package com.servinglynk.hive.connection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

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

			ResultSet result = statement.executeQuery(sql);

			fileWriter = new BufferedWriter(new FileWriter(schema+"/"+csvFileName));

			int columnCount = writeHeaderLine(result);

			while (result.next()) {
				String line = "";

				for (int i = 1; i <= columnCount; i++) {
					Object valueObject = result.getObject(i);
					String valueString = "";

					if (valueObject != null)
						valueString = valueObject.toString();

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

		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}

	}

	private String getFileName(String tableName) {
		if(StringUtils.isNotBlank(tableName)) {
			tableName = tableName.replaceAll("_","");
			tableName = tableName.substring(1,tableName.length()-1);
			tableName = StringUtils.capitalize(tableName);
		}
		return tableName+".csv";
	}

	private int writeHeaderLine(ResultSet result) throws SQLException, IOException {
// write header line containing column names
		ResultSetMetaData metaData = result.getMetaData();
		int numberOfColumns = metaData.getColumnCount();
		String headerLine = "";

// exclude the first column which is the ID field
		for (int i = 1; i <= numberOfColumns; i++) {
			String columnName = metaData.getColumnName(i);
			headerLine = headerLine.concat(columnName).concat(",");
		}

		fileWriter.write(headerLine.substring(0, headerLine.length() - 1));

		return numberOfColumns;
	}

	private String escapeDoubleQuotes(String value) {
		return value.replaceAll("\"", "\"\"");
	}

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.generatePropValues();
		CsvExporter exporter = new CsvExporter();
		exporter.export("lsa","\"lsa_Person\"","\"ReportID\"",12345);
	}
}