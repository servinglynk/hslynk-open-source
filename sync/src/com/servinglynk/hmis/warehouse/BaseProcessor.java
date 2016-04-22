package com.servinglynk.hmis.warehouse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class BaseProcessor<T> {
	
	public void syncToHBASE(Class<T> class1,String tableName,java.util.Map<String, Integer> tableSyncList,Timestamp lastSyncDate, BulkUpload upload, Map<String, String> hmisTypes) {
		int index=0;
		List<T> pojoList = getPojoData(upload, tableName, class1);
			// print out the list retrieved from database
			if(pojoList != null){
				for(T pojo : pojoList){
					if(pojo !=null) 
					{
					// Insert data into an HBASE table  with in a column Family called Client
					//TOOD: Need to verify Exception Handling
					try {
					Map<String, Object> data = org.apache.commons.beanutils.BeanUtils.describe(pojo);
					String id =(String) data.get("id");
					if(id !=null) {
					// Update the sync to true;
						String rowKey =(String) data.get("export_id");
						if(rowKey ==null) {
							rowKey = UUID.randomUUID().toString();
						}
				   // Call HBaseImport Insert
						tableSyncList.put(tableName, index++);
						HBaseImport baseImport = new HBaseImport();
						data.remove("class");
						//	System.out.println("Table Name ::"+getTableName(pojo.getClass().getSimpleName()));
						populateHmisType(data,hmisTypes);
						// Check if the record exist in the table
						if(baseImport.isDataExist(class1.getSimpleName()+"_"+upload.getProjectGroupCode()+"_2014", id)) {
							baseImport.updateData(class1.getSimpleName()+"_"+upload.getProjectGroupCode()+"_2014", id, data );	
						}else{
							baseImport.insert(class1.getSimpleName()+"_"+upload.getProjectGroupCode()+"_2014","CF" ,id , getNonCollectionFields(pojo), data);	
						}
					  }
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// 	TODO Auto-generated catch block
						e.printStackTrace();
					 }
				   }
				}
				updateSyncFlag(tableName,upload.getExportId());
				}
	}
	private List<T> getPojoData(BulkUpload upload, String tableName,Class<T> class1) {
		List<T> pojoList =null;
		UUID exportId = upload.getExportId();
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		ResultSet resultSet = null;
		try {
			connection = getConnection();

			String queryString = "SELECT * FROM stagv2014."+tableName ;
			queryString =  queryString + " where export_id = ?" ;
			statement = connection.prepareStatement(queryString);
			statement.setObject(1, exportId);
			resultSet = statement.executeQuery();
			
			// simple JDBC code to run SQL query and populate resultSet - END
			if(resultSet !=null) {
				pojoList = resultSetMapper.mapRersultSetToObject(resultSet, class1);
			}
		}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
							connection.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		return pojoList;
	}
	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://hmis-multischema-db.ct16elltavnx.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
				"hmisdb1234");
//				"jdbc:postgresql://localhost:5432/hmis", "postgres",
//				"postgres");
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

	public Timestamp updateSyncStartTime(Timestamp dateCreated) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("UPDATE stagv2015.sync SET date_created=?, status=? where date_created=?");
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
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	private void populateHmisType(Map<String, Object> data, Map<String,String> hmisTypes) {
		Map<String, Object> descMap = new HashMap<String, Object>();
		for(String key :data.keySet()) {
			String value = (String)data.get(key);
			value = value!=null ? value.trim() :"";
			String mapKey = key.trim()+"_"+value;
			String hmisType = hmisTypes.get(mapKey.trim());
			if(StringUtils.isNotEmpty(hmisType)) {
				//System.out.println("Desc Field::"+key+"_desc");
				descMap.put(key+"_desc", hmisType.trim());	
			}
		}
		if(descMap.size() >0 ) {
			for(String key :descMap.keySet()) {
				data.put(key, (String)descMap.get(key));
			}
		}
		
	}
	/***
	 * Loads the Hmistype into a hashMap so that I canbe retrieved from there instead of querying the tables.
	 * @return Map<String,String>
	 */
	public Map<String,String> loadHmisTypeMap() {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String, String> hmisTypeMap = new HashMap<String, String>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT name, value,description FROM v2014.hmis_type");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				String key = name.trim()+"_"+resultSet.getString(2).trim();
				hmisTypeMap.put(key.trim(), resultSet.getString(3).trim());
			}
			return hmisTypeMap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}
	/***
	 * Gets the type from hmis_type table so we can store readable values in HBASE.
	 * @param key
	 * @return
	 */
	public List<BulkUpload> getExportIDFromBulkUpload() {
		ResultSet resultSet = null;
		UUID exportId = null;
		String projectGroupCode = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<BulkUpload> uploads = new ArrayList<BulkUpload>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT export_id,project_group_code FROM base.bulk_upload where status='STAGING'");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				BulkUpload upload = new BulkUpload();
				upload.setExportId(UUID.fromString(resultSet.getString(1)));
				upload.setProjectGroupCode(projectGroupCode = resultSet.getString(2));
				uploads.add(upload);
			}
			return uploads;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					connection.close();
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
		Connection connection = null;
		try {
			UUID syncID = UUID.randomUUID();
			connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO stagv2014.sync (id, date_created, status) VALUES (?, ?, ?)");
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
					connection.close();
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
		Connection connection = null;
		try {
			connection = getConnection(); 
			statement = connection.prepareStatement("UPDATE stagv2014.sync SET date_updated=?, status=?, json=? where id=?");
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
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void updateSyncFlag(String tableName,UUID id) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection(); 
			statement = connection.prepareStatement("UPDATE stagv2014."+tableName+" SET date_updated=?, sync=? where id=?");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setTimestamp(1, currentTimestamp);
			statement.setBoolean(2,true );
			statement.setObject(3, id);
			int status = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public String getTableName(String className) {
		Map<String,String> tables = new HashMap<String, String>();
		tables.put("Affiliation","affiliation");
		tables.put("Bedinventory","bedinventory");
		tables.put("Client","client");
		tables.put("Commercialsexualexploitation","commercialsexualexploitation");
		tables.put("Connectionwithsoar","connectionwithsoar");
		tables.put("Dateofengagement","dateofengagement");
		tables.put("Disabilities","disabilities");
		tables.put("Domesticviolence","domesticviolence");
		tables.put("Employment","employment");
		tables.put("Enrollment","enrollment");
		tables.put("EnrollmentCoc","enrollment_coc");
		tables.put("Exit","exit");     
		tables.put("Exithousingassessment","exithousingassessment");
		tables.put("Exitplansactions","exitplansactions");
		tables.put("Export","export");
		tables.put("Familyreunification","familyreunification");
		tables.put("Formerwardchildwelfare","formerwardchildwelfare");
		tables.put("Formerwardjuvenilejustice","formerwardjuvenilejustice");
		tables.put("Funder","funder");
		tables.put("Healthinsurance","healthinsurance");
		tables.put("HealthStatus","health_status");
		tables.put("Housingassessmentdisposition","housingassessmentdisposition");
		tables.put("Incomeandsources","incomeandsources");
		tables.put("Inventory","inventory");
		tables.put("Lastgradecompleted","lastgradecompleted");
		tables.put("Lastpermanentaddress","last_perm_address");
		tables.put("Medicalassistance","medicalassistance");
		tables.put("Noncashbenefits","noncashbenefits");
		tables.put("Organization","organization");
		tables.put("Pathstatus","path_status");
		tables.put("Percentami","percent_ami");
		tables.put("Project","project");
		tables.put("Projectcoc","projectcoc");
		tables.put("Projectcompletionstatus","projectcompletionstatus");
		tables.put("Referralsource","referralsource");
		tables.put("Residentialmoveindate","residentialmoveindate");
		tables.put("Rhybcpstatus","rhybcp_status");
		tables.put("Schoolstatus","schoolstatus");
		tables.put("Services","services");
		tables.put("Sexualorientation","sexualorientation");
		tables.put("Site","site");
		tables.put("Source","source");
		tables.put("VeteranInfo","veteran_info");
		tables.put("Worsthousingsituation","worsthousingsituation");
		tables.put("Youthcriticalissues","youthcriticalissues");
		
		return tables.get(className);
				

		
	}
}
