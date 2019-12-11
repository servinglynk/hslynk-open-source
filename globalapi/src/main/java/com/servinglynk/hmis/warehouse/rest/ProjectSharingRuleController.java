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
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRule;
import com.servinglynk.hmis.warehouse.core.model.ProjectSharingRules;

@RequestMapping("/projectSharingRules")
@RestController
public class ProjectSharingRuleController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	public ProjectSharingRule createSharingRule(@RequestBody ProjectSharingRule projectSharingRule,HttpServletRequest request) {
		Account caller = sessionHelper.getSession(request).getAccount();
		return serviceFactory.getProjectSharingRuleService().createSharingRule(projectSharingRule, caller);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{sharingruleid}")
	@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	public void deleteSharingRule(@PathVariable("sharingruleid") UUID sharingruleid,HttpServletRequest request) {
		Account caller = sessionHelper.getSession(request).getAccount();
		 serviceFactory.getProjectSharingRuleService().deleteSharingRule(sharingruleid, caller);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{sharingruleid}")
	@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	public ProjectSharingRule getSharingRuleById(@PathVariable("sharingruleid") UUID sharingruleid,HttpServletRequest request) {
		return serviceFactory.getProjectSharingRuleService().getSharingRule(sharingruleid);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	public ProjectSharingRules getSharingRules(@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {
		return serviceFactory.getProjectSharingRuleService().getSharingRules(startIndex,maxItems);
	}
}
