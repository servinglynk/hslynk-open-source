package com.servinglynk.servey.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    	}
    	//  create a hive table after getting the questions.
    	
    	//Insert the data into the view by clientIds and submission id.
    	
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
