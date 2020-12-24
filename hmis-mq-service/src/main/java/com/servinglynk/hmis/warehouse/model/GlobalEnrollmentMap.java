package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class GlobalEnrollmentMap {
	
	private UUID id;
	private UUID enrollmentId;
	private UUID clientId;
	private String source;	
	private UUID genericEnrollmentId;
	
	
	private String link;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public UUID getGenericEnrollmentId() {
		return genericEnrollmentId;
	}
	public void setGenericEnrollmentId(UUID genericEnrollmentId) {
		this.genericEnrollmentId = genericEnrollmentId;
	}
}