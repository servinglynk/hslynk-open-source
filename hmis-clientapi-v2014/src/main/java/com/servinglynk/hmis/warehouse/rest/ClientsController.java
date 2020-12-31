package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.core.model.CommercialSexualExploitation;
import com.servinglynk.hmis.warehouse.core.model.CommercialSexualExploitations;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoars;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolences;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActions;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActionsList;
import com.servinglynk.hmis.warehouse.core.model.Exits;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunification;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunifications;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurances;
import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.core.model.HealthStatuses;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDispositions;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSources;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddresses;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefits;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
import com.servinglynk.hmis.warehouse.core.model.Percentami;
import com.servinglynk.hmis.warehouse.core.model.Percentamis;
import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.core.model.ProjectCompletionStatuses;
import com.servinglynk.hmis.warehouse.core.model.Referralsource;
import com.servinglynk.hmis.warehouse.core.model.Referralsources;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatuses;
import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.core.model.ServicesList;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientations;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfos;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituations;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssue;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssues;

@RestController
@RequestMapping("/clients")
public class ClientsController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public Client createClient(@Valid @RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().createClient(client, session.getAccount().getUsername());	
		Client returnClient = new Client();
		returnClient.setClientId(client.getClientId());
		return returnClient;
	}
	
	
	@RequestMapping(value="/{clientid}", method=RequestMethod.PUT)
	@APIMapping(value="CLIENT_API_UPDATE_CLIENT",checkSessionToken=true,checkTrustedApp=true)
	public void updateClient(@PathVariable("clientid") UUID clientId ,@Valid @RequestBody Client client , HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		client.setClientId(clientId);
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
		return serviceFactory.getClientService().getAllClients(session.getAccount().getProjectGroup().getProjectGroupCode(),startIndex,maxItems);
	}
	
	@RequestMapping(value="/{clientid}/enrollments",method=RequestMethod.POST)
	@APIMapping(value="CLIENT_API_CREATE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment,@PathVariable("clientid") UUID clientId ,
			@RequestParam(value = "updateGenericHouseHold",required = false,defaultValue = "true") Boolean updateGenericHouseHold,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getEnrollmentService().createEnrollment(enrollment, clientId,updateGenericHouseHold,
				session);
		Enrollment returnEnrollment = new Enrollment();
		returnEnrollment.setEnrollmentId(enrollment.getEnrollmentId());
		return returnEnrollment;
	}
	
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}",method=RequestMethod.PUT)	
	@APIMapping(value="CLIENT_API_UPDATE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public void updateEnrollment(@RequestBody Enrollment enrollment,@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		enrollment.setEnrollmentId(enrollmentId);
		serviceFactory.getEnrollmentService().updateEnrollment(enrollment, clientId, session.getAccount().getUsername(),session);
	}
	

	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/calculatechronichomeless",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment calculateChronicHomelessness(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		com.servinglynk.hmis.warehouse.core.model.Enrollment  enrollment = new com.servinglynk.hmis.warehouse.core.model.Enrollment();
		enrollment.setEnrollmentId(enrollmentId);
		return serviceFactory.getEnrollmentService().calculateChronicHomelessness(enrollment,clientId,session.getAccount().getUsername(),session);
	}
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/",method=RequestMethod.DELETE)
	@APIMapping(value="CLIENT_API_DELETE_ENROLLMENT",checkSessionToken=true,checkTrustedApp=true)
	public void deleteEnrollment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId
			,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getEnrollmentService().deleteEnrollment(enrollmentId,clientId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
	
	@RequestMapping(value="/{clientid}/enrollments/{enrollmentid}",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment getClientEnrollmentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value="includeChildLinks",required=false,defaultValue="false") boolean includeChildLinks,HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId,clientId,includeChildLinks);
	}

	@RequestMapping(value="/enrollments/{enrollmentid}",method=RequestMethod.GET)
//	@APIMapping(value="GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	@APIMapping(value="CLIENT_API_GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment getEnrollmentById(@PathVariable("enrollmentid") UUID enrollmentId ,
			@RequestParam(value="includeChildLinks",required=false,defaultValue="false") boolean includeChildLinks,
			HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().getEnrollmentByEnrollmentId(enrollmentId,includeChildLinks);
	}

	@RequestMapping(value="/{clientid}/enrollments",method=RequestMethod.GET)
	@APIMapping(value="CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS",checkSessionToken=true,checkTrustedApp=true)
	public Enrollments getAllClientEnrollments(@PathVariable("clientid") UUID clientId,
			@RequestParam(value="startIndex", required=false) Integer startIndex, 
            @RequestParam(value="maxItems", required=false) Integer maxItems ,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		if (startIndex == null) startIndex =0;
         if (maxItems == null) maxItems =30;

		return serviceFactory.getEnrollmentService().getEnrollmentsByClientId(clientId,session.getAccount().getUsername(),startIndex,maxItems);
	}
	
	
	// Exits API start
	
	
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public Exit createExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Exit exit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId);
	//        exit.setEnrollment(enrollmentId);
	        serviceFactory.getExitService().createExit(exit,enrollmentId,session.getAccount().getUsername()); 
	        Exit returnExit = new Exit();
	        returnExit.setExitId(exit.getExitId());
	        return returnExit;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "exitid" ) UUID exitId,@RequestBody Exit exit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        exit.setExitId(exitId);
	        serviceFactory.getClientService().getClientById(clientId);
	    //    exit.setEnrollment(enrollmentId);
	        serviceFactory.getExitService().updateExit(exit,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EXIT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "exitid" ) UUID exitId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId);
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	        serviceFactory.getExitService().deleteExit(exitId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EXIT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Exit getExitById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "exitid" ) UUID exitId,
			   @RequestParam(value="includeChildLinks",required=false,defaultValue="false") boolean includeChildLinks,
			   HttpServletRequest request) throws Exception{
	        serviceFactory.getClientService().getClientById(clientId);
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
		   return serviceFactory.getExitService().getExitById(exitId,includeChildLinks); 
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
		        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	        return serviceFactory.getExitService().getAllEnrollmentExits(enrollmentId,startIndex,maxItems); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Employment createEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEmploymentService().createEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	        Employment returnEmployment = new Employment();
	        returnEmployment.setEmploymentId(employment.getEmploymentId());
	        return returnEmployment;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,@RequestBody Employment employment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        employment.setEmploymentId(employmentId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEmploymentService().updateEmployment(employment,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EMPLOYMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteEmployment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getEmploymentService().deleteEmployment(employmentId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EMPLOYMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Employment getEmploymentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "employmentid" ) UUID employmentId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
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
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getEmploymentService().getAllEnrollmentEmployments(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	// Veteran Info API Start
	   
	   @RequestMapping(value="/{clientid}/veteraninfos",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_VETERANINFO",checkTrustedApp=true,checkSessionToken=true)
	   public VeteranInfo createVeteranInfo(@PathVariable("clientid") UUID clientId,@RequestBody VeteranInfo veteranInfo,HttpServletRequest request) throws Exception{
		   Session session = sessionHelper.getSession(request);
		   serviceFactory.getVeteranInfoService().createVeteranInfo(veteranInfo, clientId, session.getAccount().getUsername());
		   VeteranInfo returnVeteranInfo = new VeteranInfo();
		   returnVeteranInfo.setVeteranInfoId(veteranInfo.getVeteranInfoId());
		   return returnVeteranInfo;
	   }

	   @RequestMapping(value="/{clientid}/veteraninfos/{veteranInfoid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_VETERANINFO",checkTrustedApp=true,checkSessionToken=true)
	   public void updateVeteranInfo(@PathVariable("clientid") UUID clientId, @PathVariable( "veteranInfoid" ) UUID veteranInfoId,@RequestBody VeteranInfo veteranInfo,HttpServletRequest request) throws Exception{
		   Session session = sessionHelper.getSession(request);
		   veteranInfo.setVeteranInfoId(veteranInfoId);
		   serviceFactory.getVeteranInfoService().updateVeteranInfo(veteranInfo, clientId, session.getAccount().getUsername());
	   }

	   @RequestMapping(value="/{clientid}/veteraninfos/{veteranInfoid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_VETERANINFO",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteVeteranInfo(@PathVariable("clientid") UUID clientId,@PathVariable( "veteranInfoid" ) UUID veteranInfoId,
			   HttpServletRequest request,HttpServletResponse response) throws Exception{
		   serviceFactory.getClientService().getClientById(clientId);
		   Session session = sessionHelper.getSession(request);
		   serviceFactory.getVeteranInfoService().deleteVeteranInfo(veteranInfoId,  session.getAccount().getUsername());
		   response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/veteraninfos/{veteranInfoid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_VETERANINFO_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public VeteranInfo getVeteranInfoById(@PathVariable("clientid") UUID clientId,@PathVariable( "veteranInfoid" ) UUID veteranInfoId,HttpServletRequest request) throws Exception{
		   serviceFactory.getClientService().getClientById(clientId);
		   return serviceFactory.getVeteranInfoService().getVeteranInfoById(veteranInfoId);
	   }

	   @RequestMapping(value="/{clientid}/veteraninfos",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_CLIENT_VETERANINFOS",checkTrustedApp=true,checkSessionToken=true)
	   public VeteranInfos getAllEnrollmentVeteranInfos(@PathVariable("clientid") UUID clientId,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	           serviceFactory.getClientService().getClientById(clientId);
	           return serviceFactory.getVeteranInfoService().getAllClientVeteranInfos(clientId, startIndex, maxItems);
	           
	          }
	   
	// Disabilities API Start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilities",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public Disabilities createDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Disabilities disabilities,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	       serviceFactory.getDisabilitiesService().createDisabilities(disabilities,enrollmentId,session.getAccount().getUsername()); 
	       Disabilities returnDisabilities = new Disabilities();
	       returnDisabilities.setDisabilitiesId(disabilities.getDisabilitiesId());
	       return returnDisabilities;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "disabilitiesid" ) UUID disabilitiesId,@RequestBody Disabilities disabilities,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        disabilities.setDisabilitiesId(disabilitiesId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDisabilitiesService().updateDisabilities(disabilities,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDisabilities(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "disabilitiesid" ) UUID disabilitiesId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getDisabilitiesService().deleteDisabilities(disabilitiesId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DISABILITIES_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Disabilities getDisabilitiesById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "disabilitiesid" ) UUID disabilitiesId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getDisabilitiesService().getDisabilitiesById(disabilitiesId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/disabilities",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES",checkTrustedApp=true,checkSessionToken=true)
	   public DisabilitiesList getAllEnrollmentDisabilitiess(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getDisabilitiesService().getAllEnrollmentDisabilitiess(enrollmentId,startIndex,maxItems); 
	   }

	   // ConnectionWithSoar API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/connectionwithsoars",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_CONNECTIONWITHSOAR",checkTrustedApp=true,checkSessionToken=true)
	   public Connectionwithsoar createConnectionwithsoar(@PathVariable("clientid") UUID clientId, 
			   	@PathVariable("enrollmentid") UUID enrollmentId ,
			   	@PathVariable("exitid") UUID exitId,
			   	@RequestBody Connectionwithsoar connectionwithsoar,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getConnectionwithsoarService().createConnectionwithsoar(connectionwithsoar,exitId,session.getAccount().getUsername()); 
	        Connectionwithsoar returnConnectionwithsoar = new Connectionwithsoar();
	        returnConnectionwithsoar.setConnectionwithsoarId(connectionwithsoar.getConnectionwithsoarId());
	        return returnConnectionwithsoar;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/connectionwithsoars/{connectionwithsoarid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_CONNECTIONWITHSOAR",checkTrustedApp=true,checkSessionToken=true)
	   public void updateConnectionwithsoar(@PathVariable("clientid") UUID clientId, 
			 @PathVariable("enrollmentid") UUID enrollmentId ,
			 @PathVariable("exitid") UUID exitId ,
			 @PathVariable( "connectionwithsoarid" ) UUID connectionwithsoarId,@RequestBody Connectionwithsoar connectionwithsoar,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        connectionwithsoar.setConnectionwithsoarId(connectionwithsoarId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getConnectionwithsoarService().updateConnectionwithsoar(connectionwithsoar,exitId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/connectionwithsoars/{connectionwithsoarid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_CONNECTIONWITHSOAR",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteConnectionwithsoar(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @PathVariable( "connectionwithsoarid" ) UUID connectionwithsoarId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	         serviceFactory.getConnectionwithsoarService().deleteConnectionwithsoar(connectionwithsoarId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/connectionwithsoars/{connectionwithsoarid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_CONNECTIONWITHSOAR_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Connectionwithsoar getConnectionwithsoarById(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @PathVariable( "connectionwithsoarid" ) UUID connectionwithsoarId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getConnectionwithsoarService().getConnectionwithsoarById(connectionwithsoarId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/connectionwithsoars",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_EXIT_CONNECTIONWITHSOARS",checkTrustedApp=true,checkSessionToken=true)
	   public Connectionwithsoars getAllEnrollmentConnectionwithsoars(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getConnectionwithsoarService().getAllExitConnectionwithsoars(exitId,startIndex,maxItems); 
	   }
	   
	   // Enrollment Coc ACtions API Start
		@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/enrollmentcocs", method = RequestMethod.POST)
		@APIMapping(value = "CLIENT_API_CREATE_ENROLLMENTCOC", checkTrustedApp = true, checkSessionToken = true)
		public EnrollmentCoc createEnrollmentCoc(@PathVariable("clientid") UUID clientId,
				@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody EnrollmentCoc enrollmentCoc,
				HttpServletRequest request) throws Exception {
			Session session = sessionHelper.getSession(request);
			serviceFactory.getClientService().getClientById(clientId);
			serviceFactory.getEnrollmentCocService().createEnrollmentCoc(enrollmentCoc, enrollmentId,
					session.getAccount().getUsername());
			EnrollmentCoc returnenrollmentCoc = new EnrollmentCoc();
			returnenrollmentCoc.setEnrollmentCocId(enrollmentCoc.getEnrollmentCocId());
			return returnenrollmentCoc;
		}

		@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}", method = RequestMethod.PUT)
		@APIMapping(value = "CLIENT_API_UPDATE_ENROLLMENTCOC", checkTrustedApp = true, checkSessionToken = true)
		public void updateEnrollmentCoc(@PathVariable("clientid") UUID clientId,
				@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("enrollmentCocid") UUID enrollmentCocId,
				@RequestBody EnrollmentCoc enrollmentCoc, HttpServletRequest request) throws Exception {
			Session session = sessionHelper.getSession(request);
			enrollmentCoc.setEnrollmentCocId(enrollmentCocId);
			serviceFactory.getClientService().getClientById(clientId);
			serviceFactory.getEnrollmentCocService().updateEnrollmentCoc(enrollmentCoc, enrollmentId,
					session.getAccount().getUsername());
		}

		@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}", method = RequestMethod.DELETE)
		@APIMapping(value = "CLIENT_API_DELETE_ENROLLMENTCOC", checkTrustedApp = true, checkSessionToken = true)
		public void deleteEnrollmentCoc(@PathVariable("clientid") UUID clientId,
				@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("enrollmentCocid") UUID enrollmentCocId,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			Session session = sessionHelper.getSession(request);
			serviceFactory.getClientService().getClientById(clientId);
			serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
			serviceFactory.getEnrollmentCocService().deleteEnrollmentCoc(enrollmentCocId,
					session.getAccount().getUsername());
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}

		@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/enrollmentcocs/{enrollmentCocid}", method = RequestMethod.GET)
		@APIMapping(value = "CLIENT_API_GET_ENROLLMENTCOC_BY_ID", checkTrustedApp = true, checkSessionToken = true)
		public EnrollmentCoc getEnrollmentCocById(@PathVariable("clientid") UUID clientId,
				@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("enrollmentCocid") UUID enrollmentCocId,
				HttpServletRequest request) throws Exception {
			serviceFactory.getClientService().getClientById(clientId);
			serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
			return serviceFactory.getEnrollmentCocService().getEnrollmentCocById(enrollmentCocId);
		}

		@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/enrollmentcocs", method = RequestMethod.GET)
		@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC", checkTrustedApp = true, checkSessionToken = true)
		public EnrollmentCocs getAllEnrollmentEnrollmentCocs(@PathVariable("clientid") UUID clientId,
				@PathVariable("enrollmentid") UUID enrollmentId,
				@RequestParam(value = "startIndex", required = false) Integer startIndex,
				@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
						throws Exception {
			if (startIndex == null)
				startIndex = 0;
			if (maxItems == null)
				maxItems = 30;

			serviceFactory.getClientService().getClientById(clientId);
			serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
			return serviceFactory.getEnrollmentCocService().getAllEnrollmentEnrollmentCocs(enrollmentId, startIndex,
					maxItems);
		}
	   
	   // Exit Plans Actions API Start
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitplansactions",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EXITPLANSACTIONS",checkTrustedApp=true,checkSessionToken=true)
	   public ExitPlansActions createExitPlansActions(@PathVariable("clientid") UUID clientId, 
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @RequestBody ExitPlansActions exitPlansActions,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getExitPlansActionsService().createExitPlansActions(exitPlansActions,enrollmentId,session.getAccount().getUsername()); 
	         ExitPlansActions returnExitPlansActions = new ExitPlansActions();
	         returnExitPlansActions.setExitPlansActionsId(returnExitPlansActions.getExitPlansActionsId());
	         return returnExitPlansActions;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitplansactions/{exitPlansActionsid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EXITPLANSACTIONS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateExitPlansActions(@PathVariable("clientid") UUID clientId, 
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @PathVariable( "exitPlansActionsid" ) UUID exitPlansActionsId,@RequestBody ExitPlansActions exitPlansActions,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        exitPlansActions.setExitPlansActionsId(exitPlansActionsId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getExitPlansActionsService().updateExitPlansActions(exitPlansActions,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitplansactions/{exitPlansActionsid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EXITPLANSACTIONS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteExitPlansActions(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @PathVariable( "exitPlansActionsid" ) UUID exitPlansActionsId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	         serviceFactory.getExitPlansActionsService().deleteExitPlansActions(exitPlansActionsId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitplansactions/{exitPlansActionsid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EXITPLANSACTIONS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public ExitPlansActions getExitPlansActionsById(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
			   @PathVariable( "exitPlansActionsid" ) UUID exitPlansActionsId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getExitPlansActionsService().getExitPlansActionsById(exitPlansActionsId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitplansactions",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_EXIT_EXITPLANSACTIONS",checkTrustedApp=true,checkSessionToken=true)
	   public ExitPlansActionsList getAllEnrollmentExitPlansActionss(@PathVariable("clientid") UUID clientId,
			   @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getExitPlansActionsService().getAllExitExitPlansActionss(exitId,startIndex,maxItems); 
	   }

	   
	   // Family Reunification API start
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/familyreunifications",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_FAMILYREUNIFICATION",checkTrustedApp=true,checkSessionToken=true)
	   public FamilyReunification createFamilyReunification(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId,@RequestBody FamilyReunification familyReunification,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	         serviceFactory.getFamilyReunificationService().createFamilyReunification(familyReunification,exitId,session.getAccount().getUsername()); 
	         FamilyReunification returnFamilyReunification = new FamilyReunification();
	         returnFamilyReunification.setFamilyReunificationId(familyReunification.getFamilyReunificationId());
	         return returnFamilyReunification;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/familyreunifications/{familyReunificationid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_FAMILYREUNIFICATION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateFamilyReunification(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "familyReunificationid" ) UUID familyReunificationId,@RequestBody FamilyReunification familyReunification,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        familyReunification.setFamilyReunificationId(familyReunificationId);
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getFamilyReunificationService().updateFamilyReunification(familyReunification,exitId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/familyreunifications/{familyReunificationid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_FAMILYREUNIFICATION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteFamilyReunification(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitId, @PathVariable( "familyReunificationid" ) UUID familyReunificationId,
			   HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false);
	         serviceFactory.getExitService().getExitById(exitId,false);
	         serviceFactory.getFamilyReunificationService().deleteFamilyReunification(familyReunificationId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/familyreunifications/{familyReunificationid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_FAMILYREUNIFICATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public FamilyReunification getFamilyReunificationById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "familyReunificationid" ) UUID familyReunificationId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getFamilyReunificationService().getFamilyReunificationById(familyReunificationId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/familyreunifications",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_EXIT_FAMILYREUNIFICATION",checkTrustedApp=true,checkSessionToken=true)
	   public FamilyReunifications getAllEnrollmentFamilyReunifications(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable("exitid") UUID exitId, 
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getFamilyReunificationService().getAllEnrollmentFamilyReunifications(exitId,startIndex,maxItems); 
	   }
	   
	   
	   // Housing Assessment Dispositions API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_HOUSINGASSESSMENTDISPOSITION",checkTrustedApp=true,checkSessionToken=true)
	   public HousingAssessmentDisposition createHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId,@RequestBody HousingAssessmentDisposition housingAssessmentDisposition,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getHousingAssessmentDispositionService().createHousingAssessmentDisposition(housingAssessmentDisposition,exitId,session.getAccount().getUsername()); 
	         HousingAssessmentDisposition returnHousingAssessmentDisposition = new HousingAssessmentDisposition();
	         returnHousingAssessmentDisposition.setHousingAssessmentDispositionId(housingAssessmentDisposition.getHousingAssessmentDispositionId());
	         return returnHousingAssessmentDisposition;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_HOUSINGASSESSMENTDISPOSITION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "housingAssessmentDispositionid" ) UUID housingAssessmentDispositionId,@RequestBody HousingAssessmentDisposition housingAssessmentDisposition,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        housingAssessmentDisposition.setHousingAssessmentDispositionId(housingAssessmentDispositionId);
	        serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        serviceFactory.getHousingAssessmentDispositionService().updateHousingAssessmentDisposition(housingAssessmentDisposition,exitId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_HOUSINGASSESSMENTDISPOSITION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , 
			   @PathVariable("exitid") UUID exitId, @PathVariable( "housingAssessmentDispositionid" ) UUID housingAssessmentDispositionId,
			   HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	         serviceFactory.getHousingAssessmentDispositionService().deleteHousingAssessmentDisposition(housingAssessmentDispositionId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_HOUSINGASSESSMENTDISPOSITION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public HousingAssessmentDisposition getHousingAssessmentDispositionById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "housingAssessmentDispositionid" ) UUID housingAssessmentDispositionId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getHousingAssessmentDispositionService().getHousingAssessmentDispositionById(housingAssessmentDispositionId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_EXIT_HOUSINGASSESSMENTDISPOSITION",checkTrustedApp=true,checkSessionToken=true)
	   public HousingAssessmentDispositions getAllEnrollmentHousingAssessmentDispositions(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable("exitid") UUID exitId, 
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getExitService().getExitById(exitId,false);
	        return serviceFactory.getHousingAssessmentDispositionService().getAllExitHousingAssessmentDispositions(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   // Project Completion Status API
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/projectcompletionstatuses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_PROJECTCOMPLETIONSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public ProjectCompletionStatus createProjectCompletionStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId,@RequestBody ProjectCompletionStatus projectCompletionStatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getProjectCompletionStatusService().createProjectCompletionStatus(projectCompletionStatus,exitId,session.getAccount().getUsername()); 
	         ProjectCompletionStatus returnProjectCompletionStatus = new ProjectCompletionStatus();
	         returnProjectCompletionStatus.setProjectCompletionStatusId(projectCompletionStatus.getProjectCompletionStatusId());
	         return returnProjectCompletionStatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/projectcompletionstatuses/{projectCompletionStatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_PROJECTCOMPLETIONSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateProjectCompletionStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "projectCompletionStatusid" ) UUID projectCompletionStatusId,@RequestBody ProjectCompletionStatus projectCompletionStatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        projectCompletionStatus.setProjectCompletionStatusId(projectCompletionStatusId);
	        serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        serviceFactory.getProjectCompletionStatusService().updateProjectCompletionStatus(projectCompletionStatus,exitId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/projectcompletionstatuses/{projectCompletionStatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_PROJECTCOMPLETIONSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteProjectCompletionStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , 
			   @PathVariable("exitid") UUID exitId, @PathVariable( "projectCompletionStatusid" ) UUID projectCompletionStatusId,
			   HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getProjectCompletionStatusService().deleteProjectCompletionStatus(projectCompletionStatusId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/projectcompletionstatuses/{projectCompletionStatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_PROJECTCOMPLETIONSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public ProjectCompletionStatus getProjectCompletionStatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId , @PathVariable("exitid") UUID exitId, @PathVariable( "projectCompletionStatusid" ) UUID projectCompletionStatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getProjectCompletionStatusService().getProjectCompletionStatusById(projectCompletionStatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/projectcompletionstatuses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_EXIT_PROJECTCOMPLETIONSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public ProjectCompletionStatuses getAllEnrollmentProjectCompletionStatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable("exitid") UUID exitId, 
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getProjectCompletionStatusService().getAllExitProjectCompletionStatuss(exitId,startIndex,maxItems); 
	   }
	   
	   
	   // IncomeAndSources API
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/incomeandsources",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_INCOMEANDSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public IncomeAndSource createIncomeAndSource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody IncomeAndSource incomeAndSource,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getIncomeAndSourceService().createIncomeAndSource(incomeAndSource,enrollmentId,session.getAccount().getUsername()); 
	         IncomeAndSource returnIncomeAndSource = new IncomeAndSource();
	         returnIncomeAndSource.setIncomeAndSourceId(incomeAndSource.getIncomeAndSourceId());
	         return returnIncomeAndSource;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_INCOMEANDSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateIncomeAndSource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "incomeAndSourceid" ) UUID incomeAndSourceId,@RequestBody IncomeAndSource incomeAndSource,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        incomeAndSource.setIncomeAndSourceId(incomeAndSourceId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getIncomeAndSourceService().updateIncomeAndSource(incomeAndSource,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_INCOMEANDSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteIncomeAndSource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "incomeAndSourceid" ) UUID incomeAndSourceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getIncomeAndSourceService().deleteIncomeAndSource(incomeAndSourceId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_INCOMEANDSOURCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public IncomeAndSource getIncomeAndSourceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "incomeAndSourceid" ) UUID incomeAndSourceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getIncomeAndSourceService().getIncomeAndSourceById(incomeAndSourceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/incomeandsources",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public IncomeAndSources getAllEnrollmentIncomeAndSources(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getIncomeAndSourceService().getAllEnrollmentIncomeAndSources(enrollmentId,startIndex,maxItems); 
	   }

	   // HealthInsurance API 
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public HealthInsurance createHealthInsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody HealthInsurance healthInsurance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getHealthInsuranceService().createHealthInsurance(healthInsurance,enrollmentId,session.getAccount().getUsername()); 
	         HealthInsurance returnHealthInsurance = new HealthInsurance();
	         returnHealthInsurance.setHealthInsuranceId(healthInsurance.getHealthInsuranceId());
	         return returnHealthInsurance;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthInsuranceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateHealthInsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthInsuranceid" ) UUID healthInsuranceId,@RequestBody HealthInsurance healthInsurance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        healthInsurance.setHealthInsuranceId(healthInsuranceId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getHealthInsuranceService().updateHealthInsurance(healthInsurance,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthInsuranceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteHealthInsurance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "healthInsuranceid" ) UUID healthInsuranceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getHealthInsuranceService().deleteHealthInsurance(healthInsuranceId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthInsuranceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_HEALTHINSURANCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public HealthInsurance getHealthInsuranceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthInsuranceid" ) UUID healthInsuranceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getHealthInsuranceService().getHealthInsuranceById(healthInsuranceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthinsurances",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE",checkTrustedApp=true,checkSessionToken=true)
	   public HealthInsurances getAllEnrollmentHealthInsurances(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getHealthInsuranceService().getAllEnrollmentHealthInsurances(enrollmentId,startIndex,maxItems); 
	   }

	   
	   // Services API
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/services",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_SERVICES",checkTrustedApp=true,checkSessionToken=true)
	   public Services createServices(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Services services,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getServicesService().createServices(services,enrollmentId,session.getAccount().getUsername()); 
	         Services returnServices = new Services();
	         returnServices.setServicesId(services.getServicesId());
	         return returnServices;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/services/{servicesid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_SERVICES",checkTrustedApp=true,checkSessionToken=true)
	   public void updateServices(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "servicesid" ) UUID servicesId,@RequestBody Services services,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        services.setServicesId(servicesId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getServicesService().updateServices(services,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/services/{servicesid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_SERVICES",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteServices(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "servicesid" ) UUID servicesId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        serviceFactory.getServicesService().deleteServices(servicesId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/services/{servicesid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_SERVICES_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Services getServicesById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "servicesid" ) UUID servicesId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getServicesService().getServicesById(servicesId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/services",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_SERVICES",checkTrustedApp=true,checkSessionToken=true)
	   public ServicesList getAllEnrollmentServicess(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getServicesService().getAllEnrollmentServicess(enrollmentId,startIndex,maxItems); 
	   }

	   // Health Status API status
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public HealthStatus createHealthStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody HealthStatus healthStatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getHealthStatusService().createHealthStatus(healthStatus,enrollmentId,session.getAccount().getUsername()); 
	        HealthStatus returnHealthStatus = new HealthStatus();
	        returnHealthStatus.setHealthStatusId(healthStatus.getHealthStatusId());
	        return returnHealthStatus;	        
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthStatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateHealthStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthStatusid" ) UUID healthStatusId,@RequestBody HealthStatus healthStatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        healthStatus.setHealthStatusId(healthStatusId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getHealthStatusService().updateHealthStatus(healthStatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthStatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteHealthStatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "healthStatusid" ) UUID healthStatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getHealthStatusService().deleteHealthStatus(healthStatusId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthStatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_HEALTHSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public HealthStatus getHealthStatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "healthStatusid" ) UUID healthStatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getHealthStatusService().getHealthStatusById(healthStatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/healthstatuses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public HealthStatuses getAllEnrollmentHealthStatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getHealthStatusService().getAllEnrollmentHealthStatuss(enrollmentId,startIndex,maxItems); 
	   }

	   // Commercial Sexual Exploitation API Start
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/commercialsexualexploitations",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_COMMERCIAL_SEXUAL_EXPLOITATION",checkTrustedApp=true,checkSessionToken=true)
	   public CommercialSexualExploitation createCommercialSexualExploitation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody CommercialSexualExploitation commercialSexualExploitation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getCommercialSexualExploitationService().createCommercialSexualExploitation(commercialSexualExploitation,enrollmentId,session.getAccount().getUsername()); 
	         CommercialSexualExploitation returnCommercialSexualExploitation = new CommercialSexualExploitation();
	         returnCommercialSexualExploitation.setCommercialsexualexploitationId(commercialSexualExploitation.getCommercialsexualexploitationId());
	         return returnCommercialSexualExploitation;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/commercialsexualexploitations/{commercialSexualExploitationid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_COMMERCIAL_SEXUAL_EXPLOITATION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateCommercialSexualExploitation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "commercialSexualExploitationid" ) UUID commercialSexualExploitationId,@RequestBody CommercialSexualExploitation commercialSexualExploitation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        commercialSexualExploitation.setCommercialsexualexploitationId(commercialSexualExploitationId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getCommercialSexualExploitationService().updateCommercialSexualExploitation(commercialSexualExploitation,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/commercialsexualexploitations/{commercialSexualExploitationid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_COMMERCIAL_SEXUAL_EXPLOITATION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteCommercialSexualExploitation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "commercialSexualExploitationid" ) UUID commercialSexualExploitationId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getCommercialSexualExploitationService().deleteCommercialSexualExploitation(commercialSexualExploitationId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/commercialsexualexploitations/{commercialSexualExploitationid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_COMMERCIAL_SEXUAL_EXPLOITATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public CommercialSexualExploitation getCommercialSexualExploitationById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "commercialSexualExploitationid" ) UUID commercialSexualExploitationId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getCommercialSexualExploitationService().getCommercialSexualExploitationById(commercialSexualExploitationId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/commercialsexualexploitations",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_COMMERCIAL_SEXUAL_EXPLOITATION",checkTrustedApp=true,checkSessionToken=true)
	   public CommercialSexualExploitations getAllEnrollmentCommercialSexualExploitations(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getCommercialSexualExploitationService().getAllEnrollmentCommercialSexualExploitations(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   // Date Of Engagement API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Dateofengagement createDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Dateofengagement dateofengagement,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getDateofengagementService().createDateofengagement(dateofengagement,enrollmentId,session.getAccount().getUsername()); 
	         Dateofengagement returnDateofengagement = new Dateofengagement();
	         returnDateofengagement.setDateofengagementId(dateofengagement.getDateofengagementId());
	         return returnDateofengagement;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "dateofengagementid" ) UUID dateofengagementId,@RequestBody Dateofengagement dateofengagement,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        dateofengagement.setDateofengagementId(dateofengagementId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDateofengagementService().updateDateofengagement(dateofengagement,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DATEOFENGAGEMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDateofengagement(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "dateofengagementid" ) UUID dateofengagementId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        serviceFactory.getDateofengagementService().deleteDateofengagement(dateofengagementId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Dateofengagement getDateofengagementById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "dateofengagementid" ) UUID dateofengagementId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
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
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getDateofengagementService().getAllEnrollmentDateofengagements(enrollmentId,startIndex,maxItems); 
	   }

	  // Domestic Violence API 
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public DomesticViolence createDomesticViolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody DomesticViolence domesticViolence,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getDomesticViolenceService().createDomesticViolence(domesticViolence,enrollmentId,session.getAccount().getUsername()); 
	         DomesticViolence returnDomesticViolence = new DomesticViolence();
	         returnDomesticViolence.setDomesticViolenceId(domesticViolence.getDomesticViolenceId());
	         return returnDomesticViolence;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticViolenceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateDomesticViolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "domesticViolenceid" ) UUID domesticViolenceId,@RequestBody DomesticViolence domesticViolence,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        domesticViolence.setDomesticViolenceId(domesticViolenceId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getDomesticViolenceService().updateDomesticViolence(domesticViolence,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticViolenceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteDomesticViolence(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "domesticViolenceid" ) UUID domesticViolenceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getDomesticViolenceService().deleteDomesticViolence(domesticViolenceId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticViolenceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public DomesticViolence getDomesticViolenceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "domesticViolenceid" ) UUID domesticViolenceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getDomesticViolenceService().getDomesticViolenceById(domesticViolenceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/domesticviolences",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE",checkTrustedApp=true,checkSessionToken=true)
	   public DomesticViolences getAllEnrollmentDomesticViolences(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getDomesticViolenceService().getAllEnrollmentDomesticViolences(enrollmentId,startIndex,maxItems); 
	   }

	   
	   // Last Permanent Address API Start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/lastpermanentaddresses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_LASTPERMANENTADDRESS",checkTrustedApp=true,checkSessionToken=true)
	   public LastPermanentAddress createLastPermanentAddress(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody LastPermanentAddress lastPermanentAddress,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getLastPermanentAddressService().createLastPermanentAddress(lastPermanentAddress,enrollmentId,session.getAccount().getUsername()); 
	         LastPermanentAddress returnLastPermanentAddress = new LastPermanentAddress();
	         returnLastPermanentAddress.setLastPermanentAddressId(lastPermanentAddress.getLastPermanentAddressId());
	         return returnLastPermanentAddress;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/lastpermanentaddresses/{lastpermanentaddressid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_LASTPERMANENTADDRESS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateLastPermanentAddress(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "lastpermanentaddressid" ) UUID lastPermanentAddressId,@RequestBody LastPermanentAddress lastPermanentAddress,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        lastPermanentAddress.setLastPermanentAddressId(lastPermanentAddressId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getLastPermanentAddressService().updateLastPermanentAddress(lastPermanentAddress,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/lastpermanentaddresses/{lastpermanentaddressid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_LASTPERMANENTADDRESS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteLastPermanentAddress(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "lastpermanentaddressid" ) UUID lastPermanentAddressId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getLastPermanentAddressService().deleteLastPermanentAddress(lastPermanentAddressId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/lastpermanentaddresses/{lastpermanentaddressid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public LastPermanentAddress getLastPermanentAddressById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "lastpermanentaddressid" ) UUID lastPermanentAddressId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getLastPermanentAddressService().getLastPermanentAddressById(lastPermanentAddressId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/lastpermanentaddresses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS",checkTrustedApp=true,checkSessionToken=true)
	   public LastPermanentAddresses getAllEnrollmentLastPermanentAddresss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getLastPermanentAddressService().getAllEnrollmentLastPermanentAddresss(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   
	   
	   // Youth Critical Issues API start
	   
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/youthcriticalissues",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_YOUTHCRITICALISSUES",checkTrustedApp=true,checkSessionToken=true)
	   public YouthCriticalIssue createYouthCriticalIssues(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody YouthCriticalIssue youthCriticalIssues,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getYouthCriticalIssuesService().createYouthCriticalIssues(youthCriticalIssues,enrollmentId,session.getAccount().getUsername()); 
	         YouthCriticalIssue returnYouthCriticalIssue = new YouthCriticalIssue();
	         returnYouthCriticalIssue.setYouthCriticalIssuesId(youthCriticalIssues.getYouthCriticalIssuesId());
	         return returnYouthCriticalIssue;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/youthcriticalissues/{youthCriticalIssuesid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_YOUTHCRITICALISSUES",checkTrustedApp=true,checkSessionToken=true)
	   public void updateYouthCriticalIssues(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "youthCriticalIssuesid" ) UUID youthCriticalIssuesId,@RequestBody YouthCriticalIssue youthCriticalIssues,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        youthCriticalIssues.setYouthCriticalIssuesId(youthCriticalIssuesId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getYouthCriticalIssuesService().updateYouthCriticalIssues(youthCriticalIssues,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/youthcriticalissues/{youthCriticalIssuesid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_YOUTHCRITICALISSUES",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteYouthCriticalIssues(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "youthCriticalIssuesid" ) UUID youthCriticalIssuesId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getYouthCriticalIssuesService().deleteYouthCriticalIssues(youthCriticalIssuesId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/youthcriticalissues/{youthCriticalIssuesid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_YOUTHCRITICALISSUES_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public YouthCriticalIssue getYouthCriticalIssuesById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "youthCriticalIssuesid" ) UUID youthCriticalIssuesId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getYouthCriticalIssuesService().getYouthCriticalIssuesById(youthCriticalIssuesId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/youthcriticalissues",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_YOUTHCRITICALISSUES",checkTrustedApp=true,checkSessionToken=true)
	   public YouthCriticalIssues getAllEnrollmentYouthCriticalIssuess(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getYouthCriticalIssuesService().getAllEnrollmentYouthCriticalIssuess(enrollmentId,startIndex,maxItems); 
	   }

	   // Worst Housing Situation API start
	      
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/worsthousingsituations",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_WORSTHOUSINGSITUATION",checkTrustedApp=true,checkSessionToken=true)
	   public WorstHousingSituation createWorstHousingSituation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody WorstHousingSituation worstHousingSituation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getWorstHousingSituationService().createWorstHousingSituation(worstHousingSituation,enrollmentId,session.getAccount().getUsername()); 
	         WorstHousingSituation returnWorstHousingSituation = new WorstHousingSituation();
	         returnWorstHousingSituation.setWorstHousingSituationId(worstHousingSituation.getWorstHousingSituationId());
	         return returnWorstHousingSituation;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/worsthousingsituations/{worstHousingSituationid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_WORSTHOUSINGSITUATION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateWorstHousingSituation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "worstHousingSituationid" ) UUID worstHousingSituationId,@RequestBody WorstHousingSituation worstHousingSituation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        worstHousingSituation.setWorstHousingSituationId(worstHousingSituationId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getWorstHousingSituationService().updateWorstHousingSituation(worstHousingSituation,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/worsthousingsituations/{worstHousingSituationid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_WORSTHOUSINGSITUATION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteWorstHousingSituation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "worstHousingSituationid" ) UUID worstHousingSituationId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getWorstHousingSituationService().deleteWorstHousingSituation(worstHousingSituationId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/worsthousingsituations/{worstHousingSituationid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_WORSTHOUSINGSITUATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public WorstHousingSituation getWorstHousingSituationById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "worstHousingSituationid" ) UUID worstHousingSituationId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getWorstHousingSituationService().getWorstHousingSituationById(worstHousingSituationId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/worsthousingsituations",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_WORSTHOUSINGSITUATION",checkTrustedApp=true,checkSessionToken=true)
	   public WorstHousingSituations getAllEnrollmentWorstHousingSituations(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getWorstHousingSituationService().getAllEnrollmentWorstHousingSituations(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	  // Sexualorientation API start
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/sexualorientations",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_SEXUALORIENTATION",checkTrustedApp=true,checkSessionToken=true)
	   public Sexualorientation createSexualorientation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Sexualorientation sexualorientation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getSexualorientationService().createSexualorientation(sexualorientation,enrollmentId,session.getAccount().getUsername()); 
	         Sexualorientation returnSexualorientation = new Sexualorientation();
	         returnSexualorientation.setSexualorientationId(sexualorientation.getSexualorientationId());
	         return returnSexualorientation;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/sexualorientations/{sexualorientationid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_SEXUALORIENTATION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateSexualorientation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "sexualorientationid" ) UUID sexualorientationId,@RequestBody Sexualorientation sexualorientation,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        sexualorientation.setSexualorientationId(sexualorientationId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getSexualorientationService().updateSexualorientation(sexualorientation,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/sexualorientations/{sexualorientationid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_SEXUALORIENTATION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteSexualorientation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "sexualorientationid" ) UUID sexualorientationId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getSexualorientationService().deleteSexualorientation(sexualorientationId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/sexualorientations/{sexualorientationid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_SEXUALORIENTATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Sexualorientation getSexualorientationById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "sexualorientationid" ) UUID sexualorientationId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getSexualorientationService().getSexualorientationById(sexualorientationId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/sexualorientations",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_SEXUALORIENTATION",checkTrustedApp=true,checkSessionToken=true)
	   public Sexualorientations getAllEnrollmentSexualorientations(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getSexualorientationService().getAllEnrollmentSexualorientations(enrollmentId,startIndex,maxItems); 
	   }

	   // School status API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/schoolstatuses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_SCHOOLSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Schoolstatus createSchoolstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Schoolstatus schoolstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getSchoolstatusService().createSchoolstatus(schoolstatus,enrollmentId,session.getAccount().getUsername()); 
	         Schoolstatus returnSchoolstatus = new Schoolstatus();
	         returnSchoolstatus.setSchoolstatusId(schoolstatus.getSchoolstatusId());
	         return returnSchoolstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/schoolstatuses/{schoolstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_SCHOOLSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateSchoolstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "schoolstatusid" ) UUID schoolstatusId,@RequestBody Schoolstatus schoolstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        schoolstatus.setSchoolstatusId(schoolstatusId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getSchoolstatusService().updateSchoolstatus(schoolstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/schoolstatuses/{schoolstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_SCHOOLSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteSchoolstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "schoolstatusid" ) UUID schoolstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getSchoolstatusService().deleteSchoolstatus(schoolstatusId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/schoolstatuses/{schoolstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_SCHOOLSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Schoolstatus getSchoolstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "schoolstatusid" ) UUID schoolstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getSchoolstatusService().getSchoolstatusById(schoolstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/schoolstatuses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_SCHOOLSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Schoolstatuses getAllEnrollmentSchoolstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getSchoolstatusService().getAllEnrollmentSchoolstatuss(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   // Medicalassistances API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public Medicalassistance createMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Medicalassistance medicalassistance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getMedicalassistanceService().createMedicalassistance(medicalassistance,enrollmentId,session.getAccount().getUsername()); 
	         Medicalassistance returnMedicalassistance = new Medicalassistance();
	         returnMedicalassistance.setMedicalassistanceId(medicalassistance.getMedicalassistanceId());
	         return returnMedicalassistance;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,@RequestBody Medicalassistance medicalassistance,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request);
	        medicalassistance.setMedicalassistanceId(medicalassistanceId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getMedicalassistanceService().updateMedicalassistance(medicalassistance,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_MEDICALASSISTANCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteMedicalassistance(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getMedicalassistanceService().deleteMedicalassistance(medicalassistanceId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_MEDICALASSISTANCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Medicalassistance getMedicalassistanceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "medicalassistanceid" ) UUID medicalassistanceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
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
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getMedicalassistanceService().getAllEnrollmentMedicalassistances(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   
	   // Pathstatus API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatus createPathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Pathstatus pathstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getPathstatusService().createPathstatus(pathstatus,enrollmentId,session.getAccount().getUsername()); 
	         Pathstatus returnPathstatus = new Pathstatus();
	         returnPathstatus.setPathstatusId(pathstatus.getPathstatusId());
	         return returnPathstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updatePathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "pathstatusid" ) UUID pathstatusId,@RequestBody Pathstatus pathstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        pathstatus.setPathstatusId(pathstatusId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getPathstatusService().updatePathstatus(pathstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deletePathstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable( "pathstatusid" ) UUID pathstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getPathstatusService().deletePathstatus(pathstatusId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_PATHSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatus getPathstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "pathstatusid" ) UUID pathstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getPathstatusService().getPathstatusById(pathstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/pathstatuses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Pathstatuses getAllEnrollmentPathstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getPathstatusService().getAllEnrollmentPathstatuss(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   
	   // PercentAMI API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/percentamis",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_PERCENTAMI",checkTrustedApp=true,checkSessionToken=true)
	   public Percentami createPercentami(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Percentami percentami,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getPercentamiService().createPercentami(percentami,enrollmentId,session.getAccount().getUsername()); 
	         Percentami returnPercentami=new Percentami();
	         returnPercentami.setPercentamiId(percentami.getPercentamiId());
	         return returnPercentami;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/percentamis/{percentamiid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_PERCENTAMI",checkTrustedApp=true,checkSessionToken=true)
	   public void updatePercentami(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "percentamiid" ) UUID percentamiId,@RequestBody Percentami percentami,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        percentami.setPercentamiId(percentamiId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getPercentamiService().updatePercentami(percentami,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/percentamis/{percentamiid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_PERCENTAMI",checkTrustedApp=true,checkSessionToken=true)
	   public void deletePercentami(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable( "percentamiid" ) UUID percentamiId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getPercentamiService().deletePercentami(percentamiId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/percentamis/{percentamiid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_PERCENTAMI_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Percentami getPercentamiById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "percentamiid" ) UUID percentamiId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getPercentamiService().getPercentamiById(percentamiId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/percentamis",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_PERCENTAMI",checkTrustedApp=true,checkSessionToken=true)
	   public Percentamis getAllEnrollmentPercentamis(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getPercentamiService().getAllEnrollmentPercentamis(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   // Referralsource API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/referralsources",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_REFERRALSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public Referralsource createReferralsource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Referralsource referralsource,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getReferralsourceService().createReferralsource(referralsource,enrollmentId,session.getAccount().getUsername()); 
	         Referralsource returnReferralsource = new Referralsource();
	         returnReferralsource.setReferralsourceId(referralsource.getReferralsourceId());
	         return returnReferralsource;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/referralsources/{referralsourceid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_REFERRALSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateReferralsource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "referralsourceid" ) UUID referralsourceId,@RequestBody Referralsource referralsource,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        referralsource.setReferralsourceId(referralsourceId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getReferralsourceService().updateReferralsource(referralsource,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/referralsources/{referralsourceid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_REFERRALSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteReferralsource(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable( "referralsourceid" ) UUID referralsourceId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getReferralsourceService().deleteReferralsource(referralsourceId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/referralsources/{referralsourceid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_REFERRALSOURCE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Referralsource getReferralsourceById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "referralsourceid" ) UUID referralsourceId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getReferralsourceService().getReferralsourceById(referralsourceId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/referralsources",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_REFERRALSOURCE",checkTrustedApp=true,checkSessionToken=true)
	   public Referralsources getAllEnrollmentReferralsources(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getReferralsourceService().getAllEnrollmentReferralsources(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   // Residentialmoveindates API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveins",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindate createResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Residentialmoveindate residentialmoveindate,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getResidentialmoveindateService().createResidentialmoveindate(residentialmoveindate,enrollmentId,session.getAccount().getUsername()); 
	         Residentialmoveindate returnResidentialmoveindate = new Residentialmoveindate();
	         returnResidentialmoveindate.setResidentialmoveindateId(residentialmoveindate.getResidentialmoveindateId());
	         return returnResidentialmoveindate;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveins/{residentialmoveindateid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public void updateResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,@RequestBody Residentialmoveindate residentialmoveindate,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        residentialmoveindate.setResidentialmoveindateId(residentialmoveindateId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getResidentialmoveindateService().updateResidentialmoveindate(residentialmoveindate,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveins/{residentialmoveindateid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteResidentialmoveindate(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getResidentialmoveindateService().deleteResidentialmoveindate(residentialmoveindateId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveins/{residentialmoveindateid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindate getResidentialmoveindateById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "residentialmoveindateid" ) UUID residentialmoveindateId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getResidentialmoveindateService().getResidentialmoveindateById(residentialmoveindateId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/residentialmoveins",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE",checkTrustedApp=true,checkSessionToken=true)
	   public Residentialmoveindates getAllEnrollmentResidentialmoveindates(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getResidentialmoveindateService().getAllEnrollmentResidentialmoveindates(enrollmentId,startIndex,maxItems); 
	   }
	   
	   // Rhybcpstatus API Start
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatus createRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Rhybcpstatus rhybcpstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getRhybcpstatusService().createRhybcpstatus(rhybcpstatus,enrollmentId,session.getAccount().getUsername()); 
	         Rhybcpstatus returnRhybcpstatus = new Rhybcpstatus();
	         returnRhybcpstatus.setRhybcpstatusId(rhybcpstatus.getRhybcpstatusId());
	         return returnRhybcpstatus;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void updateRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,@RequestBody Rhybcpstatus rhybcpstatus,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        rhybcpstatus.setRhybcpstatusId(rhybcpstatusId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getRhybcpstatusService().updateRhybcpstatus(rhybcpstatus,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteRhybcpstatus(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getRhybcpstatusService().deleteRhybcpstatus(rhybcpstatusId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_RHYBCPSTATUS_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatus getRhybcpstatusById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "rhybcpstatusid" ) UUID rhybcpstatusId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getRhybcpstatusService().getRhybcpstatusById(rhybcpstatusId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS",checkTrustedApp=true,checkSessionToken=true)
	   public Rhybcpstatuses getAllEnrollmentRhybcpstatuss(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getRhybcpstatusService().getAllEnrollmentRhybcpstatuss(enrollmentId,startIndex,maxItems); 
	   }

	   
	   // NonCashBenifits API start
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefits",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_NONCASHBENEFIT",checkTrustedApp=true,checkSessionToken=true)
	   public NonCashBenefit createNonCashBenefit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody NonCashBenefit nonCashBenefit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getNonCashBenefitService().createNonCashBenefit(nonCashBenefit,enrollmentId,session.getAccount().getUsername()); 
	         NonCashBenefit returnNonCashBenefit = new NonCashBenefit();
	         returnNonCashBenefit.setNonCashBenefitId(nonCashBenefit.getNonCashBenefitId());
	         return returnNonCashBenefit;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{nonCashBenefitid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_NONCASHBENEFIT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateNonCashBenefit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "nonCashBenefitid" ) UUID nonCashBenefitId,@RequestBody NonCashBenefit nonCashBenefit,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        nonCashBenefit.setNonCashBenefitId(nonCashBenefitId);
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getNonCashBenefitService().updateNonCashBenefit(nonCashBenefit,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{nonCashBenefitid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_NONCASHBENEFIT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteNonCashBenefit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable( "nonCashBenefitid" ) UUID nonCashBenefitId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	         serviceFactory.getNonCashBenefitService().deleteNonCashBenefit(nonCashBenefitId,session.getAccount().getUsername()); 
	         response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{nonCashBenefitid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_NONCASHBENEFIT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public NonCashBenefit getNonCashBenefitById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "nonCashBenefitid" ) UUID nonCashBenefitId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getNonCashBenefitService().getNonCashBenefitById(nonCashBenefitId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/noncashbenefits",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFIT",checkTrustedApp=true,checkSessionToken=true)
	   public NonCashBenefits getAllEnrollmentNonCashBenefits(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId,false); 
	        return serviceFactory.getNonCashBenefitService().getAllEnrollmentNonCashBenefits(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
}
