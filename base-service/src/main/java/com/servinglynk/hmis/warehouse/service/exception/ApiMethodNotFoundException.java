package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class ApiMethodNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "api method not found";

	public ApiMethodNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ApiMethodNotFoundException(String message) {
		super(message);
	}

	public ApiMethodNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ApiMethodNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
