package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("lastPermanentAddress")
public class LastPermanentAddress extends ClientModel{


      private UUID lastPermanentAddressId;

      private Integer addressdataquality;

      private String lastpermanentcity;

      private String lastpermanentstate;

      private String lastpermanentstreet;

      private String lastpermanentzip;



      public UUID getLastPermanentAddressId(){
          return lastPermanentAddressId;
      }
      public void setLastPermanentAddressId(UUID lastPermanentAddressId){
          this.lastPermanentAddressId = lastPermanentAddressId;
      }
      public Integer getAddressdataquality(){
          return addressdataquality;
      }
      public void setAddressdataquality(Integer addressdataquality){
          this.addressdataquality = addressdataquality;
      }
      public String getLastpermanentcity(){
          return lastpermanentcity;
      }
      public void setLastpermanentcity(String lastpermanentcity){
          this.lastpermanentcity = lastpermanentcity;
      }
      public String getLastpermanentstate(){
          return lastpermanentstate;
      }
      public void setLastpermanentstate(String lastpermanentstate){
          this.lastpermanentstate = lastpermanentstate;
      }
      public String getLastpermanentstreet(){
          return lastpermanentstreet;
      }
      public void setLastpermanentstreet(String lastpermanentstreet){
          this.lastpermanentstreet = lastpermanentstreet;
      }
      public String getLastpermanentzip(){
          return lastpermanentzip;
      }
      public void setLastpermanentzip(String lastpermanentzip){
          this.lastpermanentzip = lastpermanentzip;
      }

 }
