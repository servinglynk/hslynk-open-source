package com.seringlynk.hmis.warehouse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BaseProcessor<T> {
	
	

	public void syncToHBASE(Class<T> class1,String tableName,java.util.Map<String, Integer> tableSyncList,Timestamp lastSyncDate) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		int index = 0;
		ResultSet resultSet = null;
		tableSyncList.put(tableName, index);
		Connection connection = null;
		try {
			connection = getConnection();

			String queryString = "SELECT * FROM live."+tableName ;
			if (lastSyncDate != null) {
				queryString =  queryString + " where date_created > ?" ;
				PreparedStatement statement = connection.prepareStatement(queryString);
				statement.setTimestamp(1, lastSyncDate);
				resultSet = statement.executeQuery();
			}else{
				PreparedStatement statement = connection.prepareStatement(queryString);
				resultSet = statement.executeQuery();
			}
			
			// simple JDBC code to run SQL query and populate resultSet - END
			if(resultSet !=null) {
			List<T> pojoList = resultSetMapper.mapRersultSetToObject(resultSet, class1);
			// print out the list retrieved from database
			if(pojoList != null){
				for(T pojo : pojoList){
					if(pojo !=null) 
					{
					HBaseImport hbaseImpot = new HBaseImport();
					// Insert data into an HBASE table  with in a column Family called Client
			//TOOD: Need to verify Exception Handling
			try {
				Map<String, Object> data = org.apache.commons.beanutils.BeanUtils.describe(pojo);
				String id =(String) data.get("id");
				if(id !=null) {
				String rowKey =(String) data.get("export_id");
				if(rowKey ==null) {
					rowKey = UUID.randomUUID().toString();
				}
				// Call HBaseImport Insert
				tableSyncList.put(tableName, ++index);
				HBaseImport baseImport = new HBaseImport();
				data.remove("class");
	//			 baseImport.insert("hmis", class1.getSimpleName(), rowKey, getNonCollectionFields(pojo), data);
				 baseImport.insert(class1.getSimpleName(),"CF" ,id , getNonCollectionFields(pojo), data);
				}
			
			
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(pojo);
					}
					
				}
			}else{
				System.out.println("ResultSet is empty. Please check if database table is empty for Table ::"+tableName);
			}
			}else{
				System.out.println("ResultSet is empty. Please check if database table is empty for Table ::"+tableName);
			}
			connection.close();

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		} 
	}

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
//				"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
//				"hmisdb1234");
				"jdbc:postgresql://localhost:5432/hmis", "postgres",
				"postgres");
		return connection;
	}
	
	public static String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		List<String> fieldList = new ArrayList<>();
		
		int i=0;
		for(Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if(genericType != null ){
				fieldList.add(field.getName());
			}
		}
		return fieldList.toArray(new String[fieldList.size()]);
	}

	public Timestamp getLastSyncTime() {
		ResultSet resultSet = null;
		Timestamp timestamp = null;
		PreparedStatement statement = null;
		try {
			Connection connection = getConnection();
//			PreparedStatement statement = connection.prepareStatement("SELECT max(insert_at) FROM live.bulk_upload where status='LIVE'");
			statement = connection.prepareStatement("SELECT max(date_created) FROM live.sync where status='COMPLETE'");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				timestamp =  resultSet.getTimestamp(1);
			}
			return timestamp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public Timestamp updateSyncStartTime(Timestamp dateCreated) {
		PreparedStatement statement = null;
		try {
			Connection connection = getConnection();
			statement = connection.prepareStatement("UPDATE live.sync SET date_created=?, status=? where date_created=?");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setTimestamp(1, currentTimestamp);
			statement.setString(2, "Initial");
			statement.setTimestamp(3, dateCreated);
			int status = statement.executeUpdate();
		return currentTimestamp;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	private Timestamp getCUrrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		return currentTimestamp;
		
	}

	public UUID insertSyncStartTime() {
		PreparedStatement statement = null;
		try {
			UUID syncID = UUID.randomUUID();
			Connection connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO live.sync (id, date_created, status) VALUES (?, ?, ?)");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setObject(1, syncID);
		statement.setTimestamp(2, currentTimestamp);
			statement.setString(3, "INITIAL");
			statement.execute();
		return syncID;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public void updateSyncEndDate(String jsonString, UUID id) {
		PreparedStatement statement = null; 
		try {
			Connection connection = getConnection(); 
			statement = connection.prepareStatement("UPDATE live.sync SET date_updated=?, status=?, json=? where id=?");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setTimestamp(1, currentTimestamp);
			statement.setString(2, "COMPLETE");
			statement.setString(3, jsonString);
			statement.setObject(4, id);
			int status = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
