package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
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
		delete(entity);
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

	public List<ClientConsentEntity> getClinetConsents(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentEntity.class);
		if(clientId!=null) criteria.add(Restrictions.eq("clientId", clientId));
		List<ClientConsentEntity> consents = (List<ClientConsentEntity>) findByCriteria(criteria);
		return consents;
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
		delete(entity);
	}

	public ClientConsentRequestEntity getClientConsentRequestId(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentRequestEntity.class);
		criteria.add(Restrictions.eq("id", id));
		List<ClientConsentRequestEntity> consents = (List<ClientConsentRequestEntity>) findByCriteria(criteria);
		if(!consents.isEmpty()) return consents.get(0);
		return null;
	}

	public List<ClientConsentRequestEntity> getClinetConsentRequests() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientConsentRequestEntity.class);
		List<ClientConsentRequestEntity> consents = (List<ClientConsentRequestEntity>) findByCriteria(criteria);
		return consents;

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
	
}
