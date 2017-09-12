package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("enrollments")
public class Enrollments extends PaginatedModel {

	@JsonProperty("enrollments")
	List<Enrollment> enrollments = new ArrayList<Enrollment>();

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollment(Enrollment enrollment){
		this.enrollments.add(enrollment);
	}
	
}
