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
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;

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
		List<String> clientsList = new ArrayList<>();
		
		  File file = new File("/Users/sdolia/Downloads/users.csv"); 
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  br.readLine();
		  String st; 
		  while ((st = br.readLine()) != null) {
			  String[] split = st.split(",");
			  if(split.length != 0){
				  clientsList.add(split[1]);
			  }
		  }
		
		for(String clientId : clientsList) {
			//Fetch by First Name and Last Name
			List<String> clients = getEligibilityClients(clientId);
				Person person = getDeDupId(clientId);
				Person personRestult  =	impl.dedupingLogic(person, "CE42ABE0AAAB87D08CCE8505B92C6769");
				String dedupId = impl.getUniqueIdentifier(personRestult.getPersonIdentifiers());
			//	updateBaseClients(clientId, dedupId);
			//	updateEligibleClients(clientId, dedupId);
			//	updateVersionClients(clientId, dedupId, person.getCustom16());
				System.out.println(clientId+","+dedupId);
		}
	}
	
	public static void updateEligibleClients(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update housing_inventory.eligible_clients set client_dedup_id= ?   where project_group_code='MO0010' and client_id= ?");
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
			statement = connection.prepareStatement("select first_name,last_name,convert_from(dob_decrypt(dob),'UTF-8') as dateofbirth,convert_from(ssn_decrypt(ssn),'UTF-8') as social,schema_year from base.client where project_group_code='MO0010' and id= ?");
			statement.setObject(1, UUID.fromString(clientId));
			resultSet = statement.executeQuery();
				while(resultSet.next()) {
					person.setGivenName((String)resultSet.getString("first_name"));	
					person.setFamilyName((String)resultSet.getString("last_name"));
					person.setSsn((String)resultSet.getString("social"));
					person.setDateOfBirth(getDateInFormat((String)resultSet.getString("dateofbirth")));
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
