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
	
	//Setting default values in the constructor.
	public Q04aDataBean() {
		this.q04aHmisProjectIdService=BigInteger.ZERO;
		this.q04aHmisProjectType="7";
		this.q04aIdentityProjectId=BigInteger.ZERO;;
		this.q04aMethodOfTracking="0";
		this.q04aOrgId="0";
		this.q04aOrgName="0";
		this.q04aProjectId="0";
		this.q04aProjectName="0";
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
