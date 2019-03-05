package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHold;
import com.servinglynk.hmis.warehouse.core.model.GlobalHouseHolds;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/global-households")
public class GlobalHouseholdsController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalHouseHold createGlobalHouseHold(@RequestBody GlobalHouseHold globalHouseHold,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getGlobalHouseHoldService().createGlobalHouseHold(globalHouseHold,session.getAccount());
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{globalHouseHoldId}")	
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void updateGlobalHouseHold(@PathVariable("globalHouseHoldId") UUID globalHouseHoldId,
			@RequestBody GlobalHouseHold globalHouseHold,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		globalHouseHold.setId(globalHouseHoldId);
		serviceFactory.getGlobalHouseHoldService().updateGlobalHouseHold(globalHouseHold,session.getAccount());	
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/{globalHouseHoldId}")	
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void deleteGlobalHousehold(@PathVariable() UUID globalHouseHoldId) {
		serviceFactory.getGlobalHouseHoldService().deleteGlobalHousehold(globalHouseHoldId);
	}

	@RequestMapping(method=RequestMethod.GET,value="/{globalHouseHoldId}")	
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalHouseHold getGlobalHousehold(@PathVariable("globalHouseHoldId") UUID globalHouseHoldId) {
		return serviceFactory.getGlobalHouseHoldService().getGlobalHouseHoldById(globalHouseHoldId);
	}
	
	@RequestMapping(method=RequestMethod.GET)	
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalHouseHolds getGLobalhouseholds(@RequestParam(value="start",required=false,defaultValue="0") Integer start,
					@RequestParam(value="maxItems",required=false,defaultValue="30") Integer maxItems) {	
		return serviceFactory.getGlobalHouseHoldService().getGlobalHouseHolds(start, maxItems);
	}

}
