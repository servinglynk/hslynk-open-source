package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

public class TrustedAppProjectGroup extends ClientModel {
	
	
	private UUID  id;
	private TrustedApp trustedApp;
	private ProjectGroup projectGroup;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public TrustedApp getTrustedApp() {
		return trustedApp;
	}
	public void setTrustedApp(TrustedApp trustedApp) {
		this.trustedApp = trustedApp;
	}
	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}	
}