package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.ClientConsentService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentRequestConverter;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentStatusEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class ClientConsentServiceImpl extends ServiceBase implements ClientConsentService {

	@Transactional
	public ClientConsent createClientConsent(ClientConsent clientConsent,Session session) {
		ClientConsentEntity entity = ClientConsentConverter.modelToEntity(clientConsent, null);
		entity.setStatus("APPROVED");

		if(clientConsent.getConsentUserId()==null){
			entity.setConsentUserId(session.getAccount().getAccountId());
		}else{
			entity.setConsentUserId(clientConsent.getConsentUserId());
		}
	
		entity.setProjectGroupCode(session.getAccount().getProjectGroup().getProjectGroupCode());
		entity.setUserId(session.getAccount().getAccountId());
		entity.setCreatedAt(new Date());
		daoFactory.getClientConsentDao().createClientConsent(entity);		
		clientConsent.setId(entity.getId());
		return clientConsent;
	}

	@Transactional
	public ClientConsent updateClientConsent(ClientConsent clientConsent,Session session) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsent.getId());
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsent.getId());
		ClientConsentConverter.modelToEntity(clientConsent, entity);
		entity.setModifiedAt(new Date());
		daoFactory.getClientConsentDao().update(entity);
		clientConsent.setId(entity.getId());
		return clientConsent;
	}

	@Transactional
	public void deleteClientConsent(UUID clientConsentId) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		entity.setDeleted(true);
		daoFactory.getClientConsentDao().deleteClientConsent(entity);;
	}

	@Transactional
	public ClientConsent getClientConsentId(UUID clientConsentId) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		return ClientConsentConverter.entityToModel(entity);
	}

	@Transactional
	public ClientConsents getClientConsents(UUID clientId,Integer startIndex,Integer maxItems) {
		ClientConsents consents  = new ClientConsents();
		long count =  daoFactory.getClientConsentDao().getClientConsentsCount(clientId);
		List<ClientConsentEntity> entities = daoFactory.getClientConsentDao().getClinetConsents(clientId,startIndex,maxItems);
		for(ClientConsentEntity entity : entities){
			ClientConsent model = ClientConsentConverter.entityToModel(entity);
			consents.addClientConsent(model);
		}
		
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(startIndex);
		pagination.setReturned(entities.size());
		pagination.setTotal((int) count);
		consents.setPagination(pagination);
		return consents;
	}
	
	@Transactional
	public ClientConsentRequest createClientConsentRequest(ClientConsentRequest clientConsentRequest,Session session) {
		ClientConsentRequestEntity entity = ClientConsentRequestConverter.modelToEntity(clientConsentRequest, null);
		entity.setCreatedAt(new Date());
		entity.setStatus("REQUESTED");
		if(clientConsentRequest.getConsentUserId()==null){
			entity.setConsentUserId(session.getAccount().getAccountId());
		}else{
			entity.setConsentUserId(clientConsentRequest.getConsentUserId());
		}
		entity.setProjectGroupCode(session.getAccount().getProjectGroup().getProjectGroupCode());
		daoFactory.getClientConsentDao().createClientConsentRequest(entity);
		clientConsentRequest.setId(entity.getId());
		return clientConsentRequest;
	}

	@Transactional
	public ClientConsentRequest updateClientConsentRequest(ClientConsentRequest clientConsentRequest,Session session) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequest.getId());
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequest.getId());
		if(entity.getStatus().equals("APPROVED") || entity.getStatus().equals("REJECTED")) throw new AccessDeniedException("Consent Request already APPROVED/REJECTED");
				ClientConsentRequestConverter.modelToEntity(clientConsentRequest, entity);
		daoFactory.getClientConsentDao().updateClientConsentRequest(entity);
		return clientConsentRequest;
	}
	
	@Transactional
	public void deleteClientConsentRequest(UUID clientConsentRequestId) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequestId);
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequestId);
		entity.setDeleted(true);
		daoFactory.getClientConsentDao().deleteClientConsentRequest(entity);
	}
	
	@Transactional
	public ClientConsentRequest getClientConsentRequestById(UUID clientConsentRequestId) {
		ClientConsentRequestEntity entity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentRequestId);
		if(entity==null) throw new ResourceNotFoundException("Client Consent request not found "+clientConsentRequestId);
		return ClientConsentRequestConverter.entityToModel(entity);
	}
	
	@Transactional
	public ClientConsentRequests getAllClientConsentRequests(UUID clientId,Integer startIndex,Integer maxItems) {
		ClientConsentRequests requests = new ClientConsentRequests();
		long count = daoFactory.getClientConsentDao().getClientConsentRequestsCount(clientId);
		List<ClientConsentRequestEntity> entities = daoFactory.getClientConsentDao().getClinetConsentRequests(clientId, startIndex, maxItems);
		for(ClientConsentRequestEntity entity : entities){
			requests.addClientConsent(ClientConsentRequestConverter.entityToModel(entity));
		}
		
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(startIndex);
		pagination.setReturned(entities.size());
		pagination.setTotal((int) count);
		requests.setPagination(pagination);
		
		return requests;
	}
	
	
	@Transactional
	public ClientConsentStatus updateClientConsentStatus(ClientConsentStatus clientConsentStatus,Session session){
		
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
			ClientConsentEntity clientConsentEntity =  ClientConsentRequestConverter.consentRequestToConsent(requestEntity,session.getAccount().getUsername());
			daoFactory.getClientConsentDao().createClientConsent(clientConsentEntity);
		}
		if(clientConsentStatus.getApprovalStatus().equalsIgnoreCase("REJECTED")){
			ClientConsentRequestEntity requestEntity = daoFactory.getClientConsentDao().getClientConsentRequestId(clientConsentStatus.getConsentId());
			requestEntity.setStatus("REJECTED");
			daoFactory.getClientConsentDao().updateClientConsentRequest(requestEntity);
		}
		
		return clientConsentStatus;
		
	}

}