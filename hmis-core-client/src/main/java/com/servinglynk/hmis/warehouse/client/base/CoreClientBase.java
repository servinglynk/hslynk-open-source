package com.servinglynk.hmis.warehouse.client.base;



import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;



public class CoreClientBase {

	protected RestTemplate restTemplate;
	
	@Autowired
	Environment environment;
	
	
	
	
	/*protected String serviceUrl;*/
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

/*	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}*/
	
	/* 04/17/2015
	 * Surya This is utility method to set the headers, You can override this method for multiple headers and get HttpHeaders Object back 
	 * 
	 */
	protected HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		// Surya 04/17/2015 - You can add any headers here like user session, Authorization token etc
		headers.add("Content-Type", "application/json; charset=UTF-8");
		
		return headers;
	}
	
	public HashMap defaultServiceUrls(){
		HashMap<String,String> defaultServiceUrls= new HashMap<>();
		defaultServiceUrls.put("api.method.authorize.url", "http://hmiselb1.aws.hmislynk.com/hmis-user-service/rest/apimethodauthcheck/{methodId}");
		defaultServiceUrls.put("check.client.consent.for.user.url", "http://hmiselb1.aws.hmislynk.com/hmis-globalapi/rest//clients/{clientId}/checkUserConsent");
		defaultServiceUrls.put("notification.service.url","http://hmisns1.aws.hmislynk.com:8080/hmis-notification-service/rest/notifications");
        defaultServiceUrls.put("project.search.url", "http://hmiselb1.aws.hmislynk.com/hmis-clientapi-v{schemaYear}/rest/projects/{projectId}");
        defaultServiceUrls.put("client.search.url","http://hhmiselb1.aws.hmislynk.com/hmis-clientapi-v2014/rest/searchall/{entity}");
		return defaultServiceUrls;
	}
	
	
	public String getURL(String serviceId) {
		if(environment.getProperty(serviceId)!=null) {
			return environment.getProperty(serviceId);
		}else {
			return this.defaultServiceUrls().get(serviceId).toString();
		}
	}	
	
	public String buildURL(String urlString,String... params) {
	
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .fromHttpUrl(urlString)
			      .buildAndExpand(params);
		
		return uriComponents.toUri().toString();
	}
	
	public String buildURL(String urlString) {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .fromHttpUrl(urlString).build();
		
		return uriComponents.toUri().toString();
	}
	
	
	/*public static void main(String args[]) {
		 UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .path("http://hmiselb1.aws.hmislynk.com/hmis-user-service/rest/apimethodauthcheck/{methodId}/{test}")
			      .buildAndExpand("junit-5","dsasdsa");
		 System.out.println(uriComponents.toUri().toString());
		 }*/
}