package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentTypes;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.Session;

public interface ClientConsentService {

	ClientConsent createClientConsent(ClientConsent clientConsent, Session session);

	ClientConsent updateClientConsent(ClientConsent clientConsent, Session session);

	void deleteClientConsent(UUID clientConsentId);

	ClientConsent getClientConsentId(UUID clientConsentId);

	ClientConsents getClientConsents(UUID clientId,Integer startIndex,Integer maxItems);

	ClientConsentRequest createClientConsentRequest(ClientConsentRequest clientConsentRequest, Session session);

	ClientConsentRequest updateClientConsentRequest(ClientConsentRequest clientConsentRequest, Session session);

	void deleteClientConsentRequest(UUID clientConsentRequestId);

	ClientConsentRequest getClientConsentRequestById(UUID clientConsentRequestId);

	ClientConsentRequests getAllClientConsentRequests(UUID clientId,Integer startIndex,Integer maxItems);
	
	ClientConsentStatus updateClientConsentStatus(ClientConsentStatus clientConsentStatus,Session session);

	ClientConsentTypes getConsentTypes(Integer startIndex, Integer maxItems);
}