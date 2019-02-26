package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("globalEnrollment")
public class GlobalEnrollment extends ClientModel {
	
	private UUID id;
	private java.util.UUID dedupClientId;
	private UUID user;
	private GlobalEnrollmentsMap enrollments= new GlobalEnrollmentsMap();
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public java.util.UUID getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(java.util.UUID dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public UUID getUser() {
		return user;
	}
	public void setUser(UUID user) {
		this.user = user;
	}
	public GlobalEnrollmentsMap getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(GlobalEnrollmentsMap enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollment(GlobalEnrollmentMap enrollment) {
		this.enrollments.addGlobalEnrollmentMap(enrollment);
	}
}