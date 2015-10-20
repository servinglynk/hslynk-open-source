package com.servinglynk.hmis.warehouse.notification.business.exception;

public class CarrierSendFailureException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_MESSAGE = "Carrier Send Failure Exception";
	
	public CarrierSendFailureException() {
		super(DEFAULT_MESSAGE);
	}
	
	public CarrierSendFailureException(String message) {
		super(message);
	}
	
	public CarrierSendFailureException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public CarrierSendFailureException(String message, Throwable cause) {
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
