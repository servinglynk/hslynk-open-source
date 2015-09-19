package com.servinglynk.hmis.warehouse.upload.csv;

import java.io.BufferedReader;
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

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.AnnotationEntryParser;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.servinglynk.hmis.warehouse.csv.Client;
import com.servinglynk.hmis.warehouse.csv.Disabilities;
import com.servinglynk.hmis.warehouse.domain.Sources;

public class ReadZip {
  public static void main(String args[]) {
    try {
      ZipFile zf = new ZipFile("C:/HMIS/servinglynk-hmis/hmis-load-processor/src/main/java/com/servinglynk/hmis/warehouse/upload/csv/CSV_files.zip");
      Enumeration entries = zf.entries();
      while (entries.hasMoreElements()) {
        ZipEntry ze = (ZipEntry) entries.nextElement();
        System.out.println("Read " + ze.getName() + "?");
            BufferedReader csvFile = new BufferedReader(
                new InputStreamReader(zf.getInputStream(ze)));
            
            switch(ze.getName()) {
            	case "Client.csv":
            		hydradeClient(csvFile);
            		break;
            	case "Disabilities.csv":
            		hydradeDisabilities(csvFile);
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
  }
  
  protected static void hydradeClient(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<Client> personReader = new CSVReaderBuilder<Client>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<Client>(Client.class, vpp)).build();
      List<Client> clients = personReader.readAll(); 
      System.out.println(clients.toString());
      List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client> clientList = new ArrayList<Sources.Source.Export.Client>();
      if(clients !=null && clients.size() > 0) {
    	  for(Client client : clients) {
    		   com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client clientModel = new com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client();
    		   clientModel.setEthnicity(client.getEthnicity().getBytes()[0]);
    		   clientModel.setDOB(getXMLGregorianCalendar(client.getDob()));
    		   clientModel.setDOBDataQuality(Byte.valueOf(client.getDobDataQuality()));
    		   clientModel.setFirstName(client.getFirstName());
    		   clientModel.setLastName(client.getLastName());
    		   clientModel.setMiddleName(client.getMiddleName());
    		   clientModel.setGender(Byte.valueOf(client.getGender()));
    		   clientModel.setNameDataQuality(Byte.valueOf(client.getNameDataQuality()));
    		   
    		   
    		   clientList.add(clientModel);
    		 //  sources.getSource().getExport().setClient(clientList);
    	  }
    	  }
      
  }
  protected static XMLGregorianCalendar getXMLGregorianCalendar(String date) {
	  Date dob=null;
	  DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	  try {
		  dob=df.parse(date);  
	  }catch(ParseException ex) {
		  ex.printStackTrace();
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
  protected static void hydradeDisabilities(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<Disabilities> personReader = new CSVReaderBuilder<Disabilities>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<Disabilities>(Disabilities.class, vpp)).build();
      List<Disabilities> persons = personReader.readAll(); 
      System.out.println(persons.toString());
  }
}