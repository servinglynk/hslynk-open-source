package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("medicalassistance")
public class Medicalassistance extends ClientModel{


      private UUID medicalassistanceId;

      private Integer adap;

      private LocalDateTime informationDate;
      private Integer dataCollectionStage;


	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
}

         public LocalDateTime getInformationDate() {
    		return informationDate;
    	}
    	public void setInformationDate(LocalDateTime informationDate) {
    		this.informationDate = informationDate;
}

      public UUID getMedicalassistanceId(){
          return medicalassistanceId;
      }
      public void setMedicalassistanceId(UUID medicalassistanceId){
          this.medicalassistanceId = medicalassistanceId;
      }
      public Integer getAdap(){
          return adap;
      }
      public void setAdap(Integer adap){
          this.adap = adap;
      }

 }
