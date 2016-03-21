package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("domesticViolence")
public class DomesticViolence extends ClientModel{


      private UUID domesticViolenceId;

      private Integer domesticviolencevictim;

      private Integer whenoccurred;



      public UUID getDomesticViolenceId(){
          return domesticViolenceId;
      }
      public void setDomesticViolenceId(UUID domesticViolenceId){
          this.domesticViolenceId = domesticViolenceId;
      }
      public Integer getDomesticviolencevictim(){
          return domesticviolencevictim;
      }
      public void setDomesticviolencevictim(Integer domesticviolencevictim){
          this.domesticviolencevictim = domesticviolencevictim;
      }
      public Integer getWhenoccurred(){
          return whenoccurred;
      }
      public void setWhenoccurred(Integer whenoccurred){
          this.whenoccurred = whenoccurred;
      }

 }
