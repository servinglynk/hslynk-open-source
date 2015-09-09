package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("oAuthMessageGroup")
public class OAuthMessageGroup {

	private String consentMessage;

	private String detailedConsentMessage;
	
	private Boolean detailedConsentMessageExists;

	@JsonProperty(value="oAuthMessageItems")
	private List<OAuthMessageItem> oAuthMessageItems;

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

	public List<OAuthMessageItem> getoAuthMessageItems() {
		return oAuthMessageItems;
	}

	public void setoAuthMessageItems(List<OAuthMessageItem> oAuthMessageItems) {
		this.oAuthMessageItems = oAuthMessageItems;
	}

	public String getDetailedConsentMessage() {
		return detailedConsentMessage;
	}

	public void setDetailedConsentMessage(String detailedConsentMessage) {
		this.detailedConsentMessage = detailedConsentMessage;
	}
}
