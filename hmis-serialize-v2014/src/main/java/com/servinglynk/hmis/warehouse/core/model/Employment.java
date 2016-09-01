package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("employment")
public class Employment extends ClientModel{


       private UUID employmentId;

       private Integer employed;

       private Integer employmentType;

       private Integer notEmployedReason;
       
       private LocalDateTime informationDate;
       private Integer dataCollectionStage;
       
       
 	public Integer getDataCollectionStage() {
 		return dataCollectionStage;
 	}
 	public void setDataCollectionStage(Integer dataCollectionStage) {
 		this.dataCollectionStage = dataCollectionStage;
 	}

	public UUID getEmploymentId() {
		return employmentId;
	}

	public void setEmploymentId(UUID employmentId) {
		this.employmentId = employmentId;
	}

	public Integer getEmployed() {
		return employed;
	}

	public void setEmployed(Integer employed) {
		this.employed = employed;
	}

	public Integer getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(Integer employmentType) {
		this.employmentType = employmentType;
	}

	public Integer getNotEmployedReason() {
		return notEmployedReason;
	}

	public void setNotEmployedReason(Integer notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
	}

	public LocalDateTime getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
 }