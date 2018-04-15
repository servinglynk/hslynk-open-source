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
	private Date  dateToStreetESSH;
	private String  householdid;
	private Integer  monthshomelesspastthreeyears;
	private Integer  monthshomelessthistime;
	private UUID  	personalid;
	private UUID  	projectentryid;
	private UUID  	projectid;
	private Integer  relationshiptohoh;
	private Integer  residenceprior;
	private Integer  statusdocumented;
	private Integer lengthOfStay;
	private Integer livingSituation;
	private Integer  timeshomelesspastthreeyears;
	private int  yearshomeless;
	private UUID  clientId;
	private Integer losunderthreshold;
	private Integer previousStreetESSH;
	private String source;
	
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
	public Date getDateToStreetESSH() {
		return dateToStreetESSH;
	}
	public void setDateToStreetESSH(Date dateToStreetESSH) {
		this.dateToStreetESSH = dateToStreetESSH;
	}

	public String getHouseholdid() {
		return householdid;
	}

	public void setHouseholdid(String householdid) {
		this.householdid = householdid;
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

	public Integer getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public Integer getLivingSituation() {
		return livingSituation;
	}

	public void setLivingSituation(Integer livingSituation) {
		this.livingSituation = livingSituation;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
