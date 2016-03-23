package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("preferences")
public class Preferences extends ClientModel {
	
	@JsonProperty("locale")
	private Locale locale;
	
	private String  newsletterOptIn;
	
	public String getNewsletterOptIn() {
		return newsletterOptIn;
	}

	public void setNewsletterOptIn(String newsletterOptIn) {
		this.newsletterOptIn = newsletterOptIn;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}
	
	
}
