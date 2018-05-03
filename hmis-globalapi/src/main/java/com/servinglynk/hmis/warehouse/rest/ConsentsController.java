package com.servinglynk.hmis.warehouse.rest;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ClientConsent;
import com.servinglynk.hmis.warehouse.core.model.ClientConsents;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.Document;
import com.servinglynk.hmis.warehouse.model.Documents;
import com.servinglynk.hmis.warehouse.model.UploadHeader;

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
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/checkUserConsent")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public Boolean checkClientUserAccess(@PathVariable("clientid") UUID clientId,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getAccountService().checkClientConsentAuthorizationForUser(session.getAccount(), clientId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/clients/{clientid}/consents/{consentid}/documents")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public void uploadDataFiles(@PathVariable("clientid") UUID clientid,
			@PathVariable("consentid") UUID consentid,
			@RequestParam("file")  MultipartFile multipartFile,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			Session session = sessionHelper.getSession(request);
			serviceFactory.getClientConsentService().saveConsentDocument(multipartFile, clientid,consentid,session.getAccount());
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consents/{consentid}/documents")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public Documents getConsentDocuments(@PathVariable("clientid") UUID clientid,
			@PathVariable("consentid") UUID consentid) throws Exception {
		return serviceFactory.getClientConsentService().getConsentDocuments(clientid,consentid);
	}
	

	@RequestMapping(method=RequestMethod.DELETE,value="/clients/{clientid}/consents/{consentid}/documents/{documentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public void deleteConsentDocument(@PathVariable("clientid") UUID clientid,
			@PathVariable("consentid") UUID consentid,
			@PathVariable("documentId") UUID documentId) throws Exception {
		 serviceFactory.getClientConsentService().deleteConsentDocument(clientid, consentid, documentId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/clients/{clientid}/consents/{consentid}/documents/{documentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="GET_CLIENT_CONSENTS")
	public void downloadtConsentDocuments(@PathVariable("clientid") UUID clientid,
			@PathVariable("consentid") UUID consentid,
			@PathVariable("documentId") UUID documentId,
			HttpServletResponse response) throws Exception {
		  InputStream inputStream = null;
		try {
		Document document = serviceFactory.getClientConsentService().downloadConsentDocument(clientid, consentid, documentId);
		
         inputStream = new BufferedInputStream(new FileInputStream(document.getFile()));

		
        FileCopyUtils.copy(inputStream, response.getOutputStream());
		}finally {
			if(inputStream!=null)
				inputStream.close();
		}
		
	}

	
	
}