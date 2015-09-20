package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Organization {
	@MapToColumn(column=0)
	private String OrganizationID;
	@MapToColumn(column=1)
	private String OrganizationName;
	@MapToColumn(column=2)
	private String OrganizationCommonName;
	@MapToColumn(column=3)
	private String DateCreated;
	@MapToColumn(column=4)
	private String DateUpdated;
	@MapToColumn(column=5)
	private String UserID;
	@MapToColumn(column=6)
	private String DateDeleted;
	@MapToColumn(column=7)
	private String ExportID;
	public String getOrganizationID() {
		return OrganizationID;
	}
	public void setOrganizationID(String organizationID) {
		OrganizationID = organizationID;
	}
	public String getOrganizationName() {
		return OrganizationName;
	}
	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}
	public String getOrganizationCommonName() {
		return OrganizationCommonName;
	}
	public void setOrganizationCommonName(String organizationCommonName) {
		OrganizationCommonName = organizationCommonName;
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
