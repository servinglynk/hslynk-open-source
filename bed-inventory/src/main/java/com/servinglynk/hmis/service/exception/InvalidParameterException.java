package com.servinglynk.hmis.service.exception;

@SuppressWarnings("serial")
public class InvalidParameterException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "invalid parameter";

	public InvalidParameterException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}