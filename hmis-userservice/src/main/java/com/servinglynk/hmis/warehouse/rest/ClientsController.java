package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;

@RestController
@RequestMapping("/clients")
public class ClientsController extends ControllerBase {
	
	@RequestMapping(value = "/{client_id}/basicinfo", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_BASIC_TRUSTEDAPP_INFO",checkSessionToken=false, checkTrustedApp=false)
	public TrustedApp getBasicClientInfo(HttpServletRequest request, 
								  		 HttpServletResponse response, 
								  		 @PathVariable(value="client_id") String trustedAppId) throws Exception {

			TrustedApp trustedApp = 
				serviceFactory.getTrustedAppService().getBasicTrustedAppInfo(trustedAppId, Constants.AUTHORIZATION_SERVICE);
		
		return trustedApp;
	}

	
	@RequestMapping(method=RequestMethod.GET)
	public void get(HttpServletRequest request) throws Exception {
		System.out.println("SYsts");
	}
}
