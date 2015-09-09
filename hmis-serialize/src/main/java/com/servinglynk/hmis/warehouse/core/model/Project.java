package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("project")
public class Project extends ClientModel {
	
	private UUID projectId;

	public Project() {
		
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
	
	
	

}
