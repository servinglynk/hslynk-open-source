package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationSearchRequest {
	
	private Date fromDate;
	private Date toDate;
	private String recipientType;
	private String recipientId;
	private Integer startIndex;
	private Integer maxItems;
	private String projectGroup;
	private List<String> status= new ArrayList<String>();
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getMaxItems() {
		return maxItems;
	}
	public void setMaxItems(Integer maxItems) {
		this.maxItems = maxItems;
	}
	public String getProjectGroup() {
		return projectGroup;
	}
	public void setProjectGroup(String projectGroup) {
		this.projectGroup = projectGroup;
	}
}