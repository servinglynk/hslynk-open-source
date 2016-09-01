package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sexualorientation")
public class Sexualorientation extends ClientModel{


      private UUID sexualorientationId;

      private Integer sexualorientation;

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

      public UUID getSexualorientationId(){
          return sexualorientationId;
      }
      public void setSexualorientationId(UUID sexualorientationId){
          this.sexualorientationId = sexualorientationId;
      }
      public Integer getSexualorientation(){
          return sexualorientation;
      }
      public void setSexualorientation(Integer sexualorientation){
          this.sexualorientation = sexualorientation;
      }

 }
