package com.servinglynk.hmis.warehouse.core.web.interceptor;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;


public class ApiAuthCheckInterceptor extends HandlerInterceptorAdapter /*implements HandlerInterceptor*/	{

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SessionHelper sessionHelper;
	
	@Autowired
	private TrustedAppHelper trustedAppHelper;
	
	@Autowired
	private ApiAuthChecker apiAuthChecker;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if (logger.isDebugEnabled()){
			logger.debug("preHandle() START!");
		}
		
		System.out.println("preHandle() START!");
		
		String trustedAppId = this.trustedAppHelper.retrieveTrustedAppId(request);
		String accessToken = this.sessionHelper.retrieveSessionToken(request);
		HandlerMethod handlerMethod = null;
		
		
		Boolean  isTrustedAppCheckRequried =null;
		Boolean isSessionTokenCheckRequired = null;
		String apiMethodId=null;
		

			// extract method name from handler and map it to an ApiMethod
			handlerMethod = (HandlerMethod) handler;
			String methodName = handlerMethod.getMethod().getName();
			APIMapping apiMapping = handlerMethod.getMethodAnnotation(APIMapping.class);

			if(apiMapping!=null) {
					apiMethodId  = apiMapping.value();
					isSessionTokenCheckRequired = apiMapping.checkSessionToken();
					isTrustedAppCheckRequried = apiMapping.checkTrustedApp();
			}
			// still no api method then fall back to method name
			if(ValidationUtil.isEmpty(apiMethodId))	apiMethodId = methodName;

			
		if (logger.isDebugEnabled() || logger.isInfoEnabled()){
			logger.debug("preHandle() trustedAppId["+trustedAppId+"], accessToke["+accessToken+"], apiMethodId["+apiMethodId+"], isTrustedAppCheckRequried["+isTrustedAppCheckRequried+"], isTrustedAppCheckRequried["+isTrustedAppCheckRequried+"]");
		}
	
		//if TrustedApp check is not required , don't do anything. return true;
		if(isTrustedAppCheckRequried!=null && !isTrustedAppCheckRequried){
			return true;
		}

		ApiMethodAuthorizationCheck apiAuthCheck = this.apiAuthChecker.checkApiAuth(trustedAppId, accessToken, apiMethodId, isSessionTokenCheckRequired);

		this.trustedAppHelper.setTrustedApp(apiAuthCheck.getTrustedApp(), request);

		Session session = new Session();
		session.setToken(apiAuthCheck.getAccessToken());
		session.setAccount(apiAuthCheck.getAccount());
		session.setClientTypeId(apiAuthCheck.getTrustedApp().getTrustedAppId());
		this.sessionHelper.setSession(session, request);

		Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		UUID clientId = null;
		
		if(pathVariables.get("clientid")!=null)
			clientId = UUID.fromString(pathVariables.get("clientid")+"");

		// Checking client consent permissions
		// Check User Having Permission
		if(isSessionTokenCheckRequired){
			boolean flag = this.apiAuthChecker.checkApiAuthForUser(session, apiMethodId,clientId);
			if(!flag) throw new AccessDeniedException();
			return flag;
		}
		else
			return true;
	}

		
	public static void main(String[] args){
		String headerValue="HMISUserAuth session_token=CD721B0A6C03483AA0ADD36E1BADA6B83FEEB4483442462F93B5D8F92FE6CAF2";
		String sessionToken=null;
		String authRealm="HMISUserAuth";
		String oAuthRealm="Bearer";
				
		
		String[] split = headerValue.split("[\\s|=|\"]+");
		if (split != null)	{
			if ((split.length >= 3) && split[0].equalsIgnoreCase(authRealm))	{
				sessionToken = split[2];
			}
			else if ((split.length >= 2) && split[0].equalsIgnoreCase(oAuthRealm))	{
				sessionToken = split[1];
			}
			
		}
		
		System.out.println(sessionToken);
	}
}
