package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class ServiceNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "developer company service not found";

	public ServiceNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ServiceNotFoundException(String message) {
		super(message);
	}

	public ServiceNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
