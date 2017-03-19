package com.servinglynk.hmis.warehouse.upload.business.util;

public enum UploadStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	COMPLETE("COMPLETE"),
	CORE("CORE"),
	PROJCHILD("PROJCHILD"),
	EXITCHILD("EXITCHILD"),
	ENRLCHILD1("ENRLCHILD1"),
	ENRLCHILD2("ENRLCHILD2"),
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
