package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;

public interface ClientConsentService {

	ClientConsent createClientConsent(ClientConsent clientConsent);

	ClientConsent updateClientConsent(ClientConsent clientConsent);

	void deleteClientConsent(UUID clientConsentId);

	ClientConsent getClientConsentId(UUID clientConsentId);

	ClientConsents getClientConsents(UUID clientId);

	ClientConsentRequest createClientConsentRequest(ClientConsentRequest clientConsentRequest);

	ClientConsentRequest updateClientConsentRequest(ClientConsentRequest clientConsentRequest);

	void deleteClientConsentRequest(UUID clientConsentRequestId);

	ClientConsentRequest getClientConsentRequestById(UUID clientConsentRequestId);

	ClientConsentRequests getAllClientConsentRequests();
	
	ClientConsentStatus updateClientConsentStatus(ClientConsentStatus clientConsentStatus);
}