package com.servinglynk.hmis.warehouse.core.model.exception;

public class RestClientException extends RuntimeException {

	private String code;
	private String message;
	private Integer status;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public static final String DEFAULT_MESSAGE = "Unauthorized to perform this action.";

	public RestClientException() {
		super(DEFAULT_MESSAGE);
	}

	public RestClientException(String message) {
		super(message);
	}
	
	public RestClientException(String message,String code,Integer status) {
		super(message);
		this.code= code;
		this.message = message;
		this.status = status;
	}

	public RestClientException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public RestClientException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
