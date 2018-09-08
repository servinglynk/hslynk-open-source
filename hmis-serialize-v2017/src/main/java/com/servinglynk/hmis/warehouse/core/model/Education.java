package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("education")
public class Education extends ClientModel{


      private UUID educationId;
      @JsonProperty("lastGradeCompleted")
      private Integer lastgradecompleted;

      private Integer schoolStatus;

      private LocalDateTime informationDate;
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

      public UUID getEducationId(){
          return educationId;
      }
      public void setEducationId(UUID educationId){
          this.educationId = educationId;
      }
      public Integer getLastgradecompleted(){
          return lastgradecompleted;
      }
      public void setLastgradecompleted(Integer lastgradecompleted){
          this.lastgradecompleted = lastgradecompleted;
      }
      public Integer getSchoolStatus(){
          return schoolStatus;
      }
      public void setSchoolStatus(Integer schoolStatus){
          this.schoolStatus = schoolStatus;
      }

 }
