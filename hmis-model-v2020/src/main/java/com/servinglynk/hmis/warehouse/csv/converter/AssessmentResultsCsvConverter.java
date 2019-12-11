package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.AssessmentResults;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.model.v2020.Assessment;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class AssessmentResultsCsvConverter extends BaseCsvConverter {

	public AssessmentResults entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults entity) {
		AssessmentResults model = new AssessmentResults();
		   model.setAssessmentResult(entity.getAssessmentResult());
	       model.setAssessmentResultType(entity.getAssessmentResultType());
	       model.setAssessmentResultID(getId(entity.getId()));
	       Assessment assessment = entity.getAssessment();
	       if(assessment != null)
	    	   model.setAssessmentID(getId(assessment.getId()));
	       
	       Enrollment enrollmentid = entity.getEnrollmentid();
	       if( enrollmentid!= null) {
	    	   model.setEnrollmentID(getId(enrollmentid.getId()));
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
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults> AssessmentResultss,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new AssessmentResults());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(AssessmentResultss)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.AssessmentResults AssessmentResults : AssessmentResultss) {
				baseCSVs.add(entityToCsv(AssessmentResults));
			}
		}
			CsvFileWriter.writeToCsv("AssessmentResults.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
