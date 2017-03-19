package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AuthCodeExpiredException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "auth code has expired";

	public AuthCodeExpiredException() {
		super(DEFAULT_MESSAGE);
	}

	public AuthCodeExpiredException(String message) {
		super(message);
	}

	public AuthCodeExpiredException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AuthCodeExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

}
