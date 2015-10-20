package com.servinglynk.hmis.warehouse.notification.business.exception;

public class CarrierNotFoundException  extends RuntimeException{
	

	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_MESSAGE = "Carrier Not Found Exception";
	
	public CarrierNotFoundException() {
		super(DEFAULT_MESSAGE);
	}
	
	public CarrierNotFoundException(String message) {
		super(message);
	}
	
	public CarrierNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public CarrierNotFoundException(String message, Throwable cause) {
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
