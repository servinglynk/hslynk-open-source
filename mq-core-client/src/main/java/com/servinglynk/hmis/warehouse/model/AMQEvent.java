package com.servinglynk.hmis.warehouse.model;


import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("event")
public class AMQEvent {

	private Date createdAt;
	private String subsystem;
	private String module;
	private Map<String, Object> payload;
	private String eventType;
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getSubsystem() {
		return subsystem;
	}
	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Map<String, Object> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}	
	
	public String toJSONString() throws Exception {
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		String jsonString = objectMapper.writeValueAsString(this);
		return jsonString;
	}

}