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
import com.servinglynk.hmis.warehouse.core.model.GlobalProject;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectUsers;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjects;
import com.servinglynk.hmis.warehouse.core.model.GlobalProjectsMap;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping({"/global-projects","/globalprojects"})
public class GlobalProjectsController extends ControllerBase {
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalProject createGlobalProject(@RequestBody GlobalProject globalProject,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getGlobalProjectService().create(globalProject, session.getAccount());		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{globalProjectId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void updateGlobalProject(@PathVariable("globalProjectId") UUID globalProjectId,@RequestBody GlobalProject globalProject,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		globalProject.setId(globalProjectId);
		serviceFactory.getGlobalProjectService().update(globalProject, session.getAccount());
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/{globalProjectId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalProject getGlobalProjectById(@PathVariable("globalProjectId") UUID globalProjectId) throws Exception {
		return serviceFactory.getGlobalProjectService().getById(globalProjectId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalProjects getGlobalProjects(
			@RequestParam(value="startIndex",defaultValue="0",required=false) Integer start,
			@RequestParam(value="maxItems",defaultValue="200",required=false) Integer maxItems
			) throws Exception {
		return serviceFactory.getGlobalProjectService().getAllGlobalProjects(start, maxItems);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{globalProjectId}/projects")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void addProjectsToGlobalProject(@PathVariable("globalProjectId") UUID globalProjectId,
			@RequestBody GlobalProjectsMap globalProjectsMap,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getGlobalProjectService().addProjectsToGlobalProject(globalProjectId,globalProjectsMap,session.getAccount());
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{globalProjectId}/projects/{projectId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void removeProjectsFromGlobalProject(@PathVariable("globalProjectId") UUID globalProjectId,@PathVariable("projectId") UUID projectId) throws Exception {
		serviceFactory.getGlobalProjectService().removeProjectsFromGlobalProject(globalProjectId,projectId);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/{globalProjectId}/users")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void addUsersToGlobalProject(@PathVariable("globalProjectId") UUID globalProjectId,
			@RequestBody GlobalProjectUsers globalProjectUsers,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getGlobalProjectService().addUsersToGlobalProject(globalProjectId,globalProjectUsers,session.getAccount());
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{globalProjectId}/users/{userId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void removeUsersFromGlobalProject(@PathVariable("globalProjectId") UUID globalProjectId,@PathVariable("userId") UUID userId) throws Exception {
		serviceFactory.getGlobalProjectService().removeUserToGlobalProject(globalProjectId,userId);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/{globalProjectId}/users")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GlobalProjectUsers getGlobalProjectUsers(@PathVariable("globalProjectId") UUID globalProjectId,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getGlobalProjectService().getGlobalProjectUsers(globalProjectId);
	}
	
	

}
