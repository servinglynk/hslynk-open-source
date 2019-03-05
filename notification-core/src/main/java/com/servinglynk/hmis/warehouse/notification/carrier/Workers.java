package com.servinglynk.hmis.warehouse.notification.carrier;

public enum Workers {
	
	NOTIFICATION_WORKER("NOTIFICATION_WORKER");
	
	private String worker;
	
	private Workers(String worker) {
		this.worker = worker;
	}
	
	public String getWorker() {
		return worker;
	}

}
