package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalHouseHoldMapEntity;

public class GlobalHouseHoldDaoImpl extends QueryExecutorImpl implements GlobalHouseHoldDao {

	
	
	public GlobalHouseHoldEntity createGLobalHouseHold(GlobalHouseHoldEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void deleteGLobalHouseHold(GlobalHouseHoldEntity entity) {
		delete(entity);
	}
	
	public void addGlobalHouseHoldMap(GlobalHouseHoldMapEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	
	public void deleteGLobalHouseHoldMap(GlobalHouseHoldMapEntity entity) {
		delete(entity);
	}
	
	public GlobalHouseHoldEntity getGlobalHouseHoldByid(UUID globalHouseHoldId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldEntity.class);
		criteria.add(Restrictions.eq("id",globalHouseHoldId));
		List<GlobalHouseHoldEntity> entities = (List<GlobalHouseHoldEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}
	
	public List<GlobalHouseHoldMapEntity> getByGlobalHouseHoldMaps(UUID globalHouseHoldId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldMapEntity.class);
		criteria.createAlias("globalHouseHold", "globalHouseHold");
		criteria.add(Restrictions.eq("globalHouseHold.id",globalHouseHoldId));
		return (List<GlobalHouseHoldMapEntity>) findByCriteria(criteria);
	}
	
	public GlobalHouseHoldMapEntity getGlobalHouseHoldMapByids(UUID globalHouseHoldId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldMapEntity.class);
		criteria.add(Restrictions.eq("id",globalHouseHoldId));
		List<GlobalHouseHoldMapEntity> entities = (List<GlobalHouseHoldMapEntity>) findByCriteria(criteria);
		if(entities.isEmpty()) return null;
		return entities.get(0);
	}


	public List<GlobalHouseHoldEntity> getGlobalHouseHold(Integer start, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldEntity.class);
		List<GlobalHouseHoldEntity> entities = (List<GlobalHouseHoldEntity>) findByCriteria(criteria,start,maxItems);
		return entities;
	}
	
	public long countGlobalHouseHold() {
		DetachedCriteria criteria = DetachedCriteria.forClass(GlobalHouseHoldEntity.class);
		return countRows(criteria);
	}
}
