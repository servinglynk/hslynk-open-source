package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("housingAssessmentDisposition")
public class HousingAssessmentDisposition extends ClientModel{


      private UUID housingAssessmentDispositionId;
      @JsonProperty("assessmentDisposition")
      private Integer assessmentdisposition;

      @JsonProperty("otherDisposition")
      private String otherdisposition;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
   	 LocalDateTime submissionDate;

        public LocalDateTime getSubmissionDate() {
  		return submissionDate;
  	}
  	public void setSubmissionDate(LocalDateTime submissionDate) {
  		this.submissionDate = submissionDate;
  	}



      public UUID getHousingAssessmentDispositionId(){
          return housingAssessmentDispositionId;
      }
      public void setHousingAssessmentDispositionId(UUID housingAssessmentDispositionId){
          this.housingAssessmentDispositionId = housingAssessmentDispositionId;
      }
      public Integer getAssessmentdisposition(){
          return assessmentdisposition;
      }
      public void setAssessmentdisposition(Integer assessmentdisposition){
          this.assessmentdisposition = assessmentdisposition;
      }
      public String getOtherdisposition(){
          return otherdisposition;
      }
      public void setOtherdisposition(String otherdisposition){
          this.otherdisposition = otherdisposition;
      }

 }
