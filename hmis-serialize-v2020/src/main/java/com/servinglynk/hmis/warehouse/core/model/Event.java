package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("event")
public class Event extends ClientModel {

	private UUID eventId;
	private UUID enrollmentid;
	 @JsonSerialize(using=JsonDateSerializer.class)
     @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime eventDate;
	 @JsonSerialize(using=JsonDateSerializer.class)
     @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime resultDate;
	private String locationcrisisorphhousing;
	private String referralResult;
	private String event;
	private String referralCaseManageAfter;
	/**
	 * @return the eventId
	 */
	public UUID getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the eventDate
	 */
	public LocalDateTime getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the resultDate
	 */
	public LocalDateTime getResultDate() {
		return resultDate;
	}
	/**
	 * @param resultDate the resultDate to set
	 */
	public void setResultDate(LocalDateTime resultDate) {
		this.resultDate = resultDate;
	}
	/**
	 * @return the locationcrisisorphhousing
	 */
	public String getLocationcrisisorphhousing() {
		return locationcrisisorphhousing;
	}
	/**
	 * @param locationcrisisorphhousing the locationcrisisorphhousing to set
	 */
	public void setLocationcrisisorphhousing(String locationcrisisorphhousing) {
		this.locationcrisisorphhousing = locationcrisisorphhousing;
	}
	/**
	 * @return the referralResult
	 */
	public String getReferralResult() {
		return referralResult;
	}
	/**
	 * @param referralResult the referralResult to set
	 */
	public void setReferralResult(String referralResult) {
		this.referralResult = referralResult;
	}
	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * @return the referralCaseManageAfter
	 */
	public String getReferralCaseManageAfter() {
		return referralCaseManageAfter;
	}
	/**
	 * @param referralCaseManageAfter the referralCaseManageAfter to set
	 */
	public void setReferralCaseManageAfter(String referralCaseManageAfter) {
		this.referralCaseManageAfter = referralCaseManageAfter;
	}
}
