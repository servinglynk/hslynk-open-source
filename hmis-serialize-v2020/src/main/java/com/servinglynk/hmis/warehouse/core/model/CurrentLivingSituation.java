package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("currentLivingSituation")
public class CurrentLivingSituation extends ClientModel {

	private UUID currentLivingSituationId;
	private UUID enrollmentid;
	private String livingSituation;
	private String verifiedBy;
	private String locationdetails;
	private String leavesituation14days;
	private String subsequentresidence;
	private String resourcestoobtain;
	private String movedtwoormore;
	private String currentLivingSituation;
	
	/*
	/**
	 * @return the currentLivingSituation
	 */
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @return the currentLivingSituationId
	 */
	public UUID getCurrentLivingSituationId() {
		return currentLivingSituationId;
	}
	/**
	 * @param currentLivingSituationId the currentLivingSituationId to set
	 */
	public void setCurrentLivingSituationId(UUID currentLivingSituationId) {
		this.currentLivingSituationId = currentLivingSituationId;
	}
	/**
	 * @return the currentLivingSituation
	 */
	public String getCurrentLivingSituation() {
		return currentLivingSituation;
	}
	/**
	 * @param currentLivingSituation the currentLivingSituation to set
	 */
	public void setCurrentLivingSituation(String currentLivingSituation) {
		this.currentLivingSituation = currentLivingSituation;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the livingSituation
	 */
	public String getLivingSituation() {
		return livingSituation;
	}
	/**
	 * @param livingSituation the livingSituation to set
	 */
	public void setLivingSituation(String livingSituation) {
		this.livingSituation = livingSituation;
	}
	/**
	 * @return the verifiedBy
	 */
	public String getVerifiedBy() {
		return verifiedBy;
	}
	/**
	 * @param verifiedBy the verifiedBy to set
	 */
	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}
	/**
	 * @return the locationdetails
	 */
	public String getLocationdetails() {
		return locationdetails;
	}
	/**
	 * @param locationdetails the locationdetails to set
	 */
	public void setLocationdetails(String locationdetails) {
		this.locationdetails = locationdetails;
	}
	/**
	 * @return the leavesituation14days
	 */
	public String getLeavesituation14days() {
		return leavesituation14days;
	}
	/**
	 * @param leavesituation14days the leavesituation14days to set
	 */
	public void setLeavesituation14days(String leavesituation14days) {
		this.leavesituation14days = leavesituation14days;
	}
	/**
	 * @return the subsequentresidence
	 */
	public String getSubsequentresidence() {
		return subsequentresidence;
	}
	/**
	 * @param subsequentresidence the subsequentresidence to set
	 */
	public void setSubsequentresidence(String subsequentresidence) {
		this.subsequentresidence = subsequentresidence;
	}
	/**
	 * @return the resourcestoobtain
	 */
	public String getResourcestoobtain() {
		return resourcestoobtain;
	}
	/**
	 * @param resourcestoobtain the resourcestoobtain to set
	 */
	public void setResourcestoobtain(String resourcestoobtain) {
		this.resourcestoobtain = resourcestoobtain;
	}
	/**
	 * @return the movedtwoormore
	 */
	public String getMovedtwoormore() {
		return movedtwoormore;
	}
	/**
	 * @param movedtwoormore the movedtwoormore to set
	 */
	public void setMovedtwoormore(String movedtwoormore) {
		this.movedtwoormore = movedtwoormore;
	}
	
}
