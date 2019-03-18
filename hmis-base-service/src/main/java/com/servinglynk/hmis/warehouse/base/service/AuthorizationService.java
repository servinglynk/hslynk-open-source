package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.OAuthAuthorization;
import com.servinglynk.hmis.warehouse.core.model.OAuthMessageGroup;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;

public interface AuthorizationService {
	
	
	public OAuthAuthorization requestAuthorization(String trustedAppId,
			   String redirectUri, 
			   String responseType, 
			   String accessType,
			   String approvalPrompt, 
			   String state, 
			   String consentToken,
			   boolean isConsented,
			   String authenticationToken, 
			   String caller);

	public List<OAuthMessageGroup> getConsentMessageForTrustedApp(String trustedAppId,
			String username, String authorizationService, boolean b);

	public void checkGrantTypeSupported(String grantType);

	public OAuthAuthorization authorizeWithRefreshToken(String refreshToken,
			String trustedAppId, String authorizationService);

	public void cleanAuthCode(String code, String trustedAppId,
			String authorizationService);

	public OAuthAuthorization authorizeWithAuthCode(String code,
			String redirectUri, String trustedAppId, String authorizationService);

	public void revokeAccessToken(String accessToken,
			String authorizationService);

	public void revokeRefreshToken(String refreshToken,
			String authorizationService);

	public void revokeConsentToken(String consentToken,
			String authorizationService);

	public OAuthAuthorization authorizeWithClientCredentials(TrustedApp trustedApp, String caller);

}
