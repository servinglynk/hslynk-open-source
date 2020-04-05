package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("hmisHousehold")
public class HmisHousehold  extends ClientModel {
	private UUID houseHoldId;
	private Client headOfHouseHold;
	private String link;
	List<HouseHoldMember> houseHoldMembers = new ArrayList<HouseHoldMember>();
	private String sourceSystemHouseHoldId;
	private String sourceSystemId;
	
	public UUID getHouseHoldId() {
		return houseHoldId;
	}
	public void setHouseHoldId(UUID houseHoldId) {
		this.houseHoldId = houseHoldId;
	}
	public Client getHeadOfHouseHold() {
		return headOfHouseHold;
	}
	public void setHeadOfHouseHold(Client headOfHouseHold) {
		this.headOfHouseHold = headOfHouseHold;
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
	public String getSourceSystemHouseHoldId() {
		return sourceSystemHouseHoldId;
	}
	public void setSourceSystemHouseHoldId(String sourceSystemHouseHoldId) {
		this.sourceSystemHouseHoldId = sourceSystemHouseHoldId;
	}
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
	
	
}