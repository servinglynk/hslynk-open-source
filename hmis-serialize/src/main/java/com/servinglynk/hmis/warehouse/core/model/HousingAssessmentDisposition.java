package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("housingAssessmentDisposition")
public class HousingAssessmentDisposition extends ClientModel{


      private UUID housingAssessmentDispositionId;

      private String assessmentdisposition;

      private String otherdisposition;



      public UUID getHousingAssessmentDispositionId(){
          return housingAssessmentDispositionId;
      }
      public void setHousingAssessmentDispositionId(UUID housingAssessmentDispositionId){
          this.housingAssessmentDispositionId = housingAssessmentDispositionId;
      }
      public String getAssessmentdisposition(){
          return assessmentdisposition;
      }
      public void setAssessmentdisposition(String assessmentdisposition){
          this.assessmentdisposition = assessmentdisposition;
      }
      public String getOtherdisposition(){
          return otherdisposition;
      }
      public void setOtherdisposition(String otherdisposition){
          this.otherdisposition = otherdisposition;
      }

 }
