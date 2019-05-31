package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollments")
public class GlobalEnrollmentsMap {
	
	@Valid
	@JsonProperty("enrollments")
	private List<GlobalEnrollmentMap> globalEnrollmentMaps = new ArrayList<GlobalEnrollmentMap>();

	public List<GlobalEnrollmentMap> getGlobalEnrollmentMaps() {
		return globalEnrollmentMaps;
	}

	public void setGlobalEnrollmentMaps(List<GlobalEnrollmentMap> globalEnrollmentMaps) {
		this.globalEnrollmentMaps = globalEnrollmentMaps;
	}
	
	public void addGlobalEnrollmentMap(GlobalEnrollmentMap enrollmentMap){
		this.globalEnrollmentMaps.add(enrollmentMap);
	}

}
