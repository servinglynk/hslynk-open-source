package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("healthinsurance")
public class Healthinsurance extends ClientModel{


      private UUID healthinsuranceId;

      private Integer insurancefromanysource;

      private Integer medicaid;

      private Integer nomedicaidreason;

      private Integer medicare;

      private Integer nomedicarereason;

      private Integer schip;

      private Integer noschipreason;

      private Integer vamedicalservices;

      private Integer novamedreason;

      private Integer employerprovided;

      private Integer noemployerprovidedreason;

      private Integer cobra;

      private Integer nocobrareason;

      private Integer privatepay;

      private Integer noprivatepayreason;

      private Integer statehealthins;

      private Integer nostatehealthinsreason;

      private Integer otherSource;

      private String otherSourceIdentify;
      private LocalDateTime informationDate;
      private Integer dataCollectionStage;

      public LocalDateTime getInformationDate() {
		return informationDate;
	}
	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
	public Integer getDataCollectionStage() {
		return dataCollectionStage;
	}
	public void setDataCollectionStage(Integer dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
}


      public UUID getHealthinsuranceId(){
          return healthinsuranceId;
      }
      public void setHealthinsuranceId(UUID healthinsuranceId){
          this.healthinsuranceId = healthinsuranceId;
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
      public Integer getNomedicaidreason(){
          return nomedicaidreason;
      }
      public void setNomedicaidreason(Integer nomedicaidreason){
          this.nomedicaidreason = nomedicaidreason;
      }
      public Integer getMedicare(){
          return medicare;
      }
      public void setMedicare(Integer medicare){
          this.medicare = medicare;
      }
      public Integer getNomedicarereason(){
          return nomedicarereason;
      }
      public void setNomedicarereason(Integer nomedicarereason){
          this.nomedicarereason = nomedicarereason;
      }
      public Integer getSchip(){
          return schip;
      }
      public void setSchip(Integer schip){
          this.schip = schip;
      }
      public Integer getNoschipreason(){
          return noschipreason;
      }
      public void setNoschipreason(Integer noschipreason){
          this.noschipreason = noschipreason;
      }
      public Integer getVamedicalservices(){
          return vamedicalservices;
      }
      public void setVamedicalservices(Integer vamedicalservices){
          this.vamedicalservices = vamedicalservices;
      }
      public Integer getNovamedreason(){
          return novamedreason;
      }
      public void setNovamedreason(Integer novamedreason){
          this.novamedreason = novamedreason;
      }
      public Integer getEmployerprovided(){
          return employerprovided;
      }
      public void setEmployerprovided(Integer employerprovided){
          this.employerprovided = employerprovided;
      }
      public Integer getNoemployerprovidedreason(){
          return noemployerprovidedreason;
      }
      public void setNoemployerprovidedreason(Integer noemployerprovidedreason){
          this.noemployerprovidedreason = noemployerprovidedreason;
      }
      public Integer getCobra(){
          return cobra;
      }
      public void setCobra(Integer cobra){
          this.cobra = cobra;
      }
      public Integer getNocobrareason(){
          return nocobrareason;
      }
      public void setNocobrareason(Integer nocobrareason){
          this.nocobrareason = nocobrareason;
      }
      public Integer getPrivatepay(){
          return privatepay;
      }
      public void setPrivatepay(Integer privatepay){
          this.privatepay = privatepay;
      }
      public Integer getNoprivatepayreason(){
          return noprivatepayreason;
      }
      public void setNoprivatepayreason(Integer noprivatepayreason){
          this.noprivatepayreason = noprivatepayreason;
      }
      public Integer getStatehealthins(){
          return statehealthins;
      }
      public void setStatehealthins(Integer statehealthins){
          this.statehealthins = statehealthins;
      }
      public Integer getNostatehealthinsreason(){
          return nostatehealthinsreason;
      }
      public void setNostatehealthinsreason(Integer nostatehealthinsreason){
          this.nostatehealthinsreason = nostatehealthinsreason;
      }
      public Integer getOtherSource(){
          return otherSource;
      }
      public void setOtherSource(Integer otherSource){
          this.otherSource = otherSource;
      }
      public String getOtherSourceIdentify(){
          return otherSourceIdentify;
      }
      public void setOtherSourceIdentify(String otherSourceIdentify){
          this.otherSourceIdentify = otherSourceIdentify;
      }

 }
