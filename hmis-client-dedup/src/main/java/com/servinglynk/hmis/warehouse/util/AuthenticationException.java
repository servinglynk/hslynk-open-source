package com.servinglynk.hmis.warehouse.util;

public class AuthenticationException extends RuntimeException
{
	private static final long serialVersionUID = 7090787379424967604L;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String message, Throwable exception) {
		super(message, exception);
	}

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(Throwable exception) {
		super(exception);
	}
}
