package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class Enrollment extends ClientModel {
	
	
	
	private UUID enrollmentId;
	private Integer continuouslyhomelessoneyear;
	private Integer  disablingcondition;
	private Date  entrydate;
	private String  householdid;
	private Integer  housingstatus;
	private Integer  monthshomelesspastthreeyears;
	private Integer  monthshomelessthistime;
	private String  otherresidenceprior;
	private UUID  	personalid;
	private UUID  	projectentryid;
	private UUID  	projectid;
	private Integer  relationshiptohoh;
	private Integer  residenceprior;
	private Integer  residencepriorlengthofstay;
	private Integer  statusdocumented;
	private Integer  timeshomelesspastthreeyears;
	private int  yearshomeless;
	private UUID  clientId;
	private Integer entryfromstreetessh;
	private Integer losunderthreshold;
	private Integer previousStreetESSH;
	
	public Integer getEntryfromstreetessh() {
		return entryfromstreetessh;
	}

	public void setEntryfromstreetessh(Integer entryfromstreetessh) {
		this.entryfromstreetessh = entryfromstreetessh;
	}

	public Integer getDatetostreetessh() {
		return datetostreetessh;
	}

	public void setDatetostreetessh(Integer datetostreetessh) {
		this.datetostreetessh = datetostreetessh;
	}

	private Integer datetostreetessh;

	public Enrollment(){
		
	}
	
	public Enrollment(UUID enrollmentId){
		this.enrollmentId = enrollmentId;
	}
	
	
	public UUID getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Integer getContinuouslyhomelessoneyear() {
		return continuouslyhomelessoneyear;
	}

	public void setContinuouslyhomelessoneyear(Integer continuouslyhomelessoneyear) {
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
	}

	public Integer getDisablingcondition() {
		return disablingcondition;
	}

	public void setDisablingcondition(Integer disablingcondition) {
		this.disablingcondition = disablingcondition;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getHouseholdid() {
		return householdid;
	}

	public void setHouseholdid(String householdid) {
		this.householdid = householdid;
	}

	public Integer getHousingstatus() {
		return housingstatus;
	}

	public void setHousingstatus(Integer housingstatus) {
		this.housingstatus = housingstatus;
	}

	public Integer getMonthshomelesspastthreeyears() {
		return monthshomelesspastthreeyears;
	}

	public void setMonthshomelesspastthreeyears(Integer monthshomelesspastthreeyears) {
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
	}

	public Integer getMonthshomelessthistime() {
		return monthshomelessthistime;
	}

	public void setMonthshomelessthistime(Integer monthshomelessthistime) {
		this.monthshomelessthistime = monthshomelessthistime;
	}

	public String getOtherresidenceprior() {
		return otherresidenceprior;
	}

	public void setOtherresidenceprior(String otherresidenceprior) {
		this.otherresidenceprior = otherresidenceprior;
	}

	public UUID getPersonalid() {
		return personalid;
	}

	public void setPersonalid(UUID personalid) {
		this.personalid = personalid;
	}

	public UUID getProjectentryid() {
		return projectentryid;
	}

	public void setProjectentryid(UUID projectentryid) {
		this.projectentryid = projectentryid;
	}

	public UUID getProjectid() {
		return projectid;
	}

	public void setProjectid(UUID projectid) {
		this.projectid = projectid;
	}

	public Integer getRelationshiptohoh() {
		return relationshiptohoh;
	}

	public void setRelationshiptohoh(Integer relationshiptohoh) {
		this.relationshiptohoh = relationshiptohoh;
	}

	public Integer getResidenceprior() {
		return residenceprior;
	}

	public void setResidenceprior(Integer residenceprior) {
		this.residenceprior = residenceprior;
	}

	public Integer getResidencepriorlengthofstay() {
		return residencepriorlengthofstay;
	}

	public void setResidencepriorlengthofstay(Integer residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}

	public Integer getStatusdocumented() {
		return statusdocumented;
	}

	public void setStatusdocumented(Integer statusdocumented) {
		this.statusdocumented = statusdocumented;
	}

	public Integer getTimeshomelesspastthreeyears() {
		return timeshomelesspastthreeyears;
	}

	public void setTimeshomelesspastthreeyears(Integer timeshomelesspastthreeyears) {
		this.timeshomelesspastthreeyears = timeshomelesspastthreeyears;
	}

	public int getYearshomeless() {
		return yearshomeless;
	}

	public void setYearshomeless(int yearshomeless) {
		this.yearshomeless = yearshomeless;
	}

	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the losunderthreshold
	 */
	public Integer getLosunderthreshold() {
		return losunderthreshold;
	}

	/**
	 * @param losunderthreshold the losunderthreshold to set
	 */
	public void setLosunderthreshold(Integer losunderthreshold) {
		this.losunderthreshold = losunderthreshold;
	}

	/**
	 * @return the previousStreetESSH
	 */
	public Integer getPreviousStreetESSH() {
		return previousStreetESSH;
	}

	/**
	 * @param previousStreetESSH the previousStreetESSH to set
	 */
	public void setPreviousStreetESSH(Integer previousStreetESSH) {
		this.previousStreetESSH = previousStreetESSH;
	}
	
}
