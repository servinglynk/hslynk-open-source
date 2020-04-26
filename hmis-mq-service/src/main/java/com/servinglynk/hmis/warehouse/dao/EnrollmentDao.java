package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.Client;

public interface EnrollmentDao {
	
	List<Client> getGenericHousehold(UUID genericHouseholdId,String projectGroupCode, String schemaYear);
}
