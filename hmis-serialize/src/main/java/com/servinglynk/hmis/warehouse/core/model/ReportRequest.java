package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("reportRequest")
public class ReportRequest extends ClientModel {
	

	
	String subject;
	
	String tempLocation;
	
	@JsonProperty("parameters")
	Parameters parameters;

	
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTempLocation() {
		return tempLocation;
	}
	public void setTempLocation(String tempLocation) {
		this.tempLocation = tempLocation;
	}


	
	
	
	
	
}
