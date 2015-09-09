package com.servinglynk.hmis.warehouse.service.exception;

/**
 * This exception is thrown when a current password is invalid.
 * 
 * @author Robert Cruz
 */
@SuppressWarnings("serial")
public class InvalidCurrentPasswordException  extends RuntimeException{
	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "The specified currentPassword does not match with the password stored in the database.";

	public InvalidCurrentPasswordException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidCurrentPasswordException(String message) {
		super(message);
	}

	public InvalidCurrentPasswordException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public InvalidCurrentPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

}
