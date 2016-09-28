package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/hmistypes")
public class HMISTypeController extends ControllerBase {

	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true)
	public void getHmisTypesByName(@PathVariable("name") String name,HttpServletRequest request) throws Exception {
		
	}
	
}
