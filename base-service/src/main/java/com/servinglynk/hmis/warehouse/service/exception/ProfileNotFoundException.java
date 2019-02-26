package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class ProfileNotFoundException extends RuntimeException {

	public static final String DEFAULT_MESSAGE = "Profile not found";

	public ProfileNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public ProfileNotFoundException(String message) {
		super(message);
	}

	public ProfileNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public ProfileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
