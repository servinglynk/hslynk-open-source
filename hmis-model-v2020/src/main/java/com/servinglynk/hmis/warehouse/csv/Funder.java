package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
										

public class Funder extends BaseCSV {
	@MapToColumn(column=0)
	private String FunderID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String Funder;
	@MapToColumn(column=3)
	private String GrantID;
	@MapToColumn(column=4)
	private String StartDate;
	@MapToColumn(column=5)
	private String EndDate;
	@MapToColumn(column=6)
	private String DateCreated;
	@MapToColumn(column=7)
	private String DateUpdated;
	@MapToColumn(column=8)
	private String UserID;
	@MapToColumn(column=9)
	private String DateDeleted;
	@MapToColumn(column=10)
	private String ExportID;
	public String getFunderID() {
		return FunderID;
	}
	public void setFunderID(String funderID) {
		FunderID = funderID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getFunder() {
		return Funder;
	}
	public void setFunder(String funder) {
		Funder = funder;
	}
	public String getGrantID() {
		return GrantID;
	}
	public void setGrantID(String grantID) {
		GrantID = grantID;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
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
