package com.servinglynk.hmis.warehouse.core.model;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("notification")
public class HmisNotification extends ClientModel {

	@Valid
	private Notification data;
	private String method;

	@Valid
	private AdditionalNotificationInfo additionalInfo= new AdditionalNotificationInfo();
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public AdditionalNotificationInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(AdditionalNotificationInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Notification getData() {
		return data;
	}

	public void setData(Notification data) {
		this.data = data;
	}
}