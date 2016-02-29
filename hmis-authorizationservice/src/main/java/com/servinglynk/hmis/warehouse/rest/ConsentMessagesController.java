package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.OAuthMessageGroups;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/trustedapps")
public class ConsentMessagesController extends ControllerBase {

	
	@RequestMapping(value = "/{trustedappid}/consentmessages", method = RequestMethod.GET)
	@APIMapping(value="AUTH_GET_CONSENT_MESSAGES",checkSessionToken=true, checkTrustedApp=true)
	public OAuthMessageGroups getConsentMessages(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request)throws Exception{

		OAuthMessageGroups oAuthMessageGroups = new OAuthMessageGroups();
		Session session = sessionHelper.getSession(request);

		Account account = session.getAccount();
		oAuthMessageGroups.setoAuthMessageGroups(serviceFactory.getAuthorizationService().getConsentMessageForTrustedApp(trustedAppId,account.getUsername(), Constants.AUTHORIZATION_SERVICE, false));
		return oAuthMessageGroups;

	}
	
	
	
	@RequestMapping(value = "/{trustedappid}/detailedconsentmessages", method = RequestMethod.GET)
	@APIMapping(value="AUTH_GET_DETAILED_CONSENT_MESSAGES",checkSessionToken=true, checkTrustedApp=true)
	public OAuthMessageGroups getConsentDetailedMessages(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		Account account = session.getAccount();
		
		OAuthMessageGroups oAuthMessageGroups = new OAuthMessageGroups();
		oAuthMessageGroups.setoAuthMessageGroups(serviceFactory.getAuthorizationService().getConsentMessageForTrustedApp(trustedAppId,  account.getUsername(), Constants.AUTHORIZATION_SERVICE, true));
		return oAuthMessageGroups;
	}
	
	
	
	
}
