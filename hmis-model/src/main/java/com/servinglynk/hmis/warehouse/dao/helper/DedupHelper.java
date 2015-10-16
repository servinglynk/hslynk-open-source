package com.servinglynk.hmis.warehouse.dao.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.restful.model.AppRequest;
import com.servinglynk.hmis.warehouse.restful.model.AuthenticationRequest;

@Component
public class DedupHelper {
	private String getDedupedClient(com.servinglynk.hmis.warehouse.model.staging.Client client) {
		try {
		 	RestTemplate restTemplate = new RestTemplate();
	        String url = env.getRequiredProperty(OPENEMPI_HOST)+"authenticate";       
	        String requestBody = "{ \"AuthenticationRequest\": {\"username\":\"admin\",\"password\":\"admin\"} }";
	        AuthenticationRequest AuthenticationRequest = new AuthenticationRequest();
	        AuthenticationRequest.setPassword("admin");
	        AuthenticationRequest.setUsername("admin");
	        AppRequest request  = new AppRequest();
	        request.setAuthenticationRequest(AuthenticationRequest);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers); 
	        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
	        // check the response, e.g. Location header,  Status, and body
	        response.getHeaders().getLocation();
	        response.getStatusCode();
	        LinkedHashMap<String, String> responseBody = (LinkedHashMap<String, String>) response.getBody();        
	        //String sessionKey = (String) responseBody.entrySet().iterator().next();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        headers.set("OPENEMPI_SESSION_KEY", responseBody.get("String"));
	        url = env.getRequiredProperty(OPENEMPI_HOST)+"dedup";
	        Person person = new Person();
	        person.setGivenName(client.getFirstName());
	        person.setFamilyName(client.getLastName());
	        person.setSsn(client.getSsn());
	        if(client.getSsnDataQuality().getValue() !=null &&  !"1".equals(client.getSsnDataQuality().getValue())) {
	        	person.setCustom10(client.getSsnDataQuality().getValue() );	
	        }
	        java.util.Date dob = null;
			if(client.getDob() !=null) {
	    		//dob.substring(0, 9);
	            Date date;
	            try {
	            	java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(client.getDob().toString());
	                person.setDateOfBirth(d);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	    	}
	        
	        if(client.getGender() !=null) {
	        	Gender gender = new Gender();
	        	 gender.setGenderCode(client.getGender().getValue());
	   	        //gender.setGenderCd(genderCd);
	   	        person.setGender(gender);
	        }
	        requestBody = parsePersonObjectToXMLString(person);
	        HttpEntity<String> entityHttp = new HttpEntity<String>(requestBody, headers); 
	        ResponseEntity<Object> responseObject = restTemplate.exchange(url, HttpMethod.POST, entityHttp, Object.class);
	        LinkedHashMap<Object, Object> persons = (LinkedHashMap<Object, Object>) responseObject.getBody();
	        List<Person> finalPersons = new ArrayList<Person>();
	        if( persons.entrySet().size()  > 1) {
	        	List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("Person");
	            for(LinkedHashMap<Object, Object> linkedPersons : abcPersons) {
	            	finalPersons.add(hydradePerson(linkedPersons));
	            }
	        }else if(persons.entrySet().size()  == 1){
	        	LinkedHashMap<Object, Object> abcPersons =   (LinkedHashMap<Object, Object>) persons.get("Person");
	        	finalPersons.add(hydradePerson(abcPersons));
	        }
	        return finalPersons.get(0).getCustom20();
		}
		catch (ResourceAccessException e) {
			logger.error("ResourceAccessException Check if the Dedup Microservice is down "+e.getMessage());
			return null;
			
		}
		catch(Exception ex) {
			logger.error("Error Occured while calling the dedup logic"+ex.getMessage());
			return null;
		}
		}
}
