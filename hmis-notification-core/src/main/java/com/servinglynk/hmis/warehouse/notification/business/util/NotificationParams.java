package com.servinglynk.hmis.warehouse.notification.business.util;

public class NotificationParams {
	
	private String senderEmailAddress;
	private String senderFriendlyName;
	private String templateId;
	private String url;
	
	private String receipientEmailAddress;
	
	public String getSenderEmailAddress() {
		return senderEmailAddress;
	}
	public void setSenderEmailAddress(String senderEmailAddress) {
		this.senderEmailAddress = senderEmailAddress;
	}
	public String getSenderFriendlyName() {
		return senderFriendlyName;
	}
	public void setSenderFriendlyName(String senderFriendlyName) {
		this.senderFriendlyName = senderFriendlyName;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getReceipientEmailAddress() {
		return receipientEmailAddress;
	}
	public void setReceipientEmailAddress(String receipientEmailAddress) {
		this.receipientEmailAddress = receipientEmailAddress;
	}
	

	

}
