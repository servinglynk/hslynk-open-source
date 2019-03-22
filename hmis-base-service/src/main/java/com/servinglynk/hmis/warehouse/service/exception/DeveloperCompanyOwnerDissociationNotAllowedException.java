package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class DeveloperCompanyOwnerDissociationNotAllowedException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "developer company account already exists";

	public DeveloperCompanyOwnerDissociationNotAllowedException() {
		super(DEFAULT_MESSAGE);
	}

	public DeveloperCompanyOwnerDissociationNotAllowedException(String message) {
		super(message);
	}

	public DeveloperCompanyOwnerDissociationNotAllowedException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DeveloperCompanyOwnerDissociationNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}

}
