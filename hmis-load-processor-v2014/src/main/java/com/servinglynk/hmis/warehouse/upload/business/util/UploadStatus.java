package com.servinglynk.hmis.warehouse.upload.business.util;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	COMPLETE("COMPLETE"),
	STAGING("STAGING"),
	LIVE("LIVE"),
	BASE("BASE"),
	ENROLLMENT("ENROLLMENT"),
	DISABILITIES("DISABILITIES"),
	EXIT("EXIT"),
	ENROLLMENT_CHILDREN("ENROLLMENT_CHILDREN"),
	DELETED("DELETED");
	private String status;
	
	private UploadStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
