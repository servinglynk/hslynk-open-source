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
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroup;
import com.servinglynk.hmis.warehouse.core.model.ProjectSubGroups;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/projectsubgroups")
public class ProjectSubGroupController extends ControllerBase {

	   @RequestMapping(method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public ProjectSubGroup createProjectSubGroup(@RequestBody ProjectSubGroup projectSubGroup,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getProjectSubGroupService().createProjectSubGroup(projectSubGroup, session.getAccount());
	}
	
	   @RequestMapping(method=RequestMethod.PUT,value="/{projectSubGroupId}")
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public void updateProjectSubGroup(@PathVariable("projectSubGroupId") UUID projectSubGroupId, @RequestBody ProjectSubGroup projectSubGroup,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		projectSubGroup.setProjectSubGroupId(projectSubGroupId);
		serviceFactory.getProjectSubGroupService().updateProjectSubGroup(projectSubGroup, session.getAccount());
	}
	
	   @RequestMapping(method=RequestMethod.DELETE,value="/{projectSubGroupId}")
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public void deleteProjectSubGroup(@PathVariable("projectSubGroupId") UUID projectSubGroupId,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getProjectSubGroupService().deleteProjectSubGroup(projectSubGroupId, session.getAccount());
	}
	
	
	   @RequestMapping(method=RequestMethod.GET,value="/{projectSubGroupId}")
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public ProjectSubGroup getProjectSubGroup(@PathVariable("projectSubGroupId") UUID projectSubGroupId,HttpServletRequest request) {
		return serviceFactory.getProjectSubGroupService().getProjectSubGroupById(projectSubGroupId);
	}
	
	
	   @RequestMapping(method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public ProjectSubGroups getProjectSubGroup(@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {
		return serviceFactory.getProjectSubGroupService().getProjectSubGroups(startIndex,maxItems);
	}
	
	   @RequestMapping(method=RequestMethod.PUT,value="/{projectSubGroupId}/projects/{projectId}")
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public void addProjectToProjectSubGroup(@PathVariable("projectSubGroupId") UUID projectSubGroupId,@PathVariable("projectId") UUID projectId,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getProjectSubGroupService().addProjectToProjectSubGroup(projectSubGroupId,projectId, session.getAccount());
	}
	
	   @RequestMapping(method=RequestMethod.DELETE,value="/{projectSubGroupId}/projects/{projectId}")
	   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
	public void deltetProjectToProjectSubGroup(@PathVariable("projectSubGroupId") UUID projectSubGroupId,@PathVariable("projectId") UUID projectId,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getProjectSubGroupService().deltetProjectToProjectSubGroup(projectSubGroupId,projectId, session.getAccount());
	}

	
}