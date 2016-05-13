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
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroups;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/projectgroups")
public class ProjectGroupController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="USR_CREATE_PROJECTGROUP",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroup createProjectGroup(@RequestBody ProjectGroup projectGroup,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getProjectGroupService().createProjectGroup(projectGroup, session.getAccount().getUsername());
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="USR_GET_ALL_PROJECTGROUP",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroups getAllProjectGroups(HttpServletRequest request,@RequestParam(value="startIndex", required=false) Integer startIndex,
				@RequestParam(value="maxItems", required=false) Integer maxItems) throws Exception {
		if (startIndex == null)	{
			startIndex = 0;
		}

		if (maxItems == null)	{
			maxItems = 30;
		}
		return serviceFactory.getProjectGroupService().getAllProjectGroups(startIndex, maxItems);
	}
	
	@RequestMapping(value="/{projectgroupid}",method=RequestMethod.PUT)
	@APIMapping(value="USR_UPDATE_PROJECTGROUP",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroup updateProjectGroup(@PathVariable("projectgroupid") UUID projectgroupid  ,@RequestBody ProjectGroup projectGroup,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getProjectGroupService().updateProjectGroup(projectgroupid,projectGroup, session.getAccount().getUsername());
	}
	
	@RequestMapping(value="/{projectgroupid}",method=RequestMethod.DELETE)
	@APIMapping(value="USR_DELTEE_PROJECTGROUP",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroup deleteProjectGroup(@PathVariable("projectgroupid") UUID projectgroupid  ,HttpServletRequest request) throws Exception {
		return serviceFactory.getProjectGroupService().deleteProjectGroup(projectgroupid);	
	}
	
	@RequestMapping(value="/{projectgroupid}",method=RequestMethod.GET)
	@APIMapping(value="USR_GET_PROJECTGROUP_ID",checkSessionToken=true, checkTrustedApp=true)
	public ProjectGroup getProjectGroupById(@PathVariable("projectgroupid") UUID projectgroupid  ,HttpServletRequest request) throws Exception {
		return serviceFactory.getProjectGroupService().getProjectGroupById(projectgroupid);	
	}

}