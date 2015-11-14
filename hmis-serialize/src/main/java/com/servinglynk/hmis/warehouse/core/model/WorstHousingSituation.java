package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("worstHousingSituation")
public class WorstHousingSituation extends ClientModel{


      private UUID worstHousingSituationId;

      private String worsthousingsituation;



      public UUID getWorstHousingSituationId(){
          return worstHousingSituationId;
      }
      public void setWorstHousingSituationId(UUID worstHousingSituationId){
          this.worstHousingSituationId = worstHousingSituationId;
      }
      public String getWorsthousingsituation(){
          return worsthousingsituation;
      }
      public void setWorsthousingsituation(String worsthousingsituation){
          this.worsthousingsituation = worsthousingsituation;
      }

 }
