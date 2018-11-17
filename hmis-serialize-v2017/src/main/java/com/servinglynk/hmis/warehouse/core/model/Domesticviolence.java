package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("domesticViolence")
public class Domesticviolence extends ClientModel{

	@JsonProperty("domesticViolenceId")
      private UUID domesticviolenceId;
      @JsonProperty("domesticViolenceVictim")
      private Integer domesticviolencevictim;

      @JsonProperty("whenOccurred")
      private Integer whenoccurred;

      private Integer currentlyFleeing;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;
      private Integer dataCollectionStage;
      
      @JsonSerialize(using=JsonDateTimeSerializer.class)
   	 LocalDateTime submissionDate;

        public LocalDateTime getSubmissionDate() {
  		return submissionDate;
  	}
  	public void setSubmissionDate(LocalDateTime submissionDate) {
  		this.submissionDate = submissionDate;
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
	public UUID getDomesticviolenceId(){
          return domesticviolenceId;
      }
      public void setDomesticviolenceId(UUID domesticviolenceId){
          this.domesticviolenceId = domesticviolenceId;
      }
      public Integer getDomesticviolencevictim(){
          return domesticviolencevictim;
      }
      public void setDomesticviolencevictim(Integer domesticviolencevictim){
          this.domesticviolencevictim = domesticviolencevictim;
      }
      public Integer getWhenoccurred(){
          return whenoccurred;
      }
      public void setWhenoccurred(Integer whenoccurred){
          this.whenoccurred = whenoccurred;
      }
      public Integer getCurrentlyFleeing(){
          return currentlyFleeing;
      }
      public void setCurrentlyFleeing(Integer currentlyFleeing){
          this.currentlyFleeing = currentlyFleeing;
      }

 }
