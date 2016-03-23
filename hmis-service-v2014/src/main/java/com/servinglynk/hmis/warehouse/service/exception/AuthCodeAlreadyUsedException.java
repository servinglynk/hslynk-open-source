package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class AuthCodeAlreadyUsedException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "auth code already used";

	public AuthCodeAlreadyUsedException() {
		super(DEFAULT_MESSAGE);
	}

	public AuthCodeAlreadyUsedException(String message) {
		super(message);
	}

	public AuthCodeAlreadyUsedException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AuthCodeAlreadyUsedException(String message, Throwable cause) {
		super(message, cause);
	}

}
