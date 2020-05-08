package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2016.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2016.HmisHouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2016.HmisHousehold;

public interface HmisHouseholdDao {

	HmisHousehold createHouseHold(HmisHousehold entity);
	void updateHouseHold(HmisHousehold entity);
	void deleteHouseHold(HmisHousehold entity);
	HmisHousehold getHouseHoldById(UUID householeId);
	List<HmisHousehold> getAllHouseHolds(Integer startIndex, Integer maxItems);
	long getHouseHoldCount();
	void addHouseHoldMember(HmisHouseHoldMember houseHoldMember);
	void removeHouseHoldMember(HmisHouseHoldMember houseHoldMember);
	HmisHouseHoldMember getHouseHoldMember(UUID householdId,UUID memberId);
	HmisHousehold fetchBulkUploadHouseHold(Enrollment enrollment);
}