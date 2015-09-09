package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("accountConsent")
public class AccountConsent extends ClientModel {

	private String token;


	private Date consentedAt;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getConsentedAt() {
		return consentedAt;
	}

	public void setConsentedAt(Date consentedAt) {
		this.consentedAt = consentedAt;
	}

}
