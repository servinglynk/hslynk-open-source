package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("dateOfEngagement")
public class Dateofengagement extends ClientModel{

	 @JsonProperty("dateOfEngagementId")
      private UUID dateofengagementId;

     @JsonSerialize(using=JsonDateSerializer.class)
     @JsonDeserialize(using=JsonDateDeserializer.class)
      @JsonProperty("dateOfEngagement")
      private LocalDateTime dateofengagement;


     @JsonSerialize(using=JsonDateTimeSerializer.class)
 	 LocalDateTime submissionDate;

      public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}
		
	public UUID getDateofengagementId(){
          return dateofengagementId;
      }
      public void setDateofengagementId(UUID dateofengagementId){
          this.dateofengagementId = dateofengagementId;
      }
      public LocalDateTime getDateofengagement(){
          return dateofengagement;
      }
      public void setDateofengagement(LocalDateTime dateofengagement){
          this.dateofengagement = dateofengagement;
      }

 }
