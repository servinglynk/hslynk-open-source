package com.servinglynk.hmis.warehouse.sync.business.util;

public enum SyncStatus {
	
	INITIAL("INITIAL"),
	INPROGRESS("INPROGRESS"),
	COMPLETE("COMPLETE");
	
	private String status;
	
	private SyncStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

}
