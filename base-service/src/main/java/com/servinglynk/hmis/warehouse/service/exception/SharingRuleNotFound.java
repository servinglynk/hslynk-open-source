package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class SharingRuleNotFound extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "SharingRule not found";

	public SharingRuleNotFound() {
		super(DEFAULT_MESSAGE);
	}

	public SharingRuleNotFound(String message) {
		super(message);
	}

	public SharingRuleNotFound(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public SharingRuleNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
