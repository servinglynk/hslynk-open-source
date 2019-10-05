package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ProjectNotFoundException extends RuntimeException {

	
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Project not found";

	public ProjectNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ProjectNotFoundException(String message) {
		super(message);
	}

	public ProjectNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ProjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
