package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ProjectGroupNotFoundException extends RuntimeException {

	
	public static final String DEFAULT_MESSAGE = "Project Group not found";

	public ProjectGroupNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ProjectGroupNotFoundException(String message) {
		super(message);
	}

	public ProjectGroupNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ProjectGroupNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
