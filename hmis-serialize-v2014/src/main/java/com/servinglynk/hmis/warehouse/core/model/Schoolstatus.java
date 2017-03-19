package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("schoolstatus")
public class Schoolstatus extends ClientModel {

	private UUID schoolstatusId;

	@JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime informationDate;
	private Integer schoolStatus;
	 private Integer dataCollectionStage;
     
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
	public UUID getSchoolstatusId() {
		return schoolstatusId;
	}

	public void setSchoolstatusId(UUID schoolstatusId) {
		this.schoolstatusId = schoolstatusId;
	}

	public Integer getSchoolStatus() {
		return schoolStatus;
	}

	public void setSchoolStatus(Integer schoolStatus) {
		this.schoolStatus = schoolStatus;
	}
}