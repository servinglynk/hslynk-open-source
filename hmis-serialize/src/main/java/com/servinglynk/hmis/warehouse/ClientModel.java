package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;


public abstract class ClientModel {
	
	@Override
	public String toString() {
		try{
			 return ToStringBuilder.reflectionToString(this);
		}catch(Exception e){ }
		
		return null;
	}
	
	public String toJSONString() throws Exception {
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		String jsonString = objectMapper.writeValueAsString(this);
		return jsonString;
	}
}
