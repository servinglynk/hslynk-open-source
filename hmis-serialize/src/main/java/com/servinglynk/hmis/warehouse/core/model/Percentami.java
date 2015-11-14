package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("percentami")
public class Percentami extends ClientModel{


      private UUID percentamiId;

      private Integer percentage;



      public UUID getPercentamiId(){
          return percentamiId;
      }
      public void setPercentamiId(UUID percentamiId){
          this.percentamiId = percentamiId;
      }
      public Integer getPercentage(){
          return percentage;
      }
      public void setPercentage(Integer percentage){
          this.percentage = percentage;
      }

 }
