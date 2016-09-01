package com.servinglynk.hmis.warehouse.client.authorizationservice;

import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;





public interface IAuthorizationClient {

	public ApiMethodAuthorizationCheck checkApiAuthorization(ApiMethodAuthorizationCheck authCheck) throws Exception;
	
	
}
