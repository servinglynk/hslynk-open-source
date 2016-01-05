package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName("apiMethods")
public class ApiMethods	{

	@JsonProperty("apiMethods")
	private List<ApiMethod> apiMethods =  new ArrayList<ApiMethod>();

	public List<ApiMethod> getApiMethods() {
		return apiMethods;
	}
	
	public void addApiMethod(ApiMethod apiMehtod) {
		this.apiMethods.add(apiMehtod);
	}
	
	public void setApiMethods(List<ApiMethod> apiMethods) {
		this.apiMethods = apiMethods;
	}
}
