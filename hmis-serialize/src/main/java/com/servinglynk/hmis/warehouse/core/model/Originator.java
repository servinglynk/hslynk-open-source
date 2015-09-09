package com.servinglynk.hmis.warehouse.core.model;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("originator")
public class Originator {
	
	private String id;

	private String type;
	
	private String sender;
	
	private String senderFriendly;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
