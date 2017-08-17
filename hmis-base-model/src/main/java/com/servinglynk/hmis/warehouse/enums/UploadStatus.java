package com.servinglynk.hmis.warehouse.enums;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	CORE_COMPLETED("CORE_COMPLETED"),
	CORE("COMPLETE"),
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
