package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldMapEntity;

public interface GlobalHouseHoldDao {

	GlobalHouseHoldEntity getGlobalHouseHold(String sourceSystemId,String sourceSystemHouseHoldId,String projectGroupCode);
	void createGlobalHouseHold(GlobalHouseHoldEntity entity);
	void addGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity);
	void removeGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity);
	List<GlobalHouseHoldMapEntity> getGlobalHouseHoldMapById(UUID hmisHouseHoldId,String projectGroupCode,String schemaYear);
}