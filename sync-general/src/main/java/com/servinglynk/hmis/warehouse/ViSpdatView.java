package com.servinglynk.hmis.warehouse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class ViSpdatView  extends Logging {

	 private SyncHBaseProcessor syncHBaseImport;
	 private Logger logger;
	 
	 public ViSpdatView(Logger logger) throws Exception {
	        this.logger = logger;
	        this.syncHBaseImport = new SyncHBaseProcessor();
	    }
	 
	public void createHbaseTable(String tableName) {
		syncHBaseImport.createHBASETable(tableName, logger);
	}
	
	 private void processViSpdat(String hbaseTable, String projectGroupCode,Survey survey) {
	       // log.info("Start sync for table: " + postgresTable);
	        HTable htable;
	        try {
	            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
	            List<Response> responsesForSurvey = getResponsesForSurvey("survey", survey.getSurveyId());
	            List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
	            List<String> existingKeysInPostgres = new ArrayList<>();
	            
	            List<Put> putsToUpdate = new ArrayList<>();
	            List<Put> putsToInsert = new ArrayList<>();
	            List<String> putsToDelete = new ArrayList<>();
	            String key = "";
	            Put p = null;
	            for(Response response : responsesForSurvey) {
	            	if(StringUtils.isBlank(key)) {
	            		 p = new Put(Bytes.toBytes(response.getSubmissionId()));
	            	}
	            	if(!StringUtils.equals(key, response.getSubmissionId()) && StringUtils.isNotBlank(key)) {
	            		p = new Put(Bytes.toBytes(key));
	            		addColumn("client_id",String.valueOf(response.getClientId()), key, p);
	            		addColumn("survey_id",String.valueOf(survey.getSurveyId()), key, p);
	            		addColumn("survey_date",getCreatedAtString(response.getSurveyResponseDate()), key, p);
	            		  if(p != null) {
	     	            	 if (existingKeysInHbase.contains(key)) {
	     	                        putsToUpdate.add(p);
	     	                        if (putsToUpdate.size() > syncHBaseImport.batchSize) {
	     	                            htable.put(putsToUpdate);
	     	                            putsToUpdate.clear();
	     	                        }
	     	                    } else {
	     	                        putsToInsert.add(p);
	     	                        if (putsToInsert.size() > syncHBaseImport.batchSize) {
	     	                            htable.put(putsToInsert);
	     	                            putsToInsert.clear();
	     	                        }
	     	                    }
	     	                existingKeysInPostgres.add(key);
	     	            }
	            	}
	            	 key = response.getSubmissionId();
	            	 addColumn(response.getQuestionId(),String.valueOf(response.getResponseText()), key, p);
	            }
	            if(p != null) {
	            	 if (existingKeysInHbase.contains(key)) {
	                        putsToUpdate.add(p);
	                        if (putsToUpdate.size() > syncHBaseImport.batchSize) {
	                            htable.put(putsToUpdate);
	                            putsToUpdate.clear();
	                        }
	                    } else {
	                        putsToInsert.add(p);
	                        if (putsToInsert.size() > syncHBaseImport.batchSize) {
	                            htable.put(putsToInsert);
	                            putsToInsert.clear();
	                        }
	                    }
	                existingKeysInPostgres.add(key);
	            }
	                   	           
	            logger.info("Rows to delete for table " + hbaseTable + ": " + putsToDelete.size());
	            if (putsToDelete.size() > 0) {
	                syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
	            }

	            logger.info("Rows to insert for table " + hbaseTable + ": " + putsToInsert.size());
	            if (putsToInsert.size() > 0) {
	                htable.put(putsToInsert);
	            }

	            logger.info("Rows to update for table " + hbaseTable + ": " + putsToUpdate.size());
	            if (putsToUpdate.size() > 0) {
	                htable.put(putsToUpdate);
	            }

	        } catch (Exception ex) {
	            logger.error("Exception:::"+ex.getMessage());
	            ex.printStackTrace();
	        }

	        log.info("Sync done for table: " + hbaseTable);
	    }
	 
	public void addColumn(String column, String value,String key,Put p) {
		 if(StringUtils.isNotBlank(value)) {
			  p.addColumn(Bytes.toBytes("CF"),
	                  Bytes.toBytes(column),
	                  Bytes.toBytes(value));
		 }
	 }
	 
	 private String getCreatedAtString(Timestamp timestamp) {
		 String pattern = "yyyy-MM-dd HH:mm:ss";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    String stringDate = format.format(timestamp);
		    return stringDate;
	}

	 public Survey getSurveyById(String schemaName,String surveyId) throws Exception{
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
    public List<String> getDisinctSurveys(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
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
    
    public static List<Response> getResponsesForSurvey(String schemaName,UUID surveyId) throws Exception{
        List<Response> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_CLIENTS_WITH_RESPONSE);
            statement.setObject(1, surveyId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String submissionId = resultSet.getString("submission_id");
            	String client  = resultSet.getString("client_id");
            	String questionId =  resultSet.getString("question_id");
            	String responseText = resultSet.getString("response_text");
            	Timestamp createdAt = resultSet.getTimestamp("created_at");
            	Response response = new Response(submissionId, questionId, client,responseText,createdAt);
            	responses.add(response);
            }
        }catch (Exception ex){
            throw ex;
        }
        return responses;
    }
    
	public static void main(String args[]) throws Exception {
		 Logger logger = Logger.getLogger(ViSpdatView.class.getName());
		 FileAppender appender = new FileAppender();
         String appenderName = "active-list";
         appender.setName(appenderName);
         appender.setFile("logs/" + appenderName + ".log");
         appender.setImmediateFlush(true);
         appender.setAppend(true);
         appender.setLayout(new PatternLayout());
         appender.activateOptions();
         logger.addAppender(appender);
		 Properties props = new Properties();
		 props.generatePropValues();
		 String projectGroupCodes = Properties.PROJECT_GROUP_CODE;
		 String[] split = projectGroupCodes.split(",");
		 List<String> projectGroups = new ArrayList<>(Arrays.asList(split));
		 for(String projectGroupCode : projectGroups) {
			 ViSpdatView view = new ViSpdatView(logger);
			 List<String> disinctSurveys = view.getDisinctSurveys("survey");
			 for(String surveyId : disinctSurveys) {
				 Survey survey = view.getSurveyById("survey", surveyId);
			     String tableName =survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_").toLowerCase()+"_"+survey.getProjectGroupCode();
			     view.createHbaseTable(tableName);
				 view.processViSpdat(tableName, projectGroupCode, survey);
			  }
			}
		 }
}