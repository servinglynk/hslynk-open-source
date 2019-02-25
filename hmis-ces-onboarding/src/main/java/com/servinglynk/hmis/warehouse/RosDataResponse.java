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

public class RosDataResponse extends Logging {
	  final static Logger logger = Logger.getLogger(RosDataResponse.class);
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
		  Logger logger = Logger.getLogger(RosDataResponse.class.getName());
		  SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yy");
	        Properties props = new Properties();
	        props.generatePropValues("application.conf");
	        props.printProps();
	        Map<UUID, List<UUID>> clientSubmissions = populateSubmissions();
	        Map<String, UUID> users = populateUserId();
	        Map<String, Client> clients = populateClient();
	        CSVStrategy strategy = new CSVStrategy(',', '"', '#', false, true);
		      ValueProcessorProvider vpp = new ValueProcessorProvider();
		      String fileName ="/Users/sdolia/Desktop/ROS_data.csv";
		      File file = new File(fileName);
		      InputStream targetStream = new FileInputStream(file);
		      BufferedReader csvFile = new BufferedReader(
		                new InputStreamReader(targetStream));
		      CSVReader<RosDataCsv> csvReader = new CSVReaderBuilder<RosDataCsv>(csvFile).strategy(strategy).entryParser(
		                      new AnnotationEntryParser<RosDataCsv>(RosDataCsv.class, vpp)).build();
		      List<RosDataCsv> records = csvReader.readAll(); 
				PreparedStatement statement = null;
			    Connection connection = getConnection();
			    connection.setAutoCommit(false);
	            statement = connection.prepareStatement("insert into survey.client_survey_submission (id,client_id,survey_id,submission_id,project_group_code,created_at,updated_at,user_id,is_active,deleted,global_enrollment_id) values (?,?,?,?,?,?,?,?,?,?,?)");
		        
		      if(CollectionUtils.isNotEmpty(records)) {
//		    	  Comparator<RosDataCsv> byName = 
//		    				(RosDataCsv o1, RosDataCsv o2)->o1.getSourceSystemId().compareTo(o2.getSourceSystemId());
				try {
					//Collections.sort(records, byName);
		  		for(RosDataCsv record : records) {
		  		 	String sourceSystemId = record.getSourceSystemId();
		  		 	String name = record.getName();
		  		 	String[] names = name.split(",");
		          	String firstName = names[1];
		          	String lastName =  names[0];
		          	String serviceCategory = record.getServiceCategory(); // SRHT - D Drug/Alcohol Services
		          	String staffingAgent = record.getStaffingAgent();
		          	String[] userNameSplit = staffingAgent.split(",");
		          	String staffingAgentLastName = userNameSplit[0].trim();
		          	String staffingAgentFirstName = userNameSplit[1].trim();
		          	String effortValue = record.getServiceValue();
//		        	if(StringUtils.isNotEmpty(effortValue)) {
//		        		effortValue = effortValue.trim();
//		        	}
//		        	System.out.println("EffortValue:"+effortValue+"is correct");
		          	if(StringUtils.isNotEmpty(effortValue) &&  (!Character.isLetter(effortValue.charAt(0)) || !Character.isDigit(effortValue.charAt(1)))) {
		          		throw new Exception("Efforvalue incorrect"+effortValue);
		          	}
		         	if(StringUtils.isNotBlank(serviceCategory) &&  !Character.isLetter(serviceCategory.charAt(0))) {
		          		throw new Exception("serviceCategory incorrect"+serviceCategory);
		          	}
		         	
		  		    UUID userId = users.get(staffingAgentFirstName+"-"+staffingAgentLastName);
		  		  if(userId == null) {
			  			throw new Exception("UserId incorrect"+userId);
			  		}
		          	String key =firstName+"-"+lastName;
		          	Client client = clients.get(key);
		        	if(client == null) {
	  					System.out.println("Client WAS NULL FOR "+ firstName + " :"+ lastName+ "record number"+ count);
	  					client = createClient(firstName, lastName, null,sourceSystemId,userId);
	  					clients.put(key, client);
	  			     }
		        		UUID submissionId = UUID.randomUUID();
			        	statement.setObject(1,UUID.randomUUID());
			            statement.setObject(2,client.getClientId()); // Get ClientID from FN and LN
			            statement.setObject(3,UUID.fromString(""));
			            statement.setObject(4,submissionId);
			            statement.setString(5,"PROJ_GRP");
			            statement.setTimestamp(6, getCUrrentTimestamp());
			            statement.setTimestamp(7, getCUrrentTimestamp());
			            statement.setObject(8,userId);
			            statement.setBoolean(9, true);
			            statement.setBoolean(10, false);
			            statement.setObject(11,UUID.fromString(""));
			            statement.addBatch();
			            if(++count % batchSize == 0) {
			            	int[] successCount = statement.executeBatch();
			            	connection.commit();
			            	System.out.println("Time for DB Execute batch$$$$$$$$$$$$$$"+successCount.length);
			            }
		  			}
		  		System.out.println(records.size());
		  		System.out.println(count);
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
		// DCEE7EC5823F3D7CDFF438BE2490F603
		      DedupServiceImpl  impl = new DedupServiceImpl();
		      Person person = new Person();
		      person.setGivenName(firstName);
		      person.setFamilyName(lastName);
		      //person.setSsn(ssn);
		      Person dedupingLogic = impl.dedupingLogic(person, "C2F20118B646931ECE4FB660A904E9F1");
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
            builder.append(" (id,dedup_client_id,first_name,last_name,project_group_code,date_created,date_updated,user_id,deleted,schema_year,source_system_id,version) " );
            builder.append("values (?,?,?,?,?,?,?,?,?,?,?,?) ");
            statement = connection.prepareStatement(builder.toString());
            statement.setObject(1,id);
            statement.setObject(2,client.getDedupClientId()); // Get ClientID from FN and LN
            statement.setString(3,firstName);
            statement.setString(4,lastName);
            statement.setString(5,"PROJ_GRP");
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setTimestamp(7, getCUrrentTimestamp());
            statement.setObject(8, UUID.fromString("6866e786-5aef-4d21-9fc0-b18befe1c18a"));
            statement.setBoolean(9, false);
            statement.setString(10, "2017");
            statement.setString(11, sourceSystemId);
          //  statement.setString(12, ssn);
            statement.setInt(12, 4);
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
            builder.append(" (id,dedup_client_id,first_name,last_name,project_group_code,date_created,date_updated,user_id,deleted,source_system_id,version) " );
            builder.append(" values (?,?,?,?,?,?,?,?,?,?,?) ");
            statement = connection.prepareStatement(builder.toString());
            statement.setObject(1,id);
            statement.setObject(2,client.getDedupClientId()); // Get ClientID from FN and LN
            statement.setString(3,firstName);
            statement.setString(4,lastName);
            statement.setString(5,"PROJ_GRP");
            statement.setTimestamp(6, getCUrrentTimestamp());
            statement.setTimestamp(7, getCUrrentTimestamp());
            statement.setObject(8, UUID.fromString("6866e786-5aef-4d21-9fc0-b18befe1c18a"));
            statement.setBoolean(9, false);
            statement.setString(10, sourceSystemId);
           // statement.setString(11, ssn);
            statement.setInt(11, 4);
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
            statement.setString(16,"PROJ_GRP");
            statement.setObject(17, dedupClientId);
            statement.setObject(18, userId);
            statement.setObject(19, "ROS_DATA");
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


