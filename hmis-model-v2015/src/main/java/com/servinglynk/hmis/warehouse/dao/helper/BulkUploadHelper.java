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

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.servinglynk.hmis.warehouse.AwsS3Client;
import com.servinglynk.hmis.warehouse.csv.Client;
import com.servinglynk.hmis.warehouse.csv.Disabilities;
import com.servinglynk.hmis.warehouse.csv.EmployementEducation;
import com.servinglynk.hmis.warehouse.csv.Enrollment;
import com.servinglynk.hmis.warehouse.csv.EnrollmentCoC;
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHSP;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntrySSVF;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExportPeriod;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

@Component
public class BulkUploadHelper {
	
	/**
	 * Gets the source object from the upload location.
	 * @param upload
	 * @return sources
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	public Sources getSourcesFromFiles(BulkUpload upload,ProjectGroupEntity projectGroupEntity,Boolean isFileFromS3) throws JAXBException, IOException {
			String inputPath = upload.getInputpath();
			// download file to temp folder
			String tempFile = upload.getInputpath();
			if(BooleanUtils.isTrue(isFileFromS3)) {
				AwsS3Client client = new AwsS3Client();
				tempFile = client.downloadFile(projectGroupEntity.getBucketName(), upload.getInputpath(),null);
			}
			if(inputPath !=null && StringUtils.equals("zip",getFileExtension(upload.getInputpath()))){
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
	 */
	public Sources getSourcesForZipFile(String fileName) {
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
		            
		            switch(ze.getName()) {
		            	case "Client.csv":
		            		hydrateClient(csvFile, sources);
		            		break;
		            	case "Disabilities.csv":
		            		hydrateDisabilities(csvFile, sources);
		            		break;
		            	case "EmploymentEducation.csv":
		            		hydrateEmployementEducation(csvFile,sources);
		            		break;
		            	case "Enrollment.csv":
		            		hydrateEnrollment(csvFile, sources);
		            		break;
		            	case "EnrollmentCOC.csv":
		            		hydrateEnrollmentCoC(csvFile, sources);
		            		break;
		            	case "Exit.csv":
		            		hydrateExit(csvFile, sources);
		            		break;
		            	case "Export.csv":
		            		hydrateExport(csvFile, sources);
		            		break;
		            	case "Funder.csv":
		            		hydrateFunder(csvFile, sources);
		            		break;		            		
		            	case "HealthAndDV.csv":
		            		hydrateHealthAndDV(csvFile, sources);
		            		break;
		            	case "IncomeBenefits.csv":
		            		hydrateIncomeBenefits(csvFile, sources);
		            		break;
		            	case "Inventory.csv":
		            		hydrateInventory(csvFile, sources);
		            		break;
		            	case "Organization.csv":
		            		hydrateOrganization(csvFile, sources);
		            		break;
		            	case  "Project.csv" :
		            		hydrateProject(csvFile, sources);
		            		break;
		            	case "ProjectCOC.csv":
		            		hydrateCoc(csvFile, sources);
		            		break;
		            	case "Services.csv":
		            		hydrateServices(csvFile, sources);
		            		break;
		            	case "Site.csv":
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
	 * @throws IOException
	 */
	  protected void hydrateClient(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Client> csvReader = new CSVReaderBuilder<Client>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Client>(Client.class, vpp)).build();
	      List<Client> clients = csvReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client> clientList = new ArrayList<Sources.Source.Export.Client>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo> veteranInfoList = new ArrayList<Sources.Source.Export.ClientVeteranInfo>();
	      if(clients !=null && clients.size() > 0) {
	    	  for(Client client : clients) {
	    		   com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client clientModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client();
	    		   clientModel.setEthnicity(getByte(client.getEthnicity()));
	    		   clientModel.setDOB(getXMLGregorianCalendar(client.getDob()));
	    		   clientModel.setDOBDataQuality(getByte(client.getDobDataQuality()));
	    		   FirstName  firstName = new FirstName();
	    		   firstName.setValue(client.getFirstName());
	    		   clientModel.setFirstName(firstName);
	    		   LastName lastName = new LastName();
	    		   lastName.setValue(client.getLastName());
	    		   clientModel.setLastName(lastName);
	    		   MiddleName middleName = new MiddleName();
	    		   middleName.setValue(client.getMiddleName());
	    		   clientModel.setMiddleName(middleName);
	    		   clientModel.setGender(getByte(client.getGender()));
	    		   clientModel.setNameDataQuality(getByte(client.getNameDataQuality()));
	    		   clientModel.setNameSuffix(client.getNameSuffix());
	    		   clientModel.setOtherGender(client.getOtherGender());
	    		   clientModel.setPersonalID(client.getPersonalID());
	    		   clientModel.setRace(getByte(client.getRaceNone()));
	    		   SSN ssn = new SSN();
	    		   ssn.setValue(client.getSsn());
	    		   clientModel.setSSN(ssn);
	    		   clientModel.setSSNDataQuality(getByte(client.getSsnDataQuality()));
	    		   clientModel.setUserID(client.getUserID());
	    		   clientModel.setVeteranStatus(getByte(client.getVeteranStatus()));
	    		   clientList.add(clientModel);
	    		   
	    		   ClientVeteranInfo veteranInfoModel = new ClientVeteranInfo();
	    		   veteranInfoModel.setAfghanistanOEF(getByte(client.getAfghanistanOEF()));
	    		   veteranInfoModel.setDateCreated(getXMLGregorianCalendar(client.getDateCreated()));
	    		   veteranInfoModel.setDateUpdated(getXMLGregorianCalendar(client.getDateUpdated()));
	    		   veteranInfoModel.setDesertStorm(getByte(client.getDesertStorm()));
	    		   veteranInfoModel.setDischargeStatus(getByte(client.getDischargeStatus()));
	    		   veteranInfoModel.setIraqOIF(getByte(client.getIraqOIF()));
	    		   veteranInfoModel.setIraqOND(getByte(client.getIraqOND()));
	    		   veteranInfoModel.setKoreanWar(getByte(client.getKoreanWar()));
	    		   veteranInfoModel.setMilitaryBranch(getByte(client.getMilitaryBranch()));
	    		   veteranInfoModel.setOtherTheater(getByte(client.getOtherTheater()));
	    		   veteranInfoModel.setPersonalID(client.getPersonalID());
	    		   veteranInfoModel.setUserID(client.getUserID());
//	    		   veteranInfoModel.setVeteranInfoID(client.getv);
	    		   veteranInfoModel.setVietnamWar(getByte(client.getVietnamWar()));
	    		   veteranInfoModel.setWorldWarII(getByte(client.getWorldWarII()));
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
	  }
	  /**
	   * Hydrate Disabilities with in Sources Object from Disabilities CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateDisabilities(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Disabilities> csvReader = new CSVReaderBuilder<Disabilities>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Disabilities>(Disabilities.class, vpp)).build();
	      List<Disabilities> disabilities = csvReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities> disabilitiesList = new ArrayList<Sources.Source.Export.Disabilities>();
	      for(Disabilities disability : disabilities) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities disabilitiesModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities();
	    	  disabilitiesModel.setDataCollectionStage(getByte(disability.getDataCollectionStage()));
	    	  disabilitiesModel.setDateCreated(getXMLGregorianCalendar(disability.getDateCreated()));
	    	  disabilitiesModel.setDateUpdated(getXMLGregorianCalendar(disability.getDateUpdated()));
	    	  disabilitiesModel.setDisabilitiesID(disability.getDisabilitiesID());
	    	  disabilitiesModel.setDisabilityResponse(getByte(disability.getDisabilityResponse()));
	    	  disabilitiesModel.setDisabilityType(getByte(disability.getDisabilityType()));
	    	  disabilitiesModel.setDocumentationOnFile(getByte(disability.getDocumentationOnFile()));
	    	 // disabilitiesModel.setIndefiniteAndImpairs(getByte(disability.getIndefiniteAndImpairs()));
	    	  disabilitiesModel.setInformationDate(getXMLGregorianCalendar(disability.getInformationDate()));
	    	  disabilitiesModel.setPATHHowConfirmed(getByte(disability.getPATHHowConfirmed()));
	    	  disabilitiesModel.setPATHSMIInformation(getByte(disability.getPATHSMIInformation()));
	    	  disabilitiesModel.setProjectEntryID(disability.getProjectEntryID());
	    	  disabilitiesModel.setReceivingServices(getByte(disability.getReceivingServices()));
	    	  disabilitiesModel.setUserID(disability.getUserID());
	    	  
	    	  disabilitiesList.add(disabilitiesModel);
	      }
	      sources.getSource().getExport().setDisabilities(disabilitiesList);
	  }
	 /**
	   * Hydrate Employment Education with in Sources Object from Disabilities CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateEmployementEducation(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<EmployementEducation> employementReader = new CSVReaderBuilder<EmployementEducation>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<EmployementEducation>(EmployementEducation.class, vpp)).build();
	      List<EmployementEducation> employementEdu = employementReader.readAll();
	      List<Employment> employmentList = new ArrayList<Sources.Source.Export.Employment>();
	      if(employementEdu !=null && employementEdu.size() >0 ) {
	    	  for(EmployementEducation  employementEducationCSV : employementEdu) {
	    		  if(employementEducationCSV !=null) {
	    			  Employment employmentModel = new Employment();
	    			  employmentModel.setDataCollectionStage(getByte(employementEducationCSV.getDataCollectionStage()));
	    			  employmentModel.setDateCreated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  employmentModel.setDateUpdated(getXMLGregorianCalendar(employementEducationCSV.getDateUpdated()));
	    			  employmentModel.setEmployed(getByte(employementEducationCSV.getEmployed()));
	    			  employmentModel.setEmploymentID(employementEducationCSV.getEmploymentEducationID());
	    			  employmentModel.setEmploymentType(getByte(employementEducationCSV.getEmploymentType()));
	    			  employmentModel.setInformationDate(getXMLGregorianCalendar(employementEducationCSV.getInformationDate()));
	    			  employmentModel.setNotEmployedReason(getByte(employementEducationCSV.getNotEmployedReason()));
	    			  employmentModel.setProjectEntryID(employementEducationCSV.getProjectEntryID());
	    			  employmentModel.setUserID(employementEducationCSV.getUserID());
	    			  employmentList.add(employmentModel);
	    		  }
	    		  sources.getSource().getExport().setEmployment(employmentList);
	    	  }
	      }
	  }
	  /**
	   * Hydrate Enrollment with in Sources Object from Enrollment CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateEnrollment(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Enrollment> enrollmentReader = new CSVReaderBuilder<Enrollment>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Enrollment>(Enrollment.class, vpp)).build();
	      List<Enrollment> enrollment = enrollmentReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollmentList = new ArrayList<Sources.Source.Export.Enrollment>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement> dateOfEngagementList = new ArrayList<Sources.Source.Export.DateOfEngagement>();
	      List<ResidentialMoveInDate> residentialmoveindateList = new ArrayList<ResidentialMoveInDate>();
	      List<WorstHousingSituation> worsthousingsituationtList = new ArrayList<WorstHousingSituation>();
	      List<RHYBCPStatus> rhybcpStatusList = new ArrayList<RHYBCPStatus>();
	      List<PATHStatus> pathStatusList = new ArrayList<PATHStatus>();
	      List<EntrySSVF>  entrySSVFList= new  ArrayList<EntrySSVF>();
	      List<EntryRHY> entryRHYList = new ArrayList<Sources.Source.Export.EntryRHY>();
	      List<EntryRHSP> entryRHSPList = new ArrayList<EntryRHSP>();
	      
	      for(Enrollment enroll : enrollment) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollmentModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment();
	    	  enrollmentModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  enrollmentModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  enrollmentModel.setDisablingCondition(getByte(enroll.getDisablingCondition()));
	    	  enrollmentModel.setEntryDate(getXMLGregorianCalendar(enroll.getEntryDate()));
	    	  enrollmentModel.setHouseholdID(enroll.getHouseholdID());
	    	  enrollmentModel.setHousingStatus(getByte(enroll.getHousingStatus()));
	    	  enrollmentModel.setMonthsHomelessPastThreeYears(getByte(enroll.getMonthsHomelessPastThreeYears()));
	    	  //enrollmentModel.setMonthsHomelessThisTime(getByte(enroll.get));
	    	  enrollmentModel.setOtherResidencePrior(enroll.getOtherResidencePrior());
	    	  enrollmentModel.setPersonalID(enroll.getPersonalID());
	    	  enrollmentModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  enrollmentModel.setProjectID(enroll.getProjectID());
	    	  enrollmentModel.setRelationshipToHoH(getByte(enroll.getRelationshipToHoH()));
	    	  enrollmentModel.setResidencePrior(getByte(enroll.getResidencePrior()));
	    	  enrollmentModel.setResidencePriorLengthOfStay(getByte(enroll.getResidencePriorLengthOfStay()));
//	    	  enrollmentModel.setStatusDocumented(getByte(enroll.get));
	    	  enrollmentModel.setTimesHomelessPastThreeYears(getByte(enroll.getTimesHomelessPastThreeYears()));
	    	  enrollmentModel.setUserID(enroll.getUserID());
//	    	  enrollmentModel.setYearsHomeless(getByte(enroll.get));
	    	  enrollmentList.add(enrollmentModel);
	    	  
	    	  
	    	  DateOfEngagement dateOfEngagementModel = new DateOfEngagement();
	    	  dateOfEngagementModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  dateOfEngagementModel.setDateOfEngagement(getXMLGregorianCalendar(enroll.getDateOfEngagement()));
	    	  dateOfEngagementModel.setDateOfEngagementID(enroll.getProjectEntryID());
	    	  dateOfEngagementModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  dateOfEngagementModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  dateOfEngagementModel.setUserID(enroll.getUserID());
	    	  dateOfEngagementList.add(dateOfEngagementModel);
	    	  
	    	  ResidentialMoveInDate residentialmoveindateModel = new ResidentialMoveInDate();
	    	  residentialmoveindateModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  residentialmoveindateModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  residentialmoveindateModel.setInPermanentHousing(getByte(enroll.getInPermanentHousing()));
	    	  residentialmoveindateModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  residentialmoveindateModel.setResidentialMoveInDate(getXMLGregorianCalendar(enroll.getResidentialMoveInDate()));
	    	  residentialmoveindateModel.setResidentialMoveInDateID(enroll.getProjectEntryID());
	    	  residentialmoveindateModel.setUserID(enroll.getUserID());
	    	  residentialmoveindateList.add(residentialmoveindateModel);
	    	  
	    	  WorstHousingSituation worsthousingsituationModel = new WorstHousingSituation();
	    	  worsthousingsituationModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  worsthousingsituationModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  worsthousingsituationModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  worsthousingsituationModel.setUserID(enroll.getUserID());
	    	  worsthousingsituationModel.setWorstHousingSituation(getByte(enroll.getWorstHousingSituation()));
	    	  worsthousingsituationModel.setWorstHousingSituationID(enroll.getProjectEntryID());
	    	  worsthousingsituationtList.add(worsthousingsituationModel);
	    	  
	    	  PATHStatus pathstatusModel = new PATHStatus();;
	    	  pathstatusModel.setClientEnrolledInPATH(getByte(enroll.getClientEnrolledInPATH()));
	    	  pathstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  pathstatusModel.setDateOfStatus(getXMLGregorianCalendar(enroll.getDateOFPATHStatus()));
	    	  pathstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  pathstatusModel.setPathStatusID(enroll.getProjectEntryID());
	    	  pathstatusModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  pathstatusModel.setReasonNotEnrolled(getByte(enroll.getReasonNotEnrolled()));
	    	  pathstatusModel.setUserID(enroll.getUserID());
	    	  pathStatusList.add(pathstatusModel);

	    	  RHYBCPStatus rhybcpstatusModel = new RHYBCPStatus();
	    	  rhybcpstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  rhybcpstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  rhybcpstatusModel.setFYSBYouth(getByte(enroll.getFYSBYouth()));
	    	  rhybcpstatusModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  rhybcpstatusModel.setReasonNoServices(getByte(enroll.getReasonNoServices()));
	    	  rhybcpstatusModel.setRHYBCPStatusID(enroll.getProjectEntryID());
	    	  //rhybcpstatusModel.setStatusDate(getXMLGregorianCalendar(enroll.get));
	    	  rhybcpstatusModel.setUserID(enroll.getUserID());
	    	  rhybcpStatusList.add(rhybcpstatusModel);
	    	  
	    	  EntrySSVF entrySSVFModel = new EntrySSVF();
	    	  entrySSVFModel.setAddressDataQuality(getByte(enroll.getAddressDataQuality()));
	    	  entrySSVFModel.setHPScreeningScore(getByte(enroll.getHPScreeningScore()));
	    	  entrySSVFModel.setLastPermanentCity(enroll.getLastPermanentCity());
	    	  entrySSVFModel.setLastPermanentState(enroll.getLastPermanentState());
	    	  entrySSVFModel.setLastPermanentStreet(enroll.getLastPermanentStreet());
	    	  if(StringUtils.isNotBlank(enroll.getLastPermanentZIP()))
	    		  entrySSVFModel.setLastPermanentZIP(Integer.parseInt(enroll.getLastPermanentZIP()));
	    	  entrySSVFModel.setPercentAMI(getByte(enroll.getPercentAMI()));
	    	  entrySSVFModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  entrySSVFModel.setVAMCStation(enroll.getVAMCStation());
	    	  entrySSVFModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  entrySSVFModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  entrySSVFModel.setUserID(enroll.getUserID());
	    	  entrySSVFList.add(entrySSVFModel);
	    	  
	    	  EntryRHY entryRHY = new EntryRHY();
	    	  entryRHY.setAbuseAndNeglectFam(getByte(enroll.getAbuseAndNeglectFam()));
	    	  entryRHY.setAbuseAndNeglectYouth(getByte(enroll.getAbuseAndNeglectYouth()));
	    	  entryRHY.setActiveMilitaryParent(getByte(enroll.getActiveMilitaryParent()));
	    	  entryRHY.setAlcoholDrugAbuseFam(getByte(enroll.getAlcoholDrugAbuseFam()));
	    	  entryRHY.setAlcoholDrugAbuseYouth(getByte(enroll.getAlcoholDrugAbuseYouth()));
	    	  entryRHY.setAskedOrForcedToExchangeForSex(getByte(enroll.getAskedOrForcedToExchangeForSex()));
	    	  entryRHY.setAskedOrForcedToExchangeForSexPastThreeMonths(getByte(enroll.getAskedOrForcedToExchangeForSexPastThreeMonths()));
	    	  entryRHY.setChildWelfareMonths(getByte(enroll.getChildWelfareMonths()));
	    	  entryRHY.setChildWelfareYears(getByte(enroll.getChildWelfareYears()));
	    	  entryRHY.setCoercedToContinueWork(getByte(enroll.getCoercedToContinueWork()));
	    	  entryRHY.setCountOfExchangeForSex(getByte(enroll.getCountOfExchangeForSex()));
	    	  entryRHY.setCountOutreachReferralApproaches(getByte(enroll.getCountOutreachReferralApproaches()));
	    	  //entryRHY.setDataCollectionStage(enroll.getDat);
	    	  entryRHY.setEntryRHYID(enroll.getProjectEntryID());
	    	  entryRHY.setExchangeForSex(getByte(enroll.getExchangeForSex()));
	    	  entryRHYList.add(entryRHY);
	    	  
	    	  EntryRHSP entryRHSP = new EntryRHSP();
	    	  entryRHSP.setWorstHousingSituation(enroll.getWorstHousingSituation());
	    	  entryRHSP.setProjectID(enroll.getProjectID());
	    	  entryRHSP.setEntryRHSPID(enroll.getProjectEntryID());
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
    	  sources.getSource().getExport().setWorstHousingSituation(worsthousingsituationtList);
    	  sources.getSource().getExport().setRHYBCPStatus(rhybcpStatusList);
    	  sources.getSource().getExport().setDateOfEngagement(dateOfEngagementList);
    	  sources.getSource().getExport().setResidentialMoveInDate(residentialmoveindateList);
    	  sources.getSource().getExport().setEntrySSVF(entrySSVFList);
    	  sources.getSource().getExport().setEntryRHY(entryRHYList);
	  }
	  /**
	   * Hydrate EnrollmentCoc with in Sources Object from EnrollmentCoc CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateEnrollmentCoC(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<EnrollmentCoC> enrollmentCocReader = new CSVReaderBuilder<EnrollmentCoC>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<EnrollmentCoC>(EnrollmentCoC.class, vpp)).build();
	      List<EnrollmentCoC> enrollmentCoc = enrollmentCocReader.readAll();
	      for(EnrollmentCoC enrollCoC : enrollmentCoc) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC enrollmentCocModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC();
	    	  enrollmentCocModel.setDataCollectionStage(getByte(enrollCoC.getDataCollectionStage()));
	    	  enrollmentCocModel.setDateCreated(getXMLGregorianCalendar(enrollCoC.getDateCreated()));
	    	  enrollmentCocModel.setDateUpdated(getXMLGregorianCalendar(enrollCoC.getDateUpdated()));
	    	  enrollmentCocModel.setEnrollmentCoCID(enrollCoC.getEnrollmentCOCID());
	    	  enrollmentCocModel.setInformationDate(getXMLGregorianCalendar(enrollCoC.getInformationDate()));
	    	  enrollmentCocModel.setClientCoC(enrollCoC.getCoCCode());
	    	  enrollmentCocModel.setProjectEntryID(enrollCoC.getProjectEntryID());
	    	  enrollmentCocModel.setUserID(enrollCoC.getUserID());
	    	  sources.getSource().getExport().getEnrollmentCoC().add(enrollmentCocModel);
	      }
	  }
	  
	  /**
	   * Hydrate Exit with in Sources Object from Exit CSV Pojos.
	   * @param csvFile
	   * @param sourcesoe
	   * @throws IOException
	   */
	  protected void hydrateExit(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Exit> exitReader = new CSVReaderBuilder<Exit>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Exit>(Exit.class, vpp)).build();
	      List<Exit> exit = exitReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit> exitList = new ArrayList<Sources.Source.Export.Exit>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition> housingAssessmentDispositionList = new ArrayList<Sources.Source.Export.HousingAssessmentDisposition>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment> exitHousingAssessmentList = new ArrayList<Sources.Source.Export.ExitHousingAssessment>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY> exitRhyList = new ArrayList<Sources.Source.Export.ExitRHY>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH> exitPATHList = new ArrayList<Sources.Source.Export.ExitPATH>();
	      for(Exit ext : exit) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit exitModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit();
	    	  
	    	  exitModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitModel.setDestination(getByte(ext.getDestination()));
	    	  exitModel.setExitDate(getXMLGregorianCalendar(ext.getExitDate()));
	    	  exitModel.setExitID(ext.getExitID());
	    	  exitModel.setOtherDestination(ext.getOtherDestination());
	    	  exitModel.setProjectEntryID(ext.getProjectEntryID());
	    	  exitModel.setUserID(ext.getUserID());
	    	  exitList.add(exitModel);
	    	  sources.getSource().getExport().getExit().add(exitModel);
	    	  
	    	  HousingAssessmentDisposition housingAssessmentDispositionModel = new HousingAssessmentDisposition();
	    	  housingAssessmentDispositionModel.setAssessmentDisposition(getByte(ext.getAssessmentDisposition()));
	    	  housingAssessmentDispositionModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  housingAssessmentDispositionModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  housingAssessmentDispositionModel.setExitID(ext.getExitID());
	    	  housingAssessmentDispositionModel.setHousingAssessmentDispositionID(ext.getHousingAssessment());
	    	  housingAssessmentDispositionModel.setOtherDisposition(ext.getOtherDisposition());
	    	  housingAssessmentDispositionModel.setUserID(ext.getUserID());
	    	  housingAssessmentDispositionList.add(housingAssessmentDispositionModel);
	    	  ExitHousingAssessment exitHousingAssessmentModel = new ExitHousingAssessment();
	    	  exitHousingAssessmentModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitHousingAssessmentModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitHousingAssessmentModel.setExitHousingAssessmentID(ext.getExitID());
	    	  exitHousingAssessmentModel.setExitID(ext.getExitID());
	    	  exitHousingAssessmentModel.setHousingAssessment(getByte(ext.getHousingAssessment()));
	    	  exitHousingAssessmentModel.setSubsidyInformation(getByte(ext.getSubsidyInformation()));
	    	  exitHousingAssessmentModel.setUserID(ext.getUserID());
	    	  exitHousingAssessmentList.add(exitHousingAssessmentModel);
	    	  ExitPATH exitPathModel = new ExitPATH();
	    	  exitPathModel.setConnectionWithSOAR(getByte(ext.getConnectionWithSOAR()));
	    	  exitPathModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitPathModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitPathModel.setExitPATHID(ext.getExitID());
	    	  exitPathModel.setUserID(ext.getUserID());
	    	  exitPathModel.setExitID(ext.getExitID());
	    	  exitPATHList.add(exitPathModel);
	    	  
	    	  ExitRHY exitRHYModel = new ExitRHY();
	    	  exitRHYModel.setAssistanceMainstreamBenefits(getByte(ext.getAssistanceMainstreamBenefits()));
	    	  exitRHYModel.setEarlyExitReason(getByte(ext.getEarlyExitReason()));
	    	  exitRHYModel.setExitCounseling(getByte(ext.getExitCounseling()));
	    	  exitRHYModel.setExitID(ext.getExitID());
	    	  exitRHYModel.setFamilyReunificationAchieved(getByte(ext.getFamilyReunificationAchieved()));
	    	  exitRHYModel.setFurtherFollowUpServices(getByte(ext.getFurtherFollowUpServices()));
	    	  exitRHYModel.setOtherAftercarePlanOrAction(getByte(ext.getOtherAftercarePlanOrAction()));
	    	  exitRHYModel.setPermanentHousingPlacement(getByte(ext.getPermanentHousingPlacement()));
	    	  exitRHYModel.setProjectCompletionStatus(getByte(ext.getProjectCompletionStatus()));
	    	  exitRHYModel.setResourcePackage(getByte(ext.getResourcePackage()));
	    	  exitRHYModel.setScheduledFollowUpContacts(getByte(ext.getScheduledFollowupContacts()));
	    	  exitRHYModel.setTemporaryShelterPlacement(getByte(ext.getTemporaryShelterPlacement()));
	    	  exitRHYModel.setWrittenAftercarePlan(getByte(ext.getWrittenAftercarePlan()));
	    	  exitRHYModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitRHYModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitRHYModel.setExitRHYID(ext.getExitID());
	    	  exitRHYModel.setUserID(ext.getUserID());
	    	  exitRhyList.add(exitRHYModel);
	      }
	      sources.getSource().getExport().setHousingAssessmentDisposition(housingAssessmentDispositionList);
	      sources.getSource().getExport().setExitHousingAssessment(exitHousingAssessmentList);
	      sources.getSource().getExport().setExitPATH(exitPATHList);
	      sources.getSource().getExport().setExitRHY(exitRhyList);
	      
	  }
	  
	  /**
	   * Hydrate Export with in Sources Object from Export CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateExport(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Export> exportReader = new CSVReaderBuilder<Export>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Export>(Export.class, vpp)).build();
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
	  }
	      
	  /**
	   * Hydrate Funder with in Sources Object from Funder CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateFunder(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Funder> funderReader = new CSVReaderBuilder<Funder>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Funder>(Funder.class, vpp)).build();
	      List<Funder> funder = funderReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder> funderList = new ArrayList<Sources.Source.Export.Funder>();
	      for(Funder fund : funder) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder funderModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Funder();
	    	  funderList.add(funderModel);
	    	  funderModel.setDateCreated(getXMLGregorianCalendar(fund.getDateCreated()));
	    	  funderModel.setDateUpdated(getXMLGregorianCalendar(fund.getDateUpdated()));
	    	  funderModel.setEndDate(getXMLGregorianCalendar(fund.getEndDate()));
	    	  funderModel.setFunder(getByte(fund.getFunder()));
	    	  funderModel.setFunderID(fund.getFunderID());
	    	  funderModel.setGrantID(fund.getGrantID());
	    	  funderModel.setProjectID(fund.getProjectID());
	    	  funderModel.setStartDate(getXMLGregorianCalendar(fund.getStartDate()));
	    	  funderModel.setUserID(fund.getUserID());
	    	  
	    	  sources.getSource().getExport().getFunder().add(funderModel);
	      }
	      
	  }
	  
	  /**
	   * Hydrate HealthAndDV with in Sources Object from HealthAndDV CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateHealthAndDV(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<HealthAndDV> healthAndDVReader = new CSVReaderBuilder<HealthAndDV>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<HealthAndDV>(HealthAndDV.class, vpp)).build();
	      List<HealthAndDV> healthAndDV = healthAndDVReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus> healthStatusList = new ArrayList<Sources.Source.Export.HealthStatus>();
	      List<DomesticViolence> domesticViolenceList = new ArrayList<DomesticViolence>();
	      for(HealthAndDV healthDV : healthAndDV) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus healthStatus = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus();
	    	  healthStatus.setDataCollectionStage(getByte(healthDV.getDataCollectionStage()));
	    	  healthStatus.setDateCreated(getXMLGregorianCalendar(healthDV.getDateCreated()));
	    	  healthStatus.setDateUpdated(getXMLGregorianCalendar(healthDV.getDateUpdated()));
	    	  healthStatus.setDueDate(getXMLGregorianCalendar(healthDV.getDueDate()));
	    	  healthStatus.setHealthStatus(getByte(healthDV.getGeneralHealthStatus()));
	    	  healthStatus.setHealthStatusID(healthDV.getHealthAndDVID());
	    	//  healthStatus.setHealthCategory(); TODO: Need to fing out Health Category
	    	  healthStatus.setInformationDate(getXMLGregorianCalendar(healthDV.getInformationDate()));
	    	  healthStatus.setProjectEntryID(healthDV.getProjectEntryID());
	    	  healthStatus.setUserID(healthDV.getUserID());
	    	  healthStatusList.add(healthStatus);
	    	  
	    	   DomesticViolence domesticViolenceModel = new DomesticViolence();
			      domesticViolenceModel.setDataCollectionStage(getByte(healthDV.getDataCollectionStage()));
			      domesticViolenceModel.setDateCreated(getXMLGregorianCalendar(healthDV.getDateCreated()));
			      domesticViolenceModel.setDateUpdated(getXMLGregorianCalendar(healthDV.getDateUpdated()));
			      domesticViolenceModel.setDomesticViolenceID(healthDV.getHealthAndDVID());
			      domesticViolenceModel.setDomesticViolenceVictim(getByte(healthDV.getDomesticViolenceVictim()));
			      domesticViolenceModel.setInformationDate(getXMLGregorianCalendar(healthDV.getInformationDate()));
			      domesticViolenceModel.setProjectEntryID(healthDV.getProjectEntryID());
			      domesticViolenceModel.setUserID(healthDV.getUserID());
			      domesticViolenceModel.setWhenOccurred(getByte(healthDV.getWhenOccurred()));
			      domesticViolenceList.add(domesticViolenceModel);
		    	  
	      }
	      sources.getSource().getExport().setHealthStatus(healthStatusList);
	      sources.getSource().getExport().setDomesticViolence(domesticViolenceList);
	  }
	  
	  /**
	   * Hydrate IncomeBenefits with in Sources Object from IncomeBenefits CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateIncomeBenefits(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<IncomeBenefits> incomeBenefitsReader = new CSVReaderBuilder<IncomeBenefits>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<IncomeBenefits>(IncomeBenefits.class, vpp)).build();
	      List<IncomeBenefits> incomeBenefits = incomeBenefitsReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources> incomeBenefitsList = new ArrayList<Sources.Source.Export.IncomeAndSources>();
	      List<NonCashBenefits> nonCashBenefitsList = new ArrayList<NonCashBenefits>();
	      List<MedicalAssistance> medicalAssistanceList = new ArrayList<MedicalAssistance>();
	      for(IncomeBenefits incomeBnfts : incomeBenefits) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources incomeBenefitsModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources();
	    	  
	    	  incomeBenefitsModel.setAlimony(getByte(incomeBnfts.getAlimony()));
	    	  if(incomeBnfts.getAlimonyAmount()!=null && !"".equals(incomeBnfts.getAlimonyAmount())){
	    		  incomeBenefitsModel.setAlimonyAmount(incomeBnfts.getAlimonyAmount());
	    	  }
	    	  incomeBenefitsModel.setChildSupport(getByte(incomeBnfts.getChildSupport()));
	    	  if(incomeBnfts.getChildSupportAmount()!=null && !"".equals(incomeBnfts.getChildSupportAmount())){
	    		  incomeBenefitsModel.setChildSupportAmount(incomeBnfts.getChildSupportAmount());
	    	  }
	    	  incomeBenefitsModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  incomeBenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  incomeBenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  incomeBenefitsModel.setEarned(getByte(incomeBnfts.getEarned()));
	    	  if(incomeBnfts.getEarnedAmount()!=null && !"".equals(incomeBnfts.getEarnedAmount())){
	    		  incomeBenefitsModel.setEarnedAmount(incomeBnfts.getEarnedAmount());
	    	  }
	    	  incomeBenefitsModel.setGA(getByte(incomeBnfts.getGA()));
	    	  if(incomeBnfts.getGAAmount()!=null && !"".equals(incomeBnfts.getGAAmount())){
	    		  incomeBenefitsModel.setGAAmount(incomeBnfts.getGAAmount());
	    	  }
	    	  incomeBenefitsModel.setIncomeAndSourcesID(incomeBnfts.getIncomeBenefitsID());
	    	  incomeBenefitsModel.setIncomeFromAnySource(getByte(incomeBnfts.getIncomeFromAnySource()));
	    	  incomeBenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  incomeBenefitsModel.setOtherSource(getByte(incomeBnfts.getOtherIncomeSource()));
	    	  if(incomeBnfts.getOtherIncomeAmount()!=null && !"".equals(incomeBnfts.getOtherIncomeAmount())){
	    		  incomeBenefitsModel.setOtherAmount(incomeBnfts.getOtherIncomeAmount());
	    	  }
	    	  incomeBenefitsModel.setOtherSourceIdentify(incomeBnfts.getOtherIncomeSourceIdentify());
	    	  incomeBenefitsModel.setPension(getByte(incomeBnfts.getPension()));
	    	  if(incomeBnfts.getPensionAmount()!=null && !"".equals(incomeBnfts.getPensionAmount())){
	    		  incomeBenefitsModel.setPensionAmount(incomeBnfts.getPensionAmount());
	    	  }
	    	  incomeBenefitsModel.setPrivateDisability(getByte(incomeBnfts.getPrivateDisability()));
	    	  if(incomeBnfts.getPrivateDisabilityAmount()!=null && !"".equals(incomeBnfts.getPrivateDisabilityAmount())){
	    		  incomeBenefitsModel.setPrivateDisabilityAmount(incomeBnfts.getPrivateDisabilityAmount());
	    	  }
	    	  incomeBenefitsModel.setProjectEntryID(incomeBnfts.getProjectEntryID());
	    	  incomeBenefitsModel.setSocSecRetirement(getByte(incomeBnfts.getSocSecRetirement()));
	    	  if(incomeBnfts.getSocSecRetirementAmount()!=null && !"".equals(incomeBnfts.getSocSecRetirementAmount())){
	    		  incomeBenefitsModel.setSocSecRetirementAmount(incomeBnfts.getSocSecRetirementAmount());
	    	  }
	    	  incomeBenefitsModel.setSSDI(getByte(incomeBnfts.getSSDI()));
	    	  if(incomeBnfts.getSSDIAmount()!=null && !"".equals(incomeBnfts.getSSDIAmount())){
	    		  incomeBenefitsModel.setSSDIAmount(incomeBnfts.getSSDIAmount());
	    	  }
	    	  incomeBenefitsModel.setSSI(getByte(incomeBnfts.getSSI()));
	    	  if(incomeBnfts.getSSIAmount()!=null && !"".equals(incomeBnfts.getSSIAmount())){
	    		  incomeBenefitsModel.setSSIAmount(incomeBnfts.getSSIAmount());
	    	  }
	    	  incomeBenefitsModel.setTANF(getByte(incomeBnfts.getTANF()));
	    	  if(incomeBnfts.getTANFAmount()!=null && !"".equals(incomeBnfts.getTANFAmount())){
	    		  incomeBenefitsModel.setTANFAmount(incomeBnfts.getTANFAmount());
	    	  }
	    	  if(incomeBnfts.getTotalMonthlyIncome()!=null && !"".equals(incomeBnfts.getTotalMonthlyIncome())){
	    		  incomeBenefitsModel.setTotalMonthlyIncome(incomeBnfts.getTotalMonthlyIncome());
	    	  }
	    	  incomeBenefitsModel.setUnemployment(getByte(incomeBnfts.getUnemployment()));
	    	  if(incomeBnfts.getUnemploymentAmount()!=null && !"".equals(incomeBnfts.getUnemploymentAmount())){
	    		  incomeBenefitsModel.setUnemploymentAmount(incomeBnfts.getUnemploymentAmount());
	    	  }
	    	  incomeBenefitsModel.setUserID(incomeBnfts.getUserID());
	    	  incomeBenefitsModel.setVADisabilityNonService(getByte(incomeBnfts.getVADisabilityNonService()));
	    	  if(incomeBnfts.getVADisabilityNonServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityNonServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityNonServiceAmount(incomeBnfts.getVADisabilityNonServiceAmount());
	    	  }
	    	  incomeBenefitsModel.setVADisabilityService(getByte(incomeBnfts.getVADisabilityService()));
	    	  if(incomeBnfts.getVADisabilityServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityServiceAmount(incomeBnfts.getVADisabilityServiceAmount());
	    	  }
	    	  
	    	  incomeBenefitsModel.setWorkersComp(getByte(incomeBnfts.getWorkersComp()));
	    	  if(incomeBnfts.getWorkersCompAmount()!=null && !"".equals(incomeBnfts.getWorkersCompAmount())){
	    		  incomeBenefitsModel.setWorkersCompAmount(incomeBnfts.getWorkersCompAmount());
	    	  }
	    	  
	    	  NonCashBenefits noncashbenefitsModel = new NonCashBenefits();
	    	  noncashbenefitsModel.setBenefitsFromAnySource(getByte(incomeBnfts.getBenefitsFromAnySource()));
	    	  noncashbenefitsModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  noncashbenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  noncashbenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  noncashbenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  noncashbenefitsModel.setNonCashBenefitsID(incomeBnfts.getIncomeBenefitsID());
	    	  noncashbenefitsModel.setOtherSource(getByte(incomeBnfts.getOtherBenefitsSource()));
	    	  nonCashBenefitsList.add(noncashbenefitsModel);
	    	  
	    	  HealthInsurance healthinsuranceModel = new HealthInsurance();
	    	  healthinsuranceModel.setCOBRA(getByte(incomeBnfts.getCOBRA()));
	    	  healthinsuranceModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  healthinsuranceModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  healthinsuranceModel.setDateDeleted(getXMLGregorianCalendar(incomeBnfts.getDateDeleted()));
	    	  healthinsuranceModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  healthinsuranceModel.setEmployerProvided(getByte(incomeBnfts.getEmployerProvided()));
	    	  healthinsuranceModel.setHealthInsuranceID(incomeBnfts.getIncomeBenefitsID());
	    	  healthinsuranceModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  healthinsuranceModel.setInsuranceFromAnySource(getByte(incomeBnfts.getIncomeFromAnySource()));
	    	  healthinsuranceModel.setMedicaid(getByte(incomeBnfts.getMedicaid()));
	    	  healthinsuranceModel.setMedicare(getByte(incomeBnfts.getMedicare()));
	    	  healthinsuranceModel.setNoCOBRAReason(getByte(incomeBnfts.getNoCOBRAReason()));
	    	  healthinsuranceModel.setNoEmployerProvidedReason(getByte(incomeBnfts.getNoEmployerProvidedReason()));
	    	  healthinsuranceModel.setNoMedicareReason(getByte(incomeBnfts.getNoMedicareReason()));
	    	  healthinsuranceModel.setNoMedicaidReason(getByte(incomeBnfts.getNoMedicaidReason()));
	    	  healthinsuranceModel.setNoPrivatePayReason(getByte(incomeBnfts.getNoPrivatePayReason()));
	    	  healthinsuranceModel.setNoSCHIPReason(getByte(incomeBnfts.getNoSCHIPReason()));
	    	  healthinsuranceModel.setNoStateHealthInsReason(getByte(incomeBnfts.getNoStateHealthInsReason()));
	    	  healthinsuranceModel.setNoVAMedReason(getByte(incomeBnfts.getNoVAMedReason()));
	    	  healthinsuranceModel.setPrivatePay(getByte(incomeBnfts.getPrivatePay()));
	    	  healthinsuranceModel.setProjectEntryID(incomeBnfts.getProjectEntryID());
	    	  healthinsuranceModel.setSCHIP(getByte(incomeBnfts.getSCHIP()));
	    	  healthinsuranceModel.setStateHealthIns(getByte(incomeBnfts.getStateHealthIns()));
	    	  healthinsuranceModel.setUserID(incomeBnfts.getUserID());
	    	  healthinsuranceModel.setVAMedicalServices(getByte(incomeBnfts.getVAMedicalServices()));
	    	  sources.getSource().getExport().getHealthInsurance().add(healthinsuranceModel);
	    	  
	    	  MedicalAssistance medicalassistanceModel = new MedicalAssistance();
	    	  medicalassistanceModel.setADAP(getByte(incomeBnfts.getADAP()));
	    	  medicalassistanceModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  medicalassistanceModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  medicalassistanceModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  medicalassistanceModel.setHIVAIDSAssistance(getByte(incomeBnfts.getHIVAIDSAssistance()));
	    	  medicalassistanceModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
	    	  medicalassistanceModel.setMedicalAssistanceID(incomeBnfts.getIncomeBenefitsID());
	    	  medicalassistanceModel.setNoADAPReason(getByte(incomeBnfts.getNoADAPReason()));
	    	  medicalassistanceModel.setNoHIVAIDSAssistanceReason(getByte(incomeBnfts.getNoHIVAIDSAssistanceReason()));
	    	  medicalassistanceModel.setProjectEntryID(incomeBnfts.getProjectEntryID());
	    	  medicalassistanceModel.setUserID(incomeBnfts.getUserID());
	    	  medicalAssistanceList.add(medicalassistanceModel);
	    	  incomeBenefitsList.add(incomeBenefitsModel);
	      }
	      sources.getSource().getExport().setIncomeAndSources(incomeBenefitsList);
	      sources.getSource().getExport().setNonCashBenefits(nonCashBenefitsList);
	      sources.getSource().getExport().setMedicalAssistance(medicalAssistanceList);
	  }
	  
	  /**
	   * Hydrate Inventory with in Sources Object from Inventory CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateInventory(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Inventory> inventoryReader = new CSVReaderBuilder<Inventory>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Inventory>(Inventory.class, vpp)).build();
	      List<Inventory> inventory = inventoryReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory> inventoryList = new ArrayList<Sources.Source.Export.Inventory>();
	      for(Inventory invntry : inventory) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory();
	    	  inventoryModel.setAvailability(getByte(invntry.getAvailability()));
	    	  inventoryModel.setBedType(getByte(invntry.getBedType()));
	    	  inventoryModel.setDateCreated(getXMLGregorianCalendar(invntry.getDateCreated()));
	    	  inventoryModel.setDateUpdated(getXMLGregorianCalendar(invntry.getDateUpdated()));
	    	  inventoryModel.setHMISParticipatingBeds(Integer.parseInt(invntry.getHMISParticipatingBeds()));
	    	  inventoryModel.setHouseholdType(getByte(invntry.getHouseholdType()));
	    	  inventoryModel.setInformationDate(getXMLGregorianCalendar(invntry.getInformationDate()));
	    	  inventoryModel.setInventoryEndDate(getXMLGregorianCalendar(invntry.getInventoryEndDate()));
	    	  inventoryModel.setInventoryID(invntry.getInventoryID());
	    	  inventoryModel.setInventoryStartDate(getXMLGregorianCalendar(invntry.getInventoryStartDate()));
	    	  if(invntry.getCoCCode() !=null && !"".equals(invntry.getCoCCode()))
	    		  inventoryModel.setCoCCode(invntry.getCoCCode());
	    	  if(invntry.getUnitInventory() !=null && !"".equals(invntry.getUnitInventory()))
	    		  inventoryModel.setUnitInventory(Integer.parseInt(invntry.getUnitInventory()));
	    	  inventoryModel.setUserID(invntry.getUserID());
	    	  
	    	  BedInventory bedInventory = new BedInventory();
	    	  if(invntry.getBedInventory() !=null && !"".equals(invntry.getBedInventory() )) {
		    	  bedInventory.setBedInventory(Short.valueOf(invntry.getBedInventory()));  
	    	  }
	    	  bedInventory.setCHBedInventory(getByte(invntry.getCHBedInventory()));
	    	  bedInventory.setVetBedInventory(getByte(invntry.getVetBedInventory()));
	    	  bedInventory.setYouthAgeGroup(getByte(invntry.getYouthAgeGroup()));
	    	  bedInventory.setYouthBedInventory(getByte(invntry.getYouthBedInventory()));
	    	  
	    	  inventoryModel.setBedInventory(bedInventory);
	    	  inventoryList.add(inventoryModel);
	      }
	      sources.getSource().getExport().setInventory(inventoryList);
	      
	  }
	  
	  /**
	   * Hydrate Organization with in Sources Object from Organization CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateOrganization(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Organization> organizationReader = new CSVReaderBuilder<Organization>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Organization>(Organization.class, vpp)).build();
	      List<Organization> organization = organizationReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization> organizationList = new ArrayList<Sources.Source.Export.Organization>();
	      for(Organization orgtn : organization) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization organizationModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Organization();
	    	  organizationModel.setDateCreated(getXMLGregorianCalendar(orgtn.getDateCreated()));
	    	  organizationModel.setDateUpdated(getXMLGregorianCalendar(orgtn.getDateUpdated()));
	    	  organizationModel.setOrganizationCommonName(orgtn.getOrganizationCommonName());
	    	  organizationModel.setOrganizationID(orgtn.getOrganizationID());
	    	  organizationModel.setOrganizationName(orgtn.getOrganizationName());
	    	  organizationModel.setUserID(orgtn.getUserID());
	    	  
	    	  organizationList.add(organizationModel);
	      }
	      sources.getSource().getExport().setOrganization(organizationList);
	  }
	  
	  /**
	   * Hydrate Project with in Sources Object from Project CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateProject(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Project> projectReader = new CSVReaderBuilder<Project>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Project>(Project.class, vpp)).build();
	      List<Project> project = projectReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project> projectList = new ArrayList<Sources.Source.Export.Project>();
	      List<Affiliation> affiliationList = new ArrayList<Sources.Source.Export.Affiliation>();
	      for(Project prjt : project) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project projectModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project();
	    	  
	    	  projectModel.setContinuumProject(getByte(prjt.getContinuumProject()));
	    	  projectModel.setDateCreated(getXMLGregorianCalendar(prjt.getDateCreated()));
	    	  projectModel.setDateUpdated(getXMLGregorianCalendar(prjt.getDateUpdated()));
	    	 // Sandeep Fix this.
	    	 // projectModel.setOrganizationID(getByte(prjt.getOrganizationID()));
	    	  projectModel.setProjectCommonName(prjt.getProjectCommonName());
	    	  projectModel.setProjectID(prjt.getProjectID());
	    	  projectModel.setProjectName(prjt.getProjectName());
	    	  projectModel.setProjectType(getByte(prjt.getProjectType()));
	    	  projectModel.setResidentialAffiliation(getByte(prjt.getResidentialAffiliation()));
	    	  projectModel.setTargetPopulation(getByte(prjt.getTargetPopulation()));
	    	  projectModel.setTrackingMethod(getByte(prjt.getTrackingMethod()));
	    	  projectModel.setUserID(prjt.getUserID());
	    	  
	    	  projectList.add(projectModel);
	    	  
	    	  Affiliation affiliationModel = new Affiliation();
	    	  affiliationModel.setAffiliationID(prjt.getResidentialAffiliation());
	    	  affiliationModel.setDateCreated(getXMLGregorianCalendar(prjt.getDateCreated()));
	    	  affiliationModel.setDateUpdated(getXMLGregorianCalendar(prjt.getDateUpdated()));
	    	  affiliationModel.setProjectID(prjt.getProjectID());
	    	  affiliationModel.setResProjectID(prjt.getResidentialAffiliation()); 
	    	  affiliationModel.setUserID(prjt.getUserID());
	    	  affiliationList.add(affiliationModel);
	    	  
	    	  sources.getSource().getExport().getProject().add(projectModel);
	      }
	      sources.getSource().getExport().setAffiliation(affiliationList);
	  }
	  
	  /**
	   * Hydrate Coc with in Sources Object from ProjectCOC CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateCoc(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<ProjectCOC> projectCOCReader = new CSVReaderBuilder<ProjectCOC>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<ProjectCOC>(ProjectCOC.class, vpp)).build();
	      List<ProjectCOC> projectCOC = projectCOCReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CoC> projectCoCList = new ArrayList<Sources.Source.Export.CoC>();
	      for(ProjectCOC prjtCoC : projectCOC) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CoC cocModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CoC();
	    	 cocModel.setCoCCode(prjtCoC.getCoCCode());
	    	 cocModel.setDateCreated(getXMLGregorianCalendar(prjtCoC.getDateCreated()));
	    	 cocModel.setDateUpdated(getXMLGregorianCalendar(prjtCoC.getDateUpdated()));
	    	 cocModel.setProjectID(prjtCoC.getProjectID());
	    	 cocModel.setUserID(prjtCoC.getUserID());
	    	  
	    	  projectCoCList.add(cocModel);
	    	  sources.getSource().getExport().getCoC().add(cocModel);
	      }
	      
	  }
	  
	  /**
	   * Hydrate Services with in Sources Object from Services CSV Pojos.
	   *
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateServices(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Services> servicesReader = new CSVReaderBuilder<Services>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Services>(Services.class, vpp)).build();
	      List<Services> services = servicesReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services> servicesList = new ArrayList<Sources.Source.Export.Services>();
	      for(Services srvcs : services) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services servicesModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Services();
	    	  servicesModel.setDateCreated(getXMLGregorianCalendar(srvcs.getDateCreated()));
	    	  servicesModel.setDateProvided(getXMLGregorianCalendar(srvcs.getDateProvided()));
	    	  servicesModel.setDateUpdated(getXMLGregorianCalendar(srvcs.getDateUpdated()));
	    	  if(srvcs.getFAAmount()!=null && !"".equals(srvcs.getFAAmount())){
	    		  servicesModel.setFAAmount(Float.valueOf(srvcs.getFAAmount()));
	    	  }
	    	  servicesModel.setOtherTypeProvided(srvcs.getOtherTypeProvided());
	    	  servicesModel.setProjectEntryID(srvcs.getProjectEntryID());
	    	  servicesModel.setRecordType(srvcs.getRecordType());
	    	  servicesModel.setReferralOutcome(getByte(srvcs.getReferralOutcome()));
	    	  servicesModel.setServicesID(srvcs.getServicesID());
	    	  servicesModel.setSubTypeProvided(getByte(srvcs.getSubTypeProvided()));
	    	  servicesModel.setTypeProvided(srvcs.getTypeProvided());
	    	  servicesModel.setUserID(srvcs.getUserID());
	    	  servicesList.add(servicesModel);
	      }
	      sources.getSource().getExport().setServices(servicesList);
	  }
	 
	 /**
	   * Hydrate Site with in Sources Object from Site CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydrateSite(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Site> siteReader = new CSVReaderBuilder<Site>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Site>(Site.class, vpp)).build();
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
	    	  siteModel.setPrincipalSite(getByte(ste.getPrincipalSite()));
	    	  
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
	  }
	  
	  protected Integer parseInt(String value) {
		  if(value !=null && !"".equals(value)) {
			  return Integer.parseInt(value);
		  }
		  return null;
	  }
	  protected byte getByte(String value) {
		  if(value !=null && !"".equals(value)) {
			  return Byte.valueOf(value);
		  }
		  return 0;
	  }
	  protected String getFileExtension(String fileName) {
			if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
		        return fileName.substring(fileName.lastIndexOf(".")+1);
		        else return "";
	  }
	  protected XMLGregorianCalendar getXMLGregorianCalendar(String date) {
		  if(date == null || "".equals(date)) {
			  return null;
		  }
		  Date dob=null;
		  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		  try {
			  dob=df.parse(date);  
		  }catch(ParseException ex) {
			  
		  }
		  
		  GregorianCalendar cal = new GregorianCalendar();
		  if(dob != null && dob !=null) {
			  cal.setTime(dob);
		  }else {
			  return null;
		  }
		  
		  XMLGregorianCalendar xmlDate2=null;
		try {
			xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return xmlDate2;
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
}
