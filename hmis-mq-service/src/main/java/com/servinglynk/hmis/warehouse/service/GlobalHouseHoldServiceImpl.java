package com.servinglynk.hmis.warehouse.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.entity.GlobalHouseHoldMapEntity;
import com.servinglynk.hmis.warehouse.model.HmisHouseHoldModel;

@Component
public class GlobalHouseHoldServiceImpl extends BaseService implements  GlobalHouseHoldService {

	@Transactional
	public void createGlobalHouseHold(HmisHouseHoldModel model) {
		GlobalHouseHoldEntity entity =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHold(model.getSourceSystemId(), model.getSourceSystemHouseHoldId(), model.getProjectGroupCode());
		if(entity==null) {
			entity = new GlobalHouseHoldEntity();
			entity.setDateCreated(LocalDateTime.now());
			entity.setDateUpdated(LocalDateTime.now());
			entity.setDeleted(false);
			entity.setProjectGroupCode(model.getProjectGroupCode());
			entity.setUserId(model.getUserId());
			daoFactory.getGlobalHouseHoldDao().createGlobalHouseHold(entity);
		}
		
		GlobalHouseHoldMapEntity mapEntity = new GlobalHouseHoldMapEntity();
		mapEntity.setDateCreated(LocalDateTime.now());
		mapEntity.setDateUpdated(LocalDateTime.now());
		mapEntity.setUserId(model.getUserId());
		mapEntity.setSchemaYear(model.getSchema());
		mapEntity.setProjectGroupCode(model.getProjectGroupCode());
		mapEntity.setGlobalHouseHold(entity);
		mapEntity.setHmisHouseHoldId(model.getClientId());
		mapEntity.setSchemaYear(model.getSchema());
		mapEntity.setSourceSystemHouseHoldId(model.getSourceSystemHouseHoldId());
		mapEntity.setSourceSystemId(model.getSourceSystemId());
		daoFactory.getGlobalHouseHoldDao().addGlobalHouseHoldMap(mapEntity);
	}

	@Transactional
	public void deleteGlobalHouseHold(HmisHouseHoldModel model) {
		List<GlobalHouseHoldMapEntity> entities = daoFactory.getGlobalHouseHoldDao().getGlobalHouseHoldMapById(model.getHmisHouseHoldId(), model.getProjectGroupCode(), model.getSchema());
		for(GlobalHouseHoldMapEntity entity : entities) {
			daoFactory.getGlobalHouseHoldDao().removeGlobalHouseHoldMap(entity);
		}
	}

}
