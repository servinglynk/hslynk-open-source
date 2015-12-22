package com.servinglynk.hmis.warehouse.service.exception;

/**
 * This exception is thrown when the account credentials (username/password) is
 * wrong.
 * 
 * @author Amrit Jain
 */
@SuppressWarnings("serial")
public class InvalidAccountCredentialsException extends RuntimeException {
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "invalid username and/or password";

	public InvalidAccountCredentialsException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidAccountCredentialsException(String message) {
		super(message);
	}

	public InvalidAccountCredentialsException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidAccountCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}
}
