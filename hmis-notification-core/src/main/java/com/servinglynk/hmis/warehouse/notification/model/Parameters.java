package com.servinglynk.hmis.warehouse.notification.model;

import java.util.ArrayList;import java.util.List;import org.apache.commons.lang.builder.ToStringBuilder;import com.fasterxml.jackson.annotation.JsonProperty;import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("parameters")public class Parameters extends ClientModel{
	@JsonProperty("parameter")	protected List<Parameter> parameters;

	public List<Parameter> getParameters() {		if (parameters == null) {			this.parameters = new ArrayList<Parameter>();		}		
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public void addParameter(Parameter parameter) {
		if (parameters == null) {
			this.parameters = new ArrayList<Parameter>();
		}
		parameters.add(parameter);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
