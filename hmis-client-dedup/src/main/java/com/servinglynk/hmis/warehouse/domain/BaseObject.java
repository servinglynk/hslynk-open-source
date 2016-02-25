package com.servinglynk.hmis.warehouse.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.servinglynk.hmis.warehouse.JSONObjectMapper;

/**
 * Base class for Model objects. Child objects should implement toString(),
 * equals() and hashCode().
 * 
 */
public abstract class BaseObject implements Serializable {    

	
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
