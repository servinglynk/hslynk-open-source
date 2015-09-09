package com.servinglynk.hmis.warehouse.notification.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("reportReceipient")
public class ReportReceipient extends ClientModel{
	
	String resourceId;
	

	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private String email;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
