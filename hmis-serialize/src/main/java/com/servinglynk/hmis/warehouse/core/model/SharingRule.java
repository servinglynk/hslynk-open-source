package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("sharingRule")
public class SharingRule extends ClientModel {
	
	UUID sharingRuleId;
	UUID fromOrganization;
	UUID toOrganization;
	Date activeFrom;
	Date activeTo;
	
	@JsonProperty("projects")
	List<Project> projects = new ArrayList<Project>();
	
	@JsonProperty("enrollment")
	List<Enrollment> enrollments = new ArrayList<Enrollment>();

	@JsonProperty("roles")
	List<Role> roles = new ArrayList<Role>();

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public UUID getSharingRuleId() {
		return sharingRuleId;
	}

	public void setSharingRuleId(UUID sharingRuleId) {
		this.sharingRuleId = sharingRuleId;
	}

	public UUID getFromOrganization() {
		return fromOrganization;
	}

	public void setFromOrganization(UUID fromOrganization) {
		this.fromOrganization = fromOrganization;
	}

	public UUID getToOrganization() {
		return toOrganization;
	}

	public void setToOrganization(UUID toOrganization) {
		this.toOrganization = toOrganization;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addRole(Role role){
		this.roles.add(role);
	}

	public void addEnrollment(Enrollment enrollment){
		this.enrollments.add(enrollment);
	}
	
	public void addProject(Project project){
		this.projects.add(project);
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
}
