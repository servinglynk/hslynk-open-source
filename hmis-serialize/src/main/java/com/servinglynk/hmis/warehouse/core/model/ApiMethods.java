package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;



@JsonRootName("apiMethods")
public class ApiMethods	{

	@JsonProperty("apiMethod")
	private List<ApiMethod> apiMethods =  new ArrayList<ApiMethod>();

	public List<ApiMethod> getApiMethods() {
		return apiMethods;
	}
	
	public void addApiMethod(ApiMethod apiMehtod) {
		if (apiMethods == null) this.apiMethods = new ArrayList<ApiMethod>();
		apiMethods.add(apiMehtod);
	}
	
	public void setApiMethods(List<ApiMethod> apiMethods) {
		this.apiMethods = apiMethods;
	}
}
