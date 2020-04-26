package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.AssessmentResult;
import com.servinglynk.hmis.warehouse.core.model.AssessmentResults;

public interface AssessmentResultService {
	
	   AssessmentResult createAssessmentResult(AssessmentResult AssessmentResult,String caller);
	   AssessmentResult updateAssessmentResult(AssessmentResult AssessmentResult,String caller);
	   AssessmentResult deleteAssessmentResult(UUID AssessmentResultId,String caller);
	   AssessmentResult getAssessmentResultById(UUID AssessmentResultId);
	   AssessmentResults getAllEnrollmentAssessmentResults(UUID enrollmentId,Integer startIndex, Integer maxItems);

}
