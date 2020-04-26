package com.servinglynk.hmis.warehouse.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class EnrollmentModel {
	
	private UUID enrollmentId;
	private Integer continuouslyhomelessoneyear;
	private Integer continuouslyHomelessOneYear;
	private Integer disablingCondition;
	private Integer  disablingcondition;
	private Date  entryDate;
	private Date  entrydate;
	private Date  dateToStreetESSH;
	private String  householdId;
	private String  householdid;
	private Integer   monthsHomelessPastThreeYears;
	private Integer  monthshomelesspastthreeyears;
	private Integer  monthsHomelessThisTime;
	private Integer  monthshomelessthistime;
	private UUID  personalId;
	private UUID  	personalid;
	private UUID  projectEntryId;
	private UUID  	projectentryid;
	private UUID  projectId;
	private UUID  	projectid;
	private Integer relationshipToHOH;
	private Integer  relationshiptohoh;
	private Integer residencePrior;
	private Integer  residenceprior;
	private Integer  statusdocumented;
	private Integer lengthOfStay;
	private Integer livingSituation;
	private Integer  timesHomelessPastThreeYears;
	private Integer  timeshomelesspastthreeyears;
	private int  yearsHomeless;
	private int  yearshomeless;
	private UUID  clientId;
	private Integer losUnderThreshold;
	private Integer losunderthreshold;
	private Integer previousStreetESSH;
	private UUID hmisHouseholdId;
	private UUID genericHouseHoldId;
	private boolean chronicHomeless;
	private Integer  housingstatus;
	private String  otherresidenceprior;
	private Integer  residencepriorlengthofstay;
	private Integer entryfromstreetessh;
	private String source;
	
	
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

	public Integer getLosunderthreshold() {
		return losunderthreshold;
	}

	public void setLosunderthreshold(Integer losunderthreshold) {
		this.losunderthreshold = losunderthreshold;
	}

	public Integer getPreviousStreetESSH() {
		return previousStreetESSH;
	}

	public void setPreviousStreetESSH(Integer previousStreetESSH) {
		this.previousStreetESSH = previousStreetESSH;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public UUID getHmisHouseholdId() {
		return hmisHouseholdId;
	}

	public void setHmisHouseholdId(UUID hmisHouseholdId) {
		this.hmisHouseholdId = hmisHouseholdId;
	}

	public UUID getGenericHouseHoldId() {
		return genericHouseHoldId;
	}

	public void setGenericHouseHoldId(UUID genericHouseHoldId) {
		this.genericHouseHoldId = genericHouseHoldId;
	}

	public Integer getContinuouslyHomelessOneYear() {
		return continuouslyHomelessOneYear;
	}

	public void setContinuouslyHomelessOneYear(Integer continuouslyHomelessOneYear) {
		this.continuouslyHomelessOneYear = continuouslyHomelessOneYear;
	}

	public Integer getDisablingCondition() {
		return disablingCondition;
	}

	public void setDisablingCondition(Integer disablingCondition) {
		this.disablingCondition = disablingCondition;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getHouseholdId() {
		return householdId;
	}

	public void setHouseholdId(String householdId) {
		this.householdId = householdId;
	}

	public Integer getMonthsHomelessPastThreeYears() {
		return monthsHomelessPastThreeYears;
	}

	public void setMonthsHomelessPastThreeYears(Integer monthsHomelessPastThreeYears) {
		this.monthsHomelessPastThreeYears = monthsHomelessPastThreeYears;
	}

	public Integer getMonthsHomelessThisTime() {
		return monthsHomelessThisTime;
	}

	public void setMonthsHomelessThisTime(Integer monthsHomelessThisTime) {
		this.monthsHomelessThisTime = monthsHomelessThisTime;
	}

	public UUID getPersonalId() {
		return personalId;
	}

	public void setPersonalId(UUID personalId) {
		this.personalId = personalId;
	}

	public UUID getProjectEntryId() {
		return projectEntryId;
	}

	public void setProjectEntryId(UUID projectEntryId) {
		this.projectEntryId = projectEntryId;
	}

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public Integer getRelationshipToHOH() {
		return relationshipToHOH;
	}

	public void setRelationshipToHOH(Integer relationshipToHOH) {
		this.relationshipToHOH = relationshipToHOH;
	}

	public Integer getResidencePrior() {
		return residencePrior;
	}

	public void setResidencePrior(Integer residencePrior) {
		this.residencePrior = residencePrior;
	}

	public Integer getTimesHomelessPastThreeYears() {
		return timesHomelessPastThreeYears;
	}

	public void setTimesHomelessPastThreeYears(Integer timesHomelessPastThreeYears) {
		this.timesHomelessPastThreeYears = timesHomelessPastThreeYears;
	}

	public int getYearsHomeless() {
		return yearsHomeless;
	}

	public void setYearsHomeless(int yearsHomeless) {
		this.yearsHomeless = yearsHomeless;
	}

	public Integer getLosUnderThreshold() {
		return losUnderThreshold;
	}

	public void setLosUnderThreshold(Integer losUnderThreshold) {
		this.losUnderThreshold = losUnderThreshold;
	}

	public boolean isChronicHomeless() {
		return chronicHomeless;
	}

	public void setChronicHomeless(boolean chronicHomeless) {
		this.chronicHomeless = chronicHomeless;
	}

	public Integer getHousingstatus() {
		return housingstatus;
	}

	public void setHousingstatus(Integer housingstatus) {
		this.housingstatus = housingstatus;
	}

	public String getOtherresidenceprior() {
		return otherresidenceprior;
	}

	public void setOtherresidenceprior(String otherresidenceprior) {
		this.otherresidenceprior = otherresidenceprior;
	}

	public Integer getResidencepriorlengthofstay() {
		return residencepriorlengthofstay;
	}

	public void setResidencepriorlengthofstay(Integer residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}

	public Integer getEntryfromstreetessh() {
		return entryfromstreetessh;
	}

	public void setEntryfromstreetessh(Integer entryfromstreetessh) {
		this.entryfromstreetessh = entryfromstreetessh;
	}
}