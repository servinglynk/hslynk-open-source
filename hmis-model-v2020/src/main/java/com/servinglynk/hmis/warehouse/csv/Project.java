package com.servinglynk.hmis.warehouse.csv;

import com.googlecode.jcsv.annotations.MapToColumn;
/**
 * ProjectID	OrganizationID	ProjectName	ProjectCommonName	ContinuumProject	
 * ProjectType	ResidentialAffiliation	TrackingMethod	TargetPopulation	
 * PITCount	DateCreated	DateUpdated	UserID	DateDeleted	ExportID

 * @author sdolia
 *
 */
public class Project extends BaseCSV{
	@MapToColumn(column=0)
	private String ProjectID;
	@MapToColumn(column=1)
	private String OrganizationID;
	@MapToColumn(column=2)
	private String ProjectName;
	@MapToColumn(column=3)
	private String ProjectCommonName;
	@MapToColumn(column=4)
	private String OperatingStartDate;
	@MapToColumn(column=5)
	private String OperatingEndDate;
	@MapToColumn(column=6)
	private String ContinuumProject;
	@MapToColumn(column=7)
	private String ProjectType;
	@MapToColumn(column=8)
	private String HousingType;
	@MapToColumn(column=9)
	private String ResidentialAffiliation;
	@MapToColumn(column=10)
	private String TrackingMethod;
	@MapToColumn(column=11)
	private String HMISParticipatingProject;
	@MapToColumn(column=12)
	private String TargetPopulation;
	@MapToColumn(column=13)
	private String PITCount;
	@MapToColumn(column=14)
	private String DateCreated;
	@MapToColumn(column=15)
	private String DateUpdated;
	@MapToColumn(column=16)
	private String UserID;
	@MapToColumn(column=17)
	private String DateDeleted;
	@MapToColumn(column=18)
	private String ExportID;
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getOrganizationID() {
		return OrganizationID;
	}
	public void setOrganizationID(String organizationID) {
		OrganizationID = organizationID;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectCommonName() {
		return ProjectCommonName;
	}
	public void setProjectCommonName(String projectCommonName) {
		ProjectCommonName = projectCommonName;
	}
	public String getContinuumProject() {
		return ContinuumProject;
	}
	public void setContinuumProject(String continuumProject) {
		ContinuumProject = continuumProject;
	}
	public String getProjectType() {
		return ProjectType;
	}
	public void setProjectType(String projectType) {
		ProjectType = projectType;
	}
	public String getResidentialAffiliation() {
		return ResidentialAffiliation;
	}
	public void setResidentialAffiliation(String residentialAffiliation) {
		ResidentialAffiliation = residentialAffiliation;
	}
	public String getTrackingMethod() {
		return TrackingMethod;
	}
	public void setTrackingMethod(String trackingMethod) {
		TrackingMethod = trackingMethod;
	}
	public String getTargetPopulation() {
		return TargetPopulation;
	}
	public void setTargetPopulation(String targetPopulation) {
		TargetPopulation = targetPopulation;
	}
	public String getPITCount() {
		return PITCount;
	}
	public void setPITCount(String pITCount) {
		PITCount = pITCount;
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
	/**
	 * @return the operatingStartDate
	 */
	public String getOperatingStartDate() {
		return OperatingStartDate;
	}
	/**
	 * @param operatingStartDate the operatingStartDate to set
	 */
	public void setOperatingStartDate(String operatingStartDate) {
		OperatingStartDate = operatingStartDate;
	}
	/**
	 * @return the operatingEndDate
	 */
	public String getOperatingEndDate() {
		return OperatingEndDate;
	}
	/**
	 * @param operatingEndDate the operatingEndDate to set
	 */
	public void setOperatingEndDate(String operatingEndDate) {
		OperatingEndDate = operatingEndDate;
	}
	
	/**
	 * @return the hMISParticipatingProject
	 */
	public String getHMISParticipatingProject() {
		return HMISParticipatingProject;
	}
	/**
	 * @param hMISParticipatingProject the hMISParticipatingProject to set
	 */
	public void setHMISParticipatingProject(String hMISParticipatingProject) {
		HMISParticipatingProject = hMISParticipatingProject;
	}
	/**
	 * @return the housingType
	 */
	public String getHousingType() {
		return HousingType;
	}
	/**
	 * @param housingType the housingType to set
	 */
	public void setHousingType(String housingType) {
		HousingType = housingType;
	}
	
}
