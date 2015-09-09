package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.OAuthRevokedToken;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
@RestController
@RequestMapping("/revoke")
public class RevocationsRestEndpoint extends RestEndpointBase {

	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="AUTH_REVOKE_TOKEN",checkSessionToken=false, checkTrustedApp=false)
	public OAuthRevokedToken revoke(HttpServletRequest request, 
								    HttpServletResponse response, 
						            @RequestParam(value="access_token", required=false) String[] accessTokens,
						            @RequestParam(value="refresh_token", required=false) String[] refreshTokens,
						            @RequestParam(value="consent_token", required=false) String[] consentTokens) throws Exception {

		String accessToken  = null;
		String consentToken = null;
		String refreshToken = null;
		
		// make sure there is only one access token provided
		if ((accessTokens != null) && accessTokens.length > 1)	{
			throw new InvalidParameterException("duplicate access tokens provided");
		}
		else	{
			if (accessTokens != null)	{
				accessToken = accessTokens[0];
			}
		}
		
		// make sure there is only one consent token provided
		if ((consentTokens != null) && consentTokens.length > 1)	{
			throw new InvalidParameterException("duplicate consent tokens provided");
		}
		else	{
			if (consentTokens != null)	{
				consentToken = consentTokens[0];
			}
		}
		
		// make sure there is only one refresh token provided
		if ((refreshTokens != null) && refreshTokens.length > 1)	{
			throw new InvalidParameterException("duplicate refresh tokens provided");
		}
		else	{
			if (refreshTokens != null)	{
				refreshToken = refreshTokens[0];
			}
		}
		
		// make sure there is at least one token provided
		if (ValidationUtil.isEmpty(accessToken) && 
			ValidationUtil.isEmpty(refreshToken) &&
			ValidationUtil.isEmpty(consentToken))	
		{
			throw new MissingParameterException("token is missing");
		}
		
		// make sure there is only one token provided
		if (!ValidationUtil.isEmpty(accessToken) && !ValidationUtil.isEmpty(refreshToken))	{
			throw new InvalidParameterException("specify only one token");
		}
		if (!ValidationUtil.isEmpty(accessToken) && !ValidationUtil.isEmpty(consentToken))	{
			throw new InvalidParameterException("specify only one token");
		}
		if (!ValidationUtil.isEmpty(refreshToken) && !ValidationUtil.isEmpty(consentToken))	{
			throw new InvalidParameterException("specify only one token");
		}

		OAuthRevokedToken revokedToken = new OAuthRevokedToken();

		if (accessToken != null)	{
			// access token is provided, so revoke access token
			getServiceFactory().getAuthorizationService().revokeAccessToken(accessToken, Constants.AUTHORIZATION_SERVICE);
			revokedToken.setAccessToken(accessToken);
		}
		else if (refreshToken != null)	{
			// refresh token is provided, so revoke refresh token
			getServiceFactory().getAuthorizationService().revokeRefreshToken(refreshToken, Constants.AUTHORIZATION_SERVICE);
			revokedToken.setRefreshToken(refreshToken);
		}
		else if (consentToken != null)	{
			// consent token is provided, so revoke consent token
			getServiceFactory().getAuthorizationService().revokeConsentToken(consentToken, Constants.AUTHORIZATION_SERVICE);			
			revokedToken.setConsentToken(consentToken);
		}

		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		
		return revokedToken;
	}
	
}
