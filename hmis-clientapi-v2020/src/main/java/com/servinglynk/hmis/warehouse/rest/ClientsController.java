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
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Clients;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.core.model.Connectionwithsoars;
import com.servinglynk.hmis.warehouse.core.model.Contact;
import com.servinglynk.hmis.warehouse.core.model.Contacts;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolences;
import com.servinglynk.hmis.warehouse.core.model.Education;
import com.servinglynk.hmis.warehouse.core.model.Educations;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.Entryrhsp;
import com.servinglynk.hmis.warehouse.core.model.Entryrhsps;
import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
import com.servinglynk.hmis.warehouse.core.model.Entryrhys;
import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.core.model.Entryssvfs;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessment;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessments;
import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.core.model.Exitrhys;
import com.servinglynk.hmis.warehouse.core.model.Exits;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurances;
import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDispositions;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSources;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.core.model.NoncashbenefitsList;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Pathstatuses;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCare;
import com.servinglynk.hmis.warehouse.core.model.RhyAfterCares;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
import com.servinglynk.hmis.warehouse.core.model.Servicefareferral;
import com.servinglynk.hmis.warehouse.core.model.Servicefareferrals;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.VashExitReason;
import com.servinglynk.hmis.warehouse.core.model.VashExitReasons;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfos;

@RestController
@RequestMapping("/clients")
public class ClientsController extends ControllerBase {

	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_CLIENT", checkSessionToken = true, checkTrustedApp = true)
	public Client createClient(@Valid @RequestBody Client client, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().createClient(client, session.getAccount().getUsername());
		Client returnClient = new Client();
		returnClient.setClientId(client.getClientId());
		returnClient.setDedupClientId(client.getDedupClientId());
		return returnClient;
	}

	@RequestMapping(value = "/{clientid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_CLIENT", checkSessionToken = true, checkTrustedApp = true)
	public void updateClient(@PathVariable("clientid") UUID clientId,@Valid @RequestBody Client client,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		client.setClientId(clientId);
		serviceFactory.getClientService().updateClient(client, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_CLIENT", checkSessionToken = true, checkTrustedApp = true)
	public void deleteClient(@PathVariable("clientid") UUID clientId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().deleteClient(clientId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_CLIENT_BY_ID", checkSessionToken = true, checkTrustedApp = true)
	public Client getClientById(@PathVariable("clientid") UUID clientId, HttpServletRequest request) throws Exception {
		return serviceFactory.getClientService().getClientById(clientId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_CLIENTS", checkSessionToken = true, checkTrustedApp = true)
	public Clients getAllClien(@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {

		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		Session session = sessionHelper.getSession(request);
         Account account = serviceFactory.getAccountService().getAccount(session.getAccount(),false);
		return serviceFactory.getClientService().getAllClients(account.getProjectGroup().getProjectGroupCode(), startIndex,
				maxItems);
	}
	
	@RequestMapping(value = "/{clientid}/enrollments", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_ENROLLMENT", checkSessionToken = true, checkTrustedApp = true)
	public Enrollment createEnrollment(@RequestBody Enrollment enrollment, @PathVariable("clientid") UUID clientId,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getEnrollmentService().createEnrollment(enrollment, clientId,
				session.getAccount().getUsername());
		Enrollment returnEnrollment = new Enrollment();
		returnEnrollment.setEnrollmentId(enrollment.getEnrollmentId());
		return returnEnrollment;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_ENROLLMENT", checkSessionToken = true, checkTrustedApp = true)
	public void updateEnrollment(@RequestBody Enrollment enrollment, @PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		enrollment.setEnrollmentId(enrollmentId);
		serviceFactory.getEnrollmentService().updateEnrollment(enrollment, clientId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_ENROLLMENT", checkSessionToken = true, checkTrustedApp = true)
	public void deleteEnrollment(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getEnrollmentService().deleteEnrollment(enrollmentId, clientId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ENROLLMENT_BY_ID", checkSessionToken = true, checkTrustedApp = true)
	public Enrollment getClientEnrollmentById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentServiceV2().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
	}
	
	@RequestMapping(value = "/{clientid}/enrollments", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS", checkSessionToken = true, checkTrustedApp = true)
	public Enrollments getAllClientEnrollments(@PathVariable("clientid") UUID clientId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		return serviceFactory.getEnrollmentServiceV2().getEnrollmentsByClientId(clientId,
				session.getAccount().getUsername(), startIndex, maxItems);
	}
	@RequestMapping(value="/enrollments/{enrollmentid}",method=RequestMethod.GET)
	@APIMapping(value="GET_ENROLLMENT_BY_ID",checkSessionToken=true,checkTrustedApp=true)
	public Enrollment getEnrollmentById(@PathVariable("enrollmentid") UUID enrollmentId ,
			@RequestParam(value="includeChildLinks",required=false,defaultValue="false") boolean includeChildLinks,	
			HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().getEnrollmentByEnrollmentId(enrollmentId,includeChildLinks);
	}
	
	

	// Veteran Info API Start

	@RequestMapping(value = "/{clientid}/veteraninfos", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_VETERANINFO", checkTrustedApp = true, checkSessionToken = true)
	public VeteranInfo createVeteranInfo(@PathVariable("clientid") UUID clientId, @RequestBody VeteranInfo veteranInfo,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getVeteranInfoService().createVeteranInfo(veteranInfo, clientId,
				session.getAccount().getUsername());
		VeteranInfo returnVeteranInfo = new VeteranInfo();
		returnVeteranInfo.setVeteranInfoId(veteranInfo.getVeteranInfoId());
		return returnVeteranInfo;
	}

	@RequestMapping(value = "/{clientid}/veteraninfos/{veteranInfoid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_VETERANINFO", checkTrustedApp = true, checkSessionToken = true)
	public void updateVeteranInfo(@PathVariable("clientid") UUID clientId,
			@PathVariable("veteranInfoid") UUID veteranInfoId, @RequestBody VeteranInfo veteranInfo,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		veteranInfo.setVeteranInfoId(veteranInfoId);
		serviceFactory.getVeteranInfoService().updateVeteranInfo(veteranInfo, clientId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/veteraninfos/{veteranInfoid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_VETERANINFO", checkTrustedApp = true, checkSessionToken = true)
	public void deleteVeteranInfo(@PathVariable("clientid") UUID clientId,
			@PathVariable("veteranInfoid") UUID veteranInfoId, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		Session session = sessionHelper.getSession(request);
		serviceFactory.getVeteranInfoService().deleteVeteranInfo(veteranInfoId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/veteraninfos/{veteranInfoid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_VETERANINFO_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public VeteranInfo getVeteranInfoById(@PathVariable("clientid") UUID clientId,
			@PathVariable("veteranInfoid") UUID veteranInfoId, HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		return serviceFactory.getVeteranInfoService().getVeteranInfoById(veteranInfoId);
	}

	@RequestMapping(value = "/{clientid}/veteraninfos", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_CLIENT_VETERANINFOS", checkTrustedApp = true, checkSessionToken = true)
	public VeteranInfos getAllEnrollmentVeteranInfos(@PathVariable("clientid") UUID clientId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;
		serviceFactory.getClientService().getClientById(clientId);
		return serviceFactory.getVeteranInfoService().getAllClientVeteranInfos(clientId, startIndex, maxItems);

	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/employments", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_EMPLOYMENT", checkTrustedApp = true, checkSessionToken = true)
	public Employment createEmployment(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Employment employment,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEmploymentService().createEmployment(employment, enrollmentId,
				session.getAccount().getUsername());
		Employment returnemployment = new Employment();
		returnemployment.setEmploymentId(employment.getEmploymentId());
		return returnemployment;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_EMPLOYMENT", checkTrustedApp = true, checkSessionToken = true)
	public void updateEmployment(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("employmentid") UUID employmentId,
			@RequestBody Employment employment, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		employment.setEmploymentId(employmentId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEmploymentService().updateEmployment(employment, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_EMPLOYMENT", checkTrustedApp = true, checkSessionToken = true)
	public void deleteEmployment(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("employmentid") UUID employmentId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getEmploymentService().deleteEmployment(employmentId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_EMPLOYMENT_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Employment getEmploymentById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("employmentid") UUID employmentId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEmploymentService().getEmploymentById(employmentId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/employments", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENT", checkTrustedApp = true, checkSessionToken = true)
	public Employments getAllEnrollmentEmployments(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEmploymentService().getAllEnrollmentEmployments(enrollmentId, startIndex, maxItems);
	}

	
	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/connectionwithsoar", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_CONNECTIONWITHSOAR", checkTrustedApp = true, checkSessionToken = true)
	public Connectionwithsoar createConnectionwithSoar(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Connectionwithsoar connectionwithsoar,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getConnectionwithsoarService().createConnectionwithsoar(connectionwithsoar, enrollmentId,
				session.getAccount().getUsername());
		Connectionwithsoar returnConnectionwithsoar = new Connectionwithsoar();
		returnConnectionwithsoar.setConnectionwithsoarId(connectionwithsoar.getConnectionwithsoarId());
		return returnConnectionwithsoar;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/connectionwithsoars/{connectionwithsoarid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_CONNECTIONWITHSOAR", checkTrustedApp = true, checkSessionToken = true)
	public void updateConnectionwithsoars(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("connectionwithsoarid") UUID connectionwithsoarid,
			@RequestBody Connectionwithsoar connectionwithsoar, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		connectionwithsoar.setConnectionwithsoarId(connectionwithsoarid);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getConnectionwithsoarService().updateConnectionwithsoar(connectionwithsoar, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/connectionwithsoars/{connectionwithsoarid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_CONNECTIONWITHSOAR", checkTrustedApp = true, checkSessionToken = true)
	public void deleteConnectionwithsoar(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("connectionwithsoarid") UUID connectionwithsoarid,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getConnectionwithsoarService().deleteConnectionwithsoar(connectionwithsoarid, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/connectionwithsoars/{connectionwithsoarid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_CONNECTIONWITHSOAR_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Connectionwithsoar getConnectionwithsoarById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("connectionwithsoarid") UUID connectionwithsoarid,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getConnectionwithsoarService().getConnectionwithsoarById(connectionwithsoarid);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/connectionwithsoars", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_CONNECTIONWITHSOAR", checkTrustedApp = true, checkSessionToken = true)
	public Connectionwithsoars getAllEnrollmentConnectionwithsoars(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getConnectionwithsoarService().getAllEnrollmentConnectionwithsoars(enrollmentId, startIndex, maxItems);
	}

	
	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/dateofengagements", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_DATEOFENGAGEMENT", checkTrustedApp = true, checkSessionToken = true)
	public Dateofengagement createDateofengagement(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Dateofengagement dateofengagement,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDateofengagementService().createDateofengagement(dateofengagement, enrollmentId,
				session.getAccount().getUsername());
		Dateofengagement returndateofengagement = new Dateofengagement();
		returndateofengagement.setDateofengagementId(dateofengagement.getDateofengagementId());
		return returndateofengagement;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_DATEOFENGAGEMENT", checkTrustedApp = true, checkSessionToken = true)
	public void updateDateofengagement(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("dateofengagementid") UUID dateofengagementId, @RequestBody Dateofengagement dateofengagement,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		dateofengagement.setDateofengagementId(dateofengagementId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDateofengagementService().updateDateofengagement(dateofengagement, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_DATEOFENGAGEMENT", checkTrustedApp = true, checkSessionToken = true)
	public void deleteDateofengagement(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("dateofengagementid") UUID dateofengagementId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getDateofengagementService().deleteDateofengagement(dateofengagementId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/dateofengagements/{dateofengagementid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Dateofengagement getDateofengagementById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("dateofengagementid") UUID dateofengagementId, HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDateofengagementService().getDateofengagementById(dateofengagementId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/dateofengagements", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT", checkTrustedApp = true, checkSessionToken = true)
	public Dateofengagements getAllEnrollmentDateofengagements(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDateofengagementService().getAllEnrollmentDateofengagements(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/disabilities", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_DISABILITIES", checkTrustedApp = true, checkSessionToken = true)
	public Disabilities createDisabilities(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Disabilities disabilities,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDisabilitiesService().createDisabilities(disabilities, enrollmentId,
				session.getAccount().getUsername());
		Disabilities returndisabilities = new Disabilities();
		returndisabilities.setDisabilitiesId(disabilities.getDisabilitiesId());
		return returndisabilities;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_DISABILITIES", checkTrustedApp = true, checkSessionToken = true)
	public void updateDisabilities(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("disabilitiesid") UUID disabilitiesId,
			@RequestBody Disabilities disabilities, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		disabilities.setDisabilitiesId(disabilitiesId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDisabilitiesService().updateDisabilities(disabilities, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_DISABILITIES", checkTrustedApp = true, checkSessionToken = true)
	public void deleteDisabilities(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("disabilitiesid") UUID disabilitiesId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getDisabilitiesService().deleteDisabilities(disabilitiesId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilitiesid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_DISABILITIES_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Disabilities getDisabilitiesById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("disabilitiesid") UUID disabilitiesId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDisabilitiesService().getDisabilitiesById(disabilitiesId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/disabilities", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES", checkTrustedApp = true, checkSessionToken = true)
	public DisabilitiesList getAllEnrollmentDisabilitiess(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDisabilitiesService().getAllEnrollmentDisabilitiess(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/domesticviolences", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_DOMESTICVIOLENCE", checkTrustedApp = true, checkSessionToken = true)
	public Domesticviolence createDomesticviolence(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Domesticviolence domesticviolence,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDomesticviolenceService().createDomesticviolence(domesticviolence, enrollmentId,
				session.getAccount().getUsername());
		Domesticviolence returndomesticviolence = new Domesticviolence();
		returndomesticviolence.setDomesticviolenceId(domesticviolence.getDomesticviolenceId());
		return returndomesticviolence;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_DOMESTICVIOLENCE", checkTrustedApp = true, checkSessionToken = true)
	public void updateDomesticviolence(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("domesticviolenceid") UUID domesticviolenceId, @RequestBody Domesticviolence domesticviolence,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		domesticviolence.setDomesticviolenceId(domesticviolenceId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getDomesticviolenceService().updateDomesticviolence(domesticviolence, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_DOMESTICVIOLENCE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteDomesticviolence(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("domesticviolenceid") UUID domesticviolenceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getDomesticviolenceService().deleteDomesticviolence(domesticviolenceId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/domesticviolences/{domesticviolenceid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Domesticviolence getDomesticviolenceById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("domesticviolenceid") UUID domesticviolenceId, HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDomesticviolenceService().getDomesticviolenceById(domesticviolenceId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/domesticviolences", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE", checkTrustedApp = true, checkSessionToken = true)
	public Domesticviolences getAllEnrollmentDomesticviolences(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getDomesticviolenceService().getAllEnrollmentDomesticviolences(enrollmentId, startIndex,
				maxItems);
	}

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
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
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
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
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
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEnrollmentCocService().getAllEnrollmentEnrollmentCocs(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthinsurances", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_HEALTHINSURANCE", checkTrustedApp = true, checkSessionToken = true)
	public Healthinsurance createHealthinsurance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Healthinsurance healthinsurance,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHealthinsuranceService().createHealthinsurance(healthinsurance, enrollmentId,
				session.getAccount().getUsername());
		Healthinsurance returnhealthinsurance = new Healthinsurance();
		returnhealthinsurance.setHealthinsuranceId(healthinsurance.getHealthinsuranceId());
		return returnhealthinsurance;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_HEALTHINSURANCE", checkTrustedApp = true, checkSessionToken = true)
	public void updateHealthinsurance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthinsuranceid") UUID healthinsuranceId,
			@RequestBody Healthinsurance healthinsurance, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		healthinsurance.setHealthinsuranceId(healthinsuranceId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHealthinsuranceService().updateHealthinsurance(healthinsurance, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_HEALTHINSURANCE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteHealthinsurance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthinsuranceid") UUID healthinsuranceId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getHealthinsuranceService().deleteHealthinsurance(healthinsuranceId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_HEALTHINSURANCE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Healthinsurance getHealthinsuranceById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthinsuranceid") UUID healthinsuranceId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getHealthinsuranceService().getHealthinsuranceById(healthinsuranceId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthinsurances", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE", checkTrustedApp = true, checkSessionToken = true)
	public Healthinsurances getAllEnrollmentHealthinsurances(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getHealthinsuranceService().getAllEnrollmentHealthinsurances(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/medicalassistances", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_MEDICALASSISTANCE", checkTrustedApp = true, checkSessionToken = true)
	public Medicalassistance createMedicalassistance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Medicalassistance medicalassistance,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getMedicalassistanceService().createMedicalassistance(medicalassistance, enrollmentId,
				session.getAccount().getUsername());
		Medicalassistance returnmedicalassistance = new Medicalassistance();
		returnmedicalassistance.setMedicalassistanceId(medicalassistance.getMedicalassistanceId());
		return returnmedicalassistance;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_MEDICALASSISTANCE", checkTrustedApp = true, checkSessionToken = true)
	public void updateMedicalassistance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("medicalassistanceid") UUID medicalassistanceId,
			@RequestBody Medicalassistance medicalassistance, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		medicalassistance.setMedicalassistanceId(medicalassistanceId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getMedicalassistanceService().updateMedicalassistance(medicalassistance, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_MEDICALASSISTANCE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteMedicalassistance(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("medicalassistanceid") UUID medicalassistanceId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getMedicalassistanceService().deleteMedicalassistance(medicalassistanceId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/medicalassistances/{medicalassistanceid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_MEDICALASSISTANCE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Medicalassistance getMedicalassistanceById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("medicalassistanceid") UUID medicalassistanceId, HttpServletRequest request)
					throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getMedicalassistanceService().getMedicalassistanceById(medicalassistanceId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/medicalassistances", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE", checkTrustedApp = true, checkSessionToken = true)
	public Medicalassistances getAllEnrollmentMedicalassistances(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getMedicalassistanceService().getAllEnrollmentMedicalassistances(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/noncashbenefits", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_NONCASHBENEFITS", checkTrustedApp = true, checkSessionToken = true)
	public Noncashbenefits createNoncashbenefits(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Noncashbenefits noncashbenefits,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getNoncashbenefitsService().createNoncashbenefits(noncashbenefits, enrollmentId,
				session.getAccount().getUsername());
		Noncashbenefits returnnoncashbenefits = new Noncashbenefits();
		returnnoncashbenefits.setNoncashbenefitsID(noncashbenefits.getNoncashbenefitsID());
		return returnnoncashbenefits;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitsid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_NONCASHBENEFITS", checkTrustedApp = true, checkSessionToken = true)
	public void updateNoncashbenefits(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("noncashbenefitsid") UUID noncashbenefitsId,
			@RequestBody Noncashbenefits noncashbenefits, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		noncashbenefits.setNoncashbenefitsID(noncashbenefitsId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getNoncashbenefitsService().updateNoncashbenefits(noncashbenefits, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitsid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_NONCASHBENEFITS", checkTrustedApp = true, checkSessionToken = true)
	public void deleteNoncashbenefits(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("noncashbenefitsid") UUID noncashbenefitsId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getNoncashbenefitsService().deleteNoncashbenefits(noncashbenefitsId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitsid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_NONCASHBENEFITS_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Noncashbenefits getNoncashbenefitsById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("noncashbenefitsid") UUID noncashbenefitsId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getNoncashbenefitsService().getNoncashbenefitsById(noncashbenefitsId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/noncashbenefits", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFITS", checkTrustedApp = true, checkSessionToken = true)
	public NoncashbenefitsList getAllEnrollmentNoncashbenefitss(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getNoncashbenefitsService().getAllEnrollmentNoncashbenefitss(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/pathstatuses", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_PATHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Pathstatus createPathstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Pathstatus pathstatus,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getPathstatusService().createPathstatus(pathstatus, enrollmentId,
				session.getAccount().getUsername());
		Pathstatus returnpathstatus = new Pathstatus();
		returnpathstatus.setPathstatusId(pathstatus.getPathstatusId());
		return returnpathstatus;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_PATHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void updatePathstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("pathstatusid") UUID pathstatusId,
			@RequestBody Pathstatus pathstatus, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		pathstatus.setPathstatusId(pathstatusId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getPathstatusService().updatePathstatus(pathstatus, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_PATHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void deletePathstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("pathstatusid") UUID pathstatusId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getPathstatusService().deletePathstatus(pathstatusId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/pathstatuses/{pathstatusid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_PATHSTATUS_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Pathstatus getPathstatusById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("pathstatusid") UUID pathstatusId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getPathstatusService().getPathstatusById(pathstatusId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/pathstatuses", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Pathstatuses getAllEnrollmentPathstatuss(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getPathstatusService().getAllEnrollmentPathstatuss(enrollmentId, startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/residentialmoveindates", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_RESIDENTIALMOVEINDATE", checkTrustedApp = true, checkSessionToken = true)
	public Residentialmoveindate createResidentialmoveindate(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Residentialmoveindate residentialmoveindate,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getResidentialmoveindateService().createResidentialmoveindate(residentialmoveindate,
				enrollmentId, session.getAccount().getUsername());
		Residentialmoveindate returnresidentialmoveindate = new Residentialmoveindate();
		returnresidentialmoveindate.setResidentialmoveindateId(residentialmoveindate.getResidentialmoveindateId());
		return returnresidentialmoveindate;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE", checkTrustedApp = true, checkSessionToken = true)
	public void updateResidentialmoveindate(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("residentialmoveindateid") UUID residentialmoveindateId,
			@RequestBody Residentialmoveindate residentialmoveindate, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		residentialmoveindate.setResidentialmoveindateId(residentialmoveindateId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getResidentialmoveindateService().updateResidentialmoveindate(residentialmoveindate,
				enrollmentId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_RESIDENTIALMOVEINDATE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteResidentialmoveindate(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("residentialmoveindateid") UUID residentialmoveindateId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getResidentialmoveindateService().deleteResidentialmoveindate(residentialmoveindateId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/residentialmoveindates/{residentialmoveindateid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Residentialmoveindate getResidentialmoveindateById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("residentialmoveindateid") UUID residentialmoveindateId, HttpServletRequest request)
					throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getResidentialmoveindateService().getResidentialmoveindateById(residentialmoveindateId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/residentialmoveindates", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE", checkTrustedApp = true, checkSessionToken = true)
	public Residentialmoveindates getAllEnrollmentResidentialmoveindates(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getResidentialmoveindateService().getAllEnrollmentResidentialmoveindates(enrollmentId,
				startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthstatuses", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_HEALTHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Healthstatus createHealthstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Healthstatus healthstatus,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHealthstatusService().createHealthstatus(healthstatus, enrollmentId,
				session.getAccount().getUsername());
		Healthstatus returnhealthstatus = new Healthstatus();
		returnhealthstatus.setHealthstatusId(healthstatus.getHealthstatusId());
		return returnhealthstatus;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_HEALTHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void updateHealthstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthstatusid") UUID healthstatusId,
			@RequestBody Healthstatus healthstatus, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		healthstatus.setHealthstatusId(healthstatusId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHealthstatusService().updateHealthstatus(healthstatus, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_HEALTHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void deleteHealthstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthstatusid") UUID healthstatusId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getHealthstatusService().deleteHealthstatus(healthstatusId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_HEALTHSTATUS_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Healthstatus getHealthstatusById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("healthstatusid") UUID healthstatusId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getHealthstatusService().getHealthstatusById(healthstatusId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/healthstatuses", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Healthstatuses getAllEnrollmentHealthstatuss(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getHealthstatusService().getAllEnrollmentHealthstatuss(enrollmentId, startIndex,
				maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_RHYBCPSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Rhybcpstatus createRhybcpstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Rhybcpstatus rhybcpstatus,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getRhybcpstatusService().createRhybcpstatus(rhybcpstatus, enrollmentId,
				session.getAccount().getUsername());
		Rhybcpstatus returnrhybcpstatus = new Rhybcpstatus();
		returnrhybcpstatus.setRhybcpstatusId(rhybcpstatus.getRhybcpstatusId());
		return returnrhybcpstatus;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_RHYBCPSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void updateRhybcpstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("rhybcpstatusid") UUID rhybcpstatusId,
			@RequestBody Rhybcpstatus rhybcpstatus, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		rhybcpstatus.setRhybcpstatusId(rhybcpstatusId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getRhybcpstatusService().updateRhybcpstatus(rhybcpstatus, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_RHYBCPSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public void deleteRhybcpstatus(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("rhybcpstatusid") UUID rhybcpstatusId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getRhybcpstatusService().deleteRhybcpstatus(rhybcpstatusId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses/{rhybcpstatusid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_RHYBCPSTATUS_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Rhybcpstatus getRhybcpstatusById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("rhybcpstatusid") UUID rhybcpstatusId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getRhybcpstatusService().getRhybcpstatusById(rhybcpstatusId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/rhybcpstatuses", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS", checkTrustedApp = true, checkSessionToken = true)
	public Rhybcpstatuses getAllEnrollmentRhybcpstatuss(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getRhybcpstatusService().getAllEnrollmentRhybcpstatuss(enrollmentId, startIndex,
				maxItems);
	}

	// IncomeAndSources API

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/incomeandsources", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_INCOMEANDSOURCE", checkTrustedApp = true, checkSessionToken = true)
	public IncomeAndSource createIncomeAndSource(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody IncomeAndSource incomeAndSource,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getIncomeAndSourceService().createIncomeAndSource(incomeAndSource, enrollmentId,
				session.getAccount().getUsername());
		IncomeAndSource returnIncomeAndSource = new IncomeAndSource();
		returnIncomeAndSource.setIncomeAndSourceId(incomeAndSource.getIncomeAndSourceId());
		return returnIncomeAndSource;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_INCOMEANDSOURCE", checkTrustedApp = true, checkSessionToken = true)
	public void updateIncomeAndSource(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("incomeAndSourceid") UUID incomeAndSourceId,
			@RequestBody IncomeAndSource incomeAndSource, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		incomeAndSource.setIncomeAndSourceId(incomeAndSourceId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getIncomeAndSourceService().updateIncomeAndSource(incomeAndSource, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_INCOMEANDSOURCE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteIncomeAndSource(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("incomeAndSourceid") UUID incomeAndSourceId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getIncomeAndSourceService().deleteIncomeAndSource(incomeAndSourceId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_INCOMEANDSOURCE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public IncomeAndSource getIncomeAndSourceById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("incomeAndSourceid") UUID incomeAndSourceId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getIncomeAndSourceService().getIncomeAndSourceById(incomeAndSourceId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/incomeandsources", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE", checkTrustedApp = true, checkSessionToken = true)
	public IncomeAndSources getAllEnrollmentIncomeAndSources(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getIncomeAndSourceService().getAllEnrollmentIncomeAndSources(enrollmentId, startIndex,
				maxItems);
	}

	// Exits API start

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_EXIT", checkTrustedApp = true, checkSessionToken = true)
	public Exit createExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@RequestBody Exit exit, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		// exit.setEnrollment(enrollmentId);
		serviceFactory.getExitService().createExit(exit, enrollmentId, session.getAccount().getUsername());
		Exit returnExit = new Exit();
		returnExit.setExitId(exit.getExitId());
		return returnExit;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_EXIT", checkTrustedApp = true, checkSessionToken = true)
	public void updateExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId, @RequestBody Exit exit, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		exit.setExitId(exitId);
		serviceFactory.getClientService().getClientById(clientId);
		// exit.setEnrollment(enrollmentId);
		serviceFactory.getExitService().updateExit(exit, enrollmentId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_EXIT", checkTrustedApp = true, checkSessionToken = true)
	public void deleteExit(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().deleteExit(exitId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_EXIT_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Exit getExitById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId, HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getExitService().getExitById(exitId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_EXITS", checkTrustedApp = true, checkSessionToken = true)
	public Exits getAllEnrollmentExits(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getExitService().getAllEnrollmentExits(enrollmentId, startIndex, maxItems);
	}

	// Housing Assessment Dispositions API start

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_HOUSINGASSESSMENTDISPOSITION", checkTrustedApp = true, checkSessionToken = true)
	public HousingAssessmentDisposition createHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@RequestBody HousingAssessmentDisposition housingAssessmentDisposition, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHousingAssessmentDispositionService().createHousingAssessmentDisposition(
				housingAssessmentDisposition, exitId, session.getAccount().getUsername());
		HousingAssessmentDisposition returnHousingAssessmentDisposition = new HousingAssessmentDisposition();
		returnHousingAssessmentDisposition
				.setHousingAssessmentDispositionId(housingAssessmentDisposition.getHousingAssessmentDispositionId());
		return returnHousingAssessmentDisposition;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_HOUSINGASSESSMENTDISPOSITION", checkTrustedApp = true, checkSessionToken = true)
	public void updateHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@PathVariable("housingAssessmentDispositionid") UUID housingAssessmentDispositionId,
			@RequestBody HousingAssessmentDisposition housingAssessmentDisposition, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		housingAssessmentDisposition.setHousingAssessmentDispositionId(housingAssessmentDispositionId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getHousingAssessmentDispositionService().updateHousingAssessmentDisposition(
				housingAssessmentDisposition, exitId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_HOUSINGASSESSMENTDISPOSITION", checkTrustedApp = true, checkSessionToken = true)
	public void deleteHousingAssessmentDisposition(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@PathVariable("housingAssessmentDispositionid") UUID housingAssessmentDispositionId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().getExitById(exitId);
		serviceFactory.getHousingAssessmentDispositionService()
				.deleteHousingAssessmentDisposition(housingAssessmentDispositionId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions/{housingAssessmentDispositionid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_HOUSINGASSESSMENTDISPOSITION_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public HousingAssessmentDisposition getHousingAssessmentDispositionById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@PathVariable("housingAssessmentDispositionid") UUID housingAssessmentDispositionId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getHousingAssessmentDispositionService()
				.getHousingAssessmentDispositionById(housingAssessmentDispositionId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/housingassessmentdispositions", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_EXIT_HOUSINGASSESSMENTDISPOSITION", checkTrustedApp = true, checkSessionToken = true)
	public HousingAssessmentDispositions getAllEnrollmentHousingAssessmentDispositions(
			@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getHousingAssessmentDispositionService()
				.getAllEnrollmentHousingAssessmentDispositions(exitId, startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_EXITRHY", checkTrustedApp = true, checkSessionToken = true)
	public Exitrhy createExitrhy(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@RequestBody Exitrhy exitrhy, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getExitrhyService().createExitrhy(exitrhy, exitId, session.getAccount().getUsername());
		Exitrhy returnexitrhy = new Exitrhy();
		returnexitrhy.setExitrhyId(exitrhy.getExitrhyId());
		return returnexitrhy;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys/{exitrhyid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_EXITRHY", checkTrustedApp = true, checkSessionToken = true)
	public void updateExitrhy(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId, @PathVariable("exitrhyid") UUID exitrhyId,
			@RequestBody Exitrhy exitrhy, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		exitrhy.setExitrhyId(exitrhyId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getExitrhyService().updateExitrhy(exitrhy, exitId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys/{exitrhyid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_EXITRHY", checkTrustedApp = true, checkSessionToken = true)
	public void deleteExitrhy(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("exitid") UUID exitId, @PathVariable("exitrhyid") UUID exitrhyId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitrhyService().deleteExitrhy(exitrhyId, session.getAccount().getUsername());
		serviceFactory.getExitService().getExitById(exitId);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys/{exitrhyid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_EXITRHY_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Exitrhy getExitrhyById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@PathVariable("exitrhyid") UUID exitrhyId, HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getExitrhyService().getExitrhyById(exitrhyId);
	}
	
	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exitrhys", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_EXITRHY", checkTrustedApp = true, checkSessionToken = true)
	public Exitrhys getAllEnrollmentExitrhys(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("exitid") UUID exitId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getExitrhyService().getAllExitExitrhys(exitId, startIndex, maxItems);
	}

	@RequestMapping(value = "/exits/{exitid}/rhyaftercares/", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_EXIT_RHYAFTERCARE", checkTrustedApp = true, checkSessionToken = true)
	public RhyAfterCares getAllExitsRhyAfterCares(
			 @PathVariable("exitid") UUID exitId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getRHYAfterCareService().getAllExitRhyAfterCares(exitId, startIndex, maxItems);
	}

	@RequestMapping(value = "/exits/{exitid}/rhyaftercares", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_RHYAFTERCARE", checkTrustedApp = true, checkSessionToken = true)
	public RhyAfterCare createRhyAfterCare(
			 @PathVariable("exitid") UUID exitId,
			@RequestBody RhyAfterCare rhyAfterCare, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getRHYAfterCareService().createRhyAfterCare(rhyAfterCare, exitId, session.getAccount().getUsername());
		RhyAfterCare returnRhyAfterCare = new RhyAfterCare();
		returnRhyAfterCare.setRhyAfterCareId(rhyAfterCare.getRhyAfterCareId());
		return returnRhyAfterCare;
	}

	@RequestMapping(value = "/exits/{exitid}/rhyaftercares/{rhyaftercareid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_RHYAFTERCARE", checkTrustedApp = true, checkSessionToken = true)
	public void updateRhyAfterCare(@PathVariable("rhyaftercareid") UUID rhyaftercareid,
			@PathVariable("exitid") UUID exitId,
			@RequestBody RhyAfterCare rhyAfterCare, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		rhyAfterCare.setRhyAfterCareId(rhyaftercareid);
		serviceFactory.getRHYAfterCareService().updateRhyAfterCare(rhyAfterCare, exitId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/exits/{exitid}/rhyaftercares/{rhyaftercareid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_RHYAFTERCARE", checkTrustedApp = true, checkSessionToken = true)
	public void deleteRhyAfterCare(@PathVariable("rhyaftercareid") UUID rhyaftercareid,
			@PathVariable("exitid") UUID exitId,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getRHYAfterCareService().deleteRhyAfterCare(rhyaftercareid, session.getAccount().getUsername());
		serviceFactory.getExitService().getExitById(exitId);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/exits/{exitid}/rhyaftercares/{rhyaftercareid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_RHYAFTERCARE_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public RhyAfterCare getRhyAfterCareById(
			@PathVariable("rhyaftercareid") UUID rhyaftercareid, @PathVariable("exitid") UUID exitId, 
			HttpServletRequest request) throws Exception {
		serviceFactory.getExitService().getExitById(exitId);
		return serviceFactory.getRHYAfterCareService().getRhyAfterCareById(rhyaftercareid);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhsps", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_ENTRYRHSP", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhsp createEntryrhsp(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Entryrhsp entryrhsp,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryrhspService().createEntryrhsp(entryrhsp, enrollmentId,
				session.getAccount().getUsername());
		Entryrhsp returnentryrhsp = new Entryrhsp();
		returnentryrhsp.setEntryrhspId(entryrhsp.getEntryrhspId());
		return returnentryrhsp;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhsps/{entryrhspid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_ENTRYRHSP", checkTrustedApp = true, checkSessionToken = true)
	public void updateEntryrhsp(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryrhspid") UUID entryrhspId,
			@RequestBody Entryrhsp entryrhsp, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		entryrhsp.setEntryrhspId(entryrhspId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryrhspService().updateEntryrhsp(entryrhsp, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhsps/{entryrhspid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_ENTRYRHSP", checkTrustedApp = true, checkSessionToken = true)
	public void deleteEntryrhsp(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryrhspid") UUID entryrhspId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getEntryrhspService().deleteEntryrhsp(entryrhspId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhsps/{entryrhspid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ENTRYRHSP_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhsp getEntryrhspById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryrhspid") UUID entryrhspId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryrhspService().getEntryrhspById(entryrhspId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhsps", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_ENTRYRHSP", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhsps getAllEnrollmentEntryrhsps(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryrhspService().getAllEnrollmentEntryrhsps(enrollmentId, startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhys", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_ENTRYRHY", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhy createEntryrhy(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Entryrhy entryrhy, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryrhyService().createEntryrhy(entryrhy, enrollmentId, session.getAccount().getUsername());
		Entryrhy returnentryrhy = new Entryrhy();
		returnentryrhy.setEntryrhyId(entryrhy.getEntryrhyId());
		return returnentryrhy;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhys/{entryrhyid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_ENTRYRHY", checkTrustedApp = true, checkSessionToken = true)
	public void updateEntryrhy(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("entryrhyid") UUID entryrhyId, @RequestBody Entryrhy entryrhy, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		entryrhy.setEntryrhyId(entryrhyId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryrhyService().updateEntryrhy(entryrhy, enrollmentId, session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhys/{entryrhyid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_ENTRYRHY", checkTrustedApp = true, checkSessionToken = true)
	public void deleteEntryrhy(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("entryrhyid") UUID entryrhyId, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getEntryrhyService().deleteEntryrhy(entryrhyId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhys/{entryrhyid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ENTRYRHY_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhy getEntryrhyById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryrhyid") UUID entryrhyId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryrhyService().getEntryrhyById(entryrhyId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryrhys", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_ENTRYRHY", checkTrustedApp = true, checkSessionToken = true)
	public Entryrhys getAllEnrollmentEntryrhys(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryrhyService().getAllEnrollmentEntryrhys(enrollmentId, startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryssvfs", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_ENTRYSSVF", checkTrustedApp = true, checkSessionToken = true)
	public Entryssvf createEntryssvf(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Entryssvf entryssvf,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryssvfService().createEntryssvf(entryssvf, enrollmentId,
				session.getAccount().getUsername());
		Entryssvf returnentryssvf = new Entryssvf();
		returnentryssvf.setEntryssvfId(entryssvf.getEntryssvfId());
		return returnentryssvf;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryssvfs/{entryssvfid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_ENTRYSSVF", checkTrustedApp = true, checkSessionToken = true)
	public void updateEntryssvf(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryssvfid") UUID entryssvfId,
			@RequestBody Entryssvf entryssvf, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		entryssvf.setEntryssvfId(entryssvfId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEntryssvfService().updateEntryssvf(entryssvf, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryssvfs/{entryssvfid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_ENTRYSSVF", checkTrustedApp = true, checkSessionToken = true)
	public void deleteEntryssvf(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryssvfid") UUID entryssvfId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getEntryssvfService().deleteEntryssvf(entryssvfId, session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryssvfs/{entryssvfid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ENTRYSSVF_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Entryssvf getEntryssvfById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @PathVariable("entryssvfid") UUID entryssvfId,
			HttpServletRequest request) throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryssvfService().getEntryssvfById(entryssvfId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/entryssvfs", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_ENTRYSSVF", checkTrustedApp = true, checkSessionToken = true)
	public Entryssvfs getAllEnrollmentEntryssvfs(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getEntryssvfService().getAllEnrollmentEntryssvfs(enrollmentId, startIndex, maxItems);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/servicefareferrals", method = RequestMethod.POST)
	@APIMapping(value = "CLIENT_API_CREATE_SERVICEFAREFERRAL", checkTrustedApp = true, checkSessionToken = true)
	public Servicefareferral createServicefareferral(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, @RequestBody Servicefareferral servicefareferral,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getServicefareferralService().createServicefareferral(servicefareferral, enrollmentId,
				session.getAccount().getUsername());
		Servicefareferral returnservicefareferral = new Servicefareferral();
		returnservicefareferral.setServicefareferralId(servicefareferral.getServicefareferralId());
		return returnservicefareferral;
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}", method = RequestMethod.PUT)
	@APIMapping(value = "CLIENT_API_UPDATE_SERVICEFAREFERRAL", checkTrustedApp = true, checkSessionToken = true)
	public void updateServicefareferral(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("servicefareferralid") UUID servicefareferralId,
			@RequestBody Servicefareferral servicefareferral, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		servicefareferral.setServicefareferralId(servicefareferralId);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getServicefareferralService().updateServicefareferral(servicefareferral, enrollmentId,
				session.getAccount().getUsername());
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}", method = RequestMethod.DELETE)
	@APIMapping(value = "CLIENT_API_DELETE_SERVICEFAREFERRAL", checkTrustedApp = true, checkSessionToken = true)
	public void deleteServicefareferral(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("servicefareferralid") UUID servicefareferralId, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		serviceFactory.getServicefareferralService().deleteServicefareferral(servicefareferralId,
				session.getAccount().getUsername());
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_SERVICEFAREFERRAL_BY_ID", checkTrustedApp = true, checkSessionToken = true)
	public Servicefareferral getServicefareferralById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@PathVariable("servicefareferralid") UUID servicefareferralId, HttpServletRequest request)
					throws Exception {
		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getServicefareferralService().getServicefareferralById(servicefareferralId);
	}

	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}/servicefareferrals", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_ENROLLMENT_SERVICEFAREFERRAL", checkTrustedApp = true, checkSessionToken = true)
	public Servicefareferrals getAllEnrollmentServicefareferrals(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		serviceFactory.getClientService().getClientById(clientId);
		serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
		return serviceFactory.getServicefareferralService().getAllEnrollmentServicefareferrals(enrollmentId, startIndex,
				maxItems);
	}
	
	
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/contacts",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_CONTACT",checkTrustedApp=true,checkSessionToken=true)
	   public Contact createContact(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Contact contact,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getContactService().createContact(contact,enrollmentId,session.getAccount().getUsername()); 
	         Contact returncontact = new Contact();
	         returncontact.setContactId(contact.getContactId());
	         return returncontact;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/contacts/{contactid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_CONTACT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateContact(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "contactid" ) UUID contactId,@RequestBody Contact contact,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        contact.setContactId(contactId);
	        serviceFactory.getContactService().updateContact(contact,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/contacts/{contactid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_CONTACT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteContact(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "contactid" ) UUID contactId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getContactService().deleteContact(contactId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/contacts/{contactid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_CONTACT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Contact getContactById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "contactid" ) UUID contactId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getContactService().getContactById(contactId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/contacts",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_CONTACT",checkTrustedApp=true,checkSessionToken=true)
	   public Contacts getAllEnrollmentContacts(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getContactService().getAllEnrollmentContacts(enrollmentId,startIndex,maxItems); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/educations",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EDUCATION",checkTrustedApp=true,checkSessionToken=true)
	   public Education createEducation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@RequestBody Education education,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEducationService().createEducation(education,enrollmentId,session.getAccount().getUsername()); 
	         Education returneducation = new Education();
	         returneducation.setEducationId(education.getEducationId());
	         return returneducation;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/educations/{educationid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EDUCATION",checkTrustedApp=true,checkSessionToken=true)
	   public void updateEducation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "educationid" ) UUID educationId,@RequestBody Education education,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        education.setEducationId(educationId);
	        serviceFactory.getEducationService().updateEducation(education,enrollmentId,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/educations/{educationid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EDUCATION",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteEducation(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "educationid" ) UUID educationId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        serviceFactory.getEducationService().deleteEducation(educationId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/educations/{educationid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EDUCATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Education getEducationById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,@PathVariable( "educationid" ) UUID educationId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEducationService().getEducationById(educationId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/educations",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_EDUCATION",checkTrustedApp=true,checkSessionToken=true)
	   public Educations getAllEnrollmentEducations(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	        return serviceFactory.getEducationService().getAllEnrollmentEducations(enrollmentId,startIndex,maxItems); 
	   }
	   
	   
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_EXITHOUSINGASSESSMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Exithousingassessment createExithousingassessment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitid ,
			   @RequestBody Exithousingassessment exithousingassessment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getExithousingassessmentService().createExithousingassessment(exithousingassessment,exitid,session.getAccount().getUsername()); 
	         Exithousingassessment returnexithousingassessment = new Exithousingassessment();
	         returnexithousingassessment.setExithousingassessmentId(exithousingassessment.getExithousingassessmentId());
	         return returnexithousingassessment;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments/{exithousingassessmentid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_EXITHOUSINGASSESSMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void updateExithousingassessment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "exithousingassessmentid" ) UUID exithousingassessmentId,@RequestBody Exithousingassessment exithousingassessment,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        exithousingassessment.setExithousingassessmentId(exithousingassessmentId);
	        serviceFactory.getExithousingassessmentService().updateExithousingassessment(exithousingassessment,exitid,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments/{exithousingassessmentid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_EXITHOUSINGASSESSMENT",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteExithousingassessment(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "exithousingassessmentid" ) UUID exithousingassessmentId,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
			serviceFactory.getExitService().getExitById(exitid);
	        serviceFactory.getExithousingassessmentService().deleteExithousingassessment(exithousingassessmentId,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments/{exithousingassessmentid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_EXITHOUSINGASSESSMENT_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public Exithousingassessment getExithousingassessmentById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "exithousingassessmentid" ) UUID exithousingassessmentId,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	 		 serviceFactory.getExitService().getExitById(exitid);
	        return serviceFactory.getExithousingassessmentService().getExithousingassessmentById(exithousingassessmentId); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/exithousingassessments",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_EXITHOUSINGASSESSMENT",checkTrustedApp=true,checkSessionToken=true)
	   public Exithousingassessments getAllEnrollmentExithousingassessments(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitid ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
   	 		 serviceFactory.getExitService().getExitById(exitid);
	        return serviceFactory.getExithousingassessmentService().getAllExitExithousingassessments(exitid,startIndex,maxItems); 
	   }
	   // VASExitReason
	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/vashexitreasons",method=RequestMethod.POST)
	   @APIMapping(value="CLIENT_API_CREATE_VASHEXITREASON",checkTrustedApp=true,checkSessionToken=true)
	   public VashExitReason createVashExitReason(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitid ,
			   @RequestBody VashExitReason vashExitReason,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getVashExitReasonService().createVashExitReason(vashExitReason,exitid,session.getAccount().getUsername()); 
	         VashExitReason returnVashExitReason = new VashExitReason();
	         returnVashExitReason.setVashExitReasonId(vashExitReason.getVashExitReasonId());
	         return returnVashExitReason;
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/vashexitreasons/{vashexitreasonid}",method=RequestMethod.PUT)
	   @APIMapping(value="CLIENT_API_UPDATE_VASHEXITREASON",checkTrustedApp=true,checkSessionToken=true)
	   public void updateVashExitReason(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "vashexitreasonid" ) UUID vashexitreasonid,@RequestBody VashExitReason vashExitReason,HttpServletRequest request) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        vashExitReason.setVashExitReasonId(vashexitreasonid);
	        serviceFactory.getVashExitReasonService().updateVashExitReason(vashExitReason,exitid,session.getAccount().getUsername()); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/vashexitreasons/{vashexitreasonid}",method=RequestMethod.DELETE)
	   @APIMapping(value="CLIENT_API_DELETE_VASHEXITREASON",checkTrustedApp=true,checkSessionToken=true)
	   public void deleteVashExitReason(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "vashexitreasonid" ) UUID vashexitreasonid,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Session session = sessionHelper.getSession(request); 
	        serviceFactory.getClientService().getClientById(clientId); 
	        serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
			serviceFactory.getExitService().getExitById(exitid);
	        serviceFactory.getVashExitReasonService().deleteVashExitReason(vashexitreasonid,session.getAccount().getUsername()); 
	        response.setStatus(HttpServletResponse.SC_NO_CONTENT); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/vashexitreasons/{vashexitreasonid}",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_VASHEXITREASON_BY_ID",checkTrustedApp=true,checkSessionToken=true)
	   public VashExitReason getVashExitReasonById(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId,
			   @PathVariable("exitid") UUID exitid ,
			   @PathVariable( "vashexitreasonid" ) UUID vashexitreasonid,HttpServletRequest request) throws Exception{
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
	 		 serviceFactory.getExitService().getExitById(exitid);
	        return serviceFactory.getVashExitReasonService().getVashExitReasonById(vashexitreasonid); 
	   }

	   @RequestMapping(value="/{clientid}/enrollments/{enrollmentid}/exits/{exitid}/vashexitreasons",method=RequestMethod.GET)
	   @APIMapping(value="CLIENT_API_GET_ALL_ENROLLMENT_VASHEXITREASON",checkTrustedApp=true,checkSessionToken=true)
	   public VashExitReasons getAllExitVashExitReasons(@PathVariable("clientid") UUID clientId, @PathVariable("enrollmentid") UUID enrollmentId ,
			   @PathVariable("exitid") UUID exitid ,
	                       @RequestParam(value="startIndex", required=false) Integer startIndex, 
	                       @RequestParam(value="maxItems", required=false) Integer maxItems,
	                       HttpServletRequest request) throws Exception {
	           if (startIndex == null) startIndex =0;
	           if (maxItems == null) maxItems =30;
	 
	         serviceFactory.getClientService().getClientById(clientId); 
	         serviceFactory.getEnrollmentService().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId); 
   	 		 serviceFactory.getExitService().getExitById(exitid);
	        return serviceFactory.getVashExitReasonService().getAllExitVashExitReasons(exitid,startIndex,maxItems); 
	   }
	   
}