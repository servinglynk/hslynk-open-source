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
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Exits;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/clients")
public class ClientsController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public Client createClient(@RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientService().createClient(client, session.getAccount().getUsername());	
	}
	
	
	@RequestMapping(value="/{clientid}", method=RequestMethod.PUT)
	@APIMapping(value="CLIENT_API_UPDATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public Client updateClient(@PathVariable("clientid") UUID clientId ,@RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientService().updateClient(client, session.getAccount().getUsername());
	}
	
	
	
	@RequestMapping(value="/{clientid}", method=RequestMethod.DELETE)
	@APIMapping(value="CLIENT_API_DELETE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public Client deleteClient(@PathVariable("clientid") UUID clientId , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getClientService().deleteClient(clientId, session.getAccount().getUsername());
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
	
	@RequestMapping(value="/{clientid}/enrollments",method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment,@PathVariable("clientid") UUID clientId ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getEnrollmentService().createEnrollment(enrollment, clientId, session.getAccount().getUsername());
	}
	
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}",method=RequestMethod.PUT)	
	@APIMapping(value="CLIENT_API_UPDATE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment updateEnrollment(@RequestBody Enrollment enrollment,@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getEnrollmentService().updateEnrollment(enrollment, clientId, session.getAccount().getUsername());
	}
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}",method=RequestMethod.DELETE)
	@APIMapping(value="CLIENT_API_DELETE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment deleteEnrollment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getEnrollmentService().deleteEnrollment(enrollmentId,clientId, session.getAccount().getUsername());
	}
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment getClientEnrollmentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId,clientId);
	}

	@RequestMapping(value="/{clientid}/enrollments",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS",checkSessionToken=true,checkTrustedApp=true)
	public Enrollments getAllClientEnrollments(@PathVariable("clientid") UUID clientId,
			@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {

		if (startIndex == null) startIndex =0;
         if (maxItems == null) maxItems =30;

		return serviceFactory.getEnrollmentService().getEnrollmentsByClientId(clientId,startIndex,maxItems);
	}
	
	
	// Exits API start
	
	
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public Exit createExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Exit exit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId);
	//        exit.setEnrollment(enrollmentId);
	        return serviceFactory.getExitService().createExit(exit,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public Exit updateExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "exitid" ) UUID exitId,@RequestBody Exit exit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId);
	    //    exit.setEnrollment(enrollmentId);
	        return serviceFactory.getExitService().updateExit(exit,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public Exit deleteExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "exitid" ) UUID exitId,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId);
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
	        return serviceFactory.getExitService().deleteExit(exitId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EXIT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Exit getExitById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "exitid" ) UUID exitId,HttpServletRequest request) throws Exception{
	        serviceFactory.getClientService().getClientById(clientId);
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		   return serviceFactory.getExitService().getExitById(exitId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_EXITS",checkTrustedApp=true,checkSessionToken=true)
	   public Exits getAllEnrollmentExits(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   			   @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
		        serviceFactory.getClientService().getClientById(clientId);
		        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
	        return serviceFactory.getExitService().getAllEnrollmentExits(enrollmentId,startIndex,maxItems); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employment createEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	        return serviceFactory.getEmploymentService().createEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employment updateEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	        return serviceFactory.getEmploymentService().updateEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employment deleteEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEmploymentService().deleteEmployment(employmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EMPLOYMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Employment getEmploymentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEmploymentService().getEmploymentById(employmentId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS",checkTrustedApp=true,checkSessionToken=true)
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
}
