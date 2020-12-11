package com.servinglynk.hmis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.client.authorizationservice.IAuthorizationClient;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.RestClientException;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;



public class ApiAuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private SessionHelper sessionHelper;
	
	@Autowired
	private TrustedAppHelper trustedAppHelper;
	
	@Autowired IAuthorizationClient client;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod handlerMethod = null;
		handlerMethod = (HandlerMethod) handler;
		JSONObjectMapper mapper = new JSONObjectMapper();
		String accessToken = this.sessionHelper.retrieveSessionToken(request);
		String trustedApp = this.trustedAppHelper.retrieveTrustedAppId(request);

		APIMapping apiMapping = handlerMethod.getMethodAnnotation(APIMapping.class);
		if(apiMapping!=null) {
			ApiMethodAuthorizationCheck apiMethodAuthorizationCheck = new ApiMethodAuthorizationCheck();
			apiMethodAuthorizationCheck.setApiMethodId(apiMapping.value());
			apiMethodAuthorizationCheck.setAccessToken(accessToken);
			apiMethodAuthorizationCheck.setTrustedAppId(trustedApp);
			//AuthorizationServiceClient client = new AuthorizationServiceClient();
			ApiMethodAuthorizationCheck clientresponse = null;
			try {
				 clientresponse = client.checkApiAuthorization(apiMethodAuthorizationCheck);
			}catch (HttpClientErrorException e) {
				Errors errors = mapper.readValue(e.getResponseBodyAsString(),Errors.class);
				throw new RestClientException(errors.getError().get(0).getMessage(), errors.getError().get(0).getCode(),e.getRawStatusCode());
			} catch (Exception e) {
				throw e;
			}
		
			Session session = new Session();
			session.setToken(clientresponse.getAccessToken());
			session.setAccount(clientresponse.getAccount());
			this.sessionHelper.setSession(session, request);
			SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(session, ""));
			return true;
		}else{
			
			return false;
		}
	}

}
