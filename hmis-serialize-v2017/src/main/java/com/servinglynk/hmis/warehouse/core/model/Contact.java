package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("contact")
public class Contact extends ClientModel{


      private UUID contactId;

      private Integer contactLocation;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime contactDate;

      @JsonSerialize(using=JsonDateTimeSerializer.class)
   	 LocalDateTime submissionDate;

        public LocalDateTime getSubmissionDate() {
  		return submissionDate;
  	}
  	public void setSubmissionDate(LocalDateTime submissionDate) {
  		this.submissionDate = submissionDate;
  	}


      public UUID getContactId(){
          return contactId;
      }
      public void setContactId(UUID contactId){
          this.contactId = contactId;
      }
      public Integer getContactLocation(){
          return contactLocation;
      }
      public void setContactLocation(Integer contactLocation){
          this.contactLocation = contactLocation;
      }
      public LocalDateTime getContactDate(){
          return contactDate;
      }
      public void setContactDate(LocalDateTime contactDate){
          this.contactDate = contactDate;
      }

 }
