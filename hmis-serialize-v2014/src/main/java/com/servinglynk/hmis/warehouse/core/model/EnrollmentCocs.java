package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("enrollmentCocs")
public class EnrollmentCocs extends PaginatedModel {

	@JsonProperty("enrollmentCocs")
	List<EnrollmentCoc> enrollmentCocs = new ArrayList<EnrollmentCoc>();

	public List<EnrollmentCoc> getEnrollmentCocs() {
		return enrollmentCocs;
	}

	public void setEnrollmentCocs(List<EnrollmentCoc> enrollmentCocs) {
		this.enrollmentCocs = enrollmentCocs;
	}
	
	public void addEnrollmentCoc(EnrollmentCoc enrollmentcoc){
		this.enrollmentCocs.add(enrollmentcoc);
	}
	
}
