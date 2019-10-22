package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class ProjectCOC {
	@MapToColumn(column=0)
	private String ProjectCocID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
	@MapToColumn(column=3)
	private String Geocode;
	@MapToColumn(column=4)
	private String Address1;
	@MapToColumn(column=5)
	private String Address2;
	@MapToColumn(column=6)
	private String City;
	@MapToColumn(column=7)
	private String State;
	@MapToColumn(column=8)
	private String ZIP;
	@MapToColumn(column=9)
	private String GeographyType;
	@MapToColumn(column=10)
	private String DateCreated;
	@MapToColumn(column=11)
	private String DateUpdated;
	@MapToColumn(column=12)
	private String UserID;
	@MapToColumn(column=12)
	private String DateDeleted;
	@MapToColumn(column=13)
	private String ExportID;
	public String getProjectCocID() {
		return ProjectCocID;
	}
	public void setProjectCocID(String projectCocID) {
		ProjectCocID = projectCocID;
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
	/**
	 * @return the geocode
	 */
	public String getGeocode() {
		return Geocode;
	}
	/**
	 * @param geocode the geocode to set
	 */
	public void setGeocode(String geocode) {
		Geocode = geocode;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return Address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return Address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return City;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		City = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return State;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		State = state;
	}
	/**
	 * @return the zIP
	 */
	public String getZIP() {
		return ZIP;
	}
	/**
	 * @param zIP the zIP to set
	 */
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	/**
	 * @return the geographyType
	 */
	public String getGeographyType() {
		return GeographyType;
	}
	/**
	 * @param geographyType the geographyType to set
	 */
	public void setGeographyType(String geographyType) {
		GeographyType = geographyType;
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
