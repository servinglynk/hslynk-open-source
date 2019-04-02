package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sharingRule")
public class SharingRule extends ClientModel {
	
	UUID sharingRuleId;
	Date activeFrom;
	Date activeTo;	
	ProjectGroup toProjectGroup;
	GlobalProject project;
	Role role;
	public UUID getSharingRuleId() {
		return sharingRuleId;
	}
	public void setSharingRuleId(UUID sharingRuleId) {
		this.sharingRuleId = sharingRuleId;
	}
	public Date getActiveFrom() {
		return activeFrom;
	}
	public void setActiveFrom(Date activeFrom) {
		this.activeFrom = activeFrom;
	}
	public Date getActiveTo() {
		return activeTo;
	}
	public void setActiveTo(Date activeTo) {
		this.activeTo = activeTo;
	}
	public ProjectGroup getToProjectGroup() {
		return toProjectGroup;
	}
	public void setToProjectGroup(ProjectGroup toProjectGroup) {
		this.toProjectGroup = toProjectGroup;
	}
	public GlobalProject getProject() {
		return project;
	}
	public void setProject(GlobalProject project) {
		this.project = project;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}	
}