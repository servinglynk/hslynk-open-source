package com.servinglynk.hmis.warehouse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;


public class SyncMain {
	private static int batchSize = 1000;
	private static Connection connection = null;
	private static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + "hmis-multischema-db.ct16elltavnx.us-west-2.rds.amazonaws.com" + ":" + "5432" + "/" + "hmis",
					"hmisdb1",
					"hmisdb1234");

		}
		if (connection.isClosed()) {
			throw new SQLException("connection could not initiated");
		}
		return connection;
	}
	
	public static void getProject(String schema,String tableName) throws IOException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		createHBASETable(tableName);
		HTable table = new HTable(HbaseUtil.getConfiguration(), tableName.trim());
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT * FROM "+schema+"."+tableName);
			resultSet = statement.executeQuery();
			int count = 0;
			List<Put> puts = new ArrayList<>();
		 while(resultSet.next()) {
			 	
				ResultSetMetaData metaData = resultSet.getMetaData();
				Put p = new Put(Bytes.toBytes(resultSet.getString("id")));
				for(int i=1;i<metaData.getColumnCount();i++) {
					String column = metaData.getColumnName(i);
					String value =resultSet.getString(i);
					//String dataType = metaData.getColumnTypeName(i);
					//System.out.println(metaData.getColumnName(i)+":Field::"+resultSet.getString(i)+"Data type::"+metaData.getColumnTypeName(i));
					if (StringUtils.isNotEmpty(column) && StringUtils.isNotEmpty(value)) {
						p.addColumn(Bytes.toBytes("CF"),
								Bytes.toBytes(column),
								Bytes.toBytes(value));
						puts.add(p);
					}
				}
				count++;
				if (count > batchSize) {
					//log.info("[" + table.getName().getNameAsString() + "]Time taken to generate " + count + " records in miliseconds: " +
					//		TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startGenerating));
					//long startWriting = System.nanoTime();
					table.put(puts);
					//log.info("[" + table.getName().getNameAsString() + "]Time taken to insert " + count + " records in miliseconds: " +
					//		TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startWriting));
					puts.clear();
					//startGenerating = System.nanoTime();
					count = 0;
				}
		 }
		 table.put(puts);
		 puts.clear();
		 System.out.println("processed records::"+count+"for table ::"+tableName);
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
	public static void createHBASETable(String tableName) {
		
		try {
			HBaseAdmin admin = HbaseUtil.getAdmin();
			HTableDescriptor tableDescriptor = new HTableDescriptor(
					tableName);
			tableDescriptor.addFamily(new HColumnDescriptor("CF"));
			admin.createTable(tableDescriptor);
			//logger.info("Table ::" + tableName + " created.");
		} catch (TableExistsException ex) {
			//logger.warn("Table :: " + tableName + " already exists.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		Map<String,List<String>> tableSchema = new HashMap<String, List<String>>();
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("picklist_group");
		tableNames.add("picklist_value");
		tableNames.add("question");
		tableNames.add("question_group");
		tableNames.add("response");
		tableNames.add("section_question_mapping");
		tableNames.add("section_score");
		tableNames.add("survey");
		tableNames.add("survey_section");
		
		tableSchema.put("survey",tableNames);
		List<String> tables = tableSchema.get("survey");
 		try {
 			for(String tableName : tables){
 				createSyncTable("survey");
 				getProject("survey",tableName);
 			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void createSyncTable(String schema) {
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS "+schema+".sync(id SERIAL NOT NULL PRIMARY KEY,status character varying(10), description text,completed boolean, date_created timestamp,date_updated timestamp) ");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void insertSyncTable(String schema) {
		PreparedStatement ps;
		
		try {
			ps = getConnection().prepareStatement("INSERT into "+schema+".sync(id,status,date_created,date_updated) values (?,?,?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "INITIAL");
			Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
			ps.setTimestamp(3, timestamp);
			ps.setTimestamp(4, timestamp);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
