package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HmisHouseholds;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;


public interface HmisHouseHoldService {

	HmisHousehold createHouseHold(HmisHousehold model,String caller);
	void updateHouseHold(HmisHousehold model,String caller);
	void deleteHouseHold(UUID householeId);
	HmisHousehold getHouseHoldById(UUID householeId);
	HmisHouseholds getAllHouseHolds(Integer startIndex, Integer maxItems);
	void addHouseHoldMember(HouseHoldMember member, String username);
	void removeHouseHoldMember(UUID householdId, UUID memberid, String username);
}