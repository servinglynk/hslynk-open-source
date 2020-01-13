package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
@JsonRootName("projectSubGroup")
public class ProjectSubGroup extends ClientModel {

	private UUID projectSubGroupId;
	private String projectSubGroupName;
	
	private List<BaseProject> projects = new ArrayList<BaseProject>();
	private List<ProjectSubGroup> projectSubGroups = new ArrayList<ProjectSubGroup>(); 
	
	
	public UUID getProjectSubGroupId() {
		return projectSubGroupId;
	}

	public void setProjectSubGroupId(UUID projectSubGroupId) {
		this.projectSubGroupId = projectSubGroupId;
	}

	public String getProjectSubGroupName() {
		return projectSubGroupName;
	}

	public void setProjectSubGroupName(String projectSubGroupName) {
		this.projectSubGroupName = projectSubGroupName;
	}

	public List<BaseProject> getProjects() {
		return projects;
	}

	public void setProjects(List<BaseProject> projects) {
		this.projects = projects;
	}
	
	public void addProject(BaseProject project) {
		this.projects.add(project);
	}
}