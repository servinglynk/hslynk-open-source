package com.servinglynk.hmis.warehouse.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("subscription")
public class Subscription {
	
	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
