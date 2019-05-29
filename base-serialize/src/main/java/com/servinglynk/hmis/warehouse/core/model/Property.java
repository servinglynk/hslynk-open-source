package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("property")
public class Property extends ClientModel {

	private String key;
	private String value;
	private String oldValue;
	
	public Property(String key, String value,String oldValue) {
		super();
		this.key = key;
		this.value = value;
		this.oldValue =oldValue;
	}
	
	public Property(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}	
}