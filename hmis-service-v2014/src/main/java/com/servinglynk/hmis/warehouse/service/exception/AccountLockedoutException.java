package com.servinglynk.hmis.warehouse.service.exception;


@SuppressWarnings("serial")
public class AccountLockedoutException extends RuntimeException {

	/**
	 * Default exception message
	 */
	public static final String DEFAULT_MESSAGE = "account is locked";	private String lockoutTime ="0";
	public String getLockoutTime() {		return lockoutTime;	}	public void setLockoutTime(String lockoutTime) {		this.lockoutTime = lockoutTime;	}	public AccountLockedoutException() {
		super(DEFAULT_MESSAGE);
	}

	public AccountLockedoutException(String message) {
		super(message);
	}		public AccountLockedoutException(String message,String lockoutTime) {		super(message);		setLockoutTime(lockoutTime);	}

	public AccountLockedoutException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public AccountLockedoutException(String message, Throwable cause) {
		super(message, cause);
	}
}
