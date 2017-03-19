package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;

@RestController
@RequestMapping("/apimethodauthcheck")
public class ApiMethodAuthorizationChecksController extends ControllerBase {

	@RequestMapping(method = RequestMethod.GET,value="/{apimethodid}")
	@APIMapping(value="USR_CHECK_API_AUTHORIZATION",checkSessionToken=false, checkTrustedApp=true)
	public ApiMethodAuthorizationCheck checkApiAuthorization(@PathVariable("apimethodid") String apimethodid,
															HttpServletRequest request, 
															 HttpServletResponse response
															 ) throws Exception {
		
		ApiMethod apiMethod = serviceFactory.getApiMethodService().getApiMethod(apimethodid);
		
		ApiMethodAuthorizationCheck apiAuthCheck= new ApiMethodAuthorizationCheck();
		String sessiontoken=this.sessionHelper.retrieveSessionToken(request);
		apiAuthCheck.setAccessToken(sessiontoken);
		apiAuthCheck.setTrustedAppId(this.trustedAppHelper.retrieveTrustedAppId(request));
		apiAuthCheck.setApiMethodId(apimethodid);
		apiAuthCheck.setCheckSessionToken(apiMethod.getRequiresAccessToken());
		if(apiMethod.getRequiresCheckTrustedApp()!=null & apiMethod.getRequiresCheckTrustedApp()){
			apiAuthCheck = serviceFactory.getTrustedAppService().checkApiAuthorization(apiAuthCheck, Constants.USER_SERVICE);
		}
		serviceFactory.getAccountService().checkApiAuthorizationForUser(apiAuthCheck.getAccount(), apimethodid);
		//apiAuthCheck.setAccount(account);
		return apiAuthCheck;
	}
}
