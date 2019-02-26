package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("exithousingassessment")
public class Exithousingassessment extends ClientModel{


      private UUID exithousingassessmentId;

      private Integer housingassessment;

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
