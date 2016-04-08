package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Enrollment extends BaseModel{
	
	@Column(name="continuouslyhomelessoneyear")
	public String continuouslyhomelessoneyear;
	@Column(name="disablingcondition")
	public String disablingcondition;
	@Column(name="entrydate")
	public Timestamp entrydate;
	@Column(name="householdid")
	public UUID householdid;
	@Column(name="housingstatus")
	public String housingstatus;
	@Column(name="monthshomelesspastthreeyears")
	public String monthshomelesspastthreeyears;
	@Column(name="monthshomelessthistime")
	public String monthshomelessthistime;
	@Column(name="otherresidenceprior")
	public String otherresidenceprior;
	@Column(name="personalid")			
	public UUID personalid;
	@Column(name="projectentryid")		
	public UUID projectentryid;
	@Column(name="projectid")			
	public UUID projectid;
	@Column(name="relationshiptohoh")
	public String relationshiptohoh;
	@Column(name="residenceprior")		
	public String residenceprior;
	@Column(name="residencepriorlengthofstay")
	public String residencepriorlengthofstay;
	@Column(name="statusdocumented")	
	public String statusdocumented;
	@Column(name="timeshomelesspastthreeyears")
	public String timeshomelesspastthreeyears;
	@Column(name="yearshomeless")		
	public String yearshomeless;
	@Column(name="client_id")
	public UUID client_id;
	/**
	 * @return the continuouslyhomelessoneyear
	 */
	public String getContinuouslyhomelessoneyear() {
		return continuouslyhomelessoneyear;
	}
	/**
	 * @param continuouslyhomelessoneyear the continuouslyhomelessoneyear to set
	 */
	public void setContinuouslyhomelessoneyear(String continuouslyhomelessoneyear) {
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
	}
	/**
	 * @return the disablingcondition
	 */
	public String getDisablingcondition() {
		return disablingcondition;
	}
	/**
	 * @param disablingcondition the disablingcondition to set
	 */
	public void setDisablingcondition(String disablingcondition) {
		this.disablingcondition = disablingcondition;
	}
	/**
	 * @return the entrydate
	 */
	public Timestamp getEntrydate() {
		return entrydate;
	}
	/**
	 * @param entrydate the entrydate to set
	 */
	public void setEntrydate(Timestamp entrydate) {
		this.entrydate = entrydate;
	}
	/**
	 * @return the householdid
	 */
	public UUID getHouseholdid() {
		return householdid;
	}
	/**
	 * @param householdid the householdid to set
	 */
	public void setHouseholdid(UUID householdid) {
		this.householdid = householdid;
	}
	/**
	 * @return the housingstatus
	 */
	public String getHousingstatus() {
		return housingstatus;
	}
	/**
	 * @param housingstatus the housingstatus to set
	 */
	public void setHousingstatus(String housingstatus) {
		this.housingstatus = housingstatus;
	}
	/**
	 * @return the monthshomelesspastthreeyears
	 */
	public String getMonthshomelesspastthreeyears() {
		return monthshomelesspastthreeyears;
	}
	/**
	 * @param monthshomelesspastthreeyears the monthshomelesspastthreeyears to set
	 */
	public void setMonthshomelesspastthreeyears(String monthshomelesspastthreeyears) {
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
	}
	/**
	 * @return the monthshomelessthistime
	 */
	public String getMonthshomelessthistime() {
		return monthshomelessthistime;
	}
	/**
	 * @param monthshomelessthistime the monthshomelessthistime to set
	 */
	public void setMonthshomelessthistime(String monthshomelessthistime) {
		this.monthshomelessthistime = monthshomelessthistime;
	}
	/**
	 * @return the otherresidenceprior
	 */
	public String getOtherresidenceprior() {
		return otherresidenceprior;
	}
	/**
	 * @param otherresidenceprior the otherresidenceprior to set
	 */
	public void setOtherresidenceprior(String otherresidenceprior) {
		this.otherresidenceprior = otherresidenceprior;
	}
	/**
	 * @return the personalid
	 */
	public UUID getPersonalid() {
		return personalid;
	}
	/**
	 * @param personalid the personalid to set
	 */
	public void setPersonalid(UUID personalid) {
		this.personalid = personalid;
	}
	/**
	 * @return the projectentryid
	 */
	public UUID getProjectentryid() {
		return projectentryid;
	}
	/**
	 * @param projectentryid the projectentryid to set
	 */
	public void setProjectentryid(UUID projectentryid) {
		this.projectentryid = projectentryid;
	}
	/**
	 * @return the projectid
	 */
	public UUID getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}
	/**
	 * @return the relationshiptohoh
	 */
	public String getRelationshiptohoh() {
		return relationshiptohoh;
	}
	/**
	 * @param relationshiptohoh the relationshiptohoh to set
	 */
	public void setRelationshiptohoh(String relationshiptohoh) {
		this.relationshiptohoh = relationshiptohoh;
	}
	/**
	 * @return the residenceprior
	 */
	public String getResidenceprior() {
		return residenceprior;
	}
	/**
	 * @param residenceprior the residenceprior to set
	 */
	public void setResidenceprior(String residenceprior) {
		this.residenceprior = residenceprior;
	}
	/**
	 * @return the residencepriorlengthofstay
	 */
	public String getResidencepriorlengthofstay() {
		return residencepriorlengthofstay;
	}
	/**
	 * @param residencepriorlengthofstay the residencepriorlengthofstay to set
	 */
	public void setResidencepriorlengthofstay(String residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}
	/**
	 * @return the statusdocumented
	 */
	public String getStatusdocumented() {
		return statusdocumented;
	}
	/**
	 * @param statusdocumented the statusdocumented to set
	 */
	public void setStatusdocumented(String statusdocumented) {
		this.statusdocumented = statusdocumented;
	}
	/**
	 * @return the timeshomelesspastthreeyears
	 */
	public String getTimeshomelesspastthreeyears() {
		return timeshomelesspastthreeyears;
	}
	/**
	 * @param timeshomelesspastthreeyears the timeshomelesspastthreeyears to set
	 */
	public void setTimeshomelesspastthreeyears(String timeshomelesspastthreeyears) {
		this.timeshomelesspastthreeyears = timeshomelesspastthreeyears;
	}
	/**
	 * @return the yearshomeless
	 */
	public String getYearshomeless() {
		return yearshomeless;
	}
	/**
	 * @param yearshomeless the yearshomeless to set
	 */
	public void setYearshomeless(String yearshomeless) {
		this.yearshomeless = yearshomeless;
	}
	/**
	 * @return the client_id
	 */
	public UUID getClient_id() {
		return client_id;
	}
	/**
	 * @param client_id the client_id to set
	 */
	public void setClient_id(UUID client_id) {
		this.client_id = client_id;
	}
	
}
