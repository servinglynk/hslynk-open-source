package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("entryrhy")
public class Entryrhy extends ClientModel{


      private UUID entryrhyId;

      private Integer sexualOrientation;

      private Integer formerlyWardChildWelfrForestCare;

      private Integer yearsChildWelfrForestCare;

      private Integer monthsChildWelfrForestCare;

      private Integer formerlyWardOfJuvenileJustice;

      private Integer yearsJuvenileJustice;

      private Integer houseHoldDynamics;

      private Integer sexualOrientatiionGenderIdentityYouth;

      private Integer sexualOrientatiionGenderIdentityFamilyMbr;

      private Integer housingIssuesYouth;

      private Integer housingIssuesFamilyMbr;

      private Integer schoolEducationIssuesYouth;

      private Integer schoolEducationIssuesFamilyMbr;

      private Integer unemployementYouth;

      private Integer unemployementFamilyMbr;

      private Integer mentalHealthIssuesYouth;

      private Integer mentalHealthIssuesFamilyMbr;

      private Integer healthIssuesYouth;

      private Integer healthIssuesFamilyMbr;

      private Integer physicalDisabilityYouth;

      private Integer physicalDisabilityFamilyMbr;

      private Integer mentalDisabilityYouth;

      private Integer mentalDisabilityFamilyMbr;

      private Integer abuseAndNeglectYouth;

      private Integer abuseAndNeglectFamilyMbr;

      private Integer alcoholDrugAbuseYouth;

      private Integer alcoholDrugAbuseFamilyMbr;

      private Integer insufficientIncomeToSupportYouth;

      private Integer activeMilitaryParent;

      private Integer incarceratedParent;

      private Integer incarceratedParentStatus;

      private Integer referralSource;

      private Integer countOutReachReferralApproaches;

      private Integer exchangeForSex;

      private Integer exchangeForSexPastThreeMonths;

      private Integer countOfExchangeForSex;

      private Integer askedOfForcedToExchangeForSex;

      private Integer askedOfForcedToExchangeForSexPastThreeMonths;

      private Integer workPlaceViolenceThreat;

      private Integer workPlacePromiseDifference;

      private Integer coercedToContinueWork;

      private Integer laborExploitPastThreeMonths;
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
      public Integer getHouseHoldDynamics(){
          return houseHoldDynamics;
      }
      public void setHouseHoldDynamics(Integer houseHoldDynamics){
          this.houseHoldDynamics = houseHoldDynamics;
      }
      public Integer getSexualOrientatiionGenderIdentityYouth(){
          return sexualOrientatiionGenderIdentityYouth;
      }
      public void setSexualOrientatiionGenderIdentityYouth(Integer sexualOrientatiionGenderIdentityYouth){
          this.sexualOrientatiionGenderIdentityYouth = sexualOrientatiionGenderIdentityYouth;
      }
      public Integer getSexualOrientatiionGenderIdentityFamilyMbr(){
          return sexualOrientatiionGenderIdentityFamilyMbr;
      }
      public void setSexualOrientatiionGenderIdentityFamilyMbr(Integer sexualOrientatiionGenderIdentityFamilyMbr){
          this.sexualOrientatiionGenderIdentityFamilyMbr = sexualOrientatiionGenderIdentityFamilyMbr;
      }
      public Integer getHousingIssuesYouth(){
          return housingIssuesYouth;
      }
      public void setHousingIssuesYouth(Integer housingIssuesYouth){
          this.housingIssuesYouth = housingIssuesYouth;
      }
      public Integer getHousingIssuesFamilyMbr(){
          return housingIssuesFamilyMbr;
      }
      public void setHousingIssuesFamilyMbr(Integer housingIssuesFamilyMbr){
          this.housingIssuesFamilyMbr = housingIssuesFamilyMbr;
      }
      public Integer getSchoolEducationIssuesYouth(){
          return schoolEducationIssuesYouth;
      }
      public void setSchoolEducationIssuesYouth(Integer schoolEducationIssuesYouth){
          this.schoolEducationIssuesYouth = schoolEducationIssuesYouth;
      }
      public Integer getSchoolEducationIssuesFamilyMbr(){
          return schoolEducationIssuesFamilyMbr;
      }
      public void setSchoolEducationIssuesFamilyMbr(Integer schoolEducationIssuesFamilyMbr){
          this.schoolEducationIssuesFamilyMbr = schoolEducationIssuesFamilyMbr;
      }
      public Integer getUnemployementYouth(){
          return unemployementYouth;
      }
      public void setUnemployementYouth(Integer unemployementYouth){
          this.unemployementYouth = unemployementYouth;
      }
      public Integer getUnemployementFamilyMbr(){
          return unemployementFamilyMbr;
      }
      public void setUnemployementFamilyMbr(Integer unemployementFamilyMbr){
          this.unemployementFamilyMbr = unemployementFamilyMbr;
      }
      public Integer getMentalHealthIssuesYouth(){
          return mentalHealthIssuesYouth;
      }
      public void setMentalHealthIssuesYouth(Integer mentalHealthIssuesYouth){
          this.mentalHealthIssuesYouth = mentalHealthIssuesYouth;
      }
      public Integer getMentalHealthIssuesFamilyMbr(){
          return mentalHealthIssuesFamilyMbr;
      }
      public void setMentalHealthIssuesFamilyMbr(Integer mentalHealthIssuesFamilyMbr){
          this.mentalHealthIssuesFamilyMbr = mentalHealthIssuesFamilyMbr;
      }
      public Integer getHealthIssuesYouth(){
          return healthIssuesYouth;
      }
      public void setHealthIssuesYouth(Integer healthIssuesYouth){
          this.healthIssuesYouth = healthIssuesYouth;
      }
      public Integer getHealthIssuesFamilyMbr(){
          return healthIssuesFamilyMbr;
      }
      public void setHealthIssuesFamilyMbr(Integer healthIssuesFamilyMbr){
          this.healthIssuesFamilyMbr = healthIssuesFamilyMbr;
      }
      public Integer getPhysicalDisabilityYouth(){
          return physicalDisabilityYouth;
      }
      public void setPhysicalDisabilityYouth(Integer physicalDisabilityYouth){
          this.physicalDisabilityYouth = physicalDisabilityYouth;
      }
      public Integer getPhysicalDisabilityFamilyMbr(){
          return physicalDisabilityFamilyMbr;
      }
      public void setPhysicalDisabilityFamilyMbr(Integer physicalDisabilityFamilyMbr){
          this.physicalDisabilityFamilyMbr = physicalDisabilityFamilyMbr;
      }
      public Integer getMentalDisabilityYouth(){
          return mentalDisabilityYouth;
      }
      public void setMentalDisabilityYouth(Integer mentalDisabilityYouth){
          this.mentalDisabilityYouth = mentalDisabilityYouth;
      }
      public Integer getMentalDisabilityFamilyMbr(){
          return mentalDisabilityFamilyMbr;
      }
      public void setMentalDisabilityFamilyMbr(Integer mentalDisabilityFamilyMbr){
          this.mentalDisabilityFamilyMbr = mentalDisabilityFamilyMbr;
      }
      public Integer getAbuseAndNeglectYouth(){
          return abuseAndNeglectYouth;
      }
      public void setAbuseAndNeglectYouth(Integer abuseAndNeglectYouth){
          this.abuseAndNeglectYouth = abuseAndNeglectYouth;
      }
      public Integer getAbuseAndNeglectFamilyMbr(){
          return abuseAndNeglectFamilyMbr;
      }
      public void setAbuseAndNeglectFamilyMbr(Integer abuseAndNeglectFamilyMbr){
          this.abuseAndNeglectFamilyMbr = abuseAndNeglectFamilyMbr;
      }
      public Integer getAlcoholDrugAbuseYouth(){
          return alcoholDrugAbuseYouth;
      }
      public void setAlcoholDrugAbuseYouth(Integer alcoholDrugAbuseYouth){
          this.alcoholDrugAbuseYouth = alcoholDrugAbuseYouth;
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
      public Integer getActiveMilitaryParent(){
          return activeMilitaryParent;
      }
      public void setActiveMilitaryParent(Integer activeMilitaryParent){
          this.activeMilitaryParent = activeMilitaryParent;
      }
      public Integer getIncarceratedParent(){
          return incarceratedParent;
      }
      public void setIncarceratedParent(Integer incarceratedParent){
          this.incarceratedParent = incarceratedParent;
      }
      public Integer getIncarceratedParentStatus(){
          return incarceratedParentStatus;
      }
      public void setIncarceratedParentStatus(Integer incarceratedParentStatus){
          this.incarceratedParentStatus = incarceratedParentStatus;
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
      public Integer getExchangeForSex(){
          return exchangeForSex;
      }
      public void setExchangeForSex(Integer exchangeForSex){
          this.exchangeForSex = exchangeForSex;
      }
      public Integer getExchangeForSexPastThreeMonths(){
          return exchangeForSexPastThreeMonths;
      }
      public void setExchangeForSexPastThreeMonths(Integer exchangeForSexPastThreeMonths){
          this.exchangeForSexPastThreeMonths = exchangeForSexPastThreeMonths;
      }
      public Integer getCountOfExchangeForSex(){
          return countOfExchangeForSex;
      }
      public void setCountOfExchangeForSex(Integer countOfExchangeForSex){
          this.countOfExchangeForSex = countOfExchangeForSex;
      }
      public Integer getAskedOfForcedToExchangeForSex(){
          return askedOfForcedToExchangeForSex;
      }
      public void setAskedOfForcedToExchangeForSex(Integer askedOfForcedToExchangeForSex){
          this.askedOfForcedToExchangeForSex = askedOfForcedToExchangeForSex;
      }
      public Integer getAskedOfForcedToExchangeForSexPastThreeMonths(){
          return askedOfForcedToExchangeForSexPastThreeMonths;
      }
      public void setAskedOfForcedToExchangeForSexPastThreeMonths(Integer askedOfForcedToExchangeForSexPastThreeMonths){
          this.askedOfForcedToExchangeForSexPastThreeMonths = askedOfForcedToExchangeForSexPastThreeMonths;
      }
      public Integer getWorkPlaceViolenceThreat(){
          return workPlaceViolenceThreat;
      }
      public void setWorkPlaceViolenceThreat(Integer workPlaceViolenceThreat){
          this.workPlaceViolenceThreat = workPlaceViolenceThreat;
      }
      public Integer getWorkPlacePromiseDifference(){
          return workPlacePromiseDifference;
      }
      public void setWorkPlacePromiseDifference(Integer workPlacePromiseDifference){
          this.workPlacePromiseDifference = workPlacePromiseDifference;
      }
      public Integer getCoercedToContinueWork(){
          return coercedToContinueWork;
      }
      public void setCoercedToContinueWork(Integer coercedToContinueWork){
          this.coercedToContinueWork = coercedToContinueWork;
      }
      public Integer getLaborExploitPastThreeMonths(){
          return laborExploitPastThreeMonths;
      }
      public void setLaborExploitPastThreeMonths(Integer laborExploitPastThreeMonths){
          this.laborExploitPastThreeMonths = laborExploitPastThreeMonths;
      }

 }
