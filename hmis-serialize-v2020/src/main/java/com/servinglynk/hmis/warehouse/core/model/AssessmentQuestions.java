package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("assessmentQuestions")
public class AssessmentQuestions extends PaginatedModel {

	@JsonProperty("assessmentQuestions")
	List<AssessmentQuestion> assessmentQuestions = new ArrayList<AssessmentQuestion>();

	public List<AssessmentQuestion> getassessmentQuestions() {
		return assessmentQuestions;
	}

	public void setassessmentQuestions(List<AssessmentQuestion> assessmentQuestions) {
		this.assessmentQuestions = assessmentQuestions;
	}
	
	public void addAssessment(AssessmentQuestion Assessment){
		this.assessmentQuestions.add(Assessment);
	}
	
}
