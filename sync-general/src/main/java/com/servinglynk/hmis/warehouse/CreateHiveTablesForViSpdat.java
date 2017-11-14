package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class CreateHiveTablesForViSpdat {
	
	 public static List<String> getDisinctQuestions(String schemaName,UUID surveyId) throws Exception{
	        List<String> questions = new ArrayList<>();
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = SyncPostgresProcessor.getConnection();
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
	 
	    public static Set<String> getDisinctSurveys(String schemaName) throws Exception{
	        Set<String> tables = new HashSet<>();
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = SyncPostgresProcessor.getConnection();
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
	    
	    public static Survey getSurveyById(String schemaName,String surveyId) throws Exception{
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = SyncPostgresProcessor.getConnection();
	            statement = connection.prepareStatement(ViewQuery.GET_SURVEY_BY_ID);
	            statement.setObject(1, UUID.fromString(surveyId));
	            resultSet = statement.executeQuery();
	            String projectGroupCode = null;
	            String surveyName =  null;
	            Timestamp createdDate =  null;
	            while(resultSet.next()) {
	                 projectGroupCode = resultSet.getString("project_group_code");
	                 surveyName = resultSet.getString("survey_title");
	                 createdDate = resultSet.getTimestamp("created_at");
	            }
	            Survey survey = new Survey(projectGroupCode,UUID.fromString(surveyId) , surveyName, createdDate);
	            return survey;
	        }catch (Exception ex){
	            throw ex;
	        }
	    }
	    
	    public static String getQuestionDisplayTextByQuestionID(String schemaName,UUID questionId) throws Exception{
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = SyncPostgresProcessor.getConnection();
	            statement = connection.prepareStatement(ViewQuery.GET_DISPLAY_TEXT_FROM_QUESTION);
	            statement.setObject(1, questionId);
	            resultSet = statement.executeQuery();
	            while (resultSet.next()){
	               return (String)resultSet.getString("display_text");
	            }

	        }catch (Exception ex){
	            throw ex;
	        }
	        return null;
	    }
	 
	public static void main(String args[]) throws Exception {
		 Properties props = new Properties();
		 props.generatePropValues();
		 Set<String> disinctSurveys = getDisinctSurveys("survey");
		 for(String surveyId : disinctSurveys) {
			 Survey survey = getSurveyById("survey", surveyId);
			 if(StringUtils.equals("MO0010",survey.getProjectGroupCode())) {
				 StringBuilder builder = new StringBuilder();
				 builder.append("CREATE EXTERNAL TABLE IF NOT EXISTS new_"+survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_").toLowerCase());
				 builder.append("(submission_id string,client_id string,survey_date  timestamp ");
				 List<String> disinctQuestions = getDisinctQuestions("survey", survey.getSurveyId());
				 for(String questionId : disinctQuestions) {
					  String displayText = getQuestionDisplayTextByQuestionID("survey", UUID.fromString(questionId));
						if(StringUtils.isNotBlank(displayText)) {
							String columnName = displayText;
							if(displayText.length() > 100) {
								columnName = displayText.substring(0,100);
							}
							columnName = columnName.replaceAll("[^a-zA-Z0-9]", "_");
							columnName = columnName.replaceAll(" ", "_");
							builder.append(" ,q_"+columnName+" string ");
						}
				 }
				 builder.append(")");
				 builder.append("STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES");
				 builder.append("(\"hbase.columns.mapping\" = \"");
				 builder.append(":key,CF:client_id,CF:survey_date");
				 for(String questionId : disinctQuestions) {
					 builder.append(",CF:"+questionId);
				 }
				 String tableName =survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_").toLowerCase()+"_"+survey.getProjectGroupCode();
				 builder.append("\") TBLPROPERTIES (\"hbase.table.name\" = \""+tableName+"\");");
				 System.out.println(builder.toString());
			 }
	     }
	}
}
