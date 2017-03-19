package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class RefreshTokenNotFoundException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "refresh token not found";
	public static final String REVOCATION = "revocation";
	public static final String AUTHORIZATION = "authorization";
	
	private String context = AUTHORIZATION;

	public RefreshTokenNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public RefreshTokenNotFoundException(String message) {
		super(message);
	}

	public RefreshTokenNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public RefreshTokenNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
