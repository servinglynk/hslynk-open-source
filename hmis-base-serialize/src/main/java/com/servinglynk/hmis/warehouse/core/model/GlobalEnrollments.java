package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;


@JsonRootName("globalEnrollments")
public class GlobalEnrollments extends PaginatedModel {

	@JsonProperty("globalEnrollments")
	private List<GlobalEnrollment> globalEnrollments = new ArrayList<GlobalEnrollment>();

	public List<GlobalEnrollment> getGlobalEnrollments() {
		return globalEnrollments;
	}

	public void setGlobalEnrollments(List<GlobalEnrollment> globalEnrollments) {
		this.globalEnrollments = globalEnrollments;
	}
	
	public void add(GlobalEnrollment globalEnrollment) {
		this.globalEnrollments.add(globalEnrollment);
	}
}