package com.servinglynk.hmis.warehouse.client.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class ClientModel {

	@Override
	public String toString() {
		try{
			return toJSONString();
		}catch(Exception e){ return ToStringBuilder.reflectionToString(this);}
	}
	

	
	public String toJSONString() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		String jsonString = mapper.writeValueAsString(this);
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
