package com.servinglynk.hmis.warehouse.core.model;



import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("locale")
public class Locale extends ClientModel {
	
	private String localeId;

	private String language;

	private String country;

	private String friendlyName;
	
	public Locale()	{}
	
	public Locale(String language, String country)	{
		this.language = language;
		this.country = country;
	}
	
	public Locale(String language)	{
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getLocaleId() {
		return localeId;
	}

	public void setLocaleId(String localeId) {
		this.localeId = localeId;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String toString(){
		return language+"_"+country;
	}
	

	public String toLocaleString(){
		if(country!=null && country.trim().length()>0)
		return language+"-"+country;
		return language;
	}
}
