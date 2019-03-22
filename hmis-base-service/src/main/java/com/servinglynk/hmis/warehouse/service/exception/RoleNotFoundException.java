package com.servinglynk.hmis.warehouse.service.exception;

@SuppressWarnings("serial")
public class RoleNotFoundException extends RuntimeException {

	public static final String DEFAULT_MESSAGE = "Role not found";

	public RoleNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public RoleNotFoundException(String message) {
		super(message);
	}

	public RoleNotFoundException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public RoleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
