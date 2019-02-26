package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class GrantTypeNotSupportedException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "grant type not supported by service";

	public GrantTypeNotSupportedException() {
		super(DEFAULT_MESSAGE);
	}

	public GrantTypeNotSupportedException(String message) {
		super(message);
	}

	public GrantTypeNotSupportedException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public GrantTypeNotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

}
