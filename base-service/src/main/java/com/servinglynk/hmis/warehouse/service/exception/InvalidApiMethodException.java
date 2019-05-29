package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class InvalidApiMethodException extends RuntimeException{
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "invalid redirect uri";

	public InvalidApiMethodException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidApiMethodException(String message) {
		super(message);
	}

	public InvalidApiMethodException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidApiMethodException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
