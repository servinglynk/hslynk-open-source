package com.servinglynk.hmis.household.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.client.authorizationservice.AuthorizationServiceClient;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;



public class ApiAuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private SessionHelper sessionHelper;
	
	@Autowired
	private TrustedAppHelper trustedAppHelper;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = null;
		handlerMethod = (HandlerMethod) handler;
		
		String accessToken = this.sessionHelper.retrieveSessionToken(request);
		String trustedApp = this.trustedAppHelper.retrieveTrustedAppId(request);

		APIMapping apiMapping = handlerMethod.getMethodAnnotation(APIMapping.class);
		if(apiMapping!=null) {
			ApiMethodAuthorizationCheck apiMethodAuthorizationCheck = new ApiMethodAuthorizationCheck();
			apiMethodAuthorizationCheck.setApiMethodId(apiMapping.value());
			apiMethodAuthorizationCheck.setAccessToken(accessToken);
			apiMethodAuthorizationCheck.setTrustedAppId(trustedApp);
			AuthorizationServiceClient client = new AuthorizationServiceClient();
			ApiMethodAuthorizationCheck clientresponse = client.checkApiAuthorization(apiMethodAuthorizationCheck);
		
			Session session = new Session();
			session.setToken(clientresponse.getAccessToken());
			this.sessionHelper.setSession(session, request);
			
			return true;
		}else{
			
			return false;
		}
	}

}
