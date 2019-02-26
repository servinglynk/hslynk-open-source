package com.servinglynk.hmis.warehouse.service.exception;
@SuppressWarnings("serial")
public class RhyAfterCareNotFoundException extends RuntimeException {

	
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Project not found";

	public RhyAfterCareNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public RhyAfterCareNotFoundException(String message) {
		super(message);
	}

	public RhyAfterCareNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public RhyAfterCareNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
