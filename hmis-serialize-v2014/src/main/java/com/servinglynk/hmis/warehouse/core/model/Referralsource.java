package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("referralsource")
public class Referralsource extends ClientModel{


      private UUID referralsourceId;

      private Integer countoutreachreferralapproaches;

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

      public UUID getReferralsourceId(){
          return referralsourceId;
      }
      public void setReferralsourceId(UUID referralsourceId){
          this.referralsourceId = referralsourceId;
      }
      public Integer getCountoutreachreferralapproaches(){
          return countoutreachreferralapproaches;
      }
      public void setCountoutreachreferralapproaches(Integer countoutreachreferralapproaches){
          this.countoutreachreferralapproaches = countoutreachreferralapproaches;
      }

 }
