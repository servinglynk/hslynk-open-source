package com.servinglynk.hmis.warehouse.base.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.ClientConsentService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConsentConverter;
import com.servinglynk.hmis.warehouse.base.service.converter.GlobalProjectConveter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.Document;
import com.servinglynk.hmis.warehouse.model.Documents;
import com.servinglynk.hmis.warehouse.model.UploadHeader;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.GlobalProjectEntity;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;

public class ClientConsentServiceImpl extends ServiceBase implements ClientConsentService {

	@Transactional
	public ClientConsent createClientConsent(ClientConsent clientConsent,Session session) {
		ClientConsentEntity entity = ClientConsentConverter.modelToEntity(clientConsent, null);
		entity.setStatus("APPROVED");
		entity.setProjectGroupCode(session.getAccount().getProjectGroup().getProjectGroupCode());
		entity.setUser(session.getAccount().getAccountId());
		entity.setConsentGroupId(clientConsent.getConsentGroupId());
		entity.setDateCreated(LocalDateTime.now());
		daoFactory.getClientConsentDao().createClientConsent(entity);	
		
		for(GlobalProject globalProject : clientConsent.getGlobalProjects()) {
			GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao().getById(globalProject.getId());
			if(globalProjectEntity!=null) {
				ClientConsentProjectMapEntity projectMapEntity = new ClientConsentProjectMapEntity();
				projectMapEntity.setClientConsent(entity);
				projectMapEntity.setGlobalProject(globalProjectEntity);
				projectMapEntity.setUser(getUser());
				projectMapEntity.setProjectGroupCode(getProjectGroup());
				daoFactory.getClientConsentDao().createConsentProjectMap(projectMapEntity);
			}
		}
		
		clientConsent.setId(entity.getId());
		return clientConsent;
	}

	@Transactional
	public ClientConsent updateClientConsent(ClientConsent clientConsent,Session session) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsent.getId());
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsent.getId());
		ClientConsentConverter.modelToEntity(clientConsent, entity);
		entity.setDateUpdated(LocalDateTime.now());
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
				List<ClientConsentProjectMapEntity> projectMapEntities = daoFactory.getClientConsentDao().getClientConsentProjectMap(entity.getId());
				for(ClientConsentProjectMapEntity mapEntity : projectMapEntities) {
					model.addGlobalProject(GlobalProjectConveter.entityToModel(mapEntity.getGlobalProject()));
				}			
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
	public void addProjectToClientConsent(UUID clientConsentId, GlobalProjects globalProjects) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		
		for(GlobalProject globalProject : globalProjects.getGlobalProjects()) {
			GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao().getById(globalProject.getId());
			if(globalProjectEntity!=null) {
				ClientConsentProjectMapEntity projectMapEntity = new ClientConsentProjectMapEntity();
				projectMapEntity.setClientConsent(entity);
				projectMapEntity.setGlobalProject(globalProjectEntity);
				projectMapEntity.setUser(getUser());
				projectMapEntity.setProjectGroupCode(getProjectGroup());
				daoFactory.getClientConsentDao().createConsentProjectMap(projectMapEntity);
			}
		}
	}
	
	

	@Transactional
	public void updateProjectToClientConsent(UUID clientConsentId, GlobalProjects globalProjects) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(clientConsentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+clientConsentId);
		List<ClientConsentProjectMapEntity> mappings =  daoFactory.getClientConsentDao().getClientConsentProjectMap(entity.getId());
		for(ClientConsentProjectMapEntity mapping : mappings) {
			daoFactory.getClientConsentDao().deleteConsentProjectMap(mapping);
		}
		for(GlobalProject globalProject : globalProjects.getGlobalProjects()) {
			GlobalProjectEntity globalProjectEntity = daoFactory.getGlobalProjectDao().getById(globalProject.getId());
			if(globalProjectEntity!=null) {
				ClientConsentProjectMapEntity projectMapEntity = new ClientConsentProjectMapEntity();
				projectMapEntity.setClientConsent(entity);
				projectMapEntity.setGlobalProject(globalProjectEntity);
				projectMapEntity.setUser(getUser());
				projectMapEntity.setProjectGroupCode(getProjectGroup());
				daoFactory.getClientConsentDao().createConsentProjectMap(projectMapEntity);
			}
		}
	}
	
	@Transactional
	public void removeProjectFromClientConsent(UUID clientConsentId,UUID globalProjectId) {
		ClientConsentProjectMapEntity entity = daoFactory.getClientConsentDao().getClientConsentProjectMap(clientConsentId, globalProjectId);		
		if(entity == null) throw new ResourceNotFoundException("Global Project not associated with selected client Consent ");
		daoFactory.getClientConsentDao().deleteConsentProjectMap(entity);
	}

	@Transactional
	public void saveConsentDocument(MultipartFile multipartFile, UUID clientid,UUID consentId,Account loginUser) throws Exception {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(consentId);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+consentId);
		UploadHeader header = new UploadHeader();
		header.setUploadType("CONSENT_UPLOAD");
		header.setBucketName(loginUser.getProjectGroup().getBucketName());
		if(entity.getConsentDocument()!=null)	header.setUploadFileId(entity.getConsentDocument());
		header.setUploadFolder("CONSENT_DOCS/"+clientid);
		UploadHeader upload = fileUploadServiceFactory.getFileUploadService().uploadDocument(multipartFile, header);
		if(entity.getConsentDocument()==null)
			 entity.setConsentDocument(upload.getUploadFileId());
		daoFactory.getClientConsentDao().update(entity);
	}
	
	@Transactional
	public Documents getConsentDocuments(UUID clientid, UUID consentid) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(consentid);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+consentid);
		if(entity.getConsentDocument()==null) throw new ResourceNotFoundException("No documents for selected client consent");
		
		return fileUploadServiceFactory.getFileUploadService().getDocuments(entity.getConsentDocument());
	}
	
	@Transactional
	public void deleteConsentDocument(UUID clientid, UUID consentid,UUID documentId) {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(consentid);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+consentid);
		if(entity.getConsentDocument()==null) throw new ResourceNotFoundException("No documents for selected client consent");
		fileUploadServiceFactory.getFileUploadService().deleteDocument(documentId);
	}
	
	@Transactional
	public Document downloadConsentDocument(UUID clientid, UUID consentid,UUID documentId) throws Exception {
		ClientConsentEntity entity = daoFactory.getClientConsentDao().getClientConsentId(consentid);
		if(entity == null) throw new ResourceNotFoundException(" Client Consent not found "+consentid);
		if(entity.getConsentDocument()==null) throw new ResourceNotFoundException("No documents for selected client consent");

		return fileUploadServiceFactory.getFileUploadService().downloadDocument(documentId);
	}

	@Transactional
	public ClientConsents searchConsents(String consentGroupId,Integer startIndex,Integer maxItems) {
		ClientConsents consents = new ClientConsents(); 
		List<ClientConsentEntity> entities = daoFactory.getClientConsentDao().searchConsents(consentGroupId,startIndex,maxItems);
		for(ClientConsentEntity entity : entities) {
			consents.addClientConsent(ClientConsentConverter.entityToModel(entity));
		}
		
		Long count =daoFactory.getClientConsentDao().searchConsentsCount(consentGroupId);
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(startIndex);
		pagination.setReturned(entities.size());
		pagination.setTotal((count.intValue()) );
		consents.setPagination(pagination);
		
		return consents;
	}

	@Transactional
	public BaseClients searchClients(String consentGroupId, Integer startIndex, Integer maxItems) {
		BaseClients clients = new BaseClients(); 
		List<ClientConsentEntity> entities = daoFactory.getClientConsentDao().searchClients(consentGroupId,startIndex,maxItems);
		for(ClientConsentEntity entity : entities) {
			BaseClient client = new BaseClient();
			client.setClientId(entity.getClientId());
			clients.addClient(client); 
		}
		
		Long count =daoFactory.getClientConsentDao().searchClientsCount(consentGroupId);
		SortedPagination pagination = new SortedPagination();
		pagination.setFrom(startIndex);
		pagination.setReturned(entities.size());
		pagination.setTotal((count.intValue()) );
		clients.setPagination(pagination);
		
		return clients;
	}

	
}
