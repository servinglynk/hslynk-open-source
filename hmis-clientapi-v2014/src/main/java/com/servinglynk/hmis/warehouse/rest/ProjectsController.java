package com.servinglynk.hmis.warehouse.rest; 

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Affiliation;
import com.servinglynk.hmis.warehouse.core.model.Affiliations;
import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.core.model.Funders;
import com.servinglynk.hmis.warehouse.core.model.Inventories;
import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.Projectcocs;
import com.servinglynk.hmis.warehouse.core.model.Projects;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Site;
import com.servinglynk.hmis.warehouse.core.model.Sites;

@RestController
@RequestMapping("/projects")
public class ProjectsController extends ControllerBase { 

   @RequestMapping(method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public Project createProject(@RequestBody Project project,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().createProject(project,session.getAccount().getOrganizationId(),session.getAccount().getUsername()); 
        Project returnProject = new Project();
        returnProject.setProjectId(project.getProjectId());
        return returnProject;
   }

   @RequestMapping(value="/{projectid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public void updateProject(@PathVariable( "projectid" ) UUID projectId,@RequestBody Project project,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        project.setProjectId(projectId);
        serviceFactory.getProjectService().updateProject(project,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_PROJECT",checkTrustedApp=true,checkSessionToken=true)
   public void deleteProject(@PathVariable( "projectid" ) UUID projectId,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().deleteProject(projectId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
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
           ProjectGroup projectGroup = session.getAccount().getProjectGroup();
        return serviceFactory.getProjectService().getAllProjects(projectGroup.getProjectGroupCode(),startIndex,maxItems); 
   }

   // ProjectCOC API start
   
   @RequestMapping(value="/{projectid}/projectcocs",method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_PROJECTCOC",checkTrustedApp=true,checkSessionToken=true)
   public Projectcoc createProjectcoc(@PathVariable("projectid") UUID projectId ,@RequestBody Projectcoc projectcoc,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectcocService().createProjectcoc(projectcoc,projectId,session.getAccount().getUsername()); 
        Projectcoc returnProjectcoc = new Projectcoc();
        returnProjectcoc.setProjectcocId(projectcoc.getProjectcocId());
        return returnProjectcoc;
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_PROJECTCOC",checkTrustedApp=true,checkSessionToken=true)
   public void updateProjectcoc(@PathVariable("projectid") UUID projectId ,@PathVariable( "projectcocid" ) UUID projectcocId,@RequestBody Projectcoc projectcoc,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        projectcoc.setProjectcocId(projectcocId);
        serviceFactory.getProjectcocService().updateProjectcoc(projectcoc,projectId,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_PROJECTCOC",checkTrustedApp=true,checkSessionToken=true)
   public void deleteProjectcoc(@PathVariable("projectid") UUID projectId ,@PathVariable( "projectcocid" ) UUID projectcocId,
		   HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 

        serviceFactory.getProjectService().getProjectById(projectId);
        serviceFactory.getProjectcocService().deleteProjectcoc(projectcocId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_PROJECTCOC_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Projectcoc getProjectcocById(@PathVariable("projectid") UUID projectId ,@PathVariable( "projectcocid" ) UUID projectcocId,HttpServletRequest request) throws Exception{
	   			serviceFactory.getProjectService().getProjectById(projectId);
        return serviceFactory.getProjectcocService().getProjectcocById(projectcocId); 
   }

   @RequestMapping(value="/{projectid}/projectcocs",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_PROJECT_PROJECTCOC",checkTrustedApp=true,checkSessionToken=true)
   public Projectcocs getAllEnrollmentProjectcocs( @PathVariable("projectid") UUID projectId ,
                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
 
           	serviceFactory.getProjectService().getProjectById(projectId);
        return serviceFactory.getProjectcocService().getAllProjectProjectcocs(projectId,startIndex,maxItems); 
   }
   
   
   // Affiliation API start
   
   @RequestMapping(value="/{projectid}/affiliations",method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_AFFILIATION",checkTrustedApp=true,checkSessionToken=true)
   public Affiliation createAffiliation(@PathVariable("projectid") UUID projectId ,@RequestBody Affiliation affiliation,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 

        serviceFactory.getAffiliationService().createAffiliation(affiliation,projectId,session.getAccount().getUsername()); 
        Affiliation returnAffiliation = new Affiliation();
        returnAffiliation.setAffiliationId(affiliation.getAffiliationId());
        return returnAffiliation;
   }

   @RequestMapping(value="/{projectid}/affiliations/{affiliationid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_AFFILIATION",checkTrustedApp=true,checkSessionToken=true)
   public void updateAffiliation(@PathVariable("projectid") UUID projectId  ,@PathVariable( "affiliationid" ) UUID affiliationId,@RequestBody Affiliation affiliation,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        affiliation.setAffiliationId(affiliationId);
        serviceFactory.getAffiliationService().updateAffiliation(affiliation,projectId,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}/affiliations/{affiliationid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_AFFILIATION",checkTrustedApp=true,checkSessionToken=true)
   public void deleteAffiliation(@PathVariable("projectid") UUID projectId ,@PathVariable( "affiliationid" ) UUID affiliationId,
		   HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().getProjectById(projectId);
        serviceFactory.getAffiliationService().deleteAffiliation(affiliationId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
   }

   @RequestMapping(value="/{projectid}/affiliations/{affiliationid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_AFFILIATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Affiliation getAffiliationById(@PathVariable("projectid") UUID projectId  ,@PathVariable( "affiliationid" ) UUID affiliationId,HttpServletRequest request) throws Exception{
	           serviceFactory.getProjectService().getProjectById(projectId);  
        return serviceFactory.getAffiliationService().getAffiliationById(affiliationId); 
   }

   @RequestMapping(value="/{projectid}/affiliations",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_AFFILIATION",checkTrustedApp=true,checkSessionToken=true)
   public Affiliations getAllEnrollmentAffiliations(@PathVariable("projectid") UUID projectId ,
                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
 
           	   serviceFactory.getProjectService().getProjectById(projectId);
        return serviceFactory.getAffiliationService().getAllProjectAffiliations(projectId,startIndex,maxItems); 
   }
   
   
   // Funder API start
   
   
   @RequestMapping(value="/{projectid}//funders",method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_FUNDER",checkTrustedApp=true,checkSessionToken=true)
   public Funder createFunder(@PathVariable("projectid") UUID projectId ,@RequestBody Funder funder,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 

        serviceFactory.getFunderService().createFunder(funder,projectId,session.getAccount().getUsername()); 
        Funder returnFunder = new Funder();
        returnFunder.setFunderId(funder.getFunderId());
        return returnFunder;
   }

   @RequestMapping(value="/{projectid}/funders/{funderid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_FUNDER",checkTrustedApp=true,checkSessionToken=true)
   public void updateFunder(@PathVariable("projectid") UUID projectId ,@PathVariable( "funderid" ) UUID funderId,@RequestBody Funder funder,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        funder.setFunderId(funderId);
         serviceFactory.getFunderService().updateFunder(funder,projectId,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}//funders/{funderid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_FUNDER",checkTrustedApp=true,checkSessionToken=true)
   public void deleteFunder(@PathVariable("projectid") UUID projectId ,@PathVariable( "funderid" ) UUID funderId,
		   HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 
    	serviceFactory.getProjectService().getProjectById(projectId);
        serviceFactory.getFunderService().deleteFunder(funderId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
   }

   @RequestMapping(value="/{projectid}/funders/{funderid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_FUNDER_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Funder getFunderById(@PathVariable("projectid") UUID projectId ,@PathVariable( "funderid" ) UUID funderId,HttpServletRequest request) throws Exception{
   	   serviceFactory.getProjectService().getProjectById(projectId);
        return serviceFactory.getFunderService().getFunderById(funderId); 
   }

   @RequestMapping(value="/{projectid}/funders",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_FUNDER",checkTrustedApp=true,checkSessionToken=true)
   public Funders getAllEnrollmentFunders(@PathVariable("projectid") UUID projectId ,
                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
 
       	   serviceFactory.getProjectService().getProjectById(projectId);
        return serviceFactory.getFunderService().getAllProjectFunders(projectId,startIndex,maxItems); 
   }
   
   // Sites API start
   
   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/sites",method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_SITE",checkTrustedApp=true,checkSessionToken=true)
   public Site createSite(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@RequestBody Site site,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().getProjectById(projectid);

        serviceFactory.getSiteService().createSite(site,projectcocid,session.getAccount().getUsername()); 
        Site returnSite = new Site();
        returnSite.setSiteId(site.getSiteId());
        return returnSite;
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/sites/{siteid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_SITE",checkTrustedApp=true,checkSessionToken=true)
   public void updateSite(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@PathVariable( "siteid" ) UUID siteId,@RequestBody Site site,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        site.setSiteId(siteId);
        serviceFactory.getProjectService().getProjectById(projectid);
        serviceFactory.getSiteService().updateSite(site,projectcocid,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/sites/{siteid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_SITE",checkTrustedApp=true,checkSessionToken=true)
   public void deleteSite(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid,
		   @PathVariable( "siteid" ) UUID siteId,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().getProjectById(projectid);
        serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        serviceFactory.getSiteService().deleteSite(siteId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/sites/{siteid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_SITE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Site getSiteById(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@PathVariable( "siteid" ) UUID siteId,HttpServletRequest request) throws Exception{
       serviceFactory.getProjectService().getProjectById(projectid);
       serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        return serviceFactory.getSiteService().getSiteById(siteId); 
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/sites",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_PROJECTCOC_SITE",checkTrustedApp=true,checkSessionToken=true)
   public Sites getAllEnrollmentSites(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,
                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
 
         serviceFactory.getProjectService().getProjectById(projectid);
         serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        return serviceFactory.getSiteService().getAllProjectCocSites(projectcocid,startIndex,maxItems); 
   }
   
   
   // Inventory API start
   
   
   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/inventories",method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_INVENTORY",checkTrustedApp=true,checkSessionToken=true)
   public Inventory createInventory(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@RequestBody Inventory inventory,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().getProjectById(projectid);

        serviceFactory.getInventoryService().createInventory(inventory,projectcocid,session.getAccount().getUsername()); 
        Inventory returnInventory = new Inventory();
        returnInventory.setInventoryId(inventory.getInventoryId());
        return returnInventory;
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/inventories/{inventoryid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_INVENTORY",checkTrustedApp=true,checkSessionToken=true)
   public void updateInventory(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@PathVariable( "inventoryid" ) UUID inventoryId,@RequestBody Inventory inventory,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        inventory.setInventoryId(inventoryId);
        serviceFactory.getProjectService().getProjectById(projectid);
        serviceFactory.getInventoryService().updateInventory(inventory,projectcocid,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/inventories/{inventoryid}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_INVENTORY",checkTrustedApp=true,checkSessionToken=true)
   public void deleteInventory(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid,
		   @PathVariable( "inventoryid" ) UUID inventoryId,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Session session = sessionHelper.getSession(request); 
        serviceFactory.getProjectService().getProjectById(projectid);
        serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        serviceFactory.getInventoryService().deleteInventory(inventoryId,session.getAccount().getUsername()); 
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/inventories/{inventoryid}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_INVENTORY_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Inventory getInventoryById(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,@PathVariable( "inventoryid" ) UUID inventoryId,HttpServletRequest request) throws Exception{
       serviceFactory.getProjectService().getProjectById(projectid);
       serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        return serviceFactory.getInventoryService().getInventoryById(inventoryId); 
   }

   @RequestMapping(value="/{projectid}/projectcocs/{projectcocid}/inventories",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_PROJECTCOC_INVENTORY",checkTrustedApp=true,checkSessionToken=true)
   public Inventories getAllEnrollmentInventorys(@PathVariable("projectcocid") UUID projectcocid, @PathVariable("projectid") UUID projectid ,
                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
 
           serviceFactory.getProjectService().getProjectById(projectid);
           serviceFactory.getProjectcocService().getProjectcocById(projectcocid);
        return serviceFactory.getInventoryService().getAllProjectCocInventories(projectcocid,startIndex,maxItems); 
   }
   
   
   
}