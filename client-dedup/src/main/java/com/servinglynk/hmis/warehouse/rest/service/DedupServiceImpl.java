package com.servinglynk.hmis.warehouse.rest.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
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
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.domain.PersonIdentifier;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;

public class DedupServiceImpl implements DedupService{
	private static final String OPENEMPI_SESSION_KEY_HEADER = "OPENEMPI_SESSION_KEY";
	private static final String OPENEMPI_HOST = "http://openempi.aws.hmislynk.com:8080/openempi-webapp-web-2.2.9/";
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
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			MediaType mediaType = new MediaType("application", "xml", Charset.forName("UTF-16"));
			headers.setContentType(mediaType);
	        headers.set(OPENEMPI_SESSION_KEY_HEADER, sessionKey);
	        String url = OPENEMPI_HOST+"openempi-ws-rest/person-manager-resource/addPerson";
	       // requestBody ="{ \"person\": { \"familyName\": \"Anderson\",\"givenName\": \"John\"}}";
	        HttpEntity<Object> entityHttp = new HttpEntity<Object>(parsePersonObjectToXMLString(person), headers); 
	        ResponseEntity<Person> responseObject = restTemplate.exchange(url, HttpMethod.PUT, entityHttp, Person.class);
	        return responseObject.getBody();
		}catch(Exception e) {
			
		}
		return null;
		
	}

	public Person updateUser(Person person,String sessionKey) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "xml", Charset.forName("UTF-16"));
		headers.setContentType(mediaType);
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
		MediaType mediaType = new MediaType("application", "xml", Charset.forName("UTF-16"));
		headers.setContentType(mediaType);
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
	public String convertStringToDate(Date indate)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
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
			requestBody = requestBody+"<dateOfBirth>"+convertStringToDate(person.getDateOfBirth())+"</dateOfBirth>";
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
	public Person dedupingLogic(Person personParam,String sessionKey) {
		// PART 1: of the algorithm states that when all the required fields are null we should not insert the record in Open EMPI or HMIS database.
			if(!isRecordFitForMatching(personParam)) {
				throw new IllegalArgumentException("Everything in the person object is null.");
			}
			// sanitize SSN
			Person person = getSanitizedPerson(personParam);
		// PART 3: Now is the time to select a potential match.
			// Custom10 field is set to a value if the client provides partial SSN.
			 if(StringUtils.isNotEmpty(person.getSsn())  && person.getSsn().length() ==9)  {
					List<Person>  unMatchedPersons = getPersonsBySSN(person,sessionKey);
					// PART 6 : Complete SSN AND • Two of (First Name/First Name Alias, Last Name/Last Name Alias, Date of Birth)
					List<Person> matchingPersons = unMatchingRecordsForCompleteSSN(unMatchedPersons,person);
					if(CollectionUtils.isNotEmpty(matchingPersons) && matchingPersons.size() != 1) {
						deleteFromPotentialMatches(matchingPersons, person);
					}
					// If the total match likely equals 1 then return it
					//	-- Part 8 IF Total Likely Matches = 1 MATCH FOUND
					if(matchingPersons !=null && CollectionUtils.isNotEmpty(matchingPersons) ){
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
				if(CollectionUtils.isNotEmpty(finalPersons)) {
					Person finalPerson =  (Person) finalPersons.get(0);
					finalPerson.setCustom20(getUniqueIdentifier(finalPerson.getPersonIdentifiers()));
					return finalPerson;
				}
			}
			// When no match found lets insert a new record.
			//-- Part 9 Likely Matches = 0  INSERT NEW RECORD
			  Person newlyAddedPerson  = createUser(person, sessionKey);
			  if(newlyAddedPerson != null) {
				  newlyAddedPerson.setCustom20(getUniqueIdentifier(newlyAddedPerson.getPersonIdentifiers()));
			  }
//			  if(newlyAddedPerson !=null ) {
//				  return getUniqueIdentifier(newlyAddedPerson.getPersonIdentifiers());
//			  }
			return newlyAddedPerson;
	}
	
	private Person getSanitizedPerson(Person personParam) {
		Person person = new Person();
		person.setSsn(sanitizeSSN(personParam.getSsn()));
		person.setFamilyName(StringUtils.isNotEmpty(personParam.getFamilyName()) ? personParam.getFamilyName().toLowerCase() : personParam.getFamilyName() );
		person.setGivenName(StringUtils.isNotEmpty(personParam.getGivenName()) ? personParam.getGivenName().toLowerCase() : personParam.getGivenName() );
		person.setDateOfBirth(personParam.getDateOfBirth());
		return person;
	}

	private String sanitizeSSN(String ssn) {
		if(StringUtils.isNotEmpty(ssn)) {
			String newSSN = ssn.replaceAll("[^a-zA-Z0-9\\s+]", "");
			String finalSSN = newSSN.replaceAll("[a-zA-Z]","");
			
			if(StringUtils.equals(finalSSN, "123456789")  || 
			   StringUtils.equals(finalSSN, "000000001")  || 
			   StringUtils.equals(finalSSN, "000000000")  || 
			   StringUtils.equals(finalSSN, "111111111")  || 
			   StringUtils.equals(finalSSN, "xxxxxxxxx")  || 
			   StringUtils.equals(finalSSN, "0")) {
				return StringUtils.EMPTY;
			}
			
			return finalSSN;
		}
		return ssn;
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
	protected String getUniqueIdentifier(Set<PersonIdentifier> personIdentifiers) {
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
					if(StringUtils.equalsIgnoreCase(matchingPerson.getFamilyName(), person.getFamilyName())) {
						points++;
					}
					if(StringUtils.equalsIgnoreCase(matchingPerson.getGivenName(), person.getGivenName())) {
						points++;
					}
					if(person.getDateOfBirth()!=null && matchingPerson.getDateOfBirth()!=null) {
						if(DateUtils.isSameDay(person.getDateOfBirth(), matchingPerson.getDateOfBirth())) {
							points = points+2;
						}else{
							LocalDate personDOB = person.getDateOfBirth().toInstant()
				                       .atZone(ZoneId.systemDefault())
				                       .toLocalDate();
							LocalDate matchingPersonDOB = matchingPerson.getDateOfBirth().toInstant()
				                       .atZone(ZoneId.systemDefault())
				                       .toLocalDate();
							long days = ChronoUnit.DAYS.between(personDOB, matchingPersonDOB);
							if(days < 5 && days > -5) {
								points++;
							}
						}
						
					}
					
					if(StringUtils.isNotBlank(matchingPerson.getSsn())  && StringUtils.isNotBlank(person.getSsn()) && StringUtils.equals(matchingPerson.getSsn(), person.getSsn())) {
						points = points+3;
					}
					person.setPoints(points);
					
					if(points >= 3) {
						matchingPersons.add(person);	
					}
				}
			}
			Comparator<Person> pointsComparator 
		      = Comparator.comparingInt(Person::getPoints);
			Comparator<Person> pointsComparatorReverse
		      = pointsComparator.reversed();
			matchingPersons.sort(pointsComparatorReverse);
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
					if(StringUtils.equalsIgnoreCase(matchingPerson.getFamilyName(), person.getFamilyName())) {
						points++;
					}
					if(StringUtils.equalsIgnoreCase(matchingPerson.getGivenName(), person.getGivenName())) {
						points++;
					}
					if(person.getDateOfBirth()!=null && matchingPerson.getDateOfBirth()!=null) {
						if(DateUtils.isSameDay(person.getDateOfBirth(), matchingPerson.getDateOfBirth())) {
							points = points+2;
						}else{
							LocalDate personDOB = person.getDateOfBirth().toInstant()
				                       .atZone(ZoneId.systemDefault())
				                       .toLocalDate();
							LocalDate matchingPersonDOB = matchingPerson.getDateOfBirth().toInstant()
				                       .atZone(ZoneId.systemDefault())
				                       .toLocalDate();
							long days = ChronoUnit.DAYS.between(personDOB, matchingPersonDOB);
							if(days < 5 || days > -5) {
								points++;
							}
						}
						
					}
					
					if(StringUtils.equals(matchingPerson.getSsn(), person.getSsn())) {
						points = points+3;
					}
					person.setPoints(points);
					
					if(points >= 4) {
						matchingPersons.add(person);	
					}
				}
			}
			
			Comparator<Person> pointsComparator 
		      = Comparator.comparingInt(Person::getPoints);
			Comparator<Person> pointsComparatorReverse
		      = pointsComparator.reversed();
			matchingPersons.sort(pointsComparatorReverse);

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
					if(StringUtils.isNotBlank(person.getSsn()) && !StringUtils.equals(newPerson.getSsn(), person.getSsn())) {
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
 		try {
 			LinkedHashMap<Object, Object>  personIdentifiersLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("personIdentifiers");
 	 		if(personIdentifiersLinkedList !=null) {
 	 			String identifier = (String)personIdentifiersLinkedList.get("identifier");
 	 			PersonIdentifier personIdentifier = new PersonIdentifier();
 	 			personIdentifier.setIdentifier(identifier);
 	 			person.addPersonIdentifier(personIdentifier);
 	 		}
 		} catch(ClassCastException ex) {
 			// There is a possiblitity that we have multiple personalIdentifiers
 			ArrayList<LinkedHashMap<Object, Object>>  personIdentifiersList = (ArrayList<LinkedHashMap<Object, Object>>)linkedPersons.get("personIdentifiers");
 	 		if(CollectionUtils.isNotEmpty(personIdentifiersList)) {
 	 			LinkedHashMap<Object, Object> personIdentifiersLinkedList = personIdentifiersList.get(0);
 	 			String identifier = (String)personIdentifiersLinkedList.get("identifier");
 	 			PersonIdentifier personIdentifier = new PersonIdentifier();
 	 			personIdentifier.setIdentifier(identifier);
 	 			person.addPersonIdentifier(personIdentifier);
 	 		}
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
	 
	protected Date getDateInFormat(String dob) {
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
	
	public static void main(String args[]) throws Exception {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
		DedupServiceImpl dedup = new DedupServiceImpl();
		  Person person = new Person();
	        person.setFamilyName("asdfasdf");
	        person.setGivenName("asdfasdf");
	        person.setSsn("asdfasdfasdfasdf");
	        person.setDateOfBirth(formatter.parse("1996-01-20"));
		Person dedupingLogic = dedup.dedupingLogic(person, "asdfasdfasfd");
		System.out.println(" Dedup:"+dedupingLogic.getCustom20());
	}
}
