package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollments")
public class EnrollmentsModel {

	@JsonProperty("enrollments")
	private List<EnrollmentModel> enrollments = new ArrayList<EnrollmentModel>();

	public List<EnrollmentModel> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<EnrollmentModel> enrollments) {
		this.enrollments = enrollments;
	}
	
}