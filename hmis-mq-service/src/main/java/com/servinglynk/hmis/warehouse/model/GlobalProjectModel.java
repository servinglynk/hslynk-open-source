package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("globalProject")
public class GlobalProjectModel {
	
	private UUID id;
	private String projectName;
	private String projectCommonName;
	private String description;
	private String sourceSystemId;
	private GlobalProjectsMap projects = new GlobalProjectsMap();
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCommonName() {
		return projectCommonName;
	}
	public void setProjectCommonName(String projectCommonName) {
		this.projectCommonName = projectCommonName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GlobalProjectsMap getProjects() {
		return projects;
	}
	public void setProjects(GlobalProjectsMap projects) {
		this.projects = projects;
	}
	
	public void addProject(GlobalProjectMap project) {
		this.projects.addGlobalProject(project);
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
}