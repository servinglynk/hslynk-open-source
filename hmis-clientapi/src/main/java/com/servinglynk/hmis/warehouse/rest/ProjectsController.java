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
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;

@RestController
@RequestMapping("/projects")
public class ProjectsController extends ControllerBase { 

   @RequestMapping(method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public Project createProject(@RequestBody Project project,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        return serviceFactory.getProjectService().createProject(project,session.getAccount().getOrganizationId(),session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public Project updateProject(@PathVariable( "projectid" ) UUID projectId,@RequestBody Project project,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        return serviceFactory.getProjectService().updateProject(project,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public Project deleteProject(@PathVariable( "projectid" ) UUID projectId,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        return serviceFactory.getProjectService().deleteProject(projectId,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_PROJECT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Project getProjectById(@PathVariable( "projectid" ) UUID projectId,HttpServletRequest request) throws Exception{
        return serviceFactory.getProjectService().getProjectById(projectId); 
   }

   @RequestMapping(method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_PROJECTS",checkTrustedApp=true,checkSessionToken=true)
   public Projects getAllProjects( @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
           Session session = sessionHelper.getSession(request);
        return serviceFactory.getProjectService().getAllProjects(session.getAccount().getOrganizationId(),startIndex,maxItems); 
   }

}

