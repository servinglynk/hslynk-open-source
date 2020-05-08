package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.client.MessageSender;
import com.servinglynk.hmis.warehouse.model.AMQEvent;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisHouseHoldMember;
import com.servinglynk.hmis.warehouse.model.v2015.HmisHousehold;

public class HmisHouseholdDaoImpl extends QueryExecutorImpl implements HmisHouseholdDao {
	
	@Autowired ParentDaoFactory parentDaoFactory;
	
	@Autowired MessageSender messageSender;

	public HmisHousehold createHouseHold(HmisHousehold entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		this.createHouseHoldMedataInfo(entity);
		this.createGlobalHouseHold(entity);
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
	
	
	public void createHouseHoldMedataInfo(com.servinglynk.hmis.warehouse.model.v2015.HmisHousehold hmisHousehold) {
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
		metaDataEntity.setAdditionalInfo("{\"houseHoldId\":\""+hmisHousehold.getId()+"\",\"schemaYear\":\"2015\",\"clientId\":\""+hmisHousehold.getHeadOfHousehold().getId()+"\"}");
		parentDaoFactory.getClientMetaDataDao().createClientMetaData(metaDataEntity);
	}
	
	public void createGlobalHouseHold(HmisHousehold hmisHousehold) {
		if(hmisHousehold.getSourceSystemId()!=null) {
			// creating active mq request
			AMQEvent amqEvent = new AMQEvent();
	
			amqEvent.setEventType("globalHouseHold");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("hmisHouseHoldId", hmisHousehold.getId());
			data.put("clientId", hmisHousehold.getHeadOfHousehold().getId());
			data.put("dedupClientId", hmisHousehold.getHeadOfHousehold().getDedupClientId());
			data.put("deleted", false);
			data.put("projectGroupCode", hmisHousehold.getProjectGroupCode());
			data.put("userId", hmisHousehold.getUser());
			data.put("sourceSystemId",hmisHousehold.getSourceSystemId());
			data.put("sourceSystemHouseHoldId",hmisHousehold.getSourceSystemHouseHoldId());
			data.put("schema","2015");
			amqEvent.setPayload(data);
			amqEvent.setModule("client-api");
			amqEvent.setSubsystem("v2015");
			messageSender.sendAmqMessage(amqEvent);
		}
	}
	
	public void deleteClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2015.HmisHousehold hmisHousehold) {
		ClientMetaDataEntity metaDataEntity = parentDaoFactory.getClientMetaDataDao().findByIdentifier(hmisHousehold.getId());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(true);
		parentDaoFactory.getClientMetaDataDao().updateClientMetaData(metaDataEntity);
	}
	
	
	public HmisHousehold fetchBulkUploadHouseHold(Enrollment enrollment) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisHousehold.class);
		criteria.add(Restrictions.eq("sourceSystemHouseHoldId", enrollment.getHouseholdid()));
		criteria.add(Restrictions.eq("projectGroupCode", enrollment.getProjectGroupCode()));
		criteria.add(Restrictions.eq("deleted", false));
		List<HmisHousehold> households = (List<HmisHousehold>) find(criteria);
		HmisHousehold hmisHousehold = null;
		if(households.isEmpty()) {
			hmisHousehold = new HmisHousehold();
			hmisHousehold.setId(UUID.randomUUID());
			hmisHousehold.setDateCreated(LocalDateTime.now());
			hmisHousehold.setDateUpdated(LocalDateTime.now());
			hmisHousehold.setProjectGroupCode(enrollment.getProjectGroupCode());
			hmisHousehold.setUser(enrollment.getUserId());
			hmisHousehold.setHeadOfHousehold(enrollment.getClient());
			hmisHousehold.setDedupClientId(enrollment.getClient().getDedupClientId());
			hmisHousehold.setDeleted(false);
			hmisHousehold.setSourceSystemHouseHoldId(enrollment.getHouseholdid());
			hmisHousehold.setSourceSystemId(enrollment.getSourceSystemId());
			insert(hmisHousehold);
		}else {
			hmisHousehold = households.get(0);
		}
		return hmisHousehold;
}
}
