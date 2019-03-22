package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("globalEnrollments")
public class GenericEnrollments extends PaginatedModel{
	
	@JsonProperty("globalEnrollments")
	private List<GenericEnrollment> genericEnrollments = new ArrayList<GenericEnrollment>();
	
	public List<GenericEnrollment> getGenericEnrollments() {
		return genericEnrollments;
	}

	public void setGenericEnrollments(List<GenericEnrollment> genericEnrollments) {
		this.genericEnrollments = genericEnrollments;
	}

	public void add(GenericEnrollment genericEnrollments) {
		this.genericEnrollments.add(genericEnrollments);
	}

}
