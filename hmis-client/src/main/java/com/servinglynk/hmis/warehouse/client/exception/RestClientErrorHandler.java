package com.servinglynk.hmis.warehouse.client.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;

public class RestClientErrorHandler<T> extends DefaultResponseErrorHandler {


	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		System.out.println(response);
		
	}
}
