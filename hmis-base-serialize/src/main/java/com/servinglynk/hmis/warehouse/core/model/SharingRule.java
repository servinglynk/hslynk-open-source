package com.servinglynk.hmis.warehouse.core.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sharingRule")
public class SharingRule extends ClientModel {
	
	private UUID sharingRuleId;
	private Date activeFrom;
	private Date activeTo;	
	private ProjectGroup toProjectGroup;
	private GlobalProject project;
	private List<GlobalProject> projects;
	private Role role;
	private List<Role> roles;
	private Profile profile;
	private Account user;
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
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Account getUser() {
		return user;
	}
	public void setUser(Account user) {
		this.user = user;
	}
	public List<GlobalProject> getProjects() {
		return projects;
	}
	public void setProjects(List<GlobalProject> projects) {
		this.projects = projects;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	
}