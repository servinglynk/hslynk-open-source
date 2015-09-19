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
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

@Component
public class BulkUploadHelper {
	
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
	
	protected String getFileExtension(String fileName) {
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
	        return fileName.substring(fileName.lastIndexOf(".")+1);
	        else return "";
	}
	
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
	public Sources getSourcesForZipFile(BulkUpload upload) {
		Sources sources = new Sources();
		try {
		      //ZipFile zf = new ZipFile("C:/HMIS/servinglynk-hmis/hmis-load-processor/src/main/java/com/servinglynk/hmis/warehouse/upload/csv/CSV_files.zip");
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
		            		
		            	case "Enrollment.csv":
		            	case "EnrollmentCOC.csv":
		            	case "Exit.csv":
		            	case "Export.csv":
		            	case "Funder.csv":
		            	case "HealthAndDV.csv":
		            	case "IncomeBenefits.csv":
		            	case "Inventory.csv":
		            	case "Organization.csv":
		            	case  "Project.csv" :
		            	case "ProjectCOC.csv":
		            	case "Services.csv":
		            	case "Site.csv":
		            		
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
	  
	  protected void hydradeDisabilities(BufferedReader csvFile,Sources sources) throws IOException {
		  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
	      ValueProcessorProvider vpp = new ValueProcessorProvider();
	      CSVReader<Disabilities> csvReader = new CSVReaderBuilder<Disabilities>(csvFile).strategy(strategy).entryParser(
	                      new AnnotationEntryParser<Disabilities>(Disabilities.class, vpp)).build();
	      List<Disabilities> distbilities = csvReader.readAll(); 
	      //System.out.println(persons.toString());
	  }
	  protected byte getByte(String value) {
		  if(value !=null && !"".equals(value)) {
			  return Byte.valueOf(value);
		  }
		  return 0;
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
