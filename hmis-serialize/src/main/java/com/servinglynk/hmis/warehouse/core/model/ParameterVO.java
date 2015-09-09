package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Parameters;

public class ParameterVO {

	HashMap<String, Object> map = new HashMap<String, Object>();

	public ParameterVO(List<Parameter> parameters) {
		if (parameters != null && !parameters.isEmpty())
			map(parameters);
	}

	public ParameterVO(Parameters parameters) {
		if (parameters != null)
			map(parameters.getParameters());
	}

	public Parameter createParameter(String key, Object value) {
		Parameter param = new Parameter();
		param.setKey(key);
		param.setValue(value);
		return param;
	}

	public void addParameter(String key, Object value) {
		if (value!=null) {
			ArrayList<Object> list = new ArrayList<Object>();
			list.add(value);
			map.put(key, value);
		}
	}
	


	public HashMap<String, ?> map(List<Parameter> parameters) {
		ArrayList<Object> list = null;
		for (Parameter parameter : parameters) {
			Object value = parameter.getValue();			
			map.put(parameter.getKey(), value);
		}
		return map;
	}
	
	/*
	public HashMap<String, ?> map(List<Parameter> parameters) {
		ArrayList<Object> list = null;
		for (Parameter parameter : parameters) {
			list = new ArrayList<Object>(0);
			if (map.containsKey(parameter.getKey()))
				list = (ArrayList<Object>) map.get(parameter.getKey());
			list.add(parameter.getValue());
			map.put(parameter.getKey(), list);
		}
		return map;
	}*/

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	public Object get(String key) {
		return map.get(key);
	}

	public Double getDouble(String key) {
		Object object = map.get(key);
		if (object == null)
			return null;

		if (object instanceof String)
			return Double.parseDouble((String) object);
		else {
			ArrayList<String> list = (ArrayList<String>) map.get(key);{
				if(!StringUtils.isEmpty((String) list.get(0)))
				return Double.parseDouble((String) list.get(0));
			}
		}
		return null;
	}
	

	public Integer getInteger(String key) {
		Object object = map.get(key);
		if(object==null) return null;
		if (object instanceof String)
			return Integer.parseInt((String) object);
		else {
			ArrayList<String> list = (ArrayList<String>) map.get(key);
			if(!StringUtils.isEmpty((String) list.get(0))){
			return Integer.parseInt((String) list.get(0));
			}
		}
		return null;
	}

	public Boolean getBoolean(String key) {
		Object object = map.get(key);
		if (object instanceof String)
			return Boolean.parseBoolean((String) object);
		else {
			ArrayList<String> list = (ArrayList<String>) map.get(key);
			return Boolean.parseBoolean((String) list.get(0));
		}
	}

	public String getStringValue(String key) {
		Object object = map.get(key);
		if(object==null) return null;
		if (object instanceof String)
			return (String) object;
		else {
			ArrayList<String> list = (ArrayList<String>) map.get(key);
			return list.get(0);
		}
	}

	public ArrayList<ArrayList<String>> getList(String key) {
		return (ArrayList<ArrayList<String>>) map.get(key);
	}
}
