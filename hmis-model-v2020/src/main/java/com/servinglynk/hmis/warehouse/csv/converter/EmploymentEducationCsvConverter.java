package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.EmployementEducation;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Education;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class EmploymentEducationCsvConverter extends BaseCsvConverter {

	public EmployementEducation entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Employment entity) {
		 EmployementEducation model = new EmployementEducation();
		 model.setEmploymentEducationID(getId(entity.getId()));
	       if(entity.getInformationDate()!=null)
	       model.setInformationDate(getDate(entity.getInformationDate()));
	       if(entity.getDataCollectionStage() !=null)
	    	   model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

	       	   if(entity.getEmployed()!=null)
	       		   model.setEmployed(entity.getEmployed().getValue());
	       	   if(entity.getEmploymentType()!=null)
	       		   model.setEmploymentType(entity.getEmploymentType().getValue());
	           if(entity.getNotEmployedReason()!=null)
	        	   model.setNotEmployedReason(entity.getNotEmployedReason().getValue());
	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if(enrollmentid != null) {
	    	   model.setEnrollmentyID(getId(enrollmentid.getId()));
	    	   Client client = enrollmentid.getClient();
	    	   if(client != null)
	    		   model.setPersonalID(getId(client.getId()));
	       }
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public EmployementEducation educationToCsv(com.servinglynk.hmis.warehouse.model.v2020.Education entity) {
		 EmployementEducation model = new EmployementEducation();
		 model.setEmploymentEducationID(getId(entity.getId()));
	       if(entity.getInformationDate()!=null)
	       model.setInformationDate(getDate(entity.getInformationDate()));
	       if(entity.getDataCollectionStage() !=null)
	    	   model.setDataCollectionStage(entity.getDataCollectionStage().getValue());

	       if(entity.getLastgradecompleted()!=null)
	       model.setLastGradeCompleted(entity.getLastgradecompleted().getValue());
	       if(entity.getSchoolStatus()!=null)
	       model.setSchoolStatus(entity.getSchoolStatus().getValue());
	      
	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if(enrollmentid != null) {
	    	   model.setEnrollmentyID(getId(enrollmentid.getId()));
	    	   Client client = enrollmentid.getClient();
	    	   if(client != null)
	    		   model.setPersonalID(getId(client.getId()));
	       }
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment,boolean fillHeaders) {
		Set<com.servinglynk.hmis.warehouse.model.v2020.Employment> employments  = enrollment.getEmployments();
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new EmployementEducation());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(employments)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Employment employment : employments) {
				baseCSVs.add(entityToCsv(employment));
			}
		}
		Set<Education> educations = enrollment.getEducations();
		if(CollectionUtils.isNotEmpty(educations)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Education education : educations) {
				baseCSVs.add(educationToCsv(education));
			}
		}
			CsvFileWriter.writeToCsv("EmployementEducation.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
