package com.servinglynk.hmis.warehouse.rest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;

public class DedupIdFix {

	public static void main(String args[]) throws Exception {
		Logger logger = Logger.getLogger(DedupIdFix.class.getName());
		Properties props = new Properties();
		props.generatePropValues();
		props.printProps();
		AuthenticationRequest authRequest = new AuthenticationRequest();
		authRequest.setPassword(Properties.OPEN_EMPI_PASSWORD);
		authRequest.setUsername(Properties.OPEN_EMPI_USERNAME);
		
		
		DedupServiceImpl impl = new DedupServiceImpl();
		String value = "D91AAD4897470D1D0E48F9E5301CFB73";
	//	System.out.println("SESSION_KEY:"+value);
		//Fetch by First Name and Last Name
	//	List<String> clients = getEligibilityClients("03392450-9e69-11e6-ab44-02f305dabccf");
				//getEligibilityClients("03392450-9e69-11e6-ab44-02f305dabccf");
		List<Person> persons = getPersons();
		for(Person person : persons) {
			String clientId = person.getCustom15();
			Person personRestult  =	impl.dedupingLogic(person, value);
			String dedupId = impl.getUniqueIdentifier(personRestult.getPersonIdentifiers());
			
			updateBaseClients(clientId, dedupId);
		//	updateEligibleClients(clientId, dedupId);
			updateVersionClients(clientId, dedupId, person.getCustom16());
			System.out.println("CLIENT_ID:"+ clientId+"   PERSON_ID:"+dedupId);
		}
	}
	
	public static void updateEligibleClients(String clientId, String dedupId) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update housing_inventory.eligible_clients set client_dedup_id= ?   where   client_id= ?");
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
		statement = connection.prepareStatement("update base.client set dedup_client_id = ?,date_updated=?,version=? where id = ? ");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setTimestamp(2, getCUrrentTimestamp());
		statement.setInt(3, 3);
		statement.setObject(4, UUID.fromString(clientId));
		statement.executeUpdate();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}
	  private static Timestamp getCUrrentTimestamp() {
	        Calendar calendar = Calendar.getInstance();
	        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	        return currentTimestamp;
	    }
	public static void updateVersionClients(String clientId, String dedupId,String schema) {
		PreparedStatement statement = null;
		Connection connection = null;
		try{
		connection = SyncPostgresProcessor.getConnection();
		statement = connection.prepareStatement("update v"+schema+".client set dedup_client_id = ?,date_updated=?,version=? where id= ?");
		statement.setObject(1, UUID.fromString(dedupId));
		statement.setTimestamp(2, getCUrrentTimestamp());
		statement.setInt(3, 3);
		statement.setObject(4, UUID.fromString(clientId));
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
	
	 public static List<Person> getPersons() {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<Person> persons = new ArrayList<>();
			try{
			connection = SyncPostgresProcessor.getConnection();
			statement = connection.prepareStatement("select id,first_name,last_name,convert_from(dob_decrypt(dob),'UTF-8') as dateofbirth,convert_from(ssn_decrypt(ssn),'UTF-8') as social,schema_year from base.client where dedup_client_id is null ");
			resultSet = statement.executeQuery();
				while(resultSet.next()) {
					Person person = new Person();
					UUID  uuid = (UUID) resultSet.getObject("id");
					person.setCustom15(uuid.toString());
					person.setGivenName((String)resultSet.getString("first_name"));	
					person.setFamilyName((String)resultSet.getString("last_name"));
					person.setSsn((String)resultSet.getString("social"));
					String dob = resultSet.getString("dateofbirth");
					if(StringUtils.isNotBlank(dob)) {
						person.setDateOfBirth(getDateInFormat(dob));
					}
					person.setCustom16((String)resultSet.getString("schema_year"));
					persons.add(person);
				}
			}catch (Exception ex){
				ex.printStackTrace();
			}
			return persons;
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
