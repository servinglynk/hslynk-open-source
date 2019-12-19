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
import com.servinglynk.hmis.warehouse.core.model.HmisHousehold;
import com.servinglynk.hmis.warehouse.core.model.HmisHouseholds;
import com.servinglynk.hmis.warehouse.core.model.HouseHoldMember;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/hmishouseholds")
public class HmisHouseHoldController extends ControllerBase {

	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_HOUSEHOLD",checkSessionToken=true,checkTrustedApp=true)
	public HmisHousehold createHouseHold(@RequestBody HmisHousehold model,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		model = serviceFactory.getHmisHouseHoldService().createHouseHold(model, session.getAccount().getUsername());
		HmisHousehold returnHmisHousehold = new HmisHousehold();
		returnHmisHousehold.setHouseHoldId(model.getHouseHoldId());
		return returnHmisHousehold;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{householdid}")
	@APIMapping(value="CLIENT_API_UPDATE_HOUSEHOLD",checkSessionToken=true,checkTrustedApp=true)
	public void updateHouseHold(@PathVariable("householdid") UUID householdId,@RequestBody HmisHousehold model,HttpServletRequest request){
		model.setHouseHoldId(householdId);
		Session session = sessionHelper.getSession(request);
		serviceFactory.getHmisHouseHoldService().updateHouseHold(model, session.getAccount().getUsername());

	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{householdid}")
	@APIMapping(value="CLIENT_API_DELETE_HOUSEHOLD",checkSessionToken=true,checkTrustedApp=true)
	public void deleteHouseHold(@PathVariable("householdid") UUID householdId){
		serviceFactory.getHmisHouseHoldService().deleteHouseHold(householdId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{householdid}")
	@APIMapping(value="CLIENT_API_GET_HOUSEHOLD",checkSessionToken=true,checkTrustedApp=true)
	public HmisHousehold getHouseHoldById(@PathVariable("householdid") UUID householdId){
		return serviceFactory.getHmisHouseHoldService().getHouseHoldById(householdId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_HOUSEHOLDS",checkSessionToken=true,checkTrustedApp=true)
	public HmisHouseholds getAllHouseHolds(
			@RequestParam(value="startIndex", required=false) Integer startIndex,
			@RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {

		 if (startIndex == null) startIndex =0;
        if (maxItems == null) maxItems =30;

		return serviceFactory.getHmisHouseHoldService().getAllHouseHolds(startIndex, maxItems);
	}
	
	public void addHouseHoldMember(@PathVariable("householdid") UUID householdId,@RequestBody HouseHoldMember member,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		member.setHouseHoldId(householdId);
		serviceFactory.getHmisHouseHoldService().addHouseHoldMember(member,session.getAccount().getUsername());
	}
	
	public void removeHouseHoldMember(@PathVariable("householdid") UUID householdId,@PathVariable("memberid") UUID memberid,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getHmisHouseHoldService().removeHouseHoldMember(householdId,memberid,session.getAccount().getUsername());
	}
	
	
}