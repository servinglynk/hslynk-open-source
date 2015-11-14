package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("domesticViolence")
public class DomesticViolence extends ClientModel{


      private UUID domesticViolenceId;

      private String domesticviolencevictim;

      private String whenoccurred;



      public UUID getDomesticViolenceId(){
          return domesticViolenceId;
      }
      public void setDomesticViolenceId(UUID domesticViolenceId){
          this.domesticViolenceId = domesticViolenceId;
      }
      public String getDomesticviolencevictim(){
          return domesticviolencevictim;
      }
      public void setDomesticviolencevictim(String domesticviolencevictim){
          this.domesticviolencevictim = domesticviolencevictim;
      }
      public String getWhenoccurred(){
          return whenoccurred;
      }
      public void setWhenoccurred(String whenoccurred){
          this.whenoccurred = whenoccurred;
      }

 }
