package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("globalHousehold")
public class GlobalHouseHold extends ClientModel {
	
	private UUID id;
	private UUID user;
	
	@JsonProperty("globalHouseholdMappings")
	GlobalHouseHoldsMap globalHouseHoldMaps = new GlobalHouseHoldsMap();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUser() {
		return user;
	}

	public void setUser(UUID user) {
		this.user = user;
	}

	public GlobalHouseHoldsMap getGlobalHouseHoldMaps() {
		return globalHouseHoldMaps;
	}

	public void setGlobalHouseHoldMaps(GlobalHouseHoldsMap globalHouseHoldMaps) {
		this.globalHouseHoldMaps = globalHouseHoldMaps;
	}
}