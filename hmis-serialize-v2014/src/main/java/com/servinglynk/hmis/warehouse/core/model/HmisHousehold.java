package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("hmisHousehold")
public class HmisHousehold  extends ClientModel {
	private UUID houseHoldId;
	private UUID headOfHouseHoldId;
	private String link;
	List<HouseHoldMember> houseHoldMembers = new ArrayList<HouseHoldMember>();
	
	public UUID getHouseHoldId() {
		return houseHoldId;
	}
	public void setHouseHoldId(UUID houseHoldId) {
		this.houseHoldId = houseHoldId;
	}
	public UUID getHeadOfHouseHoldId() {
		return headOfHouseHoldId;
	}
	public void setHeadOfHouseHoldId(UUID headOfHouseHoldId) {
		this.headOfHouseHoldId = headOfHouseHoldId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	public List<HouseHoldMember> getHouseHoldMembers() {
		return houseHoldMembers;
	}
	public void setHouseHoldMembers(List<HouseHoldMember> houseHoldMembers) {
		this.houseHoldMembers = houseHoldMembers;
	}
	public void addHouseHoldMember(HouseHoldMember member) {
		this.houseHoldMembers.add(member);
	}
}