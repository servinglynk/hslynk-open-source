package com.servinglynk.hmis.warehouse.core.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("oAuthAuthorization")
public class OAuthAuthorization extends ClientModel {
	

	private String accessToken;

	private String tokenType;

	private Integer expiresIn;

	private String refreshToken;

	private String authCode;
	
	private String redirectUri;
	
	private String consentToken;
	
	private Integer nextAction;
	
	private String state;
	
	private String grantType;
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	
	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getConsentToken() {
		return consentToken;
	}

	public void setConsentToken(String consentToken) {
		this.consentToken = consentToken;
	}

	public Integer getNextAction() {
		return nextAction;
	}

	public void setNextAction(Integer nextAction) {
		this.nextAction = nextAction;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}