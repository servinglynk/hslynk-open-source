package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

public class SessionModel {

	private String sessionToken;
	private String trustedAppId;
	private String projectGroupCode;
	private UUID userId;
	private String clientId;
	private String enrollmentId;
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public String getTrustedAppId() {
		return trustedAppId;
	}
	public void setTrustedAppId(String trustedAppId) {
		this.trustedAppId = trustedAppId;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the enrollmentId
	 */
	public String getEnrollmentId() {
		return enrollmentId;
	}
	/**
	 * @param enrollmentId the enrollmentId to set
	 */
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
}
