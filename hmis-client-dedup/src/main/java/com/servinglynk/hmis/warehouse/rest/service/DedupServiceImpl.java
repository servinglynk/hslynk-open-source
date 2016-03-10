package com.servinglynk.hmis.warehouse.rest.service;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.domain.PersonIdentifier;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;

public class DedupServiceImpl implements DedupService{
	private static final String OPENEMPI_SESSION_KEY_HEADER = "OPENEMPI_SESSION_KEY";
	private static final String OPENEMPI_HOST = "http://ec2-54-149-78-38.us-west-2.compute.amazonaws.com:8080/openempi-webapp-web-2.2.9/";
	final static Logger logger = Logger.getLogger(DedupServiceImpl.class);
	
	public String authenticate(AuthenticationRequest authRequest) {
		RestTemplate restTemplate = new RestTemplate();
		String url = OPENEMPI_HOST+"openempi-ws-rest/security-resource/authenticate";       
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); 
        HttpEntity<AuthenticationRequest> entity = new HttpEntity<AuthenticationRequest>(authRequest, headers); 
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        // check the response, e.g. Location header,  Status, and body
        response.getHeaders().getLocation();
        response.getStatusCode();
        return response.getBody();
	}

	public Person createUser(Person person,String sessionKey) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
		  	headers.setContentType(MediaType.APPLICATION_XML); 
	        headers.set(OPENEMPI_SESSION_KEY_HEADER, sessionKey);
	        String url = OPENEMPI_HOST+"openempi-ws-rest/person-manager-resource/addPerson";
	       // requestBody ="{ \"person\": { \"familyName\": \"Anderson\",\"givenName\": \"John\"}}";
	        HttpEntity<Person> entityHttp = new HttpEntity<Person>(person, headers); 
	        ResponseEntity<Person> responseObject = restTemplate.exchange(url, HttpMethod.PUT, entityHttp, Person.class);
	        return responseObject.getBody();
	}

	public Person updateUser(Person person,String sessionKey) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	  	headers.setContentType(MediaType.APPLICATION_XML); 
        headers.set(OPENEMPI_SESSION_KEY_HEADER, sessionKey);
        String url = OPENEMPI_HOST+"openempi-ws-rest/person-manager-resource/updatePerson";
       // requestBody ="{ \"person\": { \"familyName\": \"Anderson\",\"givenName\": \"John\"}}";
        HttpEntity<Person> entityHttp = new HttpEntity<Person>(person, headers); 
        ResponseEntity<Person> responseObject = restTemplate.exchange(url, HttpMethod.PUT, entityHttp, Person.class);
        return responseObject.getBody();
        }
	
	
	public List<Person> findMatchingPersonsByAttributes(Person person,String sessionKey) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(new MediaType[] {MediaType.TEXT_XML}));
	  	headers.setContentType(MediaType.APPLICATION_XML); 
        headers.set(OPENEMPI_SESSION_KEY_HEADER, sessionKey);
        String url = OPENEMPI_HOST+"openempi-ws-rest/person-query-resource/findPersonsByAttributes";
        HttpEntity<Object> entityHttp = new HttpEntity<Object>(parsePersonObjectToXMLString(person), headers); 
        ResponseEntity<Object> responseObject = restTemplate.exchange(url, HttpMethod.POST, entityHttp, Object.class);
        LinkedHashMap<Object, Object> persons = (LinkedHashMap<Object, Object>) responseObject.getBody();
        List<Person> finalPersons = new ArrayList<Person>();
        if(persons !=null && persons.size() > 0) {
        	  if( persons.entrySet().size()  > 1) {
              	List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("person");
                  for(LinkedHashMap<Object, Object> linkedPersons : abcPersons) {
                  	finalPersons.add(hydradePerson(linkedPersons));
                  }
              }else if(persons.entrySet().size()  == 1){
            	  try {
            		  LinkedHashMap<Object, Object> abcPersons =   (LinkedHashMap<Object, Object>) persons.get("person");
            		  finalPersons.add(hydradePerson(abcPersons));
            	  }catch(ClassCastException ex) {
            			List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("person");
                        for(LinkedHashMap<Object, Object> linkedPersons : abcPersons) {
                        	finalPersons.add(hydradePerson(linkedPersons));
                        }
            	  }
              }
        }
      
        
        return finalPersons;
	}
	private String parsePersonObjectToXMLString(Person person) {
		String requestBody = "<person>";
		if(person.getSsn() !=null && !"".equals(person.getSsn())) {
			requestBody =requestBody+"<ssn>"+person.getSsn()+"</ssn>";
		}
		if(person.getGivenName() !=null && !"".equals(person.getGivenName())) {
			requestBody = requestBody +"<givenName>"+person.getGivenName()+"</givenName>";
		}
		if(person.getFamilyName() !=null && !"".equals(person.getFamilyName())) {
			requestBody = requestBody+ "<familyName>"+person.getFamilyName()+"</familyName>";
		}
		if(person.getDateOfBirth() !=null)  {
			requestBody = requestBody+"<dateOfBirth>"+person.getDateOfBirth()+"</dateOfBirth>";
		}
		requestBody = requestBody+"</person>";
		logger.info("Request Body"+requestBody);
		return requestBody;	
	}

	/***
	 *  Follow the following deduping algorithm for each new Client record.
	 * For Each New Client Record
			--Part 1
			IF SSN Is Null And Two of (First Name/First Name Alias, Last Name/Last Name Alias, Date of
			Birth) Are Null
			 DISCARD RECORD
			ELSE
			--Part 2
			Select as POTENTIAL MATCH
			(
			-- Part 3
			Where existing records match the SSN of new record AND
			• Neither Data Quality Code indicates Partial SSN
			 OR
			-- Part 4
			Existing records match new record on at least 2 of the following elements:
			• First Name/First Name Alias (match first name and all first name aliases of
			client against all first names and first name aliases in database);
			• Last Name/Last Name Alias (match last name and all last name aliases of
			client against all last names and last name aliases in database);
			• Date of Birth
			• SSN where Data Quality Code indicates partial SSN
			)
			-- Part 5
			 Delete from POTENTIAL MATCHES
			Where
			( non-null conflicting information is present in any TWO of the following elements:
			• Gender
			• Name Suffix/Name Suffix Alias
			• Day of Birth
			• Month of Birth
			• Year of Birth
			• SSN, where neither data quality code indicates partial SSN
			 )
			-- Part 6
			 AND new record does not match existing records based on BOTH
			• Complete SSN AND
			• Two of (First Name/First Name Alias, Last Name/Last Name Alias, Date
			of Birth)
			--Part 7
			Delete From POTENTIAL MATCHES
			 Where
			• Match was based on Last Name and Date of Birth
			• SSN Does Not Match (either different or at least one is null)
			• Matching clients < 18 at Program Entry
			• Non-null conflicting information is present in First Name
			9
			Technical Guidelines for Unduplicating and De-identifying HMIS Client Records
			-- Part 8
			IF Total Likely Matches = 1
			 MATCH FOUND
			-- Part 9
			ELSE IF Total Likely Matches = 0
			 INSERT NEW RECORD
			-- Part 10
			ELSE IF Total Likely Matches > 1
			 FLAG RECORDS FOR INTERVENTION
			END IF
			Next New Client Record

	 * @param person
	 * @param sessionKey
	 * @return
	 */
	public Person dedupingLogic(Person person,String sessionKey) {
		// PART 1: of the algorithm states that when all the required fields are null we should not insert the record in Open EMPI or HMIS database.
			if(!isRecordFitForMatching(person)) {
				//throw new ApplicationException(id, ins);
			}
		// PART 3: Now is the time to select a potential match.
			// Custom10 field is set to a value if the client provides partial SSN.
			if(StringUtils.isEmpty(person.getCustom10()) && person.getSsn() != null && !"".equals(person.getSsn())) {
					List<Person>  unMatchedPersons = getPersonsBySSN(person,sessionKey);
					// PART 6 : Complete SSN AND • Two of (First Name/First Name Alias, Last Name/Last Name Alias, Date of Birth)
					List<Person> matchingPersons = unMatchingRecordsForCompleteSSN(unMatchedPersons,person);
					// If the total match likely equals 1 then return it
					//	-- Part 8 IF Total Likely Matches = 1 MATCH FOUND
					if(matchingPersons !=null && matchingPersons.size() == 1 ) {
						Person finalPerson =  (Person) matchingPersons.get(0);
						finalPerson.setCustom20(getUniqueIdentifier(finalPerson.getPersonIdentifiers()));
						return finalPerson;
					}	
			}else {
				// 	PART 4 : Scenario where the SSN is Partial 
				// Now lets play a game where we assign points if something is available between Partial SSN,First Name, Last Name and Date of Birth.
				List<Person> unMatchingPersons  = matchingRecords(person,sessionKey);
				// PART 5 : Unmatch based on the algorithm.
				List<Person> matchingPersons = unMatchingRecordsForPartialSSN(unMatchingPersons, person);
				// PART 7 : Delete from potential matches
				List<Person> finalPersons =	deleteFromPotentialMatches(matchingPersons,person);
				//	-- Part 8 IF Total Likely Matches = 1 MATCH FOUND
				if(finalPersons !=null && finalPersons.size() == 1 ) {
					Person finalPerson =  (Person) finalPersons.get(0);
					finalPerson.setCustom20(getUniqueIdentifier(finalPerson.getPersonIdentifiers()));
					return finalPerson;
				}
				if(finalPersons !=null && finalPersons.size() > 1 ) {
					throw new IllegalArgumentException("Very hard to match this guy");
				}
			}
			// When no match found lets insert a new record.
			//-- Part 9 Likely Matches = 0  INSERT NEW RECORD
			  Person newlyAddedPerson  = createUser(person, sessionKey);
			  newlyAddedPerson.setCustom20(getUniqueIdentifier(newlyAddedPerson.getPersonIdentifiers()));
//			  if(newlyAddedPerson !=null ) {
//				  return getUniqueIdentifier(newlyAddedPerson.getPersonIdentifiers());
//			  }
			return newlyAddedPerson;
	}
	
	/*-- Part 4
	Existing records match new record on at least 2 of the following elements:
	• First Name/First Name Alias (match first name and all first name aliases of
	client against all first names and first name aliases in database);
	• Last Name/Last Name Alias (match last name and all last name aliases of
	client against all last names and last name aliases in database);
	• Date of Birth
	• SSN where Data Quality Code indicates partial SSN
	*/
	private List<Person> matchingRecords(Person person, String sessionKey) {
		Set<String> uniqueIdentifiers = new HashSet<String>();
		List<Person> matchingPersons = new ArrayList<Person>();
		//Fetch by First Name and Last Name
		if(!StringUtils.isEmpty(person.getGivenName()) && !StringUtils.isEmpty(person.getFamilyName())) {
			Person firstNameLastNamePerson = new Person();
			firstNameLastNamePerson.setFamilyName(person.getFamilyName());
			firstNameLastNamePerson.setGivenName(person.getGivenName());
			List<Person> firstNameLastNamePersons = findMatchingPersonsByAttributes(firstNameLastNamePerson, sessionKey);
			matchingPersons.addAll(getNonDuplicatePersons(firstNameLastNamePersons,uniqueIdentifiers));
		}
		//Fetch by First Name and Date of Birth
		if(!StringUtils.isEmpty(person.getGivenName()) && person.getDateOfBirth() !=null) {
			Person firstNameDOBPerson = new Person();
			firstNameDOBPerson.setGivenName(person.getGivenName());
			firstNameDOBPerson.setDateOfBirth(person.getDateOfBirth());
			List<Person> firstNameDOBPersons = findMatchingPersonsByAttributes(firstNameDOBPerson, sessionKey);
			matchingPersons.addAll(getNonDuplicatePersons(firstNameDOBPersons,uniqueIdentifiers));
		}
	
 		//Fetch by Last Name and Date of Birth
		if(!StringUtils.isEmpty(person.getFamilyName()) && person.getDateOfBirth() !=null) {
			Person lastNameDOBPerson = new Person();
			lastNameDOBPerson.setFamilyName(person.getFamilyName());
			lastNameDOBPerson.setDateOfBirth(person.getDateOfBirth());
			List<Person> lastNameDOBPersons = findMatchingPersonsByAttributes(lastNameDOBPerson, sessionKey);
			if(!CollectionUtils.isEmpty(lastNameDOBPersons)) {
				for(Person lastNamePerson : lastNameDOBPersons ) {
					lastNamePerson.setCustom11("LNAMEDOB");		
				}
			}
			matchingPersons.addAll(getNonDuplicatePersons(lastNameDOBPersons,uniqueIdentifiers));	
		}
		
		
		//Fetch by First Name and SSN
		if(!StringUtils.isEmpty(person.getGivenName()) && !StringUtils.isEmpty(person.getSsn())) {
			Person firstNameSSNPerson = new Person();
			firstNameSSNPerson.setGivenName(person.getGivenName());
			firstNameSSNPerson.setSsn(person.getSsn());
			List<Person> firstNameSSNPersons = findMatchingPersonsByAttributes(firstNameSSNPerson, sessionKey);
			matchingPersons.addAll(getNonDuplicatePersons(firstNameSSNPersons,uniqueIdentifiers));
		}
		
		//Fetch by Last Name and SSN
		if(!StringUtils.isEmpty(person.getFamilyName()) && !StringUtils.isEmpty(person.getSsn())) {
			Person lastNameSSNPerson = new Person();
			lastNameSSNPerson.setFamilyName(person.getFamilyName());
			lastNameSSNPerson.setSsn(person.getSsn());
			List<Person> lastNameSSNPersons = findMatchingPersonsByAttributes(lastNameSSNPerson, sessionKey);
			matchingPersons.addAll(getNonDuplicatePersons(lastNameSSNPersons,uniqueIdentifiers));
		}
		//Fetch by Date of Birth and SSN
		if(!StringUtils.isEmpty(person.getSsn()) && person.getDateOfBirth() !=null) {
			Person dobSSNPerson = new Person();
			dobSSNPerson.setDateOfBirth(person.getDateOfBirth());
			dobSSNPerson.setSsn(person.getSsn());
			List<Person> dobSSNPersonPersons = findMatchingPersonsByAttributes(dobSSNPerson, sessionKey);
			matchingPersons.addAll(getNonDuplicatePersons(dobSSNPersonPersons,uniqueIdentifiers));
		}
		return matchingPersons;	
	}
	private String getUniqueIdentifier(Set<PersonIdentifier> personIdentifiers) {
		 Iterator<PersonIdentifier> iterator = personIdentifiers.iterator();
		 String identifier = null;
		 while(iterator.hasNext()) {
			 PersonIdentifier personIdentifier = iterator.next();
			 identifier = personIdentifier.getIdentifier();
			 break;
		 }
		 return identifier;
	}

	private List<Person> getNonDuplicatePersons(List<Person> persons, Set<String> uniqueIdentifiers) {
		List<Person> newPersons = new ArrayList<Person>();
		if(!CollectionUtils.isEmpty(persons)) {
			for(Person person : persons) {
				if(!uniqueIdentifiers.contains(getUniqueIdentifier(person.getPersonIdentifiers()))) {
					newPersons.add(person);
					uniqueIdentifiers.add(getUniqueIdentifier(person.getPersonIdentifiers()));	
				}
			}
		}
		return newPersons;
	}
	
	/* PART 5:
	 * Delete from POTENTIAL MATCHES
		Where
		( non-null conflicting information is present in any TWO of the following elements:
		• Gender
		• Name Suffix/Name Suffix Alias
		• Day of Birth
		• Month of Birth
		• Year of Birth
		• SSN, where neither data quality code indicates partial SSN
		 )
		 */
	private List<Person> unMatchingRecordsForPartialSSN(List<Person> persons, Person matchingPerson) {
		List<Person> matchingPersons = new ArrayList<Person>();
		if(persons !=null ) {
			for(Person person : persons) {
				int points = 0 ;
				if(person != null && matchingPerson !=null) {
					if(StringUtils.equals(matchingPerson.getFamilyName(), person.getFamilyName())) {
						points++;
					}
					if(StringUtils.equals(matchingPerson.getGivenName(), person.getGivenName())) {
						points++;
					}
					if(person.getDateOfBirth()!=null && matchingPerson.getDateOfBirth()!=null && DateUtils.isSameDay(person.getDateOfBirth(), matchingPerson.getDateOfBirth())) {
						points++;
					}
					if(StringUtils.equals(matchingPerson.getSsn(), person.getSsn())) {
						points++;
					}
					if(matchingPerson.getGender()!=null && person.getGender() !=null  && StringUtils.equals(matchingPerson.getGender().getGenderCode(), person.getGender().getGenderCode())) {
						points++;
					}
					if(points >= 2) {
						matchingPersons.add(person);	
					}
				}
			}
		}
		return matchingPersons;
	}
	
	/*
	-- Part 6
	 AND new record does not match existing records based on BOTH
	• Complete SSN AND
	• Two of (First Name/First Name Alias, Last Name/Last Name Alias, Date
	of Birth)
	*/
	private List<Person> unMatchingRecordsForCompleteSSN(List<Person> persons, Person matchingPerson) {
		List<Person> matchingPersons = new ArrayList<Person>();
		if(persons !=null ) {
			for(Person person : persons) {
				int points = 0 ;
				if(person != null && matchingPerson !=null) {
					if(StringUtils.equals(matchingPerson.getFamilyName(), person.getFamilyName())) {
						points++;
					}
					if(StringUtils.equals(matchingPerson.getGivenName(), person.getGivenName())) {
						points++;
					}
					if(person.getDateOfBirth()!=null && matchingPerson.getDateOfBirth()!=null && DateUtils.isSameDay(person.getDateOfBirth(), matchingPerson.getDateOfBirth())) {
						points++;
					}
					if(StringUtils.equals(matchingPerson.getSsn(), person.getSsn())) {
						points++;
					}
					if(points >= 2) {
						matchingPersons.add(person);	
					}
				}
			}
		}
		return matchingPersons;
	}
	/*--Part 7
			Delete From POTENTIAL MATCHES
			 Where
			• Match was based on Last Name and Date of Birth
			• SSN Does Not Match (either different or at least one is null)
			• Matching clients < 18 at Program Entry
			• Non-null conflicting information is present in First Name
			*/
	private List<Person> deleteFromPotentialMatches(List<Person> persons,Person person) {
		List<Person> finalPersons = new ArrayList<Person>();
		if(!CollectionUtils.isEmpty(persons)) {
			for(Person newPerson : persons) {
				if(newPerson !=null ) {
					if(!StringUtils.equals(newPerson.getSsn(), person.getSsn())) {
						continue;
					}
					if(newPerson.getGivenName() == null) {
						continue;
					}
					if(getAge(newPerson.getDateOfBirth()) < 18) {
						continue;
					}
					// Match was based on last name and DOB
					if("LNAMEDOB".equals(newPerson.getCustom11())) {
						continue;
					}
					finalPersons.add(newPerson);
				}
			}
		}
		return finalPersons;
	}
	
	public int getAge(Date dateOfBirth) {
	    int age = 0;
	    Calendar born = Calendar.getInstance();
	    Calendar now = Calendar.getInstance();
	    if(dateOfBirth!= null) {
	        now.setTime(new Date());
	        born.setTime(dateOfBirth);  
	        if(born.after(now)) {
	            throw new IllegalArgumentException("Can't be born in the future");
	        }
	        age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
	        if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
	            age-=1;
	        }
	    }  
	    return age;
	}
	private List<Person> getPersonsBySSN(Person person,String sessionKey) {
		Person personWithCompleteSSN = new Person();
		personWithCompleteSSN.setSsn(person.getSsn());
		return findMatchingPersonsByAttributes(personWithCompleteSSN, sessionKey);
	}
	private boolean isRecordFitForMatching(Person person) {
		if(person !=null) {
			if(StringUtils.isEmpty(person.getSsn()) && StringUtils.isEmpty(person.getGivenName()) && StringUtils.isEmpty(person.getFamilyName()) && person.getDateOfBirth() == null) {
				return false;
			}
			// This method returns true then it means that not all the fields are null. SSN,Given name, Family name and Date Of Birth.
			return true;
		}
		return false;
	}
	
	 private Person hydradePerson(LinkedHashMap<Object, Object> linkedPersons) {
     	Person person = new Person();
     	String dob = (String)linkedPersons.get("dateOfBirth");
     	if(dob !=null) {
     		dob.substring(0, 9);
     		person.setDateOfBirth(getDateInFormat(dob));
     	}
 		person.setSsn((String)linkedPersons.get("ssn"));
 		person.setGivenName((String)linkedPersons.get("givenName"));
 		person.setFamilyName((String)linkedPersons.get("familyName"));
 		Integer personId =  Integer.parseInt((String)linkedPersons.get("personId"));
 		person.setPersonId(personId);
 		
 		LinkedHashMap<Object, Object>  personIdentifiersLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("personIdentifiers");
 		if(personIdentifiersLinkedList !=null) {
 			String identifier = (String)personIdentifiersLinkedList.get("identifier");
 			PersonIdentifier personIdentifier = new PersonIdentifier();
 			personIdentifier.setIdentifier(identifier);
 			person.addPersonIdentifier(personIdentifier);
 		}
 		LinkedHashMap<Object, Object>  genderLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("gender");
 		Gender gender = new Gender();
 		if(genderLinkedList !=null) {
 			Integer genderCd = Integer.parseInt((String)genderLinkedList.get("genderCd"));
 	 		gender.setGenderCd(genderCd);
 	 		gender.setGenderCode((String)genderLinkedList.get("genderCode"));
 	 		person.setGender(gender);	
 		}
 		
 		
     	return person;
     }
	 
	private Date getDateInFormat(String dob) {
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
	public static void main(String args[]) {
		DedupServiceImpl impl = new DedupServiceImpl();
		AuthenticationRequest authRequest = new AuthenticationRequest();
		authRequest.setPassword("admin");
		authRequest.setUsername("admin");
		String value = impl.authenticate(authRequest);
		System.out.println("SESSION_KEY:"+value);
//		Person person = new Person();
		
		//Fetch by First Name and Last Name
		Person person = new Person();
		person.setFamilyName("Jackson");
		person.setGivenName("Paul");
		person.setSsn("4321");
		
		person.setDateOfBirth(impl.getDateInFormat("1970-01-01"));
//		person.setCity("Minneapolis");
		person.setCustom10("ANC");
		Person personRestult  =	impl.dedupingLogic(person, value);
//		 Set<PersonIdentifier> personIdentifiers = personRestult.getPersonIdentifiers();
//		 Iterator<PersonIdentifier> iterator = personIdentifiers.iterator();
//		 while(iterator.hasNext()) {
//			 PersonIdentifier personIdentifier = iterator.next();
//			 System.out.println("PERSON_ID:"+personIdentifier.getIdentifier());
//		 }
		System.out.println("PERSON_ID:"+impl.getUniqueIdentifier(personRestult.getPersonIdentifiers()));
//		 List<Person> findMatchingPersonsByAttributes = impl.findMatchingPersonsByAttributes(person, value);
//		 
//		 System.out.println("Inserted Value:"+findMatchingPersonsByAttributes.get(0).getGivenName());
//		
	}

}
