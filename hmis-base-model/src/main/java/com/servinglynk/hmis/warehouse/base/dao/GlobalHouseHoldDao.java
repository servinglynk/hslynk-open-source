package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldMapEntity;

public interface GlobalHouseHoldDao {

	GlobalHouseHoldEntity createGLobalHouseHold(GlobalHouseHoldEntity entity);

	void deleteGLobalHouseHold(GlobalHouseHoldEntity entity);

	void addGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity);

	void deleteGLobalHouseHoldMap(GlobalHouseHoldMapEntity entity);

	GlobalHouseHoldEntity getGlobalHouseHoldByid(UUID globalHouseHoldId);

	List<GlobalHouseHoldMapEntity> getByGlobalHouseHoldMaps(UUID globalHouseHoldId);

	GlobalHouseHoldMapEntity getGlobalHouseHoldMapByids(UUID globalHouseHoldId);

	List<GlobalHouseHoldEntity> getGlobalHouseHold(Integer start, Integer maxItems);
	
	long countGlobalHouseHold();

}
