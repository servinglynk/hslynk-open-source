package com.servinglynk.hmis.warehouse.core.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class ClientModel {
	
	@Override
	public String toString() {
		try{
			return toJSONString();
		}catch(Exception e){ return ToStringBuilder.reflectionToString(this);}
	}
	

	
	public String toJSONString() throws Exception {
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		String jsonString = objectMapper.writeValueAsString(this);
		return jsonString;
	}
	
	
	@SuppressWarnings("unchecked")
	protected String getJsonFriendlyClassName(Class cls) {
		String name = "";
		XmlRootElement annotation = (XmlRootElement) cls.getAnnotation(XmlRootElement.class);
		if (annotation != null) {
			name = annotation.name();
		}
		return name;
	}
	
	

}
