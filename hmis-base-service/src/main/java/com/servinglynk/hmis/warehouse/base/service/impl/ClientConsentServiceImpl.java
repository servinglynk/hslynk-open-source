package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.ClientConsentService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentRequestConverter;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentStatusEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class ClientConsentServiceImpl extends ServiceBase implements ClientConsentService {

	@Transactional
	public ClientConsent createClientConsent(ClientConsent clientConsent) {
		ClientConsentEntity entity = ClientConsentConverter.modelToEntity(clientConsent, null);
		entity.setCreatedAt(new Date());
		daoFactory.getClientConsentDao().createClientConsent(entity);		
		clientConsent.setId(entity.getId());
		return clientConsent;
	}

	@Transactional
	public ClientConsent updateClientConsent(ClientConsent clientConsent) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsent.getId());
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsent.getId());
		ClientConsentConverter.modelToEntity(clientConsent, entity);
		entity.setModifiedAt(new Date());
		daoFactory.getClientConsentDao().createClientConsent(entity);
		clientConsent.setId(entity.getId());
		return clientConsent;
	}

	@Transactional
	public void deleteClientConsent(UUID clientConsentId) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		daoFactory.getClientConsentDao().deleteClientConsent(entity);
	}

	@Transactional
	public ClientConsent getClientConsentId(UUID clientConsentId) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		return ClientConsentConverter.entityToModel(entity);
	}

	@Transactional
	public ClientConsents getClientConsents(UUID clientId) {
		ClientConsents consents  = new ClientConsents();
		List<ClientConsentEntity> entities = daoFactory.getClientConsentDao().getClinetConsents(clientId);
		for(ClientConsentEntity entity : entities){
			ClientConsent model = ClientConsentConverter.entityToModel(entity);
			consents.addClientConsent(model);
		}
		return consents;
	}
	
	@Transactional
	public ClientConsentRequest createClientConsentRequest(ClientConsentRequest clientConsentRequest) {
		ClientConsentRequestEntity entity = ClientConsentRequestConverter.modelToEntity(clientConsentRequest, null);
		entity.setCreatedAt(new Date());
		daoFactory.getClientConsentDao().createClientConsentRequest(entity);
		clientConsentRequest.setConsentRequestid(entity.getId());
		return clientConsentRequest;
	}

	@Transactional
	public ClientConsentRequest updateClientConsentRequest(ClientConsentRequest clientConsentRequest) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequest.getConsentRequestid());
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequest.getConsentRequestid());
		for(ClientConsentRequestEntitiesEntity entitiesEntity: entity.getConsentEntities()){
			daoFactory.getClientConsentDao().deleteClientConsentRequestEntities(entitiesEntity);
		}
		ClientConsentRequestConverter.modelToEntity(clientConsentRequest, entity);
		daoFactory.getClientConsentDao().updateClientConsentRequest(entity);
		return clientConsentRequest;
	}
	
	@Transactional
	public void deleteClientConsentRequest(UUID clientConsentRequestId) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequestId);
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequestId);
		daoFactory.getClientConsentDao().deleteClientConsentRequest(entity);
	}
	
	@Transactional
	public ClientConsentRequest getClientConsentRequestById(UUID clientConsentRequestId) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequestId);
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequestId);
		return ClientConsentRequestConverter.entityToModel(entity);
	}
	
	@Transactional
	public ClientConsentRequests getAllClientConsentRequests() {
		return null;
	}
	
	
	@Transactional
	public ClientConsentStatus updateClientConsentStatus(ClientConsentStatus clientConsentStatus){
		
		List<ClientConsentStatusEntity> entities = daoFactory.getClientConsentDao().getClientConsentStatusByConsentId(clientConsentStatus.getConsentId());
		ClientConsentStatusEntity entity = null;
		if(!entities.isEmpty()) {
			entity = entities.get(0);	
		}
		entity = ClientConsentRequestConverter.entityToModel(clientConsentStatus,entity);
		daoFactory.getClientConsentDao().updateConsentStatus(entity);
		if(clientConsentStatus.getApprovalStatus().equalsIgnoreCase("APPROVED")){
			ClientConsentRequestEntity requestEntity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentStatus.getConsentId());
			requestEntity.setStatus("APPROVED");
			requestEntity.setStartTime(clientConsentStatus.getApprovalStatusEffectiveFromDate());
			requestEntity.setEndTime(clientConsentStatus.getApprovalStatusEffectiveToDate());
			daoFactory.getClientConsentDao().updateClientConsentRequest(requestEntity);
			daoFactory.getClientConsentDao().createClientConsent(ClientConsentRequestConverter.consentRequestToConsent(requestEntity));
		}
		if(clientConsentStatus.getApprovalStatus().equalsIgnoreCase("REJECTED")){
			ClientConsentRequestEntity requestEntity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentStatus.getConsentId());
			requestEntity.setStatus("REJECTED");
			daoFactory.getClientConsentDao().updateClientConsentRequest(requestEntity);
		}
		
		return clientConsentStatus;
		
	}

}