package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectCompletionStatus")
public class ProjectCompletionStatus extends ClientModel{


      private UUID projectCompletionStatusId;

      private Integer earlyExitReason;

      private Integer projectCompletionStatus;



      public UUID getProjectCompletionStatusId(){
          return projectCompletionStatusId;
      }
      public void setProjectCompletionStatusId(UUID projectCompletionStatusId){
          this.projectCompletionStatusId = projectCompletionStatusId;
      }
      public Integer getEarlyExitReason(){
          return earlyExitReason;
      }
      public void setEarlyExitReason(Integer earlyExitReason){
          this.earlyExitReason = earlyExitReason;
      }
      public Integer getProjectCompletionStatus(){
          return projectCompletionStatus;
      }
      public void setProjectCompletionStatus(Integer projectCompletionStatus){
          this.projectCompletionStatus = projectCompletionStatus;
      }

 }
