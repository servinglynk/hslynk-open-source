package com.servinglynk.hmis.warehouse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.rest.service.DedupServiceImpl;

public class RoberTolosaResponse extends Logging {
	  final static Logger logger = Logger.getLogger(RoberTolosaResponse.class);
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
		  Logger logger = Logger.getLogger(RoberTolosaResponse.class.getName());
		  SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yy");
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
	       // Map<String, UUID> users = populateUserId();
	        Map<String, Client> clients = populateClient();
	        CSVStrategy strategy = new CSVStrategy(',', '"', '#', false, true);
		      ValueProcessorProvider vpp = new ValueProcessorProvider();
		      String fileName ="/Users/sdolia/Desktop/robert_tolosa.csv";
		      File file = new File(fileName);
		      InputStream targetStream = new FileInputStream(file);
		      BufferedReader csvFile = new BufferedReader(
		                new InputStreamReader(targetStream));
		      CSVReader<HenryNegashCsv> csvReader = new CSVReaderBuilder<HenryNegashCsv>(csvFile).strategy(strategy).entryParser(
		                      new AnnotationEntryParser<HenryNegashCsv>(HenryNegashCsv.class, vpp)).build();
		      List<HenryNegashCsv> records = csvReader.readAll(); 
				PreparedStatement statement = null;
			    connection.setAutoCommit(false);
	            statement = connection.prepareStatement("insert into survey.client_survey_submission (id,client_id,survey_id,submission_id,project_group_code,created_at,updated_at,user_id,is_active,deleted,global_enrollment_id) values (?,?,?,?,?,?,?,?,?,?,?)");
		        Connection connection = getConnection();
		      if(CollectionUtils.isNotEmpty(records)) {
				try {
		  		for(HenryNegashCsv record : records) {
		  		 	String sourceSystemId = record.getSourceSystemId();
		          	String firstName = record.getFirstName();
		          	String lastName =  record.getLastName();
		          	String serviceCategory = record.getServiceCategory();
		          	String effortValue = record.getServiceValue();
		         //  	System.out.println(record.toString());
		          	if(!Character.isLetter(effortValue.charAt(0)) || !Character.isDigit(effortValue.charAt(1))) {
		          		throw new Exception("Efforvalue incorrect"+effortValue);
		          	}
//		          	try {
		          		if(!Character.isLetter(serviceCategory.charAt(0))) {
			          		throw new Exception("serviceCategory incorrect"+serviceCategory);
			          	}
//		          	}catch(StringIndexOutOfBoundsException e) {
//		          		System.out.println(" SSI"+record.getSourceSystemId() +" :" + record.getFirstName() + " : "+record.getLastName() +" count : "+count );
//		          	}
		         	count++;
		         	
		  		    UUID userId  = UUID.fromString(""); //specific userid 
		  		  if(userId == null) {
			  			throw new Exception("UserId incorrect"+userId);
			  		}
		          	String key =firstName+"-"+lastName;
		          	Client client = clients.get(key);
		          	UUID submissionId = UUID.randomUUID();
		  			String interalExternal = record.getInternalExtertnal();
		  			String timeInterval = record.getTime();
		  		    java.util.Date date = sdf1.parse(record.getContactDate());
		  		    java.sql.Date effectiveDate = new java.sql.Date(date.getTime());
		  		    
		  			if(client == null) {
		  					System.out.println("Client WAS NULL FOR "+ firstName + " :"+ lastName+ "record number"+ count);
		  					client = createClient(firstName, lastName, null,sourceSystemId,userId);
		  					clients.put(key, client);
		  			}
		  			}
		  		System.out.println(records.size());
		      } catch(Exception e) {
		    	  e.printStackTrace();
		      }
				
		      }
		      try {
	                if (statement != null) {
	                	statement.executeBatch(); // insert remaining records
	                	connection.commit();
	                	connection.setAutoCommit(true);
	                	statement.close();
	                	connection.close();
	                }
	            } catch (SQLException ex) {
	            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
	            }
		      System.out.println("Program completed.......$$$$$$$$$$$$$$");
	}

	 private static Client createClient(String firstName,String lastName,String ssn,String sourceSystemId,UUID userId) {
		 //Call Open EMPI
		      DedupServiceImpl  impl = new DedupServiceImpl();
		      Person person = new Person();
		      person.setGivenName(firstName);
		      person.setFamilyName(lastName);
		    //  person.setSsn(ssn);
		      Person dedupingLogic = impl.dedupingLogic(person, "SOME_KEY");
		      String dedupId = dedupingLogic.getCustom20();
		      UUID id = UUID.randomUUID();
		      Client client = new Client(id, UUID.fromString(dedupId));
		 // Create Client Base schemeen
		        System.out.println(" Dedup ID:::: for FirstName:"+firstName+ " Dedup: "+ dedupId);
		      
		        createBaseClient(id, client, userId, firstName, lastName, ssn,sourceSystemId);
		        createV2017Client(id, client, userId, firstName, lastName, ssn, sourceSystemId);
		 // Create client version schema
		 return  client;
	 }

	private static void createBaseClient(UUID id, Client client, UUID userId,String firstName,String lastName,String ssn,String sourceSystemId) {
		PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            		
            StringBuilder builder = new StringBuilder();
            builder.append(" insert into base.client ");
            builder.append(" (id,dedup_client_id,first_name,last_name,project_group_code,date_created,date_updated,user_id,deleted,schema_year,source_system_id,ssn,version) " );
            builder.append("values (?,?,?,?,?,?,?,?,?,?,?,ssn_encrypt(?),?) ");
            statement = connection.prepareStatement(builder.toString());
            statement.setObject(1,id);
            statement.setObject(2,client.getDedupClientId()); // Get ClientID from FN and LN
            statement.setString(3,firstName);
            statement.setString(4,lastName);
            statement.setString(5,"PROJ_GRP");
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setTimestamp(7, getCUrrentTimestamp());
            statement.setObject(8, UUID.fromString(""));
            statement.setBoolean(9, false);
            statement.setString(10, "2017");
            statement.setString(11, sourceSystemId);
            statement.setString(12, ssn);
            statement.setInt(13, 3);
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

	private static void createV2017Client(UUID id, Client client, UUID userId,String firstName,String lastName,String ssn,String sourceSystemId) {
		PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            		
            StringBuilder builder = new StringBuilder();
            builder.append(" insert into v2017.client ");
            builder.append(" (id,dedup_client_id,first_name,last_name,project_group_code,date_created,date_updated,user_id,deleted,source_system_id,ssn,version) " );
            builder.append(" values (?,?,?,?,?,?,?,?,?,?,ssn_encrypt(?),?) ");
            statement = connection.prepareStatement(builder.toString());
            statement.setObject(1,id);
            statement.setObject(2,client.getDedupClientId()); // Get ClientID from FN and LN
            statement.setString(3,firstName);
            statement.setString(4,lastName);
            statement.setString(5,"PROJ_GRP");
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setTimestamp(7, getCUrrentTimestamp());
            statement.setObject(8, UUID.fromString(""));
            statement.setBoolean(9, false);
            statement.setString(10, sourceSystemId);
            statement.setString(11, ssn);
            statement.setInt(12, 3);
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
	
	private static void hydrateResponseTable(UUID clientId, UUID userId, UUID submissionId,String responstText,Date effectiveDate,String questionId,UUID dedupClientId,Long count) {
		PreparedStatement statement = null;
        Connection connection = null;
        try{
            connection = getConnection();
            		
            StringBuilder builder = new StringBuilder();
            builder.append(" insert into survey.response ");
            builder.append(" (id,response_text,question_score,effective_date,created_at,updated_at,is_active,section_id,question_id,client_id,survey_id,refused,submission_id,client_link,deleted,project_group_code,client_dedup_id,user_id) " );
            builder.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            statement = connection.prepareStatement(builder.toString());
            statement.setObject(1,UUID.randomUUID());
            statement.setString(2,responstText); // Get ClientID from FN and LN
            statement.setInt(3,0);
            statement.setDate(4,effectiveDate);
            statement.setTimestamp(5, getCUrrentTimestamp());
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setBoolean(7, true);
            statement.setObject(8,UUID.fromString(""));
            statement.setObject(9, UUID.fromString(questionId));
            statement.setObject(10, clientId);
            statement.setObject(11, UUID.fromString(""));
            statement.setBoolean(12, false);
            statement.setObject(13, submissionId);
            statement.setString(14, "/hmis-clientapi/rest/v2017/clients/"+clientId.toString());
            statement.setBoolean(15, false);
            statement.setString(16,"PROJ_GRP");
            statement.setObject(17, dedupClientId);
            statement.setObject(18, userId);
            statement.addBatch();
    		if(count % batchSize == 0) {
    			statement.executeBatch();
  			}
        }catch (Exception ex) {
            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
        }
        finally {
        	try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException ex) {
            	logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
            }
        }
    	
	}

	private static Map<String,Client> populateClient() {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Map<String,Client> clientsMaps = new HashMap<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select id,dedup_client_id,lower(first_name),lower(last_name) from base.client where project_group_code='PROJ_GRP' ");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
				UUID id = (UUID) resultSet.getObject("id");
				UUID dedupClientId = (UUID) resultSet.getObject("dedup_client_id");
				Client client = new  Client(id,dedupClientId);
				String firstName = resultSet.getString(3);
				String lastName = resultSet.getString(4);
				clientsMaps.put(firstName+"-"+lastName, client);
			}
        }catch (Exception ex){
            logger.error(" Error getting hmis_user for firstName  ",ex);
        }
		return clientsMaps;
	}

	  private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;
	    }
	  
	 public static void hydrateClientSurveySubmission(UUID clientId,UUID userId,UUID submissionId){
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = getConnection();
	            statement = connection.prepareStatement("insert into survey.client_survey_submission (id,client_id,survey_id,submission_id,project_group_code,created_at,updated_at,user_id,is_active,deleted) values (?,?,?,?,?,?,?,?,?,?)");
	            statement.setObject(1,UUID.randomUUID());
	            statement.setObject(2,clientId); // Get ClientID from FN and LN
	            statement.setObject(3,UUID.fromString(""));
	            statement.setObject(4,submissionId);
	            statement.setString(5,"PROJ_GRP");
	            statement.setTimestamp(6, getCUrrentTimestamp());
	            statement.setTimestamp(7, getCUrrentTimestamp());
	            statement.setObject(8,userId);
	            statement.setBoolean(9, true);
	            statement.setBoolean(10, false);
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

	private static Map<String,UUID> populateUserId() {
			Map<String,UUID> usersIdsMap = new HashMap<>();
			UUID id = null;
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        try{
	            connection = getConnection();
	            statement = connection.prepareStatement("select id,lower(first_name),lower(last_name) from base.hmis_user where project_group_code='PROJ_GRP'");
	            resultSet = statement.executeQuery();
	            while (resultSet.next()){
	            	String firstName = resultSet.getString(2);
	            	String lastName = resultSet.getString(3);
	            	id = (UUID)resultSet.getObject("id");
	            	usersIdsMap.put(firstName+"-"+lastName, id);
	            }
	        }catch (Exception ex){
	            logger.error(" Error getting hmis_user for firstName ",ex);
	        }
	        return usersIdsMap;
	}

}


