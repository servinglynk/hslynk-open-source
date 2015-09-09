package com.servinglynk.hmis.warehouse.test.core;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WebserviceTestExecutorOld {
	

	@Autowired
	public RestTemplate restTemplate; 
	
	public URL base;
	
	
	
	
	protected HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		// Surya 04/17/2015 - You can add any headers here like user session, Authorization token etc
		headers.add("Content-Type", "application/json");
		
		return headers;
	}
	
	protected HttpHeaders getHttpHeaders(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		// Surya 04/17/2015 - You can add any headers here like user session, Authorization token etc
		headers.add("Content-Type", "application/json");
	//	if(token!=null)
			headers.add("Authorization", "HMISHNUserAuth session_token=8933D6E5838D4DA794429E6055EBB88AFBE91DCE9697493BAD558FE6F87BFEF9");
			headers.add("X-HMIS-TrustedApp-Id", "DC54A9D7-1CC1-481B-8CDE-378D4B9286A3");
		return headers;
	}
	@SuppressWarnings("unchecked")
	public <T> T executePost(String requestUri, Object contentObject,  Class<T> responseValueType, String authorizationToken ) throws Exception {
		
		//return (T) execute(HttpMethod.POST, requestUri, contentObject, responseValueType, params);
		HttpEntity<Object> entity =new HttpEntity<Object>(getHttpHeaders(authorizationToken));
		if(contentObject!=null){
			 entity=new HttpEntity<Object>(contentObject,getHttpHeaders(authorizationToken));
		}
		return (T) execute(this.base+requestUri,HttpMethod.POST,entity,responseValueType);
		//return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T executePut(String requestUri, Object contentObject,  Class<T> responseValueType, String authorizationToken ) throws Exception {
		
		//return (T) execute(HttpMethod.POST, requestUri, contentObject, responseValueType, params);
		HttpEntity<Object> entity=new HttpEntity<Object>(contentObject,getHttpHeaders(authorizationToken));
		return (T) execute(this.base+requestUri,HttpMethod.PUT,entity,responseValueType);
		//return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public <T> T executeDelete(String requestUri, Object contentObject,  Class<T> responseValueType, String authorizationToken ) throws Exception {
		
		//return (T) execute(HttpMethod.POST, requestUri, contentObject, responseValueType, params);
		HttpEntity<Object> entity=new HttpEntity<Object>(contentObject,getHttpHeaders(authorizationToken));
		return (T) execute(this.base+requestUri,HttpMethod.DELETE,entity,responseValueType);
		//return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public <T> T executeGet(String requestUri, Object contentObject,  Class<T> responseValueType, String authorizationToken ) throws Exception {
		
		//return (T) execute(HttpMethod.POST, requestUri, contentObject, responseValueType, params);
		HttpEntity<Object> entity=new HttpEntity<Object>(contentObject,getHttpHeaders(authorizationToken));
		return (T) execute(this.base+requestUri,HttpMethod.GET,entity,responseValueType);
		//return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public <T> T execute(String uri,HttpMethod method,HttpEntity<?> httpEntity,Class<?> responceType){
//		restTemplate.exchange(url, method, requestEntity, responseType);
	 ResponseEntity<T> response =	(ResponseEntity<T>) restTemplate.exchange(uri,method, httpEntity,responceType);
	 return (T) response.getBody();
	}
	
	
	
}
