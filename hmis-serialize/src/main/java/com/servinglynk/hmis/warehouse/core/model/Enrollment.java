package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class Enrollment extends ClientModel {
	
	
	
	private UUID enrollmentId;

	public Enrollment(){
		
	}
	
	public Enrollment(UUID enrollmentId){
		this.enrollmentId = enrollmentId;
	}
	
	
	public UUID getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
	
	
	

}
