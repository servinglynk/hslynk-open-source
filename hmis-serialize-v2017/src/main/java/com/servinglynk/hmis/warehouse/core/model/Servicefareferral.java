package com.servinglynk.hmis.warehouse.core.model; 

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("erviceFaReferral")
public class Servicefareferral extends ClientModel{

		@JsonProperty("erviceFaReferralId")		
      private UUID servicefareferralId;
      
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime dateprovided;

      private Integer recordType;
      
      private Integer typeProvided;

      private String otherTypeProvided;

      private Integer subTypeProvided;

      private BigDecimal faAmount;

      private Integer referralOutcome;
      @JsonSerialize(using=JsonDateTimeSerializer.class)
   	 LocalDateTime submissionDate;

        public LocalDateTime getSubmissionDate() {
  		return submissionDate;
  	}
  	public void setSubmissionDate(LocalDateTime submissionDate) {
  		this.submissionDate = submissionDate;
  	}



      public UUID getServicefareferralId(){
          return servicefareferralId;
      }
      public void setServicefareferralId(UUID servicefareferralId){
          this.servicefareferralId = servicefareferralId;
      }
      public LocalDateTime getDateprovided(){
          return dateprovided;
      }
      public void setDateprovided(LocalDateTime dateprovided){
          this.dateprovided = dateprovided;
      }
      
      public Integer getRecordType() {
		return recordType;
	}
	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}
	public Integer getTypeProvided(){
          return typeProvided;
      }
      public void setTypeProvided(Integer typeProvided){
          this.typeProvided = typeProvided;
      }
      public String getOtherTypeProvided(){
          return otherTypeProvided;
      }
      public void setOtherTypeProvided(String otherTypeProvided){
          this.otherTypeProvided = otherTypeProvided;
      }
      public Integer getSubTypeProvided(){
          return subTypeProvided;
      }
      public void setSubTypeProvided(Integer subTypeProvided){
          this.subTypeProvided = subTypeProvided;
      }
      public BigDecimal getFaAmount(){
          return faAmount;
      }
      public void setFaAmount(BigDecimal faAmount){
          this.faAmount = faAmount;
      }
      public Integer getReferralOutcome(){
          return referralOutcome;
      }
      public void setReferralOutcome(Integer referralOutcome){
          this.referralOutcome = referralOutcome;
      }

 }
