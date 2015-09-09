package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName("oAuthRevokedToken")
public class OAuthRevokedToken {
	
	private String accessToken;

	private String consentToken;

	private String refreshToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getConsentToken() {
		return consentToken;
	}

	public void setConsentToken(String consentToken) {
		this.consentToken = consentToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}