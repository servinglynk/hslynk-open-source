package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("medicalassistance")
public class Medicalassistance extends ClientModel{


      private UUID medicalassistanceId;

      private String adap;



      public UUID getMedicalassistanceId(){
          return medicalassistanceId;
      }
      public void setMedicalassistanceId(UUID medicalassistanceId){
          this.medicalassistanceId = medicalassistanceId;
      }
      public String getAdap(){
          return adap;
      }
      public void setAdap(String adap){
          this.adap = adap;
      }

 }
