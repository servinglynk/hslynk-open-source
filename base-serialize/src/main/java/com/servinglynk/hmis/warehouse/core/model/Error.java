package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("error")
public class Error extends ClientModel{

	private String code;

	private String message;

	/*@JsonProperty("parameter")
	private List<Parameter> parameters = new java.util.ArrayList<Parameter>();
*/


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

/*	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(Parameter parameter) {
		this.parameters.add(parameter);
	}*/
}
