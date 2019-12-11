package com.servinglynk.hmis.warehouse.dao.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.servinglynk.hmis.warehouse.AwsS3Client;
import com.servinglynk.hmis.warehouse.csv.Assessment;
import com.servinglynk.hmis.warehouse.csv.AssessmentQuestions;
import com.servinglynk.hmis.warehouse.csv.AssessmentResults;
import com.servinglynk.hmis.warehouse.csv.Client;
import com.servinglynk.hmis.warehouse.csv.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.csv.Disabilities;
import com.servinglynk.hmis.warehouse.csv.EmployementEducation;
import com.servinglynk.hmis.warehouse.csv.Enrollment;
import com.servinglynk.hmis.warehouse.csv.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.csv.Event;
import com.servinglynk.hmis.warehouse.csv.Exit;
import com.servinglynk.hmis.warehouse.csv.Export;
import com.servinglynk.hmis.warehouse.csv.Funder;
import com.servinglynk.hmis.warehouse.csv.HealthAndDV;
import com.servinglynk.hmis.warehouse.csv.IncomeBenefits;
import com.servinglynk.hmis.warehouse.csv.Inventory;
import com.servinglynk.hmis.warehouse.csv.Organization;
import com.servinglynk.hmis.warehouse.csv.Project;
import com.servinglynk.hmis.warehouse.csv.ProjectCOC;
import com.servinglynk.hmis.warehouse.csv.Services;
import com.servinglynk.hmis.warehouse.csv.Site;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.FirstName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.LastName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.MiddleName;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client.SSN;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Education;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHSP;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntrySSVF;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExportPeriod;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Moveindate;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYAfterCare;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@Component
public class BulkUploadHelper2020 {
	
	@Autowired
	Environment  env;
	/**
	 * Gets the source object from the upload location.
	 * @param upload
	 * @return sources
	 * @throws Exception 
	 */
	public Sources getSourcesFromFiles(BulkUpload upload,ProjectGroupEntity projectGroupEntity,Boolean isFileFromS3) throws Exception {
			String inputPath = upload.getInputpath();
			// download file to temp folder
			String tempFile = upload.getInputpath();
			if(BooleanUtils.isTrue(isFileFromS3)) {
				AwsS3Client client = new AwsS3Client(env.getProperty("aws_access_key_id"),env.getProperty("aws_secret_access_key"));
				tempFile = client.downloadFile(projectGroupEntity.getBucketName(), upload.getInputpath(),null);
			}
			if(inputPath !=null && StringUtils.equals("zip",getFileExtension(upload.getInputpath())) || StringUtils.equals("7z",getFileExtension(upload.getInputpath()))){
				return getSourcesForZipFile(tempFile);
			}
			else if(inputPath !=null && StringUtils.equals("xml",getFileExtension(upload.getInputpath()))){
				return getSourcesForXml(tempFile,projectGroupEntity);
			}
		return null;
	}
	/**
	 * Gets the Sources XML object when the file to be bulk uploaded is an XML file.
	 * @param upload
	 * @return
	 * @throws JAXBException 
	 */
	public Sources getSourcesForXml(String fileName,ProjectGroupEntity projectGroupEntity) throws JAXBException {
			File file = new File(fileName);
//			if(validateXMLSchema(upload.getInputPath(),"C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_HMIS.xsd")) {
//				System.out.println("XML is valid");
//			}else{
//				System.out.println("XML is NOT valid");
//			}
			
		    File tempFile = new File(fileName+System.currentTimeMillis()+"temp.xml");
			try {
				
				boolean skipUserIdentities = projectGroupEntity.isSkipuseridentifers();
				FileInputStream fis = new FileInputStream(file);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				FileWriter fstream = new FileWriter(tempFile, false);
				BufferedWriter out = new BufferedWriter(fstream);
				String aLine = null;
				while ((aLine = in.readLine()) != null) {
				  if(skipUserIdentities) {
				      //Process each line and add output to Dest.txt file
				      if(aLine.indexOf("<hmis:FirstName>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:FirstName[^>]*>.*?</hmis:FirstName>",
                                  "");
				      }
				      if(aLine.indexOf("<hmis:LastName>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:LastName[^>]*>.*?</hmis:LastName>",
				                                    "");
				      }
				      if(aLine.indexOf("<hmis:SSN>") != -1)  {
				    	  aLine = aLine.replaceAll("(?s)<hmis:SSN[^>]*>.*?</hmis:SSN>",
				                                    "");
				      }
				      if(aLine.indexOf("<hmis:DOB>") != -1)  {
				    	  String dob = aLine;
				    	  try {
				    	  aLine = aLine.substring(aLine.indexOf(":DOB>")+5,aLine.indexOf("</hmis:DOB>"));
				    	  aLine = "<hmis:DOB>"+aLine.substring(0, 8)+"01</hmis:DOB>";
				    	  }catch(IllegalArgumentException e) {
				    		  aLine = dob;
				    	  }
				      }
				    }
				      if(StringUtils.isNotEmpty(aLine.trim())) {
				    	  if(aLine.contains(":Sources")) {
				    		  aLine = aLine.replaceAll("hmis_0:", "");
				    		  aLine = aLine.replaceAll("hmis_1:", "");
				    	  }
				    	  aLine = aLine.replaceAll("hmis:", "");
				    	  out.write(aLine);
				    	  out.newLine();
				      }
				     }
				     // do not forget to close the buffer reader
				     in.close();
				     // close buffer writer
				     out.close();
			}catch (IOException e) {
				        //Simple exception handling, replace with what's necessary for your use case!
				        throw new RuntimeException("Generating file failed", e);
				     }
			JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sources sources = (Sources) jaxbUnmarshaller.unmarshal(tempFile);
			return sources;
	}
	
	 private boolean validateXMLSchema(String xsdPath, String xmlPath){
         
	        try {
	            SchemaFactory factory = 
	                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(xsdPath));
	            Validator validator = (Validator) schema.newValidator();
					validator.validate(new StreamSource(new File(xmlPath)));
	        } catch ( SAXException |JAXBException e) {
	            System.out.println("Exception: "+e.getMessage());
	            return false;
	        }
	        return true;
	    }
	/**
	 * Gets the Sources XML object when the file to be bulk uploaded is an Zip file 
	 * containing csv files.
	 * @param upload
	 * @return
	 * @throws Exception 
	 */
	public Sources getSourcesForZipFile(String fileName) throws Exception {
		Sources sources = new Sources();
		Source source = sources.getSource();
		if(source == null) {
			Source newSource = new Source();
			sources.setSource(newSource);
			newSource.setExport(new Sources.Source.Export());
		}
		try {
			ZipFile zf = new ZipFile(fileName);
		      Enumeration entries = zf.entries();
		      while (entries.hasMoreElements()) {
		        ZipEntry ze = (ZipEntry) entries.nextElement();
		        System.out.println("Read " + ze.getName() + "?");
		            BufferedReader csvFile = new BufferedReader(
		                new InputStreamReader(zf.getInputStream(ze)));
		            String lowerCase = ze.getName().toLowerCase();
		            String stripHmis=lowerCase.replace("hmis", "");
		            switch(stripHmis) {
		            	case "affiliation.csv":
		            		hydrateAffiliation(csvFile, sources);
		            		break;
		            	case "assessment.csv":
		            		hydrateAssessment(csvFile, sources);
		            		break;
		            	case "assessmentquestions.csv":
		            		hydrateAssessmentQuestions(csvFile, sources);
		            		break;
		            	case "assessmentresults.csv":
		            		hydrateAssessmentResults(csvFile, sources);
		            		break;
		            	case "event.csv":
		            		hydrateEvent(csvFile, sources);
		            		break;
		            	case "currentlivingsituation.csv":
		            		hydrateCurrentLivingSituation(csvFile, sources);
		            		break;
		            	case "client.csv":
		            		hydrateClient(csvFile, sources);
		            		break;
		            	case "disabilities.csv":
		            		hydrateDisabilities(csvFile, sources);
		            		break;
		            	case "employmenteducation.csv":
		            		hydrateEmployementEducation(csvFile,sources);
		            		break;
		            	case "enrollment.csv":
		            		hydrateEnrollment(csvFile, sources);
		            		break;
		            	case "enrollmentcoc.csv":
		            		hydrateEnrollmentCoC(csvFile, sources);
		            		break;
		            	case "exit.csv":
		            		hydrateExit(csvFile, sources);
		            		break;
		            	case "export.csv":
		            		hydrateExport(csvFile, sources);
		            		break;
		            	case "funder.csv":
		            		hydrateFunder(csvFile, sources);
		            		break;		            		
		            	case "healthanddv.csv":
		            		hydrateHealthAndDV(csvFile, sources);
		            		break;
		            	case "incomebenefits.csv":
		            		hydrateIncomeBenefits(csvFile, sources);
		            		break;
		            	case "inventory.csv":
		            		hydrateInventory(csvFile, sources);
		            		break;
		            	case "organization.csv":
		            		hydrateOrganization(csvFile, sources);
		            		break;
		            	case  "project.csv" :
		            		hydrateProject(csvFile, sources);
		            		break;
		            	case "projectcoc.csv":
		            		hydrateCoc(csvFile, sources);
		            		break;
		            	case "services.csv":
		            		hydrateServices(csvFile, sources);
		            		break;
		            	case "site.csv":
		            		hydrateSite(csvFile, sources);
		            		break;
		            		
		            	default:
		            		break;
		            }
		           
		            csvFile.close();
		      }
		      
		    }
			catch (IOException e) {
		      e.printStackTrace();
		    } 
		return sources;
	}

	/**
	 * Hydrate Client with in Sources.Export.
	 * @param csvFile
	 * @param sources
	 * @throws Exception
	 */
	private void hydrateAffiliation(BufferedReader csvFile, Sources sources) throws Exception {
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation> affiliationList = new ArrayList<Sources.Source.Export.Affiliation>();
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<com.servinglynk.hmis.warehouse.csv.Affiliation> csvReader = new CSVReaderBuilder<com.servinglynk.hmis.warehouse.csv.Affiliation>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<com.servinglynk.hmis.warehouse.csv.Affiliation>(com.servinglynk.hmis.warehouse.csv.Affiliation.class, vpp)).build();
	      try {
	      List<com.servinglynk.hmis.warehouse.csv.Affiliation> affiliations = csvReader.readAll(); 
	      if(CollectionUtils.isNotEmpty(affiliations)) {
	    	  for(com.servinglynk.hmis.warehouse.csv.Affiliation affiliation : affiliations) {
	    		  Affiliation affiliationModel = new Affiliation();
	    		  affiliationModel.setAffiliationID(affiliation.getAffiliationID());
	    		  affiliationModel.setDateCreated(getXMLGregorianCalendar(affiliation.getDateCreated()));
	    		  affiliationModel.setDateUpdated(getXMLGregorianCalendar(affiliation.getDateUpdated()));
	    		  affiliationModel.setProjectID(affiliation.getProjectID());
	    		  affiliationModel.setResProjectID(affiliation.getResProjectID());
	    		  affiliationModel.setUserID(affiliation.getUserID());
	    		  affiliationList.add(affiliationModel);
	    	  }
	      }
	      sources.getSource().getExport().setAffiliation(affiliationList);
		 }catch(Exception e) {
	   	  throw new Exception("Affiliation.csv Invalid file format : "+e.getMessage(),e);
	     }
	}
	/**
	 * Hydrate Client with in Sources.Export.
	 * @param csvFile
	 * @param sources
	 * @throws Exception
	 */
	  protected void hydrateClient(BufferedReader csvFile,Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Client> csvReader = new CSVReaderBuilder<Client>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Client>(Client.class, vpp)).build();
	      List<Client> clients = csvReader.readAll(); 
	      try{
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client> clientList = new ArrayList<Sources.Source.Export.Client>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo> veteranInfoList = new ArrayList<Sources.Source.Export.ClientVeteranInfo>();
	      if(clients !=null && clients.size() > 0) {
	    	  for(Client client : clients) {
	    		   com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client clientModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client();
	    		   clientModel.setEthnicity((client.getEthnicity()));
	    		   clientModel.setDOB(getXMLGregorianCalendar(client.getDob()));
	    		   clientModel.setDOBDataQuality((client.getDobDataQuality()));
	    		   FirstName  firstName = new FirstName();
	    		   firstName.setValue(client.getFirstName());
	    		   clientModel.setFirstName(firstName);
	    		   LastName lastName = new LastName();
	    		   lastName.setValue(client.getLastName());
	    		   clientModel.setLastName(lastName);
	    		   MiddleName middleName = new MiddleName();
	    		   middleName.setValue(client.getMiddleName());
	    		   clientModel.setMiddleName(middleName);
	    		   clientModel.setGender((client.getGender()));
	    		   clientModel.setNameDataQuality((client.getNameDataQuality()));
	    		   clientModel.setNameSuffix(client.getNameSuffix());
	    		   clientModel.setPersonalID(client.getPersonalID());
	    		   if(StringUtils.equals(client.getAsian(), "1")) {
	    			   clientModel.setRace("2");
	    		   }else if (StringUtils.equals(client.getAmIndAKNative(), "1")) {
	    			   clientModel.setRace("1");
	    		   }else if (StringUtils.equals(client.getBlackAfAmerican(), "1")) {
	    			   clientModel.setRace("3");
	    		   }else if (StringUtils.equals(client.getNativeHIOtherPacific(), "1")) {
	    			   clientModel.setRace("4");
	    		   }else if (StringUtils.equals(client.getWhite(), "1")) {
	    			   clientModel.setRace("5");
	    		   }else if (StringUtils.isNotBlank(client.getRaceNone())) {
	    			   clientModel.setRace(client.getRaceNone());
	    		   }
	    		   SSN ssn = new SSN();
	    		   ssn.setValue(client.getSsn());
	    		   clientModel.setSSN(ssn);
	    		   clientModel.setSSNDataQuality((client.getSsnDataQuality()));
	    		   clientModel.setUserID(client.getUserID());
	    		   clientModel.setVeteranStatus((client.getVeteranStatus()));
	    		   clientModel.setDateCreated(getXMLGregorianCalendar(client.getDateCreated()));
	    		   clientModel.setDateUpdated(getXMLGregorianCalendar(client.getDateUpdated()));
	    		   clientList.add(clientModel);
	    		   
	    		   ClientVeteranInfo veteranInfoModel = new ClientVeteranInfo();
	    		   veteranInfoModel.setAfghanistanOEF((client.getAfghanistanOEF()));
	    		   veteranInfoModel.setDateCreated(getXMLGregorianCalendar(client.getDateCreated()));
	    		   veteranInfoModel.setDateUpdated(getXMLGregorianCalendar(client.getDateUpdated()));
	    		   veteranInfoModel.setDesertStorm((client.getDesertStorm()));
	    		   veteranInfoModel.setDischargeStatus((client.getDischargeStatus()));
	    		   veteranInfoModel.setIraqOIF((client.getIraqOIF()));
	    		   veteranInfoModel.setIraqOND((client.getIraqOND()));
	    		   veteranInfoModel.setKoreanWar((client.getKoreanWar()));
	    		   veteranInfoModel.setMilitaryBranch((client.getMilitaryBranch()));
	    		   veteranInfoModel.setOtherTheater((client.getOtherTheater()));
	    		   veteranInfoModel.setPersonalID(client.getPersonalID());
	    		   veteranInfoModel.setUserID(client.getUserID());
	    		   veteranInfoModel.setClientVeteranInfoID(client.getPersonalID());
	    		   veteranInfoModel.setVietnamWar((client.getVietnamWar()));
	    		   veteranInfoModel.setWorldWarII((client.getWorldWarII()));
	    		   if (client.getYearEnteredService()!=null && !"".equals(client.getYearEnteredService()) ) {
	    			   veteranInfoModel.setYearEnteredService(Short.valueOf(client.getYearEnteredService()));
	    		   }
	    		   if (client.getYearSeparated()!=null && !"".equals(client.getYearSeparated()) ) {
	    			   veteranInfoModel.setYearSeparated(Short.valueOf(client.getYearSeparated()));
	    		   }
	    		   veteranInfoList.add(veteranInfoModel);
	    	  }
	    	  sources.getSource().getExport().setClients(clientList);
	    	  sources.getSource().getExport().setClientVeteranInfo(veteranInfoList);
	      	}
	      }catch(Exception e) {
		   	  throw new Exception("Client.csv Invalid file format : "+e.getMessage(),e);
		     }
	  }
	  /**
	   * Hydrate Disabilities with in Sources Object from Disabilities CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateDisabilities(BufferedReader csvFile,Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Disabilities> csvReader = new CSVReaderBuilder<Disabilities>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Disabilities>(Disabilities.class, vpp)).build();
	      try{
	      List<Disabilities> disabilities = csvReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities> disabilitiesList = new ArrayList<Sources.Source.Export.Disabilities>();
	      for(Disabilities disability : disabilities) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities disabilitiesModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities();
	    	  disabilitiesModel.setDataCollectionStage((disability.getDataCollectionStage()));
	    	  disabilitiesModel.setDateCreated(getXMLGregorianCalendar(disability.getDateCreated()));
	    	  disabilitiesModel.setDateUpdated(getXMLGregorianCalendar(disability.getDateUpdated()));
	    	  disabilitiesModel.setTCellCount(disability.getTCellCount());
	    	  disabilitiesModel.setTCellCountAvailable(disability.getTCellCountAvailable());
	    	  disabilitiesModel.setTCellSource(disability.getTCellSource());
	    	  disabilitiesModel.setDisabilitiesID(disability.getDisabilitiesID());
	    	  disabilitiesModel.setDisabilityResponse((disability.getDisabilityResponse()));
	    	  disabilitiesModel.setDisabilityType((disability.getDisabilityType()));
	    	  disabilitiesModel.setInformationDate(getXMLGregorianCalendar(disability.getInformationDate()));
	    	  disabilitiesModel.setEnrollmentID(disability.getEnrollmentID());
	    	  disabilitiesModel.setUserID(disability.getUserID());
	    	  disabilitiesModel.setIndefiniteAndImpairsIndependence((disability.getIndefiniteAndImpairs()));
	    	  disabilitiesModel.setViralLoad(getIntValue(disability.getViralLoad()));
	    	  disabilitiesModel.setViralLoadAvailable(disability.getViralLoadAvailable());
	    	  disabilitiesModel.setViralLoadSource((disability.getViralLoadSource()));
	    	  disabilitiesList.add(disabilitiesModel);
	      }
	      sources.getSource().getExport().setDisabilities(disabilitiesList);
	  }catch(Exception e) {
	   	  throw new Exception("Client.csv Invalid file format : "+e.getMessage(),e);
	     }
	  }
	 /**
	   * Hydrate Employment Education with in Sources Object from Disabilities CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	protected void hydrateEmployementEducation(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<EmployementEducation> employementReader = new CSVReaderBuilder<EmployementEducation>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<EmployementEducation>(EmployementEducation.class, vpp)).build();
	      try {
	      List<EmployementEducation> employementEdu = employementReader.readAll();
	      List<Employment> employmentList = new ArrayList<Sources.Source.Export.Employment>();
	      List<Education> educationList = new ArrayList<Sources.Source.Export.Education>();
	      if(employementEdu !=null && employementEdu.size() >0 ) {
	    	  for(EmployementEducation  employementEducationCSV : employementEdu) {
	    		  if(employementEducationCSV !=null) {
	    			  Employment employmentModel = new Employment();
	    			  employmentModel.setDataCollectionStage((employementEducationCSV.getDataCollectionStage()));
	    			  employmentModel.setDateCreated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  employmentModel.setDateUpdated(getXMLGregorianCalendar(employementEducationCSV.getDateUpdated()));
	    			  employmentModel.setEmployed((employementEducationCSV.getEmployed()));
	    			  employmentModel.setEmploymentID(employementEducationCSV.getEmploymentEducationID());
	    			  employmentModel.setEmploymentType((employementEducationCSV.getEmploymentType()));
	    			  employmentModel.setInformationDate(getXMLGregorianCalendar(employementEducationCSV.getInformationDate()));
	    			  employmentModel.setNotEmployedReason((employementEducationCSV.getNotEmployedReason()));
	    			  employmentModel.setEnrollmentID(employementEducationCSV.getEnrollmentyID());
	    			  employmentModel.setUserID(employementEducationCSV.getUserID());
	    			  employmentList.add(employmentModel);
	    			  
	    			  Education educationModel = new Education();
	    			  educationModel.setDataCollectionStage((employementEducationCSV.getDataCollectionStage()));
	    			  educationModel.setDateCreated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  educationModel.setDateUpdated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  educationModel.setEnrollmentID(employementEducationCSV.getEnrollmentyID());
	    			  educationModel.setEducationID(employementEducationCSV.getEmploymentEducationID());
	    			  educationModel.setInformationDate(getXMLGregorianCalendar(employementEducationCSV.getInformationDate()));
	    			  educationModel.setSchoolStatus(employementEducationCSV.getSchoolStatus());
	    			  educationModel.setLastGradeCompleted((employementEducationCSV.getLastGradeCompleted()));
	    			  educationList.add(educationModel);
	    		  }
	    		  sources.getSource().getExport().setEmployment(employmentList);
	    		  sources.getSource().getExport().setEducation(educationList);
	    	  }
	      }
	      }catch(Exception e) {
		   	  throw new Exception("EmploymentEducation.csv Invalid file format : "+e.getMessage(),e);
		     }
	  }
	  /**
	   * Hydrate Enrollment with in Sources Object from Enrollment CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateEnrollment(BufferedReader csvFile,Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Enrollment> enrollmentReader = new CSVReaderBuilder<Enrollment>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Enrollment>(Enrollment.class, vpp)).build();
	      try{
		      List<Enrollment> enrollment = enrollmentReader.readAll();
		      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollmentList = new ArrayList<Sources.Source.Export.Enrollment>();
		      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement> dateOfEngagementList = new ArrayList<Sources.Source.Export.DateOfEngagement>();
		      List<Moveindate> residentialmoveindateList = new ArrayList<Moveindate>();
		      List<RHYBCPStatus> rhybcpStatusList = new ArrayList<RHYBCPStatus>();
		      List<PATHStatus> pathStatusList = new ArrayList<PATHStatus>();
		      List<EntrySSVF>  entrySSVFList= new  ArrayList<EntrySSVF>();
		      List<EntryRHY> entryRHYList = new ArrayList<Sources.Source.Export.EntryRHY>();
		      List<EntryRHSP> entryRHSPList = new ArrayList<EntryRHSP>();
		      
		      for(Enrollment enroll : enrollment) {
		    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollmentModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment();
		    	  enrollmentModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  enrollmentModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  enrollmentModel.setDateToStreetESSH(getXMLGregorianCalendar(enroll.getDateToStreetESSH()));
		    	  enrollmentModel.setDisablingCondition(enroll.getDisablingCondition());
		    	  enrollmentModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  enrollmentModel.setEntryDate(getXMLGregorianCalendar(enroll.getEntryDate()));
		    	  enrollmentModel.setHouseholdID(enroll.getHouseholdID());
		    	  enrollmentModel.setLengthOfStay(enroll.getLengthOfStay());
		    	  enrollmentModel.setLivingSituation(enroll.getLivingSituation());
		    	  enrollmentModel.setLosUnderThreshold(enroll.getLOSUnderThreshold());
		    	  enrollmentModel.setPreviousStreetESSH(enroll.getPreviousStreetESSH());
		    	  enrollmentModel.setMonthsHomelessPastThreeYears(enroll.getMonthsHomelessPastThreeYears());
		    	  enrollmentModel.setPersonalID(enroll.getPersonalID());
		    	  enrollmentModel.setProjectID(enroll.getProjectID());
		    	  enrollmentModel.setRelationshipToHoH((enroll.getRelationshipToHoH()));
		    	  enrollmentModel.setTimesHomelessPastThreeYears(enroll.getTimesHomelessPastThreeYears());
		    	  enrollmentModel.setUserID(enroll.getUserID());
		    	  enrollmentList.add(enrollmentModel);
		    	  
		    	  DateOfEngagement dateOfEngagementModel = new DateOfEngagement();
		    	  dateOfEngagementModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  dateOfEngagementModel.setDateOfEngagement(getXMLGregorianCalendar(enroll.getDateOfEngagement()));
		    	  dateOfEngagementModel.setDateOfEngagementID(enroll.getEnrollmentID());
		    	  dateOfEngagementModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  dateOfEngagementModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  dateOfEngagementModel.setUserID(enroll.getUserID());
		    	  dateOfEngagementList.add(dateOfEngagementModel);
		    	  
		    	  Moveindate residentialmoveindateModel = new Moveindate();
		    	  residentialmoveindateModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  residentialmoveindateModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  residentialmoveindateModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  residentialmoveindateModel.setMoveInDate(getXMLGregorianCalendar(enroll.getMoveInDate()));
		    	  residentialmoveindateModel.setMoveInDateID(enroll.getEnrollmentID());
		    	  residentialmoveindateModel.setUserID(enroll.getUserID());
		    	  residentialmoveindateList.add(residentialmoveindateModel);
		    	  
		    	  PATHStatus pathstatusModel = new PATHStatus();;
		    	  pathstatusModel.setClientEnrolledInPATH(enroll.getClientEnrolledInPATH());
		    	  pathstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  pathstatusModel.setDateOfStatus(getXMLGregorianCalendar(enroll.getDateOfPATHStatus()));
		    	  pathstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  pathstatusModel.setPathStatusID(enroll.getEnrollmentID());
		    	  pathstatusModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  pathstatusModel.setReasonNotEnrolled(enroll.getReasonNotEnrolled());
		    	  pathstatusModel.setUserID(enroll.getUserID());
		    	  pathStatusList.add(pathstatusModel);
	
		    	  RHYBCPStatus rhybcpstatusModel = new RHYBCPStatus();
		    	  rhybcpstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  rhybcpstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  rhybcpstatusModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  rhybcpstatusModel.setEligibleForRHY(enroll.getEligibleForRHY());
		    	  rhybcpstatusModel.setStatusDate(getXMLGregorianCalendar(enroll.getDateOfBCPStatus()));
		    	  rhybcpstatusModel.setRunawayYouth(enroll.getRunawayYouth());
		    	  rhybcpstatusModel.setReasonNoServices((enroll.getReasonNoServices()));
		    	  rhybcpstatusModel.setRHYBCPStatusID(enroll.getEnrollmentID());
		    	  rhybcpstatusModel.setUserID(enroll.getUserID());
		    	  rhybcpStatusList.add(rhybcpstatusModel);
		    	  
		    	  EntrySSVF entrySSVFModel = new EntrySSVF();
		    	  entrySSVFModel.setAddressDataQuality(enroll.getAddressDataQuality());
		    	  entrySSVFModel.setHpsScreeningScore(enroll.getHPScreeningScore());
		    	  entrySSVFModel.setLastPermanentCity(enroll.getLastPermanentCity());
		    	  entrySSVFModel.setLastPermanentState(enroll.getLastPermanentState());
		    	  entrySSVFModel.setLastPermanentStreet(enroll.getLastPermanentStreet());
		    	  if(StringUtils.isNotBlank(enroll.getLastPermanentZIP()))
		    		  entrySSVFModel.setLastPermanentZIP(getIntValue(enroll.getLastPermanentZIP()));
		    	  entrySSVFModel.setPercentAMI(enroll.getPercentAMI());
		    	  entrySSVFModel.setEnrollmentID(enroll.getEnrollmentID());
		    	  entrySSVFModel.setVAMCStation(enroll.getVAMCStation());
		    	  entrySSVFModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  entrySSVFModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  entrySSVFModel.setUserID(enroll.getUserID());
		    	  entrySSVFModel.setEntrySSVFID(enroll.getEnrollmentID());
		    	  entrySSVFList.add(entrySSVFModel);
		    	  
		    	  EntryRHY entryRHY = new EntryRHY();
		
		    	  entryRHY.setAlcoholDrugAbuseFam((enroll.getAlcoholDrugAbuseFam()));
		    		    	  entryRHY.setChildWelfareMonths((enroll.getChildWelfareMonths()));
		    	  entryRHY.setChildWelfareYears((enroll.getChildWelfareYears()));
		    	  entryRHY.setEnrollmentID(enroll.getEnrollmentID());
		    	  entryRHY.setCountOutreachReferralApproaches((enroll.getCountOutreachReferralApproaches()));
		    	  entryRHY.setEntryRHYID(enroll.getEnrollmentID());
		    	  entryRHY.setSexualOrientation(enroll.getSexualOrientation());
		    	  entryRHY.setSexualOrientationOther(enroll.getSexualOrientationOther());
		    	  entryRHY.setFormerWardChildWelfare(enroll.getFormerWardChildWelfare());
		    	  entryRHY.setEntryRHYID(enroll.getEnrollmentID());
		    	  entryRHY.setFormerWardJuvenileJustice(enroll.getFormerWardJuvenileJustice());
		    	  entryRHY.setIncarceratedParent(enroll.getIncarceratedParent());
		    	  entryRHY.setInsufficientIncome(enroll.getInsufficientIncome());
		    	  entryRHY.setJuvenileJusticeMonths(enroll.getJuvenileJusticeMonths());
		    	  entryRHY.setJuvenileJusticeYears(enroll.getJuvenileJusticeYears());
		    	  entryRHY.setMentalHealthIssuesFam(enroll.getMentalHealthIssuesFam());
		    	  entryRHY.setPhysicalDisabilityFam(enroll.getPhysicalDisabilityFam());
		    	  entryRHY.setReferralSource(enroll.getReferralSource());
		    	  entryRHY.setUnemploymentFam(enroll.getUnemploymentFam());
		    	  entryRHYList.add(entryRHY);
		    	  
		    	  
		    	  EntryRHSP entryRHSP = new EntryRHSP();
		    	  entryRHSP.setEntryRHSPID(enroll.getEnrollmentID());
		    	  entryRHSP.setWorstHousingSituation(enroll.getWorstHousingSituation());
		    	  entryRHSP.setEnrollmentID(enroll.getEnrollmentID());
		    	  entryRHSP.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
		    	  entryRHSP.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
		    	  entryRHSP.setUserID(enroll.getUserID());
		    	  entryRHSPList.add(entryRHSP);
		    	  
		    	  /**
		    	   * ContinuouslyHomelessOneYear, MonthsHomelessThisTime, StatusDocumented, YearsHomeless --> These fields are missing in CSV Pojo file of Enrollment.
		    	   * 
		    	   * there are more fields which are not available in Enrollment Pojo under Export package comparing with CSV Enrollment POJO.
		    	   * 
		    	   * 
		    	   * */
		    	  sources.getSource().getExport().getEnrollment().add(enrollmentModel);
		      }
			  sources.getSource().getExport().setPATHStatus(pathStatusList);
	    	  sources.getSource().getExport().setRHYBCPStatus(rhybcpStatusList);
	    	  sources.getSource().getExport().setDateOfEngagement(dateOfEngagementList);
	    	  sources.getSource().getExport().setMoveInDate(residentialmoveindateList);
	    	  sources.getSource().getExport().setEntrySSVF(entrySSVFList);
	    	  sources.getSource().getExport().setEntryRHY(entryRHYList);
	  }catch(Exception e) {
	   	  throw new Exception("Enrollment.csv Invalid file format : "+e.getMessage(),e);
	     }
	  }
	  /**
	   * Hydrate EnrollmentCoc with in Sources Object from EnrollmentCoc CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateEnrollmentCoC(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<EnrollmentCoC> enrollmentCocReader = new CSVReaderBuilder<EnrollmentCoC>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<EnrollmentCoC>(EnrollmentCoC.class, vpp)).build();
	      try{
		      List<EnrollmentCoC> enrollmentCoc = enrollmentCocReader.readAll();
		      for(EnrollmentCoC enrollCoC : enrollmentCoc) {
		    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC enrollmentCocModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC();
		    	  enrollmentCocModel.setDataCollectionStage((enrollCoC.getDataCollectionStage()));
		    	  enrollmentCocModel.setDateCreated(getXMLGregorianCalendar(enrollCoC.getDateCreated()));
		    	  enrollmentCocModel.setDateUpdated(getXMLGregorianCalendar(enrollCoC.getDateUpdated()));
		    	  enrollmentCocModel.setEnrollmentCoCID(enrollCoC.getEnrollmentCOCID());
		    	  enrollmentCocModel.setHouseholdID(enrollCoC.getHouseholdID());
		    	  enrollmentCocModel.setInformationDate(getXMLGregorianCalendar(enrollCoC.getInformationDate()));
		    	  enrollmentCocModel.setCocCode(enrollCoC.getCoCCode());
		    	  enrollmentCocModel.setEnrollmentID(enrollCoC.getEnrollmentID());
		    	  enrollmentCocModel.setUserID(enrollCoC.getUserID());
		    	  sources.getSource().getExport().getEnrollmentCoC().add(enrollmentCocModel);
		      }
	  }catch(Exception e) {
	   	  throw new Exception("EnrollmentCoC.csv Invalid file format : "+e.getMessage(),e);
	     }
	  }
	  
	  /**
	   * Hydrate Exit with in Sources Object from Exit CSV Pojos.
	   * @param csvFile
	   * @param sourcesoe
	   * @throws Exception
	   */
	  protected void hydrateExit(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Exit> exitReader = new CSVReaderBuilder<Exit>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Exit>(Exit.class, vpp)).build();
	      try{
	      List<Exit> exit = exitReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit> exitList = new ArrayList<Sources.Source.Export.Exit>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition> housingAssessmentDispositionList = new ArrayList<Sources.Source.Export.HousingAssessmentDisposition>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment> exitHousingAssessmentList = new ArrayList<Sources.Source.Export.ExitHousingAssessment>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY> exitRhyList = new ArrayList<Sources.Source.Export.ExitRHY>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH> exitPATHList = new ArrayList<Sources.Source.Export.ExitPATH>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYAfterCare> rhyAfterCareList = new ArrayList<Sources.Source.Export.RHYAfterCare>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason> vashExitReasonList = new ArrayList<Sources.Source.Export.VASHExitReason>();
		   
	      for(Exit ext : exit) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit exitModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit();
	    	  exitModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitModel.setDestination((ext.getDestination()));
	    	  exitModel.setExitDate(getXMLGregorianCalendar(ext.getExitDate()));
	    	  exitModel.setExitID(ext.getExitID());
	    	  exitModel.setOtherDestination(ext.getOtherDestination());
	    	  exitModel.setEnrollmentID(ext.getEnrollmentID());
	    	  exitModel.setUserID(ext.getUserID());
	    	  exitList.add(exitModel);
	    	  sources.getSource().getExport().getExit().add(exitModel);
	    	  
	    	  HousingAssessmentDisposition housingAssessmentDispositionModel = new HousingAssessmentDisposition();
	    	  housingAssessmentDispositionModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  housingAssessmentDispositionModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  housingAssessmentDispositionModel.setExitID(ext.getExitID());
	    	  housingAssessmentDispositionModel.setHousingAssessmentDispositionID(ext.getHousingAssessment());
	    	  housingAssessmentDispositionModel.setUserID(ext.getUserID());
	    	  housingAssessmentDispositionList.add(housingAssessmentDispositionModel);
	    	  
	    	  VASHExitReason vashExitReasonModel = new VASHExitReason();
	    	  vashExitReasonModel.setCmExitReason(ext.getCMExitReason());
	    	  vashExitReasonModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  vashExitReasonModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  vashExitReasonModel.setUserID(ext.getUserID());
	    	  vashExitReasonModel.setExitID(ext.getExitID());
	    	  vashExitReasonModel.setVashExitReasonID(ext.getExitID());
	    	  vashExitReasonList.add(vashExitReasonModel);
	    	  
	      	  RHYAfterCare rhyAfterCareModel = new RHYAfterCare();
	      	  rhyAfterCareModel.setAfterCareDate(getXMLGregorianCalendar(ext.getAftercareDate()));
	      	  rhyAfterCareModel.setAfterCareProvided(ext.getAftercareProvided());
	      	  rhyAfterCareModel.setEmailSocialMedia(ext.getEmailSocialMedia());
	      	  rhyAfterCareModel.setInPersonGroup(ext.getInPersonGroup());
	      	  rhyAfterCareModel.setInPersonIndividual(ext.getInPersonIndividual());
	      	  rhyAfterCareModel.setRhyAfterCareID(ext.getExitID());
	      	  rhyAfterCareModel.setTelephone(ext.getTelephone());
	    	  rhyAfterCareModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  rhyAfterCareModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  rhyAfterCareModel.setExitID(ext.getExitID());
	    	  rhyAfterCareModel.setUserID(ext.getUserID());
	    	  rhyAfterCareList.add(rhyAfterCareModel);
	    	  
	    	  ExitHousingAssessment exitHousingAssessmentModel = new ExitHousingAssessment();
	    	  exitHousingAssessmentModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitHousingAssessmentModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitHousingAssessmentModel.setUserID(ext.getUserID());
	    	  exitHousingAssessmentModel.setExitHousingAssessmentID(ext.getExitID());
	    	  exitHousingAssessmentModel.setExitID(ext.getExitID());
	    	  exitHousingAssessmentModel.setHousingAssessment((ext.getHousingAssessment()));
	    	  exitHousingAssessmentModel.setSubsidyInformation((ext.getSubsidyInformation()));
	    	  exitHousingAssessmentList.add(exitHousingAssessmentModel);
	    	  
	    	  ExitRHY exitRHYModel = new ExitRHY();
	    	  exitRHYModel.setProjectCompletionStatus(ext.getProjectCompletionStatus());
	    	  exitRHYModel.setEarlyExitReason(ext.getEarlyExitReason());
	    	  exitRHYModel.setExitRHYID(ext.getExitID());
	    	  exitRHYModel.setExitID(ext.getExitID());
	    	  exitRHYModel.setAskedOrForcedToExchangeForSex(ext.getAskedOrForcedToExchangeForSex());
	    	  exitRHYModel.setAskedOrForcedToExchangeForSexPastThreeMonths(ext.getAskedOrForcedToExchangeForSexPastThreeMonths());
	    	  exitRHYModel.setCoercedToContinueWork(ext.getCoercedToContinueWork());
	    	  exitRHYModel.setCounselingReceived(ext.getCounselingReceived());
	    	  exitRHYModel.setCountOfExchangeForSex(ext.getCountOfExchangeForSex());
	    	  exitRHYModel.setDestinationSafeClient(ext.getDestinationSafeClient());
	    	  exitRHYModel.setDestinationSafeWorker(ext.getDestinationSafeWorker());
	    	  exitRHYModel.setEarlyExitReason(ext.getEarlyExitReason());
	    	  exitRHYModel.setExchangeForSex(ext.getExchangeForSex());
	    	  exitRHYModel.setExchangeForSexPastThreeMonths(ext.getExchangeForSexPastThreeMonths());
	    	  exitRHYModel.setFamilyCounseling(ext.getFamilyCounseling());
	    	  exitRHYModel.setGroupCounseling(ext.getGroupCounseling());
	    	  exitRHYModel.setIndividualCounseling(ext.getIndividualCounseling());
	    	  exitRHYModel.setLaborExploitPastThreeMonths(ext.getLaborExploitPastThreeMonths());
	    	  exitRHYModel.setPosAdultConnections(ext.getPosAdultConnections());
	    	  exitRHYModel.setPosCommunityConnections(ext.getPosCommunityConnections());
	    	  exitRHYModel.setPosPeerConnections(ext.getPosPeerConnections());
	    	  exitRHYModel.setPostExitCounselingPlan(ext.getPostExitCounselingPlan());
	    	  exitRHYModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitRHYModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitRHYModel.setUserID(ext.getUserID());
	    	  exitRhyList.add(exitRHYModel);
	      }
	      sources.getSource().getExport().setHousingAssessmentDisposition(housingAssessmentDispositionList);
	      sources.getSource().getExport().setExitHousingAssessment(exitHousingAssessmentList);
	      sources.getSource().getExport().setExitPATH(exitPATHList);
	      sources.getSource().getExport().setExitRHY(exitRhyList);
	      sources.getSource().getExport().setVashExitReason(vashExitReasonList);
	      sources.getSource().getExport().setRhyAfterCaren(rhyAfterCareList);
	  }catch(Exception e) {
	   	  throw new Exception("Exit.csv Invalid file format : "+e.getMessage(),e);
	     }
	  }
	  
	  /**
	   * Hydrate Export with in Sources Object from Export CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateExport(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Export> exportReader = new CSVReaderBuilder<Export>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Export>(Export.class, vpp)).build();
	      try{
	      List<Export> export = exportReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export> exportList = new ArrayList<Sources.Source.Export>();
	      for(Export exp : export){
	    	  sources.getSource().getExport().setExportDate(getXMLGregorianCalendar(exp.getExportDate()));
	    	  sources.getSource().getExport().setExportDirective(exp.getExportDirective());
	    	  sources.getSource().getExport().setExportID(exp.getExportID());
	    	  ExportPeriod exportPeriod = new ExportPeriod();
	    	  exportPeriod.setEndDate(getXMLGregorianCalendar(exp.getExportEndDate()));
	    	  exportPeriod.setStartDate(getXMLGregorianCalendar(exp.getExportStartDate()));
	    	  sources.getSource().getExport().setExportPeriodType(exp.getExportPeriodType());
	      }
	  }catch(Exception e) {
	   	  throw new Exception("Export.csv Invalid file format : "+e.getMessage(),e);
	     }
	  }
	      
	  /**
	   * Hydrate Funder with in Sources Object from Funder CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateFunder(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Funder> funderReader = new CSVReaderBuilder<Funder>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Funder>(Funder.class, vpp)).build();
	      try{
	      List<Funder> funder = funderReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder> funderList = new ArrayList<Sources.Source.Export.Funder>();
	      for(Funder fund : funder) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder funderModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder();
	    	  funderList.add(funderModel);
	    	  funderModel.setDateCreated(getXMLGregorianCalendar(fund.getDateCreated()));
	    	  funderModel.setDateUpdated(getXMLGregorianCalendar(fund.getDateUpdated()));
	    	  funderModel.setEndDate(getXMLGregorianCalendar(fund.getEndDate()));
	    	  funderModel.setFunder((fund.getFunder()));
	    	  funderModel.setFunderID(fund.getFunderID());
	    	  funderModel.setGrantID(fund.getGrantID());
	    	  funderModel.setProjectID(fund.getProjectID());
	    	  funderModel.setStartDate(getXMLGregorianCalendar(fund.getStartDate()));
	    	  funderModel.setUserID(fund.getUserID());
	    	  sources.getSource().getExport().getFunder().add(funderModel);
	      }
	      }catch(Exception e) {
		   	  throw new Exception("Funder.csv Invalid file format : "+e.getMessage(),e);
		     }
	  }
	  
	  /**
	   * Hydrate HealthAndDV with in Sources Object from HealthAndDV CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateHealthAndDV(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<HealthAndDV> healthAndDVReader = new CSVReaderBuilder<HealthAndDV>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<HealthAndDV>(HealthAndDV.class, vpp)).build();
	      try{
	      List<HealthAndDV> healthAndDV = healthAndDVReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus> healthStatusList = new ArrayList<Sources.Source.Export.HealthStatus>();
	      List<DomesticViolence> domesticViolenceList = new ArrayList<DomesticViolence>();
	      for(HealthAndDV healthDV : healthAndDV) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus healthStatus = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus();
	    	  healthStatus.setDataCollectionStage((healthDV.getDataCollectionStage()));
	    	  healthStatus.setDateCreated(getXMLGregorianCalendar(healthDV.getDateCreated()));
	    	  healthStatus.setDateUpdated(getXMLGregorianCalendar(healthDV.getDateUpdated()));
	    	  healthStatus.setDueDate(getXMLGregorianCalendar(healthDV.getDueDate()));
	    	  healthStatus.setHealthStatus((healthDV.getGeneralHealthStatus()));
	    	  healthStatus.setHealthStatusID(healthDV.getHealthAndDVID());
	    	//  healthStatus.setHealthCategory(); TODO: Need to fing out Health Category
	    	  healthStatus.setInformationDate(getXMLGregorianCalendar(healthDV.getInformationDate()));
	    	  healthStatus.setEnrollmentID(healthDV.getProjectEntryID());
	    	  healthStatus.setUserID(healthDV.getUserID());
	    	  healthStatusList.add(healthStatus);
	    	  
	    	   DomesticViolence domesticViolenceModel = new DomesticViolence();
			      domesticViolenceModel.setDataCollectionStage((healthDV.getDataCollectionStage()));
			      domesticViolenceModel.setDateCreated(getXMLGregorianCalendar(healthDV.getDateCreated()));
			      domesticViolenceModel.setDateUpdated(getXMLGregorianCalendar(healthDV.getDateUpdated()));
			      domesticViolenceModel.setDomesticViolenceID(healthDV.getHealthAndDVID());
			      domesticViolenceModel.setDomesticViolenceVictim((healthDV.getDomesticViolenceVictim()));
			      domesticViolenceModel.setInformationDate(getXMLGregorianCalendar(healthDV.getInformationDate()));
			      domesticViolenceModel.setEnrollmentID(healthDV.getProjectEntryID());
			      domesticViolenceModel.setUserID(healthDV.getUserID());
			      domesticViolenceModel.setWhenOccurred((healthDV.getWhenOccurred()));
			      domesticViolenceList.add(domesticViolenceModel);
		    	  
	      }
	      sources.getSource().getExport().setHealthStatus(healthStatusList);
	      sources.getSource().getExport().setDomesticViolence(domesticViolenceList);
	      }catch(Exception e) {
		   	  throw new Exception("HealthAndDV.csv Invalid file format : "+e.getMessage(),e);
		  }
	  }
	  
	  /**
	   * Hydrate IncomeBenefits with in Sources Object from IncomeBenefits CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateIncomeBenefits(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<IncomeBenefits> incomeBenefitsReader = new CSVReaderBuilder<IncomeBenefits>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<IncomeBenefits>(IncomeBenefits.class, vpp)).build();
	      try{
	      List<IncomeBenefits> incomeBenefits = incomeBenefitsReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources> incomeBenefitsList = new ArrayList<Sources.Source.Export.IncomeAndSources>();
	      List<NonCashBenefits> nonCashBenefitsList = new ArrayList<NonCashBenefits>();
	      List<ConnectionWithSOAR> ConnectionWithSOARList = new ArrayList<ConnectionWithSOAR>();
	      List<MedicalAssistance> medicalAssistanceList = new ArrayList<MedicalAssistance>();
	      for(IncomeBenefits incomeBnfts : incomeBenefits) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources incomeBenefitsModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources();
	    	  
	    	  incomeBenefitsModel.setAlimony(incomeBnfts.getAlimony());
	    	  if(incomeBnfts.getAlimonyAmount()!=null && !"".equals(incomeBnfts.getAlimonyAmount())){
	    		  incomeBenefitsModel.setAlimonyAmount(getFloatValue(incomeBnfts.getAlimonyAmount()));
	    	  }
	    	  incomeBenefitsModel.setChildSupport(incomeBnfts.getChildSupport());
	    	  if(incomeBnfts.getChildSupportAmount()!=null && !"".equals(incomeBnfts.getChildSupportAmount())){
	    		  incomeBenefitsModel.setChildSupportAmount(getFloatValue(incomeBnfts.getChildSupportAmount()));
	    	  }
	    	  incomeBenefitsModel.setDataCollectionStage((incomeBnfts.getDataCollectionStage()));
	    	  incomeBenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  incomeBenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  incomeBenefitsModel.setEarned((incomeBnfts.getEarned()));
	    	  if(incomeBnfts.getEarnedAmount()!=null && !"".equals(incomeBnfts.getEarnedAmount())){
	    		  incomeBenefitsModel.setEarnedAmount(getFloatValue(incomeBnfts.getEarnedAmount()));
	    	  }
	    	  incomeBenefitsModel.setGA((incomeBnfts.getGA()));
	    	  if(incomeBnfts.getGAAmount()!=null && !"".equals(incomeBnfts.getGAAmount())){
	    		  incomeBenefitsModel.setGAAmount(getFloatValue(incomeBnfts.getGAAmount()));
	    	  }
	    	  incomeBenefitsModel.setIncomeAndSourcesID(incomeBnfts.getIncomeBenefitsID());
	    	  incomeBenefitsModel.setIncomeFromAnySource((incomeBnfts.getIncomeFromAnySource()));
	    	  incomeBenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  incomeBenefitsModel.setOtherSource((incomeBnfts.getOtherIncomeSource()));
	    	  if(incomeBnfts.getOtherIncomeAmount()!=null && !"".equals(incomeBnfts.getOtherIncomeAmount())){
	    		  incomeBenefitsModel.setOtherAmount(getFloatValue(incomeBnfts.getOtherIncomeAmount()));
	    	  }
	    	  incomeBenefitsModel.setOtherSourceIdentify(incomeBnfts.getOtherIncomeSourceIdentify());
	    	  incomeBenefitsModel.setPension(incomeBnfts.getPension());
	    	  if(incomeBnfts.getPensionAmount()!=null && !"".equals(incomeBnfts.getPensionAmount())){
	    		  incomeBenefitsModel.setPensionAmount(getFloatValue(incomeBnfts.getPensionAmount()));
	    	  }
	    	  incomeBenefitsModel.setPrivateDisability(incomeBnfts.getPrivateDisability());
	    	  if(incomeBnfts.getPrivateDisabilityAmount()!=null && !"".equals(incomeBnfts.getPrivateDisabilityAmount())){
	    		  incomeBenefitsModel.setPrivateDisabilityAmount(getFloatValue(incomeBnfts.getPrivateDisabilityAmount()));
	    	  }
	    	  incomeBenefitsModel.setEnrollmentID(incomeBnfts.getEnrollmentID());
	    	  incomeBenefitsModel.setSocSecRetirement(incomeBnfts.getSocSecRetirement());
	    	  if(incomeBnfts.getSocSecRetirementAmount()!=null && !"".equals(incomeBnfts.getSocSecRetirementAmount())){
	    		  incomeBenefitsModel.setSocSecRetirementAmount(getFloatValue(incomeBnfts.getSocSecRetirementAmount()));
	    	  }
	    	  incomeBenefitsModel.setSSDI(incomeBnfts.getSSDI());
	    	  if(incomeBnfts.getSSDIAmount()!=null && !"".equals(incomeBnfts.getSSDIAmount())){
	    		  incomeBenefitsModel.setSSDIAmount(getFloatValue(incomeBnfts.getSSDIAmount()));
	    	  }
	    	  incomeBenefitsModel.setSSI((incomeBnfts.getSSI()));
	    	  if(incomeBnfts.getSSIAmount()!=null && !"".equals(incomeBnfts.getSSIAmount())){
	    		  incomeBenefitsModel.setSSIAmount(getFloatValue(incomeBnfts.getSSIAmount()));
	    	  }
	    	  incomeBenefitsModel.setTANF((incomeBnfts.getTANF()));
	    	  if(incomeBnfts.getTANFAmount()!=null && !"".equals(incomeBnfts.getTANFAmount())){
	    		  incomeBenefitsModel.setTANFAmount(getFloatValue(incomeBnfts.getTANFAmount()));
	    	  }
	    	  if(incomeBnfts.getTotalMonthlyIncome()!=null && !"".equals(incomeBnfts.getTotalMonthlyIncome())){
	    		  incomeBenefitsModel.setTotalMonthlyIncome(getFloatValue(incomeBnfts.getTotalMonthlyIncome()));
	    	  }
	    	  incomeBenefitsModel.setUnemployment(incomeBnfts.getUnemployment());
	    	  if(incomeBnfts.getUnemploymentAmount()!=null && !"".equals(incomeBnfts.getUnemploymentAmount())){
	    		  incomeBenefitsModel.setUnemploymentAmount(getFloatValue(incomeBnfts.getUnemploymentAmount()));
	    	  }
	    	  incomeBenefitsModel.setUserID(incomeBnfts.getUserID());
	    	  incomeBenefitsModel.setVADisabilityNonService(incomeBnfts.getVADisabilityNonService());
	    	  if(incomeBnfts.getVADisabilityNonServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityNonServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityNonServiceAmount(getFloatValue(incomeBnfts.getVADisabilityNonServiceAmount()));
	    	  }
	    	  incomeBenefitsModel.setVADisabilityService((incomeBnfts.getVADisabilityService()));
	    	  if(incomeBnfts.getVADisabilityServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityServiceAmount(getFloatValue(incomeBnfts.getVADisabilityServiceAmount()));
	    	  }
	    	  
	    	  incomeBenefitsModel.setWorkersComp((incomeBnfts.getWorkersComp()));
	    	  if(incomeBnfts.getWorkersCompAmount()!=null && !"".equals(incomeBnfts.getWorkersCompAmount())){
	    		  incomeBenefitsModel.setWorkersCompAmount(getFloatValue(incomeBnfts.getWorkersCompAmount()));
	    	  }
	    	  
	    	  ConnectionWithSOAR connectionWithSOAR = new ConnectionWithSOAR();
	    	  connectionWithSOAR.setConnectionWithSOAR(incomeBnfts.getConnectionWithSOAR());
	    	  connectionWithSOAR.setDataCollectionStage(incomeBnfts.getDataCollectionStage());
	    	  connectionWithSOAR.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  connectionWithSOAR.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  connectionWithSOAR.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  connectionWithSOAR.setConnectionWithSOARID(incomeBnfts.getIncomeBenefitsID());
	    	  ConnectionWithSOARList.add(connectionWithSOAR);
	    	  
	    	  NonCashBenefits noncashbenefitsModel = new NonCashBenefits();
	    	  noncashbenefitsModel.setBenefitsFromAnySource((incomeBnfts.getBenefitsFromAnySource()));
	    	  noncashbenefitsModel.setDataCollectionStage((incomeBnfts.getDataCollectionStage()));
	    	  noncashbenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  noncashbenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  noncashbenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  noncashbenefitsModel.setNonCashBenefitsID(incomeBnfts.getIncomeBenefitsID());
	    	  noncashbenefitsModel.setOtherSource((incomeBnfts.getOtherBenefitsSource()));
	    	  noncashbenefitsModel.setEnrollmentID(incomeBnfts.getEnrollmentID());
	    	  noncashbenefitsModel.setOtherSourceIdentify(incomeBnfts.getOtherBenefitsSourceIdentify());
	    	  noncashbenefitsModel.setOtherTANF(incomeBnfts.getOtherTANF());
	    	//  noncashbenefitsModel.setRentalAssistanceOngoing(incomeBnfts.getong);
	    	  noncashbenefitsModel.setSNAP(incomeBnfts.getSNAP());
	    	  noncashbenefitsModel.setTANFChildCare(incomeBnfts.getTANFChildCare());
	    	  noncashbenefitsModel.setTANFTransportation(incomeBnfts.getTANFTransportation());
	    	  noncashbenefitsModel.setWIC(incomeBnfts.getWIC());
	    	  nonCashBenefitsList.add(noncashbenefitsModel);
	    	  
	    	  HealthInsurance healthinsuranceModel = new HealthInsurance();
	    	  healthinsuranceModel.setCOBRA((incomeBnfts.getCOBRA()));
	    	  healthinsuranceModel.setOtherInsurance((incomeBnfts.getOtherInsurance()));
	    	  healthinsuranceModel.setOtherInsuranceIdentify(incomeBnfts.getOtherIncomeSourceIdentify());
	    	  healthinsuranceModel.setIndianHealthServices((incomeBnfts.getIndianHealthServices()));
	    	  healthinsuranceModel.setNoIndianHealthServicesReason(incomeBnfts.getNoIndianHealthServicesReason());
	    	  healthinsuranceModel.setDataCollectionStage((incomeBnfts.getDataCollectionStage()));
	    	  healthinsuranceModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  healthinsuranceModel.setDateDeleted(getXMLGregorianCalendar(incomeBnfts.getDateDeleted()));
	    	  healthinsuranceModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  healthinsuranceModel.setEmployerProvided((incomeBnfts.getEmployerProvided()));
	    	  healthinsuranceModel.setHealthInsuranceID(incomeBnfts.getIncomeBenefitsID());
	    	  healthinsuranceModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  healthinsuranceModel.setInsuranceFromAnySource((incomeBnfts.getIncomeFromAnySource()));
	    	  healthinsuranceModel.setMedicaid((incomeBnfts.getMedicaid()));
	    	  healthinsuranceModel.setMedicare((incomeBnfts.getMedicare()));
	    	  healthinsuranceModel.setNoCOBRAReason((incomeBnfts.getNoCOBRAReason()));
	    	  healthinsuranceModel.setNoEmployerProvidedReason((incomeBnfts.getNoEmployerProvidedReason()));
	    	  healthinsuranceModel.setNoMedicareReason((incomeBnfts.getNoMedicareReason()));
	    	  healthinsuranceModel.setNoMedicaidReason((incomeBnfts.getNoMedicaidReason()));
	    	  healthinsuranceModel.setNoPrivatePayReason((incomeBnfts.getNoPrivatePayReason()));
	    	  healthinsuranceModel.setNoSCHIPReason((incomeBnfts.getNoSCHIPReason()));
	    	  healthinsuranceModel.setNoStateHealthInsReason((incomeBnfts.getNoStateHealthInsReason()));
	    	  healthinsuranceModel.setNoVAMedReason((incomeBnfts.getNoVAMedReason()));
	    	  healthinsuranceModel.setPrivatePay((incomeBnfts.getPrivatePay()));
	    	  healthinsuranceModel.setEnrollmentID(incomeBnfts.getEnrollmentID());
	    	  healthinsuranceModel.setSCHIP((incomeBnfts.getSCHIP()));
	    	  healthinsuranceModel.setStateHealthIns((incomeBnfts.getStateHealthIns()));
	    	  healthinsuranceModel.setUserID(incomeBnfts.getUserID());
	    	  healthinsuranceModel.setVAMedicalServices((incomeBnfts.getVAMedicalServices()));
	    	  sources.getSource().getExport().getHealthInsurance().add(healthinsuranceModel);
	    	  
	    	  MedicalAssistance medicalassistanceModel = new MedicalAssistance();
	    	  medicalassistanceModel.setADAP((incomeBnfts.getADAP()));
	    	  medicalassistanceModel.setDataCollectionStage((incomeBnfts.getDataCollectionStage()));
	    	  medicalassistanceModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  medicalassistanceModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  medicalassistanceModel.setHIVAIDSAssistance((incomeBnfts.getHIVAIDSAssistance()));
	    	  medicalassistanceModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  medicalassistanceModel.setMedicalAssistanceID(incomeBnfts.getIncomeBenefitsID());
	    	  medicalassistanceModel.setNoADAPReason((incomeBnfts.getNoADAPReason()));
	    	  medicalassistanceModel.setNoHIVAIDSAssistanceReason((incomeBnfts.getNoHIVAIDSAssistanceReason()));
	    	  medicalassistanceModel.setEnrollmentID(incomeBnfts.getEnrollmentID());
	    	  medicalassistanceModel.setUserID(incomeBnfts.getUserID());
	    	  medicalAssistanceList.add(medicalassistanceModel);
	    	  incomeBenefitsList.add(incomeBenefitsModel);
	      }
	      sources.getSource().getExport().setIncomeAndSources(incomeBenefitsList);
	      sources.getSource().getExport().setNonCashBenefits(nonCashBenefitsList);
	      sources.getSource().getExport().setMedicalAssistance(medicalAssistanceList);
	      sources.getSource().getExport().setConnectionWithSoar(ConnectionWithSOARList);
	      
	  }catch(Exception e) {
	   	  throw new Exception("IncomeBenefits.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  /**
	   * Hydrate Inventory with in Sources Object from Inventory CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateInventory(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Inventory> inventoryReader = new CSVReaderBuilder<Inventory>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Inventory>(Inventory.class, vpp)).build();
	      try{
	      List<Inventory> inventory = inventoryReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory> inventoryList = new ArrayList<Sources.Source.Export.Inventory>();
	      for(Inventory invntry : inventory) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory();
	    	  
	    	  inventoryModel.setAvailability(invntry.getAvailability());
	    	  inventoryModel.setBedType(invntry.getBedType());
	    	  inventoryModel.setProjectID(invntry.getProjectID());
	    	  inventoryModel.setDateCreated(getXMLGregorianCalendar(invntry.getDateCreated()));
	    	  inventoryModel.setDateUpdated(getXMLGregorianCalendar(invntry.getDateUpdated()));
	    	  inventoryModel.setHouseholdType((invntry.getHouseholdType()));
	    	  inventoryModel.setInventoryEndDate(getXMLGregorianCalendar(invntry.getInventoryEndDate()));
	    	  inventoryModel.setInventoryID(invntry.getInventoryID());
	    	  inventoryModel.setInventoryStartDate(getXMLGregorianCalendar(invntry.getInventoryStartDate()));
	    	  if(invntry.getCoCCode() !=null && !"".equals(invntry.getCoCCode()))
	    		  inventoryModel.setCoCCode(invntry.getCoCCode());
	    	  if(invntry.getUnitInventory() !=null && !"".equals(invntry.getUnitInventory()))
	    		  inventoryModel.setUnitInventory(Integer.parseInt(invntry.getUnitInventory()));
	    	  inventoryModel.setUserID(invntry.getUserID());
	    	  
	    	  if(invntry.getBedInventory() !=null && !"".equals(invntry.getBedInventory() )) {
	    		  inventoryModel.setBedInventory(invntry.getBedInventory());  
	    	  }
	    	  inventoryModel.setChVetBedInventory(invntry.getCHVetBedInventory());
	    	  inventoryModel.setVetBedInventory(invntry.getVetBedInventory());
	    	  inventoryModel.setYouthVetBedInventory(invntry.getYouthVetBedInventory());
	    	  inventoryModel.setChYouthBedInventory(invntry.getCHYouthBedInventory());
	    	  
	    	  inventoryModel.setYouthBedInventory(invntry.getYouthBedInventory());
	    	  inventoryModel.setChBedInventory(invntry.getCHBedInventory());
	    	  inventoryModel.setBedInventory(invntry.getBedInventory());
	    	  inventoryModel.setOtherBedInventory(invntry.getOtherBedInventory());
	    	  inventoryList.add(inventoryModel);
	      }
	      sources.getSource().getExport().setInventory(inventoryList);
	  }catch(Exception e) {
	   	  throw new Exception("Inventory.csv Invalid file format : "+e.getMessage(),e);
	  }
	      
	  }
	  
	  /**
	   * Hydrate Organization with in Sources Object from Organization CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateOrganization(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Organization> organizationReader = new CSVReaderBuilder<Organization>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Organization>(Organization.class, vpp)).build();
	      try{
		      List<Organization> organization = organizationReader.readAll();
		      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization> organizationList = new ArrayList<Sources.Source.Export.Organization>();
		      for(Organization orgtn : organization) {
		    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization organizationModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization();
		    	  organizationModel.setDateCreated(getXMLGregorianCalendar(orgtn.getDateCreated()));
		    	  organizationModel.setDateUpdated(getXMLGregorianCalendar(orgtn.getDateUpdated()));
		    	  organizationModel.setOrganizationCommonName(orgtn.getOrganizationCommonName());
		    	  organizationModel.setVictimServicesProvider(orgtn.getVictimServicesProvider());
		    	  organizationModel.setOrganizationID(orgtn.getOrganizationID());
		    	  organizationModel.setOrganizationName(orgtn.getOrganizationName());
		    	  organizationModel.setUserID(orgtn.getUserID());
		    	  
		    	  organizationList.add(organizationModel);
		      }
		      sources.getSource().getExport().setOrganization(organizationList);
	  }catch(Exception e) {
	   	  throw new Exception("Organization.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  /**
	   * Hydrate Project with in Sources Object from Project CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateProject(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Project> projectReader = new CSVReaderBuilder<Project>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Project>(Project.class, vpp)).build();
	      try{
	      List<Project> project = projectReader.readAll();
	      for(Project prjt : project) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project projectModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project();
	    	  
	    	  projectModel.setContinuumProject(prjt.getContinuumProject());
	    	  projectModel.setDateCreated(getXMLGregorianCalendar(prjt.getDateCreated()));
	    	  projectModel.setDateUpdated(getXMLGregorianCalendar(prjt.getDateUpdated()));
	    	  projectModel.setOrganizationID(prjt.getOrganizationID());
	    	  projectModel.setProjectCommonName(prjt.getProjectCommonName());
	    	  projectModel.setProjectID(prjt.getProjectID());
	    	  projectModel.setProjectName(prjt.getProjectName());
	    	  projectModel.setProjectType(prjt.getProjectType());
	    	  projectModel.setResidentialAffiliation(prjt.getResidentialAffiliation());
	    	  projectModel.setTargetPopulation((prjt.getTargetPopulation()));
	    	  projectModel.setTrackingMethod((prjt.getTrackingMethod()));
	    	  projectModel.setUserID(prjt.getUserID());
	    	  projectModel.setHousingType(prjt.getHousingType());
	    	  projectModel.setOperatingEndDate(getXMLGregorianCalendar(prjt.getOperatingEndDate()));
	    	  projectModel.setOperatingStartDate(getXMLGregorianCalendar(prjt.getOperatingStartDate()));
	    	  
	    	  sources.getSource().getExport().getProject().add(projectModel);
	      }
	  }catch(Exception e) {
	   	  throw new Exception("Project.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  /**
	   * Hydrate Coc with in Sources Object from ProjectCOC CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateCoc(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<ProjectCOC> projectCOCReader = new CSVReaderBuilder<ProjectCOC>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<ProjectCOC>(ProjectCOC.class, vpp)).build();
	      try{
	      List<ProjectCOC> projectCOC = projectCOCReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC> projectCoCList = new ArrayList<Sources.Source.Export.ProjectCoC>();
	      for(ProjectCOC prjtCoC : projectCOC) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC cocModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC();
	    	 cocModel.setCoCCode(prjtCoC.getCoCCode());
	    	 cocModel.setDateCreated(getXMLGregorianCalendar(prjtCoC.getDateCreated()));
	    	 cocModel.setDateUpdated(getXMLGregorianCalendar(prjtCoC.getDateUpdated()));
	    	 cocModel.setUserID(prjtCoC.getUserID());
	    	 cocModel.setProjectID(prjtCoC.getProjectID());
	    	 cocModel.setProjectCoCID(prjtCoC.getProjectCocID());
	    	 cocModel.setGeoCode(prjtCoC.getGeocode());
	    	 cocModel.setAddress1(prjtCoC.getAddress1());
	    	 cocModel.setAddress2(prjtCoC.getAddress2());
	    	 cocModel.setCity(prjtCoC.getCity());
	    	 cocModel.setState(prjtCoC.getState());
	    	 cocModel.setZip(prjtCoC.getZIP());
	    	 cocModel.setGeographyType(prjtCoC.getGeographyType());
	    	
	    	  projectCoCList.add(cocModel);
	    	  sources.getSource().getExport().getCoC().add(cocModel);
	      }
	  }catch(Exception e) {
	   	  throw new Exception("Coc.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  
	  
	  /**
	   * Hydrate Assessment with in Sources Object from Assessment CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateAssessment(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Assessment> assessmentReader = new CSVReaderBuilder<Assessment>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Assessment>(Assessment.class, vpp)).build();
	      try{
	      List<Assessment> assessments = assessmentReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Assessment> assessmentList = new ArrayList<Sources.Source.Export.Assessment>();
	      for(Assessment assessment : assessments) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Assessment assessmentModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Assessment();
	    	  assessmentModel.setDateCreated(getXMLGregorianCalendar(assessment.getDateCreated()));
	    	  assessmentModel.setDateUpdated(getXMLGregorianCalendar(assessment.getDateUpdated()));
	    	  assessmentModel.setUserID(assessment.getUserID());
	    	  assessmentModel.setAssessmentDate(getXMLGregorianCalendar(assessment.getAssessmentDate()));
	    	  assessmentModel.setAssessmentID(assessment.getAssessmentID());
	    	  assessmentModel.setAssessmentLevel(assessment.getAssessmentLevel());
	    	  assessmentModel.setAssessmentLocation(assessment.getAssessmentLocation());
	    	  assessmentModel.setAssessmentType(assessment.getAssessmentType());
	    	  assessmentModel.setPrioritizationStatus(assessment.getPrioritizationStatus());
	    	  assessmentModel.setEnrollmentID(assessment.getProjectEntryID());
	    	  assessmentList.add(assessmentModel);
	      }
	      sources.getSource().getExport().setAssessment(assessmentList);
	  }catch(Exception e) {
	   	  throw new Exception("Assessment.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  

	  /**
	   * Hydrate AssessmentQuestions with in Sources Object from AssessmentQuestions CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateAssessmentQuestions(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<AssessmentQuestions> assessmentQuestionsReader = new CSVReaderBuilder<AssessmentQuestions>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<AssessmentQuestions>(AssessmentQuestions.class, vpp)).build();
	      try{
	      List<AssessmentQuestions> assessmentQuestions = assessmentQuestionsReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentQuestions> assessmentQuestionsList = new ArrayList<Sources.Source.Export.AssessmentQuestions>();
	      for(AssessmentQuestions assessmentQuestion : assessmentQuestions) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentQuestions assessmenQuestionModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentQuestions();
	    	  assessmenQuestionModel.setDateCreated(getXMLGregorianCalendar(assessmentQuestion.getDateCreated()));
	    	  assessmenQuestionModel.setDateUpdated(getXMLGregorianCalendar(assessmentQuestion.getDateUpdated()));
	    	  assessmenQuestionModel.setUserID(assessmentQuestion.getUserID());
	    	  assessmenQuestionModel.setEnrollmentID(assessmentQuestion.getEnrollmentID());
	    	  assessmenQuestionModel.setAssessmentID(assessmentQuestion.getAssessmentID());
	    	  assessmenQuestionModel.setAssessmentAnswer(assessmentQuestion.getAssessmentAnswer());
	    	  assessmenQuestionModel.setAssessmentQuestion(assessmentQuestion.getAssessmentQuestion());
	    	  assessmenQuestionModel.setAssessmentQuestionGroup(assessmentQuestion.getAssessmentQuestionGroup());
	    	  assessmenQuestionModel.setAssessmentQuestionID(assessmentQuestion.getAssessmentQuestionID());
	    	  assessmenQuestionModel.setEnrollmentID(assessmentQuestion.getEnrollmentID());
	    	 
	    	  assessmentQuestionsList.add(assessmenQuestionModel);
	      }
	      sources.getSource().getExport().setAssessmentQuestions(assessmentQuestionsList);
	  }catch(Exception e) {
   	  throw new Exception("AssessmentQuestions.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  
	  
	  /**
	   * Hydrate AssessmentQuestions with in Sources Object from AssessmentQuestions CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateAssessmentResults(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<AssessmentResults> assessmentQuestionsReader = new CSVReaderBuilder<AssessmentResults>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<AssessmentResults>(AssessmentResults.class, vpp)).build();
	      try{
	      List<AssessmentResults> assessmentResults= assessmentQuestionsReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentResults> assessmentResultsList = new ArrayList<Sources.Source.Export.AssessmentResults>();
	      for(AssessmentResults assessmentResult : assessmentResults) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentResults assessmenResultsModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.AssessmentResults();
	    	  assessmenResultsModel.setDateCreated(getXMLGregorianCalendar(assessmentResult.getDateCreated()));
	    	  assessmenResultsModel.setDateUpdated(getXMLGregorianCalendar(assessmentResult.getDateUpdated()));
	    	  assessmenResultsModel.setUserID(assessmentResult.getUserID());
	    	  assessmenResultsModel.setEnrollmentID(assessmentResult.getEnrollmentID());
	    	  assessmenResultsModel.setAssessmentID(assessmentResult.getAssessmentID());
	    	  assessmenResultsModel.setAssessmentResult(assessmentResult.getAssessmentResult());
	    	  assessmenResultsModel.setAssessmentResultType(assessmentResult.getAssessmentResultType());
	    	  assessmentResultsList.add(assessmenResultsModel);
	      }
	      sources.getSource().getExport().setAssessmentResults(assessmentResultsList);
	  }catch(Exception e) {
   	  throw new Exception("AssessmentQuestions.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  /**
	   * Hydrate CurrentLivingSituation with in Sources Object from CurrentLivingSituation CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateCurrentLivingSituation(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CurrentLivingSituation> currentLivingSituationList = new ArrayList<Sources.Source.Export.CurrentLivingSituation>();
	      
	      CSVReader<CurrentLivingSituation> currentLivingSituationReader = new CSVReaderBuilder<CurrentLivingSituation>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<CurrentLivingSituation>(CurrentLivingSituation.class, vpp)).build();
	      try{
	      List<CurrentLivingSituation> currentLivingSituations = currentLivingSituationReader.readAll();
	      for(CurrentLivingSituation currentLivingSituation : currentLivingSituations) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CurrentLivingSituation currentLivingSituationModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CurrentLivingSituation();
	    	  currentLivingSituationModel.setDateCreated(getXMLGregorianCalendar(currentLivingSituation.getDateCreated()));
	    	  currentLivingSituationModel.setDateUpdated(getXMLGregorianCalendar(currentLivingSituation.getDateUpdated()));
	    	  currentLivingSituationModel.setUserID(currentLivingSituation.getUserID());
	    	  currentLivingSituationModel.setEnrollmentID(currentLivingSituation.getProjectEntryID());
	    	  currentLivingSituationModel.setCurrentLivingSitID(currentLivingSituation.getCurrentLivingSitID());
	    	  currentLivingSituationModel.setCurrentLivingSituation(currentLivingSituation.getCurrentLivingSituation());
	    	  currentLivingSituationModel.setLeaseOwn60Day(currentLivingSituation.getLeaseOwn60Day());
	    	  currentLivingSituationModel.setLeaveSituation14Days(currentLivingSituation.getLeaveSituation14Days());
	    	  currentLivingSituationModel.setLocationDetails(currentLivingSituation.getLocationDetails());
	    	  currentLivingSituationModel.setMovedTwoOrMore(currentLivingSituation.getMovedTwoOrMore());
	    	  currentLivingSituationModel.setPersonalID(currentLivingSituation.getPersonalID());
	    	  currentLivingSituationModel.setResourcesToObtain(currentLivingSituation.getResourcesToObtain());
	    	  currentLivingSituationModel.setSubsequentResidence(currentLivingSituation.getSubsequentResidence());
	    	  currentLivingSituationModel.setVerifiedBy(currentLivingSituation.getVerifiedBy());
	    	  currentLivingSituationList.add(currentLivingSituationModel);
	      }
	      sources.getSource().getExport().setCurrentLivingSituation(currentLivingSituationList);
	  }catch(Exception e) {
   	  throw new Exception("CurrentLivingSituation.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  /**
	   * Hydrate CurrentLivingSituation with in Sources Object from CurrentLivingSituation CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateEvent(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
		  List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Event> eventList = new ArrayList<Sources.Source.Export.Event>();
	      
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Event> eventReader = new CSVReaderBuilder<Event>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Event>(Event.class, vpp)).build();
	      try{
	      List<Event> events = eventReader.readAll();
	      for(Event event : events) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Event eventModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Event();
	    	  eventModel.setDateCreated(getXMLGregorianCalendar(event.getDateCreated()));
	    	  eventModel.setDateUpdated(getXMLGregorianCalendar(event.getDateUpdated()));
	    	  eventModel.setUserID(event.getUserID());
	    	  eventModel.setEnrollmentID(event.getEnrollmentID());
	    	  eventModel.setEvent(event.getEvent());
	    	  eventModel.setEventDate(getXMLGregorianCalendar(event.getEventDate()));
	    	  eventModel.setLocationCrisisOrPHHousing(event.getLocationCrisisOrPHHousing());
	    	  eventModel.setReferralCaseManageAfter(event.getReferralCaseManageAfter());
	    	  eventModel.setReferralResult(event.getReferralResult());
	    	  eventModel.setEventID(event.getEventID());
	    	  eventModel.setPersonalID(event.getPersonalID());
	    	  eventModel.setProbSolDivRRResult(event.getProbSolDivRRResult());
	    	  eventList.add(eventModel);
	      }
	      sources.getSource().getExport().setEvent(eventList);
	  }catch(Exception e) {
   	  throw new Exception("AssessmentQuestions.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  /**
	   * Hydrate Services with in Sources Object from Services CSV Pojos.
	   *
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateServices(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Services> servicesReader = new CSVReaderBuilder<Services>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Services>(Services.class, vpp)).build();
	      try{
	      List<Services> services = servicesReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services> servicesList = new ArrayList<Sources.Source.Export.Services>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact> contactList = new ArrayList<Sources.Source.Export.Contact>();
	      for(Services srvcs : services) {
	    	  if(StringUtils.isNotEmpty(srvcs.getRecordType()) && StringUtils.equals("13", srvcs.getRecordType())) {
	    		  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact contactModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Contact();
	    		  contactModel.setDateCreated(getXMLGregorianCalendar(srvcs.getDateCreated()));
	    		  contactModel.setDateUpdated(getXMLGregorianCalendar(srvcs.getDateUpdated()));
		    	  contactModel.setEnrollmentID(srvcs.getProjectEntryID());
		    	  contactModel.setUserID(srvcs.getUserID());
		    	  contactModel.setContactDate(getXMLGregorianCalendar(srvcs.getDateProvided()));
		    	  contactModel.setContactID(srvcs.getServicesID());
		    	  contactModel.setContactLocation(srvcs.getTypeProvided());
		    	  contactList.add(contactModel);
	    	  }else {
	    		  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services servicesModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services();
		    	  servicesModel.setDateCreated(getXMLGregorianCalendar(srvcs.getDateCreated()));
		    	  servicesModel.setDateProvided(getXMLGregorianCalendar(srvcs.getDateProvided()));
		    	  servicesModel.setDateUpdated(getXMLGregorianCalendar(srvcs.getDateUpdated()));
		    	  if(srvcs.getFAAmount()!=null && !"".equals(srvcs.getFAAmount())){
		    		  servicesModel.setFAAmount(Float.valueOf(srvcs.getFAAmount()));
		    	  }
		    	  servicesModel.setOtherTypeProvided(srvcs.getOtherTypeProvided());
		    	  servicesModel.setEnrollmentID(srvcs.getProjectEntryID());
		    	  servicesModel.setRecordType(srvcs.getRecordType());
		    	  servicesModel.setReferralOutcome((srvcs.getReferralOutcome()));
		    	  servicesModel.setServicesID(srvcs.getServicesID());
		    	  servicesModel.setSubTypeProvided((srvcs.getSubTypeProvided()));
		    	  servicesModel.setTypeProvided(srvcs.getTypeProvided());
		    	  servicesModel.setUserID(srvcs.getUserID());
		    	  servicesList.add(servicesModel);
	    	  }
	      }
	      sources.getSource().getExport().setServices(servicesList);
	      sources.getSource().getExport().setContact(contactList);
	  }catch(Exception e) {
	   	  throw new Exception("Services.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	 
	 /**
	   * Hydrate Site with in Sources Object from Site CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws Exception
	   */
	  protected void hydrateSite(BufferedReader csvFile, Sources sources) throws Exception {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Site> siteReader = new CSVReaderBuilder<Site>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Site>(Site.class, vpp)).build();
	      try{
	      List<Site> site = siteReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site> siteList = new ArrayList<Sources.Source.Export.Site>();
	      for(Site ste : site) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site siteModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site();
	    	  
	    	  siteModel.setAddress(ste.getAddress());
	    	  siteModel.setCity(ste.getCity());
	    	  siteModel.setDateCreated(getXMLGregorianCalendar(ste.getDateCreated()));
	    	  siteModel.setDateUpdated(getXMLGregorianCalendar(ste.getDateUpdated()));
	    	  /*
	    	   *  Always look to see if something is null before doing a parseIn
	    	   *  
	    	   *   */
	    	  if(ste.getGeocode() !=null && !"".equals(ste.getGeocode())) {
	    		  siteModel.setGeocode(parseInt(ste.getGeocode()).intValue());  
	    	  }
	    	  siteModel.setPrincipalSite((ste.getPrincipalSite()));
	    	  
	    	  if(ste.getCoCCode()!=null && !"".equals(ste.getCoCCode())){
	    		  siteModel.setCoCCode(ste.getCoCCode());
	    	  }
	    	  
	    	  if(ste.getSiteID()!=null && !"".equals(ste.getSiteID())){
	    		  siteModel.setSiteID(ste.getSiteID());
	    	  }
	    	  
	    	  siteModel.setState(ste.getState());
	    	  siteModel.setUserID(ste.getUserID());
	    	  
	    	  if(ste.getZIP() !=null && !"".equals(ste.getZIP())) {
	    		  siteModel.setZIP((parseInt(ste.getZIP()).intValue()));  
	    	  }
	    	  
	    	  siteList.add(siteModel);
	      }
	      sources.getSource().getExport().setSite(siteList);
	  }catch(Exception e) {
	   	  throw new Exception("Site.csv Invalid file format : "+e.getMessage(),e);
	  }
	  }
	  
	  protected Integer parseInt(String value) {
		  if(value !=null && !"".equals(value)) {
			  return Integer.parseInt(value);
		  }
		  return null;
	  }
	  protected byte getByte(String value) {
		  if(value !=null && !"".equals(value) && !"NA".equals(value)) {
			  return Byte.valueOf(value);
		  }
		  return 99;
	  }
	  protected String getFileExtension(String fileName) {
			if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
		        return fileName.substring(fileName.lastIndexOf(".")+1);
		        else return "";
	  }
	  protected XMLGregorianCalendar getXMLGregorianCalendar(String date) {
		  if(date == null || "".equals(date) || "NA".equalsIgnoreCase(date)) {
			  return null;
		  }
		  DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
		  Date dob=null;
		  String dobString ="";
		  DateFormat df=new SimpleDateFormat("MM/dd/yy mm:ss");
		  try {
			  dob=df.parse(date);  
			  dobString=df1.format(dob);
		  }catch(ParseException ex) {
			
			  try {
				dob=df1.parse(date);
				dobString=df1.format(dob);
			} catch (ParseException e) {
				DateFormat df2=new SimpleDateFormat("yyyy-MM-dd mm:ss");
				  try {
					dob=df2.parse(date);
					dobString=df1.format(dob);
				  }catch(ParseException exp) {
					  
					  DateFormat df3=new SimpleDateFormat("MM/dd/yy");
					  try {
						dob=df3.parse(date);
						dobString=df1.format(dob);
					  }catch(ParseException exp1) {
						  exp1.printStackTrace();
					  }
				  }
			}
		  }
		  if(dob == null){
			  return null;
		  }
		  XMLGregorianCalendar xmlDate2=null;
		try {
			xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(dobString);
			//xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return xmlDate2;
		}
	  
	  protected int getIntValue(String value) {
		  int s= 0;
		  try {
			  s = Integer.parseInt(value);
			} catch (NumberFormatException e){
				return 0;
			}     
	  	return s;
	  }
	  protected float getFloatValue(String value) {
		  float s = 0;
		  try {
			  s = Float.parseFloat(value);
			} catch (NumberFormatException e){
				return 0;
			}     
	  	return s;
	  }
	  protected short getShortValue(String value) {
		  short s= 0;
		  try {
			  s = Short.parseShort(value);
			} catch (NumberFormatException e){
				return 0;
			}     
	  	return s;
	  }
	  protected XMLGregorianCalendar getXMLGregorianCalendarMMddyyyy(String date) {
		  if(date == null || "".equals(date)) {
			  return null;
		  }
		  Date dob=null;
		  DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		  try {
			  dob=df.parse(date);  
		  }catch(ParseException ex) {
			  
		  }
		  
		  GregorianCalendar cal = new GregorianCalendar();

		  cal.setTime(dob);
		  XMLGregorianCalendar xmlDate2=null;
		try {
			xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return xmlDate2;
		}
	  
	  
	  public static void main(String args[]) {
		  BulkUploadHelper2020 bulk = new BulkUploadHelper2020();
		  XMLGregorianCalendar date1 = bulk.getXMLGregorianCalendar("2020-03-31");
		  System.out.println(date1);
		  
	  }
}
