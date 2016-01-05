package com.servinglynk.hmis.warehouse.service.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.web.interceptor.ApiAuthChecker;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;



public class LocalApiAuthChecker implements ApiAuthChecker	{
	
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ParentServiceFactory serviceFactory;
	
	private String requestor="WebInterceptor";
		
	public void setRequestor(String requestor)	{
		this.requestor = requestor;
	}


	@Override
	public ApiMethodAuthorizationCheck checkApiAuth(String trustedAppId, String accessToken, String apiMethodId, Boolean isSessionTokenCheckRequired) {
		
		ApiMethodAuthorizationCheck apiMethodAuthCheck = new ApiMethodAuthorizationCheck();
		apiMethodAuthCheck.setTrustedAppId(trustedAppId);
		apiMethodAuthCheck.setAccessToken(accessToken);
		apiMethodAuthCheck.setApiMethodId(apiMethodId);
		apiMethodAuthCheck.setCheckSessionToken(isSessionTokenCheckRequired);
		
		return serviceFactory.getTrustedAppService().checkApiAuthorization(apiMethodAuthCheck, this.requestor);
	}
	
	
	public boolean checkApiAuthForUser(String accessToken, String apiMethodId){
	return true;
//		return serviceFactory.getAccountService().checkApiAuthorizationForUser(accessToken, apiMethodId);
	}
	
	
	

}
