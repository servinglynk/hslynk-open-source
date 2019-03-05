package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class DeveloperServiceNotFoundException extends RuntimeException {

	
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Developer Service not found";

	public DeveloperServiceNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public DeveloperServiceNotFoundException(String message) {
		super(message);
	}

	public DeveloperServiceNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DeveloperServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
