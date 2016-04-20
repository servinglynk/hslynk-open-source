package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Entryrhy extends BaseModel {

	
	@Column( name = "abuse_and_neglect_family_mbr")
	private Integer abuseAndNeglectFamilyMbr;
	@Column( name = "abuse_and_neglect_youth")
	private Integer abuseAndNeglectYouth;
	@Column( name = "active_military_parent")
	private Integer activeMilitaryParent;
	@Column( name = "alcohol_drug_abuse_family_mbr")
	private Integer alcoholDrugAbuseFamilyMbr;
	@Column( name = "alcohol_drug_abuse_youth")
	private Integer alcoholDrugAbuseYouth;
	@Column( name = "asked_of_forced_to_exchange_for_sex")
	private Integer askedOfForcedToExchangeForSex;
	@Column( name = "asked_of_forced_to_exchange_for_sex_past_three_months")
	private Integer askedOfForcedToExchangeForSexPastThreeMonths;
	@Column( name = "coerced_to_continue_work")
	private Integer coercedToContinueWork;
	@Column( name = "count_of_exchange_for_sex")
	private Integer countOfExchangeForSex;
	@Column( name = "count_out_reach_referral_approaches")
	private Integer countOutReachReferralApproaches;
	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;
	@Column( name = "exchange_for_sex")
	private Integer exchangeForSex;
	@Column( name = "exchange_for_sex_past_three_months")
	private Integer exchangeForSexPastThreeMonths;
	@Column( name = "formerly_ward_child_welfr_forest_care")
	private Integer formerlyWardChildWelfrForestCare;
	@Column( name = "formerly_ward_of_juvenile_justice")
	private Integer formerlyWardOfJuvenileJustice;
	@Column( name = "health_issues_family_mbr")
	private Integer healthIssuesFamilyMbr;
	@Column( name = "health_issues_youth")
	private Integer healthIssuesYouth;
	@Column( name = "house_hold_dynamics")
	private Integer houseHoldDynamics;
	@Column( name = "housing_issues_family_mbr")
	private Integer housingIssuesFamilyMbr;
	@Column( name = "housing_issues_youth")
	private Integer housingIssuesYouth;
	@Column( name = "id")
	private java.util.UUID id;
	@Column( name = "incarcerated_parent")
	private Integer incarceratedParent;
	@Column( name = "incarcerated_parent_status")
	private Integer incarceratedParentStatus;
	@Column( name = "insufficient_income_to_support_youth")
	private Integer insufficientIncomeToSupportYouth;
	@Column( name = "labor_exploit_past_three_months")
	private Integer laborExploitPastThreeMonths;
	@Column( name = "mental_disability_family_mbr")
	private Integer mentalDisabilityFamilyMbr;
	@Column( name = "mental_disability_youth")
	private Integer mentalDisabilityYouth;
	@Column( name = "mental_health_issues_family_mbr")
	private Integer mentalHealthIssuesFamilyMbr;
	@Column( name = "mental_health_issues_youth")
	private Integer mentalHealthIssuesYouth;
	@Column( name = "months_child_welfr_forest_care")
	private Integer monthsChildWelfrForestCare;
	@Column( name = "physical_disability_family_mbr")
	private Integer physicalDisabilityFamilyMbr;
	@Column( name = "physical_disability_youth")
	private Integer physicalDisabilityYouth;
	@Column( name = "referral_source")
	private Integer referralSource;
	@Column( name = "school_education_issues_family_mbr")
	private Integer schoolEducationIssuesFamilyMbr;
	@Column( name = "school_education_issues_youth")
	private Integer schoolEducationIssuesYouth;
	@Column( name = "sexual_orientatiion_gender_identity_family_mbr")
	private Integer sexualOrientatiionGenderIdentityFamilyMbr;
	@Column( name = "sexual_orientatiion_gender_identity_youth")
	private Integer sexualOrientatiionGenderIdentityYouth;
	@Column( name = "sexual_orientation")
	private Integer sexualOrientation;
	@Column( name = "unemployement_family_mbr")
	private Integer unemployementFamilyMbr;
	@Column( name = "unemployement_youth")
	private Integer unemployementYouth;
	@Column( name = "work_place_promise_difference")
	private Integer workPlacePromiseDifference;
	@Column( name = "work_place_violence_threat")
	private Integer workPlaceViolenceThreat;
	@Column( name = "years_child_welfr_forest_care")
	private Integer yearsChildWelfrForestCare;
	@Column( name = "years_juvenile_justice")
	private Integer yearsJuvenileJustice;
	public Integer getAbuseAndNeglectFamilyMbr() {
		return abuseAndNeglectFamilyMbr;
	}
	public void setAbuseAndNeglectFamilyMbr(Integer abuseAndNeglectFamilyMbr) {
		this.abuseAndNeglectFamilyMbr = abuseAndNeglectFamilyMbr;
	}
	public Integer getAbuseAndNeglectYouth() {
		return abuseAndNeglectYouth;
	}
	public void setAbuseAndNeglectYouth(Integer abuseAndNeglectYouth) {
		this.abuseAndNeglectYouth = abuseAndNeglectYouth;
	}
	public Integer getActiveMilitaryParent() {
		return activeMilitaryParent;
	}
	public void setActiveMilitaryParent(Integer activeMilitaryParent) {
		this.activeMilitaryParent = activeMilitaryParent;
	}
	public Integer getAlcoholDrugAbuseFamilyMbr() {
		return alcoholDrugAbuseFamilyMbr;
	}
	public void setAlcoholDrugAbuseFamilyMbr(Integer alcoholDrugAbuseFamilyMbr) {
		this.alcoholDrugAbuseFamilyMbr = alcoholDrugAbuseFamilyMbr;
	}
	public Integer getAlcoholDrugAbuseYouth() {
		return alcoholDrugAbuseYouth;
	}
	public void setAlcoholDrugAbuseYouth(Integer alcoholDrugAbuseYouth) {
		this.alcoholDrugAbuseYouth = alcoholDrugAbuseYouth;
	}
	public Integer getAskedOfForcedToExchangeForSex() {
		return askedOfForcedToExchangeForSex;
	}
	public void setAskedOfForcedToExchangeForSex(
			Integer askedOfForcedToExchangeForSex) {
		this.askedOfForcedToExchangeForSex = askedOfForcedToExchangeForSex;
	}
	public Integer getAskedOfForcedToExchangeForSexPastThreeMonths() {
		return askedOfForcedToExchangeForSexPastThreeMonths;
	}
	public void setAskedOfForcedToExchangeForSexPastThreeMonths(
			Integer askedOfForcedToExchangeForSexPastThreeMonths) {
		this.askedOfForcedToExchangeForSexPastThreeMonths = askedOfForcedToExchangeForSexPastThreeMonths;
	}
	public Integer getCoercedToContinueWork() {
		return coercedToContinueWork;
	}
	public void setCoercedToContinueWork(Integer coercedToContinueWork) {
		this.coercedToContinueWork = coercedToContinueWork;
	}
	public Integer getCountOfExchangeForSex() {
		return countOfExchangeForSex;
	}
	public void setCountOfExchangeForSex(Integer countOfExchangeForSex) {
		this.countOfExchangeForSex = countOfExchangeForSex;
	}
	public Integer getCountOutReachReferralApproaches() {
		return countOutReachReferralApproaches;
	}
	public void setCountOutReachReferralApproaches(
			Integer countOutReachReferralApproaches) {
		this.countOutReachReferralApproaches = countOutReachReferralApproaches;
	}
	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public Integer getExchangeForSex() {
		return exchangeForSex;
	}
	public void setExchangeForSex(Integer exchangeForSex) {
		this.exchangeForSex = exchangeForSex;
	}
	public Integer getExchangeForSexPastThreeMonths() {
		return exchangeForSexPastThreeMonths;
	}
	public void setExchangeForSexPastThreeMonths(
			Integer exchangeForSexPastThreeMonths) {
		this.exchangeForSexPastThreeMonths = exchangeForSexPastThreeMonths;
	}
	public Integer getFormerlyWardChildWelfrForestCare() {
		return formerlyWardChildWelfrForestCare;
	}
	public void setFormerlyWardChildWelfrForestCare(
			Integer formerlyWardChildWelfrForestCare) {
		this.formerlyWardChildWelfrForestCare = formerlyWardChildWelfrForestCare;
	}
	public Integer getFormerlyWardOfJuvenileJustice() {
		return formerlyWardOfJuvenileJustice;
	}
	public void setFormerlyWardOfJuvenileJustice(
			Integer formerlyWardOfJuvenileJustice) {
		this.formerlyWardOfJuvenileJustice = formerlyWardOfJuvenileJustice;
	}
	public Integer getHealthIssuesFamilyMbr() {
		return healthIssuesFamilyMbr;
	}
	public void setHealthIssuesFamilyMbr(Integer healthIssuesFamilyMbr) {
		this.healthIssuesFamilyMbr = healthIssuesFamilyMbr;
	}
	public Integer getHealthIssuesYouth() {
		return healthIssuesYouth;
	}
	public void setHealthIssuesYouth(Integer healthIssuesYouth) {
		this.healthIssuesYouth = healthIssuesYouth;
	}
	public Integer getHouseHoldDynamics() {
		return houseHoldDynamics;
	}
	public void setHouseHoldDynamics(Integer houseHoldDynamics) {
		this.houseHoldDynamics = houseHoldDynamics;
	}
	public Integer getHousingIssuesFamilyMbr() {
		return housingIssuesFamilyMbr;
	}
	public void setHousingIssuesFamilyMbr(Integer housingIssuesFamilyMbr) {
		this.housingIssuesFamilyMbr = housingIssuesFamilyMbr;
	}
	public Integer getHousingIssuesYouth() {
		return housingIssuesYouth;
	}
	public void setHousingIssuesYouth(Integer housingIssuesYouth) {
		this.housingIssuesYouth = housingIssuesYouth;
	}
	public java.util.UUID getId() {
		return id;
	}
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	public Integer getIncarceratedParent() {
		return incarceratedParent;
	}
	public void setIncarceratedParent(Integer incarceratedParent) {
		this.incarceratedParent = incarceratedParent;
	}
	public Integer getIncarceratedParentStatus() {
		return incarceratedParentStatus;
	}
	public void setIncarceratedParentStatus(Integer incarceratedParentStatus) {
		this.incarceratedParentStatus = incarceratedParentStatus;
	}
	public Integer getInsufficientIncomeToSupportYouth() {
		return insufficientIncomeToSupportYouth;
	}
	public void setInsufficientIncomeToSupportYouth(
			Integer insufficientIncomeToSupportYouth) {
		this.insufficientIncomeToSupportYouth = insufficientIncomeToSupportYouth;
	}
	public Integer getLaborExploitPastThreeMonths() {
		return laborExploitPastThreeMonths;
	}
	public void setLaborExploitPastThreeMonths(Integer laborExploitPastThreeMonths) {
		this.laborExploitPastThreeMonths = laborExploitPastThreeMonths;
	}
	public Integer getMentalDisabilityFamilyMbr() {
		return mentalDisabilityFamilyMbr;
	}
	public void setMentalDisabilityFamilyMbr(Integer mentalDisabilityFamilyMbr) {
		this.mentalDisabilityFamilyMbr = mentalDisabilityFamilyMbr;
	}
	public Integer getMentalDisabilityYouth() {
		return mentalDisabilityYouth;
	}
	public void setMentalDisabilityYouth(Integer mentalDisabilityYouth) {
		this.mentalDisabilityYouth = mentalDisabilityYouth;
	}
	public Integer getMentalHealthIssuesFamilyMbr() {
		return mentalHealthIssuesFamilyMbr;
	}
	public void setMentalHealthIssuesFamilyMbr(Integer mentalHealthIssuesFamilyMbr) {
		this.mentalHealthIssuesFamilyMbr = mentalHealthIssuesFamilyMbr;
	}
	public Integer getMentalHealthIssuesYouth() {
		return mentalHealthIssuesYouth;
	}
	public void setMentalHealthIssuesYouth(Integer mentalHealthIssuesYouth) {
		this.mentalHealthIssuesYouth = mentalHealthIssuesYouth;
	}
	public Integer getMonthsChildWelfrForestCare() {
		return monthsChildWelfrForestCare;
	}
	public void setMonthsChildWelfrForestCare(Integer monthsChildWelfrForestCare) {
		this.monthsChildWelfrForestCare = monthsChildWelfrForestCare;
	}
	public Integer getPhysicalDisabilityFamilyMbr() {
		return physicalDisabilityFamilyMbr;
	}
	public void setPhysicalDisabilityFamilyMbr(Integer physicalDisabilityFamilyMbr) {
		this.physicalDisabilityFamilyMbr = physicalDisabilityFamilyMbr;
	}
	public Integer getPhysicalDisabilityYouth() {
		return physicalDisabilityYouth;
	}
	public void setPhysicalDisabilityYouth(Integer physicalDisabilityYouth) {
		this.physicalDisabilityYouth = physicalDisabilityYouth;
	}
	public Integer getReferralSource() {
		return referralSource;
	}
	public void setReferralSource(Integer referralSource) {
		this.referralSource = referralSource;
	}
	public Integer getSchoolEducationIssuesFamilyMbr() {
		return schoolEducationIssuesFamilyMbr;
	}
	public void setSchoolEducationIssuesFamilyMbr(
			Integer schoolEducationIssuesFamilyMbr) {
		this.schoolEducationIssuesFamilyMbr = schoolEducationIssuesFamilyMbr;
	}
	public Integer getSchoolEducationIssuesYouth() {
		return schoolEducationIssuesYouth;
	}
	public void setSchoolEducationIssuesYouth(Integer schoolEducationIssuesYouth) {
		this.schoolEducationIssuesYouth = schoolEducationIssuesYouth;
	}
	public Integer getSexualOrientatiionGenderIdentityFamilyMbr() {
		return sexualOrientatiionGenderIdentityFamilyMbr;
	}
	public void setSexualOrientatiionGenderIdentityFamilyMbr(
			Integer sexualOrientatiionGenderIdentityFamilyMbr) {
		this.sexualOrientatiionGenderIdentityFamilyMbr = sexualOrientatiionGenderIdentityFamilyMbr;
	}
	public Integer getSexualOrientatiionGenderIdentityYouth() {
		return sexualOrientatiionGenderIdentityYouth;
	}
	public void setSexualOrientatiionGenderIdentityYouth(
			Integer sexualOrientatiionGenderIdentityYouth) {
		this.sexualOrientatiionGenderIdentityYouth = sexualOrientatiionGenderIdentityYouth;
	}
	public Integer getSexualOrientation() {
		return sexualOrientation;
	}
	public void setSexualOrientation(Integer sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}
	public Integer getUnemployementFamilyMbr() {
		return unemployementFamilyMbr;
	}
	public void setUnemployementFamilyMbr(Integer unemployementFamilyMbr) {
		this.unemployementFamilyMbr = unemployementFamilyMbr;
	}
	public Integer getUnemployementYouth() {
		return unemployementYouth;
	}
	public void setUnemployementYouth(Integer unemployementYouth) {
		this.unemployementYouth = unemployementYouth;
	}
	public Integer getWorkPlacePromiseDifference() {
		return workPlacePromiseDifference;
	}
	public void setWorkPlacePromiseDifference(Integer workPlacePromiseDifference) {
		this.workPlacePromiseDifference = workPlacePromiseDifference;
	}
	public Integer getWorkPlaceViolenceThreat() {
		return workPlaceViolenceThreat;
	}
	public void setWorkPlaceViolenceThreat(Integer workPlaceViolenceThreat) {
		this.workPlaceViolenceThreat = workPlaceViolenceThreat;
	}
	public Integer getYearsChildWelfrForestCare() {
		return yearsChildWelfrForestCare;
	}
	public void setYearsChildWelfrForestCare(Integer yearsChildWelfrForestCare) {
		this.yearsChildWelfrForestCare = yearsChildWelfrForestCare;
	}
	public Integer getYearsJuvenileJustice() {
		return yearsJuvenileJustice;
	}
	public void setYearsJuvenileJustice(Integer yearsJuvenileJustice) {
		this.yearsJuvenileJustice = yearsJuvenileJustice;
	}

}
