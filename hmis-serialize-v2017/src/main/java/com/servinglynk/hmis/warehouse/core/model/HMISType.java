package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("dataElement")
public class HMISType extends ClientModel {
	
	@JsonIgnore
	public String name;
	@JsonProperty("pickListValueCode")
	public String value;
	@JsonProperty("valueText")
	public String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}