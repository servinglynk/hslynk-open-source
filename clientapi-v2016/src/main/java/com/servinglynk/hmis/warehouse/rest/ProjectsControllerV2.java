package com.servinglynk.hmis.warehouse.rest; 

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/v2/projects")
public class ProjectsControllerV2 extends ControllerBase { 


   @RequestMapping(value="/{projectid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_PROJECT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Project getProjectById(@PathVariable( "projectid" ) UUID projectId,HttpServletRequest request) throws Exception{
        return serviceFactory.getProjectServiceV2().getProjectById(projectId); 
   }

   @RequestMapping(method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_PROJECTS",checkTrustedApp=true,checkSessionToken=true)
   public Projects getAllProjects( @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
           Session session = sessionHelper.getSession(request);
           Account account = serviceFactory.getAccountService().getAccount(session.getAccount(),false);
           return serviceFactory.getProjectServiceV2().getAllProjects(account.getProjectGroup().getProjectGroupCode(),startIndex,maxItems);
   }

   
}