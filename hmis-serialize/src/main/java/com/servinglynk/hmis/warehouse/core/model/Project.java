package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("project")
public class Project extends ClientModel {
	
	private UUID projectId;
    private String projectName;
    private String projectCommonName;
    private String continuumProject;
    private String projectType;
    private String residentialAffiliation;
    private String targetPopulation;
    private String trackingMethod;
    
	public Project() {
		
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Project(UUID projectId) {
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

	public String getContinuumProject() {
		return continuumProject;
	}

	public void setContinuumProject(String continuumProject) {
		this.continuumProject = continuumProject;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getResidentialAffiliation() {
		return residentialAffiliation;
	}

	public void setResidentialAffiliation(String residentialAffiliation) {
		this.residentialAffiliation = residentialAffiliation;
	}

	public String getTargetPopulation() {
		return targetPopulation;
	}

	public void setTargetPopulation(String targetPopulation) {
		this.targetPopulation = targetPopulation;
	}

	public String getTrackingMethod() {
		return trackingMethod;
	}

	public void setTrackingMethod(String trackingMethod) {
		this.trackingMethod = trackingMethod;
	}
}