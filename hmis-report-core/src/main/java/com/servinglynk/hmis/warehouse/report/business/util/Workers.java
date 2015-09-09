package com.servinglynk.hmis.warehouse.report.business.util;

public enum Workers {
	
	REPORT_WORKER("REPORT_WORKER");
	
	private String worker;
	
	private Workers(String worker) {
		this.worker = worker;
	}
	
	public String getWorker() {
		return worker;
	}

}
