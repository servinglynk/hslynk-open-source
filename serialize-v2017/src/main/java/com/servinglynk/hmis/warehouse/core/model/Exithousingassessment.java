package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("exitHousingAssessment")
public class Exithousingassessment extends ClientModel{

	@JsonProperty("exitHousingAssessmentId")
      private UUID exithousingassessmentId;

      @JsonProperty("housingAssessment")
      private Integer housingassessment;

      @JsonProperty("subsidyInformation")
      private Integer subsidyinformation;



      public UUID getExithousingassessmentId(){
          return exithousingassessmentId;
      }
      public void setExithousingassessmentId(UUID exithousingassessmentId){
          this.exithousingassessmentId = exithousingassessmentId;
      }
      public Integer getHousingassessment(){
          return housingassessment;
      }
      public void setHousingassessment(Integer housingassessment){
          this.housingassessment = housingassessment;
      }
      public Integer getSubsidyinformation(){
          return subsidyinformation;
      }
      public void setSubsidyinformation(Integer subsidyinformation){
          this.subsidyinformation = subsidyinformation;
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
