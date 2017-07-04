package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ViewQuery;
import com.servinglynk.hmis.warehouse.Properties;

public class ActiveListView extends BaseView {

	public static void createHiveTable(String projectGroupCode) {
		Connection connection;
		try {
			connection = HiveConnection.getConnection();
			Statement stmt = connection.createStatement();
			// execute statement
			StringBuilder builder = new StringBuilder();
			builder.append("CREATE TABLE IF NOT EXISTS ");
			builder.append(projectGroupCode+".test_active_list");
			builder.append("( client_id string,first_name string,last_name string,survey_id string,survey_title string,survey_date string ,score bigint ");
			String query = builder.toString();
			query = query +")";
			System.out.println(" Create Query::"+ query);
			//  stmt.execute("DROP Table  IF EXISTS "+projectGroupCode+".test_active_list");
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}

	/***
	 * Execute the below 3 queries to get the results
	 * select sum(section_score),survey_id,client_id from survey.section_score group by survey_id,client_id
	 select * from base.client where client_id = ?
	 select * from survey.survey where id = ?
	 * @param surveyId
	 * @param score
	 */
	public static void insertIntoHiveTable(String surveyId, int score,String clientId,String projectGroupCode,Date createAt) {
		Connection connection;
		try {
			connection = HiveConnection.getConnection();
			// execute statement
			Survey survey = getSurveyById("survey", surveyId.toString());
			if(survey !=null && StringUtils.equals(projectGroupCode, survey.getProjectGroupCode()) ) {
				StringBuilder builder = new StringBuilder();
				builder.append("INSERT INTO ");
				String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
				builder.append(survey.getProjectGroupCode()+".test_active_list");
				System.out.println("Inserting records for :::"+survey.getProjectGroupCode()+"."+tableName);
				builder.append("  VALUES ( ");
				builder.append("?,?,?,?,?,?,?");
				builder.append(")");
				System.out.println("The Query:::"+builder.toString() + " Survey :"+surveyId.toString() + " Client:"+clientId.toString());
				Client client = getClientByID(clientId.toString());
				PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
				preparedStatement.setString(1, clientId);
				preparedStatement.setString(2, client.getFirstName());
				preparedStatement.setString(3, client.getLastName());
				preparedStatement.setString(4, surveyId);
				preparedStatement.setString(5, survey.getSurveyName());
				if(createAt !=null) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					 String strDate = format.format(createAt);
					 preparedStatement.setString(6,	strDate);
				}else {
					preparedStatement.setString(6,	"");
				}
				
				preparedStatement.setInt(7, score);
				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void processActiveList(String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			Map<String,List<String>> hiveClientMap = getHiveActiveListClients(projectGroupCode);
			connection = getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_ACTIVE_LIST_DATA);
			statement.setString(1, projectGroupCode);
			resultSet = statement.executeQuery();
 			while(resultSet.next()) {
				int score = resultSet.getInt("score");
				String surveyId =(String) resultSet.getString("survey_id");
				String clientId = (String)resultSet.getString("client_id");
				Date createAt = (Date)resultSet.getDate("created_at");
				if(StringUtils.isNotBlank(surveyId) && StringUtils.isNotBlank(clientId)) {
					surveyId = surveyId.trim();
					clientId = clientId.trim();
					List<String> surveyIdsFromHive = hiveClientMap.get(clientId.trim());
					if(StringUtils.isNotBlank(surveyId)) {
						if(CollectionUtils.isNotEmpty(surveyIdsFromHive)) {
							if(!surveyIdsFromHive.contains(surveyId)){
								insertIntoHiveTable(surveyId, score, clientId,projectGroupCode,createAt);
							}
						} else {
							insertIntoHiveTable(surveyId, score, clientId,projectGroupCode,createAt);
						}
					}

				}
							}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
//	private static List<String> getUniqueSurveysForClient(List<String> surveyIdsFromHive, String surveyId) {
//		if(CollectionUtils.isNotEmpty(surveyIdsFromHive) && StringUtils.isNotBlank(surveyId)) {
//			for(String survey : surveyIdsFromHive) {
//				if(StringUtils.equals(survey, surveyId)) {
//					surveyIdsFromHive.remove(survey);
//				}
//			}
//		}
//		return surveyIdsFromHive;
//	}

	public static Map<String,List<String>> getHiveActiveListClients(String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String,List<String>> hiveClientMap = new HashMap<>();
		try {
			connection = HiveConnection.getConnection();
			// execute statement
				StringBuilder builder = new StringBuilder();
				
				builder.append("select client_id ,survey_id from ");
				builder.append(projectGroupCode);
				builder.append(".test_active_list");
				statement = connection.prepareStatement(builder.toString());
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String clientId = resultSet.getString("client_id");
					String surveyId = resultSet.getString("survey_id");
					if(StringUtils.isNotBlank(clientId) && StringUtils.isNotBlank(surveyId) ) {
						clientId = clientId.trim();
						List<String> surveys = hiveClientMap.get(clientId.trim());
						if(CollectionUtils.isNotEmpty(surveys)) {
							surveys.add(surveyId.trim());
							hiveClientMap.put(clientId, surveys);
						}else {
							surveys = new ArrayList<>();
							surveys.add(surveyId.trim());
							hiveClientMap.put(clientId, surveys);
						}
					}
				
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hiveClientMap;
	}
	public static Client getClientByID(String clientId) throws Exception{
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			connection = getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_CLIENT_BY_ID);
			statement.setObject(1, UUID.fromString(clientId));
			resultSet = statement.executeQuery();
			String firstName =  null;
			String lastName =  null;
			while(resultSet.next()) {
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
			}
			Client client = new Client(UUID.fromString(clientId), firstName, lastName);
			return client;
		}catch (Exception ex){
			throw ex;
		}
	}

	public static Survey getSurveyById(String schemaName,String surveyId) throws Exception{
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			connection = getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_SURVEY_BY_ID);
			statement.setObject(1, UUID.fromString(surveyId));
			resultSet = statement.executeQuery();
			String projectGroupCode = null;
			String surveyName =  null;
			Date createdDate =  null;
			while(resultSet.next()) {
				projectGroupCode = resultSet.getString("project_group_code");
				surveyName = resultSet.getString("survey_title");
				createdDate = resultSet.getDate("created_at");
			}
			Survey survey = new Survey(projectGroupCode,UUID.fromString(surveyId) , surveyName, createdDate);
			return survey;
		}catch (Exception ex){
			throw ex;
		}
	}

	public static void main(String args[]) throws Exception {
		Properties props = new Properties();
		props.generatePropValues();
		createHiveTable("MO0010");
		while(true){
			processActiveList("MO0010");
			Long seconds = Long.valueOf(1) * 60;
			System.out.println("Sleep for 60 minutes");
			Thread.sleep(1000 * seconds);
		} 
	}


}