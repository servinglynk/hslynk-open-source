package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pathstatus")
public class Pathstatus extends ClientModel{


      private UUID pathstatusId;

      private LocalDateTime dateOfStatus;

      private Long clientEnrolledInPath;

      private Integer reasonNotEnrolled;



      public UUID getPathstatusId(){
          return pathstatusId;
      }
      public void setPathstatusId(UUID pathstatusId){
          this.pathstatusId = pathstatusId;
      }
      public LocalDateTime getDateOfStatus(){
          return dateOfStatus;
      }
      public void setDateOfStatus(LocalDateTime dateOfStatus){
          this.dateOfStatus = dateOfStatus;
      }
      public Long getClientEnrolledInPath(){
          return clientEnrolledInPath;
      }
      public void setClientEnrolledInPath(Long clientEnrolledInPath){
          this.clientEnrolledInPath = clientEnrolledInPath;
      }
      public Integer getReasonNotEnrolled(){
          return reasonNotEnrolled;
      }
      public void setReasonNotEnrolled(Integer reasonNotEnrolled){
          this.reasonNotEnrolled = reasonNotEnrolled;
      }

 }
