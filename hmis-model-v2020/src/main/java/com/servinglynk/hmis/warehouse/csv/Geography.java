package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

/*GeographyID	ProjectID	CoCCode	InformationDate	Geocode	GeographyType	Address1	Address2	City	State	ZIP	DateCreated	DateUpdated	UserID	DateDeleted	ExportID */
public class Geography extends BaseCSV {
	
	@MapToColumn(column=0)
	private String GeographyID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String CoCCode;
	@MapToColumn(column=3)
	private String InformationDate;
	@MapToColumn(column=4)
	private String Geocode;
	@MapToColumn(column=5)
	private String GeographyType;
	@MapToColumn(column=6)
	private String Address1;
	@MapToColumn(column=7)
	private String Address2;
	@MapToColumn(column=8)
	private String City;
	@MapToColumn(column=9)
	private String State;
	@MapToColumn(column=10)
	private String ZIP;
	@MapToColumn(column=11)
	private String DateCreated;
	@MapToColumn(column=12)
	private String DateUpdated;
	@MapToColumn(column=13)
	private String UserID;
	@MapToColumn(column=14)
	private String DateDeleted;
	@MapToColumn(column=15)
	private String ExportID;
	public String getGeographyID() {
		return GeographyID;
	}
	public void setGeographyID(String geographyID) {
		GeographyID = geographyID;
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
	public String getInformationDate() {
		return InformationDate;
	}
	public void setInformationDate(String informationDate) {
		InformationDate = informationDate;
	}
	public String getGeocode() {
		return Geocode;
	}
	public void setGeocode(String geocode) {
		Geocode = geocode;
	}
	public String getGeographyType() {
		return GeographyType;
	}
	public void setGeographyType(String geographyType) {
		GeographyType = geographyType;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
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
