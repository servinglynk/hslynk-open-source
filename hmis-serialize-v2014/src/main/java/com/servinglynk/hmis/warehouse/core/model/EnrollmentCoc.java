package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollmentcoc")
public class EnrollmentCoc extends ClientModel {
	
	private String cocCode;
	private UUID enrollmentId;
	private UUID enrollmentCocId;

	public EnrollmentCoc(){
		
	}
	
	public EnrollmentCoc(UUID enrollmentCocId){
		this.enrollmentCocId = enrollmentCocId;
	}

	public String getCocCode() {
		return cocCode;
	}

	public void setCocCode(String cocCode) {
		this.cocCode = cocCode;
	}

	public UUID getEnrollmentCocId() {
		return enrollmentCocId;
	}

	public void setEnrollmentCocId(UUID enrollmentCocId) {
		this.enrollmentCocId = enrollmentCocId;
	}

	public UUID getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

}
