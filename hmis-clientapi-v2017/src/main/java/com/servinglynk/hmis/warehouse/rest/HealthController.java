package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/health")
public class HealthController extends ControllerBase {

	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=false,checkTrustedApp=false)
	public void checkConnectionHealth(HttpServletRequest request , HttpServletResponse response) {
	  boolean flag =	serviceFactory.getHealthService().checkConnectionHealth();
	  if(flag){
		  response.setStatus(HttpServletResponse.SC_ACCEPTED);
	  }else{
		  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 
	  }
	}
	
}