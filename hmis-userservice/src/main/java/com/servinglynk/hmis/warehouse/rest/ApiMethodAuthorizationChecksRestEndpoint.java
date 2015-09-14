package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;

@RestController
@RequestMapping("/apimethodauthcheck")
public class ApiMethodAuthorizationChecksRestEndpoint extends RestEndpointBase {

	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="USR_CHECK_API_AUTHORIZATION",checkSessionToken=false, checkTrustedApp=true)
	public ApiMethodAuthorizationCheck checkApiAuthorization(HttpServletRequest request, 
															 HttpServletResponse response,
															 @RequestBody ApiMethodAuthorizationCheck apiAuthCheck) throws Exception {
		
		apiAuthCheck = serviceFactory.getTrustedAppService().checkApiAuthorization(apiAuthCheck, Constants.USER_SERVICE);
		
		return apiAuthCheck;
	}
}
