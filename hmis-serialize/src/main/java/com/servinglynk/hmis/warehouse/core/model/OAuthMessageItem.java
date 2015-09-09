package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("oAuthMessageItem")
public class OAuthMessageItem {
	

	private String consentMessage;

	private Boolean detailedConsentMessageExists;

	private String detailedConsentMessage;

	public String getConsentMessage() {
		return consentMessage;
	}

	public void setConsentMessage(String consentMessage) {
		this.consentMessage = consentMessage;
	}

	public Boolean getDetailedConsentMessageExists() {
		return detailedConsentMessageExists;
	}

	public void setDetailedConsentMessageExists(Boolean detailedConsentMessageExists) {
		this.detailedConsentMessageExists = detailedConsentMessageExists;
	}

	public String getDetailedConsentMessage() {
		return detailedConsentMessage;
	}

	public void setDetailedConsentMessage(String detailedConsentMessage) {
		this.detailedConsentMessage = detailedConsentMessage;
	}
}
