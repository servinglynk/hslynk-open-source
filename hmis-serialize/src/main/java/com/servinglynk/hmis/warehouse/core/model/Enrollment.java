package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class Enrollment extends ClientModel {
	
	
	
	private UUID enrollmentId;
	private String continuouslyhomelessoneyear;
	private String  disablingcondition;
	private Date  entrydate;
	private UUID  householdid;
	private String  housingstatus;
	private String  monthshomelesspastthreeyears;
	private String  monthshomelessthistime;
	private String  otherresidenceprior;
	private UUID  	personalid;
	private UUID  	projectentryid;
	private UUID  	projectid;
	private String  relationshiptohoh;
	private String  residenceprior;
	private String  residencepriorlengthofstay;
	private String  statusdocumented;
	private String  timeshomelesspastthreeyears;
	private int  yearshomeless;
	private UUID  clientId;
	

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

	public String getContinuouslyhomelessoneyear() {
		return continuouslyhomelessoneyear;
	}

	public void setContinuouslyhomelessoneyear(String continuouslyhomelessoneyear) {
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
	}

	public String getDisablingcondition() {
		return disablingcondition;
	}

	public void setDisablingcondition(String disablingcondition) {
		this.disablingcondition = disablingcondition;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public UUID getHouseholdid() {
		return householdid;
	}

	public void setHouseholdid(UUID householdid) {
		this.householdid = householdid;
	}

	public String getHousingstatus() {
		return housingstatus;
	}

	public void setHousingstatus(String housingstatus) {
		this.housingstatus = housingstatus;
	}

	public String getMonthshomelesspastthreeyears() {
		return monthshomelesspastthreeyears;
	}

	public void setMonthshomelesspastthreeyears(String monthshomelesspastthreeyears) {
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
	}

	public String getMonthshomelessthistime() {
		return monthshomelessthistime;
	}

	public void setMonthshomelessthistime(String monthshomelessthistime) {
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

	public String getRelationshiptohoh() {
		return relationshiptohoh;
	}

	public void setRelationshiptohoh(String relationshiptohoh) {
		this.relationshiptohoh = relationshiptohoh;
	}

	public String getResidenceprior() {
		return residenceprior;
	}

	public void setResidenceprior(String residenceprior) {
		this.residenceprior = residenceprior;
	}

	public String getResidencepriorlengthofstay() {
		return residencepriorlengthofstay;
	}

	public void setResidencepriorlengthofstay(String residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}

	public String getStatusdocumented() {
		return statusdocumented;
	}

	public void setStatusdocumented(String statusdocumented) {
		this.statusdocumented = statusdocumented;
	}

	public String getTimeshomelesspastthreeyears() {
		return timeshomelesspastthreeyears;
	}

	public void setTimeshomelesspastthreeyears(String timeshomelesspastthreeyears) {
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
}
