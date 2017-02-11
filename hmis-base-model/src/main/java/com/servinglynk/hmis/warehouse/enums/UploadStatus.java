package com.servinglynk.hmis.warehouse.enums;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	CORE_COMPLETE("CORE_COMPLETE"),
	COMPLETE("COMPLETE"),
	STAGING("STAGING"),
	ERROR("ERROR"),
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
