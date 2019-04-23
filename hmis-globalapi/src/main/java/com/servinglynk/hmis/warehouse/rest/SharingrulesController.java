package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;

@RestController
@RequestMapping("/sharingrules")
public class SharingrulesController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public SharingRule createSharingRule(@RequestBody SharingRule sharingRule) {
		sharingRule = serviceFactory.getSharingRuleService().createSharingRule(sharingRule);
		SharingRule returnSharingRule = new SharingRule();
		returnSharingRule.setSharingRuleId(sharingRule.getSharingRuleId());
		return returnSharingRule;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{sharingRuleId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public void updateSharingRule(@RequestBody SharingRule sharingRule,@PathVariable("sharingRuleId") UUID sharingRuleId) {
		sharingRule.setSharingRuleId(sharingRuleId);
		serviceFactory.getSharingRuleService().updateSharingRule(sharingRule);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{sharingRuleId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public void deleteSharingRule(@PathVariable("sharingRuleId") UUID sharingRuleId) {
		serviceFactory.getSharingRuleService().deleteSharingRule(sharingRuleId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{sharingRuleId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public SharingRule getSharingRuleById(@PathVariable("sharingRuleId") UUID sharingRuleId) {
		return serviceFactory.getSharingRuleService().getSharingRuleById(sharingRuleId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public SharingRules getAllSharingRules(			@RequestParam(value="startIndex",defaultValue="0",required=false) Integer start,
			@RequestParam(value="maxItems",defaultValue="200",required=false) Integer maxItems) {
		return serviceFactory.getSharingRuleService().getAllSharingRules(start,maxItems);
	}
}