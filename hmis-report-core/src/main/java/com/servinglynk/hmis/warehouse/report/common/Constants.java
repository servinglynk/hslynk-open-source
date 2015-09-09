package com.servinglynk.hmis.warehouse.report.common;

public class Constants {

	private Constants() {
	}

	
	public static enum NotificationMethod {
		APNS, SMS, NULL, EMAIL;
	}
	

	public static enum NotificationStatus {
		INIT, PUSHED_TO_QUEUE, PICKED_UP_FROM_QUEUE, SENT_TO_NOT_ENGINE, TEMPLATE_MERGE, SENT_TO_CARRIER, IN_PROCESS, PARTIAL, COMPLETE, FAILED
	}
	
	public static enum ReportStatus {
		INIT, PUSHED_TO_QUEUE, PICKED_UP_FROM_QUEUE, SENT_TO_NOT_ENGINE, TEMPLATE_MERGE, SENT_TO_CARRIER, IN_PROCESS, PARTIAL, COMPLETE, FAILED
	}
	
	public static enum NotificationOriginatorType {
		USER, NETWORK, CLOUD
	}
	
	
	/* NotificationVO Constants */
	public static final String JOB_FAILED = "FAILED";
	public static final String JOB_SUCCEEDED = "SUCCESS";
	public static final String JOB_CREATED = "CREATED";
	public static final String JOB_PROCESSING = "PROCESSING";


}
