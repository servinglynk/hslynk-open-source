package com.servinglynk.hmis.warehouse.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;


public class DemoWithXML {
	private static final String OPENEMPI_HOST = "http://ec2-54-149-78-38.us-west-2.compute.amazonaws.com:8080/openempi-webapp-web-2.2.9/";
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String url = OPENEMPI_HOST+"openempi-ws-rest/security-resource/authenticate";       
        //String requestBody = "{\"username\":\"admin\",\"password\":\"admin\"}";
        AuthenticationRequest requestBody = new AuthenticationRequest();
        requestBody.setUsername("admin");
        requestBody.setPassword("admin");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); 
        HttpEntity<AuthenticationRequest> entity = new HttpEntity<AuthenticationRequest>(requestBody, headers); 
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        // check the response, e.g. Location header,  Status, and body
        response.getHeaders().getLocation();
        response.getStatusCode();
        String responseBody = response.getBody();        
        //102243E2A55F9BC337D759EF921BA835
        
        //fa194a0b-2a66-4662-b4fa-3b75d687ae33	568333527	1963-10-26 00:00:00.000000 +00:00:00	Richard	Blanco
        System.out.println(" SESSION KEY"+responseBody);
        headers.setContentType(MediaType.APPLICATION_XML); 
        headers.set("OPENEMPI_SESSION_KEY", responseBody);
        url = OPENEMPI_HOST+"openempi-ws-rest/person-query-resource/findPersonsByAttributes";
        //requestBody ="{ \"person\": { \"familyName\": \"Anderson\",\"givenName\": \"John\"}}";
       // requestBody = "<person><familyName>Anderson</familyName><givenName>John</givenName><ssn>111111111</ssn></person>";
        Person person = new Person();
        person.setFamilyName("Blanco");
        person.setGivenName("Richard");
        person.setSsn("568333527");
        person.setDateOfBirth(new Date("1963-10-26"));
        
       // requestBody = "<person><ssn>111111111</ssn></person>";
//        Person person = new Person();
//        person.setGivenName("John");
//        person.setGivenName("Anderson");
        HttpEntity<Person> entityHttp = new HttpEntity<Person>(person, headers); 
        ResponseEntity<Object> responseObject = restTemplate.exchange(url, HttpMethod.POST, entityHttp, Object.class);
        LinkedHashMap<Object, Object> persons = (LinkedHashMap<Object, Object>) responseObject.getBody();
        List<Person> finalPersons = new ArrayList<Person>();
        if( persons.entrySet().size()  > 1) {
        	List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("person");
            for(LinkedHashMap<Object, Object> linkedPersons : abcPersons) {
//            	Set<Entry<Object, Object>> entrySet = linkedPersons.entrySet();
//            	Entry<Object, Object> next = entrySet.iterator().next();
//            	Object value = next.getValue();
            	System.out.println("New Person Object------------");
            	
            	DemoWithXML main = new DemoWithXML();
            	finalPersons.add(main.hydradePerson(linkedPersons));
            }
        }else if(persons.entrySet().size()  == 1){
        	LinkedHashMap<Object, Object> abcPersons =   (LinkedHashMap<Object, Object>) persons.get("person");
        	DemoWithXML main = new DemoWithXML();
        	finalPersons.add(main.hydradePerson(abcPersons));
        }
        
        

    }
        private Person hydradePerson(LinkedHashMap<Object, Object> linkedPersons) {
        	Person person = new Person();
        	String dob = (String)linkedPersons.get("dateOfBirth");
        	dob.substring(0, 9);
        	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = (Date)((DateFormat) formatter).parse(dob);
                person.setDateOfBirth(date);
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
    		
    		person.setSsn((String)linkedPersons.get("ssn"));
    		person.setGivenName((String)linkedPersons.get("givenName"));
    		person.setFamilyName((String)linkedPersons.get("familyName"));
    		LinkedHashMap<Object, Object>  genderLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("gender");
    		Gender gender = new Gender();
    		Integer genderCd = Integer.parseInt((String)genderLinkedList.get("genderCd"));
    		gender.setGenderCd(genderCd);
    		gender.setGenderCode((String)genderLinkedList.get("genderCode"));
    		person.setGender(gender);
        	return person;
        }
 //       }
        /*Set<Entry<Object, Object>> entrySet = persons.entrySet();
        Entry<Object, Object> next = entrySet.iterator().next();
        List<LinkedHashMap<Object, Object>> personsList = (List<LinkedHashMap<Object, Object>>) next.getValue();
       // Person finalPerson = personsList.get(0);
        LinkedHashMap<Object, Object> finalPersons  = (LinkedHashMap<Object, Object>) personsList.get(0);
        Person values = (Person) finalPersons.values();
       // Person next2 = (Person) values.iterator().next();
        System.out.println("Testing:"+values.getGivenName());
//        List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("person");
//        
//        LinkedHashMap<Object, Object> finalPersons  = (LinkedHashMap<Object, Object>) abcPersons.get(0);
//        Person finalPerson =(Person) finalPersons.get("person");
//        System.out.println("Testing:"+finalPerson.getGivenName());
        System.out.println("Testing:"+responseBody.toString());*/
}
