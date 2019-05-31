package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("enrollment")
public class GlobalEnrollmentMap  extends ClientModel {
	
	private UUID id;
	@NotNull(message="Enrollment id is required")
	private UUID enrollmentId;
	@NotNull(message="Client id is required")
	private UUID clientId;
	@NotNull(message="Enrollment source is required")
	private String source;
	
	
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
}