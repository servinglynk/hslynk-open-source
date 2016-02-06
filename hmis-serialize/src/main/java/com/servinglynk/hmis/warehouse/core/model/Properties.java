package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class Properties extends PaginatedModel {

	List<Property> properties =new ArrayList<Property>();

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public void add(Property property){
		this.properties.add(property);
	}
	
	
}
