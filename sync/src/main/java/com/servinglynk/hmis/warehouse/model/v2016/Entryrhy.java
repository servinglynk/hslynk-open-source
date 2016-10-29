package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Entryrhy extends BaseModel {

	
	@Column( name = "abuse_and_neglect_family_mbr")
	private Integer abuse_and_neglect_family_mbr;
	@Column( name = "abuse_and_neglect_youth")
	private Integer abuse_and_neglect_youth;
	@Column( name = "active_military_parent")
	private Integer active_military_parent;
	@Column( name = "alcohol_drug_abuse_family_mbr")
	private Integer alcohol_drug_abuse_family_mbr;
	@Column( name = "alcohol_drug_abuse_youth")
	private Integer alcohol_drug_abuse_youth;
	@Column( name = "asked_of_forced_to_exchange_for_sex")
	private Integer asked_of_forced_to_exchange_for_sex;
	@Column( name = "asked_of_forced_to_exchange_for_sex_past_three_months")
	private Integer asked_of_forced_to_exchange_for_sex_past_three_months;
	@Column( name = "coerced_to_continue_work")
	private Integer coerced_to_continue_work;
	@Column( name = "count_of_exchange_for_sex")
	private Integer count_of_exchange_for_sex;
	@Column( name = "count_out_reach_referral_approaches")
	private Integer count_out_reach_referral_approaches;
	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;
	@Column( name = "exchange_for_sex")
	private Integer exchange_for_sex;
	@Column( name = "exchange_for_sex_past_three_months")
	private Integer exchange_for_sex_past_three_months;
	@Column( name = "formerly_ward_child_welfr_forest_care")
	private Integer formerly_ward_child_welfr_forest_care;
	@Column( name = "formerly_ward_of_juvenile_justice")
	private Integer formerly_ward_of_juvenile_justice;
	@Column( name = "health_issues_family_mbr")
	private Integer health_issues_family_mbr;
	@Column( name = "health_issues_youth")
	private Integer health_issues_youth;
	@Column( name = "house_hold_dynamics")
	private Integer house_hold_dynamics;
	@Column( name = "housing_issues_family_mbr")
	private Integer housing_issues_family_mbr;
	@Column( name = "housing_issues_youth")
	private Integer housing_issues_youth;
	@Column( name = "id")
	private java.util.UUID id;
	@Column( name = "incarcerated_parent")
	private Integer incarcerated_parent;
	@Column( name = "incarcerated_parent_status")
	private Integer incarcerated_parent_status;
	@Column( name = "insufficient_income_to_support_youth")
	private Integer insufficient_income_to_support_youth;
	@Column( name = "labor_exploit_past_three_months")
	private Integer labor_exploit_past_three_months;
	@Column( name = "mental_disability_family_mbr")
	private Integer mental_disability_family_mbr;
	@Column( name = "mental_disability_youth")
	private Integer mental_disability_youth;
	@Column( name = "mental_health_issues_family_mbr")
	private Integer mental_health_issues_family_mbr;
	@Column( name = "mental_health_issues_youth")
	private Integer mental_health_issues_youth;
	@Column( name = "months_child_welfr_forest_care")
	private Integer months_child_welfr_forest_care;
	@Column( name = "physical_disability_family_mbr")
	private Integer physical_disability_family_mbr;
	@Column( name = "physical_disability_youth")
	private Integer physical_disability_youth;
	@Column( name = "referral_source")
	private Integer referral_source;
	@Column( name = "school_education_issues_family_mbr")
	private Integer school_education_issues_family_mbr;
	@Column( name = "school_education_issues_youth")
	private Integer school_education_issues_youth;
	@Column( name = "sexual_orientatiion_gender_identity_family_mbr")
	private Integer sexual_orientatiion_gender_identity_family_mbr;
	@Column( name = "sexual_orientatiion_gender_identity_youth")
	private Integer sexual_orientatiion_gender_identity_youth;
	@Column( name = "sexual_orientation")
	private Integer sexual_orientation;
	@Column( name = "unemployement_family_mbr")
	private Integer unemployement_family_mbr;
	@Column( name = "unemployement_youth")
	private Integer unemployement_youth;
	@Column( name = "work_place_promise_difference")
	private Integer work_place_promise_difference;
	@Column( name = "work_place_violence_threat")
	private Integer work_place_violence_threat;
	@Column( name = "years_child_welfr_forest_care")
	private Integer years_child_welfr_forest_care;
	@Column( name = "years_juvenile_justice")
	private Integer years_juvenile_justice;
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	
	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}
	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}
	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}
	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}
	public Integer getAbuse_and_neglect_family_mbr() {
		return abuse_and_neglect_family_mbr;
	}
	public void setAbuse_and_neglect_family_mbr(Integer abuse_and_neglect_family_mbr) {
		this.abuse_and_neglect_family_mbr = abuse_and_neglect_family_mbr;
	}
	public Integer getAbuse_and_neglect_youth() {
		return abuse_and_neglect_youth;
	}
	public void setAbuse_and_neglect_youth(Integer abuse_and_neglect_youth) {
		this.abuse_and_neglect_youth = abuse_and_neglect_youth;
	}
	public Integer getActive_military_parent() {
		return active_military_parent;
	}
	public void setActive_military_parent(Integer active_military_parent) {
		this.active_military_parent = active_military_parent;
	}
	public Integer getAlcohol_drug_abuse_family_mbr() {
		return alcohol_drug_abuse_family_mbr;
	}
	public void setAlcohol_drug_abuse_family_mbr(
			Integer alcohol_drug_abuse_family_mbr) {
		this.alcohol_drug_abuse_family_mbr = alcohol_drug_abuse_family_mbr;
	}
	public Integer getAlcohol_drug_abuse_youth() {
		return alcohol_drug_abuse_youth;
	}
	public void setAlcohol_drug_abuse_youth(Integer alcohol_drug_abuse_youth) {
		this.alcohol_drug_abuse_youth = alcohol_drug_abuse_youth;
	}
	public Integer getAsked_of_forced_to_exchange_for_sex() {
		return asked_of_forced_to_exchange_for_sex;
	}
	public void setAsked_of_forced_to_exchange_for_sex(
			Integer asked_of_forced_to_exchange_for_sex) {
		this.asked_of_forced_to_exchange_for_sex = asked_of_forced_to_exchange_for_sex;
	}
	public Integer getAsked_of_forced_to_exchange_for_sex_past_three_months() {
		return asked_of_forced_to_exchange_for_sex_past_three_months;
	}
	public void setAsked_of_forced_to_exchange_for_sex_past_three_months(
			Integer asked_of_forced_to_exchange_for_sex_past_three_months) {
		this.asked_of_forced_to_exchange_for_sex_past_three_months = asked_of_forced_to_exchange_for_sex_past_three_months;
	}
	public Integer getCoerced_to_continue_work() {
		return coerced_to_continue_work;
	}
	public void setCoerced_to_continue_work(Integer coerced_to_continue_work) {
		this.coerced_to_continue_work = coerced_to_continue_work;
	}
	public Integer getCount_of_exchange_for_sex() {
		return count_of_exchange_for_sex;
	}
	public void setCount_of_exchange_for_sex(Integer count_of_exchange_for_sex) {
		this.count_of_exchange_for_sex = count_of_exchange_for_sex;
	}
	public Integer getCount_out_reach_referral_approaches() {
		return count_out_reach_referral_approaches;
	}
	public void setCount_out_reach_referral_approaches(
			Integer count_out_reach_referral_approaches) {
		this.count_out_reach_referral_approaches = count_out_reach_referral_approaches;
	}
	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public Integer getExchange_for_sex() {
		return exchange_for_sex;
	}
	public void setExchange_for_sex(Integer exchange_for_sex) {
		this.exchange_for_sex = exchange_for_sex;
	}
	public Integer getExchange_for_sex_past_three_months() {
		return exchange_for_sex_past_three_months;
	}
	public void setExchange_for_sex_past_three_months(
			Integer exchange_for_sex_past_three_months) {
		this.exchange_for_sex_past_three_months = exchange_for_sex_past_three_months;
	}
	public Integer getFormerly_ward_child_welfr_forest_care() {
		return formerly_ward_child_welfr_forest_care;
	}
	public void setFormerly_ward_child_welfr_forest_care(
			Integer formerly_ward_child_welfr_forest_care) {
		this.formerly_ward_child_welfr_forest_care = formerly_ward_child_welfr_forest_care;
	}
	public Integer getFormerly_ward_of_juvenile_justice() {
		return formerly_ward_of_juvenile_justice;
	}
	public void setFormerly_ward_of_juvenile_justice(
			Integer formerly_ward_of_juvenile_justice) {
		this.formerly_ward_of_juvenile_justice = formerly_ward_of_juvenile_justice;
	}
	public Integer getHealth_issues_family_mbr() {
		return health_issues_family_mbr;
	}
	public void setHealth_issues_family_mbr(Integer health_issues_family_mbr) {
		this.health_issues_family_mbr = health_issues_family_mbr;
	}
	public Integer getHealth_issues_youth() {
		return health_issues_youth;
	}
	public void setHealth_issues_youth(Integer health_issues_youth) {
		this.health_issues_youth = health_issues_youth;
	}
	public Integer getHouse_hold_dynamics() {
		return house_hold_dynamics;
	}
	public void setHouse_hold_dynamics(Integer house_hold_dynamics) {
		this.house_hold_dynamics = house_hold_dynamics;
	}
	public Integer getHousing_issues_family_mbr() {
		return housing_issues_family_mbr;
	}
	public void setHousing_issues_family_mbr(Integer housing_issues_family_mbr) {
		this.housing_issues_family_mbr = housing_issues_family_mbr;
	}
	public Integer getHousing_issues_youth() {
		return housing_issues_youth;
	}
	public void setHousing_issues_youth(Integer housing_issues_youth) {
		this.housing_issues_youth = housing_issues_youth;
	}
	public java.util.UUID getId() {
		return id;
	}
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	public Integer getIncarcerated_parent() {
		return incarcerated_parent;
	}
	public void setIncarcerated_parent(Integer incarcerated_parent) {
		this.incarcerated_parent = incarcerated_parent;
	}
	public Integer getIncarcerated_parent_status() {
		return incarcerated_parent_status;
	}
	public void setIncarcerated_parent_status(Integer incarcerated_parent_status) {
		this.incarcerated_parent_status = incarcerated_parent_status;
	}
	public Integer getInsufficient_income_to_support_youth() {
		return insufficient_income_to_support_youth;
	}
	public void setInsufficient_income_to_support_youth(
			Integer insufficient_income_to_support_youth) {
		this.insufficient_income_to_support_youth = insufficient_income_to_support_youth;
	}
	public Integer getLabor_exploit_past_three_months() {
		return labor_exploit_past_three_months;
	}
	public void setLabor_exploit_past_three_months(
			Integer labor_exploit_past_three_months) {
		this.labor_exploit_past_three_months = labor_exploit_past_three_months;
	}
	public Integer getMental_disability_family_mbr() {
		return mental_disability_family_mbr;
	}
	public void setMental_disability_family_mbr(Integer mental_disability_family_mbr) {
		this.mental_disability_family_mbr = mental_disability_family_mbr;
	}
	public Integer getMental_disability_youth() {
		return mental_disability_youth;
	}
	public void setMental_disability_youth(Integer mental_disability_youth) {
		this.mental_disability_youth = mental_disability_youth;
	}
	public Integer getMental_health_issues_family_mbr() {
		return mental_health_issues_family_mbr;
	}
	public void setMental_health_issues_family_mbr(
			Integer mental_health_issues_family_mbr) {
		this.mental_health_issues_family_mbr = mental_health_issues_family_mbr;
	}
	public Integer getMental_health_issues_youth() {
		return mental_health_issues_youth;
	}
	public void setMental_health_issues_youth(Integer mental_health_issues_youth) {
		this.mental_health_issues_youth = mental_health_issues_youth;
	}
	public Integer getMonths_child_welfr_forest_care() {
		return months_child_welfr_forest_care;
	}
	public void setMonths_child_welfr_forest_care(
			Integer months_child_welfr_forest_care) {
		this.months_child_welfr_forest_care = months_child_welfr_forest_care;
	}
	public Integer getPhysical_disability_family_mbr() {
		return physical_disability_family_mbr;
	}
	public void setPhysical_disability_family_mbr(
			Integer physical_disability_family_mbr) {
		this.physical_disability_family_mbr = physical_disability_family_mbr;
	}
	public Integer getPhysical_disability_youth() {
		return physical_disability_youth;
	}
	public void setPhysical_disability_youth(Integer physical_disability_youth) {
		this.physical_disability_youth = physical_disability_youth;
	}
	public Integer getReferral_source() {
		return referral_source;
	}
	public void setReferral_source(Integer referral_source) {
		this.referral_source = referral_source;
	}
	public Integer getSchool_education_issues_family_mbr() {
		return school_education_issues_family_mbr;
	}
	public void setSchool_education_issues_family_mbr(
			Integer school_education_issues_family_mbr) {
		this.school_education_issues_family_mbr = school_education_issues_family_mbr;
	}
	public Integer getSchool_education_issues_youth() {
		return school_education_issues_youth;
	}
	public void setSchool_education_issues_youth(
			Integer school_education_issues_youth) {
		this.school_education_issues_youth = school_education_issues_youth;
	}
	public Integer getSexual_orientatiion_gender_identity_family_mbr() {
		return sexual_orientatiion_gender_identity_family_mbr;
	}
	public void setSexual_orientatiion_gender_identity_family_mbr(
			Integer sexual_orientatiion_gender_identity_family_mbr) {
		this.sexual_orientatiion_gender_identity_family_mbr = sexual_orientatiion_gender_identity_family_mbr;
	}
	public Integer getSexual_orientatiion_gender_identity_youth() {
		return sexual_orientatiion_gender_identity_youth;
	}
	public void setSexual_orientatiion_gender_identity_youth(
			Integer sexual_orientatiion_gender_identity_youth) {
		this.sexual_orientatiion_gender_identity_youth = sexual_orientatiion_gender_identity_youth;
	}
	public Integer getSexual_orientation() {
		return sexual_orientation;
	}
	public void setSexual_orientation(Integer sexual_orientation) {
		this.sexual_orientation = sexual_orientation;
	}
	public Integer getUnemployement_family_mbr() {
		return unemployement_family_mbr;
	}
	public void setUnemployement_family_mbr(Integer unemployement_family_mbr) {
		this.unemployement_family_mbr = unemployement_family_mbr;
	}
	public Integer getUnemployement_youth() {
		return unemployement_youth;
	}
	public void setUnemployement_youth(Integer unemployement_youth) {
		this.unemployement_youth = unemployement_youth;
	}
	public Integer getWork_place_promise_difference() {
		return work_place_promise_difference;
	}
	public void setWork_place_promise_difference(
			Integer work_place_promise_difference) {
		this.work_place_promise_difference = work_place_promise_difference;
	}
	public Integer getWork_place_violence_threat() {
		return work_place_violence_threat;
	}
	public void setWork_place_violence_threat(Integer work_place_violence_threat) {
		this.work_place_violence_threat = work_place_violence_threat;
	}
	public Integer getYears_child_welfr_forest_care() {
		return years_child_welfr_forest_care;
	}
	public void setYears_child_welfr_forest_care(
			Integer years_child_welfr_forest_care) {
		this.years_child_welfr_forest_care = years_child_welfr_forest_care;
	}
	public Integer getYears_juvenile_justice() {
		return years_juvenile_justice;
	}
	public void setYears_juvenile_justice(Integer years_juvenile_justice) {
		this.years_juvenile_justice = years_juvenile_justice;
	}
	
	
}
