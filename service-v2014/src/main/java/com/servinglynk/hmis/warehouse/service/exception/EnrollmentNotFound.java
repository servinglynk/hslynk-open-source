package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class EnrollmentNotFound extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Enrollment not found";

	public EnrollmentNotFound() {
		super(DEFAULT_MESSAGE);
	}

	public EnrollmentNotFound(String message) {
		super(message);
	}

	public EnrollmentNotFound(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public EnrollmentNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
