package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHold;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHolds;

public interface GlobalHouseHoldService {

	public GlobalHouseHold createGlobalHouseHold(GlobalHouseHold globalHouseHold,Account account);	
	public void updateGlobalHouseHold(GlobalHouseHold globalHouseHold, Account account);
	
	public GlobalHouseHold getGlobalHouseHoldById(UUID globalHouseHoldId);
	

	public GlobalHouseHolds getGlobalHouseHolds(Integer start, Integer maxItems);
	public void deleteGlobalHousehold(UUID globalHouseHoldId);
	
}