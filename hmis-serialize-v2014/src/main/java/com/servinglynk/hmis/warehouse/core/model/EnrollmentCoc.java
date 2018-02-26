package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollmentCoc")
public class EnrollmentCoc extends ClientModel {
	
	private String cocCode;
	private UUID enrollmentId;
	private UUID projectCocId;
	private UUID enrollmentCocId;
	private LocalDateTime informationDate;
    private Integer dataCollectionStage;

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

	public UUID getProjectCocId() {
		return projectCocId;
	}

	public void setProjectCocId(UUID projectCocId) {
		this.projectCocId = projectCocId;
	}

	public LocalDateTime getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}

	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}

	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	
}
