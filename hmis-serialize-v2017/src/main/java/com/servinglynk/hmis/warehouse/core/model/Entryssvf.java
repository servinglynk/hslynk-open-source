package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("entryssvf")
public class Entryssvf extends ClientModel{


      private UUID entryssvfId;

      @JsonProperty("percentAmi")
      private Integer percentami;

      private String lastPermanentStreet;

      private String lastPermanentCity;

      private String lastPermanentState;

      private String lastPermanentZip;

      private Integer addressDataQuality;
  	@JsonProperty("hpScreenScore")
      private Integer hpScreenScore;
	@JsonProperty("vamcStaction")
      private String vamcStaction;
  	private Integer timeToHousingLoss;
  	@JsonProperty("zeroIncome")
  	private Integer zeroincome;
  	@JsonProperty("annualPercentAmi")
  	private Integer annualpercentami;
	@JsonProperty("financialChange")
  	private Integer financialchange;
	@JsonProperty("householdChange")
  	private Integer householdchange;
  	@JsonProperty("evictionHistory")
  	private Integer evictionhistory;
  	@JsonProperty("subsidyAtRisk")
  	private Integer subsidyatrisk;
  	@JsonProperty("literalHomelessHistory")
  	private Integer literalhomelesshistory;
  	@JsonProperty("disableHoh")
  	private Integer disablehoh;
  	@JsonProperty("criminalRecord")
  	private Integer criminalrecord;
  	@JsonProperty("sexOffender")
  	private Integer sexoffender;
  	@JsonProperty("dependendUnder6")
  	private Integer dependendunder6;
  	@JsonProperty("singleParent")
  	private Integer singleparent;
  	@JsonProperty("hh5Plus")
  	private Integer hh5plus;
  	@JsonProperty("iraqAfghanistan")
  	private Integer iraqafghanistan;
  	private Integer femvet;
  	@JsonProperty("thresholdScore")
  	private Integer thresholdscore;
  	private Integer ervisits;
  	private Integer jailnights;
  	private Integer hospitalnights;
  	private Integer urgentReferral;



      public UUID getEntryssvfId(){
          return entryssvfId;
      }
      public void setEntryssvfId(UUID entryssvfId){
          this.entryssvfId = entryssvfId;
      }
      public Integer getPercentami(){
          return percentami;
      }
      public void setPercentami(Integer percentami){
          this.percentami = percentami;
      }
      public String getLastPermanentStreet(){
          return lastPermanentStreet;
      }
      public void setLastPermanentStreet(String lastPermanentStreet){
          this.lastPermanentStreet = lastPermanentStreet;
      }
      public String getLastPermanentCity(){
          return lastPermanentCity;
      }
      public void setLastPermanentCity(String lastPermanentCity){
          this.lastPermanentCity = lastPermanentCity;
      }
      public String getLastPermanentState(){
          return lastPermanentState;
      }
      public void setLastPermanentState(String lastPermanentState){
          this.lastPermanentState = lastPermanentState;
      }
      public String getLastPermanentZip(){
          return lastPermanentZip;
      }
      public void setLastPermanentZip(String lastPermanentZip){
          this.lastPermanentZip = lastPermanentZip;
      }
      public Integer getAddressDataQuality(){
          return addressDataQuality;
      }
      public void setAddressDataQuality(Integer addressDataQuality){
          this.addressDataQuality = addressDataQuality;
      }
      public Integer getHpScreenScore(){
          return hpScreenScore;
      }
      public void setHpScreenScore(Integer hpScreenScore){
          this.hpScreenScore = hpScreenScore;
      }
      public String getVamcStaction(){
          return vamcStaction;
      }
      public void setVamcStaction(String vamcStaction){
          this.vamcStaction = vamcStaction;
      }
	/**
	 * @return the timeToHousingLoss
	 */
	public Integer getTimeToHousingLoss() {
		return timeToHousingLoss;
	}
	/**
	 * @param timeToHousingLoss the timeToHousingLoss to set
	 */
	public void setTimeToHousingLoss(Integer timeToHousingLoss) {
		this.timeToHousingLoss = timeToHousingLoss;
	}
	/**
	 * @return the zeroincome
	 */
	public Integer getZeroincome() {
		return zeroincome;
	}
	/**
	 * @param zeroincome the zeroincome to set
	 */
	public void setZeroincome(Integer zeroincome) {
		this.zeroincome = zeroincome;
	}
	/**
	 * @return the annualpercentami
	 */
	public Integer getAnnualpercentami() {
		return annualpercentami;
	}
	/**
	 * @param annualpercentami the annualpercentami to set
	 */
	public void setAnnualpercentami(Integer annualpercentami) {
		this.annualpercentami = annualpercentami;
	}
	/**
	 * @return the financialchange
	 */
	public Integer getFinancialchange() {
		return financialchange;
	}
	/**
	 * @param financialchange the financialchange to set
	 */
	public void setFinancialchange(Integer financialchange) {
		this.financialchange = financialchange;
	}
	/**
	 * @return the householdchange
	 */
	public Integer getHouseholdchange() {
		return householdchange;
	}
	/**
	 * @param householdchange the householdchange to set
	 */
	public void setHouseholdchange(Integer householdchange) {
		this.householdchange = householdchange;
	}
	/**
	 * @return the evictionhistory
	 */
	public Integer getEvictionhistory() {
		return evictionhistory;
	}
	/**
	 * @param evictionhistory the evictionhistory to set
	 */
	public void setEvictionhistory(Integer evictionhistory) {
		this.evictionhistory = evictionhistory;
	}
	/**
	 * @return the subsidyatrisk
	 */
	public Integer getSubsidyatrisk() {
		return subsidyatrisk;
	}
	/**
	 * @param subsidyatrisk the subsidyatrisk to set
	 */
	public void setSubsidyatrisk(Integer subsidyatrisk) {
		this.subsidyatrisk = subsidyatrisk;
	}
	/**
	 * @return the literalhomelesshistory
	 */
	public Integer getLiteralhomelesshistory() {
		return literalhomelesshistory;
	}
	/**
	 * @param literalhomelesshistory the literalhomelesshistory to set
	 */
	public void setLiteralhomelesshistory(Integer literalhomelesshistory) {
		this.literalhomelesshistory = literalhomelesshistory;
	}
	/**
	 * @return the disablehoh
	 */
	public Integer getDisablehoh() {
		return disablehoh;
	}
	/**
	 * @param disablehoh the disablehoh to set
	 */
	public void setDisablehoh(Integer disablehoh) {
		this.disablehoh = disablehoh;
	}
	/**
	 * @return the criminalrecord
	 */
	public Integer getCriminalrecord() {
		return criminalrecord;
	}
	/**
	 * @param criminalrecord the criminalrecord to set
	 */
	public void setCriminalrecord(Integer criminalrecord) {
		this.criminalrecord = criminalrecord;
	}
	/**
	 * @return the sexoffender
	 */
	public Integer getSexoffender() {
		return sexoffender;
	}
	/**
	 * @param sexoffender the sexoffender to set
	 */
	public void setSexoffender(Integer sexoffender) {
		this.sexoffender = sexoffender;
	}
	/**
	 * @return the dependendunder6
	 */
	public Integer getDependendunder6() {
		return dependendunder6;
	}
	/**
	 * @param dependendunder6 the dependendunder6 to set
	 */
	public void setDependendunder6(Integer dependendunder6) {
		this.dependendunder6 = dependendunder6;
	}
	/**
	 * @return the singleparent
	 */
	public Integer getSingleparent() {
		return singleparent;
	}
	/**
	 * @param singleparent the singleparent to set
	 */
	public void setSingleparent(Integer singleparent) {
		this.singleparent = singleparent;
	}
	/**
	 * @return the hh5plus
	 */
	public Integer getHh5plus() {
		return hh5plus;
	}
	/**
	 * @param hh5plus the hh5plus to set
	 */
	public void setHh5plus(Integer hh5plus) {
		this.hh5plus = hh5plus;
	}
	/**
	 * @return the iraqafghanistan
	 */
	public Integer getIraqafghanistan() {
		return iraqafghanistan;
	}
	/**
	 * @param iraqafghanistan the iraqafghanistan to set
	 */
	public void setIraqafghanistan(Integer iraqafghanistan) {
		this.iraqafghanistan = iraqafghanistan;
	}
	/**
	 * @return the femvet
	 */
	public Integer getFemvet() {
		return femvet;
	}
	/**
	 * @param femvet the femvet to set
	 */
	public void setFemvet(Integer femvet) {
		this.femvet = femvet;
	}
	/**
	 * @return the thresholdscore
	 */
	public Integer getThresholdscore() {
		return thresholdscore;
	}
	/**
	 * @param thresholdscore the thresholdscore to set
	 */
	public void setThresholdscore(Integer thresholdscore) {
		this.thresholdscore = thresholdscore;
	}
	/**
	 * @return the ervisits
	 */
	public Integer getErvisits() {
		return ervisits;
	}
	/**
	 * @param ervisits the ervisits to set
	 */
	public void setErvisits(Integer ervisits) {
		this.ervisits = ervisits;
	}
	/**
	 * @return the jailnights
	 */
	public Integer getJailnights() {
		return jailnights;
	}
	/**
	 * @param jailnights the jailnights to set
	 */
	public void setJailnights(Integer jailnights) {
		this.jailnights = jailnights;
	}
	/**
	 * @return the hospitalnights
	 */
	public Integer getHospitalnights() {
		return hospitalnights;
	}
	/**
	 * @param hospitalnights the hospitalnights to set
	 */
	public void setHospitalnights(Integer hospitalnights) {
		this.hospitalnights = hospitalnights;
	}
	public Integer getUrgentReferral() {
		return urgentReferral;
	}
	public void setUrgentReferral(Integer urgentReferral) {
		this.urgentReferral = urgentReferral;
	}
    @JsonSerialize(using=JsonDateTimeSerializer.class)
	 LocalDateTime submissionDate;

     public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}
	
}