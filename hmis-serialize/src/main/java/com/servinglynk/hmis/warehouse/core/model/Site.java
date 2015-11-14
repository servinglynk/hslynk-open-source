package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("site")
public class Site extends ClientModel{


      private UUID siteId;

      private String address;

      private String city;

      private Integer geocode;

      private String principalsite;

      private String state;

      private String zip;



      public UUID getSiteId(){
          return siteId;
      }
      public void setSiteId(UUID siteId){
          this.siteId = siteId;
      }
      public String getAddress(){
          return address;
      }
      public void setAddress(String address){
          this.address = address;
      }
      public String getCity(){
          return city;
      }
      public void setCity(String city){
          this.city = city;
      }
      public Integer getGeocode(){
          return geocode;
      }
      public void setGeocode(Integer geocode){
          this.geocode = geocode;
      }
      public String getPrincipalsite(){
          return principalsite;
      }
      public void setPrincipalsite(String principalsite){
          this.principalsite = principalsite;
      }
      public String getState(){
          return state;
      }
      public void setState(String state){
          this.state = state;
      }
      public String getZip(){
          return zip;
      }
      public void setZip(String zip){
          this.zip = zip;
      }

 }
