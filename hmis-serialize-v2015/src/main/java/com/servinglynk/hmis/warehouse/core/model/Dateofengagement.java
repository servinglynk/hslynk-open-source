package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("dateofengagement")
public class Dateofengagement extends ClientModel{


      private UUID dateofengagementId;

      private LocalDateTime dateofengagement;



      public UUID getDateofengagementId(){
          return dateofengagementId;
      }
      public void setDateofengagementId(UUID dateofengagementId){
          this.dateofengagementId = dateofengagementId;
      }
      public LocalDateTime getDateofengagement(){
          return dateofengagement;
      }
      public void setDateofengagement(LocalDateTime dateofengagement){
          this.dateofengagement = dateofengagement;
      }

 }
