package com.servinglynk.hmis.warehouse.report.business.exception;

public class MacroRunningException  extends RuntimeException{
	
	public static final String DEFAULT_MESSAGE = "Macro Running Exception";
	
	public MacroRunningException() {
		super(DEFAULT_MESSAGE);
	}
	
	public MacroRunningException(String message) {
		super(message);
	}
	
	public MacroRunningException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public MacroRunningException(String message, Throwable cause) {
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
