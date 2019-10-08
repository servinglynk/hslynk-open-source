package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("assessments")
public class Assessments extends PaginatedModel {

	@JsonProperty("assessments")
	List<Assessment> Assessments = new ArrayList<Assessment>();

	public List<Assessment> getAssessments() {
		return Assessments;
	}

	public void setAssessments(List<Assessment> Assessments) {
		this.Assessments = Assessments;
	}
	
	public void addAssessment(Assessment Assessment){
		this.Assessments.add(Assessment);
	}
	
}
