package com.servinglynk.hmis.warehouse.base.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ClientTracker;

public interface ClientTrackerDao {
	
	ClientTracker insertClientTracker(ClientTracker clientTracker) ;
	
	void createTracker(UUID clientId, String projectGroup, boolean deletedFlag,String operation);

}