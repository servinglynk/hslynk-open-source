package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class UserAuthenticationFailedException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "user cannot be authenticated";

	public UserAuthenticationFailedException() {
		super(DEFAULT_MESSAGE);
	}

	public UserAuthenticationFailedException(String message) {
		super(message);
	}

	public UserAuthenticationFailedException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public UserAuthenticationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}
