package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.Assessment;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class AssessmentCsvConverter extends BaseCsvConverter {

	public Assessment entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Assessment entity) {
		Assessment model = new Assessment();
	       model.setAssessmentDate(getDate(entity.getAssessmentDate()));
	       if(entity.getAssessmentLevel() != null)
	    	   model.setAssessmentLevel(entity.getAssessmentLevel().getValue());
	       if(model.getAssessmentLocation() != null) 
	    	   model.setAssessmentLocation(model.getAssessmentLocation());
	       if(model.getAssessmentType() != null)
	    	   model.setAssessmentType(entity.getAssessmentType().getValue());
	       if(model.getPrioritizationStatus() != null)
	    	   model.setPrioritizationStatus(entity.getPrioritizationStatus().getValue());
	       model.setAssessmentID(getId(entity.getId()));
	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if( enrollmentid!= null) {
	    	   model.setProjectEntryID(getId(enrollmentid.getId()));
	    	   if(enrollmentid.getClient() != null) {
	    		   model.setPersonalID(getId(enrollmentid.getClient().getId()));
	    	   }
	       }
	       
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		return model;
	}
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Assessment> assessments,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Assessment());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(assessments)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Assessment assessment : assessments) {
				baseCSVs.add(entityToCsv(assessment));
			}
		}
			CsvFileWriter.writeToCsv("Assessment.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
