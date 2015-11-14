package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("nonCashBenefit")
public class NonCashBenefit extends ClientModel{


      private UUID nonCashBenefitId;

      private String othersource;

      private String othersourceidentify;

      private String othertanf;

      private String rentalassistanceongoing;

      private String rentalassistancetemp;

      private String snap;

      private String tanfchildcare;

      private String tanftransportation;

      private String wic;

      private String benefitsfromanysource;



      public UUID getNonCashBenefitId(){
          return nonCashBenefitId;
      }
      public void setNonCashBenefitId(UUID nonCashBenefitId){
          this.nonCashBenefitId = nonCashBenefitId;
      }
      public String getOthersource(){
          return othersource;
      }
      public void setOthersource(String othersource){
          this.othersource = othersource;
      }
      public String getOthersourceidentify(){
          return othersourceidentify;
      }
      public void setOthersourceidentify(String othersourceidentify){
          this.othersourceidentify = othersourceidentify;
      }
      public String getOthertanf(){
          return othertanf;
      }
      public void setOthertanf(String othertanf){
          this.othertanf = othertanf;
      }
      public String getRentalassistanceongoing(){
          return rentalassistanceongoing;
      }
      public void setRentalassistanceongoing(String rentalassistanceongoing){
          this.rentalassistanceongoing = rentalassistanceongoing;
      }
      public String getRentalassistancetemp(){
          return rentalassistancetemp;
      }
      public void setRentalassistancetemp(String rentalassistancetemp){
          this.rentalassistancetemp = rentalassistancetemp;
      }
      public String getSnap(){
          return snap;
      }
      public void setSnap(String snap){
          this.snap = snap;
      }
      public String getTanfchildcare(){
          return tanfchildcare;
      }
      public void setTanfchildcare(String tanfchildcare){
          this.tanfchildcare = tanfchildcare;
      }
      public String getTanftransportation(){
          return tanftransportation;
      }
      public void setTanftransportation(String tanftransportation){
          this.tanftransportation = tanftransportation;
      }
      public String getWic(){
          return wic;
      }
      public void setWic(String wic){
          this.wic = wic;
      }
      public String getBenefitsfromanysource(){
          return benefitsfromanysource;
      }
      public void setBenefitsfromanysource(String benefitsfromanysource){
          this.benefitsfromanysource = benefitsfromanysource;
      }

 }
