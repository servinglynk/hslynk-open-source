package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ClientConsentEntity;

public interface ClientConsentDao  extends QueryExecutor {

	void createClientConsent(ClientConsentEntity entity);
	void updateClientConsent(ClientConsentEntity entity);
	void deleteClientConsent(ClientConsentEntity entity);
	ClientConsentEntity getClientConsentId(UUID id);
	List<ClientConsentEntity> getClinetConsents();
	List<ClientConsentEntity> getClinetConsents(UUID clientId);
}