package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthInsurance")
public class HealthInsurance extends ClientModel{


      private UUID healthInsuranceId;

      private Integer cobra;

      private Integer employerprovided;

      private String insurancefromanysource;

      private String medicaid;

      private String medicare;

      private String nocobrareason;

      private String noemployerprovidedreason;

      private String nomedicaidreason;

      private String nomedicarereason;

      private String noprivatepayreason;

      private String noschipreason;

      private String nostatehealthinsreason;

      private String novamedreason;

      private String privatepay;

      private String schip;

      private String statehealthins;

      private String vamedicalservices;



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
      public String getInsurancefromanysource(){
          return insurancefromanysource;
      }
      public void setInsurancefromanysource(String insurancefromanysource){
          this.insurancefromanysource = insurancefromanysource;
      }
      public String getMedicaid(){
          return medicaid;
      }
      public void setMedicaid(String medicaid){
          this.medicaid = medicaid;
      }
      public String getMedicare(){
          return medicare;
      }
      public void setMedicare(String medicare){
          this.medicare = medicare;
      }
      public String getNocobrareason(){
          return nocobrareason;
      }
      public void setNocobrareason(String nocobrareason){
          this.nocobrareason = nocobrareason;
      }
      public String getNoemployerprovidedreason(){
          return noemployerprovidedreason;
      }
      public void setNoemployerprovidedreason(String noemployerprovidedreason){
          this.noemployerprovidedreason = noemployerprovidedreason;
      }
      public String getNomedicaidreason(){
          return nomedicaidreason;
      }
      public void setNomedicaidreason(String nomedicaidreason){
          this.nomedicaidreason = nomedicaidreason;
      }
      public String getNomedicarereason(){
          return nomedicarereason;
      }
      public void setNomedicarereason(String nomedicarereason){
          this.nomedicarereason = nomedicarereason;
      }
      public String getNoprivatepayreason(){
          return noprivatepayreason;
      }
      public void setNoprivatepayreason(String noprivatepayreason){
          this.noprivatepayreason = noprivatepayreason;
      }
      public String getNoschipreason(){
          return noschipreason;
      }
      public void setNoschipreason(String noschipreason){
          this.noschipreason = noschipreason;
      }
      public String getNostatehealthinsreason(){
          return nostatehealthinsreason;
      }
      public void setNostatehealthinsreason(String nostatehealthinsreason){
          this.nostatehealthinsreason = nostatehealthinsreason;
      }
      public String getNovamedreason(){
          return novamedreason;
      }
      public void setNovamedreason(String novamedreason){
          this.novamedreason = novamedreason;
      }
      public String getPrivatepay(){
          return privatepay;
      }
      public void setPrivatepay(String privatepay){
          this.privatepay = privatepay;
      }
      public String getSchip(){
          return schip;
      }
      public void setSchip(String schip){
          this.schip = schip;
      }
      public String getStatehealthins(){
          return statehealthins;
      }
      public void setStatehealthins(String statehealthins){
          this.statehealthins = statehealthins;
      }
      public String getVamedicalservices(){
          return vamedicalservices;
      }
      public void setVamedicalservices(String vamedicalservices){
          this.vamedicalservices = vamedicalservices;
      }

 }
