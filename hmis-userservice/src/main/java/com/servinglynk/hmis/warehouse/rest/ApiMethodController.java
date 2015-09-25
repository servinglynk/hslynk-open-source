package com.servinglynk.hmis.warehouse.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;


@RestController
@RequestMapping("/apiMethod")
public class ApiMethodController extends ControllerBase {
	
	
	public void createApiGroup(){
		
	}
	
	
	@RequestMapping(value="/createMethod",method=RequestMethod.POST)
	@APIMapping(value="USR_CREATE_API_METHOD",checkSessionToken=true,checkTrustedApp=true)
	public ApiMethod createApiMethod(@RequestBody ApiMethod apiMethod) throws Exception {
		return serviceFactory.getApiMethodService().createApiMehod(apiMethod);
	}
	
	
	@RequestMapping(value="/{serviceId}/{apiMethodId}",method=RequestMethod.POST)
	@APIMapping(value="USR_MAP_SERVICE_APIMETHOD",checkSessionToken=true,checkTrustedApp=true)
	public void mapServiceWithApiMethod(@PathVariable("serviceId") String serviceId,@PathVariable("apiMethodId") String apiMethodId) throws Exception {
		serviceFactory.getApiMethodService().mapServiceWithApiMethod(serviceId, apiMethodId);
	}

}
