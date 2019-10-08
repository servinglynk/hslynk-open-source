package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("assessmentResults")
public class AssessmentResults extends PaginatedModel {

	@JsonProperty("assessmentResults")
	List<AssessmentResult> assessmentResults = new ArrayList<AssessmentResult>();

	public List<AssessmentResult> getAssessmentResults() {
		return assessmentResults;
	}

	public void setAssessmentResults(List<AssessmentResult> assessmentResults) {
		this.assessmentResults = assessmentResults;
	}
	
	public void addAssessmentResult(AssessmentResult assessment){
		this.assessmentResults.add(assessment);
	}
	
}
