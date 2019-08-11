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
import java.util.Collections;
import java.util.Comparator;
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

public class EffortData extends Logging {
	  final static Logger logger = Logger.getLogger(EffortData.class);
		static Map<String,String> categories = new HashMap<>();
		static {
			addCrossWalkCategories();
		}
		static Long count =0L;
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
    
    public static void addCrossWalkCategories() {
    	categories.put("A1", "A1");
    	categories.put("B1", "B1");
      	categories.put("B1", "B1");
      	categories.put("B2", "B1");
      	categories.put("B3", "B3");
      	categories.put("B4","B2");	
      	categories.put("B5","B3");
      	categories.put("B6","B4");
      	categories.put("B7","B5");
      	categories.put("B8","B6");
      	categories.put("B9","B7");
      	categories.put("C1","C1");
      	categories.put("C2","C1");
      	categories.put("C3","C2");
      	categories.put("C4","C2");
      	categories.put("C5","C3");
      	categories.put("C6","C3");
      	categories.put("C7","C4");
      	categories.put("C8","C5");
      	categories.put("C9","C5");
      	categories.put("D1","D1");
      	categories.put("D2","D1");
      	categories.put("D3","D2");
      	categories.put("D4","N3");
      	categories.put("D5","D3");
      	categories.put("D6","D3");
      	categories.put("D7","D3");
      	categories.put("D8","D3");
      	categories.put("D9","D4");
      	categories.put("D10","D4");
      	categories.put("D11","D1");
      	categories.put("D12","D4");
      	categories.put("D13","D5");
      	categories.put("E1","B7");
      	categories.put("E2","E1");
      	categories.put("E3","E7");	
      	categories.put("E4","E7");
      	categories.put("E5","E2");
      	categories.put("E6","E2");	
      	categories.put("E7","E3");
      	categories.put("E8","E3");
      	categories.put("E9","N3");	
      	categories.put("E10","E6");	
      	categories.put("E11","E6");	
      	categories.put("E12","E4");	
      	categories.put("E13","E4");	
      	categories.put("E14","E5");	
      	categories.put("E15","E5");	
      	categories.put("F1","C2");	
      	categories.put("F2","N3");	
      	categories.put("F3","F1");	
      	categories.put("F4","N3");	
      	categories.put("F5","F2");	
      	categories.put("F6","G3");	
      	categories.put("G1","G1");	
      	categories.put("G2","G2");	
      	categories.put("G3","N3");	
      	categories.put("G4","N3");	
      	categories.put("G5","G5");	
      	categories.put("G6","G5");	
      	categories.put("G7","G3");	
      	categories.put("G8","G3");	
      	categories.put("G9","G4");	
      	categories.put("G10","N3");	
      	categories.put("H1","H1");	
      	categories.put("H2","H2");	
      	categories.put("H3","H2");	
      	categories.put("J1","J2");
      	categories.put("J2","N3");	
      	categories.put("J3","N3");	
      	categories.put("J4","N3");	
      	categories.put("J5","N3");	
      	categories.put("J6","J3");	
      	categories.put("L1","N3");	
      	categories.put("L2","L2");	
      	categories.put("L3","L1");	
      	categories.put("L4","L1");	
      	categories.put("L5","L3");	
      	categories.put("M1","M1");
      	categories.put("N1","N1");
      	categories.put("N2","N2");
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
		  Logger logger = Logger.getLogger(EffortData.class.getName());
		  SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yy");
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
	        Map<UUID, List<UUID>> clientSubmissions = populateSubmissions();
	        Map<String, UUID> users = populateUserId();
	        Map<String, Client> clients = populateClient();
	        CSVStrategy strategy = new CSVStrategy(',', '"', '#', false, true);
		      ValueProcessorProvider vpp = new ValueProcessorProvider();
		      String fileName ="/Users/sdolia/Desktop/effort_data.csv";
		      File file = new File(fileName);
		      InputStream targetStream = new FileInputStream(file);
		      BufferedReader csvFile = new BufferedReader(
		                new InputStreamReader(targetStream));
		      CSVReader<EffortCsv> csvReader = new CSVReaderBuilder<EffortCsv>(csvFile).strategy(strategy).entryParser(
		                      new AnnotationEntryParser<EffortCsv>(EffortCsv.class, vpp)).build();
		      List<EffortCsv> records = csvReader.readAll(); 
				PreparedStatement statement = null;
		        Connection connection = getConnection();
		        connection.setAutoCommit(false);
		        StringBuilder builder = new StringBuilder();
	            builder.append(" insert into survey.response ");
	            builder.append(" (id,response_text,question_score,effective_date,created_at,updated_at,is_active,section_id,question_id,client_id,survey_id,refused,submission_id,client_link,deleted,project_group_code,client_dedup_id,user_id) " );
	            builder.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            statement = connection.prepareStatement(builder.toString());
		      if(CollectionUtils.isNotEmpty(records)) {
		    	  Comparator<EffortCsv> byName = 
		    				(EffortCsv o1, EffortCsv o2)->o1.getSourceSystemId().compareTo(o2.getSourceSystemId());
				try {
					Collections.sort(records, byName);
		  		for(EffortCsv record : records) {
		  		 	String sourceSystemId = record.getSourceSystemId();
		          	String firstName = record.getFirstName();
		          	String lastName =  record.getLastName();
		          	String ssn =  record.getSsn();
		          	String effortName = record.getEffortName(); // SRHT - D Drug/Alcohol Services
		          	String serviceCategory = getServiceCategory(effortName);
		          	String staffingAgent = record.getStaffingAgent();
		          	String[] userNameSplit = staffingAgent.split(",");
		          	String staffingAgentLastName = userNameSplit[0].trim();
		          	String staffingAgentFirstName = userNameSplit[1].trim();
		          	String effortValue = record.getEffortValue();
		           
		          	if(!Character.isLetter(effortValue.charAt(0)) || !Character.isDigit(effortValue.charAt(1))) {
		          		throw new Exception("Efforvalue incorrect"+effortValue);
		          	}
		         	if(!Character.isLetter(serviceCategory.charAt(0))) {
		          		throw new Exception("serviceCategory incorrect"+serviceCategory);
		          	}
		         	
		  		    UUID userId = users.get(staffingAgentFirstName+"-"+staffingAgentLastName);
		  		  if(userId == null) {
			  			throw new Exception("UserId incorrect"+userId);
			  		}
		          	String key =firstName+"-"+lastName;
		          	Client client = clients.get(key);
		          	List<UUID> submissions = clientSubmissions.get(client.getClientId());
		          	
		  			if(StringUtils.isNotBlank(effortValue)) {
		  				String value = categories.get(effortValue);
		  				if(StringUtils.isNotBlank(value)) {
		  					effortValue = value;
		  				}
		  			}
		  			//System.out.println(record.toString());
		  			UUID submissionId = submissions.iterator().next();
		  			String interalExternal = record.getInternalExternal();
		  			String timeInterval = record.getTime();
		  		    java.util.Date date = sdf1.parse(record.getDateContacted());
		  		    java.sql.Date effectiveDate = new java.sql.Date(date.getTime());
		  		    
		  			if(StringUtils.isNotBlank(serviceCategory)) {
		  				hydrateResponseTable(client.getClientId(),userId,submissionId,serviceCategory,effectiveDate,"CORRECT_UUID_FOR_QUESTION",client.getDedupClientId(),connection,statement);
		  			}
		  			if(StringUtils.isNotBlank(effortValue)) {
		  				hydrateResponseTable(client.getClientId(),userId,submissionId,effortValue,effectiveDate,"CORRECT_UUID_FOR_QUESTION",client.getDedupClientId(),connection,statement);
		  			}
		  			if(StringUtils.isNotBlank(interalExternal)) {
		  				hydrateResponseTable(client.getClientId(),userId,submissionId,interalExternal,effectiveDate,"CORRECT_UUID_FOR_QUESTION",client.getDedupClientId(),connection,statement);
		  			}
		  			if(StringUtils.isNotBlank(timeInterval))  {
		  				hydrateResponseTable(client.getClientId(),userId,submissionId,timeInterval,effectiveDate,"CORRECT_UUID_FOR_QUESTION",client.getDedupClientId(),connection,statement);
		  			}
		  			hydrateResponseTable(client.getClientId(),userId,submissionId,"migrated_data",effectiveDate,"CORRECT_UUID_FOR_QUESTION",client.getDedupClientId(),connection,statement);
		  			submissions.remove(submissionId);
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
		      person.setSsn(ssn);
		      Person dedupingLogic = impl.dedupingLogic(person, "CORRECT_KEY");
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

	private static String getServiceCategory(String effortName) {
		String finalValue = "";
		if(!StringUtils.isEmpty(effortName)) {
			String[] split = effortName.split("-");
			String string = split[1];
			for(int i=0 ;i <= string.length();i++) {
				if(Character.isLetter(string.charAt(i))) {
					finalValue = String.valueOf(string.charAt(i));
					break;
				}
			}
			return finalValue;
		}
		return null;
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
            statement.setString(5,"CORRECT_PROJECT_GROUP");
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setTimestamp(7, getCUrrentTimestamp());
            statement.setObject(8, UUID.fromString(" "));
            statement.setBoolean(9, false);
            statement.setString(10, "CORRECT_YEAR");
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
            statement.setString(5,"CORRECT_PROJECT_GROUP_CODE");
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
	
	public static void hydrateResponseTable(UUID clientId, UUID userId, UUID submissionId,String responstText,Date effectiveDate,String questionId,UUID dedupClientId,Connection connection, PreparedStatement statement) {
        try{
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
            statement.setString(16,"CORRECT_PROJECT_GROUP_CODE");
            statement.setObject(17, dedupClientId);
            statement.setObject(18, userId);
            statement.addBatch();
	         if(++count % batchSize == 0) {
	            	int[] successCount = statement.executeBatch();
	            	connection.commit();
	            	System.out.println("Time for DB Execute batch$$$$$$$$$$$$$$"+successCount.length);
	        	}
        }catch (Exception ex) {
            logger.error(" Exception inserting sync table: "+ex.getMessage(), ex);
        }
    	
	}
	private static Map<UUID,List<UUID>> populateSubmissions() {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Map<UUID,List<UUID>> maps = new HashMap<>();
        List<UUID> submissions = new ArrayList<>();
        UUID perviousClient = UUID.randomUUID();
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select client_id,submission_id  from survey.client_survey_submission where  global_enrollment_id='f29534a2-078f-4415-82c3-2c634d9c77d8' order by client_id ");
            resultSet = statement.executeQuery();
            int i=0;
            UUID submissionId = UUID.randomUUID();
            while (resultSet.next()) {
				UUID clientId = (UUID) resultSet.getObject("client_id");
				submissionId = (UUID) resultSet.getObject("submission_id");
				if(clientId.compareTo(perviousClient) !=0 && i!=0) {
					maps.put(perviousClient, submissions);
					submissions = new ArrayList<>();
					i=0;
				}
				submissions.add(submissionId);
				perviousClient = clientId;
				i++;
			}
            submissions.add(submissionId);
            maps.put(perviousClient, submissions);
        }catch (Exception ex){
            logger.error(" Error getting hmis_user for firstName  ",ex);
        }
        //List<UUID> list = maps.get(UUID.fromString("fff9752f-2f2e-4434-8fbc-1a4eb17650ea"));
		return maps;
	}
	
	private static Map<String,Client> populateClient() {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Map<String,Client> clientsMaps = new HashMap<>();
        try{
            connection = getConnection();
            statement = connection.prepareStatement("select id,dedup_client_id,lower(first_name),lower(last_name) from base.client where project_group_code='CORRECT_PROJECT_GROUP_CODE' ");
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

//	public static List<String> readFile() throws IOException {
//	    List<String> lines = Collections.emptyList(); 
//	      lines = 
//	       Files.readAllLines(Paths.get("/Users/sdolia/Desktop/effort_data.csv"), StandardCharsets.UTF_8); 
//	      return lines;
//	}
	
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
	            statement.setString(5,"CORRECT_PROJECT_GROUP_CODE");
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
	            statement = connection.prepareStatement("select id,lower(first_name),lower(last_name) from base.hmis_user where project_group_code='CORRECT_PROJECT_GROUP_CODE'");
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


