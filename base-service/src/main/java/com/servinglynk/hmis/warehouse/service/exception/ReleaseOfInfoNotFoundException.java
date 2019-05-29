package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ReleaseOfInfoNotFoundException extends RuntimeException {
	
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Release Of Info not found";

	public ReleaseOfInfoNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ReleaseOfInfoNotFoundException(String message) {
		super(message);
	}

	public ReleaseOfInfoNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ReleaseOfInfoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
