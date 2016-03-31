package com.servinglynk.hmis.warehouse.core.model; 

import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("noncashbenefits")
public class Noncashbenefits extends ClientModel{


      private UUID noncashbenefitsID;

      private Integer benefitsfromanysource;

      private Integer othersource;

      private String othersourceidentify;

      private Integer othertanf;

      private Integer rentalassistanceongoing;

      private Integer rentalassistancetemp;

      private Integer snap;

      private Integer tanfchildcare;

      private Integer tanftransportation;

      private Integer wic;



      public UUID getNoncashbenefitsID(){
          return noncashbenefitsID;
      }
      public void setNoncashbenefitsID(UUID noncashbenefitsID){
          this.noncashbenefitsID = noncashbenefitsID;
      }
      public Integer getBenefitsfromanysource(){
          return benefitsfromanysource;
      }
      public void setBenefitsfromanysource(Integer benefitsfromanysource){
          this.benefitsfromanysource = benefitsfromanysource;
      }
      public Integer getOthersource(){
          return othersource;
      }
      public void setOthersource(Integer othersource){
          this.othersource = othersource;
      }
      public String getOthersourceidentify(){
          return othersourceidentify;
      }
      public void setOthersourceidentify(String othersourceidentify){
          this.othersourceidentify = othersourceidentify;
      }
      public Integer getOthertanf(){
          return othertanf;
      }
      public void setOthertanf(Integer othertanf){
          this.othertanf = othertanf;
      }
      public Integer getRentalassistanceongoing(){
          return rentalassistanceongoing;
      }
      public void setRentalassistanceongoing(Integer rentalassistanceongoing){
          this.rentalassistanceongoing = rentalassistanceongoing;
      }
      public Integer getRentalassistancetemp(){
          return rentalassistancetemp;
      }
      public void setRentalassistancetemp(Integer rentalassistancetemp){
          this.rentalassistancetemp = rentalassistancetemp;
      }
      public Integer getSnap(){
          return snap;
      }
      public void setSnap(Integer snap){
          this.snap = snap;
      }
      public Integer getTanfchildcare(){
          return tanfchildcare;
      }
      public void setTanfchildcare(Integer tanfchildcare){
          this.tanfchildcare = tanfchildcare;
      }
      public Integer getTanftransportation(){
          return tanftransportation;
      }
      public void setTanftransportation(Integer tanftransportation){
          this.tanftransportation = tanftransportation;
      }
      public Integer getWic(){
          return wic;
      }
      public void setWic(Integer wic){
          this.wic = wic;
      }

 }
