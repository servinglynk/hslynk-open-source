package com.servinglynk.hmis.warehouse.enums;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	BASE("BASE"),
	ENROLLMENT("ENROLLMENT"),
	DISAB("DISAB"),
	EXIT("EXIT"),
	CORE_C("CORE_C"),
	ENROLL_C("ENROLL_C"),
	DISAB_C("DISAB_C"),
	EXIT_C("EXIT_C"),
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
