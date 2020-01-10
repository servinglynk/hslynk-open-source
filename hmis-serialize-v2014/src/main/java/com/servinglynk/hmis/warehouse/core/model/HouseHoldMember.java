package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("houseHoldMember")
public class HouseHoldMember extends ClientModel{

	private UUID houseHoldMemberId;
	private Client member;
	private String relationWithHouseHold;
	private UUID houseHoldId;
	private String link;
	
	public UUID getHouseHoldMemberId() {
		return houseHoldMemberId;
	}
	public void setHouseHoldMemberId(UUID houseHoldMemberId) {
		this.houseHoldMemberId = houseHoldMemberId;
	}
	public Client getMember() {
		return member;
	}
	public void setMember(Client member) {
		this.member = member;
	}
	public String getRelationWithHouseHold() {
		return relationWithHouseHold;
	}
	public void setRelationWithHouseHold(String relationWithHouseHold) {
		this.relationWithHouseHold = relationWithHouseHold;
	}
	public UUID getHouseHoldId() {
		return houseHoldId;
	}
	public void setHouseHoldId(UUID houseHoldId) {
		this.houseHoldId = houseHoldId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}