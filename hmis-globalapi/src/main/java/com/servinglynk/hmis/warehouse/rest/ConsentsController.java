package com.servinglynk.hmis.warehouse.rest;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentEntityModel;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;

@RestController
@RequestMapping("/consents")
public class ConsentsController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="CREATE_CLIENT_CONSENT")
	public ClientConsent createClientConsent(@RequestBody ClientConsent clientConsent,HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().createClientConsent(clientConsent);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{consentid}")	
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="UPDATE_CLIENT_CONSENT")
	public ClientConsent updateClientConsent(@RequestBody ClientConsent clientConsent,@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		clientConsent.setId(consentId);
		return serviceFactory.getClientConsentService().updateClientConsent(clientConsent);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{consentid}")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="DELETE_CLIENT_CONSENT")
	public void deleteClientConsent(@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		serviceFactory.getClientConsentService().deleteClientConsent(consentId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{consentid}")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="GET_CLIENT_CONSENT")
	public ClientConsent getClientConsentById(@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getClientConsentId(consentId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="GET_CLIENT_CONSENTS")
	public ClientConsents getAllClientConsents(HttpServletRequest request) throws Exception {
/*		ClientConsents clientConsents = new ClientConsents();
		
		ClientConsent clientConsent = new ClientConsent();
			clientConsent.setClientId(UUID.randomUUID());
			clientConsent.setEndTime(LocalDateTime.now());		
			clientConsent.setStartTime(LocalDateTime.now());
			clientConsent.setId(UUID.randomUUID());
			clientConsent.setStatus("APPROVED");
			
			ClientConsentEntityModel entity = new ClientConsentEntityModel();
			entity.setClientConsentId(UUID.randomUUID());
			entity.setConsentEntityId(UUID.randomUUID());
			entity.setConsentTypeId(UUID.randomUUID());
		clientConsent.getClientConsentEntities().addClientConsentEntity(entity);
		
		clientConsents.addClientConsent(clientConsent);*/
		return serviceFactory.getClientConsentService().getClientConsents(null);
	}
	
}