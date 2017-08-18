package com.servinglynk.hmis.warehouse.enums;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	COMPLETE("COMPLETE"),
	STAGING("STAGING"),
	LIVE("LIVE"),
	BASE("BASE"),
	ENROLLMENT("ENROLLMENT"),
	C_EMENT("C_EMENT"),
	DISAB("DISAB"),
	EXIT("EXIT"),
	C_EXIT("C_EXIT"),
	C_CLIENT("C_CLIENT"),
	ERROR("ERROR"),
	DELETED("DELETED");
	private String status;
	
	private UploadStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
