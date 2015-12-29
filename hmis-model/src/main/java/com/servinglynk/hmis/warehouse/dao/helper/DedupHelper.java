package com.servinglynk.hmis.warehouse.dao.helper;

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
import com.servinglynk.hmis.warehouse.restful.model.AppRequest;
import com.servinglynk.hmis.warehouse.restful.model.AuthenticationRequest;

@Component
public class DedupHelper {
	@Resource
	private Environment env;
	
	final static Logger logger = Logger.getLogger(DedupHelper.class);
	private static final String OPENEMPI_HOST = "openempi.host";
	
	public String getDedupedClient(com.servinglynk.hmis.warehouse.model.staging.Client client) {
		try {
		 	RestTemplate restTemplate = new RestTemplate();
		 	
		 	String url = "http://ec2-54-149-120-14.us-west-2.compute.amazonaws.com:8080/hmis-client-dedup/rest/api/v1/authenticate";
	        //String url = env.getRequiredProperty(OPENEMPI_HOST)+"authenticate";       
	        String requestBody = "{ \"AuthenticationRequest\": {\"username\":\"admin\",\"password\":\"admin\"} }";
	        AuthenticationRequest AuthenticationRequest = new AuthenticationRequest();
	        AuthenticationRequest.setPassword("admin");
	        AuthenticationRequest.setUsername("admin");
	        AppRequest request  = new AppRequest();
	        request.setAuthenticationRequest(AuthenticationRequest);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        HttpEntity<AppRequest> entity = new HttpEntity<AppRequest>(request, headers); 
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
	

    private Person hydradePerson(LinkedHashMap<Object, Object> linkedPersons) {
    	Person person = new Person();
//    	Long dob = (Long)linkedPersons.get("dateOfBirth");
//    	if(dob !=null && !"".equals(dob)) {
//    		//dob.substring(0, 9);
//        	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date date;
//            try {
//                date = (Date)((DateFormat) formatter).parse(String.valueOf(dob));
//                person.setDateOfBirth(date);
//                formatter = new SimpleDateFormat("yyyy-MM-dd");
//                String s = formatter.format(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//    	}
		person.setSsn((String)linkedPersons.get("ssn"));
		person.setGivenName((String)linkedPersons.get("givenName"));
		person.setFamilyName((String)linkedPersons.get("familyName"));
		person.setCustom20((String)linkedPersons.get("custom20"));
		LinkedHashMap<Object, Object>  genderLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("gender");
		if(genderLinkedList !=null) {
			Gender gender = new Gender();
			String genderCd = (String)genderLinkedList.get("genderCd");
			if(genderCd !=null && !"".equals(genderCd)) {
				Integer genderCdInt = Integer.parseInt(genderCd);
				gender.setGenderCd(genderCdInt);
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
		System.out.println("Request Body"+requestBody);
		//logger.info("Request Body"+requestBody);
		return requestBody;	
	}
    
	
    public static void main(String args[]) {
    	DedupHelper impl = new DedupHelper();
    	com.servinglynk.hmis.warehouse.model.staging.Client client = new com.servinglynk.hmis.warehouse.model.staging.Client();
    	client.setFirstName("John");
    	client.setLastName("Anderson");
    	client.setDob(LocalDateTime.of(1980, 01, 01, 00 ,0, 0));
    	client.setGender(ClientGenderEnum.ONE);
    	client.setSsn("111111111");
    	client.setSsnDataQuality(ClientSsnDataQualityEnum.EIGHT);
    	String abc = impl.getDedupedClient(client);
    	System.out.println("Identifier "+abc);
    }
}
