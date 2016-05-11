package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("education")
public class Education extends ClientModel{


      private UUID educationId;

      private Integer lastgradecompleted;

      private Integer schoolStatus;



      public UUID getEducationId(){
          return educationId;
      }
      public void setEducationId(UUID educationId){
          this.educationId = educationId;
      }
      public Integer getLastgradecompleted(){
          return lastgradecompleted;
      }
      public void setLastgradecompleted(Integer lastgradecompleted){
          this.lastgradecompleted = lastgradecompleted;
      }
      public Integer getSchoolStatus(){
          return schoolStatus;
      }
      public void setSchoolStatus(Integer schoolStatus){
          this.schoolStatus = schoolStatus;
      }

 }
