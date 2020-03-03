package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.v2017.HmisHouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2017.HmisHousehold;

public class HmisHouseholdDaoImpl extends QueryExecutorImpl implements HmisHouseholdDao {

	@Autowired ParentDaoFactory parentDaoFactory;
	
	public HmisHousehold createHouseHold(HmisHousehold entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		this.createHouseHoldMedataInfo(entity);
		return entity;
	}
	
	public void updateHouseHold(HmisHousehold entity) {
		update(entity);
	}
	
	public void deleteHouseHold(HmisHousehold entity) {
		delete(entity);
		this.deleteClientMedataInfo(entity);
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
			criteria.createAlias("member", "member");
			criteria.add(Restrictions.eq("hmisHousehold.id", householdId));
			criteria.add(Restrictions.eq("member.id", memberId));
			List<HmisHouseHoldMember> entities = (List<HmisHouseHoldMember>) findByCriteria(criteria);
			if(entities.isEmpty()) return null;
		return entities.get(0);
	}
	
	public void createHouseHoldMedataInfo(com.servinglynk.hmis.warehouse.model.v2017.HmisHousehold hmisHousehold) {
		ClientMetaDataEntity metaDataEntity = new ClientMetaDataEntity();
		metaDataEntity.setId(UUID.randomUUID());
		metaDataEntity.setClientId(hmisHousehold.getHeadOfHousehold().getId());
		metaDataEntity.setClientDedupId(hmisHousehold.getHeadOfHousehold().getDedupClientId());
		metaDataEntity.setDate(LocalDateTime.now());
		metaDataEntity.setDateCreated(LocalDateTime.now());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(false);
		metaDataEntity.setMetaDataIdentifier(hmisHousehold.getId());
		metaDataEntity.setType("hmishouseholds");
		metaDataEntity.setProjectGroupCode(hmisHousehold.getProjectGroupCode());
		metaDataEntity.setUserId(hmisHousehold.getUser());
		metaDataEntity.setAdditionalInfo("{\"houseHoldId\":\""+hmisHousehold.getId()+"\",\"schemaYear\":\"2017\",\"clientId\":\""+hmisHousehold.getHeadOfHousehold().getId()+"\"}");
		parentDaoFactory.getClientMetaDataDao().createClientMetaData(metaDataEntity);
	}
	
	public void deleteClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2017.HmisHousehold hmisHousehold) {
		ClientMetaDataEntity metaDataEntity = parentDaoFactory.getClientMetaDataDao().findByIdentifier(hmisHousehold.getId());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(true);
		parentDaoFactory.getClientMetaDataDao().updateClientMetaData(metaDataEntity);
	}
}
