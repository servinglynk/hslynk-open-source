package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("HealthStatus")
public class HealthStatus extends ClientModel{


      private UUID healthStatusId;

      private LocalDateTime informationDate;

      private Integer healthCategory;

      private Integer healthStatus;

      private Date dueDate;

      private Integer dataCollectionStage;


	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
      public UUID getHealthStatusId(){
          return healthStatusId;
      }
      public void setHealthStatusId(UUID healthStatusId){
          this.healthStatusId = healthStatusId;
      }
      public LocalDateTime getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(LocalDateTime informationDate){
          this.informationDate = informationDate;
      }
      public Integer getHealthCategory(){
          return healthCategory;
      }
      public void setHealthCategory(Integer healthCategory){
          this.healthCategory = healthCategory;
      }
      public Integer getHealthStatus(){
          return healthStatus;
      }
      public void setHealthStatus(Integer healthStatus){
          this.healthStatus = healthStatus;
      }
      public Date getDueDate(){
          return dueDate;
      }
      public void setDueDate(Date dueDate){
          this.dueDate = dueDate;
      }

 }
