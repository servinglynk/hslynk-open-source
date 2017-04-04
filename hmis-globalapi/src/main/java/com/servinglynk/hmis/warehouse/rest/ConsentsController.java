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
import com.servinglynk.hmis.warehouse.core.model.ClientConsentStatus;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentTypes;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequest;
import com.servinglynk.hmis.warehouse.core.model.ClientConsentRequests;

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
	
	@RequestMapping(method=RequestMethod.POST,value="/clients/{clientid}/consentrequests")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_CLIENT_CONSENT_REQUEST")
	public ClientConsentRequest createClientConsentRequest(@PathVariable("clientid") UUID clientId ,@RequestBody ClientConsentRequest requestClientConsent, HttpServletRequest request) throws Exception {
			requestClientConsent.setClientId(clientId);
			Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientConsentService().createClientConsentRequest(requestClientConsent,session);
	}

	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="UPDATE_CLIENT_CONSENT_REQUEST")
	public ClientConsentRequest updateClientConsentRequest(
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,
			@RequestBody ClientConsentRequest requestClientConsent, HttpServletRequest request) throws Exception {
		requestClientConsent.setId(clientConsentRequestId);
		requestClientConsent.setClientId(clientId);
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientConsentService().updateClientConsentRequest(requestClientConsent,session);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="DELETE_CLIENT_CONSENT_REQUEST")
	public void deleteClientConsentRequest(			
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,HttpServletRequest request) throws Exception {
		serviceFactory.getClientConsentService().deleteClientConsentRequest(clientConsentRequestId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consentrequests/{consentrequestid}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENT_REQUEST_BY_ID")
	public ClientConsentRequest getClientConsentRequestById(
			@PathVariable("clientid") UUID clientId ,
			@PathVariable("consentrequestid") UUID clientConsentRequestId,HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getClientConsentRequestById(clientConsentRequestId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consentrequests")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENT_REQUESTS")
	public ClientConsentRequests getAllClientConsentRequests(
			@PathVariable("clientid") UUID clientId,
			@RequestParam(value="startIndex",defaultValue="0",required=true) Integer startIndex,
			@RequestParam(value="maxItems",defaultValue="30",required=true) Integer maxItems,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getAllClientConsentRequests(clientId,startIndex,maxItems);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/clients/{clientid}/consentrequests/{consentrequestid}/statuses")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="UPDATE_CLIENT_CONSENT_REQUEST_STATUS")
	public void updateConsentStatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("consentrequestid") UUID consentId ,
			@RequestBody ClientConsentStatus clientConsentStatus,HttpServletRequest request) throws Exception {
		clientConsentStatus.setConsentId(consentId);
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientConsentService().updateClientConsentStatus(clientConsentStatus,session);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clientConsentTypes")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="UPDATE_CLIENT_CONSENT_REQUEST_STATUS")
	public ClientConsentTypes getConsentTypes(			
			@RequestParam(value="startIndex",defaultValue="0",required=true) Integer startIndex,
			@RequestParam(value="maxItems",defaultValue="30",required=true) Integer maxItems,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getClientConsentService().getConsentTypes(startIndex,maxItems);
	}
}