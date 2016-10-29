package com.servinglynk.hmis.warehouse.model.v2016;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Enrollment extends BaseModel{
	
	/*@Column(name="continuouslyhomelessoneyear")
	public String continuouslyhomelessoneyear;*/
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
	/*@Column(name="personalid")			
	public UUID personalid;*/
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
	@Column(name="chronicHomeless")
	private boolean chronicHomeless;
	
	public String getDisablingcondition() {
		return disablingcondition;
	}
	public void setDisablingcondition(String disablingcondition) {
		this.disablingcondition = disablingcondition;
	}
	public Timestamp getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Timestamp entrydate) {
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
	public String getYearshomeless() {
		return yearshomeless;
	}
	public void setYearshomeless(String yearshomeless) {
		this.yearshomeless = yearshomeless;
	}
	public UUID getClient_id() {
		return client_id;
	}
	public void setClient_id(UUID client_id) {
		this.client_id = client_id;
	}
	public boolean isChronicHomeless() {
		return chronicHomeless;
	}
	public void setChronicHomeless(boolean chronicHomeless) {
		this.chronicHomeless = chronicHomeless;
	}
}
