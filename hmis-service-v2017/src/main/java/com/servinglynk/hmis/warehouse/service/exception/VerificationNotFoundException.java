package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class VerificationNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "The verification with the specified token is not found";

	public VerificationNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public VerificationNotFoundException(String message) {
		super(message);
	}

	public VerificationNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public VerificationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
