package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthInsurance")
public class HealthInsurance extends ClientModel{


      private UUID healthInsuranceId;

      private Integer cobra;

      private Integer employerprovided;

      private Integer insurancefromanysource;

      private Integer medicaid;

      private Integer medicare;

      private Integer nocobrareason;

      private Integer noemployerprovidedreason;

      private Integer nomedicaidreason;

      private Integer nomedicarereason;

      private Integer noprivatepayreason;

      private Integer noschipreason;

      private Integer nostatehealthinsreason;

      private Integer novamedreason;

      private Integer privatepay;

      private Integer schip;

      private Integer statehealthins;

      private Integer vamedicalservices;



      public UUID getHealthInsuranceId(){
          return healthInsuranceId;
      }
      public void setHealthInsuranceId(UUID healthInsuranceId){
          this.healthInsuranceId = healthInsuranceId;
      }
      public Integer getCobra(){
          return cobra;
      }
      public void setCobra(Integer cobra){
          this.cobra = cobra;
      }
      public Integer getEmployerprovided(){
          return employerprovided;
      }
      public void setEmployerprovided(Integer employerprovided){
          this.employerprovided = employerprovided;
      }
      public Integer getInsurancefromanysource(){
          return insurancefromanysource;
      }
      public void setInsurancefromanysource(Integer insurancefromanysource){
          this.insurancefromanysource = insurancefromanysource;
      }
      public Integer getMedicaid(){
          return medicaid;
      }
      public void setMedicaid(Integer medicaid){
          this.medicaid = medicaid;
      }
      public Integer getMedicare(){
          return medicare;
      }
      public void setMedicare(Integer medicare){
          this.medicare = medicare;
      }
      public Integer getNocobrareason(){
          return nocobrareason;
      }
      public void setNocobrareason(Integer nocobrareason){
          this.nocobrareason = nocobrareason;
      }
      public Integer getNoemployerprovidedreason(){
          return noemployerprovidedreason;
      }
      public void setNoemployerprovidedreason(Integer noemployerprovidedreason){
          this.noemployerprovidedreason = noemployerprovidedreason;
      }
      public Integer getNomedicaidreason(){
          return nomedicaidreason;
      }
      public void setNomedicaidreason(Integer nomedicaidreason){
          this.nomedicaidreason = nomedicaidreason;
      }
      public Integer getNomedicarereason(){
          return nomedicarereason;
      }
      public void setNomedicarereason(Integer nomedicarereason){
          this.nomedicarereason = nomedicarereason;
      }
      public Integer getNoprivatepayreason(){
          return noprivatepayreason;
      }
      public void setNoprivatepayreason(Integer noprivatepayreason){
          this.noprivatepayreason = noprivatepayreason;
      }
      public Integer getNoschipreason(){
          return noschipreason;
      }
      public void setNoschipreason(Integer noschipreason){
          this.noschipreason = noschipreason;
      }
      public Integer getNostatehealthinsreason(){
          return nostatehealthinsreason;
      }
      public void setNostatehealthinsreason(Integer nostatehealthinsreason){
          this.nostatehealthinsreason = nostatehealthinsreason;
      }
      public Integer getNovamedreason(){
          return novamedreason;
      }
      public void setNovamedreason(Integer novamedreason){
          this.novamedreason = novamedreason;
      }
      public Integer getPrivatepay(){
          return privatepay;
      }
      public void setPrivatepay(Integer privatepay){
          this.privatepay = privatepay;
      }
      public Integer getSchip(){
          return schip;
      }
      public void setSchip(Integer schip){
          this.schip = schip;
      }
      public Integer getStatehealthins(){
          return statehealthins;
      }
      public void setStatehealthins(Integer statehealthins){
          this.statehealthins = statehealthins;
      }
      public Integer getVamedicalservices(){
          return vamedicalservices;
      }
      public void setVamedicalservices(Integer vamedicalservices){
          this.vamedicalservices = vamedicalservices;
      }

 }
