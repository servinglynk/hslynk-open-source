package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("dateofengagement")
public class Dateofengagement extends ClientModel{


      private UUID dateofengagementId;

      private Date dateofengagement;



      public UUID getDateofengagementId(){
          return dateofengagementId;
      }
      public void setDateofengagementId(UUID dateofengagementId){
          this.dateofengagementId = dateofengagementId;
      }
      public Date getDateofengagement(){
          return dateofengagement;
      }
      public void setDateofengagement(Date dateofengagement){
          this.dateofengagement = dateofengagement;
      }

 }
