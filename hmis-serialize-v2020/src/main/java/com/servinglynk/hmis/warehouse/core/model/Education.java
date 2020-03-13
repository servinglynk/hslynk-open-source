package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("education")
public class Education extends ClientModel{


      private UUID educationId;
      @JsonProperty("lastGradeCompleted")
      private Integer lastgradecompleted;

      private Integer schoolStatus;

      private LocalDateTime informationDate;
      private Integer dataCollectionStage;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
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
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
  	 LocalDateTime submissionDate;

       public LocalDateTime getSubmissionDate() {
 		return submissionDate;
 	}
 	public void setSubmissionDate(LocalDateTime submissionDate) {
 		this.submissionDate = submissionDate;
 	}
 	

 }
