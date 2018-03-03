package com.servinglynk.hmis.warehouse.base.service.core.security;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactory;
import com.servinglynk.hmis.warehouse.base.dao.PropertyDao;
import com.servinglynk.hmis.warehouse.base.dao.PropertyDaoImpl;
import com.servinglynk.hmis.warehouse.base.service.PropertyReaderService;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.web.interceptor.ApiAuthChecker;
import com.servinglynk.hmis.warehouse.model.base.PropertyEntity;



public class LocalApiAuthChecker implements ApiAuthChecker	{
	
	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private BaseServiceFactory serviceFactory;
	
	@Autowired
	PropertyDao propertyDao;
	
	
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
	
	
	public boolean checkApiAuthForUser(Session session, String apiMethodId,UUID clientId){
		boolean flag = serviceFactory.getAccountService().checkApiAuthorizationForUser(session.getAccount(), apiMethodId);
		if(flag) this.extendUserSession(session.getToken());
		return flag;
	}	
	
	@Transactional
	public boolean checkApiAuthForConsent(Session session,UUID clientId){
				PropertyEntity entity =	propertyDao.readConsentProperty();
				if(entity==null || entity.getValue().equalsIgnoreCase("false")) return true;
		boolean flag= serviceFactory.getAccountService().checkClientConsentAuthorizationForUser(session.getAccount(), clientId);
		return flag;
	}	
	public void extendUserSession(String accessToken){
		serviceFactory.getAccountService().extendUserSession(accessToken);
	}
}