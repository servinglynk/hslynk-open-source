package com.servinglynk.report.bean;


public class Q4aBean {
	private String organizationName;
	private String organizationId;
	private String projectName;
	private String projectId;
	private String projectType;
	private String methodOfTracking;
	private String projectTypeId;
	private String identifyProjectId;
	public Q4aBean() {}
	public Q4aBean(String organizationName, String organizationId,
			String projectName, String projectId, String projectType,
			String methodOfTracking, String projectTypeId,
			String identifyProjectId) {
		super();
		this.organizationName = organizationName;
		this.organizationId = organizationId;
		this.projectName = projectName;
		this.projectId = projectId;
		this.projectType = projectType;
		this.methodOfTracking = methodOfTracking;
		this.projectTypeId = projectTypeId;
		this.identifyProjectId = identifyProjectId;
	}
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}
	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	 * @return the methodOfTracking
	 */
	public String getMethodOfTracking() {
		return methodOfTracking;
	}
	/**
	 * @param methodOfTracking the methodOfTracking to set
	 */
	public void setMethodOfTracking(String methodOfTracking) {
		this.methodOfTracking = methodOfTracking;
	}
	/**
	 * @return the projectTypeId
	 */
	public String getProjectTypeId() {
		return projectTypeId;
	}
	/**
	 * @param projectTypeId the projectTypeId to set
	 */
	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	/**
	 * @return the identifyProjectId
	 */
	public String getIdentifyProjectId() {
		return identifyProjectId;
	}
	/**
	 * @param identifyProjectId the identifyProjectId to set
	 */
	public void setIdentifyProjectId(String identifyProjectId) {
		this.identifyProjectId = identifyProjectId;
	}
	

}
