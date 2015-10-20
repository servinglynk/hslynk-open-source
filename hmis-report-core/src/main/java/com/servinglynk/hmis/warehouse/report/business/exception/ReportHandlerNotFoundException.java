package com.servinglynk.hmis.warehouse.report.business.exception;

public class ReportHandlerNotFoundException  extends RuntimeException{
	
	public static final String DEFAULT_MESSAGE = "Report Handler Not Found Exception";
	
	public ReportHandlerNotFoundException() {
		super(DEFAULT_MESSAGE);
	}
	
	public ReportHandlerNotFoundException(String message) {
		super(message);
	}
	
	public ReportHandlerNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ReportHandlerNotFoundException(String message, Throwable cause) {
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
