package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class DuplicateDataException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account already exists";

	public DuplicateDataException() {
		super(DEFAULT_MESSAGE);
	}

	public DuplicateDataException(String message) {
		super(message);
	}

	public DuplicateDataException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public DuplicateDataException(String message, Throwable cause) {
		super(message, cause);
	}

}
