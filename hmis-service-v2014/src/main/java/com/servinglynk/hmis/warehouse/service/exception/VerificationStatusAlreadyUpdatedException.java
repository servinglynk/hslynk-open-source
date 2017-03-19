package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class VerificationStatusAlreadyUpdatedException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "The status of the specified verification has already been updated as ACCEPTED or REJECTED";

	public VerificationStatusAlreadyUpdatedException() {
		super(DEFAULT_MESSAGE);
	}

	public VerificationStatusAlreadyUpdatedException(String message) {
		super(message);
	}

	public VerificationStatusAlreadyUpdatedException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public VerificationStatusAlreadyUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
}
