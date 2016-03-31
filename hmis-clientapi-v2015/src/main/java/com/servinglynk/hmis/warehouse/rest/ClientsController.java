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
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolences;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurances;
import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.core.model.NoncashbenefitsList;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/clients")
public class ClientsController extends ControllerBase {
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public Client createClient(@RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().createClient(client, session.getAccount().getUsername());	
		Client returnClient = new Client();
		returnClient.setClientId(client.getClientId());
		return returnClient;
	}
	
	
	@RequestMapping(value="/{clientid}", method=RequestMethod.PUT)
	@APIMapping(value="CLIENT_API_UPDATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public void updateClient(@PathVariable("clientid") UUID clientId ,@RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().updateClient(client, session.getAccount().getUsername());
	}
	
	
	
	@RequestMapping(value="/{clientid}", method=RequestMethod.DELETE)
	@APIMapping(value="CLIENT_API_DELETE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public void deleteClient(@PathVariable("clientid") UUID clientId , HttpServletRequest request,HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().deleteClient(clientId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	

	@RequestMapping(value="/{clientid}", method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_CLIENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Client getClientById(@PathVariable("clientid") UUID clientId ,HttpServletRequest request ) throws Exception {
		return serviceFactory.getClientService().getClientById(clientId);
	}

	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ALL_CLIENTS",checkSessionToken=true,checkTrustedApp=true)
	public Clients getAllClien(@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {

		 if (startIndex == null) startIndex =0;
         if (maxItems == null) maxItems =30;
         
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientService().getAllClients(session.getAccount().getUsername(),startIndex,maxItems);
	}
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employment createEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEmploymentService().createEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	         Employment returnemployment = new Employment();
	         returnemployment.setEmploymentId(employment.getEmploymentId());
	         return returnemployment;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEmploymentService().updateEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getEmploymentService().deleteEmployment(employmentId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EMPLOYMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Employment getEmploymentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEmploymentService().getEmploymentById(employmentId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employments getAllEnrollmentEmployments(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEmploymentService().getAllEnrollmentEmployments(enrollmentId,startIndex,maxItems); 
	   }	
	   

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Dateofengagement createDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Dateofengagement dateofengagement,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getDateofengagementService().createDateofengagement(dateofengagement,enrollmentId,session.getAccount().getUsername()); 
	         Dateofengagement returndateofengagement = new Dateofengagement();
	         returndateofengagement.setDateofengagementId(dateofengagement.getDateofengagementId());
	         return returndateofengagement;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "dateofengagementid" ) UUID dateofengagementId,@RequestBody Dateofengagement dateofengagement,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDateofengagementService().updateDateofengagement(dateofengagement,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "dateofengagementid" ) UUID dateofengagementId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getDateofengagementService().deleteDateofengagement(dateofengagementId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Dateofengagement getDateofengagementById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "dateofengagementid" ) UUID dateofengagementId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDateofengagementService().getDateofengagementById(dateofengagementId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Dateofengagements getAllEnrollmentDateofengagements(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDateofengagementService().getAllEnrollmentDateofengagements(enrollmentId,startIndex,maxItems); 
	   }
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilitiess",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public Disabilities createDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Disabilities disabilities,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getDisabilitiesService().createDisabilities(disabilities,enrollmentId,session.getAccount().getUsername()); 
	         Disabilities returndisabilities = new Disabilities();
	         returndisabilities.setDisabilitiesId(disabilities.getDisabilitiesId());
	         return returndisabilities;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilitiess/{disabilitiesid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "disabilitiesid" ) UUID disabilitiesId,@RequestBody Disabilities disabilities,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDisabilitiesService().updateDisabilities(disabilities,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilitiess/{disabilitiesid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "disabilitiesid" ) UUID disabilitiesId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getDisabilitiesService().deleteDisabilities(disabilitiesId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilitiess/{disabilitiesid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DISABILITIES_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Disabilities getDisabilitiesById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "disabilitiesid" ) UUID disabilitiesId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDisabilitiesService().getDisabilitiesById(disabilitiesId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilitiess",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public DisabilitiesList getAllEnrollmentDisabilitiess(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDisabilitiesService().getAllEnrollmentDisabilitiess(enrollmentId,startIndex,maxItems); 
	   }
	   

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public Domesticviolence createDomesticviolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Domesticviolence domesticviolence,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getDomesticviolenceService().createDomesticviolence(domesticviolence,enrollmentId,session.getAccount().getUsername()); 
	         Domesticviolence returndomesticviolence = new Domesticviolence();
	         returndomesticviolence.setDomesticviolenceId(domesticviolence.getDomesticviolenceId());
	         return returndomesticviolence;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDomesticviolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "domesticviolenceid" ) UUID domesticviolenceId,@RequestBody Domesticviolence domesticviolence,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDomesticviolenceService().updateDomesticviolence(domesticviolence,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDomesticviolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "domesticviolenceid" ) UUID domesticviolenceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getDomesticviolenceService().deleteDomesticviolence(domesticviolenceId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Domesticviolence getDomesticviolenceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "domesticviolenceid" ) UUID domesticviolenceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDomesticviolenceService().getDomesticviolenceById(domesticviolenceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public Domesticviolences getAllEnrollmentDomesticviolences(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getDomesticviolenceService().getAllEnrollmentDomesticviolences(enrollmentId,startIndex,maxItems); 
	   }
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/enrollmentcocs",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_ENROLLMENTCOC",checkTrustedApp=true,checkSessionToken=true)
	   public EnrollmentCoc createEnrollmentCoc(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody EnrollmentCoc enrollmentCoc,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentCocService().createEnrollmentCoc(enrollmentCoc,enrollmentId,session.getAccount().getUsername()); 
	         EnrollmentCoc returnenrollmentCoc = new EnrollmentCoc();
	         returnenrollmentCoc.setEnrollmentCocId(enrollmentCoc.getEnrollmentCocId());
	         return returnenrollmentCoc;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_ENROLLMENTCOC",checkTrustedApp=true,checkSessionToken=true)
	   public void updateEnrollmentCoc(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "enrollmentCocid" ) UUID enrollmentCocId,@RequestBody EnrollmentCoc enrollmentCoc,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentCocService().updateEnrollmentCoc(enrollmentCoc,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_ENROLLMENTCOC",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteEnrollmentCoc(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "enrollmentCocid" ) UUID enrollmentCocId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getEnrollmentCocService().deleteEnrollmentCoc(enrollmentCocId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ENROLLMENTCOC_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public EnrollmentCoc getEnrollmentCocById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "enrollmentCocid" ) UUID enrollmentCocId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEnrollmentCocService().getEnrollmentCocById(enrollmentCocId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/enrollmentcocs",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC",checkTrustedApp=true,checkSessionToken=true)
	   public EnrollmentCocs getAllEnrollmentEnrollmentCocs(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEnrollmentCocService().getAllEnrollmentEnrollmentCocs(enrollmentId,startIndex,maxItems); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public Healthinsurance createHealthinsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Healthinsurance healthinsurance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getHealthinsuranceService().createHealthinsurance(healthinsurance,enrollmentId,session.getAccount().getUsername()); 
	         Healthinsurance returnhealthinsurance = new Healthinsurance();
	         returnhealthinsurance.setHealthinsuranceId(healthinsurance.getHealthinsuranceId());
	         return returnhealthinsurance;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateHealthinsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthinsuranceid" ) UUID healthinsuranceId,@RequestBody Healthinsurance healthinsurance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getHealthinsuranceService().updateHealthinsurance(healthinsurance,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteHealthinsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthinsuranceid" ) UUID healthinsuranceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getHealthinsuranceService().deleteHealthinsurance(healthinsuranceId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_HEALTHINSURANCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Healthinsurance getHealthinsuranceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthinsuranceid" ) UUID healthinsuranceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getHealthinsuranceService().getHealthinsuranceById(healthinsuranceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public Healthinsurances getAllEnrollmentHealthinsurances(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getHealthinsuranceService().getAllEnrollmentHealthinsurances(enrollmentId,startIndex,maxItems); 
	   }
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public Medicalassistance createMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Medicalassistance medicalassistance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getMedicalassistanceService().createMedicalassistance(medicalassistance,enrollmentId,session.getAccount().getUsername()); 
	         Medicalassistance returnmedicalassistance = new Medicalassistance();
	         returnmedicalassistance.setMedicalassistanceId(medicalassistance.getMedicalassistanceId());
	         return returnmedicalassistance;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,@RequestBody Medicalassistance medicalassistance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getMedicalassistanceService().updateMedicalassistance(medicalassistance,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getMedicalassistanceService().deleteMedicalassistance(medicalassistanceId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_MEDICALASSISTANCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Medicalassistance getMedicalassistanceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getMedicalassistanceService().getMedicalassistanceById(medicalassistanceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public Medicalassistances getAllEnrollmentMedicalassistances(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getMedicalassistanceService().getAllEnrollmentMedicalassistances(enrollmentId,startIndex,maxItems); 
	   }
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefitss",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_NONCASHBENEFITS",checkTrustedApp=true,checkSessionToken=true)
	   public Noncashbenefits createNoncashbenefits(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Noncashbenefits noncashbenefits,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getNoncashbenefitsService().createNoncashbenefits(noncashbenefits,enrollmentId,session.getAccount().getUsername()); 
	         Noncashbenefits returnnoncashbenefits = new Noncashbenefits();
	         returnnoncashbenefits.setNoncashbenefitsID(noncashbenefits.getNoncashbenefitsID());
	         return returnnoncashbenefits;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefitss/{noncashbenefitsid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_NONCASHBENEFITS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateNoncashbenefits(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "noncashbenefitsid" ) UUID noncashbenefitsId,@RequestBody Noncashbenefits noncashbenefits,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getNoncashbenefitsService().updateNoncashbenefits(noncashbenefits,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefitss/{noncashbenefitsid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_NONCASHBENEFITS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteNoncashbenefits(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "noncashbenefitsid" ) UUID noncashbenefitsId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getNoncashbenefitsService().deleteNoncashbenefits(noncashbenefitsId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefitss/{noncashbenefitsid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_NONCASHBENEFITS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Noncashbenefits getNoncashbenefitsById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "noncashbenefitsid" ) UUID noncashbenefitsId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getNoncashbenefitsService().getNoncashbenefitsById(noncashbenefitsId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefitss",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFITS",checkTrustedApp=true,checkSessionToken=true)
	   public NoncashbenefitsList getAllEnrollmentNoncashbenefitss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getNoncashbenefitsService().getAllEnrollmentNoncashbenefitss(enrollmentId,startIndex,maxItems); 
	   }
	   

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuss",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatus createPathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Pathstatus pathstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getPathstatusService().createPathstatus(pathstatus,enrollmentId,session.getAccount().getUsername()); 
	         Pathstatus returnpathstatus = new Pathstatus();
	         returnpathstatus.setPathstatusId(pathstatus.getPathstatusId());
	         return returnpathstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuss/{pathstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updatePathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "pathstatusid" ) UUID pathstatusId,@RequestBody Pathstatus pathstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getPathstatusService().updatePathstatus(pathstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuss/{pathstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deletePathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "pathstatusid" ) UUID pathstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getPathstatusService().deletePathstatus(pathstatusId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuss/{pathstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_PATHSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatus getPathstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "pathstatusid" ) UUID pathstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getPathstatusService().getPathstatusById(pathstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuss",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatuses getAllEnrollmentPathstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getPathstatusService().getAllEnrollmentPathstatuss(enrollmentId,startIndex,maxItems); 
	   }
	   

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveindates",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindate createResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Residentialmoveindate residentialmoveindate,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getResidentialmoveindateService().createResidentialmoveindate(residentialmoveindate,enrollmentId,session.getAccount().getUsername()); 
	         Residentialmoveindate returnresidentialmoveindate = new Residentialmoveindate();
	         returnresidentialmoveindate.setResidentialmoveindate(residentialmoveindate.getResidentialmoveindate());
	         return returnresidentialmoveindate;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,@RequestBody Residentialmoveindate residentialmoveindate,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getResidentialmoveindateService().updateResidentialmoveindate(residentialmoveindate,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getResidentialmoveindateService().deleteResidentialmoveindate(residentialmoveindateId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindate getResidentialmoveindateById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getResidentialmoveindateService().getResidentialmoveindateById(residentialmoveindateId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveindates",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindates getAllEnrollmentResidentialmoveindates(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getResidentialmoveindateService().getAllEnrollmentResidentialmoveindates(enrollmentId,startIndex,maxItems); 
	   }
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuss",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Healthstatus createHealthstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Healthstatus healthstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getHealthstatusService().createHealthstatus(healthstatus,enrollmentId,session.getAccount().getUsername()); 
	         Healthstatus returnhealthstatus = new Healthstatus();
	         returnhealthstatus.setHealthstatusId(healthstatus.getHealthstatusId());
	         return returnhealthstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuss/{healthstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateHealthstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthstatusid" ) UUID healthstatusId,@RequestBody Healthstatus healthstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getHealthstatusService().updateHealthstatus(healthstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuss/{healthstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteHealthstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthstatusid" ) UUID healthstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getHealthstatusService().deleteHealthstatus(healthstatusId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuss/{healthstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_HEALTHSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Healthstatus getHealthstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthstatusid" ) UUID healthstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getHealthstatusService().getHealthstatusById(healthstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuss",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Healthstatuses getAllEnrollmentHealthstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getHealthstatusService().getAllEnrollmentHealthstatuss(enrollmentId,startIndex,maxItems); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuss",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatus createRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Rhybcpstatus rhybcpstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getRhybcpstatusService().createRhybcpstatus(rhybcpstatus,enrollmentId,session.getAccount().getUsername()); 
	         Rhybcpstatus returnrhybcpstatus = new Rhybcpstatus();
	         returnrhybcpstatus.setRhybcpstatusId(rhybcpstatus.getRhybcpstatusId());
	         return returnrhybcpstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuss/{rhybcpstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,@RequestBody Rhybcpstatus rhybcpstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getRhybcpstatusService().updateRhybcpstatus(rhybcpstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuss/{rhybcpstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getRhybcpstatusService().deleteRhybcpstatus(rhybcpstatusId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuss/{rhybcpstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_RHYBCPSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatus getRhybcpstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getRhybcpstatusService().getRhybcpstatusById(rhybcpstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuss",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatuses getAllEnrollmentRhybcpstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getRhybcpstatusService().getAllEnrollmentRhybcpstatuss(enrollmentId,startIndex,maxItems); 
	   }
	}
	
