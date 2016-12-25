package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ViewQuery;
public class SurveyView {	
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
    
    public static void createHiveTableForSurvey() throws Exception {
    	// Get distinct questions for a survey.
    	List<String> disinctSurveys = getDisinctSurveys("survey");
    	for(String surveyId : disinctSurveys) {
    		List<String> disinctQuestions = getDisinctQuestions("survey", UUID.fromString(surveyId));
    		System.out.println("Quesitons for survey ::"+surveyId+ "  are ::"+disinctQuestions.toString());
    		// Get the Survey details from the survey table and project group code in the survey 
    		Survey survey = getSurveyById("survey", surveyId);
    		// TODO: Below items
        	// table is the hive database where this hive table needs to be created.
    		createHiveTable(survey, disinctQuestions);
        	//  create a hive table after getting the questions.    	
        	//Insert the data into the view by clientIds and submission id.
    		List<Response>  responses = getResponseBySubmissionClient("survey", UUID.fromString(surveyId));
    		insertIntoHiveTable(survey,disinctQuestions, responses);	
    	}
    }
    
    public static void insertIntoHiveTable(Survey survey, List<String> disinctQuestions, List<Response>  responses) {
    	Connection connection;
		try {
			connection = HiveConnection.getConnection();
		 Statement stmt = connection.createStatement();
	      // execute statement
		 String clientId = null;
		 int i = 4;
		 for (Response response : responses) {
			 	
				StringBuilder builder = new StringBuilder();
			 	builder.append("INSERT INTO ");
			 	String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
			 	builder.append(survey.getProjectGroupCode()+"."+tableName);
			 	builder.append("( client_id , survey_date , submission_id  ");
				  for(String question : disinctQuestions) {
					  question = question.replaceAll("[^a-zA-Z0-9]", "_");
					  builder.append(","+question);
	    		  }
				  builder.append(" VALUES ");
				  builder.append(" ?, ?, ?");
				  for(String question : disinctQuestions) {
					  builder.append(",?");  
				  }
				  builder.append(")");
				  PreparedStatement preparedStatement = connection.prepareStatement(builder.toString());
				  preparedStatement.setString(1, response.getClientId());
				  preparedStatement.setDate(2, survey.getSurveyDate());
				  preparedStatement.setString(3, response.getSubmissionId());
				  preparedStatement.setString(i++, response.getResponseText());
				  // execute insert SQL stetement
				  if(StringUtils.isNotBlank(clientId) && !StringUtils.equals(clientId, response.getClientId())) {
					  preparedStatement .executeUpdate();
					  i =4;
				  }
				  clientId = response.getClientId();
		 }
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
    }
    public static void createHiveTable(Survey survey, List<String> disinctQuestions) {
    	Connection connection;
		try {
			connection = HiveConnection.getConnection();
		 Statement stmt = connection.createStatement();
	      // execute statement
		 	StringBuilder builder = new StringBuilder();
		 	builder.append("CREATE TABLE IF NOT EXISTS ");
		 	String tableName  = survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_");
		 	builder.append(survey.getProjectGroupCode()+"."+tableName);
		 	builder.append("( client_id string, survey_date date , submission_id string, ");
			  for(String question : disinctQuestions) {
				  question = question.replaceAll("[^a-zA-Z0-9]", "_");
				  builder.append(question +" string,");
    		  }
			  String query = builder.toString();
			  query = query.substring(0,query.length() - 1);
			  query = query +")";
	      stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    public static List<String> getDisinctSurveys(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_DISTINCT_SURVEY);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                tables.add(resultSet.getString("survey_id"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }
    
    public static List<Response> getResponseBySubmissionClient(String schemaName,UUID surveyId) throws Exception{
        List<Response> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_CLIENTS_WITH_RESPONSE);
            statement.setObject(1, surveyId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String submissionId = resultSet.getString("submission_id");
            	String questionId = resultSet.getString("client_id");
            	String clientId =  resultSet.getString("question_id");
            	String responseText = resultSet.getString("response_text");
            	Response response = new Response(submissionId, questionId, clientId,responseText);
            	responses.add(response);
            }
        }catch (Exception ex){
            throw ex;
        }
        return responses;
    }
    
    public static List<String> getDisinctQuestions(String schemaName,UUID surveyId) throws Exception{
        List<String> questions = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_DISTINCT_QUESTIONS_FOR_SURVEY);
            statement.setObject(1, surveyId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	questions.add(resultSet.getString("question_id"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return questions;
    }
    
    public static void main(String args[]) throws Exception {
    	createHiveTableForSurvey();
    }

}
