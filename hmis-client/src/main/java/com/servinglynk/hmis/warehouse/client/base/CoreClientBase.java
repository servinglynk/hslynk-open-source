package com.servinglynk.hmis.warehouse.client.base;



import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;



public class CoreClientBase {


	protected RestTemplate restTemplate;
	
	
	protected String serviceUrl;
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	/* 04/17/2015
	 * Surya This is utility method to set the headers, You can override this method for multiple headers and get HttpHeaders Object back 
	 * 
	 */
	protected HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/xml");
		// Surya 04/17/2015 - You can add any headers here like user session, Authorization token etc
		headers.add("Content-Type", "application/xml; charset=UTF-8");
		
		return headers;
	}
	
	
}
