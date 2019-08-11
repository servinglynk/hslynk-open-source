package com.servinglynk.hmis.warehouse.service.exception;
@SuppressWarnings("serial")
public class VerificationTargetNotFoundException extends RuntimeException{
	
	public static final String DEFAULT_MESSAGE = "Verification Target  not found";



	public VerificationTargetNotFoundException() {

		super(DEFAULT_MESSAGE);

	}



	public VerificationTargetNotFoundException(String message) {

		super(message);

	}



	public VerificationTargetNotFoundException(Throwable cause) {

		super(DEFAULT_MESSAGE, cause);

	}



	public VerificationTargetNotFoundException(String message, Throwable cause) {

		super(message, cause);

	}

}
