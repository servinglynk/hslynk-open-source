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
	
<<<<<<< HEAD
	 private void syncTable(String hbaseTable, String projectGroupCode,String postgresTable) {
	       // log.info("Start sync for table: " + postgresTable);
	        HTable htable;
	        ResultSet resultSet;
	        PreparedStatement statement;
	        Connection connection;
	        try {
	            htable = new HTable(HbaseUtil.getConfiguration(), hbaseTable);
	            connection = SyncPostgresProcessor.getConnection();
	            statement = connection.prepareStatement("SELECT client_id,deleted,ignore_match_process,survey_score,date_updated FROM housing_inventory.eligible_clients where project_group_code=?");
	            statement.setString(1, projectGroupCode);
	            resultSet = statement.executeQuery();
	            
	            List<String> existingKeysInHbase = syncHBaseImport.getAllKeyRecords(htable, logger);
	            List<String> existingKeysInPostgres = new ArrayList<>();

	            List<Put> putsToUpdate = new ArrayList<>();
	            List<Put> putsToInsert = new ArrayList<>();
	            List<String> putsToDelete = new ArrayList<>();
	            while (resultSet.next()) {
	                Boolean markedForDelete = false;
	                try{
	                    resultSet.getBoolean("deleted");
	                }catch (Exception ex){
	                    logger.debug("table does not contained 'deleted' column", ex);
	                }
	                String key = resultSet.getString("client_id");
	                if(StringUtils.isBlank(key)){
	                    continue;
	                }

	                if (markedForDelete) {
	                    if (existingKeysInHbase.contains(key)) {
	                        putsToDelete.add(key);
	                        if (putsToDelete.size() > syncHBaseImport.batchSize) {
	                            syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
	                            putsToDelete.clear();
	                        }
	                    } else {
	                        log.debug("Skip row with key: " + key);
	                        continue;
	                    }
	                } else {
	                	 Put p = new Put(Bytes.toBytes(key));
	                	 addColumn("ignore_match_process",String.valueOf(resultSet.getBoolean("ignore_match_process")), key, p);
	                	 addColumn("survey_score",String.valueOf(resultSet.getInt("survey_score")), key, p);
	                	 Survey survey = getLastestSurveyByClient(key, projectGroupCode);
	                	 if(survey !=null && survey.getSurveyId() !=null) {
	                		 survey = getLastestSurveyByClientFromSectionScore(key, projectGroupCode);
	                	 }
	                	 if(survey !=null && survey.getSurveyId() !=null) {
	                		 String surveyId =  String.valueOf(survey.getSurveyId());
	                		 addColumn("survey_id",surveyId, key, p);
	                		 addColumn("survey_title",survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", " "), key, p);
	                		 addColumn("survey_date",getCreatedAtString(survey.getSurveyDate()), key, p);
	                	 }
	                	 
	                	 Client client = getClientByID(key);
	                	 if(client !=null) {
	                		 addColumn("first_name",client.getFirstName(), key, p);
		                	 addColumn("last_name",client.getLastName(), key, p);
		                	 addColumn("email",client.getEmail(),key,p);
		                	 addColumn("phone",client.getPhone(),key,p);
		                	 if(client.getDob() !=null) {
		                		 Date dob = client.getDob();
		                		 LocalDate birthday = dob.toLocalDate();
		                		 LocalDate now = LocalDate.now();
		                		 long age = birthday.until(now, ChronoUnit.YEARS);
			                	 addColumn("age",String.valueOf(age),key,p);
		                	 }
	                	 }
	                	 String notes = getNotes(key);
	                	 if(StringUtils.isNotBlank(notes)) {
	                		 addColumn("notes",notes,key,p);
	                	 }
	                	 
	                    if (existingKeysInHbase.contains(key)) {
=======
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
>>>>>>> vi-spdat-view
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
<<<<<<< HEAD
	                }
	                existingKeysInPostgres.add(key);
	            }
	            existingKeysInHbase.forEach(key -> {
	                if(!existingKeysInPostgres.contains(key)){
	                    putsToDelete.add(key);
	                }
	            });

	            logger.info("Rows to delete for table " + postgresTable + ": " + putsToDelete.size());
=======
	                existingKeysInPostgres.add(key);
	            }
	                   	           
	            logger.info("Rows to delete for table " + hbaseTable + ": " + putsToDelete.size());
>>>>>>> vi-spdat-view
	            if (putsToDelete.size() > 0) {
	                syncHBaseImport.deleteDataInBatch(htable, putsToDelete, logger);
	            }

<<<<<<< HEAD
	            logger.info("Rows to insert for table " + postgresTable + ": " + putsToInsert.size());
=======
	            logger.info("Rows to insert for table " + hbaseTable + ": " + putsToInsert.size());
>>>>>>> vi-spdat-view
	            if (putsToInsert.size() > 0) {
	                htable.put(putsToInsert);
	            }

<<<<<<< HEAD
	            logger.info("Rows to update for table " + postgresTable + ": " + putsToUpdate.size());
=======
	            logger.info("Rows to update for table " + hbaseTable + ": " + putsToUpdate.size());
>>>>>>> vi-spdat-view
	            if (putsToUpdate.size() > 0) {
	                htable.put(putsToUpdate);
	            }

	        } catch (Exception ex) {
	            logger.error("Exception:::"+ex.getMessage());
	            ex.printStackTrace();
	        }

<<<<<<< HEAD
	        log.info("Sync done for table: " + postgresTable);
	    }
	 
	 private String getNotes(String key) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			String notes =null;
			try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_NOTES);
			statement.setObject(1, UUID.fromString(key));
			resultSet = statement.executeQuery();
				while(resultSet.next()) {
					notes = (String)resultSet.getString("response_text");
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
			return notes;
	}

=======
	        log.info("Sync done for table: " + hbaseTable);
	    }
	 
>>>>>>> vi-spdat-view
	public void addColumn(String column, String value,String key,Put p) {
		 if(StringUtils.isNotBlank(value)) {
			  p.addColumn(Bytes.toBytes("CF"),
	                  Bytes.toBytes(column),
	                  Bytes.toBytes(value));
		 }
	 }
	 
<<<<<<< HEAD
	 public int getAge(java.util.Date dob) {
			    long ageInMillis =  new java.util.Date().getTime() - dob.getTime();
			    Date age = new Date(ageInMillis);
			    return age.getYear();
	 }

	 private static String getCreatedAtString(Timestamp timestamp) {
=======
	 private String getCreatedAtString(Timestamp timestamp) {
>>>>>>> vi-spdat-view
		 String pattern = "yyyy-MM-dd HH:mm:ss";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    String stringDate = format.format(timestamp);
		    return stringDate;
	}

<<<<<<< HEAD
	public static  Survey getLastestSurveyByClient(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Survey survey = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT);
		statement.setObject(1, UUID.fromString(clientId));
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String surveyId = (String)resultSet.getString("survey_id");
				survey = new Survey(projectGroupCode, UUID.fromString(surveyId) , (String)resultSet.getString("survey_title"), (Timestamp)resultSet.getTimestamp("created_at"));
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return survey;
	}
	
	public static  Survey getLastestSurveyByClientFromSectionScore(String clientId,String projectGroupCode) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Survey survey = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement(ViewQuery.GET_LASTEST_SURVEY_BY_CLIENT_FROM_SCORE);
		statement.setObject(1, UUID.fromString(clientId));
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String surveyId = (String)resultSet.getString("survey_id");
				survey = new Survey(projectGroupCode, UUID.fromString(surveyId) ,(String)resultSet.getString("survey_title") , (Timestamp)resultSet.getTimestamp("created_at"));
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return survey;
	}
	
	public static Client getClientByID(String clientId) throws Exception{
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement(ViewQuery.GET_CLIENT_BY_ID);
			statement.setObject(1, UUID.fromString(clientId));
			resultSet = statement.executeQuery();
			String firstName =  null;
			String lastName =  null;
			String email = null;
			String phoneNumber = null;
			Date dob = null;
			while(resultSet.next()) {
				firstName = resultSet.getString("first_name");
				lastName = resultSet.getString("last_name");
				email = resultSet.getString("email_address");
				phoneNumber = resultSet.getString("phone_number");
				dob = (Date) resultSet.getDate("dob");
						
			}
			Client client = new Client(UUID.fromString(clientId), firstName, lastName,phoneNumber,email,dob);
			return client;
		}catch (Exception ex){
			throw ex;
		}
	}

	public void processActiveList() {
		 FileAppender appender = new FileAppender();
         String appenderName = "active-list";
         appender.setName(appenderName);
         appender.setFile("logs/" + appenderName + ".log");
         appender.setImmediateFlush(true);
         appender.setAppend(true);
         appender.setLayout(new PatternLayout());
         appender.activateOptions();
         logger.addAppender(appender);
         String projectGroupCode ="MO0010";
         String tableName ="active_list_"+projectGroupCode;
         createHbaseTable(tableName);
         syncTable(tableName, projectGroupCode, "eligible_clients");
	}
	
    public static Survey getSurveyById(String schemaName,String surveyId) throws Exception{
=======
	 public Survey getSurveyById(String schemaName,String surveyId) throws Exception{
>>>>>>> vi-spdat-view
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
<<<<<<< HEAD
=======
	 
>>>>>>> vi-spdat-view
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
<<<<<<< HEAD
    public static List<String> getDisinctSurveys(String schemaName) throws Exception{
=======
    public List<String> getDisinctSurveys(String schemaName) throws Exception{
>>>>>>> vi-spdat-view
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
    
<<<<<<< HEAD
    public static List<Response> getResponseBySubmissionClient(String schemaName,UUID surveyId, UUID clientId) throws Exception{
        List<Response> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
=======
    public static List<Response> getResponsesForSurvey(String schemaName,UUID surveyId) throws Exception{
        List<Response> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
>>>>>>> vi-spdat-view
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement(ViewQuery.GET_CLIENTS_WITH_RESPONSE);
            statement.setObject(1, surveyId);
<<<<<<< HEAD
            statement.setObject(2, clientId);
=======
>>>>>>> vi-spdat-view
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String submissionId = resultSet.getString("submission_id");
            	String client  = resultSet.getString("client_id");
            	String questionId =  resultSet.getString("question_id");
            	String responseText = resultSet.getString("response_text");
<<<<<<< HEAD
            	Response response = new Response(submissionId, questionId, client,responseText);
=======
            	Timestamp createdAt = resultSet.getTimestamp("created_at");
            	Response response = new Response(submissionId, questionId, client,responseText,createdAt);
>>>>>>> vi-spdat-view
            	responses.add(response);
            }
        }catch (Exception ex){
            throw ex;
        }
        return responses;
    }
    
<<<<<<< HEAD
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
	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(ViSpdatView.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		ViSpdatView view = new ViSpdatView(logger);
		view.processActiveList();
=======
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
         String projectGroupCode ="MO0010";
		 Properties props = new Properties();
		 props.generatePropValues();
		 ViSpdatView view = new ViSpdatView(logger);
		 List<String> disinctSurveys = view.getDisinctSurveys("survey");
		 for(String surveyId : disinctSurveys) {
			 Survey survey = view.getSurveyById("survey", surveyId);
			 if(StringUtils.equals("MO0010",survey.getProjectGroupCode())) {
				 String tableName =survey.getSurveyName().replaceAll("[^a-zA-Z0-9]", "_").toLowerCase()+"_"+survey.getProjectGroupCode();
				 view.createHbaseTable(tableName);
				 view.processViSpdat(tableName, projectGroupCode, survey);
			 }
		}
>>>>>>> vi-spdat-view
	}

}