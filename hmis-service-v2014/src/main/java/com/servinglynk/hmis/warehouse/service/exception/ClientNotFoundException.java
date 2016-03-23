package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ClientNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "client not found";

	public ClientNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ClientNotFoundException(String message) {
		super(message);
	}

	public ClientNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ClientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}