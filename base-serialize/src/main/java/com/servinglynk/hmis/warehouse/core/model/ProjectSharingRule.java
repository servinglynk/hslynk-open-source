package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectSharingRule")
public class ProjectSharingRule extends ClientModel {
	
	private UUID projectSharingRuleId;
	private BaseProject project;
	private ProjectSubGroup projectSubGroup;
	private BaseProject toProject;
	private ProjectSubGroup toProjectSubGroup;	
	private String toProjectGroupId;
	public UUID getProjectSharingRuleId() {
		return projectSharingRuleId;
	}
	public void setProjectSharingRuleId(UUID projectSharingRuleId) {
		this.projectSharingRuleId = projectSharingRuleId;
	}
	public BaseProject getProject() {
		return project;
	}
	public void setProject(BaseProject project) {
		this.project = project;
	}
	public ProjectSubGroup getProjectSubGroup() {
		return projectSubGroup;
	}
	public void setProjectSubGroup(ProjectSubGroup projectSubGroup) {
		this.projectSubGroup = projectSubGroup;
	}
	public BaseProject getToProject() {
		return toProject;
	}
	public void setToProject(BaseProject toProject) {
		this.toProject = toProject;
	}
	public ProjectSubGroup getToProjectSubGroup() {
		return toProjectSubGroup;
	}
	public void setToProjectSubGroup(ProjectSubGroup toProjectSubGroup) {
		this.toProjectSubGroup = toProjectSubGroup;
	}
	public String getToProjectGroupId() {
		return toProjectGroupId;
	}
	public void setToProjectGroupId(String toProjectGroupId) {
		this.toProjectGroupId = toProjectGroupId;
	}
}