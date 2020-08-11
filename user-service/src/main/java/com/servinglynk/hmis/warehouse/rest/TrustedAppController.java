package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroups;
import com.servinglynk.hmis.warehouse.core.model.TrustedApps;

@RestController
public class TrustedAppController extends ControllerBase {
	
	
	@RequestMapping(value = "/trustedapps/{trustedappid}/projectgroups",method = RequestMethod.PUT)
	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public void addProjectGroupToTrustedApp(@PathVariable("trustedappid") String trustedAppId, @RequestBody ProjectGroup projectGroup) {
		serviceFactory.getTrustedAppService().addProjectGroupToTrustedApp(trustedAppId, projectGroup);
	}
	
	
	@RequestMapping(value = "/trustedapps/{trustedappid}/projectgroups/{projectgroupid}",method = RequestMethod.DELETE)
	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public void deleteProjectGroupFromTrustedApp(@PathVariable("trustedappid") String trustedAppId,
			@PathVariable("projectgroupid") UUID projectgroupid) {
		serviceFactory.getTrustedAppService().deleteProjectGroupToTrustedApp(trustedAppId, projectgroupid);
	}
	
	
	@RequestMapping(value = "/trustedapps/{trustedappid}/projectgroups",method = RequestMethod.GET)
	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroups getTrustedAppProjectGroups(@PathVariable("trustedappid") String trustedAppId) {
		return serviceFactory.getTrustedAppService().getTrustedAppProjectGroups(trustedAppId);
	}
	
	
	@RequestMapping(value = "/trustedapps",method = RequestMethod.GET)
	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApps getTrustedApps() {
		return serviceFactory.getTrustedAppService().getTrustedApps();
	}

}
