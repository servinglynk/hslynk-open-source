package com.servinglynk.hmis.warehouse.service.exception;

public class InvalidRequest  extends RuntimeException  {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Invalid request";

	public InvalidRequest() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidRequest(String message) {
		super(message);
	}

	public InvalidRequest(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidRequest(String message, Throwable cause) {
		super(message, cause);
	}
	
}