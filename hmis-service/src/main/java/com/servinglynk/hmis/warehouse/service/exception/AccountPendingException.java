package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountPendingException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account is pending";

	public AccountPendingException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountPendingException(String message) {
		super(message);
	}

	public AccountPendingException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountPendingException(String message, Throwable cause) {
		super(message, cause);
	}
}
