package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.AssessmentQuestion;
import com.servinglynk.hmis.warehouse.core.model.AssessmentQuestions;

public interface AssessmentQuestionService {
	
	   AssessmentQuestion createAssessmentQuestion(AssessmentQuestion AssessmentQuestion,String caller);
	   AssessmentQuestion updateAssessmentQuestion(AssessmentQuestion AssessmentQuestion,String caller);
	   AssessmentQuestion deleteAssessmentQuestion(UUID AssessmentQuestionId,String caller);
	   AssessmentQuestion getAssessmentQuestionById(UUID AssessmentQuestionId);
	   AssessmentQuestions getAllEnrollmentAssessmentQuestions(UUID enrollmentId,Integer startIndex, Integer maxItems);

}
