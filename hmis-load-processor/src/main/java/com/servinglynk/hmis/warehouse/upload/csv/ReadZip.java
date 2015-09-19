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
import com.servinglynk.hmis.warehouse.csv.EmployementEducation;
import com.servinglynk.hmis.warehouse.csv.Enrollment;
import com.servinglynk.hmis.warehouse.csv.EnrollmentCoC;
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
            		hydradeEmployementEducation(csvFile);
            		break;
            	case "Enrollment.csv":
            		hydradeEnrollment(csvFile);
            		break;
            	case "EnrollmentCOC.csv":
            		hydradeEnrollmentCoC(csvFile);
            		break;
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
   		   //sources.getSource().getExport().setClient(clientList);t);
    	  }
    	  }
      
  }
	  protected static byte getByte(String value) {
		  if(value !=null && !"".equals(value)) {
			  return Byte.valueOf(value);
		  }
		  return 0;
	  }
	  
	  protected static XMLGregorianCalendar getXMLGregorianCalendar(String date) {
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

  protected static void hydradeDisabilities(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<Disabilities> personReader = new CSVReaderBuilder<Disabilities>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<Disabilities>(Disabilities.class, vpp)).build();
      List<Disabilities> persons = personReader.readAll(); 
      System.out.println(persons.toString());
  }
  
  protected static void hydradeEmployementEducation(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<EmployementEducation> employementReader = new CSVReaderBuilder<EmployementEducation>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<EmployementEducation>(EmployementEducation.class, vpp)).build();
      List<EmployementEducation> employementEdu = employementReader.readAll(); 
      System.out.println(employementEdu.toString());
  }
  
  protected static void hydradeEnrollment(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<Enrollment> enrollmentReader = new CSVReaderBuilder<Enrollment>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<Enrollment>(Enrollment.class, vpp)).build();
      List<Enrollment> enrollment = enrollmentReader.readAll(); 
      System.out.println(enrollment.toString());
  }
  
  protected static void hydradeEnrollmentCoC(BufferedReader csvFile) throws IOException {
	  CSVStrategy strategy = new CSVStrategy(',', '"', '#', true, true);
      ValueProcessorProvider vpp = new ValueProcessorProvider();
      CSVReader<EnrollmentCoC> enrollmentCocReader = new CSVReaderBuilder<EnrollmentCoC>(csvFile).strategy(strategy).entryParser(
                      new AnnotationEntryParser<EnrollmentCoC>(EnrollmentCoC.class, vpp)).build();
      List<EnrollmentCoC> enrollmentCoc = enrollmentCocReader.readAll(); 
      System.out.println(enrollmentCoc.toString());
  }
  
  
}