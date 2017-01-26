package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;

@RestController
//@RequestMapping("/consents")
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

		return serviceFactory.getClientConsentService().getClientConsents(null);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/clients/{clientid}/consentrequests")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="CREATE_CLIENT_CONSENT_REQUEST")
	public ClientConsentRequest createClientConsentRequest(@PathVariable("clientid") UUID clientId ,@RequestBody ClientConsentRequest requestClientConsent, HttpServletRequest request) throws Exception {
			requestClientConsent.setClientId(clientId);
		return serviceFactory.getClientConsentService().createClientConsentRequest(requestClientConsent);
	}

	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="UPDATE_CLIENT_CONSENT_REQUEST")
	public ClientConsentRequest updateClientConsentRequest(
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,
			@RequestBody ClientConsentRequest requestClientConsent, HttpServletRequest request) throws Exception {
		requestClientConsent.setConsentRequestid(clientConsentRequestId);
		requestClientConsent.setClientId(clientId);
		
		return serviceFactory.getClientConsentService().updateClientConsentRequest(requestClientConsent);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="DELETE_CLIENT_CONSENT_REQUEST")
	public void deleteClientConsentRequest(			
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,HttpServletRequest request) throws Exception {
		
		serviceFactory.getClientConsentService().deleteClientConsentRequest(clientConsentRequestId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="GET_CLIENT_CONSENT_REQUEST_BY_ID")
	public ClientConsentRequest getClientConsentRequestById(
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,HttpServletRequest request) throws Exception {
		
		return serviceFactory.getClientConsentService().getClientConsentRequestById(clientConsentRequestId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consentrequests")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="GET_CLIENT_CONSENT_REQUESTS")
	public ClientConsentRequests getAllClientConsentRequests(
			@PathVariable("clientid") UUID clientId ,HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getAllClientConsentRequests();
	}
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consentrequests/{consentrequestid}/statuses")
	@APIMapping(checkSessionToken=false,checkTrustedApp=false,value="UPDATE_CLIENT_CONSENT_REQUEST_STATUS")
	public void updateConsentStatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("consentrequestid") UUID consentId ,
			@RequestBody ClientConsentStatus clientConsentStatus,HttpServletRequest request) throws Exception {
		clientConsentStatus.setConsentId(consentId);
		serviceFactory.getClientConsentService().updateClientConsentStatus(clientConsentStatus);
	}
	
}