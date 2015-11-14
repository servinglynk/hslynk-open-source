package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("HealthStatus")
public class HealthStatus extends ClientModel{


      private UUID healthStatusId;

      private Date informationDate;

      private String healthCategory;

      private String healthStatus;

      private Date dueDate;



      public UUID getHealthStatusId(){
          return healthStatusId;
      }
      public void setHealthStatusId(UUID healthStatusId){
          this.healthStatusId = healthStatusId;
      }
      public Date getInformationDate(){
          return informationDate;
      }
      public void setInformationDate(Date informationDate){
          this.informationDate = informationDate;
      }
      public String getHealthCategory(){
          return healthCategory;
      }
      public void setHealthCategory(String healthCategory){
          this.healthCategory = healthCategory;
      }
      public String getHealthStatus(){
          return healthStatus;
      }
      public void setHealthStatus(String healthStatus){
          this.healthStatus = healthStatus;
      }
      public Date getDueDate(){
          return dueDate;
      }
      public void setDueDate(Date dueDate){
          this.dueDate = dueDate;
      }

 }
