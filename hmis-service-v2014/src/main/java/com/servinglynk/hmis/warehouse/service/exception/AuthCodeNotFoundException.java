package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AuthCodeNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "auth code not found";

	public AuthCodeNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public AuthCodeNotFoundException(String message) {
		super(message);
	}

	public AuthCodeNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AuthCodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
