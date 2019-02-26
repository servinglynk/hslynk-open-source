package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountDisabledException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account is disabled";

	public AccountDisabledException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountDisabledException(String message) {
		super(message);
	}

	public AccountDisabledException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountDisabledException(String message, Throwable cause) {
		super(message, cause);
	}
}
