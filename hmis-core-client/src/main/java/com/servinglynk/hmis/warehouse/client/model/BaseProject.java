package com.servinglynk.hmis.warehouse.client.model;

import java.util.UUID;

public class BaseProject extends ClientModel {


	private UUID projectId;
    private String projectName;
    private String projectCommonName;
    private Integer continuumProject;
    private Integer projectType;
    private Integer residentialAffiliation;
    private Integer targetPopulation;
    private Integer trackingMethod;
    private Integer schemaYear;
    private String link;
    private String projectGroup;
    
	public BaseProject() {
		
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public BaseProject(UUID projectId) {
		this.projectId = projectId;
	}

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public String getProjectCommonName() {
		return projectCommonName;
	}

	public void setProjectCommonName(String projectCommonName) {
		this.projectCommonName = projectCommonName;
	}

	public Integer getContinuumProject() {
		return continuumProject;
	}

	public void setContinuumProject(Integer continuumProject) {
		this.continuumProject = continuumProject;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Integer getResidentialAffiliation() {
		return residentialAffiliation;
	}

	public void setResidentialAffiliation(Integer residentialAffiliation) {
		this.residentialAffiliation = residentialAffiliation;
	}

	public Integer getTargetPopulation() {
		return targetPopulation;
	}

	public void setTargetPopulation(Integer targetPopulation) {
		this.targetPopulation = targetPopulation;
	}

	public Integer getTrackingMethod() {
		return trackingMethod;
	}

	public void setTrackingMethod(Integer trackingMethod) {
		this.trackingMethod = trackingMethod;
	}

	public Integer getSchemaYear() {
		return schemaYear;
	}

	public void setSchemaYear(Integer schemaYear) {
		this.schemaYear = schemaYear;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}
	
}