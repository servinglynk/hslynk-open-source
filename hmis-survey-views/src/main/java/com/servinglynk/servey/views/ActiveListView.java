package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
			builder.append(projectGroupCode+".active_list");
			builder.append("( client_id string,first_name string,last_name string,survey_id string,survey_title string,survey_date timestamp ,score bigint,ignore_match_process boolean");
			String query = builder.toString();
			query = query +")";
			System.out.println(" Create Query::"+ query);
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
	/***
	 * Deleting the active list record by client_id
	 */
	private static void updateClient(String clientId,String projectGroupCode, String surveyId,Timestamp surveyDate,int score,boolean ignoreMatchProcess) {
		Connection connection;
		try {
			connection = HiveConnection.getConnection();
			// execute statement
			StringBuilder builder = new StringBuilder();
			builder.append("update ");
			builder.append(projectGroupCode+".active_list");
			builder.append(" set survey_id = ?,survey_date=?, score= ?,ignore_match_process=? ");
			builder.append(" where client_id = ?");
			System.out.println(" Delete Query::"+ builder.toString());
			PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
			preparedStatement.setString(1, surveyId);
			preparedStatement.setTimestamp(2, surveyDate);
			preparedStatement.setInt(3, score);
			preparedStatement.setBoolean(4, ignoreMatchProcess);
			preparedStatement.setString(5, clientId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
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
	public static void insertIntoHiveTable(String surveyId, int score,String clientId,String projectGroupCode,Timestamp createAt,boolean ignoreMatchProcess) {
		Connection connection;
		try {
			connection = HiveConnection.getConnection();
			// execute statement
			Survey survey = getSurveyById("survey", surveyId);
			if(survey !=null && StringUtils.equals(projectGroupCode, survey.getProjectGroupCode()) ) {
				StringBuilder builder = new StringBuilder();
				builder.append("INSERT INTO ");
				builder.append(survey.getProjectGroupCode()+".active_list");
				builder.append("  VALUES ( ");
				System.out.println("The Query:::"+builder.toString() + " Survey :"+surveyId.toString() + " Client:"+clientId.toString());
				Client client = getClientByID(clientId.toString());
				Statement stmt = connection.createStatement();
				builder.append("'"+clientId+"',");
				builder.append("'"+client.getFirstName().replaceAll("[^a-zA-Z0-9]", " ")+"',");
				builder.append("'"+client.getLastName().replaceAll("[^a-zA-Z0-9]", " ")+"',");
				builder.append("'"+surveyId+"',");
				builder.append("'"+survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", " ")+"',");
				builder.append("'"+getCreatedAtString(createAt)+"',");
				builder.append(score+",");
				builder.append(ignoreMatchProcess);
				builder.append(")");
				System.out.println(builder.toString());
				stmt.executeUpdate(builder.toString());
			}else {
				System.out.println("Skipping inserting of client id "+clientId +"related to survey Id :"+clientId);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static String getCreatedAtString(Timestamp timestamp) {
		 String pattern = "yyyy-MM-dd HH:mm:ss";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    String stringDate = format.format(timestamp);
		    return stringDate;
	}

	public static void processActiveList(String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			System.out.println("before getting getHiveActiveListClients");
			Map<String,Timestamp> hiveClientMap = getHiveActiveListClients(projectGroupCode);
			connection = getConnection();
			statement = connection.prepareStatement(ViewQuery.HOUSING_INVENTORY_ACTIVE_LIST);
			statement.setString(1, projectGroupCode);
			resultSet = statement.executeQuery();
 			while(resultSet.next()) {
				int score = resultSet.getInt("score");
				//String surveyId =(String) resultSet.getString("survey_id");
				String clientId = (String)resultSet.getString("client_id");
				System.out.println("Processing Client ::"+clientId);
				Timestamp createAt = (Timestamp)resultSet.getTimestamp("survey_date");
				boolean ignoreMatchProcess =  resultSet.getBoolean("ignore_match_process");
				if(StringUtils.isNotBlank(clientId)) {
					String surveyId = getLastestSurveyByClient(clientId, projectGroupCode);
					if(StringUtils.isBlank(surveyId)) {
						surveyId = getLastestSurveyByClientFromSectionScore(clientId, projectGroupCode);
					}
					if(StringUtils.isNotBlank(surveyId)) {
						surveyId = surveyId.trim();
						clientId = clientId.trim();
						Timestamp createDateFromHive = hiveClientMap.get(clientId.trim());
							if(createDateFromHive != null) {
								if(clientSurvyedAgain(createAt,createDateFromHive)){
									System.out.println("Updating Client::"+clientId+" createDateFromHive ::"+createDateFromHive + " createAt::"+createAt);
									updateClient(clientId,projectGroupCode,surveyId,createAt,score,ignoreMatchProcess);
								}
							} else {
								insertIntoHiveTable(surveyId, score, clientId,projectGroupCode,createAt,ignoreMatchProcess);
							}
						} {
							System.out.println("Skipping this client because we can't find a survey"+clientId);
						}
					}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static  String getLastestSurveyByClient(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		String surveyID =null;
		try{
		connection = getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT);
		statement.setObject(1, UUID.fromString(clientId));
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				surveyID = (String)resultSet.getString("survey_id");
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return surveyID;
	}
	
	public static  String getLastestSurveyByClientFromSectionScore(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		String surveyID =null;
		try{
		connection = getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT_FROM_SCORE);
		statement.setObject(1, UUID.fromString(clientId));
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				surveyID = (String)resultSet.getString("survey_id");
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return surveyID;
	}
	
	private static boolean clientSurvyedAgain(Timestamp createAt, Timestamp createDateFromHive) {
		if( createAt.compareTo(createDateFromHive) == 0) {
			 return false;
		}else if(createDateFromHive.compareTo(createAt) > 0) {
			return false;
		}else if( createDateFromHive.compareTo(createAt) < 0) {
			return true;
		}
		return false;
	}
	public static Map<String,Timestamp> getHiveActiveListClients(String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Map<String,Timestamp> hiveClientMap = new HashMap<>();
		try {
			connection = HiveConnection.getConnection();
			// execute statement
				StringBuilder builder = new StringBuilder();
				
				builder.append("select client_id ,survey_date from ");
				builder.append(projectGroupCode);
				builder.append(".active_list");
				statement = connection.prepareStatement(builder.toString());
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String clientId = resultSet.getString("client_id"); 
					Timestamp surveyDate = resultSet.getTimestamp("survey_date");
					if(StringUtils.isNotBlank(clientId) && surveyDate !=null ) {
							clientId = clientId.trim();
							hiveClientMap.put(clientId, surveyDate);
						}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finally created the hive client map");
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
		processActiveList("MO0010");
	}


}