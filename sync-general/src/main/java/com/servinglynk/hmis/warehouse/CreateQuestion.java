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
						if(!StringUtils.contains(split[2].trim(),"I")) {
							question.insertQuestion(schemaName, split[1].trim(), split[0].trim(),split[2].trim());
						}
					}
				}
			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				
			}

	        
	}

}