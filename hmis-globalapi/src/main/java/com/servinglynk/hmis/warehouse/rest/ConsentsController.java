package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
public class ConsentsController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST,value="/clients/{clientid}/consents")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_CLIENT_CONSENT")
	public ClientConsent createClientConsent(@PathVariable("clientid") UUID clientId ,@RequestBody ClientConsent clientConsent,HttpServletRequest request) throws Exception {
		clientConsent.setClientId(clientId);
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientConsentService().createClientConsent(clientConsent,session);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consents/{consentid}")	
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="UPDATE_CLIENT_CONSENT")
	public ClientConsent updateClientConsent(@PathVariable("clientid") UUID clientId ,@RequestBody ClientConsent clientConsent,@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		clientConsent.setId(consentId);
		clientConsent.setClientId(clientId);
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientConsentService().updateClientConsent(clientConsent,session);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/clients/{clientid}/consents/{consentid}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="DELETE_CLIENT_CONSENT")
	public void deleteClientConsent(@PathVariable("clientid") UUID clientId ,@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		serviceFactory.getClientConsentService().deleteClientConsent(consentId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consents/{consentid}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENT")
	public ClientConsent getClientConsentById(@PathVariable("clientid") UUID clientId ,@PathVariable("consentid") UUID consentId,HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getClientConsentId(consentId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consents")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public ClientConsents getAllClientConsents(@PathVariable("clientid") UUID clientId,
			@RequestParam(value="startIndex",defaultValue="0",required=true) Integer startIndex,
			@RequestParam(value="maxItems",defaultValue="30",required=true) Integer maxItems,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getClientConsents(clientId,startIndex,maxItems);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consents/{consentid}/projects")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public void addClientConsentProjects(@PathVariable("clientid") UUID clientId,@PathVariable("consentid")  UUID clientConsentId,
				@RequestBody GlobalProjects globalProjects) {
		serviceFactory.getClientConsentService().addProjectToClientConsent(clientConsentId, globalProjects);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/clients/{clientid}/consents/{consentid}/projects/{globalProjectId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public void removeClientConsentProjects(@PathVariable("clientid") UUID clientId,
			@PathVariable("consentid") UUID clientConsentId,
			@PathVariable("globalProjectId") UUID globalProjectId) {
		serviceFactory.getClientConsentService().removeProjectFromClientConsent(clientConsentId, globalProjectId);
		
	}
	

}