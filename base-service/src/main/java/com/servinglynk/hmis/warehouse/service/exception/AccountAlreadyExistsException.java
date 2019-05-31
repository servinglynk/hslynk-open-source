package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountAlreadyExistsException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account already exists";

	public AccountAlreadyExistsException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountAlreadyExistsException(String message) {
		super(message);
	}

	public AccountAlreadyExistsException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
