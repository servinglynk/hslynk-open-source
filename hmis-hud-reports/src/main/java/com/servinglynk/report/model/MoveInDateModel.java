package com.servinglynk.report.model;

import java.sql.Date;

public class MoveInDateModel extends BaseModel {
	
	private String dedupClientId;
	private Date moveInDate;
	private String projectType;
	
	public MoveInDateModel(String dedupClientId, Date moveInDate, String projectType) {
		super();
		this.dedupClientId = dedupClientId;
		this.moveInDate = moveInDate;
		this.projectType = projectType;
	}
	public String getDedupClientId() {
		return dedupClientId;
	}
	public void setDedupClientId(String dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	public Date getMoveInDate() {
		return moveInDate;
	}
	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	
	
}
