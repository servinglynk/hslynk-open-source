package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Assessment;
import com.servinglynk.hmis.warehouse.core.model.Assessments;

public interface AssessmentService {
	
	   Assessment createAssessment(Assessment assessment,UUID enrollmentId,String caller);
	   Assessment updateAssessment(Assessment assessment,UUID enrollmentId,String caller);
	   Assessment deleteAssessment(UUID assessmentId,String caller);
	   Assessment getAssessmentById(UUID assessmentId);
	   Assessments getAllEnrollmentAssessments(UUID enrollmentId,Integer startIndex, Integer maxItems);

}
