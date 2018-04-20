package com.servinglynk.report.model;

public class ProjectModel {
	private String projectname;
	private String projectType;
	private String projectId;
	private String organizationid;
	private String trackingMethod;
	
	public ProjectModel(String projectname, String projectType, String projectId, String organizationid,String trackingMethod) {
		super();
		this.projectname = projectname;
		this.projectType = projectType;
		this.projectId = projectId;
		this.organizationid = organizationid;
		this.trackingMethod = trackingMethod;
	}
	/**
	 * @return the projectname
	 */
	public String getProjectname() {
		return projectname;
	}
	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the organizationid
	 */
	public String getOrganizationid() {
		return organizationid;
	}
	/**
	 * @param organizationid the organizationid to set
	 */
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	/**
	 * @return the trackingMethod
	 */
	public String getTrackingMethod() {
		return trackingMethod;
	}
	/**
	 * @param trackingMethod the trackingMethod to set
	 */
	public void setTrackingMethod(String trackingMethod) {
		this.trackingMethod = trackingMethod;
	}
	
}
