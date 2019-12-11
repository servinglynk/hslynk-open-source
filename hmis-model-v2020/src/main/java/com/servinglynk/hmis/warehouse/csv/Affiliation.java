package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;

/*AffiliationID	ProjectID	ResProjectID	DateCreated	DateUpdated	UserID	DateDeleted	ExportID */
public class Affiliation extends BaseCSV {
	
	@MapToColumn(column=0)
	private String AffiliationID;
	@MapToColumn(column=1)
	private String ProjectID;
	@MapToColumn(column=2)
	private String ResProjectID;
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
	public String getAffiliationID() {
		return AffiliationID;
	}
	public void setAffiliationID(String affiliationID) {
		AffiliationID = affiliationID;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getResProjectID() {
		return ResProjectID;
	}
	public void setResProjectID(String resProjectID) {
		ResProjectID = resProjectID;
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
