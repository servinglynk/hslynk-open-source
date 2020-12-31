package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SubscriptionModel extends ClientModel {
	
	
	private UUID id;
	@NotNull(message = "Resource type is required")
	private String resourceType;
	@NotNull(message = "Criteria is required")
	private String criteria;

	private String reason;
	private String status;
	private Date end;
	
	@Valid
	private SubscriptionChannel channel;
	private List<SubscriptionContact> contact = new ArrayList<SubscriptionContact>();
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SubscriptionChannel getChannel() {
		return channel;
	}
	public void setChannel(SubscriptionChannel channel) {
		this.channel = channel;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public List<SubscriptionContact> getContact() {
		return contact;
	}
	public void setContact(List<SubscriptionContact> contact) {
		this.contact = contact;
	}
}