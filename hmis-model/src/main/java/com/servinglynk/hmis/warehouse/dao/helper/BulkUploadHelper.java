package com.servinglynk.hmis.warehouse.dao.helper;

import java.io.BufferedReader;
import java.io.File;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.CommercialSexualExploitation;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPlansActions;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExportPeriod;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardJuvenileJustice;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthInsurance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.MedicalAssistance;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ReferralSource;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SchoolStatus;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VeteranInfo;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.YouthCriticalIssues;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

@Component
public class BulkUploadHelper {
	/**
	 * Gets the source object from the upload location.
	 * @param upload
	 * @return sources
	 */
	public Sources getSourcesFromFiles(BulkUpload upload) {
		String inputPath = upload.getInputPath();
		if(inputPath !=null && StringUtils.equals("zip",getFileExtension(upload.getInputPath()))){
			return getSourcesForZipFile(upload);
		}
		else if(inputPath !=null && StringUtils.equals("xml",getFileExtension(upload.getInputPath()))){
			return getSourcesForXml(upload);
		}
		return null;
	}
	/**
	 * Gets the Sources XML object when the file to be bulk uploaded is an XML file.
	 * @param upload
	 * @return
	 */
	public Sources getSourcesForXml(BulkUpload upload) {
		try {
			File file = new File(upload.getInputPath());
			if(validateXMLSchema(upload.getInputPath(),"C:\\HMIS\\hmis-lynk-open-source\\hmis-model\\src\\main\\test\\com\\servinglynk\\hmis\\warehouse\\dao\\HUD_HMIS.xsd")) {
				System.out.println("XML is valid");
			}else{
				System.out.println("XML is NOT valid");
			}
		    File tempFile = new File(file.getPath()+System.currentTimeMillis()+"temp.xml");
			try {
			     String content = FileUtils.readFileToString(file, "UTF-8");
			     content = content.replaceAll("hmis:", "");
			     FileUtils.writeStringToFile(tempFile, content, "UTF-8");
			  } catch (IOException e) {
			     //Simple exception handling, replace with what's necessary for your use case!
			     throw new RuntimeException("Generating file failed", e);
			  }
//			   String stylesheetPathname = "";
//			    String inputPathname ="";
//			    String outputPathname = "";
//
//		    TransformerFactory factory = TransformerFactory.newInstance();
//		    Source stylesheetSource = new StreamSource(new File(stylesheetPathname).getAbsoluteFile());
//		    Transformer transformer = factory.newTransformer(stylesheetSource);
//		    Source inputSource = new StreamSource(new File(inputPathname).getAbsoluteFile());
//		    Result outputResult = new StreamResult(new File(outputPathname).getAbsoluteFile());
//		    transformer.transform(inputSource, outputResult);
		    
			JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sources sources = (Sources) jaxbUnmarshaller.unmarshal(tempFile);
			return sources;
			}
			 catch (JAXBException e) {
					e.printStackTrace();
				}
		return null;
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
	public Sources getSourcesForZipFile(BulkUpload upload) {
		Sources sources = new Sources();
		Source source = sources.getSource();
		if(source == null) {
			Source newSource = new Source();
			sources.setSource(newSource);
			newSource.setExport(new Sources.Source.Export());
		}
		try {
			ZipFile zf = new ZipFile(upload.getInputPath());
		      Enumeration entries = zf.entries();
		      while (entries.hasMoreElements()) {
		        ZipEntry ze = (ZipEntry) entries.nextElement();
		        System.out.println("Read " + ze.getName() + "?");
		            BufferedReader csvFile = new BufferedReader(
		                new InputStreamReader(zf.getInputStream(ze)));
		            
		            switch(ze.getName()) {
		            	case "Client.csv":
		            		hydradeClient(csvFile, sources);
		            		break;
		            	case "Disabilities.csv":
		            		hydradeDisabilities(csvFile, sources);
		            		break;
		            	case "EmploymentEducation.csv":
		            		hydradeEmployementEducation(csvFile,sources);
		            		break;
		            	case "Enrollment.csv":
		            		hydradeEnrollment(csvFile, sources);
		            		break;
		            	case "EnrollmentCOC.csv":
		            		hydradeEnrollmentCoC(csvFile, sources);
		            		break;
		            	case "Exit.csv":
		            		hydradeExit(csvFile, sources);
		            		break;
		            	case "Export.csv":
		            		hydradeExport(csvFile, sources);
		            		break;
		            	case "Funder.csv":
		            		hydradeFunder(csvFile, sources);
		            		break;		            		
		            	case "HealthAndDV.csv":
		            		hydradeHealthAndDV(csvFile, sources);
		            		break;
		            	case "IncomeBenefits.csv":
		            		hydradeIncomeBenefits(csvFile, sources);
		            		break;
		            	case "Inventory.csv":
		            		hydradeInventory(csvFile, sources);
		            		break;
		            	case "Organization.csv":
		            		hydradeOrganization(csvFile, sources);
		            		break;
		            	case  "Project.csv" :
		            		hydradeProject(csvFile, sources);
		            		break;
		            	case "ProjectCOC.csv":
		            		hydradeProjectCOC(csvFile, sources);
		            		break;
		            	case "Services.csv":
		            		hydradeServices(csvFile, sources);
		            		break;
		            	case "Site.csv":
		            		hydradeSite(csvFile, sources);
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
	  protected void hydradeClient(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Client> csvReader = new CSVReaderBuilder<Client>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Client>(Client.class, vpp)).build();
	      List<Client> clients = csvReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client> clientList = new ArrayList<Sources.Source.Export.Client>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VeteranInfo> veteranInfoList = new ArrayList<Sources.Source.Export.VeteranInfo>();
	      if(clients !=null && clients.size() > 0) {
	    	  for(Client client : clients) {
	    		   com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client clientModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client();
	    		   clientModel.setEthnicity(getByte(client.getEthnicity()));
	    		   clientModel.setDOB(getXMLGregorianCalendar(client.getDob()));
	    		   clientModel.setDOBDataQuality(getByte(client.getDobDataQuality()));
	    		   clientModel.setFirstName(client.getFirstName());
	    		   clientModel.setLastName(client.getLastName());
	    		   clientModel.setMiddleName(client.getMiddleName());
	    		   clientModel.setGender(getByte(client.getGender()));
	    		   clientModel.setNameDataQuality(getByte(client.getNameDataQuality()));
	    		   clientModel.setNameSuffix(client.getNameSuffix());
	    		   clientModel.setOtherGender(client.getOtherGender());
	    		   clientModel.setPersonalID(client.getPersonalID());
	    		   clientModel.setRace(getByte(client.getRaceNone()));
	    		   clientModel.setSSN(client.getSsn());
	    		   clientModel.setSSNDataQuality(getByte(client.getSsnDataQuality()));
	    		   clientModel.setUserID(client.getUserID());
	    		   clientModel.setVeteranStatus(getByte(client.getVeteranStatus()));
	    		   clientList.add(clientModel);
	    		   
	    		   VeteranInfo veteranInfoModel = new VeteranInfo();
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
	    	  sources.getSource().getExport().setClient(clientList);
	    	  sources.getSource().getExport().setVeteranInfo(veteranInfoList);
	      }
	  }
	  /**
	   * Hydrate Disabilities with in Sources Object from Disabilities CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeDisabilities(BufferedReader csvFile,Sources sources) throws IOException {
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
	    	  disabilitiesModel.setIndefiniteAndImpairs(getByte(disability.getIndefiniteAndImpairs()));
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
	  protected void hydradeEmployementEducation(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<EmployementEducation> employementReader = new CSVReaderBuilder<EmployementEducation>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<EmployementEducation>(EmployementEducation.class, vpp)).build();
	      List<EmployementEducation> employementEdu = employementReader.readAll();
	      List<Employment> employmentList = new ArrayList<Sources.Source.Export.Employment>();
	      List<SchoolStatus> schoolStatusList = new ArrayList<Sources.Source.Export.SchoolStatus>();
	      List<LastGradeCompleted> lastGradeCompletedList = new ArrayList<Sources.Source.Export.LastGradeCompleted>();
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
	    			  
	    			  SchoolStatus schoolStatusModel= new SchoolStatus();
	    			  schoolStatusModel.setDataCollectionStage(getByte(employementEducationCSV.getDataCollectionStage()));
	    			  schoolStatusModel.setDateCreated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  schoolStatusModel.setDateUpdated(getXMLGregorianCalendar(employementEducationCSV.getDateUpdated()));
	    			  schoolStatusModel.setInformationDate(getXMLGregorianCalendar(employementEducationCSV.getInformationDate()));
	    			  schoolStatusModel.setProjectEntryID(employementEducationCSV.getProjectEntryID());
	    			  schoolStatusModel.setUserID(employementEducationCSV.getUserID());
	    			  schoolStatusModel.setSchoolStatus(getByte(employementEducationCSV.getSchoolStatus()));
	    			  schoolStatusList.add(schoolStatusModel);
	    			  
	    			  LastGradeCompleted lastGradeCompletedModel = new LastGradeCompleted();
	    			  lastGradeCompletedModel.setDataCollectionStage(getByte(employementEducationCSV.getDataCollectionStage()));
	    			  lastGradeCompletedModel.setDateCreated(getXMLGregorianCalendar(employementEducationCSV.getDateCreated()));
	    			  lastGradeCompletedModel.setDateUpdated(getXMLGregorianCalendar(employementEducationCSV.getDateUpdated()));
	    			  lastGradeCompletedModel.setInformationDate(getXMLGregorianCalendar(employementEducationCSV.getInformationDate()));
	    			  lastGradeCompletedModel.setProjectEntryID(employementEducationCSV.getProjectEntryID());
	    			  lastGradeCompletedModel.setUserID(employementEducationCSV.getUserID());
	    			  lastGradeCompletedModel.setLastGradeCompleted(getByte(employementEducationCSV.getLastGradeCompleted()));
	    			  lastGradeCompletedList.add(lastGradeCompletedModel);
	    		  }
	    		  sources.getSource().getExport().setEmployment(employmentList);
	    		  sources.getSource().getExport().setLastGradeCompleted(lastGradeCompletedList);
	    		  sources.getSource().getExport().setSchoolStatus(schoolStatusList);
	    	  }
	      }
	  }
	  /**
	   * Hydrate Enrollment with in Sources Object from Enrollment CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeEnrollment(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Enrollment> enrollmentReader = new CSVReaderBuilder<Enrollment>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Enrollment>(Enrollment.class, vpp)).build();
	      List<Enrollment> enrollment = enrollmentReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollmentList = new ArrayList<Sources.Source.Export.Enrollment>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement> dateOfEngagementList = new ArrayList<Sources.Source.Export.DateOfEngagement>();
	      List<ResidentialMoveInDate> residentialmoveindateList = new ArrayList<ResidentialMoveInDate>();
	      List<WorstHousingSituation> worsthousingsituationtList = new ArrayList<WorstHousingSituation>();
	      List<PercentAMI> percentAMIList = new ArrayList<PercentAMI>();
	      List<RHYBCPStatus> rhybcpStatusList = new ArrayList<RHYBCPStatus>();
	      List<FormerWardChildWelfare> formerWardChildWelfareList = new ArrayList<FormerWardChildWelfare>();
	      List<FormerWardJuvenileJustice> formerwardjuvenilejusticeList = new ArrayList<Sources.Source.Export.FormerWardJuvenileJustice>();
	      List<PATHStatus> pathStatusList = new ArrayList<PATHStatus>();
	      
	      List<LastPermanentAddress> lastPermanentAddressList = new ArrayList<LastPermanentAddress>();
	      List<ReferralSource> referralSourceList = new ArrayList<Sources.Source.Export.ReferralSource>();
	      List<SexualOrientation> sexualOrientationList = new ArrayList<SexualOrientation>();
	      List<YouthCriticalIssues> youthCriticalIssuesList = new ArrayList<YouthCriticalIssues>();
	      List<Services> servicesList = new ArrayList<Services>();
	      
	      List<CommercialSexualExploitation> commercialSexualExploitationList = new ArrayList<CommercialSexualExploitation>();
	      	      
	      for(Enrollment enroll : enrollment) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollmentModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment();
	    	  //enrollmentModel.setContinuouslyHomelessOneYear(enroll.get);
	    	  enrollmentModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  enrollmentModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  enrollmentModel.setDisablingCondition(getByte(enroll.getDisablingCondition()));
	    	  enrollmentModel.setEntryDate(getXMLGregorianCalendar(enroll.getEntryDate()));
	    	  enrollmentModel.setHouseholdID(enroll.getHouseholdID());
	    	  enrollmentModel.setHousingStatus(getByte(enroll.getHousingStatus()));
	    	  enrollmentModel.setMonthsHomelessPastThreeYears(getByte(enroll.getMonthsHomelessPastThreeYears()));
//	    	  enrollmentModel.setMonthsHomelessThisTime(getByte(enroll.get));
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
//	    	  dateOfEngagementModel.setDateOfEngagementID(enroll.getdat);
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
//	    	  residentialmoveindateModel.setResidentialMoveInDateID(enroll.getresi);
	    	  residentialmoveindateModel.setUserID(enroll.getUserID());
	    	  residentialmoveindateList.add(residentialmoveindateModel);
	    	  
	    	  WorstHousingSituation worsthousingsituationModel = new WorstHousingSituation();
	    	  worsthousingsituationModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  worsthousingsituationModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  worsthousingsituationModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  worsthousingsituationModel.setUserID(enroll.getUserID());
	    	  worsthousingsituationModel.setWorstHousingSituation(getByte(enroll.getWorstHousingSituation()));
//	    	  worsthousingsituationModel.setWorstHousingSituationID(enroll.getwo);
	    	  worsthousingsituationtList.add(worsthousingsituationModel);
	    	  
	    	  PATHStatus pathstatusModel = new PATHStatus();;
	    	  pathstatusModel.setClientEnrolledInPATH(getByte(enroll.getClientEnrolledInPATH()));
	    	  pathstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  pathstatusModel.setDateOfStatus(getXMLGregorianCalendar(enroll.getDateOFPATHStatus()));
	    	  pathstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
//	    	  pathstatusModel.setPathStatusID(enroll.getpat);
	    	  pathstatusModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  pathstatusModel.setReasonNotEnrolled(getByte(enroll.getReasonNotEnrolled()));
	    	  pathstatusModel.setUserID(enroll.getUserID());
	    	  pathStatusList.add(pathstatusModel);

	    	  PercentAMI percentamiModel = new PercentAMI();
	    	  percentamiModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  percentamiModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  percentamiModel.setPercentAMI(getByte(enroll.getPercentAMI()));
//	    	  percentamiModel.setPercentAMIID(enroll.getperc);
	    	  percentamiModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  percentamiModel.setUserID(enroll.getUserID());
	    	  percentAMIList.add(percentamiModel);
	    	  
	    	  RHYBCPStatus rhybcpstatusModel = new RHYBCPStatus();
	    	  rhybcpstatusModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  rhybcpstatusModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  rhybcpstatusModel.setFYSBYouth(getByte(enroll.getFYSBYouth()));
	    	  rhybcpstatusModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  rhybcpstatusModel.setReasonNoServices(getByte(enroll.getReasonNoServices()));
//	    	  rhybcpstatusModel.setRHYBCPStatusID(enroll.getrhy);
//	    	  rhybcpstatusModel.setStatusDate(getXMLGregorianCalendar(enroll.get));
	    	  rhybcpstatusModel.setUserID(enroll.getUserID());
	    	  rhybcpStatusList.add(rhybcpstatusModel);
	    	  
	    	  
	    	  FormerWardChildWelfare formerwardchildwelfareModel = new FormerWardChildWelfare();
	    	  formerwardchildwelfareModel.setChildWelfareMonths(getByte(enroll.getChildWelfareMonths()));
	    	  formerwardchildwelfareModel.setChildWelfareYears(getByte(enroll.getChildWelfareYears()));
//	    	  formerwardchildwelfareModel.setDataCollectionStage(getByte(enroll.getda));
	    	  formerwardchildwelfareModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  formerwardchildwelfareModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  formerwardchildwelfareModel.setFormerWardChildWelfare(getByte(enroll.getFormerWardChildWelfare()));
//	    	  formerwardchildwelfareModel.setFormerWardChildWelfareID(enroll.getFormerWardCh);
//	    	  formerwardchildwelfareModel.setInformationDate(getXMLGregorianCalendar(enroll.getinf));
	    	  formerwardchildwelfareModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  formerwardchildwelfareModel.setUserID(enroll.getUserID());
	    	  formerWardChildWelfareList.add(formerwardchildwelfareModel);
	    	  
	    	  FormerWardJuvenileJustice formerwardjuvenilejusticeModel = new FormerWardJuvenileJustice();
//	    	  formerwardjuvenilejusticeModel.setDataCollectionStage(getByte(enroll.getdata));
	    	  formerwardjuvenilejusticeModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  formerwardjuvenilejusticeModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
//	    	  formerwardjuvenilejusticeModel.setFormerWardJuvenileJustice(getByte(enroll.getFormer));
//	    	  formerwardjuvenilejusticeModel.setFormerWardJuvenileJusticeID(enroll.getfor);
//	    	  formerwardjuvenilejusticeModel.setInformationDate(getXMLGregorianCalendar(enroll.getin));
	    	  formerwardjuvenilejusticeModel.setJuvenileJusticeMonths(getByte(enroll.getJuvenileJusticeMonths()));
	    	  formerwardjuvenilejusticeModel.setJuvenileJusticeYears(getByte(enroll.getJuvenileJusticeYears()));
	    	  formerwardjuvenilejusticeModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  formerwardjuvenilejusticeModel.setUserID(enroll.getUserID());
	    	  formerwardjuvenilejusticeList.add(formerwardjuvenilejusticeModel);
	    	  
	    	  LastPermanentAddress lastpermanentaddressModel = new LastPermanentAddress();
	    	  lastpermanentaddressModel.setAddressDataQuality(getByte(enroll.getAddressDataQuality()));
	    	  lastpermanentaddressModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  lastpermanentaddressModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
//	    	  lastpermanentaddressModel.setLastPermanentAddressID(enroll.getlast);
	    	  lastpermanentaddressModel.setLastPermanentCity(enroll.getLastPermanentCity());
	    	  lastpermanentaddressModel.setLastPermanentState(enroll.getLastPermanentState());
	    	  lastpermanentaddressModel.setLastPermanentStreet(enroll.getLastPermanentStreet());
	    	  if (enroll.getLastPermanentZIP() != null && !"".equals(enroll.getLastPermanentZIP())) {
	    		  lastpermanentaddressModel.setLastPermanentZIP(Integer.parseInt(enroll.getLastPermanentZIP()));				
	    	  }
	    	  lastpermanentaddressModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  lastpermanentaddressModel.setUserID(enroll.getUserID());
	    	  lastPermanentAddressList.add(lastpermanentaddressModel);
	    	  
	    	  ReferralSource referralsourceModel = new ReferralSource();
	    	  referralsourceModel.setCountOutreachReferralApproaches(getByte(enroll.getCountOutreachReferralApproaches()));
//	    	  referralsourceModel.setDataCollectionStage(getByte(enroll.getdataco));
	    	  referralsourceModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  referralsourceModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  referralsourceModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  referralsourceModel.setReferralSource(getByte(enroll.getReferralSource()));
//	    	  referralsourceModel.setReferralSourceID(enroll.getre);
	    	  referralsourceModel.setUserID(enroll.getUserID());
	    	  sources.getSource().getExport().setReferralSource(referralsourceModel);
	    	  
	    	  SexualOrientation sexualorientationModel = new SexualOrientation();
//	    	  sexualorientationModel.setDataCollectionStage(getByte(enroll.getC));
	    	  sexualorientationModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  sexualorientationModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  sexualorientationModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  sexualorientationModel.setSexualOrientation(getByte(enroll.getSexualOrientation()));
//	    	  sexualorientationModel.setSexualOrientationID(enroll.getse);
	    	  sexualorientationModel.setUserID(enroll.getUserID());
	    	  sexualOrientationList.add(sexualorientationModel);
	    	  
	    	  
	    	  YouthCriticalIssues youthcriticalissuesModel = new YouthCriticalIssues();
	    	  youthcriticalissuesModel.setAbuseAndNeglectFam(getByte(enroll.getAbuseAndNeglectFam()));
	    	  youthcriticalissuesModel.setAbuseAndNeglectYouth(getByte(enroll.getAbuseAndNeglectYouth()));
	    	  youthcriticalissuesModel.setActiveMilitaryParent(getByte(enroll.getActiveMilitaryParent()));
	    	  youthcriticalissuesModel.setAlcoholDrugAbuseFam(getByte(enroll.getAlcoholDrugAbuseFam()));
	    	  youthcriticalissuesModel.setAlcoholDrugAbuseYouth(getByte(enroll.getAlcoholDrugAbuseYouth()));
//	    	  youthcriticalissuesModel.setDataCollectionStage(getByte(enroll.getdata));
	    	  youthcriticalissuesModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  youthcriticalissuesModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  youthcriticalissuesModel.setHealthIssuesFam(getByte(enroll.getHealthIssuesFam()));
	    	  youthcriticalissuesModel.setHealthIssuesYouth(getByte(enroll.getHealthIssuesYouth()));
	    	  youthcriticalissuesModel.setHouseholdDynamics(getByte(enroll.getHouseholdDynamics()));
	    	  youthcriticalissuesModel.setHousingIssuesFam(getByte(enroll.getHousingIssuesFam()));
	    	  youthcriticalissuesModel.setHousingIssuesYouth(getByte(enroll.getHousingIssuesYouth()));
	    	  youthcriticalissuesModel.setIncarceratedParent(getByte(enroll.getIncarceratedParent()));
	    	  youthcriticalissuesModel.setIncarceratedParentStatus(getByte(enroll.getIncarceratedParentStatus()));
	    	  youthcriticalissuesModel.setInsufficientIncome(getByte(enroll.getInsufficientIncome()));
	    	  youthcriticalissuesModel.setMentalDisabilityFam(getByte(enroll.getMentalDisabilityFam()));
	    	  youthcriticalissuesModel.setMentalDisabilityYouth(getByte(enroll.getMentalDisabilityYouth()));
	    	  youthcriticalissuesModel.setMentalHealthIssuesFam(getByte(enroll.getMentalHealthIssuesFam()));
	    	  youthcriticalissuesModel.setMentalHealthIssuesYouth(getByte(enroll.getMentalHealthIssuesYouth()));
	    	  youthcriticalissuesModel.setPhysicalDisabilityFam(getByte(enroll.getPhysicalDisabilityFam()));
	    	  youthcriticalissuesModel.setPhysicalDisabilityYouth(getByte(enroll.getPhysicalDisabilityYouth()));
	    	  youthcriticalissuesModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  youthcriticalissuesModel.setSchoolEducationalIssuesFam(getByte(enroll.getSchoolEducationalIssuesFam()));
	    	  youthcriticalissuesModel.setSchoolEducationalIssuesYouth(getByte(enroll.getSchoolEducationalIssuesYouth()));
	    	  youthcriticalissuesModel.setSexualOrientationGenderIDFam(getByte(enroll.getSexualOrientationGenderIDFam()));
	    	  youthcriticalissuesModel.setSexualOrientationGenderIDYouth(getByte(enroll.getSexualOrientationGenderIDYouth()));
	    	  youthcriticalissuesModel.setUnemploymentFam(getByte(enroll.getUnemploymentFam()));
	    	  youthcriticalissuesModel.setUnemploymentYouth(getByte(enroll.getUnemploymentYouth()));
	    	  youthcriticalissuesModel.setUserID(enroll.getUserID());
//	    	  youthcriticalissuesModel.setYouthCriticalIssuesID(enroll.getyou);
	    	  youthCriticalIssuesList.add(youthcriticalissuesModel);
	    	  
	    	  CommercialSexualExploitation commercialSexualExploitationModel = new CommercialSexualExploitation();
	    	  commercialSexualExploitationModel.setAskedOrForcedToExchangeForSex(getByte(enroll.getAskedOrForcedToExchangeForSex()));
//	    	  commercialSexualExploitationModel.setCommercialSexualExploitationID(enroll.getcomm);
	    	  commercialSexualExploitationModel.setCountOfExchangeForSex(getByte(enroll.getCountOfExchangeForSex()));
//	    	  commercialSexualExploitationModel.setDataCollectionStage(getByte(enroll.getdata));
	    	  commercialSexualExploitationModel.setDateCreated(getXMLGregorianCalendar(enroll.getDateCreated()));
	    	  commercialSexualExploitationModel.setDateUpdated(getXMLGregorianCalendar(enroll.getDateUpdated()));
	    	  commercialSexualExploitationModel.setExchangeForSexPastThreeMonths(getByte(enroll.getExchangeForSexPastThreeMonths()));
	    	  commercialSexualExploitationModel.setProjectEntryID(enroll.getProjectEntryID());
	    	  commercialSexualExploitationModel.setUserID(enroll.getUserID());
	    	  commercialSexualExploitationList.add(commercialSexualExploitationModel);
	    	  
	    	  
	    	  /*
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
    	  sources.getSource().getExport().setPercentAMI(percentAMIList);
    	  sources.getSource().getExport().setRHYBCPStatus(rhybcpStatusList);
    	  sources.getSource().getExport().setFormerWardChildWelfare(formerWardChildWelfareList);
    	  sources.getSource().getExport().setFormerWardJuvenileJustice(formerwardjuvenilejusticeList);
    	  sources.getSource().getExport().setLastPermanentAddress(lastPermanentAddressList);
    	  sources.getSource().getExport().setDateOfEngagement(dateOfEngagementList);
    	  sources.getSource().getExport().setSexualOrientation(sexualOrientationList);
    	  sources.getSource().getExport().setYouthCriticalIssues(youthCriticalIssuesList);
    	  sources.getSource().getExport().setResidentialMoveInDate(residentialmoveindateList);
    	  sources.getSource().getExport().setCommercialSexualExploitation(commercialSexualExploitationList);
	  }
	  /**
	   * Hydrate EnrollmentCoc with in Sources Object from EnrollmentCoc CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */ 
	  protected void hydradeEnrollmentCoC(BufferedReader csvFile, Sources sources) throws IOException {
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
	    	  enrollmentCocModel.setEnrollmentCoCID(Integer.parseInt(enrollCoC.getEnrollmentCOCID()));
	    	  enrollmentCocModel.setInformationDate(getXMLGregorianCalendar(enrollCoC.getInformationDate()));
	    	  enrollmentCocModel.setProjectCoCID(Short.valueOf(enrollCoC.getProjectID()));
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
	  protected void hydradeExit(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Exit> exitReader = new CSVReaderBuilder<Exit>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Exit>(Exit.class, vpp)).build();
	      List<Exit> exit = exitReader.readAll(); 
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit> exitList = new ArrayList<Sources.Source.Export.Exit>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition> housingAssessmentDispositionList = new ArrayList<Sources.Source.Export.HousingAssessmentDisposition>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification> familyReunificationList = new ArrayList<Sources.Source.Export.FamilyReunification>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPlansActions> exitPlansActionsList = new ArrayList<Sources.Source.Export.ExitPlansActions>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ConnectionWithSOAR> connectionWithSOARList = new ArrayList<Sources.Source.Export.ConnectionWithSOAR>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment> exitHousingAssessmentList = new ArrayList<Sources.Source.Export.ExitHousingAssessment>();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus> projectCompletionStatusList = new ArrayList<Sources.Source.Export.ProjectCompletionStatus>();
	      
	          
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
	    	  
	    	  FamilyReunification familyReunificationModel = new FamilyReunification();
	    	  familyReunificationModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  familyReunificationModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  familyReunificationModel.setExitID(ext.getExitID());
	    	  familyReunificationModel.setFamilyReunificationAchieved(getByte(ext.getFamilyReunificationAchieved()));
//	    	  familyReunificationModel.setFamilyReunificationID(ext.get);
	    	  familyReunificationModel.setUserID(ext.getUserID());
	    	  sources.getSource().getExport().getFamilyReunification().add(familyReunificationModel);
	    	  
	    	  ExitPlansActions exitPlansActionsModel = new ExitPlansActions();
	    	  exitPlansActionsModel.setAssistanceMainstreamBenefits(getByte(ext.getAssistanceMainstreamBenefits()));
	    	  exitPlansActionsModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitPlansActionsModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  exitPlansActionsModel.setExitCounseling(getByte(ext.getExitCounseling()));
	    	  exitPlansActionsModel.setExitID(ext.getExitID());
//	    	  exitPlansActionsModel.setExitPlansActionsID(ext.get);
	    	  exitPlansActionsModel.setFurtherFollowUpServices(getByte(ext.getFurtherFollowUpServices()));
	    	  exitPlansActionsModel.setOtherAftercarePlanOrAction(getByte(ext.getOtherAftercarePlanOrAction()));
	    	  exitPlansActionsModel.setPermanentHousingPlacement(getByte(ext.getPermanentHousingPlacement()));
	    	  exitPlansActionsModel.setResourcePackage(getByte(ext.getResourcePackage()));
	    	  exitPlansActionsModel.setScheduledFollowUpContacts(getByte(ext.getScheduledFollowupContacts()));
	    	  exitPlansActionsModel.setTemporaryShelterPlacement(getByte(ext.getTemporaryShelterPlacement()));
	    	  exitPlansActionsModel.setUserID(ext.getUserID());
	    	  exitPlansActionsModel.setWrittenAftercarePlan(getByte(ext.getWrittenAftercarePlan()));
	    	  exitPlansActionsList.add(exitPlansActionsModel);
	    	  
	    	  ConnectionWithSOAR connectionWithSOARModel = new ConnectionWithSOAR();
	    	  connectionWithSOARModel.setConnectionWithSOAR(getByte(ext.getConnectionWithSOAR()));
//	    	  connectionWithSOARModel.setConnectionWithSOARID(ext.getConn);
	    	  connectionWithSOARModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  connectionWithSOARModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  connectionWithSOARModel.setExitID(ext.getExitID());
	    	  connectionWithSOARModel.setUserID(ext.getUserID());
	    	  connectionWithSOARList.add(connectionWithSOARModel);
	    	  
	    	  ExitHousingAssessment exitHousingAssessmentModel = new ExitHousingAssessment();
	    	  exitHousingAssessmentModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  exitHousingAssessmentModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
//	    	  exitHousingAssessmentModel.setExitHousingAssessmentID(Short.valueOf(ext.gete));
	    	  exitHousingAssessmentModel.setExitID(ext.getExitID());
	    	  exitHousingAssessmentModel.setHousingAssessment(getByte(ext.getHousingAssessment()));
	    	  exitHousingAssessmentModel.setSubsidyInformation(getByte(ext.getSubsidyInformation()));
	    	  exitHousingAssessmentModel.setUserID(ext.getUserID());
	    	  exitHousingAssessmentList.add(exitHousingAssessmentModel);
	    	  
	    	  
	    	  ProjectCompletionStatus projectCompletionStatusModel = new ProjectCompletionStatus();
	    	  projectCompletionStatusModel.setDateCreated(getXMLGregorianCalendar(ext.getDateCreated()));
	    	  projectCompletionStatusModel.setDateUpdated(getXMLGregorianCalendar(ext.getDateUpdated()));
	    	  projectCompletionStatusModel.setEarlyExitReason(getByte(ext.getEarlyExitReason()));
	    	  projectCompletionStatusModel.setExitID(ext.getExitID());
	    	  projectCompletionStatusModel.setProjectCompletionStatus(getByte(ext.getProjectCompletionStatus()));
//	    	  projectCompletionStatusModel.setProjectCompletionStatusID(ext.getpr);
	    	  projectCompletionStatusModel.setUserID(ext.getUserID());
	    	  projectCompletionStatusList.add(projectCompletionStatusModel);
	    	  
	      }
	      sources.getSource().getExport().setProjectCompletionStatus(projectCompletionStatusList);
	      sources.getSource().getExport().setHousingAssessmentDisposition(housingAssessmentDispositionList);
	      sources.getSource().getExport().setConnectionWithSOAR(connectionWithSOARList);
	      sources.getSource().getExport().setExitPlansActions(exitPlansActionsList);
	      sources.getSource().getExport().setExitHousingAssessment(exitHousingAssessmentList);
	  }
	  
	  /**
	   * Hydrate Export with in Sources Object from Export CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeExport(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Export> exportReader = new CSVReaderBuilder<Export>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Export>(Export.class, vpp)).build();
	      List<Export> export = exportReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export> exportList = new ArrayList<Sources.Source.Export>();
	      for(Export exp : export){
	    	  sources.getSource().getExport().setExportDate(getXMLGregorianCalendar(exp.getExportDate()));
	    	  sources.getSource().getExport().setExportDirective(exp.getExportDirective());
	    	  // Sandeep TODO: Need to change the ExportID to a String verses a byte
	    	 // exportModel.setExportID(getByte(exp.getExportID()));
	    	  ExportPeriod exportPeriod = new ExportPeriod();
	    	  exportPeriod.setEndDate(getXMLGregorianCalendar(exp.getExportEndDate()));
	    	  exportPeriod.setStartDate(getXMLGregorianCalendar(exp.getExportStartDate()));
	    	  sources.getSource().getExport().setExportPeriodType(exp.getExportPeriodType());
	      }
	      
	      /***
	       * Read the first element from the export List and hydrate the exportMode
	       */
	     /* if(export != null && export.size() >0 ) {
	    	  Export exportCsv = export.get(0);
	    	//  exportModel.setExportID(getByte(exportCsv.getExportID()));
	      }*/
//	      sources.getSource().setExport(exportModel);
	  }
	  

	  /**
	   * Hydrate Funder with in Sources Object from Funder CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeFunder(BufferedReader csvFile, Sources sources) throws IOException {
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
	  protected void hydradeHealthAndDV(BufferedReader csvFile, Sources sources) throws IOException {
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
//	    	  healthAndDVModel.setHealthStatusID(healthDV.getHea);
//	    	  healthAndDVModel.setHealthCategory(getByte(healthDV.get));
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
		    	  
			    
	    	  /**
	    	   * 
	    	   * Fields to be compared between pojos in CSV and Export Package.
	    	   * there are few fields missing in HealthStatus.java pojo in export package when compared with HealthAndDV.java under CSV package.
	    	   *
	    	   */
	    	  
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
	  protected void hydradeIncomeBenefits(BufferedReader csvFile, Sources sources) throws IOException {
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
	    		  incomeBenefitsModel.setAlimonyAmount(Float.valueOf(incomeBnfts.getAlimonyAmount()));
	    	  }
	    	  incomeBenefitsModel.setChildSupport(getByte(incomeBnfts.getChildSupport()));
	    	  if(incomeBnfts.getChildSupportAmount()!=null && !"".equals(incomeBnfts.getChildSupportAmount())){
	    		  incomeBenefitsModel.setChildSupportAmount(Float.valueOf(incomeBnfts.getChildSupportAmount()));
	    	  }
	    	  incomeBenefitsModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  incomeBenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  incomeBenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  incomeBenefitsModel.setEarned(getByte(incomeBnfts.getEarned()));
	    	  if(incomeBnfts.getEarnedAmount()!=null && !"".equals(incomeBnfts.getEarnedAmount())){
	    		  incomeBenefitsModel.setEarnedAmount(Float.valueOf(incomeBnfts.getEarnedAmount()));
	    	  }
	    	  incomeBenefitsModel.setGA(getByte(incomeBnfts.getGA()));
	    	  if(incomeBnfts.getGAAmount()!=null && !"".equals(incomeBnfts.getGAAmount())){
	    		  incomeBenefitsModel.setGAAmount(Float.valueOf(incomeBnfts.getGAAmount()));
	    	  }
	    	  incomeBenefitsModel.setIncomeAndSourcesID(incomeBnfts.getIncomeBenefitsID());
	    	  incomeBenefitsModel.setIncomeFromAnySource(getByte(incomeBnfts.getIncomeFromAnySource()));
	    	  incomeBenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
//	    	  incomeBenefitsModel.setOtherSource(getByte(incomeBnfts.getother));
	    	  if(incomeBnfts.getOtherIncomeAmount()!=null && !"".equals(incomeBnfts.getOtherIncomeAmount())){
	    		  incomeBenefitsModel.setOtherSourceAmount(Float.valueOf(incomeBnfts.getOtherIncomeAmount()));
	    	  }
	    	  incomeBenefitsModel.setOtherSourceIdentify(incomeBnfts.getOtherIncomeSourceIdentify());
	    	  incomeBenefitsModel.setPension(getByte(incomeBnfts.getPension()));
	    	  if(incomeBnfts.getPensionAmount()!=null && !"".equals(incomeBnfts.getPensionAmount())){
	    		  incomeBenefitsModel.setPensionAmount(Float.valueOf(incomeBnfts.getPensionAmount()));
	    	  }
	    	  incomeBenefitsModel.setPrivateDisability(getByte(incomeBnfts.getPrivateDisability()));
	    	  if(incomeBnfts.getPrivateDisabilityAmount()!=null && !"".equals(incomeBnfts.getPrivateDisabilityAmount())){
	    		  incomeBenefitsModel.setPrivateDisabilityAmount(Float.valueOf(incomeBnfts.getPrivateDisabilityAmount()));
	    	  }
	    	  incomeBenefitsModel.setProjectEntryID(incomeBnfts.getProjectEntryID());
	    	  incomeBenefitsModel.setSocSecRetirement(getByte(incomeBnfts.getSocSecRetirement()));
	    	  if(incomeBnfts.getSocSecRetirementAmount()!=null && !"".equals(incomeBnfts.getSocSecRetirementAmount())){
	    		  incomeBenefitsModel.setSocSecRetirementAmount(Float.valueOf(incomeBnfts.getSocSecRetirementAmount()));
	    	  }
	    	  incomeBenefitsModel.setSSDI(getByte(incomeBnfts.getSSDI()));
	    	  if(incomeBnfts.getSSDIAmount()!=null && !"".equals(incomeBnfts.getSSDIAmount())){
	    		  incomeBenefitsModel.setSSDIAmount(Float.valueOf(incomeBnfts.getSSDIAmount()));
	    	  }
	    	  incomeBenefitsModel.setSSI(getByte(incomeBnfts.getSSI()));
	    	  if(incomeBnfts.getSSIAmount()!=null && !"".equals(incomeBnfts.getSSIAmount())){
	    		  incomeBenefitsModel.setSSIAmount(Float.valueOf(incomeBnfts.getSSIAmount()));
	    	  }
	    	  incomeBenefitsModel.setTANF(getByte(incomeBnfts.getTANF()));
	    	  if(incomeBnfts.getTANFAmount()!=null && !"".equals(incomeBnfts.getTANFAmount())){
	    		  incomeBenefitsModel.setTANFAmount(Float.valueOf(incomeBnfts.getTANFAmount()));
	    	  }
	    	  if(incomeBnfts.getTotalMonthlyIncome()!=null && !"".equals(incomeBnfts.getTotalMonthlyIncome())){
	    		  incomeBenefitsModel.setTotalMonthlyIncome(Float.valueOf(incomeBnfts.getTotalMonthlyIncome()));
	    	  }
	    	  incomeBenefitsModel.setUnemployment(getByte(incomeBnfts.getUnemployment()));
	    	  if(incomeBnfts.getUnemploymentAmount()!=null && !"".equals(incomeBnfts.getUnemploymentAmount())){
	    		  incomeBenefitsModel.setUnemploymentAmount(Float.valueOf(incomeBnfts.getUnemploymentAmount()));
	    	  }
	    	  incomeBenefitsModel.setUserID(incomeBnfts.getUserID());
	    	  incomeBenefitsModel.setVADisabilityNonService(getByte(incomeBnfts.getVADisabilityNonService()));
	    	  if(incomeBnfts.getVADisabilityNonServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityNonServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityNonServiceAmount(Float.valueOf(incomeBnfts.getVADisabilityNonServiceAmount()));
	    	  }
	    	  incomeBenefitsModel.setVADisabilityService(getByte(incomeBnfts.getVADisabilityService()));
	    	  if(incomeBnfts.getVADisabilityServiceAmount()!=null && !"".equals(incomeBnfts.getVADisabilityServiceAmount())){
	    		  incomeBenefitsModel.setVADisabilityServiceAmount(Float.valueOf(incomeBnfts.getVADisabilityServiceAmount()));
	    	  }
	    	  
	    	  incomeBenefitsModel.setWorkersComp(getByte(incomeBnfts.getWorkersComp()));
	    	  if(incomeBnfts.getWorkersCompAmount()!=null && !"".equals(incomeBnfts.getWorkersCompAmount())){
	    		  incomeBenefitsModel.setWorkersCompAmount(Float.valueOf(incomeBnfts.getWorkersCompAmount()));
	    	  }
	    	  
	    	  NonCashBenefits noncashbenefitsModel = new NonCashBenefits();
	    	  noncashbenefitsModel.setBenefitsFromAnySource(getByte(incomeBnfts.getBenefitsFromAnySource()));
	    	  noncashbenefitsModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  noncashbenefitsModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  noncashbenefitsModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  noncashbenefitsModel.setInformationDate(getXMLGregorianCalendar(incomeBnfts.getInformationDate()));
//	    	  noncashbenefitsModel.setNonCashBenefitsID(incomeBnfts.getNon);
	    	  noncashbenefitsModel.setOtherSource(getByte(incomeBnfts.getOtherBenefitsSource()));
	    	  nonCashBenefitsList.add(noncashbenefitsModel);
	    	  
	    	  HealthInsurance healthinsuranceModel = new HealthInsurance();
	    	  healthinsuranceModel.setCOBRA(getByte(incomeBnfts.getCOBRA()));
	    	  healthinsuranceModel.setDataCollectionStage(getByte(incomeBnfts.getDataCollectionStage()));
	    	  healthinsuranceModel.setDateCreated(getXMLGregorianCalendar(incomeBnfts.getDateCreated()));
	    	  healthinsuranceModel.setDateDeleted(getXMLGregorianCalendar(incomeBnfts.getDateDeleted()));
	    	  healthinsuranceModel.setDateUpdated(getXMLGregorianCalendar(incomeBnfts.getDateUpdated()));
	    	  healthinsuranceModel.setEmployerProvided(getByte(incomeBnfts.getEmployerProvided()));
//	    	  healthinsuranceModel.setHealthInsuranceID(incomeBnfts.getH);
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
//	    	  medicalassistanceModel.setMedicalAssistanceID(enroll.getmedic);
	    	  medicalassistanceModel.setNoADAPReason(getByte(incomeBnfts.getNoADAPReason()));
	    	  medicalassistanceModel.setNoHIVAIDSAssistanceReason(getByte(incomeBnfts.getNoHIVAIDSAssistanceReason()));
	    	  medicalassistanceModel.setProjectEntryID(incomeBnfts.getProjectEntryID());
	    	  medicalassistanceModel.setUserID(incomeBnfts.getUserID());
	    	  medicalAssistanceList.add(medicalassistanceModel);
	    	  
	    	  /**
	    	   * 
	    	   * Fields to be compared between pojos in CSV and Export Package.
	    	   * there are few fields missing in Incomebenefits.java pojo in export package.
	    	   *
	    	   */
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
	  protected void hydradeInventory(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Inventory> inventoryReader = new CSVReaderBuilder<Inventory>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Inventory>(Inventory.class, vpp)).build();
	      List<Inventory> inventory = inventoryReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory> inventoryList = new ArrayList<Sources.Source.Export.Inventory>();
	      for(Inventory invntry : inventory) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory inventoryModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory();
	    	  inventoryModel.setAvailabilty(getByte(invntry.getAvailability()));
	    	  inventoryModel.setBedType(getByte(invntry.getBedType()));
	    	  inventoryModel.setDateCreated(getXMLGregorianCalendar(invntry.getDateCreated()));
	    	  inventoryModel.setDateUpdated(getXMLGregorianCalendar(invntry.getDateUpdated()));
	    	  inventoryModel.setHMISParticipatingBeds(Integer.parseInt(invntry.getHMISParticipatingBeds()));
	    	  inventoryModel.setHouseholdType(getByte(invntry.getHouseholdType()));
	    	  inventoryModel.setInformationDate(getXMLGregorianCalendar(invntry.getInformationDate()));
	    	  inventoryModel.setInventoryEndDate(getXMLGregorianCalendar(invntry.getInventoryEndDate()));
	    	  inventoryModel.setInventoryID(invntry.getInventoryID());
	    	  inventoryModel.setInventoryStartDate(getXMLGregorianCalendar(invntry.getInventoryStartDate()));
	    	  if(invntry.getProjectID() !=null && !"".equals(invntry.getProjectID()))
	    		  inventoryModel.setProjectCoCID(Short.valueOf(invntry.getProjectID()));
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
	    	  /**
	    	   *  Writing comments on missing fields here.
	    	   *  Export_ID, Date_Deleted,CoCCode --> these fields are available in Inventory.java POJO which is created using CSV File but not availabel
	    	   *  in Inventory.java POJO which is under Export package.
	    	   *  
	    	   */
	    	  
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
	  protected void hydradeOrganization(BufferedReader csvFile, Sources sources) throws IOException {
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
	    	//  organizationModel.setOrganizationID(getByte(orgtn.getOrganizationID()));
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
	  protected void hydradeProject(BufferedReader csvFile, Sources sources) throws IOException {
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
	   * Hydrate ProjectCOC with in Sources Object from ProjectCOC CSV Pojos.
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeProjectCOC(BufferedReader csvFile, Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<ProjectCOC> projectCOCReader = new CSVReaderBuilder<ProjectCOC>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<ProjectCOC>(ProjectCOC.class, vpp)).build();
	      List<ProjectCOC> projectCOC = projectCOCReader.readAll();
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC> projectCoCList = new ArrayList<Sources.Source.Export.ProjectCoC>();
	      for(ProjectCOC prjtCoC : projectCOC) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC projectCoCModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC();
	    	 projectCoCModel.setCoCCode(prjtCoC.getCoCCode());
	    	 projectCoCModel.setDateCreated(getXMLGregorianCalendar(prjtCoC.getDateCreated()));
	    	 projectCoCModel.setDateUpdated(getXMLGregorianCalendar(prjtCoC.getDateUpdated()));
	    	 if(prjtCoC.getProjectCocID()!=null && !"".equals(prjtCoC.getProjectCocID())){
	    		 projectCoCModel.setProjectCoCID(Short.valueOf(prjtCoC.getProjectCocID()));
	    	 }
	    	 projectCoCModel.setProjectID(prjtCoC.getProjectID());
	    	 projectCoCModel.setUserID(prjtCoC.getUserID());
	    	  
	    	  projectCoCList.add(projectCoCModel);
	    	  sources.getSource().getExport().getProjectCoC().add(projectCoCModel);
	      }
	      
	  }
	  
	  /**
	   * Hydrate Services with in Sources Object from Services CSV Pojos.
	   *
	   * @param csvFile
	   * @param sources
	   * @throws IOException
	   */
	  protected void hydradeServices(BufferedReader csvFile, Sources sources) throws IOException {
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
	    	  servicesModel.setRecordType(getByte(srvcs.getRecordType()));
	    	  servicesModel.setReferralOutcome(getByte(srvcs.getReferralOutcome()));
	    	  servicesModel.setServicesID(srvcs.getServicesID());
	    	  servicesModel.setSubTypeProvided(getByte(srvcs.getSubTypeProvided()));
	    	  servicesModel.setTypeProvided(getByte(srvcs.getTypeProvided()));
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
	  protected void hydradeSite(BufferedReader csvFile, Sources sources) throws IOException {
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
	    	  
	    	  if(ste.getProjectID()!=null && !"".equals(ste.getProjectID())){
	    		  siteModel.setProjectCoCID(Short.valueOf(ste.getProjectID()));
	    	  }
	    	  
	    	  if(ste.getSiteID()!=null && !"".equals(ste.getSiteID())){
	    		  siteModel.setSiteID(Short.valueOf(ste.getSiteID()));
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
