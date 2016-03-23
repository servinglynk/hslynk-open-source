package com.servinglynk.hmis.warehouse.core.model.exception;


@SuppressWarnings("serial")
public class TrustedAppNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "TrustedApp not found";

	public TrustedAppNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public TrustedAppNotFoundException(String message) {
		super(message);
	}

	public TrustedAppNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public TrustedAppNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
