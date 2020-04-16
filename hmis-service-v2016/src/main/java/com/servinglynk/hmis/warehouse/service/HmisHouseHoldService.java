package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HmisHouseholds;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2016.Client;


public interface HmisHouseHoldService {

	HmisHousehold createHouseHold(HmisHousehold model,Account caller);
	com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold createHmisHousehold(Client client,HmisHousehold model,Account caller);
	void updateHouseHold(HmisHousehold model,Account caller);
	void deleteHouseHold(UUID householeId);
	HmisHousehold getHouseHoldById(UUID householeId);
	HmisHouseholds getAllHouseHolds(Integer startIndex, Integer maxItems);
	void addHouseHoldMember(HouseHoldMember member, Account caller);
	void removeHouseHoldMember(UUID householdId, UUID memberid, Account caller);
}