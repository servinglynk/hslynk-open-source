package com.servinglynk.hmis.warehouse;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.common.base.CaseFormat;

public class CreateQuestion extends Logging {
	 Logger logger = Logger.getLogger(CreateQuestion.class.getName());
	public static int batchSize = 1000;
    private static Connection connection = null;
    static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + Properties.POSTGRESQL_DB_HOST + ":" + Properties.POSTGRESQL_DB_PORT + "/" + Properties.POSTGRESQL_DB_DATABASE,
                    Properties.POSTGRESQL_DB_USERNAME,
                    Properties.POSTGRESQL_DB_PASSWORD);
        }
        if (connection.isClosed()) {
            throw new SQLException("connection could not initiated");
        }
        return connection;
    }
    
	
    public  List<String> getDistinctHmisType(String schemaName) throws Exception{
        List<String> responses = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            statement = connection.prepareStatement("select distinct name from "+schemaName+".hmis_type");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	String name = resultSet.getString(1);
            	responses.add(name);
            }
        }catch (Exception ex){
            throw ex;
        }
        return responses;
    }
    
    public  String getQuestionByName(String schemaName, String desc,boolean useLower ) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        String returnName = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            String nameQuery = useLower ? " lower(picklist_group_name) " : " picklist_group_name ";
            statement = connection.prepareStatement("select hud_question_id from "+schemaName+".question where " +nameQuery+" = ? ");
            statement.setString(1, desc.trim().toLowerCase());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	returnName = resultSet.getString(1);
            	break;
            }
        }catch (Exception ex){
            throw ex;
        }
        return returnName;
    }
    
    public  String getHmisTypeByName(String schemaName, String name,boolean useLower ) throws Exception{
        ResultSet resultSet = null;
        PreparedStatement statement = null;		
        Connection connection = null;
        String returnName = null;
        try{
            connection = SyncPostgresProcessor.getConnection();
            String nameQuery = useLower ? " lower(name) " : " name ";
            statement = connection.prepareStatement("select name from "+schemaName+".hmis_type where " +nameQuery+" = ? ");
            statement.setString(1, name.trim().toLowerCase());
            resultSet = statement.executeQuery();
            while (resultSet.next()){
            	returnName = resultSet.getString(1);
            	break;
            }
        }catch (Exception ex){
            throw ex;
        }
        return returnName;
    }
    
    public  void updateQuestion(String schemaName,String hudName,String hudId,String hudNameWithUnderscore){
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("update "+schemaName+".question set hud_question_id =?,question_description=?,display_text=? where picklist_group_name = ? and hud_question_id is null ");
            statement.setString(1,hudId);
            statement.setString(2,hudName);
            statement.setString(3,hudName);
            statement.setString(4,hudNameWithUnderscore);
            statement.executeUpdate();
        }catch (SQLException ex) {
            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);

        } finally {

            try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException ex) {
            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
            }
        }
    }

    
	  public  void insertQuestion(String schemaName,String hudName,String hudId,String dataType){
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = getConnection();
	            statement = connection.prepareStatement("insert into "+schemaName+".question (id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template)  values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            statement.setObject(1, UUID.randomUUID());
	            statement.setString(2,hudName);
	            statement.setString(3,hudName);
	            statement.setString(4,"STRING");
	            statement.setString(5,"DROPDOWN");
	            if(StringUtils.isNotBlank(dataType) && StringUtils.contains(dataType,"S")) {
	            	 statement.setString(5,"STRING");
	            }else if(StringUtils.contains(dataType,"D")) {
	            	statement.setString(5,"DATE");
	            }else if(StringUtils.contains(dataType,"T")) {
	            	statement.setString(5,"DATETIME");
	            }else if(StringUtils.contains(dataType,"M")) {
	            	statement.setString(5,"CURRENCY");
	            }
	            statement.setTimestamp(6, getCUrrentTimestamp());
	            statement.setTimestamp(7, getCUrrentTimestamp());
	            statement.setString(8, "ADMIN_USER");
	            statement.setBoolean(9, true);
	            statement.setString(10, hudName);
	            statement.setBoolean(11, false);
	            statement.setString(12,hudId);
	            statement.setString(13, "/v2017/hmistypes/"+hudName+"/values");
	            statement.executeUpdate();
	        }catch (SQLException ex) {
	            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);

	        } finally {

	            try {
	                if (statement != null) {
	                	statement.close();
	                }
	            } catch (SQLException ex) {
	            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
	            }
	        }
	    }

	 private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;
	    }
	 
	 
	 public List<String> readFile() {
		 BufferedReader br = null;
			FileReader fr = null;
			List<String> lists = new ArrayList<>();

			try {

				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader("/Users/sdolia/Desktop/datamap.txt");
				br = new BufferedReader(fr);

				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					lists.add(sCurrentLine);
				}
			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
			return lists;
	 }
	public static void main(String args[]) throws Exception {
		  Logger logger = Logger.getLogger(CreateQuestion.class.getName());
		  CreateQuestion question = new CreateQuestion();
	        Properties props = new Properties();
	        props.generatePropValues();
	        props.printProps();
	        String schemaName = "v2017";
			try {
//				List<String> distinctHmisType = question.getDistinctHmisType(schemaName);
//				for(String hmisType : distinctHmisType) {
//					question.insertQuestion(schemaName, hmisType, hmisType);
//				}
				List<String> lists = question.readFile();
				for(String line : lists) {
					if(StringUtils.isNotBlank(line)) {
						String[] split = line.split(",");
						if(StringUtils.contains(split[2].trim(),"I")) {
							String hudNameWithUnderscore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, split[1].trim());
//							
//							String hmisTypeByName = question.getHmisTypeByName(schemaName, hudNameWithUnderscore,false);
//							if(StringUtils.isBlank(hmisTypeByName)) {
//								 hmisTypeByName = question.getHmisTypeByName(schemaName, split[1].toLowerCase().trim(),true);
//							}
//							if(StringUtils.isBlank(hmisTypeByName)) {
//								 hmisTypeByName = question.getHmisTypeByName(schemaName, hudNameWithUnderscore.trim(),true);
//								 if(StringUtils.isNotBlank(hmisTypeByName)) {
//									 hmisTypeByName = question.getQuestionByName(schemaName, split[1].trim(), true);
//									 System.out.println("Fount with _ but not in question"+hudNameWithUnderscore);
//								 }
//							}
							String hudQuestionId  = question.getQuestionByName(schemaName, hudNameWithUnderscore, true);
							if(StringUtils.isBlank(hudQuestionId)) {
								hudQuestionId =  question.getHmisTypeByName(schemaName, split[1].trim(),true);
							}
							if(StringUtils.isBlank(hudQuestionId)) {
								System.out.println(" updating...:::"+ split[1].trim()+ " File value:"+split[0].trim() );
							}
							
//							if(StringUtils.isNotBlank(hudQuestionId)) {
//								String same= "NotSame";
//								if(StringUtils.equalsIgnoreCase(hudQuestionId, split[0].trim())) {
//									same = "::Same";
//								}
//						    	System.out.println(" updating...:::"+ split[1].trim()+ " DB Value ::"+hudQuestionId + " File value:"+split[0].trim() +":::"+same);
//								//question.updateQuestion(schemaName,hmisTypeByName , split[0].trim(),hudNameWithUnderscore);
//							}else {
//								System.out.println(" hmis type missing:::"+ split[1].trim());
//							}
						}
//						if(!StringUtils.contains(split[2].trim(),"I")) {
//							question.insertQuestion(schemaName, split[1].trim(), split[0].trim(),split[2].trim());
//						}
					}
				}
			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				
			}

	        
	}

}