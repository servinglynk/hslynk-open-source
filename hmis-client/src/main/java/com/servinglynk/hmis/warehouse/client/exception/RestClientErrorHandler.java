package com.servinglynk.hmis.warehouse.client.exception;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

public class RestClientErrorHandler<T> extends DefaultResponseErrorHandler {


	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		System.out.println(response);
		
	}
}
