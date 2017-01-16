package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.service.ClientConsentService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentConverter;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntities;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
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

}