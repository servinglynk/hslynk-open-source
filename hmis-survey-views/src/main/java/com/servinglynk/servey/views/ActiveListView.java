package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ViewQuery;

public class ActiveListView {
	 private static Connection connection = null;
	    static Connection getConnection() throws SQLException {
	        if (connection == null) {
	            connection = DriverManager.getConnection(
	                    "jdbc:postgresql://hmis-multischema-db.ct16elltavnx.us-west-2.rds.amazonaws.com"+ ":5432"+"/hmis",
	                    "hmisdb1",
	                    "hmisdb1234");
	        }
	        if (connection.isClosed()) {
	            throw new SQLException("connection could not initiated");
	        }
	        return connection;
	    }
	    
	    public static void createHiveTable(String projectGroupCode) {
	    	Connection connection;
			try {
				connection = HiveConnection.getConnection();
			 Statement stmt = connection.createStatement();
		      // execute statement
			 	StringBuilder builder = new StringBuilder();
			 	builder.append("CREATE TABLE IF NOT EXISTS ");
			 	builder.append(projectGroupCode+".active_list");
			 	builder.append("( client_id string,first_name string,last_name string,survey_id string,survey_title string,survey_date timestamp ,score bigint ");
				  String query = builder.toString();
				  query = query +")";
				  System.out.println(" Create Query::"+ query);
				  stmt.execute("DROP Table  IF EXISTS "+projectGroupCode+".active_list");
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
	     * @param survey
	     * @param score
	     */
	    public static void insertIntoHiveTable(UUID surveyId, int score,UUID clientId,String projectGroupCode) {
	    	Connection connection;
			try {
				connection = HiveConnection.getConnection();
		      // execute statement
				Survey survey = getSurveyById("survey", surveyId.toString());
				if(survey !=null && StringUtils.equals(projectGroupCode, survey.getProjectGroupCode()) ) {
					StringBuilder builder = new StringBuilder();
				 	builder.append("INSERT INTO ");
				 	String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
				 	builder.append(survey.getProjectGroupCode()+".active_list");
				 	System.out.println("Inserting records for :::"+survey.getProjectGroupCode()+"."+tableName);
					builder.append("  VALUES ( ");
					builder.append("?,?,?,?,?,?,?");
					builder.append(")");
					System.out.println("The Query:::"+builder.toString());
					Client client = getClientByID(clientId.toString());
					PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
					preparedStatement.setString(1, clientId.toString());
					preparedStatement.setString(2, client.getFirstName());
					preparedStatement.setString(3, client.getLastName());
					preparedStatement.setString(4, surveyId.toString());
					preparedStatement.setString(5, survey.getSurveyName());
					preparedStatement.setString(6,"CURRENT_TIMESTAMP");
					if(survey.getSurveyDate() !=null) {
						preparedStatement.setString(6,survey.getSurveyDate().toString());
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
		            connection = getConnection();
		            statement = connection.prepareStatement(ViewQuery.GET_ACTIVE_LIST_DATA);
		            resultSet = statement.executeQuery();
		            while(resultSet.next()) {
		                 int score = resultSet.getInt("score");
		                 UUID surveyId =(UUID) resultSet.getObject("survey_id");
		                 UUID clientId = (UUID)resultSet.getObject("client_id");
		                 insertIntoHiveTable(surveyId, score, clientId,projectGroupCode);
		            }
		        }catch (Exception ex){
		            ex.printStackTrace();
		        }
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
	    
	    public static void main(String args[]) {
	    	createHiveTable("MO0010");
	    	processActiveList("MO0010");
	    }
	
	
}
