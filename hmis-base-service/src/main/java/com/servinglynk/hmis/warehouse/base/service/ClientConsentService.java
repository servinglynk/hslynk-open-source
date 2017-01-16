package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;

public interface ClientConsentService {

	ClientConsent createClientConsent(ClientConsent clientConsent);
	ClientConsent updateClientConsent(ClientConsent clientConsent);
	void deleteClientConsent(UUID clientConsentId);
	ClientConsent getClientConsentId(UUID clientConsentId);
	ClientConsents getClientConsents(UUID clientId);
}