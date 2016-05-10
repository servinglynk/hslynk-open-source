package com.servinglynk.hmis.warehouse.model.v2015;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Entryrhy extends BaseModel {

	
	@Column( name = "abuse_and_neglect_family_mbr")
	private String abuse_and_neglect_family_mbr;
	@Column( name = "abuse_and_neglect_youth")
	private String abuse_and_neglect_youth;
	@Column( name = "active_military_parent")
	private String active_military_parent;
	@Column( name = "alcohol_drug_abuse_family_mbr")
	private String alcohol_drug_abuse_family_mbr;
	@Column( name = "alcohol_drug_abuse_youth")
	private String alcohol_drug_abuse_youth;
	@Column( name = "asked_of_forced_to_exchange_for_sex")
	private String asked_of_forced_to_exchange_for_sex;
	@Column( name = "asked_of_forced_to_exchange_for_sex_past_3_months")
	private String asked_of_forced_to_exchange_for_sex_past_three_months;
	@Column( name = "coerced_to_continue_work")
	private String coerced_to_continue_work;
	@Column( name = "count_of_exchange_for_sex")
	private String count_of_exchange_for_sex;
	@Column( name = "count_out_reach_referral_approaches")
	private String count_out_reach_referral_approaches;
	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;
	@Column( name = "exchange_for_sex")
	private String exchange_for_sex;
	@Column( name = "exchange_for_sex_past_three_months")
	private String exchange_for_sex_past_three_months;
	@Column( name = "formerly_ward_child_welfr_forest_care")
	private String formerly_ward_child_welfr_forest_care;
	@Column( name = "formerly_ward_of_juvenile_justice")
	private String formerly_ward_of_juvenile_justice;
	@Column( name = "health_issues_family_mbr")
	private String health_issues_family_mbr;
	@Column( name = "health_issues_youth")
	private String health_issues_youth;
	@Column( name = "house_hold_dynamics")
	private String house_hold_dynamics;
	@Column( name = "housing_issues_family_mbr")
	private String housing_issues_family_mbr;
	@Column( name = "housing_issues_youth")
	private String housing_issues_youth;
	@Column( name = "id")
	private java.util.UUID id;
	@Column( name = "incarcerated_parent")
	private String incarcerated_parent;
	@Column( name = "incarcerated_parent_status")
	private String incarcerated_parent_status;
	@Column( name = "insufficient_income_to_support_youth")
	private String insufficient_income_to_support_youth;
	@Column( name = "labor_exploit_past_three_months")
	private String labor_exploit_past_three_months;
	@Column( name = "mental_disability_family_mbr")
	private String mental_disability_family_mbr;
	@Column( name = "mental_disability_youth")
	private String mental_disability_youth;
	@Column( name = "mental_health_issues_family_mbr")
	private String mental_health_issues_family_mbr;
	@Column( name = "mental_health_issues_youth")
	private String mental_health_issues_youth;
	@Column( name = "months_child_welfr_forest_care")
	private String months_child_welfr_forest_care;
	@Column( name = "physical_disability_family_mbr")
	private String physical_disability_family_mbr;
	@Column( name = "physical_disability_youth")
	private String physical_disability_youth;
	@Column( name = "referral_source")
	private String referral_source;
	@Column( name = "school_education_issues_family_mbr")
	private String school_education_issues_family_mbr;
	@Column( name = "school_education_issues_youth")
	private String school_education_issues_youth;
	@Column( name = "sexual_orientatiion_gender_identity_family_mbr")
	private String sexual_orientatiion_gender_identity_family_mbr;
	@Column( name = "sexual_orientatiion_gender_identity_youth")
	private String sexual_orientatiion_gender_identity_youth;
	@Column( name = "sexual_orientation")
	private String sexual_orientation;
	@Column( name = "unemployement_family_mbr")
	private String unemployement_family_mbr;
	@Column( name = "unemployement_youth")
	private String unemployement_youth;
	@Column( name = "work_place_promise_difference")
	private String work_place_promise_difference;
	@Column( name = "work_place_violence_threat")
	private String work_place_violence_threat;
	@Column( name = "years_child_welfr_forest_care")
	private String years_child_welfr_forest_care;
	@Column( name = "years_juvenile_justice")
	private String years_juvenile_justice;
	public String getAbuse_and_neglect_family_mbr() {
		return abuse_and_neglect_family_mbr;
	}
	public void setAbuse_and_neglect_family_mbr(String abuse_and_neglect_family_mbr) {
		this.abuse_and_neglect_family_mbr = abuse_and_neglect_family_mbr;
	}
	public String getAbuse_and_neglect_youth() {
		return abuse_and_neglect_youth;
	}
	public void setAbuse_and_neglect_youth(String abuse_and_neglect_youth) {
		this.abuse_and_neglect_youth = abuse_and_neglect_youth;
	}
	public String getActive_military_parent() {
		return active_military_parent;
	}
	public void setActive_military_parent(String active_military_parent) {
		this.active_military_parent = active_military_parent;
	}
	public String getAlcohol_drug_abuse_family_mbr() {
		return alcohol_drug_abuse_family_mbr;
	}
	public void setAlcohol_drug_abuse_family_mbr(
			String alcohol_drug_abuse_family_mbr) {
		this.alcohol_drug_abuse_family_mbr = alcohol_drug_abuse_family_mbr;
	}
	public String getAlcohol_drug_abuse_youth() {
		return alcohol_drug_abuse_youth;
	}
	public void setAlcohol_drug_abuse_youth(String alcohol_drug_abuse_youth) {
		this.alcohol_drug_abuse_youth = alcohol_drug_abuse_youth;
	}
	public String getAsked_of_forced_to_exchange_for_sex() {
		return asked_of_forced_to_exchange_for_sex;
	}
	public void setAsked_of_forced_to_exchange_for_sex(
			String asked_of_forced_to_exchange_for_sex) {
		this.asked_of_forced_to_exchange_for_sex = asked_of_forced_to_exchange_for_sex;
	}
	public String getAsked_of_forced_to_exchange_for_sex_past_three_months() {
		return asked_of_forced_to_exchange_for_sex_past_three_months;
	}
	public void setAsked_of_forced_to_exchange_for_sex_past_three_months(
			String asked_of_forced_to_exchange_for_sex_past_three_months) {
		this.asked_of_forced_to_exchange_for_sex_past_three_months = asked_of_forced_to_exchange_for_sex_past_three_months;
	}
	public String getCoerced_to_continue_work() {
		return coerced_to_continue_work;
	}
	public void setCoerced_to_continue_work(String coerced_to_continue_work) {
		this.coerced_to_continue_work = coerced_to_continue_work;
	}
	public String getCount_of_exchange_for_sex() {
		return count_of_exchange_for_sex;
	}
	public void setCount_of_exchange_for_sex(String count_of_exchange_for_sex) {
		this.count_of_exchange_for_sex = count_of_exchange_for_sex;
	}
	public String getCount_out_reach_referral_approaches() {
		return count_out_reach_referral_approaches;
	}
	public void setCount_out_reach_referral_approaches(
			String count_out_reach_referral_approaches) {
		this.count_out_reach_referral_approaches = count_out_reach_referral_approaches;
	}
	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public String getExchange_for_sex() {
		return exchange_for_sex;
	}
	public void setExchange_for_sex(String exchange_for_sex) {
		this.exchange_for_sex = exchange_for_sex;
	}
	public String getExchange_for_sex_past_three_months() {
		return exchange_for_sex_past_three_months;
	}
	public void setExchange_for_sex_past_three_months(
			String exchange_for_sex_past_three_months) {
		this.exchange_for_sex_past_three_months = exchange_for_sex_past_three_months;
	}
	public String getFormerly_ward_child_welfr_forest_care() {
		return formerly_ward_child_welfr_forest_care;
	}
	public void setFormerly_ward_child_welfr_forest_care(
			String formerly_ward_child_welfr_forest_care) {
		this.formerly_ward_child_welfr_forest_care = formerly_ward_child_welfr_forest_care;
	}
	public String getFormerly_ward_of_juvenile_justice() {
		return formerly_ward_of_juvenile_justice;
	}
	public void setFormerly_ward_of_juvenile_justice(
			String formerly_ward_of_juvenile_justice) {
		this.formerly_ward_of_juvenile_justice = formerly_ward_of_juvenile_justice;
	}
	public String getHealth_issues_family_mbr() {
		return health_issues_family_mbr;
	}
	public void setHealth_issues_family_mbr(String health_issues_family_mbr) {
		this.health_issues_family_mbr = health_issues_family_mbr;
	}
	public String getHealth_issues_youth() {
		return health_issues_youth;
	}
	public void setHealth_issues_youth(String health_issues_youth) {
		this.health_issues_youth = health_issues_youth;
	}
	public String getHouse_hold_dynamics() {
		return house_hold_dynamics;
	}
	public void setHouse_hold_dynamics(String house_hold_dynamics) {
		this.house_hold_dynamics = house_hold_dynamics;
	}
	public String getHousing_issues_family_mbr() {
		return housing_issues_family_mbr;
	}
	public void setHousing_issues_family_mbr(String housing_issues_family_mbr) {
		this.housing_issues_family_mbr = housing_issues_family_mbr;
	}
	public String getHousing_issues_youth() {
		return housing_issues_youth;
	}
	public void setHousing_issues_youth(String housing_issues_youth) {
		this.housing_issues_youth = housing_issues_youth;
	}
	public java.util.UUID getId() {
		return id;
	}
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	public String getIncarcerated_parent() {
		return incarcerated_parent;
	}
	public void setIncarcerated_parent(String incarcerated_parent) {
		this.incarcerated_parent = incarcerated_parent;
	}
	public String getIncarcerated_parent_status() {
		return incarcerated_parent_status;
	}
	public void setIncarcerated_parent_status(String incarcerated_parent_status) {
		this.incarcerated_parent_status = incarcerated_parent_status;
	}
	public String getInsufficient_income_to_support_youth() {
		return insufficient_income_to_support_youth;
	}
	public void setInsufficient_income_to_support_youth(
			String insufficient_income_to_support_youth) {
		this.insufficient_income_to_support_youth = insufficient_income_to_support_youth;
	}
	public String getLabor_exploit_past_three_months() {
		return labor_exploit_past_three_months;
	}
	public void setLabor_exploit_past_three_months(
			String labor_exploit_past_three_months) {
		this.labor_exploit_past_three_months = labor_exploit_past_three_months;
	}
	public String getMental_disability_family_mbr() {
		return mental_disability_family_mbr;
	}
	public void setMental_disability_family_mbr(String mental_disability_family_mbr) {
		this.mental_disability_family_mbr = mental_disability_family_mbr;
	}
	public String getMental_disability_youth() {
		return mental_disability_youth;
	}
	public void setMental_disability_youth(String mental_disability_youth) {
		this.mental_disability_youth = mental_disability_youth;
	}
	public String getMental_health_issues_family_mbr() {
		return mental_health_issues_family_mbr;
	}
	public void setMental_health_issues_family_mbr(
			String mental_health_issues_family_mbr) {
		this.mental_health_issues_family_mbr = mental_health_issues_family_mbr;
	}
	public String getMental_health_issues_youth() {
		return mental_health_issues_youth;
	}
	public void setMental_health_issues_youth(String mental_health_issues_youth) {
		this.mental_health_issues_youth = mental_health_issues_youth;
	}
	public String getMonths_child_welfr_forest_care() {
		return months_child_welfr_forest_care;
	}
	public void setMonths_child_welfr_forest_care(
			String months_child_welfr_forest_care) {
		this.months_child_welfr_forest_care = months_child_welfr_forest_care;
	}
	public String getPhysical_disability_family_mbr() {
		return physical_disability_family_mbr;
	}
	public void setPhysical_disability_family_mbr(
			String physical_disability_family_mbr) {
		this.physical_disability_family_mbr = physical_disability_family_mbr;
	}
	public String getPhysical_disability_youth() {
		return physical_disability_youth;
	}
	public void setPhysical_disability_youth(String physical_disability_youth) {
		this.physical_disability_youth = physical_disability_youth;
	}
	public String getReferral_source() {
		return referral_source;
	}
	public void setReferral_source(String referral_source) {
		this.referral_source = referral_source;
	}
	public String getSchool_education_issues_family_mbr() {
		return school_education_issues_family_mbr;
	}
	public void setSchool_education_issues_family_mbr(
			String school_education_issues_family_mbr) {
		this.school_education_issues_family_mbr = school_education_issues_family_mbr;
	}
	public String getSchool_education_issues_youth() {
		return school_education_issues_youth;
	}
	public void setSchool_education_issues_youth(
			String school_education_issues_youth) {
		this.school_education_issues_youth = school_education_issues_youth;
	}
	public String getSexual_orientatiion_gender_identity_family_mbr() {
		return sexual_orientatiion_gender_identity_family_mbr;
	}
	public void setSexual_orientatiion_gender_identity_family_mbr(
			String sexual_orientatiion_gender_identity_family_mbr) {
		this.sexual_orientatiion_gender_identity_family_mbr = sexual_orientatiion_gender_identity_family_mbr;
	}
	public String getSexual_orientatiion_gender_identity_youth() {
		return sexual_orientatiion_gender_identity_youth;
	}
	public void setSexual_orientatiion_gender_identity_youth(
			String sexual_orientatiion_gender_identity_youth) {
		this.sexual_orientatiion_gender_identity_youth = sexual_orientatiion_gender_identity_youth;
	}
	public String getSexual_orientation() {
		return sexual_orientation;
	}
	public void setSexual_orientation(String sexual_orientation) {
		this.sexual_orientation = sexual_orientation;
	}
	public String getUnemployement_family_mbr() {
		return unemployement_family_mbr;
	}
	public void setUnemployement_family_mbr(String unemployement_family_mbr) {
		this.unemployement_family_mbr = unemployement_family_mbr;
	}
	public String getUnemployement_youth() {
		return unemployement_youth;
	}
	public void setUnemployement_youth(String unemployement_youth) {
		this.unemployement_youth = unemployement_youth;
	}
	public String getWork_place_promise_difference() {
		return work_place_promise_difference;
	}
	public void setWork_place_promise_difference(
			String work_place_promise_difference) {
		this.work_place_promise_difference = work_place_promise_difference;
	}
	public String getWork_place_violence_threat() {
		return work_place_violence_threat;
	}
	public void setWork_place_violence_threat(String work_place_violence_threat) {
		this.work_place_violence_threat = work_place_violence_threat;
	}
	public String getYears_child_welfr_forest_care() {
		return years_child_welfr_forest_care;
	}
	public void setYears_child_welfr_forest_care(
			String years_child_welfr_forest_care) {
		this.years_child_welfr_forest_care = years_child_welfr_forest_care;
	}
	public String getYears_juvenile_justice() {
		return years_juvenile_justice;
	}
	public void setYears_juvenile_justice(String years_juvenile_justice) {
		this.years_juvenile_justice = years_juvenile_justice;
	}
	
	
}
