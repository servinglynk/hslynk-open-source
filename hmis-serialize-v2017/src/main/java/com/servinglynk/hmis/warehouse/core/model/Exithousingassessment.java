package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

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

 }
