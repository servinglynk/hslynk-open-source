package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectGroup")
public class ProjectGroup extends ClientModel {

	private String projectGroupName;
	private String projectGroupDesc;
	private UUID projectGroupId;
	private String projectGroupCode;
	private Boolean skipuseridentifers;
	private String bucketName;
	private String senderEmail;
	
	@JsonProperty("projects")
	List<BaseProject> projects = new ArrayList<BaseProject>();

	public String getProjectGroupName() {
		return projectGroupName;
	}

	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}

	public String getProjectGroupDesc() {
		return projectGroupDesc;
	}

	public void setProjectGroupDesc(String projectGroupDesc) {
		this.projectGroupDesc = projectGroupDesc;
	}

	public UUID getProjectGroupId() {
		return projectGroupId;
	}

	public void setProjectGroupId(UUID projectGroupId) {
		this.projectGroupId = projectGroupId;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public List<BaseProject> getProjects() {
		return projects;
	}

	public void setProjects(List<BaseProject> projects) {
		this.projects = projects;
	}	
	
	public void addProject(BaseProject project){
		this.projects.add(project);
	}

	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	
	public Boolean isSkipuseridentifers() {
		return skipuseridentifers;
	}
	public void setSkipuseridentifers(Boolean skipuseridentifers) {
		this.skipuseridentifers = skipuseridentifers;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
}