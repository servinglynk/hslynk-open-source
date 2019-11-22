package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("projectSharingRules")
public class ProjectSharingRules extends PaginatedModel {

	
	@JsonProperty("projectSharingRules")
	private List<ProjectSharingRule> projectSharingRules = new ArrayList<ProjectSharingRule>();

	public List<ProjectSharingRule> getProjectSharingRules() {
		return projectSharingRules;
	}

	public void setProjectSharingRules(List<ProjectSharingRule> projectSharingRules) {
		this.projectSharingRules = projectSharingRules;
	}
	
	public void addProjectSharingRule(ProjectSharingRule projectSharingRule) {
		this.projectSharingRules.add(projectSharingRule);
	}
}
