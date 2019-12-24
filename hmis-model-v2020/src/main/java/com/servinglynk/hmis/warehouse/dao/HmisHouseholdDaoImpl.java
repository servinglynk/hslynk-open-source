package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2020.HmisHouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2020.HmisHousehold;

public class HmisHouseholdDaoImpl extends QueryExecutorImpl implements HmisHouseholdDao {

	public HmisHousehold createHouseHold(HmisHousehold entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void updateHouseHold(HmisHousehold entity) {
		update(entity);
	}
	
	public void deleteHouseHold(HmisHousehold entity) {
		delete(entity);
	}
	
	public HmisHousehold getHouseHoldById(UUID householeId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisHousehold.class);
		criteria.add(Restrictions.eq("id", householeId));
		List<HmisHousehold> households = (List<HmisHousehold>) findByCriteria(criteria);
		if(households.isEmpty()) return null;
		return households.get(0);
	}
	
	public List<HmisHousehold> getAllHouseHolds(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisHousehold.class);
		List<HmisHousehold> households = (List<HmisHousehold>) findByCriteria(criteria,startIndex,maxItems);
		return households;
	}

	public long getHouseHoldCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisHousehold.class);
		return countRows(criteria);
	}

	@Override
	public void addHouseHoldMember(HmisHouseHoldMember entity) {
				entity.setId(UUID.randomUUID());
				insert(entity);		
	}

	@Override
	public void removeHouseHoldMember(HmisHouseHoldMember entity) {
				delete(entity);
	}

	@Override
	public HmisHouseHoldMember getHouseHoldMember(UUID householdId, UUID memberId) {
			DetachedCriteria criteria = DetachedCriteria.forClass(HmisHouseHoldMember.class);
			criteria.createAlias("hmisHousehold", "hmisHousehold");
			criteria.add(Restrictions.eq("hmisHousehold.id", householdId));
			criteria.add(Restrictions.eq("memberId", memberId));
			List<HmisHouseHoldMember> entities = (List<HmisHouseHoldMember>) findByCriteria(criteria);
			if(entities.isEmpty()) return null;
		return entities.get(0);
	}
}
