package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/sessions")
public class SessionsController extends ControllerBase {

	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="USR_CREATE_SESSION",checkSessionToken=false, checkTrustedApp=false)
	public Session createSession(@RequestBody Session session, HttpServletRequest request) throws Exception {
		String trustedAppId = trustedAppHelper.retrieveTrustedAppId(request);
		
		
			 serviceFactory.getSessionService().createSession(session, trustedAppId, USER_SERVICE);
		 
		// return a session containing the token field to indicate the
		// successful creation.
		Session returnSession = new Session();
		returnSession.setToken(session.getToken());
		return returnSession;
	}
	

	@RequestMapping(value = "/{sessionToken}", method = RequestMethod.DELETE)
	@APIMapping(value="USR_END_SESSION",checkSessionToken=false, checkTrustedApp=true)
	public Session endSession(@PathVariable("sessionToken") String sessionToken, HttpServletRequest request) throws Exception {
		serviceFactory.getSessionService().endSession(sessionToken);
		Session returnSession = new Session();
		//returnSession.setToken(sessionToken);
		return returnSession;
	}
}
