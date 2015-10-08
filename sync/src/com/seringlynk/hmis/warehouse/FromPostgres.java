package com.seringlynk.hmis.warehouse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FromPostgres {
	public static void main(String args[]) {
		
	//	syncClient(date,Client.class);
	System.out.println("-------- PostgreSQL "
			+ "JDBC Connection Testing ------------");

	try {

		Class.forName("org.postgresql.Driver");

	} catch (ClassNotFoundException e) {

		System.out.println("Where is your PostgreSQL JDBC Driver? "
				+ "Include in your library path!");
		e.printStackTrace();

	}

	System.out.println("PostgreSQL JDBC Driver Registered!");

	Connection connection = null;
	ResultSetMapper<Client> resultSetMapper = new ResultSetMapper<Client>();
	ResultSet resultSet = null;

	try {

		connection = DriverManager.getConnection(
				"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
				"hmisdb1234");
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM staging.Client");
		resultSet = statement.executeQuery();
		// simple JDBC code to run SQL query and populate resultSet - END
		List<Client> pojoList = resultSetMapper.mapRersultSetToObject(resultSet, Client.class);
		// print out the list retrieved from database
		if(pojoList != null){
			for(Client pojo : pojoList){
				HBaseImport hbaseImpot = new HBaseImport();
				UUID  rowkey = pojo.getId();
				// Insert data into an HBASE table  with in a column Family called Client
		//TOOD: Need to verify Exception Handling
		try {
			Map<String, Object> data = org.apache.commons.beanutils.BeanUtils.describe(pojo);
			// Call HBaseImport Insert
				HBaseImport baseImport = new HBaseImport();
				baseImport.insert("hmis", "client", rowkey.toString(), getNonCollectionFields(pojo), data);
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
		}else{
			System.out.println("ResultSet is empty. Please check if database table is empty");
		}
		connection.close();

	} catch (SQLException e) {

		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();

	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
 }
	
	
	public static String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getDeclaredFields();
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
}
