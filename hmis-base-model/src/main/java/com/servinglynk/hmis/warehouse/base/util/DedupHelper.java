package com.servinglynk.hmis.warehouse.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.restful.model.AppRequest;
import com.servinglynk.hmis.warehouse.restful.model.AuthenticationRequest;

@Component
public class DedupHelper {
	
	@Resource
	private Environment env;
	
	final static Logger logger = Logger.getLogger(DedupHelper.class);
	private static final String OPENEMPI_HOST = "openempi.host";
	
	public String getDedupedClient(Client client,String sessionKey) {
		try {
		 	RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        headers.set("OPENEMPI_SESSION_KEY", sessionKey);
	     //   String url = env.getRequiredProperty(OPENEMPI_HOST)+"dedup";
	        String url = "http://ec2-52-38-189-237.us-west-2.compute.amazonaws.com:8080/hmis-client-dedup/rest/api/v1/dedup";
	        Person person = new Person();
	        person.setGivenName(client.getFirstName());
	        person.setFamilyName(client.getLastName());
	        person.setSsn(client.getSsn());
	        if(client.getSsnDataQuality().getValue() !=null &&  "2".equals(client.getSsnDataQuality().getValue())) {
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
	        	 gender.setGenderCode(String.valueOf(client.getGender().getValue()));
	   	        //gender.setGenderCd(genderCd);
	   	        person.setGender(gender);
	        }
	        String requestBody = parsePersonObjectToXMLString(person);
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
	public String getAuthenticationHeader() {
			RestTemplate restTemplate = new RestTemplate();
		    //String url = env.getRequiredProperty(OPENEMPI_HOST)+"authenticate";
			String url = "http://ec2-52-38-189-237.us-west-2.compute.amazonaws.com:8080/hmis-client-dedup/rest/api/v1/authenticate";
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
	        LinkedHashMap<String, String> responseBody = (LinkedHashMap<String, String>) response.getBody();   
	        return responseBody.get("String");
	}
	
    private Person hydradePerson(LinkedHashMap<Object, Object> linkedPersons) {
    	Person person = new Person();
		person.setSsn((String)linkedPersons.get("ssn"));
		person.setGivenName((String)linkedPersons.get("givenName"));
		person.setFamilyName((String)linkedPersons.get("familyName"));
		person.setCustom20((String)linkedPersons.get("custom20"));
		LinkedHashMap<Object, Object>  genderLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("gender");
		if(genderLinkedList !=null) {
			Gender gender = new Gender();
			Integer genderCd = (Integer)genderLinkedList.get("genderCd");
			if(genderCd !=null && !"".equals(genderCd)) {
				gender.setGenderCd(genderCd);
			}
			String genderCode = (String)genderLinkedList.get("genderCode");
			if(genderCode !=null && !"".equals(genderCode)) {
				gender.setGenderCode(genderCode);
			}
			person.setGender(gender);
		}
		
    	return person;
    }
    
    private String parsePersonObjectToXMLString(Person person) {
		String requestBody = "{ \"Person\": {";
		if(person.getSsn() !=null && !"".equals(person.getSsn())) {
			requestBody =requestBody+"\"ssn\": \"" +person.getSsn()+"\",";
		}
		if(person.getGivenName() !=null && !"".equals(person.getGivenName())) {
			requestBody = requestBody +"\"givenName\":  \""+person.getGivenName()+"\",";
		}
		if(person.getFamilyName() !=null && !"".equals(person.getFamilyName())) {
			requestBody = requestBody+ " \"familyName\":  \""+person.getFamilyName()+"\",";
		}
		if(person.getDateOfBirth() !=null)  {
			String dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").format(person.getDateOfBirth());
			requestBody = requestBody+ " \"dateOfBirth\":  \""+ dateOfBirth + "\"";
		}
		requestBody = requestBody+"}}";
		logger.info("Request Body:::"+requestBody);
		//logger.info("Request Body"+requestBody);
		return requestBody;	
	}
    
	
    public static void main(String args[]) {
    	DedupHelper impl = new DedupHelper();
    	Client client = new Client();
    	client.setFirstName("John");
    	client.setLastName("Anderson");
    	client.setDob(LocalDateTime.of(1980, 01, 01, 00 ,0, 0));
    	client.setGender(ClientGenderEnum.ONE);
    	client.setSsn("111111111");
    	client.setSsnDataQuality(ClientSsnDataQualityEnum.EIGHT);
    	String abc = impl.getDedupedClient(client,impl.getAuthenticationHeader());
    	System.out.println("Identifier "+abc);
    }
}
