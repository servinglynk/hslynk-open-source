package com.servinglynk.hmis.warehouse.base.service;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.Document;
import com.servinglynk.hmis.warehouse.model.Documents;

public interface ClientConsentService {

	ClientConsent createClientConsent(ClientConsent clientConsent, Session session);

	ClientConsent updateClientConsent(ClientConsent clientConsent, Session session);

	void deleteClientConsent(UUID clientConsentId);

	ClientConsent getClientConsentId(UUID clientConsentId);

	ClientConsents getClientConsents(UUID clientId,Integer startIndex,Integer maxItems);
	
	
	void addProjectToClientConsent(UUID clientConsentId, GlobalProjects globalProjects);
	
	void removeProjectFromClientConsent(UUID clientConsentId,UUID globalProjectId);

	void saveConsentDocument(MultipartFile multipartFile, UUID clientid, UUID consentid,Account loginUser) throws Exception ;

	Documents getConsentDocuments(UUID clientid, UUID consentid);
	
	void deleteConsentDocument(UUID clientid, UUID consentid,UUID documentId);
	
	Document downloadConsentDocument(UUID clientid, UUID consentid,UUID documentId) throws Exception ;

}