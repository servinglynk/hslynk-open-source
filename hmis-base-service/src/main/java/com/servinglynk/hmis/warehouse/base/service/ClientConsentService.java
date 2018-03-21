package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.Session;

public interface ClientConsentService {

	ClientConsent createClientConsent(ClientConsent clientConsent, Session session);

	ClientConsent updateClientConsent(ClientConsent clientConsent, Session session);

	void deleteClientConsent(UUID clientConsentId);

	ClientConsent getClientConsentId(UUID clientConsentId);

	ClientConsents getClientConsents(UUID clientId,Integer startIndex,Integer maxItems);
	
	
	void addProjectToClientConsent(UUID clientConsentId, GlobalProjects globalProjects);
	
	void removeProjectFromClientConsent(UUID clientConsentId,UUID globalProjectId);

}