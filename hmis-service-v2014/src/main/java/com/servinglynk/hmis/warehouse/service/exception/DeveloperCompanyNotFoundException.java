package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class DeveloperCompanyNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "developer company not found";

	public DeveloperCompanyNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public DeveloperCompanyNotFoundException(String message) {
		super(message);
	}

	public DeveloperCompanyNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DeveloperCompanyNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
