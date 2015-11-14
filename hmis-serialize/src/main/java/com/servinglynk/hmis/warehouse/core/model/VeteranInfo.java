package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("veteranInfo")
public class VeteranInfo extends ClientModel{


      private UUID veteranInfoId;

      private Integer yearEntrdService;

      private Integer yearSeperated;

      private String worldWar2;

      private String koreanWar;

      private String vietnamWar;

      private String desertStorm;

      private String afghanistanOef;

      private String iraqOif;

      private String iraqOnd;

      private String otherTheater;

      private String militaryBranch;

      private String dischargeStatus;



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
      public String getWorldWar2(){
          return worldWar2;
      }
      public void setWorldWar2(String worldWar2){
          this.worldWar2 = worldWar2;
      }
      public String getKoreanWar(){
          return koreanWar;
      }
      public void setKoreanWar(String koreanWar){
          this.koreanWar = koreanWar;
      }
      public String getVietnamWar(){
          return vietnamWar;
      }
      public void setVietnamWar(String vietnamWar){
          this.vietnamWar = vietnamWar;
      }
      public String getDesertStorm(){
          return desertStorm;
      }
      public void setDesertStorm(String desertStorm){
          this.desertStorm = desertStorm;
      }
      public String getAfghanistanOef(){
          return afghanistanOef;
      }
      public void setAfghanistanOef(String afghanistanOef){
          this.afghanistanOef = afghanistanOef;
      }
      public String getIraqOif(){
          return iraqOif;
      }
      public void setIraqOif(String iraqOif){
          this.iraqOif = iraqOif;
      }
      public String getIraqOnd(){
          return iraqOnd;
      }
      public void setIraqOnd(String iraqOnd){
          this.iraqOnd = iraqOnd;
      }
      public String getOtherTheater(){
          return otherTheater;
      }
      public void setOtherTheater(String otherTheater){
          this.otherTheater = otherTheater;
      }
      public String getMilitaryBranch(){
          return militaryBranch;
      }
      public void setMilitaryBranch(String militaryBranch){
          this.militaryBranch = militaryBranch;
      }
      public String getDischargeStatus(){
          return dischargeStatus;
      }
      public void setDischargeStatus(String dischargeStatus){
          this.dischargeStatus = dischargeStatus;
      }

 }
