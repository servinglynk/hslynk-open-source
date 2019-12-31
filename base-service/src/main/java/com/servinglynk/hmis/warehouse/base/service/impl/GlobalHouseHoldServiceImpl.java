package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.GlobalHouseHoldService;
import com.servinglynk.hmis.warehouse.base.service.converter.GlobalHouseHoldConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHold;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHoldMap;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHolds;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldMapEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class GlobalHouseHoldServiceImpl extends ServiceBase implements GlobalHouseHoldService {

	
	@Transactional
	public GlobalHouseHold createGlobalHouseHold(GlobalHouseHold globalHouseHold,Account account) {
		GlobalHouseHoldEntity houseHoldEntity = new GlobalHouseHoldEntity();
		houseHoldEntity.setUser(account.getAccountId());
		houseHoldEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		houseHoldEntity.setDateCreated(LocalDateTime.now());
		houseHoldEntity.setDateUpdated(LocalDateTime.now());
		daoFactory.getGlobalHouseHoldDao().createGLobalHouseHold(houseHoldEntity);
		for(GlobalHouseHoldMap map : globalHouseHold.getGlobalHouseHoldMaps().getGlobalHouseHoldMaps()) {
			GlobalHouseHoldMapEntity mapEntity =GlobalHouseHoldConverter.modelToEntity(null, map);
			mapEntity.setGlobalHouseHold(houseHoldEntity);
			mapEntity.setUser(account.getAccountId());
			mapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
			mapEntity.setDateCreated(LocalDateTime.now());
			mapEntity.setDateUpdated(LocalDateTime.now());
			daoFactory.getGlobalHouseHoldDao().addGlobalHouseHoldMap(mapEntity);
			}
		GlobalHouseHold model = new GlobalHouseHold();
		model.setId(houseHoldEntity.getId());
		return model;
	}
	
	@Transactional	
	public void updateGlobalHouseHold(GlobalHouseHold globalHouseHold,Account account) {

		GlobalHouseHoldEntity houseHoldEntity =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHoldByid(globalHouseHold.getId());
		if(houseHoldEntity==null) throw new ResourceNotFoundException("Global house hold not found");
		houseHoldEntity.setUser(account.getAccountId());
		houseHoldEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
		houseHoldEntity.setDateCreated(LocalDateTime.now());
		houseHoldEntity.setDateUpdated(LocalDateTime.now());
		List<GlobalHouseHoldMapEntity> mapEntities = daoFactory.getGlobalHouseHoldDao().getByGlobalHouseHoldMaps(houseHoldEntity.getId());
		for(GlobalHouseHoldMapEntity entity : mapEntities) {
			daoFactory.getGlobalHouseHoldDao().deleteGLobalHouseHoldMap(entity);
		}
		for(GlobalHouseHoldMap map : globalHouseHold.getGlobalHouseHoldMaps().getGlobalHouseHoldMaps()) {
			GlobalHouseHoldMapEntity mapEntity =GlobalHouseHoldConverter.modelToEntity(null, map);
			mapEntity.setGlobalHouseHold(houseHoldEntity);
			mapEntity.setUser(account.getAccountId());
			mapEntity.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
			mapEntity.setDateCreated(LocalDateTime.now());
			mapEntity.setDateUpdated(LocalDateTime.now());
			daoFactory.getGlobalHouseHoldDao().addGlobalHouseHoldMap(mapEntity);
			}
	}
	
	@Transactional
	public GlobalHouseHold getGlobalHouseHoldById(UUID globalHouseHoldId) {
		GlobalHouseHold globalHouseHold = new GlobalHouseHold();
		
		GlobalHouseHoldEntity houseHoldEntity =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHoldByid(globalHouseHoldId);
		if(houseHoldEntity==null) throw new ResourceNotFoundException("Global house hold not found");
		List<GlobalHouseHoldMapEntity> mapEntities = daoFactory.getGlobalHouseHoldDao().getByGlobalHouseHoldMaps(houseHoldEntity.getId());
		 globalHouseHold = GlobalHouseHoldConverter.entityToModel(houseHoldEntity);

		for(GlobalHouseHoldMapEntity entity : mapEntities) {
			globalHouseHold.getGlobalHouseHoldMaps().addGlobalHouseHoldMap(GlobalHouseHoldConverter.entityToModel(entity));

		}
		return globalHouseHold;
	}
	
	@Transactional
	public GlobalHouseHolds getGlobalHouseHolds(Integer start, Integer maxItems) {
		GlobalHouseHolds globalHouseHolds = new GlobalHouseHolds();
		
		List<GlobalHouseHoldEntity> houseHoldEntities =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHold(start,maxItems);
		
		for(GlobalHouseHoldEntity houseHoldEntity : houseHoldEntities) {
			GlobalHouseHold model = GlobalHouseHoldConverter.entityToModel(houseHoldEntity);
			List<GlobalHouseHoldMapEntity> mapEntities = daoFactory.getGlobalHouseHoldDao().getByGlobalHouseHoldMaps(houseHoldEntity.getId());
			for(GlobalHouseHoldMapEntity entity : mapEntities) {
					model.getGlobalHouseHoldMaps().addGlobalHouseHoldMap(GlobalHouseHoldConverter.entityToModel(entity));
			}
			globalHouseHolds.addGlobalHouseHold(model);
		}
		
		Long count = daoFactory.getGlobalHouseHoldDao().countGlobalHouseHold();
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(start);
		pagination.setReturned(houseHoldEntities.size());
		pagination.setTotal(count.intValue());
		globalHouseHolds.setPagination(pagination);		
		return globalHouseHolds;
	}

	@Transactional
	public void deleteGlobalHousehold(UUID globalHouseHoldId) {
		GlobalHouseHoldEntity houseHoldEntity =	daoFactory.getGlobalHouseHoldDao().getGlobalHouseHoldByid(globalHouseHoldId);
		if(houseHoldEntity==null) throw new ResourceNotFoundException("Global house hold not found");
		List<GlobalHouseHoldMapEntity> mapEntities = daoFactory.getGlobalHouseHoldDao().getByGlobalHouseHoldMaps(houseHoldEntity.getId());
		for(GlobalHouseHoldMapEntity entity : mapEntities) {
			daoFactory.getGlobalHouseHoldDao().deleteGLobalHouseHoldMap(entity);
		}
		daoFactory.getGlobalHouseHoldDao().deleteGLobalHouseHold(houseHoldEntity);
		
	}
	
}
