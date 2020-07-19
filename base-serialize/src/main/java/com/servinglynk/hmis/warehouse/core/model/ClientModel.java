package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class ClientModel {
	
	@JsonSerialize(using=JsonDateSerializer.class)
	 LocalDateTime dateCreated;
	@JsonSerialize(using=JsonDateSerializer.class)	
	LocalDateTime dateUpdated;
	
	
	@JsonProperty("createdTimeStamp")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	 LocalDateTime createdTime;
	@JsonProperty("lastStatusTimeStamp")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	LocalDateTime updatedTime;
	
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}



	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}



	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}



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



	public LocalDateTime getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}



	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}



	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	
	  List<ActionLink> links;

		public List<ActionLink> getLinks() {
			return links;
		}

		public void setLinks(List<ActionLink> links) {
			this.links = links;
		}

		public void addLink(ActionLink link) {
			if (this.links == null)
				this.links = new ArrayList<ActionLink>();
			this.links.add(link);
		}
	 
}