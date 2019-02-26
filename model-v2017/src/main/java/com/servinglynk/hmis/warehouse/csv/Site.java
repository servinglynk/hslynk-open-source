package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Site {
	@MapToColumn(column=0)
	private String SiteID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
	@MapToColumn(column=3)
	private String PrincipalSite;
	@MapToColumn(column=4)
	private String Geocode;
	@MapToColumn(column=5)
	private String Address;
	@MapToColumn(column=6)
	private String City;
	@MapToColumn(column=7)
	private String State;
	@MapToColumn(column=8)
	private String ZIP;
	@MapToColumn(column=9)
	private String DateCreated;
	@MapToColumn(column=10)
	private String DateUpdated;
	@MapToColumn(column=11)
	private String UserID;
	@MapToColumn(column=12)
	private String DateDeleted;
	@MapToColumn(column=13)
	private String ExportID;
	public String getSiteID() {
		return SiteID;
	}
	public void setSiteID(String siteID) {
		SiteID = siteID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getCoCCode() {
		return CoCCode;
	}
	public void setCoCCode(String coCCode) {
		CoCCode = coCCode;
	}
	public String getPrincipalSite() {
		return PrincipalSite;
	}
	public void setPrincipalSite(String principalSite) {
		PrincipalSite = principalSite;
	}
	public String getGeocode() {
		return Geocode;
	}
	public void setGeocode(String geocode) {
		Geocode = geocode;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getDateDeleted() {
		return DateDeleted;
	}
	public void setDateDeleted(String dateDeleted) {
		DateDeleted = dateDeleted;
	}
	public String getExportID() {
		return ExportID;
	}
	public void setExportID(String exportID) {
		ExportID = exportID;
	}
	
}
