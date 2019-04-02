package com.servinglynk.hmis.warehouse.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;

@RestController
@RequestMapping("/sharingrules")
public class SharingrulesController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public void createSharingRule(@RequestBody SharingRule sharingRule) {
		serviceFactory.getSharingRuleService().createSharingRule(sharingRule, "");
	}
}