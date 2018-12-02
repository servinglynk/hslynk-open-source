package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("entryrhy")
public class Entryrhy extends ClientModel{


      private UUID entryrhyId;

      private Integer sexualOrientation;

      private Integer formerlyWardChildWelfrForestCare;

      private Integer yearsChildWelfrForestCare;

      private Integer monthsChildWelfrForestCare;

      private Integer formerlyWardOfJuvenileJustice;

      private Integer yearsJuvenileJustice;
      
      private Integer monthsJuvenileJustice;

      private Integer unemployementFamilyMbr;

      private Integer mentalHealthIssuesFamilyMbr;

      private Integer healthIssuesFamilyMbr;

      private Integer physicalDisabilityFamilyMbr;

      private Integer alcoholDrugAbuseFamilyMbr;

      private Integer insufficientIncomeToSupportYouth;

      private Integer incarceratedParent;

      private Integer referralSource;

      private Integer countOutReachReferralApproaches;
      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
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


      public UUID getEntryrhyId(){
          return entryrhyId;
      }
      public void setEntryrhyId(UUID entryrhyId){
          this.entryrhyId = entryrhyId;
      }
      public Integer getSexualOrientation(){
          return sexualOrientation;
      }
      public void setSexualOrientation(Integer sexualOrientation){
          this.sexualOrientation = sexualOrientation;
      }
      public Integer getFormerlyWardChildWelfrForestCare(){
          return formerlyWardChildWelfrForestCare;
      }
      public void setFormerlyWardChildWelfrForestCare(Integer formerlyWardChildWelfrForestCare){
          this.formerlyWardChildWelfrForestCare = formerlyWardChildWelfrForestCare;
      }
      public Integer getYearsChildWelfrForestCare(){
          return yearsChildWelfrForestCare;
      }
      public void setYearsChildWelfrForestCare(Integer yearsChildWelfrForestCare){
          this.yearsChildWelfrForestCare = yearsChildWelfrForestCare;
      }
      public Integer getMonthsChildWelfrForestCare(){
          return monthsChildWelfrForestCare;
      }
      public void setMonthsChildWelfrForestCare(Integer monthsChildWelfrForestCare){
          this.monthsChildWelfrForestCare = monthsChildWelfrForestCare;
      }
      public Integer getFormerlyWardOfJuvenileJustice(){
          return formerlyWardOfJuvenileJustice;
      }
      public void setFormerlyWardOfJuvenileJustice(Integer formerlyWardOfJuvenileJustice){
          this.formerlyWardOfJuvenileJustice = formerlyWardOfJuvenileJustice;
      }
      public Integer getYearsJuvenileJustice(){
          return yearsJuvenileJustice;
      }
      public void setYearsJuvenileJustice(Integer yearsJuvenileJustice){
          this.yearsJuvenileJustice = yearsJuvenileJustice;
      }
      public Integer getUnemployementFamilyMbr(){
          return unemployementFamilyMbr;
      }
      public void setUnemployementFamilyMbr(Integer unemployementFamilyMbr){
          this.unemployementFamilyMbr = unemployementFamilyMbr;
      }
      public Integer getMentalHealthIssuesFamilyMbr(){
          return mentalHealthIssuesFamilyMbr;
      }
      public void setMentalHealthIssuesFamilyMbr(Integer mentalHealthIssuesFamilyMbr){
          this.mentalHealthIssuesFamilyMbr = mentalHealthIssuesFamilyMbr;
      }
      public Integer getHealthIssuesFamilyMbr(){
          return healthIssuesFamilyMbr;
      }
      public void setHealthIssuesFamilyMbr(Integer healthIssuesFamilyMbr){
          this.healthIssuesFamilyMbr = healthIssuesFamilyMbr;
      }
      public Integer getPhysicalDisabilityFamilyMbr(){
          return physicalDisabilityFamilyMbr;
      }
      public void setPhysicalDisabilityFamilyMbr(Integer physicalDisabilityFamilyMbr){
          this.physicalDisabilityFamilyMbr = physicalDisabilityFamilyMbr;
      }
      public Integer getAlcoholDrugAbuseFamilyMbr(){
          return alcoholDrugAbuseFamilyMbr;
      }
      public void setAlcoholDrugAbuseFamilyMbr(Integer alcoholDrugAbuseFamilyMbr){
          this.alcoholDrugAbuseFamilyMbr = alcoholDrugAbuseFamilyMbr;
      }
      public Integer getInsufficientIncomeToSupportYouth(){
          return insufficientIncomeToSupportYouth;
      }
      public void setInsufficientIncomeToSupportYouth(Integer insufficientIncomeToSupportYouth){
          this.insufficientIncomeToSupportYouth = insufficientIncomeToSupportYouth;
      }
      public Integer getIncarceratedParent(){
          return incarceratedParent;
      }
      public void setIncarceratedParent(Integer incarceratedParent){
          this.incarceratedParent = incarceratedParent;
      }
      public Integer getReferralSource(){
          return referralSource;
      }
      public void setReferralSource(Integer referralSource){
          this.referralSource = referralSource;
      }
      public Integer getCountOutReachReferralApproaches(){
          return countOutReachReferralApproaches;
      }
      public void setCountOutReachReferralApproaches(Integer countOutReachReferralApproaches){
          this.countOutReachReferralApproaches = countOutReachReferralApproaches;
      }
	/**
	 * @return the monthsJuvenileJustice
	 */
	public Integer getMonthsJuvenileJustice() {
		return monthsJuvenileJustice;
	}
	/**
	 * @param monthsJuvenileJustice the monthsJuvenileJustice to set
	 */
	public void setMonthsJuvenileJustice(Integer monthsJuvenileJustice) {
		this.monthsJuvenileJustice = monthsJuvenileJustice;
	}
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
	 LocalDateTime submissionDate;

     public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}
	

 }
