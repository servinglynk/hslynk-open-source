package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountConsentNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "consent not found";

	public AccountConsentNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountConsentNotFoundException(String message) {
		super(message);
	}

	public AccountConsentNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountConsentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
