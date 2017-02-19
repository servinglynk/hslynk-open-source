package com.servinglynk.hmis.warehouse.upload.business.exception;

public class BulkUploadException  extends RuntimeException{
	
	public static final String DEFAULT_MESSAGE = "Report Creation Exception";
	
	public BulkUploadException() {
		super(DEFAULT_MESSAGE);
	}
	
	public BulkUploadException(String message) {
		super(message);
	}
	
	public BulkUploadException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public BulkUploadException(String message, Throwable cause) {
		super(message, cause);
	}
	
	String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
	String errorGroup;

	public String getErrorGroup() {
		return errorGroup;
	}

	public void setErrorGroup(String errorGroup) {
		this.errorGroup = errorGroup;
	}
		
		

}
