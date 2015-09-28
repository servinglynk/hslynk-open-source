package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;

@RestController
@RequestMapping("/sharingrules")
public class SharingRulesController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="ACL_CREATE_SHARING_RULE",checkTrustedApp=true,checkSessionToken=true)
	public SharingRules createSharingRule(@RequestBody SharingRule sharingRule,HttpServletRequest request) throws Exception{
		return serviceFactory.getSharingRuleService().createSharingRule(sharingRule,USER_SERVICE);
	}
	
	
	@RequestMapping(value="/{sharingRuleId}",method=RequestMethod.PUT)
	@APIMapping(value="ACL_UPDATE_SHARING_RULE",checkTrustedApp=true,checkSessionToken=true)
	public SharingRule updateShringRule(@PathVariable("sharingRuleId") UUID sharingRuleId, @RequestBody SharingRule sharingRule,HttpServletRequest request) throws Exception {
		return serviceFactory.getSharingRuleService().updateSharingRule(sharingRule,USER_SERVICE);
	}
	
	@RequestMapping(value="/{sharingRuleId}",method=RequestMethod.DELETE)
	@APIMapping(value="ACL_DELETE_SHARING_RULE",checkTrustedApp=true,checkSessionToken=true)
	public SharingRule deleteSharingRule(@PathVariable("sharingRuleId") UUID sharingRuleId, HttpServletRequest request) throws Exception {
		return serviceFactory.getSharingRuleService().deleteSharingRule(sharingRuleId,USER_SERVICE);
	}
}
