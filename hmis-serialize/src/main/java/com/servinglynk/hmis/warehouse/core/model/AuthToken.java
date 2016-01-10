package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("auth")
public class AuthToken extends ClientModel {

	 private String grantType;
	 private String code;
	 private String redirectUri;
	 private String refreshToken;
	 
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRedirectUri() {
		return redirectUri;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	 
	 
	 
}
