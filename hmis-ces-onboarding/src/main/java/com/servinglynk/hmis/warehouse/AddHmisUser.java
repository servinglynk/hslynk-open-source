package com.servinglynk.hmis.warehouse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

public class AddHmisUser extends Logging {
	  final static Logger logger = Logger.getLogger(AddHmisUser.class);
		
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
    

   
    					
    					
    					
    					
	public static List<String> getAllTablesFromPostgres(String schemaName) throws Exception{
        List<String> tables = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            statement = connection.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='"+schemaName+"'");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                tables.add(resultSet.getString("table_name"));
            }

        }catch (Exception ex){
            throw ex;
        }
        return tables;
    }
	
	
	public static void main(String args[]) throws Exception {
		Long count =0L;
		  Logger logger = Logger.getLogger(AddHmisUser.class.getName());
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
		List<String> users = readFile();
		for(String user : users) {
				hydrateDBTable("base", user);
		}
		System.out.println(users.size());
	}
	
	public static List<String> readFile() throws IOException {
	    List<String> lines = Collections.emptyList(); 
	      lines = 
	       Files.readAllLines(Paths.get("/Users/sdolia/Desktop/active.csv"), StandardCharsets.UTF_8); 
	      return lines;
	}
	
	  private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;
	    }
	 public static void hydrateDBTable(String schemaName,String user){
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	        	String[] split = user.split(",");
	        	String lastName = split[0].toLowerCase().trim();
	        	String firstName = split[1].toLowerCase().trim();
	        	String username = split[2].toLowerCase().trim();
	        	String hiveUserName = username.replaceAll("[^a-zA-Z0-9]", "3");
	        	System.out.println(firstName +" : "+lastName+" : "+username+" : "+hiveUserName);
	            connection = getConnection();
	            statement = connection.prepareStatement("insert into base.hmis_user (id,first_name,last_name,is_user_in_hive,profile_id,email_address,password,status,username,project_group_id,project_group_code,date_created,date_updated,created_by,hive_username,hive_password,two_factor_authentication)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            statement.setObject(1,UUID.randomUUID());
	            statement.setString(2,firstName);
	            statement.setString(3,lastName);
	            statement.setBoolean(4,true);
	            statement.setObject(5,UUID.fromString("SOME UUID")); // Populate the correct ID
	            statement.setString(6,username);
	            statement.setString(7, UUID.randomUUID().toString()); //Need to change
	            statement.setString(8, "ACTIVE");
	            statement.setString(9, username);
	            statement.setObject(10, UUID.fromString("")); // Populate the correctID
	            statement.setString(11, "CORRECT_PROIECT_GRPOUP"); //Populate correct project group.
	            statement.setTimestamp(12, getCUrrentTimestamp());
	            statement.setTimestamp(13, getCUrrentTimestamp());
	            statement.setString(14, "CORRECT_USER"); //Correct USER
	            statement.setString(15, hiveUserName);
	            statement.setString(16, "SOME PASS"); // Tobe populated.
	            statement.setBoolean(17, false);
	            statement.executeUpdate();
	        }catch (Exception ex) {
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
	 

}


