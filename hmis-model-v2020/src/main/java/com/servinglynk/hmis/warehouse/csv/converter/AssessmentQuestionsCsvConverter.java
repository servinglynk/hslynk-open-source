package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.AssessmentQuestions;
import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.model.v2020.Assessment;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;

@Component
public class AssessmentQuestionsCsvConverter extends BaseCsvConverter {

	public AssessmentQuestions entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions entity) {
		AssessmentQuestions model = new AssessmentQuestions();

	       model.setAssessmentQuestionID(getId(entity.getId()));
	       
	       model.setAssessmentAnswer(entity.getAssessmentAnswer());
	       model.setAssessmentQuestion(entity.getAssessmentQuestion());
	       model.setAssessmentQuestionGroup(entity.getAssessmentQuestionGroup());
	       if(entity.getAssessmentQuestionOrder()  != null)
	    	   model.setAssessmentQuestionOrder(String.valueOf(entity.getAssessmentQuestionOrder()));
	       
	       Assessment assessment = entity.getAssessment();
	       if(assessment !=null) {
	    	   model.setAssessmentID(getId(entity.getAssessment().getId()));
	       }
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
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions> assessmentQuestions,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new AssessmentQuestions());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(assessmentQuestions)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.AssessmentQuestions assessmentQuestion : assessmentQuestions) {
				baseCSVs.add(entityToCsv(assessmentQuestion));
			}
		}
			CsvFileWriter.writeToCsv("AssessmentQuestions.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
