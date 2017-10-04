package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("veteranInfo")
public class VeteranInfo extends ClientModel{


      private UUID veteranInfoId;

      private Integer yearEntrdService;

      private Integer yearSeperated;

      private Integer worldWar2;

      private Integer koreanWar;

      private Integer vietnamWar;

      private Integer desertStorm;

      private Integer afghanistanOef;

      private Integer iraqOif;

      private Integer iraqOnd;

      private Integer otherTheater;

      private Integer militaryBranch;

      private Integer dischargeStatus;



      public UUID getVeteranInfoId(){
          return veteranInfoId;
      }
      public void setVeteranInfoId(UUID veteranInfoId){
          this.veteranInfoId = veteranInfoId;
      }
      public Integer getYearEntrdService(){
          return yearEntrdService;
      }
      public void setYearEntrdService(Integer yearEntrdService){
          this.yearEntrdService = yearEntrdService;
      }
      public Integer getYearSeperated(){
          return yearSeperated;
      }
      public void setYearSeperated(Integer yearSeperated){
          this.yearSeperated = yearSeperated;
      }
      public Integer getWorldWar2(){
          return worldWar2;
      }
      public void setWorldWar2(Integer worldWar2){
          this.worldWar2 = worldWar2;
      }
      public Integer getKoreanWar(){
          return koreanWar;
      }
      public void setKoreanWar(Integer koreanWar){
          this.koreanWar = koreanWar;
      }
      public Integer getVietnamWar(){
          return vietnamWar;
      }
      public void setVietnamWar(Integer vietnamWar){
          this.vietnamWar = vietnamWar;
      }
      public Integer getDesertStorm(){
          return desertStorm;
      }
      public void setDesertStorm(Integer desertStorm){
          this.desertStorm = desertStorm;
      }
      public Integer getAfghanistanOef(){
          return afghanistanOef;
      }
      public void setAfghanistanOef(Integer afghanistanOef){
          this.afghanistanOef = afghanistanOef;
      }
      public Integer getIraqOif(){
          return iraqOif;
      }
      public void setIraqOif(Integer iraqOif){
          this.iraqOif = iraqOif;
      }
      public Integer getIraqOnd(){
          return iraqOnd;
      }
      public void setIraqOnd(Integer iraqOnd){
          this.iraqOnd = iraqOnd;
      }
      public Integer getOtherTheater(){
          return otherTheater;
      }
      public void setOtherTheater(Integer otherTheater){
          this.otherTheater = otherTheater;
      }
      public Integer getMilitaryBranch(){
          return militaryBranch;
      }
      public void setMilitaryBranch(Integer militaryBranch){
          this.militaryBranch = militaryBranch;
      }
      public Integer getDischargeStatus(){
          return dischargeStatus;
      }
      public void setDischargeStatus(Integer dischargeStatus){
          this.dischargeStatus = dischargeStatus;
      }

 }
