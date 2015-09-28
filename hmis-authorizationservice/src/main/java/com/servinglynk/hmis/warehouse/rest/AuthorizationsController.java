package com.servinglynk.hmis.warehouse.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.OAuthAuthorization;
import com.servinglynk.hmis.warehouse.service.exception.UserAuthenticationFailedException;



@Controller
@RequestMapping("/authorize")
public class AuthorizationsController extends ControllerBase {

	@Autowired
	private String consentUri;
	
	@Autowired
	private String loginUri;
	
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value="AUTH_AUTHORIZE",checkSessionToken=false, checkTrustedApp=false)
	public void authorize(HttpServletRequest request, 
				          HttpServletResponse response, 
		                  @RequestParam(value="response_type", required=false) String responseType,
		                  @RequestParam(value="trustedApp_id", required=false) String trustedAppId,
		                  @RequestParam(value="redirect_uri", required=false) String redirectUri,
		                  @RequestParam(value="state", required=false) String state,
		                  @RequestParam(value="access_type", required=false) String accessType,
		                  @RequestParam(value="approval_prompt", required=false) String approvalPrompt,
		                  @RequestParam(value="consent_token", required=false) String consentToken,
		                  @RequestParam(value="consented", required=false) String consented) throws Exception {

		OAuthAuthorization authorization = null;
		int nextAction = -1;
		
		// extract authentication token
		String authenticationToken = extractAuthenticationToken(request);
		
		boolean isConsented = false;
		if ((consented != null) && consented.equals("true"))	{
			isConsented = true;
		}

		try	{
			// request authorization
			authorization = serviceFactory.getAuthorizationService().requestAuthorization(trustedAppId, 
																						  redirectUri, 
																						  responseType, 
																						  accessType, 
																						  approvalPrompt, 
																						  state,
																						  consentToken,
																						  isConsented,
																						  authenticationToken,
																						  Constants.AUTHORIZATION_SERVICE);
	
			nextAction = authorization.getNextAction();
		}
		catch(UserAuthenticationFailedException e)	{
			logger.error(null, e);
			nextAction = Constants.OAUTH_FLOW_LOGIN;
		}
		
		// effective redirect uri defaults redirect uri
		String effectiveRedirectUri = redirectUri;

		switch(nextAction)	{
			case Constants.OAUTH_FLOW_REQUEST_CONSENT :
				effectiveRedirectUri = this.consentUri + "?response_type="+responseType+"&trustedApp_id="+trustedAppId+"&redirect_uri="+urlEncode(redirectUri)+"&consent_token="+authorization.getConsentToken();
				effectiveRedirectUri += "&authentication_token="+authenticationToken;  // TEMPORARY OAUTH LOG OUT FIX
				break;
			
			case Constants.OAUTH_FLOW_REDIRECT_AUTH_CODE_TO_TRUSTEDAPP :
				//TODO  you can use redirect_uri param here directly instead of authorization.getRedirectUri()
				effectiveRedirectUri = authorization.getRedirectUri() + "?code=" + authorization.getAuthCode();
				break;

			case Constants.OAUTH_FLOW_REDIRECT_ACCESS_TOKEN_TO_TRUSTEDAPP :
				//TODO you can use redirect_uri param here directly instead of authorization.getRedirectUri()
				effectiveRedirectUri = authorization.getRedirectUri() + "#access_token=" + authorization.getAccessToken() + "&token_type=Bearer&expires_in=" + authorization.getExpiresIn();
				break;
		
			case Constants.OAUTH_FLOW_LOGIN :
				effectiveRedirectUri = loginUri + "?response_type="+responseType+"&trustedApp_id="+trustedAppId+"&redirect_uri="+urlEncode(redirectUri);
				break;
		}
		
		// Surya 05.26.2015 - below we are appending the optional parameters to the redirectUri if they were provided initially
		
		if (state != null)	{
			effectiveRedirectUri = effectiveRedirectUri + "&state=" + urlEncode(state);
			logger.debug("state is provided {}, append it to the redirect uri", state);
		}
		
		// append access_type if provided
		if (accessType != null)	{
			effectiveRedirectUri = effectiveRedirectUri + "&access_type=" + accessType;
			logger.debug("accessType is provided {}, append it to the redirect uri", accessType);
		}
		
		// append approval_prompt if provided
		if (approvalPrompt != null)	{
			effectiveRedirectUri = effectiveRedirectUri + "&approval_prompt=" + approvalPrompt;
			logger.debug("approvalPrompt is provided {}, append it to the redirect uri", approvalPrompt);
		}
		
		logger.debug("redirect uri: {}", effectiveRedirectUri);
		
		// send redirect
		response.sendRedirect(effectiveRedirectUri);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("abc#123", "UTF-8"));
	}
	
	private String urlEncode(String s)	{
		try {
			return URLEncoder.encode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			logger.debug(null, e);
		}
		
		return s;
	}
	

	private String extractAuthenticationToken(HttpServletRequest request)	{
			String authenticationToken = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.OAUTH_AUTHENTICATION_COOKIE)) {
					authenticationToken = cookie.getValue();
				}
			}
		}
		
		return authenticationToken;
		
	}
	
}
