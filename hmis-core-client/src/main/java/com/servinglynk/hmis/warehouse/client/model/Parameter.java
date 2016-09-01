package com.servinglynk.hmis.warehouse.client.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.ClientModel;


@JsonRootName("parameter")
public class Parameter extends ClientModel {
	
	String type;
	String key;
	Object value;
	String desc;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	
	/*public String getStringValue() {
		return (String)value;
	}
	*/
	
	public void setValue(Object value) {
		this.value = value;
	}
	

	protected List<Parameter> values =  null;
	public List<Parameter> getValues() {
		return values;
	}
	public void setValues(List<Parameter> values) {
		this.values = values;
	}
	
	public void addValue(Parameter value) {
		if (values == null) this.values = new ArrayList<Parameter>();
		values.add(value);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Parameter(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Parameter() {
		super();
	}
}
