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
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTable;

import com.servinglynk.hmis.warehouse.model.v2014.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2014.Bedinventory;
import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.Commercialsexualexploitation;
import com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2014.Employment;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.v2014.Funder;
import com.servinglynk.hmis.warehouse.model.v2014.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2014.Inventory;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.model.v2014.Lastpermanentaddress;
import com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2014.Organization;
import com.servinglynk.hmis.warehouse.model.v2014.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Services;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.model.v2014.Site;
import com.servinglynk.hmis.warehouse.model.v2014.Source;
import com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.model.v2015.Coc;
import com.servinglynk.hmis.warehouse.model.v2015.Contact;
import com.servinglynk.hmis.warehouse.model.v2015.Education;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2015.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2015.Exitpath;
import com.servinglynk.hmis.warehouse.model.v2015.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral;

public class BaseProcessor<T> extends Logging {

	public void syncToHBASE(Class<T> class1, String tableName, Timestamp lastSyncDate, BulkUpload upload, Map<String, String> hmisTypes) throws Exception {
		log.info("[" + tableName + "] Run SyncToHBASE for class: " + class1.getName());
		long startNanos = System.nanoTime();
		String schema = getSchemaFromYear(upload);
		List<T> pojoList = getPojoData(upload, tableName, class1,schema);

		// print out the list retrieved from database
		if (pojoList != null) {
			Map<String, Map<String, Object>> toUpdate = new HashMap<>();
			Map<String, Map<String, Object>> toInsert = new HashMap<>();

			String tblName = class1.getSimpleName() + "_" + upload.getProjectGroupCode();
			HTable table = new HTable(HbaseUtil.getConfiguration(), tblName.trim());
			HBaseImport hBaseImport = new HBaseImport();
			List<String> rowKeys = hBaseImport.getAllKeyRecords(table);
			for (T pojo : pojoList) {
				if (pojo != null) {
					// Insert data into an HBASE table  with in a column Family called Client
					//TOOD: Need to verify Exception Handling
					try {
						Map<String, Object> data = org.apache.commons.beanutils.BeanUtils.describe(pojo);
						String id = (String) data.get("id");
						if (id != null) {
							// Update the sync to true;
							String rowKey = (String) data.get("export_id");
							if (rowKey == null) {
								rowKey = UUID.randomUUID().toString();
								data.put("export_id", rowKey);
							}

							data.remove("class");
							populateHmisType(data, hmisTypes);
							// Check if the record exist in the table
//							boolean exists = HBaseImport.isDataExist(table, id);
							if (rowKeys.contains(id)) {
								toUpdate.put(id, data);
							} else {
								toInsert.put(id, data);
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
			log.info("[" + tableName + "] Time taken to generate insert and update maps in seconds: " +
					TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) / 1000);
			log.info("[" + tableName + "] Insertions for " + class1.getName() + " : " + toInsert.size());
			log.info("[" + tableName + "] Updates for " + class1.getName() + " : " + toUpdate.size());
			if (toUpdate.size() > 0) {
				hBaseImport.updateDataInBatch(table, toUpdate);
			}
			if (toInsert.size() > 0) {
				hBaseImport.insertDataInBatch(table, "CF", toInsert);
			}
			//updateSyncFlag(tableName, upload.getExportId());
			table.close();
			hBaseImport.closeAdmin();
		}
		updateSyncFlag(tableName, upload.getExportId(),schema);
	}

	private List<T> getPojoData(BulkUpload upload, String tableName, Class<T> class1,String schema) {
		List<T> pojoList = null;
		UUID exportId = upload.getExportId();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		ResultSet resultSet = null;
		try {
			connection = getConnection();

			String queryString = "SELECT * FROM "+schema+"."+tableName;
			queryString = queryString + " where export_id = ?";
			statement = connection.prepareStatement(queryString);
			statement.setObject(1, exportId);
			resultSet = statement.executeQuery();

			// simple JDBC code to run SQL query and populate resultSet - END
			if (resultSet != null) {
				pojoList = resultSetMapper.mapRersultSetToObject(resultSet, class1);
			}
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
		return pojoList;
	}

	private static Connection connection = null;

	private static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://hmis-multischema-db.ct16elltavnx.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
					"hmisdb1234");
//				"jdbc:postgresql://localhost:5432/hmis", "postgres",
//				"postgres");
		}
		if (connection.isClosed()) {
			throw new SQLException("connection could not initiated");
		}
		return connection;
	}

	public static String[] getNonCollectionFields(Object obj) {
		Field[] declaredFields = obj.getClass().getFields();
		//System.out.println(declaredFields[0].getName() + " type of the field "+declaredFields[0].getGenericType() );
		String[] fieldsArray = new String[100];
		List<String> fieldList = new ArrayList<>();

		int i = 0;
		for (Field field : declaredFields) {
			Type genericType = field.getGenericType();
			if (genericType != null) {
				fieldList.add(field.getName());
			}
		}
		return fieldList.toArray(new String[fieldList.size()]);
	}

	public Timestamp updateSyncStartTime(Timestamp dateCreated, String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("UPDATE "+schema+".sync SET date_created=?, status=? where date_created=?");
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
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	private void populateHmisType(Map<String, Object> data, Map<String, String> hmisTypes) {
		Map<String, Object> descMap = new HashMap<String, Object>();
		for (String key : data.keySet()) {
			String value = (String) data.get(key);
			value = value != null ? value.trim() : "";
			String mapKey = key.trim() + "_" + value;
			String hmisType = hmisTypes.get(mapKey.trim().toLowerCase());
			if (StringUtils.isNotEmpty(hmisType)) {
				//System.out.println("Desc Field::"+key+"_desc");
				descMap.put(key + "_desc", hmisType.trim());
			}
		}
		if (descMap.size() > 0) {
			for (String key : descMap.keySet()) {
				data.put(key, (String) descMap.get(key));
			}
		}

	}

	/***
	 * Loads the Hmistype into a hashMap so that I canbe retrieved from there instead of querying the tables.
	 *
	 * @return Map<String,String>
	 */
	public static Map<String, String> loadHmisTypeMap(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String, String> hmisTypeMap = new HashMap<String, String>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT name, value,description FROM "+schema+".hmis_type");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				String key = name.trim() + "_" + resultSet.getString(2).trim();
				hmisTypeMap.put(key.trim().toLowerCase(), resultSet.getString(3).trim());
			}
			return hmisTypeMap;
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
	/***
	 * This method returns schema name from year.
	 * @return
	 */
	public String getSchemaFromYear(BulkUpload upload) {
		if(upload.getYear() != 0L) {
			return "v"+upload.getYear();	
		}
		return "v2014";
	}

	/***
	 * Gets the type from hmis_type table so we can store readable values in HBASE.
	 *
	 * @return
	 */
	public static BulkUpload getExportIDFromBulkUpload() {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<BulkUpload> uploads = new ArrayList<BulkUpload>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement("SELECT export_id,project_group_code,id,year FROM base.bulk_upload where status='STAGING'");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				BulkUpload upload = new BulkUpload();
				upload.setExportId(UUID.fromString(resultSet.getString(1)));
				upload.setProjectGroupCode(resultSet.getString(2));
				upload.setId(resultSet.getLong(3));
				upload.setYear(resultSet.getLong(4));
				uploads.add(upload);
			}
			return uploads.get(0);
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


	private static  Timestamp getCUrrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		return currentTimestamp;

	}

	public static UUID insertSyncStartTime(String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			UUID syncID = UUID.randomUUID();
			connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO "+schema+".sync (id, date_created, status) VALUES (?, ?, ?)");
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
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public void updateSyncEndDate(String jsonString, UUID id,String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("UPDATE "+schema+".sync SET date_updated=?, status=?, json=? where id=?");
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
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void updateBulkUpload(Long id) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("UPDATE base.bulk_upload SET date_updated=?, status=? where id =?");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setTimestamp(1, currentTimestamp);
			statement.setString(2, "LIVE");
			statement.setLong(3, id);
			int status = statement.executeUpdate();
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
	public void updateSyncFlag(String tableName, UUID id, String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement("UPDATE "+schema+"."+ tableName + " SET date_updated=?, sync=?,active=? where export_id=?");
			Timestamp currentTimestamp = getCUrrentTimestamp();
			statement.setTimestamp(1, currentTimestamp);
			statement.setBoolean(2, true);
			statement.setBoolean(3, true);
			statement.setObject(4, id);
			int status = statement.executeUpdate();
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

	public static Map<String, Class<? extends BaseModel>> getAlltablesV2014() {
		Map<String, Class<? extends BaseModel>> tables = new HashMap<String, Class<? extends BaseModel>>();
		tables.put("affiliation", Affiliation.class);
		tables.put("bedinventory", Bedinventory.class);
		tables.put("client", Client.class);
		tables.put("commercialsexualexploitation", Commercialsexualexploitation.class);
		tables.put("connectionwithsoar", Connectionwithsoar.class);
		tables.put("dateofengagement", Dateofengagement.class);
		tables.put("disabilities", Disabilities.class);
		tables.put("domesticviolence", Domesticviolence.class);
		tables.put("employment", Employment.class);
		tables.put("enrollment", Enrollment.class);
		tables.put("enrollment_coc", EnrollmentCoc.class);
		tables.put("exit", Exit.class);
		tables.put("exithousingassessment", Exithousingassessment.class);
		tables.put("exitplansactions", Exitplansactions.class);
		tables.put("export", Export.class);
		tables.put("familyreunification", Familyreunification.class);
		tables.put("formerwardchildwelfare", Formerwardchildwelfare.class);
		tables.put("formerwardjuvenilejustice", Formerwardjuvenilejustice.class);
		tables.put("funder", Funder.class);
		tables.put("healthinsurance", Healthinsurance.class);
		tables.put("health_status", HealthStatus.class);
		tables.put("housingassessmentdisposition", Housingassessmentdisposition.class);
		tables.put("incomeandsources", Incomeandsources.class);
		tables.put("inventory", Inventory.class);
		tables.put("lastgradecompleted", Lastgradecompleted.class);
		tables.put("last_perm_address", Lastpermanentaddress.class);
		tables.put("medicalassistance", Medicalassistance.class);
		tables.put("noncashbenefits", Noncashbenefits.class);
		tables.put("organization", Organization.class);
		tables.put("path_status", Pathstatus.class);
		tables.put("percent_ami", Percentami.class);
		tables.put("project", Project.class);
		tables.put("projectcoc", Projectcoc.class);
		tables.put("projectcompletionstatus", Projectcompletionstatus.class);
		tables.put("referralsource", Referralsource.class);
		tables.put("residentialmoveindate", Residentialmoveindate.class);
		tables.put("rhybcp_status", Rhybcpstatus.class);
		tables.put("schoolstatus", Schoolstatus.class);
		tables.put("services", Services.class);
		tables.put("sexualorientation", Sexualorientation.class);
		tables.put("site", Site.class);
		tables.put("source", Source.class);
		tables.put("veteran_info", VeteranInfo.class);
		tables.put("worsthousingsituation", Worsthousingsituation.class);
		tables.put("youthcriticalissues", Youthcriticalissues.class);
		return tables;
	}
	
	public static Map<String, Class<? extends BaseModel>> getAlltablesV2015() {
		Map<String, Class<? extends BaseModel>> tables = new HashMap<String, Class<? extends BaseModel>>();
		tables.put("affiliation",com.servinglynk.hmis.warehouse.model.v2015.Affiliation.class);
		tables.put("bedinventory",com.servinglynk.hmis.warehouse.model.v2015.Bedinventory.class);
		tables.put("client",com.servinglynk.hmis.warehouse.model.v2015.Client.class);
	    tables.put("client_veteran_info",com.servinglynk.hmis.warehouse.model.v2015.VeteranInfo.class);
	    tables.put("coc",Coc.class);
	    tables.put("contact",Contact.class);
	    tables.put("dateofengagement",com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class);
	    tables.put("disabilities",com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class);
	    tables.put("domesticviolence",com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence.class);
	    tables.put("education",Education.class);
	    tables.put("employment",com.servinglynk.hmis.warehouse.model.v2015.Employment.class);
	    tables.put("enrollment",com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
	    tables.put("enrollment_coc",com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc.class);
	    tables.put("entryrhsp",Entryrhsp.class);
	    tables.put("entryrhy",Entryrhy.class);
	    tables.put("entryssvf",Entryssvf.class);
	    tables.put("exit", com.servinglynk.hmis.warehouse.model.v2015.Exit.class);
	    tables.put("exithousingassessment",com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment.class);
	    tables.put("exitpath",Exitpath.class);
	    tables.put("exitrhy",Exitrhy.class);
	    tables.put("export",com.servinglynk.hmis.warehouse.model.v2015.Export.class);
	    tables.put("funder",com.servinglynk.hmis.warehouse.model.v2015.Funder.class);
	    tables.put("health_status",com.servinglynk.hmis.warehouse.model.v2015.HealthStatus.class);
	    tables.put("healthinsurance",com.servinglynk.hmis.warehouse.model.v2015.Healthinsurance.class);
	    tables.put("housingassessmentdisposition",com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition.class);
	    tables.put("incomeandsources",com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
	    tables.put("inventory",com.servinglynk.hmis.warehouse.model.v2015.Inventory.class);
	    tables.put("medicalassistance",com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance.class);
	    tables.put("noncashbenefits",com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits.class);
	    tables.put("organization",com.servinglynk.hmis.warehouse.model.v2015.Organization.class);
	    tables.put("path_status",com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class);
	    tables.put("project",com.servinglynk.hmis.warehouse.model.v2015.Project.class);
	    tables.put("residentialmoveindate",com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate.class);
	    tables.put("rhybcp_status",com.servinglynk.hmis.warehouse.model.v2015.Rhybcpstatus.class);
	    tables.put("schoolstatus",Schoolstatus.class);
	    tables.put("service_fa_referral",ServiceFaReferral.class);
	    tables.put("site",com.servinglynk.hmis.warehouse.model.v2015.Site.class);
	    tables.put("source",com.servinglynk.hmis.warehouse.model.v2015.Source.class);

		return tables;
	}

}
