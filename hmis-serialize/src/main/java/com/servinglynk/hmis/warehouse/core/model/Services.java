package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("services")
public class Services extends ClientModel{


      private UUID servicesId;

      private Date dateprovided;

      private float faamount;

      private String insurancefromanysource;

      private String recordtype;

      private String referraloutcome;

      private Integer subtypeprovided;

      private Integer typeprovided;



      public UUID getServicesId(){
          return servicesId;
      }
      public void setServicesId(UUID servicesId){
          this.servicesId = servicesId;
      }
      public Date getDateprovided(){
          return dateprovided;
      }
      public void setDateprovided(Date dateprovided){
          this.dateprovided = dateprovided;
      }
      public float getFaamount(){
          return faamount;
      }
      public void setFaamount(float faamount){
          this.faamount = faamount;
      }
      public String getInsurancefromanysource(){
          return insurancefromanysource;
      }
      public void setInsurancefromanysource(String insurancefromanysource){
          this.insurancefromanysource = insurancefromanysource;
      }
      public String getRecordtype(){
          return recordtype;
      }
      public void setRecordtype(String recordtype){
          this.recordtype = recordtype;
      }
      public String getReferraloutcome(){
          return referraloutcome;
      }
      public void setReferraloutcome(String referraloutcome){
          this.referraloutcome = referraloutcome;
      }
      public Integer getSubtypeprovided(){
          return subtypeprovided;
      }
      public void setSubtypeprovided(Integer subtypeprovided){
          this.subtypeprovided = subtypeprovided;
      }
      public Integer getTypeprovided(){
          return typeprovided;
      }
      public void setTypeprovided(Integer typeprovided){
          this.typeprovided = typeprovided;
      }

 }
