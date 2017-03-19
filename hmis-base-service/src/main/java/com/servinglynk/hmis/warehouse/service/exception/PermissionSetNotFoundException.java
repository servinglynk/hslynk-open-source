package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class PermissionSetNotFoundException extends RuntimeException {
	
	
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "PermissionSet not found";

	public PermissionSetNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public PermissionSetNotFoundException(String message) {
		super(message);
	}

	public PermissionSetNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public PermissionSetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}


}
