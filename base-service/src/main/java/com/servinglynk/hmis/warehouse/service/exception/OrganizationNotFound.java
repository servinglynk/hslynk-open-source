package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class OrganizationNotFound extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "Organization not found";

	public OrganizationNotFound() {
		super(DEFAULT_MESSAGE);
	}

	public OrganizationNotFound(String message) {
		super(message);
	}

	public OrganizationNotFound(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public OrganizationNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
