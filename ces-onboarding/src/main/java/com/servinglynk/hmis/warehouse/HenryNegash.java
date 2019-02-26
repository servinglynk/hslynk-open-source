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
import org.beanio.internal.util.StringUtil;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.rest.service.DedupServiceImpl;

public class HenryNegash {
	  final static Logger logger = Logger.getLogger(RosData.class);
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
	    
		public static void main(String args[]) throws Exception {
			  Logger logger = Logger.getLogger(HenryNegash.class.getName());
			  SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yy");
		        Properties props = new Properties();
		        props.generatePropValues("application.conf");
		        props.printProps();
		        Map<UUID, List<UUID>> clientSubmissions = populateSubmissions();
		      //  Map<String, UUID> users = populateUserId();
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
		        Connection connection = getConnection();
		        connection.setAutoCommit(false);
		        StringBuilder builder = new StringBuilder();
	            builder.append(" insert into survey.response ");
	            builder.append(" (id,response_text,question_score,effective_date,created_at,updated_at,is_active,section_id,question_id,client_id,survey_id,refused,submission_id,client_link,deleted,project_group_code,client_dedup_id,user_id,old_user_id) " );
	            builder.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	            statement = connection.prepareStatement(builder.toString());
	            
			      if(CollectionUtils.isNotEmpty(records)) {
			    	  Comparator<HenryNegashCsv> byName = 
			    				(HenryNegashCsv o1, HenryNegashCsv o2)->o1.getSourceSystemId().compareTo(o2.getSourceSystemId());
					try {
						Collections.sort(records, byName);
			  		for(HenryNegashCsv record : records) {
			  		 	String firstName = record.getFirstName();
			          	String lastName =  record.getLastName();
			          	String serviceCategory = record.getServiceCategory(); // SRHT - D Drug/Alcohol Services
			          	String effortValue = record.getServiceValue();
//			        	System.out.println("EffortValue:"+effortValue+"is correct");
			          	if(StringUtils.isNotEmpty(effortValue) &&  (!Character.isLetter(effortValue.charAt(0)) || !Character.isDigit(effortValue.charAt(1)))) {
			          		throw new Exception("Efforvalue incorrect"+effortValue);
			          	}
			         	if(StringUtils.isNotBlank(serviceCategory) &&  !Character.isLetter(serviceCategory.charAt(0))) {
			          		throw new Exception("serviceCategory incorrect"+serviceCategory);
			          	}
			         	UUID userId= UUID.fromString("");
			          	String key =firstName+"-"+lastName;
			          	Client client = clients.get(key);
			          	List<UUID> submissions = clientSubmissions.get(client.getClientId());
			  			//System.out.println(record.toString());
			  			UUID submissionId = submissions.iterator().next();
			  			String interalExternal = record.getInternalExtertnal();
			  			String timeInterval = record.getTime();
			  		    java.util.Date date = sdf1.parse(record.getContactDate());
			  		    java.sql.Date effectiveDate = new java.sql.Date(date.getTime());
			  		    
			  			if(StringUtils.isNotBlank(serviceCategory)) {
			  				hydrateResponseTable(client.getClientId(),userId,submissionId,serviceCategory,effectiveDate,"",client.getDedupClientId(),connection,statement);
			  			}
			  			if(StringUtils.isNotBlank(effortValue)) {
			  				hydrateResponseTable(client.getClientId(),userId,submissionId,effortValue,effectiveDate,"",client.getDedupClientId(),connection,statement);
			  			}
			  			if(StringUtils.isNotBlank(interalExternal)) {
			  				hydrateResponseTable(client.getClientId(),userId,submissionId,interalExternal,effectiveDate,"",client.getDedupClientId(),connection,statement);
			  			}
			  			if(StringUtils.isNotBlank(timeInterval))  {
			  				hydrateResponseTable(client.getClientId(),userId,submissionId,timeInterval,effectiveDate,"",client.getDedupClientId(),connection,statement);
			  			}
			  			String notes = record.getNotes();
			  			if(StringUtils.isNotBlank(notes)) {
			  				hydrateResponseTable(client.getClientId(),userId,submissionId,notes,effectiveDate,"",client.getDedupClientId(),connection,statement);
			  			}
			  			submissions.remove(submissionId);
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
			      DedupServiceImpl  impl = new DedupServiceImpl();
			      Person person = new Person();
			      person.setGivenName(firstName);
			      person.setFamilyName(lastName);
			      //person.setSsn(ssn);
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
	            builder.append(" (id,dedup_client_id,first_name,last_name,project_group_code,date_created,date_updated,user_id,deleted,schema_year,source_system_id,version) " );
	            builder.append("values (?,?,?,?,?,?,?,?,?,?,?,?) ");
	            statement = connection.prepareStatement(builder.toString());
	            statement.setObject(1,id);
	            statement.setObject(2,client.getDedupClientId()); // Get ClientID from FN and LN
	            statement.setString(3,firstName);
	            statement.setString(4,lastName);
	            statement.setString(5,"PROJ_GRP_CODE");
	            statement.setTimestamp(6, getCUrrentTimestamp());
	            statement.setTimestamp(7, getCUrrentTimestamp());
	            statement.setObject(8, UUID.fromString(""));
	            statement.setBoolean(9, false);
	            statement.setString(10, "");
	            statement.setString(11, sourceSystemId);
	          //  statement.setString(12, ssn);
	            statement.setInt(12, 5);
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
	            statement.setString(5,"PROJ_GRP_CODE");
	            statement.setTimestamp(6, getCUrrentTimestamp());
	            statement.setTimestamp(7, getCUrrentTimestamp());
	            statement.setObject(8, UUID.fromString(""));
	            statement.setBoolean(9, false);
	            statement.setString(10, sourceSystemId);
	           // statement.setString(11, ssn);
	            statement.setInt(11, 5);
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
	            statement.setString(16,"PROJ_GRP_CODE");
	            statement.setObject(17, dedupClientId);
	            statement.setObject(18, userId);
	            statement.setObject(19, "R_T");
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
	            statement = connection.prepareStatement("select client_id,submission_id  from survey.client_survey_submission where  global_enrollment_id='c1acb932-3ffa-49fd-8599-6da0f3ef4df0' order by client_id ");
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
	            statement = connection.prepareStatement("select id,dedup_client_id,lower(first_name),lower(last_name) from base.client where project_group_code='PROJ_GRP_CODE' ");
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
		            statement.setString(5,"PROJ_GRP_CODE");
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
		            statement = connection.prepareStatement("select id,lower(first_name),lower(last_name) from base.hmis_user where project_group_code='PROJ_GRP_CODE'");
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
