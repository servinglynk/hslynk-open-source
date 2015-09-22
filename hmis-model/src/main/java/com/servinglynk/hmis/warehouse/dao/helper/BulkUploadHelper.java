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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory.BedInventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SchoolStatus;
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
			JAXBContext jaxbContext = JAXBContext.newInstance(Sources.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Sources sources = (Sources) jaxbUnmarshaller.unmarshal(file);
			return sources;
			}
			 catch (JAXBException e) {
					e.printStackTrace();
				}
		return null;
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
		    } catch (IOException e) {
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
	    		   sources.getSource().getExport().setClient(clientList);
	    	  }
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
	   * Hydrate Disabilities with in Sources Object from Disabilities CSV Pojos.
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
	      for(Enrollment enroll : enrollment) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollmentModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment();
	    	  //enrollmentModel.setContinuouslyHomelessOneYear(enroll.get);
	    	  sources.getSource().getExport().getEnrollment().add(enrollmentModel);
	      }
	      
	      
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
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC> enrollmentCocList = new ArrayList<Sources.Source.Export.EnrollmentCoC>();
	      for(EnrollmentCoC enrollCoC : enrollmentCoc) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC enrollmentCocModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC();
	    	  enrollmentCocList.add(enrollmentCocModel);
	      }
//	      sources.getSource().getExport().set
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
	      for(Exit ext : exit) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit exitModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit();
	    	  exitList.add(exitModel);
	    	  sources.getSource().getExport().getExit().add(exitModel);
	      }
	      
	  
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
	      com.servinglynk.hmis.warehouse.domain.Sources.Source.Export exportModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export();
	      /***
	       * Read the first element from the export List and hydrate the exportMode
	       */
	      if(export != null && export.size() >0 ) {
	    	  Export exportCsv = export.get(0);
	    	  exportModel.setExportID(getByte(exportCsv.getExportID()));
	      }
	      sources.getSource().setExport(exportModel);
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
	      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus> healthAndDVList = new ArrayList<Sources.Source.Export.HealthStatus>();
	      for(HealthAndDV healthDV : healthAndDV) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus healthAndDVModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus();
	    	  healthAndDVList.add(healthAndDVModel);
	      }
	      sources.getSource().getExport().setHealthStatus(healthAndDVList);
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
	      for(IncomeBenefits incomeBnfts : incomeBenefits) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources incomeBenefitsModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources();
	    	  incomeBenefitsList.add(incomeBenefitsModel);
	      }
	      sources.getSource().getExport().setIncomeAndSources(incomeBenefitsList);
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
	      for(Project prjt : project) {
	    	  com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project projectModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project();
	    	  projectList.add(projectModel);
	    	  sources.getSource().getExport().getProject().add(projectModel);
	      }
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
	    	  siteList.add(siteModel);
	      }
	      sources.getSource().getExport().setSite(siteList);
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
}
