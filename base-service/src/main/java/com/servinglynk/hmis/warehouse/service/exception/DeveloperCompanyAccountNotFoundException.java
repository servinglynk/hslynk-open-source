package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class DeveloperCompanyAccountNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "developer company account not found";

	public DeveloperCompanyAccountNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public DeveloperCompanyAccountNotFoundException(String message) {
		super(message);
	}

	public DeveloperCompanyAccountNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DeveloperCompanyAccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
