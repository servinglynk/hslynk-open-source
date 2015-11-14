package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("referralsource")
public class Referralsource extends ClientModel{


      private UUID referralsourceId;

      private Integer countoutreachreferralapproaches;



      public UUID getReferralsourceId(){
          return referralsourceId;
      }
      public void setReferralsourceId(UUID referralsourceId){
          this.referralsourceId = referralsourceId;
      }
      public Integer getCountoutreachreferralapproaches(){
          return countoutreachreferralapproaches;
      }
      public void setCountoutreachreferralapproaches(Integer countoutreachreferralapproaches){
          this.countoutreachreferralapproaches = countoutreachreferralapproaches;
      }

 }
