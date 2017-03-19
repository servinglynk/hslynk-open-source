package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class DeveloperCompanyAccountAlreadyExistsException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "developer company owner cannot be dissociated";

	public DeveloperCompanyAccountAlreadyExistsException() {
		super(DEFAULT_MESSAGE);
	}

	public DeveloperCompanyAccountAlreadyExistsException(String message) {
		super(message);
	}

	public DeveloperCompanyAccountAlreadyExistsException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DeveloperCompanyAccountAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
