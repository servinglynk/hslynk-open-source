package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("releaseOfInfo")
public class ReleaseOfInfo extends ClientModel {

	public UUID roleaseOfInfoId;
	public UUID enrollmentId;
	public boolean consented;
	public List<Project> projects = new ArrayList<Project>();
	
	public UUID getRoleaseOfInfoId() {
		return roleaseOfInfoId;
	}
	public void setRoleaseOfInfoId(UUID roleaseOfInfoId) {
		this.roleaseOfInfoId = roleaseOfInfoId;
	}
	public UUID getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(UUID enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public boolean isConsented() {
		return consented;
	}
	public void setConsented(boolean consented) {
		this.consented = consented;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public void addProject(Project project){
		this.projects.add(project);
	}
	
	
}