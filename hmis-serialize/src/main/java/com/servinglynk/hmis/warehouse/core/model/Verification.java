package com.servinglynk.hmis.warehouse.core.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("verification")
public class Verification extends ClientModel{


	private String token;


	private String status;

	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@JsonProperty(value="parameters")
	private List<Parameter> parameters = new java.util.ArrayList<Parameter>();
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(Parameter parameter) {
		this.parameters.add(parameter);
	}
	
	public String getParameter(String paramKey) {
		if (parameters == null)  return null;
		for(Parameter p : parameters){
			if(p!=null){
					String paramName = p.getKey();
					if(paramName!=null && p.getKey().equalsIgnoreCase(paramKey)) {
						 return p.getValue().toString();
					}
			}
		}
		return null;
	}
	
}
