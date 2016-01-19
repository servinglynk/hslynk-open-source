package com.servinglynk.hmis.warehouse.rest;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.OAuthAuthorization;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.service.exception.AuthCodeAlreadyUsedException;

@RestController
@RequestMapping("/token")
public class TokensController extends ControllerBase {

	

	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="AUTH_AUTHORIZE_TOKEN",checkSessionToken=false, checkTrustedApp=false)
	public OAuthAuthorization authorize(HttpServletRequest request, 
					        HttpServletResponse response, 
			                @RequestParam(value="grant_type", required=false) String grantType,
			                @RequestParam(value="code", required=false) String code,
			                @RequestParam(value="redirect_uri", required=false) String redirectUri,
			                @RequestParam(value="refresh_token", required=false) String refreshToken) throws Exception {
		
		if (ValidationUtil.isEmpty(grantType))	{
			throw new MissingParameterException("grant type is missing");
		}
		
		// checkGrantTypeSupported(grantType);
		
		TrustedApp trustedApp = authenticateTrustedApp(sessionHelper.retrieveSessionToken(request));
		
		OAuthAuthorization authorization = null;
		
		if (grantType.equals(Constants.OAUTH_AUTHORIZATION_CODE))	{
			
			// check if auth code is provided
			if (ValidationUtil.isEmpty(code))	{
				throw new MissingParameterException("authorization code is missing");
			}

			if (ValidationUtil.isEmpty(redirectUri))	{
				throw new MissingParameterException("redirect uri is missing");
			}
			
			//if (!ValidationUtil.isUriValid(redirectUri))	{
			//	throw new InvalidParameterException("redirect uri is invalid");
			//}
			
			try	{
				authorization = serviceFactory.getAuthorizationService().authorizeWithAuthCode(code, redirectUri, trustedApp.getTrustedAppId(), Constants.AUTHORIZATION_SERVICE);
			}
			catch(AuthCodeAlreadyUsedException e)	{
				// auth code is reused do a clean up (need to do here as it needs to be done in a separate transaction)
				serviceFactory.getAuthorizationService().cleanAuthCode(code, trustedApp.getTrustedAppId(), Constants.AUTHORIZATION_SERVICE);
				throw e;
			}
		}
		else if (grantType.equals(Constants.OAUTH_REFRESH_TOKEN))	{
			
			// check if refresh token is provided
			if (ValidationUtil.isEmpty(refreshToken))	{
				throw new InvalidParameterException("refresh token is missing");
			}
			
			authorization = serviceFactory.getAuthorizationService().authorizeWithRefreshToken(refreshToken, trustedApp.getTrustedAppId(), Constants.AUTHORIZATION_SERVICE);
		}
		
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		
		return authorization;
	}
	
	private void checkGrantTypeSupported(String grantType)	{
		serviceFactory.getAuthorizationService().checkGrantTypeSupported(grantType);
	}
	
	private TrustedApp authenticateTrustedApp(String authorizationHeaderValue)	{
		if (authorizationHeaderValue == null)	{
			throw new InvalidTrustedAppException("invalid TrustedApp");
		}
		
		String authorization = authorizationHeaderValue.replaceFirst(Constants.BASIC_AUTH_REALM, "").trim();
		String usernamePassword = null;
		String trustedAppId = null;
		String trustedAppSecret = null;
		
		try {
			usernamePassword = new String(Base64.decodeBase64(authorization.getBytes("UTF-8")));
		//	usernamePassword = authorization;
			String[] usernamePasswordPair = usernamePassword.split(":");
		
			if (usernamePasswordPair.length != 2)	{
				throw new InvalidTrustedAppException("invalid TrustedApp");
			}
		
			trustedAppId = usernamePasswordPair[0];
			trustedAppSecret = usernamePasswordPair[1];
		} 
		catch (UnsupportedEncodingException e) {
			throw new InvalidTrustedAppException("invalid TrustedApp", e);
		}
		
		return serviceFactory.getTrustedAppService().authenticateTrustedAppId(trustedAppId, trustedAppSecret);
	}
		
}
