package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("affiliation")
public class Affiliation extends ClientModel{


      private UUID affiliationId;

      @JsonProperty("resProjectId")
      private String resprojectid;



      public UUID getAffiliationId(){
          return affiliationId;
      }
      public void setAffiliationId(UUID affiliationId){
          this.affiliationId = affiliationId;
      }
      public String getResprojectid(){
          return resprojectid;
      }
      public void setResprojectid(String resprojectid){
          this.resprojectid = resprojectid;
      }

 }
