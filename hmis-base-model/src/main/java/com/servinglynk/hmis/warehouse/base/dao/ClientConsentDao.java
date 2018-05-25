package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentProjectMapEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntitiesEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentRequestEntity;
import com.servinglynk.hmis.warehouse.model.base.ClientConsentStatusEntity;

public interface ClientConsentDao  extends QueryExecutor {

	void createClientConsent(ClientConsentEntity entity);
	void updateClientConsent(ClientConsentEntity entity);
	void deleteClientConsent(ClientConsentEntity entity);
	ClientConsentEntity getClientConsentId(UUID id);
	List<ClientConsentEntity> getClinetConsents();
	List<ClientConsentEntity> getClinetConsents(UUID clientId,Integer startIndex,Integer maxItems);
	long getClientConsentsCount(UUID clientId);
	
	void createClientConsentRequest(ClientConsentRequestEntity entity);
	void updateClientConsentRequest(ClientConsentRequestEntity entity);
	void deleteClientConsentRequest(ClientConsentRequestEntity entity);
	ClientConsentRequestEntity getClientConsentRequestId(UUID id);
	List<ClientConsentRequestEntity> getClinetConsentRequests(UUID clientId,Integer startIndex,Integer maxItems);
	long getClientConsentRequestsCount(UUID clientId);
	
	void deleteClientConsentRequestEntities(ClientConsentRequestEntitiesEntity entitiesEntity);
	void updateConsentStatus(ClientConsentStatusEntity entity);
	List<ClientConsentStatusEntity> getClientConsentStatusByConsentId(UUID consentRequestId);
	List<String> getConsentTypes();
	
	
	
	
	void createConsentProjectMap(ClientConsentProjectMapEntity entity);
	void deleteConsentProjectMap(ClientConsentProjectMapEntity entity);
	
	ClientConsentProjectMapEntity getClientConsentProjectMap(UUID clientConsentId,UUID globalProjectId);
	List<ClientConsentProjectMapEntity> getClientConsentProjectMap(UUID clientConsentId);
	List<ClientConsentEntity> searchConsents(String consentGroupId,Integer startIndex,Integer maxItems);
	Long searchConsentsCount(String consentGroupId);
	List<ClientConsentEntity> searchClients(String consentGroupId, Integer startIndex, Integer maxItems);
	Long searchClientsCount(String consentGroupId);
}