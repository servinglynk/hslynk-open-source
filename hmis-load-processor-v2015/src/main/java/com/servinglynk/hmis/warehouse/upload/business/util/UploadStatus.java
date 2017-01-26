package com.servinglynk.hmis.warehouse.upload.business.util;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	COMPLETE("COMPLETE"),
	CORE_COMPLETE("CORE_COMPLETE"),
	STAGING("STAGING"),
	LIVE("LIVE"),
	DELETED("DELETED");
	private String status;
	
	private UploadStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
