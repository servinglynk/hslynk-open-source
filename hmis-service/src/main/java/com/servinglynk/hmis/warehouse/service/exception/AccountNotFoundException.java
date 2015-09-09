package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account not found";

	public AccountNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountNotFoundException(String message) {
		super(message);
	}

	public AccountNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
