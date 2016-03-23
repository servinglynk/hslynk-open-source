package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class ServiceAlreadyExistsException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "service already exists";

	public ServiceAlreadyExistsException() {
		super(DEFAULT_MESSAGE);
	}

	public ServiceAlreadyExistsException(String message) {
		super(message);
	}

	public ServiceAlreadyExistsException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ServiceAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
