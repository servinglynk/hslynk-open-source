package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryRhsp")
public class Entryrhsp extends ClientModel{


      private UUID entryrhspId;

      private Integer worstHousingSituation;



      public UUID getEntryrhspId(){
          return entryrhspId;
      }
      public void setEntryrhspId(UUID entryrhspId){
          this.entryrhspId = entryrhspId;
      }
      public Integer getWorstHousingSituation(){
          return worstHousingSituation;
      }
      public void setWorstHousingSituation(Integer worstHousingSituation){
          this.worstHousingSituation = worstHousingSituation;
      }

 }
