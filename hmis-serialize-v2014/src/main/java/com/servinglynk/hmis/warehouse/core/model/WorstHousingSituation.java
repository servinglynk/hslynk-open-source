package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("worstHousingSituation")
public class WorstHousingSituation extends ClientModel{


      private UUID worstHousingSituationId;

      private Integer worsthousingsituation;



      public UUID getWorstHousingSituationId(){
          return worstHousingSituationId;
      }
      public void setWorstHousingSituationId(UUID worstHousingSituationId){
          this.worstHousingSituationId = worstHousingSituationId;
      }
      public Integer getWorsthousingsituation(){
          return worsthousingsituation;
      }
      public void setWorsthousingsituation(Integer worsthousingsituation){
          this.worsthousingsituation = worsthousingsituation;
      }

 }
