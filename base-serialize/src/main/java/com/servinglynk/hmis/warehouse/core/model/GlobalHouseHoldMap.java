package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalHouseHoldMap extends ClientModel {

	private UUID id;
	@JsonProperty("genericHouseholdId")	              
	private UUID genericHouseHoldId;
	@JsonProperty("hmisHouseholdId")	   
	private UUID hmisHouseHoldId;
	@JsonProperty("schemaYear")
	private String shemaYear;
	private String link;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getGenericHouseHoldId() {
		return genericHouseHoldId;
	}
	public void setGenericHouseHoldId(UUID genericHouseHoldId) {
		this.genericHouseHoldId = genericHouseHoldId;
	}
	public UUID getHmisHouseHoldId() {
		return hmisHouseHoldId;
	}
	public void setHmisHouseHoldId(UUID hmisHouseHoldId) {
		this.hmisHouseHoldId = hmisHouseHoldId;
	}
	public String getShemaYear() {
		return shemaYear;
	}
	public void setShemaYear(String shemaYear) {
		this.shemaYear = shemaYear;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}