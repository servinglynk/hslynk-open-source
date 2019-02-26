package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryssvf")
public class Entryssvf extends ClientModel{


      private UUID entryssvfId;

      private Integer percentami;

      private String lastPermanentStreet;

      private String lastPermanentCity;

      private String lastPermanentState;

      private String lastPermanentZip;

      private Integer addressDataQuality;

      private Integer hpScreenScore;

      private String vamcStaction;



      public UUID getEntryssvfId(){
          return entryssvfId;
      }
      public void setEntryssvfId(UUID entryssvfId){
          this.entryssvfId = entryssvfId;
      }
      public Integer getPercentami(){
          return percentami;
      }
      public void setPercentami(Integer percentami){
          this.percentami = percentami;
      }
      public String getLastPermanentStreet(){
          return lastPermanentStreet;
      }
      public void setLastPermanentStreet(String lastPermanentStreet){
          this.lastPermanentStreet = lastPermanentStreet;
      }
      public String getLastPermanentCity(){
          return lastPermanentCity;
      }
      public void setLastPermanentCity(String lastPermanentCity){
          this.lastPermanentCity = lastPermanentCity;
      }
      public String getLastPermanentState(){
          return lastPermanentState;
      }
      public void setLastPermanentState(String lastPermanentState){
          this.lastPermanentState = lastPermanentState;
      }
      public String getLastPermanentZip(){
          return lastPermanentZip;
      }
      public void setLastPermanentZip(String lastPermanentZip){
          this.lastPermanentZip = lastPermanentZip;
      }
      public Integer getAddressDataQuality(){
          return addressDataQuality;
      }
      public void setAddressDataQuality(Integer addressDataQuality){
          this.addressDataQuality = addressDataQuality;
      }
      public Integer getHpScreenScore(){
          return hpScreenScore;
      }
      public void setHpScreenScore(Integer hpScreenScore){
          this.hpScreenScore = hpScreenScore;
      }
      public String getVamcStaction(){
          return vamcStaction;
      }
      public void setVamcStaction(String vamcStaction){
          this.vamcStaction = vamcStaction;
      }

 }
