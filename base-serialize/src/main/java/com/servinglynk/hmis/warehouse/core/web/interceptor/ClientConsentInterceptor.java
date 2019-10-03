package com.servinglynk.hmis.warehouse.core.web.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;

public class ClientConsentInterceptor  extends HandlerInterceptorAdapter {
	
	@Autowired
	private ApiAuthChecker apiAuthChecker;
	
	@Autowired
	private SessionHelper sessionHelper;

	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("inside client consent interceptor");
		
		Boolean flag = false;
		
		Session session = sessionHelper.getSession(request);
		
		Map<String,Object> pathVariables = (Map<String,Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		Map<String,Object> map = new HashMap<String,Object>();
		
		for(String key : pathVariables.keySet()) {
			map.put(key.toUpperCase(), pathVariables.get(key));
		}
		
		if(map.get("CLIENTID")==null) return true;
		
		flag = apiAuthChecker.checkApiAuthForConsent(session, UUID.fromString(map.get("CLIENTID").toString()));
		
		if(!flag) throw new AccessDeniedException("User does not have consent to acess the client information");
		
		
		return flag;
	}

}