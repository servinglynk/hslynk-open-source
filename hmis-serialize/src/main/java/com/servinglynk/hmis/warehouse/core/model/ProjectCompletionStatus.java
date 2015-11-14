package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectCompletionStatus")
public class ProjectCompletionStatus extends ClientModel{


      private UUID projectCompletionStatusId;

      private String earlyExitReason;

      private String projectCompletionStatus;



      public UUID getProjectCompletionStatusId(){
          return projectCompletionStatusId;
      }
      public void setProjectCompletionStatusId(UUID projectCompletionStatusId){
          this.projectCompletionStatusId = projectCompletionStatusId;
      }
      public String getEarlyExitReason(){
          return earlyExitReason;
      }
      public void setEarlyExitReason(String earlyExitReason){
          this.earlyExitReason = earlyExitReason;
      }
      public String getProjectCompletionStatus(){
          return projectCompletionStatus;
      }
      public void setProjectCompletionStatus(String projectCompletionStatus){
          this.projectCompletionStatus = projectCompletionStatus;
      }

 }
