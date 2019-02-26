package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("enrollmentCoc")
public class EnrollmentCoc extends ClientModel{


      private UUID enrollmentCocId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime informationDate;
      private Integer dataCollectionStage;
      private String cocCode;

      public UUID getEnrollmentCocId(){
          return enrollmentCocId;
      }
      public void setEnrollmentCocId(UUID enrollmentCocId){
          this.enrollmentCocId = enrollmentCocId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	public String getCocCode() {
		return cocCode;
	}
	public void setCocCode(String cocCode) {
		this.cocCode = cocCode;
	}

 }
