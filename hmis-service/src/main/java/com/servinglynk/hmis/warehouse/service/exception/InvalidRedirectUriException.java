package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class InvalidRedirectUriException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "invalid redirect uri";

	public InvalidRedirectUriException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidRedirectUriException(String message) {
		super(message);
	}

	public InvalidRedirectUriException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidRedirectUriException(String message, Throwable cause) {
		super(message, cause);
	}

}
