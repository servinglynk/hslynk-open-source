package com.servinglynk.hmis.warehouse.client.model;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest {
	
	private String trustedAppId;
	private String sessionToken;
	private Map<String, Object> searchParams= new HashMap<String,Object>();

	public String getTrustedAppId() {
		return trustedAppId;
	}
	public void setTrustedAppId(String trustedAppId) {
		this.trustedAppId = trustedAppId;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public Map<String, Object> getSearchParams() {
		return searchParams;
	}
	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}
	
	public void addSearchParam(String paramName,Object paramValue){
		this.searchParams.put(paramName, paramValue);
	}

}