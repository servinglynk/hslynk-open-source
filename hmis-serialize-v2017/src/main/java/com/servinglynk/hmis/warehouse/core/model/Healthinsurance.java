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

      private Integer statehealthinadults;
      
      private Integer nostatehealthinsreason;

      private Integer otherInsurance;

      private String otherInsuranceIdentify;
      private Integer indianHealthServices;
      private Integer noIndianHealthServicesReason;
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
      public Integer getNostatehealthinsreason(){
          return nostatehealthinsreason;
      }
      public void setNostatehealthinsreason(Integer nostatehealthinsreason){
          this.nostatehealthinsreason = nostatehealthinsreason;
      }
	/**
	 * @return the statehealthinadults
	 */
	public Integer getStatehealthinadults() {
		return statehealthinadults;
	}
	/**
	 * @param statehealthinadults the statehealthinadults to set
	 */
	public void setStatehealthinadults(Integer statehealthinadults) {
		this.statehealthinadults = statehealthinadults;
	}
	/**
	 * @return the otherInsurance
	 */
	public Integer getOtherInsurance() {
		return otherInsurance;
	}
	/**
	 * @param otherInsurance the otherInsurance to set
	 */
	public void setOtherInsurance(Integer otherInsurance) {
		this.otherInsurance = otherInsurance;
	}
	/**
	 * @return the otherInsuranceIdentify
	 */
	public String getOtherInsuranceIdentify() {
		return otherInsuranceIdentify;
	}
	/**
	 * @param otherInsuranceIdentify the otherInsuranceIdentify to set
	 */
	public void setOtherInsuranceIdentify(String otherInsuranceIdentify) {
		this.otherInsuranceIdentify = otherInsuranceIdentify;
	}
	/**
	 * @return the indianHealthServices
	 */
	public Integer getIndianHealthServices() {
		return indianHealthServices;
	}
	/**
	 * @param indianHealthServices the indianHealthServices to set
	 */
	public void setIndianHealthServices(Integer indianHealthServices) {
		this.indianHealthServices = indianHealthServices;
	}
	/**
	 * @return the noIndianHealthServicesReason
	 */
	public Integer getNoIndianHealthServicesReason() {
		return noIndianHealthServicesReason;
	}
	/**
	 * @param noIndianHealthServicesReason the noIndianHealthServicesReason to set
	 */
	public void setNoIndianHealthServicesReason(Integer noIndianHealthServicesReason) {
		this.noIndianHealthServicesReason = noIndianHealthServicesReason;
	}

 }
