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

import com.servinglynk.hmis.warehouse.model.Client;

public class BaseProcessor<T> {
	
	Connection connection = null;
	ResultSet resultSet = null;

	public void getResult(Class<T> class1) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
					"hmisdb1234");
			
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM staging."+class1.getSimpleName());
			resultSet = statement.executeQuery();
			// simple JDBC code to run SQL query and populate resultSet - END
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
				HBaseImport baseImport = new HBaseImport();
				data.remove("class");
				// baseImport.insert("hmis", class1.getSimpleName(), rowKey, getNonCollectionFields(pojo), data);
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
				System.out.println("ResultSet is empty. Please check if database table is empty");
			}
			connection.close();

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}
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
}
