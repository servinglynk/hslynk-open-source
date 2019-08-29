package com.servinglynk.hmis.warehouse.rest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.domain.Person;

public class DedupIdReload {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(DedupIdReload.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		props.printProps();
//		AuthenticationRequest authRequest = new AuthenticationRequest();
//		authRequest.setPassword("admin");
//		authRequest.setUsername("admin");
//		
//		
		DedupServiceImpl impl = new DedupServiceImpl();
//		String value = impl.authenticate(authRequest);
//		System.out.println("SESSION_KEY:"+value);
		Map<String,String> clientsList = new HashMap<>();
		
		  File file = new File("/Users/sdolia/Downloads/users.csv"); 
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  br.readLine();
		  String st; 
		  while ((st = br.readLine()) != null) {
			  String[] split = st.split(",");
			  if(split.length != 0){
				  clientsList.put(split[1],split[2]);
			  }
		  }
		
		  List<String> clients = new ArrayList<>();
		  clients.add("20aa4109-23e8-48f4-b7fd-2515c7acc591");
		  clients.add("2c7c1908-8146-41fc-a8c3-4c9551ee3096");
		  clients.add("359ba27a-02e4-42be-8bd4-e55237919912");
		  clients.add("41536b81-eacd-40e9-95df-cde42a757af4");
		  clients.add("436e6dd5-cbf4-4adf-846e-502526764906");
		  clients.add("51b9a462-45bd-437c-9594-570ea64a97b8");
		  clients.add("582a14cd-e225-45cf-8d08-ca8dbc4cc48a");
		  clients.add("77c7d161-665e-4553-a563-03ba5176b840");
		  clients.add(" bcbec2a0-28ae-4d23-a643-9dc1ba8f13f3");
		  clients.add("cb2bb398-4135-43ea-b0a4-6afef5173347");
		  clients.add("d3190a28-9442-4aa5-86ef-2af12eea8dbe");
		  clients.add("dbcd1424-d038-4f16-9208-2ff69c87e720");
		  clients.add("e34b74e8-cf18-4d86-b7af-b32b0061bc9f");
		  clients.add("e7e04037-f188-49a6-8a12-2e0ccd52679f");
		  clients.add("fedf6a6c-540d-4b3c-9de7-ea3367741b03");
		  
		//  Set<String> keySet = clientsList.keySet();
		for(String clientId : clients) {
			//Fetch by First Name and Last Name
//		List<String> clients = getEligibilityClients(clientId);
		//  String clientId ="137bc009-b37d-4925-9332-c4e6310a819d";
			String dedupId =null;
			if(StringUtils.isNotBlank(clientId)) {
				Person person = getDeDupId(clientId);
				if(person !=null) {
					Person personRestult  =	impl.dedupingLogic(person, "D403A582649D5EFACC241090974EBB65");
					
					if(personRestult != null) {
						 dedupId = impl.getUniqueIdentifier(personRestult.getPersonIdentifiers());
					}
				}
				
//				String dedupId = clientsList.get(clientId);
				if(StringUtils.isNotBlank(dedupId) && !StringUtils.equals("null", dedupId)) {
					
					updateBaseClients(clientId, dedupId);
					String clientSchemaYear = getClientSchemaYear(clientId);
					if(clientSchemaYear != null) {
						updateVersionClients(clientId, dedupId,clientSchemaYear);
					}
					
					updateEligibleClients(clientId, dedupId);
					updateMatchProcesssing(clientId, dedupId);
					updateResponse(clientId, dedupId);
					updateSectionScore(clientId, dedupId); 
					
					System.out.println(clientId+","+dedupId);
				}
			}
			}
//		}
	}
	
	public static void updateEligibleClients(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update housing_inventory.eligible_clients set client_dedup_id= ?,date_updated=CURRENT_TIMESTAMP   where project_group_code='MO0010' and client_id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public static void updateResponse(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update survey.response set client_dedup_id= ?,updated_at=CURRENT_TIMESTAMP   where project_group_code='MO0010' and client_id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public static void updateSectionScore(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update survey.section_score set client_dedup_id= ?,updated_at=CURRENT_TIMESTAMP   where project_group_code='MO0010' and client_id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void updateMatchProcesssing(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update housing_inventory.match_reservations set client_dedup_id= ?,date_updated=CURRENT_TIMESTAMP   where project_group_code='MO0010' and client_id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void updateBaseClients(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update base.client set dedup_client_id = ? where project_group_code='MO0010' and id = ? ");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static String getClientSchemaYear(String clientId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("select schema_year from base.client where id = ? ");
		statement.setObject(1, UUID.fromString(clientId));
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			return (String)resultSet.getString("schema_year");	
		}
		
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	public static void updateVersionClients(String clientId, String dedupId,String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update v"+schema+".client set dedup_client_id = ? where project_group_code='MO0010' and id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setObject(2, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static List<String> getEligibilityClients(String dedupClientId) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String> clientIds = new ArrayList<String>();
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("select client_id from housing_inventory.eligible_clients where project_group_code='MO0010' and client_dedup_id= ?");
		statement.setObject(1, UUID.fromString(dedupClientId));
		resultSet = statement.executeQuery();
			while(resultSet.next()) {
				clientIds.add((String)resultSet.getString("client_id"));	
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return clientIds;
	}
	
	 public static Person getDeDupId(String clientId) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			Person person = new Person();
			try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement("select first_name,last_name,convert_from(dob_decrypt(dob),'UTF-8') as dateofbirth,convert_from(ssn_decrypt(ssn),'UTF-8') as social,schema_year from base.client where project_group_code in ('MC0005','MO0010') and id= ?");
			statement.setObject(1, UUID.fromString(clientId));
			resultSet = statement.executeQuery();
				while(resultSet.next()) {
					person.setGivenName((String)resultSet.getString("first_name"));	
					person.setFamilyName((String)resultSet.getString("last_name"));
					person.setSsn((String)resultSet.getString("social"));
					String dob = resultSet.getString("dateofbirth");
					if(StringUtils.isNotBlank(dob)){
						person.setDateOfBirth(getDateInFormat((dob)));
					}
					person.setCustom16((String)resultSet.getString("schema_year"));
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
			return person;
	}
	 
		public static Date getDateInFormat(String dob) {
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = new Date();
	        try {
	            date = (Date)((DateFormat) formatter).parse(dob);
	            formatter = new SimpleDateFormat("yyyy-MM-dd");
	            String s = formatter.format(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
		}
}
