package com.servinglynk.hmis.warehouse.notification.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationOriginatorType;


@JsonRootName("originator")
public class Originator {
	
	private String id;

	private NotificationOriginatorType type;
	
	private String sender;
	
	private String senderFriendly;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public NotificationOriginatorType getType() {
		return type;
	}
	public void setType(NotificationOriginatorType type) {
		this.type = type;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderFriendly() {
		return senderFriendly;
	}
	public void setSenderFriendly(String senderFriendly) {
		this.senderFriendly = senderFriendly;
	}
	@Override
	public String toString() {
		return "Originator [id=" + id + ", sender=" + sender
				+ ", senderFriendly=" + senderFriendly + ", type=" + type + "]";
	}
}
