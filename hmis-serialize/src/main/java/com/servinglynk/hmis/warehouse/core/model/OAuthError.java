package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("oAuthError")
public class OAuthError extends ClientModel {
	

	private String error;


	private String errorDescription;

	public String getError() {
		return error;
	}

	public void setError(String error)	{
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}