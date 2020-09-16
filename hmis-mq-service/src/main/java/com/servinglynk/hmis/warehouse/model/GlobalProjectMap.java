package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

public class GlobalProjectMap {
	
	private UUID projectId;
	private String source;
	private String link;
	
	public UUID getProjectId() {
		return projectId;
	}
	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}