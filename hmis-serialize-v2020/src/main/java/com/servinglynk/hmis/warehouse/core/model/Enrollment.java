package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("enrollment")
public class Enrollment extends ClientModel {
	
	private UUID enrollmentId;
	
	@JsonProperty("continuouslyHomelessOneYear")
	private Integer continuouslyhomelessoneyear;
	
	@JsonProperty("disablingCondition")
	private Integer  disablingcondition;
	
	
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    @JsonProperty("dateToStreetESSH")
    private LocalDateTime dateToStreetESSH;
    
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    @JsonProperty("entryDate")
    private LocalDateTime entryDate;
	
	@JsonProperty("householdId")
	private String  householdid;
	
	@JsonProperty("monthsHomelessPastThreeYears")
	private Integer  monthshomelesspastthreeyears;
	
	@JsonProperty("monthsHomelessThisTime")
	private Integer  monthshomelessthistime;
	
	@JsonProperty("personalId")
	private UUID  	personalid;
	
	@JsonProperty("projectEntryId")
	private UUID  	projectentryid;
	
	@JsonProperty("projectId")
	private UUID  	projectid;
	
	@JsonProperty("relationshipToHOH")
	private Integer  relationshiptohoh;
	
	@JsonProperty("residencePrior")
	private Integer  residenceprior;
	
	@JsonProperty("statusdocumented")
	private Integer  statusdocumented;
	
	@JsonProperty("lengthOfStay")
	private Integer lengthOfStay;
	
	@JsonProperty("livingSituation")
	private Integer livingSituation;
	
	@JsonProperty("timesHomelessPastThreeYears")
	private Integer  timeshomelesspastthreeyears;
	
	@JsonProperty("yearsHomeless")
	private int  yearshomeless;
	
	@JsonProperty("clientId")
	private UUID  clientId;
	
	@JsonProperty("losUnderThreshold")
	private Integer losunderthreshold;
	
	@JsonProperty("previousStreetESSH")
	private Integer previousStreetESSH;
	
	@JsonProperty("source")
	private String source;
	
	EnrollmentEntryLinks entryLinks;
	
	EnrollmentLinks enrollmentLinks;
	
	Map<String,Map<String,List<ExitActionLinks>>> exitLinks;
	private UUID hmisHouseholdId;
	

	
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

	/**
	 * @return the dateToStreetESSH
	 */
	public LocalDateTime getDateToStreetESSH() {
		return dateToStreetESSH;
	}

	/**
	 * @param dateToStreetESSH the dateToStreetESSH to set
	 */
	public void setDateToStreetESSH(LocalDateTime dateToStreetESSH) {
		this.dateToStreetESSH = dateToStreetESSH;
	}

	/**
	 * @return the entryDate
	 */
	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
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

	public EnrollmentEntryLinks getEntryLinks() {
		return entryLinks;
	}

	public void setEntryLinks(EnrollmentEntryLinks entryLinks) {
		this.entryLinks = entryLinks;
	}

	public EnrollmentLinks getEnrollmentLinks() {
		return enrollmentLinks;
	}

	public void setEnrollmentLinks(EnrollmentLinks enrollmentLinks) {
		this.enrollmentLinks = enrollmentLinks;
	}

	public Map<String,Map<String,List<ExitActionLinks>>> getExitLinks() {
		return exitLinks;
	}

	public void setExitLinks(Map<String,Map<String,List<ExitActionLinks>>> exitLinks) {
		this.exitLinks = exitLinks;
	}

	public UUID getHmisHouseholdId() {
		return hmisHouseholdId;
	}

	public void setHmisHouseholdId(UUID hmisHouseholdId) {
		this.hmisHouseholdId = hmisHouseholdId;
	}

/*	public List<ExitActionLink> getExitLinks() {
		return exitLinks;
	}

	public void setExitLinks(List<ExitActionLink> exitLinks) {
		this.exitLinks = exitLinks;
	}*/

	
}
