package com.servinglynk.hmis.warehouse.base.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.servinglynk.hmis.warehouse.model.base.ApiMethodEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentStatusEntity;

public class ClientConsentDaoImpl extends QueryExecutorImpl implements ClientConsentDao {

	public void createClientConsent(ClientConsentEntity entity) {
		insert(entity);
	}

	public void updateClientConsent(ClientConsentEntity entity) {
		update(entity);
	}

	public void deleteClientConsent(ClientConsentEntity entity) {
		getCurrentSession().update(entity);
	}

	public ClientConsentEntity getClientConsentId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<ClientConsentEntity> consents = (List<ClientConsentEntity>) findByCriteria(criteria);
		if(!consents.isEmpty()) return consents.get(0);
		return null;
	}

	public List<ClientConsentEntity> getClinetConsents() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
		List<ClientConsentEntity> consents = (List<ClientConsentEntity>) findByCriteria(criteria);
		return consents;

	}

	public List<ClientConsentEntity> getClinetConsents(UUID clientId,Integer startIndex,Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
		if(clientId!=null) criteria.add(Restrictions.eq("clientId", clientId));
		List<ClientConsentEntity> consents = new ArrayList<>();
		if(startIndex==null || maxItems==null) {
			consents = (List<ClientConsentEntity>) findByCriteria(criteria);
		}else {
			
		 consents = (List<ClientConsentEntity>) findByCriteria(criteria,startIndex,maxItems);
		}
		return consents;
	}
	
	public long getClientConsentsCount(UUID clientId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
		if(clientId!=null) criteria.add(Restrictions.eq("clientId", clientId));
		return countRows(criteria);
	}
	
	public void createClientConsentRequest(ClientConsentRequestEntity entity) {
		insert(entity);
	}

	public void updateClientConsentRequest(ClientConsentRequestEntity entity) {
		update(entity);
	}
	
	public void deleteClientConsentRequestEntities(ClientConsentRequestEntitiesEntity entitiesEntity){
		delete(entitiesEntity);
	}

	public void deleteClientConsentRequest(ClientConsentRequestEntity entity) {
		getCurrentSession().update(entity);
	}

	public ClientConsentRequestEntity getClientConsentRequestId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentRequestEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<ClientConsentRequestEntity> consents = (List<ClientConsentRequestEntity>) findByCriteria(criteria);
		if(!consents.isEmpty()) return consents.get(0);
		return null;
	}

	public List<ClientConsentRequestEntity> getClinetConsentRequests(UUID clientId,Integer startIndex,Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentRequestEntity.class);
		criteria.add(Restrictions.eq("clientId", clientId));
		List<ClientConsentRequestEntity> consents = (List<ClientConsentRequestEntity>) findByCriteria(criteria,startIndex,maxItems);
		return consents;

	}
	
	public long getClientConsentRequestsCount(UUID clientId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentRequestEntity.class);
		criteria.add(Restrictions.eq("clientId", clientId));
		return countRows(criteria);
	}
		
	public void updateConsentStatus(ClientConsentStatusEntity entity){
		insertOrUpdate(entity);		
	}

	public List<ClientConsentStatusEntity> getClientConsentStatusByConsentId(UUID consentRequestId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentStatusEntity.class);
		criteria.createAlias("clientConsentRequestEntity", "clientConsentRequestEntity");
		criteria.add(Restrictions.eq("clientConsentRequestEntity.id", consentRequestId));
		return (List<ClientConsentStatusEntity>) findByCriteria(criteria);
	}
	
	public List<String> getConsentTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ApiMethodEntity.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("clientConsentGroup"));
		criteria.setProjection(Projections.distinct(projList));
		List<String> consentTypes =	(List<String>) findByCriteria(criteria);
		return consentTypes;
	}
	
	
	public void createConsentProjectMap(ClientConsentProjectMapEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
	}
	
	
	public void deleteConsentProjectMap(ClientConsentProjectMapEntity entity) {
		delete(entity);
	}
	
	public ClientConsentProjectMapEntity getClientConsentProjectMap(UUID clientConsentId,UUID globalProjectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentProjectMapEntity.class);
		criteria.createAlias("clientConsent", "clientConsent");
		criteria.createAlias("globalProject", "globalProject");
		
		criteria.add(Restrictions.eq("clientConsent.id",clientConsentId));
		if(globalProjectId!=null) criteria.add(Restrictions.eq("globalProject.id",globalProjectId));
		
		List<ClientConsentProjectMapEntity> entities = (List<ClientConsentProjectMapEntity>) findByCriteria(criteria);
		if(!entities.isEmpty()) return entities.get(0);
		return null;
	}
	
	public List<ClientConsentProjectMapEntity> getClientConsentProjectMap(UUID clientConsentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentProjectMapEntity.class);
		criteria.createAlias("clientConsent", "clientConsent");
		
		criteria.add(Restrictions.eq("clientConsent.id",clientConsentId));
		
		List<ClientConsentProjectMapEntity> entities = (List<ClientConsentProjectMapEntity>) findByCriteria(criteria);
		return entities;
	}

	@Override
	public List<ClientConsentEntity> searchConsents(String consentGroupId,Integer startIndex,Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
	      criteria.add(Restrictions.eq("consentGroupId", consentGroupId));
		return (List<ClientConsentEntity>) findByCriteria(criteria,startIndex,maxItems);
	}
	
	public Long searchConsentsCount(String consentGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
	      criteria.add(Restrictions.eq("consentGroupId", consentGroupId));
		return countRows(criteria);
	}

	@Override
	public List<ClientConsentEntity> searchClients(String consentGroupId, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
	      criteria.add(Restrictions.eq("consentGroupId", consentGroupId));
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.distinct(Projections.property("clientId")),"clientId");
			criteria.setProjection(projectionList);
			criteria.setResultTransformer(Transformers.aliasToBean(ClientConsentEntity.class));
			if(startIndex!=null && maxItems!=null) {
				return (List<ClientConsentEntity>) findByCriteria(criteria,startIndex,maxItems);
			}else {
				return (List<ClientConsentEntity>) findByCriteria(criteria);
			}
		
		
	}
	
	public List<UUID> searchClients(String consentGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
	      criteria.add(Restrictions.eq("consentGroupId", consentGroupId));
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.distinct(Projections.property("clientId")),"clientId");
			criteria.setProjection(projectionList);
			
		return (List<UUID>) findByCriteria(criteria);	
	}
	
	public Long searchClientsCount(String consentGroupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
	      criteria.add(Restrictions.eq("consentGroupId", consentGroupId));
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.distinct(Projections.property("clientId")),"clientId");
			criteria.setProjection(projectionList);
		return countRows(criteria);
	}
}