package com.servinglynk.hmis.warehouse.test.core;

import java.net.URL;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WebserviceTestExecutor {
	

	@Autowired
	public RestTemplate restTemplate; 
	
	public URL base;
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + 8081);
//		this.base = new URL("http://localhost:" + 8080 + "/hmis-userservice/rest");
		
		//restTemplate = new TestRestTemplate();
	}
	
	
	
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
			headers.add("Authorization", "HMISHNUserAuth session_token=CD721B0A6C03483AA0ADD36E1BADA6B83FEEB4483442462F93B5D8F92FE6CAF2");
			headers.add("X-HMIS-TrustedApp-Id", "631D1191-9AC5-4F3F-836A-8DB0DBAE3CD3");
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
	public <T> T executePost(String requestUri, Object contentObject,  Class<T> responseValueType,String authorizationToken, HttpEntity<Object>  requestEntity) throws Exception {
		
		//return (T) execute(HttpMethod.POST, requestUri, contentObject, responseValueType, params);

		return (T) execute(this.base+requestUri,HttpMethod.POST,requestEntity,responseValueType);
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
	
	/*		
	
	@SuppressWarnings("unchecked")
	public <T> T execute(String uri,HttpMethod method,HttpEntity<?> httpEntity,Class<?> responceType){
//		restTemplate.exchange(url, method, requestEntity, responseType);
//	 ResponseEntity<T> response =	(ResponseEntity<T>) restTemplate.exchange(uri,method, httpEntity,responceType);
		 ResponseEntity<T> response =	(ResponseEntity<T>) restTemplate.postForObject(uri, httpEntity,responceType);	
		
	 return (T) response.getBody();
	}
	
	*/
	@SuppressWarnings("unchecked")
	public <T> T execute(String uri,HttpMethod method,HttpEntity<?> httpEntity,Class<?> responceType){
//		restTemplate.exchange(url, method, requestEntity, responseType);
	 ResponseEntity<T> response =	(ResponseEntity<T>) restTemplate.exchange(uri,method, httpEntity,responceType);
//		 return (T) restTemplate.exchange(uri, method,httpEntity,responceType);	
		
	 return (T) response.getBody();
	}

	
}
