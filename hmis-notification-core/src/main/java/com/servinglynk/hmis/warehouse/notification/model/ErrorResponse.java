package com.servinglynk.hmis.warehouse.notification.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class ErrorResponse extends ClientModel {


	private String code;
	private String message;

	

	public ErrorResponse() {
	}

	public ErrorResponse(String code, String message) {
		setCode(code);
		setMessage(message);
	}

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
}
