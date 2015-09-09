package com.servinglynk.hmis.warehouse.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class RestClientHttpException extends HttpServerErrorException	{
	
	private Object error;
	
	public RestClientHttpException(HttpStatus statusCode) {
		super(statusCode);
	}

	public RestClientHttpException(HttpStatus statusCode, Object error) {
		super(statusCode);
		this.error = error;
	}

	public RestClientHttpException(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}

	public RestClientHttpException(HttpStatus statusCode, String statusText, Object error) {
		super(statusCode, statusText);
		this.error = error;
	}

	public void setError(Object error)	{
		this.error = error;
	}
	public Object getError()	{
		return this.error;
	}
	
	public String toString()	{
		String str = super.toString();
		
		if (this.error != null)	{
			str = str + "\n" + this.error.toString();
		}
		
		return str;
	}
}
