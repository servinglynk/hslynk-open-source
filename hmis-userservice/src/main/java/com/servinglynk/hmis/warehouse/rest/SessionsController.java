package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.hbase.generated.thrift.thrift_jsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountPendingException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidAccountCredentialsException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidOnetimePasswordException;
import com.servinglynk.hmis.warehouse.service.exception.SessionNotFoundException;


@RestController
@RequestMapping("/sessions")
public class SessionsController {
	
	@Autowired
	public SessionHelper sessionHelper;
	
	@Autowired
	protected TrustedAppHelper trustedAppHelper;
	
	@Autowired
	protected ParentServiceFactory serviceFactory;


	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="USR_CREATE_SESSION",checkSessionToken=false, checkTrustedApp=false)
	public Session createSession(@RequestParam(value="username" , required=true) String username,
								 @RequestParam(value="password",  required=true) String password, 
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		String trustedAppId = trustedAppHelper.retrieveTrustedAppId(request);
		
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		Session session= new Session();
		session.setAccount(account);
		
		 serviceFactory.getSessionService().validateUserCredentials(session, trustedAppId, USER_SERVICE);
		 
		 if(session.getNextAction() == Constants.TWO_FACTOR_AUTH_FLOW_OPT){
			 response.sendRedirect("/hmis-user-service/twofactorauth.html?authKey="+session.getAuthCode());
		 }
		// return a session containing the token field to indicate the
		// successful creation.
		Session returnSession = new Session();
		returnSession.setToken(session.getToken());
		return returnSession;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/authorize")
	@APIMapping(value="USR_VALIDATE_OTP",checkSessionToken=false, checkTrustedApp=false)
	public Session validateOtp(@RequestParam(value="authKey", required=true) String authKey,
							@RequestParam(value="otp", required=true) String otp,
							HttpServletRequest request
							) throws Exception {
		Session session = new Session();
		session.setAuthCode(authKey);
		Account account = new Account();
		account.setOtp(otp);
		session.setAccount(account);
		
		
		serviceFactory.getSessionService().createSession(session, USER_SERVICE);
		
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
	
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value="USR_END_SESSION",checkSessionToken=false, checkTrustedApp=true)
	public Session validateSession(HttpServletRequest request) throws Exception {
		
		String sessionToken = sessionHelper.retrieveSessionToken(request);
		if(sessionToken == null) throw new SessionNotFoundException();
		Session session = serviceFactory.getSessionService().validateSession(sessionToken);
		return session;
	}
	
	@ExceptionHandler(Throwable.class)
	private Errors handleException(Throwable t, HttpServletRequest request, HttpServletResponse response) {
		
		Errors errors = new Errors();
		String uri = "/hmis-user-service";
		
		try{
			throw t;
		}catch(InvalidTrustedAppException e){
			uri  += "/login.html?error="+e.getMessage();
		} catch (MissingParameterException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (InvalidParameterException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (AccountNotFoundException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (InvalidAccountCredentialsException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (AccountDisabledException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (AccountPendingException e) {
			uri += "/login.html?error="+e.getMessage();			
		} catch (InvalidOnetimePasswordException e) {
			uri += "/twofactorauth.html?authKey="+request.getParameter("authKey")+"&error="+e.getMessage();			
		} catch (InvalidSessionTokenException e) {
			uri += "/login.html?error="+e.getMessage();
		}catch (SessionNotFoundException e) {
				Error error = new Error();
				error.setMessage(e.getMessage());
				error.setCode("SESSION_NOT_FOUND");;
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				errors.addError(error);
				return errors;
		}
		catch (Throwable e) {

			e.printStackTrace();
		}
		
		try {
			response.sendRedirect(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return errors;
	}
}
