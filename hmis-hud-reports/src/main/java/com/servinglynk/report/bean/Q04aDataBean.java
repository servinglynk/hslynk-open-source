package com.servinglynk.report.bean;

import java.math.BigInteger;

public class Q04aDataBean extends ReportBean{
	
	private BigInteger q04aHmisProjectIdService;
	private String q04aHmisProjectType;
	private BigInteger q04aIdentityProjectId;
	private String q04aMethodOfTracking;
	private String q04aOrgId;
	private String q04aOrgName;
	private String q04aProjectId;
	private String q04aProjectName;
	private String q04aAffiliatedResidentialProject;
	private String q04aProjectIdsOfAffiliation;
	private String q04acocNumber;
	private String q04aGeoCode;
	private String q04aVictimServiceProvider;
	private String q04aReportStartDate;
	private String q04aReportEndDate;
	private String q04aHmisSoftwareName;
	
	
	/***
	 * 2.01.2	Organization Name
2.01.1	Organization ID
2.02.2	Project Name
2.02.1	Project ID
2.02.6	HMIS Project Type
2.02.6C	Method for Tracking ES 
2.02.6A	Is the Services Only (HMIS Project Type 6) affiliated with a residential project?
2.02.6B	Identify the Project ID’s of the housing projects this project is affiliated with
2.03.1	CoC Number
2.03.2	Geocode
2.01.3	Victim Service Provider

	 * @return
	 */
	public BigInteger getQ04aHmisProjectIdService() {
		return q04aHmisProjectIdService;
	}
	public void setQ04aHmisProjectIdService(BigInteger q04aHmisProjectIdService) {
		this.q04aHmisProjectIdService = q04aHmisProjectIdService;
	}
	public String getQ04aHmisProjectType() {
		return q04aHmisProjectType;
	}
	public void setQ04aHmisProjectType(String q04aHmisProjectType) {
		this.q04aHmisProjectType = q04aHmisProjectType;
	}
	public BigInteger getQ04aIdentityProjectId() {
		return q04aIdentityProjectId;
	}
	public void setQ04aIdentityProjectId(BigInteger q04aIdentityProjectId) {
		this.q04aIdentityProjectId = q04aIdentityProjectId;
	}
	public String getQ04aMethodOfTracking() {
		return q04aMethodOfTracking;
	}
	public void setQ04aMethodOfTracking(String q04aMethodOfTracking) {
		this.q04aMethodOfTracking = q04aMethodOfTracking;
	}
	public String getQ04aOrgId() {
		return q04aOrgId;
	}
	public void setQ04aOrgId(String q04aOrgId) {
		this.q04aOrgId = q04aOrgId;
	}
	public String getQ04aOrgName() {
		return q04aOrgName;
	}
	public void setQ04aOrgName(String q04aOrgName) {
		this.q04aOrgName = q04aOrgName;
	}
	public String getQ04aProjectId() {
		return q04aProjectId;
	}
	public void setQ04aProjectId(String q04aProjectId) {
		this.q04aProjectId = q04aProjectId;
	}
	public String getQ04aProjectName() {
		return q04aProjectName;
	}
	public void setQ04aProjectName(String q04aProjectName) {
		this.q04aProjectName = q04aProjectName;
	}
	public String getQ04aAffiliatedResidentialProject() {
		return q04aAffiliatedResidentialProject;
	}
	public void setQ04aAffiliatedResidentialProject(String q04aAffiliatedResidentialProject) {
		this.q04aAffiliatedResidentialProject = q04aAffiliatedResidentialProject;
	}
	public String getQ04aProjectIdsOfAffiliation() {
		return q04aProjectIdsOfAffiliation;
	}
	public void setQ04aProjectIdsOfAffiliation(String q04aProjectIdsOfAffiliation) {
		this.q04aProjectIdsOfAffiliation = q04aProjectIdsOfAffiliation;
	}
	public String getQ04acocNumber() {
		return q04acocNumber;
	}
	public void setQ04acocNumber(String q04acocNumber) {
		this.q04acocNumber = q04acocNumber;
	}
	public String getQ04aGeoCode() {
		return q04aGeoCode;
	}
	public void setQ04aGeoCode(String q04aGeoCode) {
		this.q04aGeoCode = q04aGeoCode;
	}
	public String getQ04aVictimServiceProvider() {
		return q04aVictimServiceProvider;
	}
	public void setQ04aVictimServiceProvider(String q04aVictimServiceProvider) {
		this.q04aVictimServiceProvider = q04aVictimServiceProvider;
	}
	public String getQ04aReportStartDate() {
		return q04aReportStartDate;
	}
	public void setQ04aReportStartDate(String q04aReportStartDate) {
		this.q04aReportStartDate = q04aReportStartDate;
	}
	public String getQ04aReportEndDate() {
		return q04aReportEndDate;
	}
	public void setQ04aReportEndDate(String q04aReportEndDate) {
		this.q04aReportEndDate = q04aReportEndDate;
	}
	public String getQ04aHmisSoftwareName() {
		return q04aHmisSoftwareName;
	}
	public void setQ04aHmisSoftwareName(String q04aHmisSoftwareName) {
		this.q04aHmisSoftwareName = q04aHmisSoftwareName;
	}
	
	}
