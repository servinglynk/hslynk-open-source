package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("enrollmentcocs")
public class EnrollmentCocs extends PaginatedModel {

	@JsonProperty("enrollmentcocs")
	List<EnrollmentCoc> enrollmentcocs = new ArrayList<EnrollmentCoc>();

	public List<EnrollmentCoc> getEnrollmentCocs() {
		return enrollmentcocs;
	}

	public void setEnrollmentCocs(List<EnrollmentCoc> enrollmentcocs) {
		this.enrollmentcocs = enrollmentcocs;
	}
	
	public void addEnrollmentCoc(EnrollmentCoc enrollmentcoc){
		this.enrollmentcocs.add(enrollmentcoc);
	}
	
}
