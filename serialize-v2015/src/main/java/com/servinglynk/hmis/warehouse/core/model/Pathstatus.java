package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("pathstatus")
public class Pathstatus extends ClientModel{


      private UUID pathstatusId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
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
