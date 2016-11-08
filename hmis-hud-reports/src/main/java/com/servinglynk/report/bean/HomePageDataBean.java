package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

public class HomePageDataBean {
	
	private String homePageStartDate;
	private String homePageEndDate;
	private String homePageProjects;
	private String homePageHomeLess;
	private String homePageGrants;
	private String homePageView;
	
	private Timestamp crtdUpdtdDate;
	private Boolean delFlag;
	private BigInteger q04aHmisProjectIdService;
	private String q04aHmisProjectType;
	private BigInteger q04aIdentityProjectId;
	private String q04aMethodOfTracking;
	private String q04aOrgId;
	private String q04aOrgName;
	private String q04aProjectId;
	private String q04aProjectName;
	
	private List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean;
	private List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean;
	private List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean;
	private List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean;
	private List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean;
	private List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	private List<Q09aNumberPersonsContactedDataBean> qQ09aNumberPersonsContactedDataBean;
	private List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean;
	
	
	public List<Q09bNumberofPersonsEngagedDataBean> getQ09bNumberofPersonsEngagedDataBean() {
		return q09bNumberofPersonsEngagedDataBean;
	}
	public void setQ09bNumberofPersonsEngagedDataBean(
			List<Q09bNumberofPersonsEngagedDataBean> q09bNumberofPersonsEngagedDataBean) {
		this.q09bNumberofPersonsEngagedDataBean = q09bNumberofPersonsEngagedDataBean;
	}
	public List<Q09aNumberPersonsContactedDataBean> getqQ09aNumberPersonsContactedDataBean() {
		return qQ09aNumberPersonsContactedDataBean;
	}
	public void setqQ09aNumberPersonsContactedDataBean(
			List<Q09aNumberPersonsContactedDataBean> qQ09aNumberPersonsContactedDataBean) {
		this.qQ09aNumberPersonsContactedDataBean = qQ09aNumberPersonsContactedDataBean;
	}
	public List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayDataBean() {
		return q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public void setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(
			List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> q07bPointInTimeCountHouseholdsLastWednesdayDataBean) {
		this.q07bPointInTimeCountHouseholdsLastWednesdayDataBean = q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
	}
	public List<Q07aHouseholdsServedDataBean> getQ07aHouseholdsServedDataBean() {
		return q07aHouseholdsServedDataBean;
	}
	public void setQ07aHouseholdsServedDataBean(
			List<Q07aHouseholdsServedDataBean> q07aHouseholdsServedDataBean) {
		this.q07aHouseholdsServedDataBean = q07aHouseholdsServedDataBean;
	}
	public List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayDataBean() {
		return q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public void setQ06cPointInTimeCountPersonsLastWednesdayDataBean(
			List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> q06cPointInTimeCountPersonsLastWednesdayDataBean) {
		this.q06cPointInTimeCountPersonsLastWednesdayDataBean = q06cPointInTimeCountPersonsLastWednesdayDataBean;
	}
	public List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedDataBean() {
		return q06bNumberOfPersonsServedDataBean;
	}
	public void setQ06bNumberOfPersonsServedDataBean(
			List<Q06bNumberOfPersonsServedDataBean> q06bNumberOfPersonsServedDataBean) {
		this.q06bNumberOfPersonsServedDataBean = q06bNumberOfPersonsServedDataBean;
	}
	public List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableDataBean() {
		return q06aReportValidationsTableDataBean;
	}
	public void setQ06aReportValidationsTableDataBean(
			List<Q06aReportValidationsTableDataBean> q06aReportValidationsTableDataBean) {
		this.q06aReportValidationsTableDataBean = q06aReportValidationsTableDataBean;
	}
	public List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISComparableDBDataQualityDataBean() {
		return q05aHMISComparableDBDataQualityDataBean;
	}
	public void setQ05aHMISComparableDBDataQualityDataBean(
			List<Q05aHMISComparableDBDataQualityDataBean> q05aHMISComparableDBDataQualityDataBean) {
		this.q05aHMISComparableDBDataQualityDataBean = q05aHMISComparableDBDataQualityDataBean;
	}
	
	public String getHomePageStartDate() {
		return homePageStartDate;
	}
	public void setHomePageStartDate(String homePageStartDate) {
		this.homePageStartDate = homePageStartDate;
	}
	public String getHomePageEndDate() {
		return homePageEndDate;
	}
	public void setHomePageEndDate(String homePageEndDate) {
		this.homePageEndDate = homePageEndDate;
	}
	public String getHomePageProjects() {
		return homePageProjects;
	}
	public void setHomePageProjects(String homePageProjects) {
		this.homePageProjects = homePageProjects;
	}
	public String getHomePageHomeLess() {
		return homePageHomeLess;
	}
	public void setHomePageHomeLess(String homePageHomeLess) {
		this.homePageHomeLess = homePageHomeLess;
	}
	public String getHomePageGrants() {
		return homePageGrants;
	}
	public void setHomePageGrants(String homePageGrants) {
		this.homePageGrants = homePageGrants;
	}
	public String getHomePageView() {
		return homePageView;
	}
	public void setHomePageView(String homePageView) {
		this.homePageView = homePageView;
	}
	public Timestamp getCrtdUpdtdDate() {
		return crtdUpdtdDate;
	}
	public void setCrtdUpdtdDate(Timestamp crtdUpdtdDate) {
		this.crtdUpdtdDate = crtdUpdtdDate;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
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
}
