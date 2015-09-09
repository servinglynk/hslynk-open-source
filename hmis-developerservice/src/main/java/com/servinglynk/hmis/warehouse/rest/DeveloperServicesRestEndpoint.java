package com.servinglynk.hmis.warehouse.rest;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedApps;


@RestController
@RequestMapping("/services")
public class DeveloperServicesRestEndpoint extends RestEndpointBase {

	@RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperService getService(@PathVariable("serviceId") String externalServiceId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		
		return serviceFactory.getDeveloperCompanyService().getService(externalServiceId, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}

	@RequestMapping(value = "/{serviceId:.*}", method = RequestMethod.PUT)
	@APIMapping(value="DCS_UPDATE_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperService updateService(@PathVariable("serviceId") String externalServiceId, @RequestBody DeveloperService service, HttpServletRequest request) throws Exception {
		
		Session session =sessionHelper.getSession(request);
		
	serviceFactory.getDeveloperCompanyService().updateService(externalServiceId, service, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);	
	
	return service;
	}

	@RequestMapping(value = "/{serviceId:.*}", method = RequestMethod.DELETE)
	@APIMapping(value="DCS_DELETE_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperService deleteService(@PathVariable("serviceId") String externalServiceId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		serviceFactory.getDeveloperCompanyService().deleteService(externalServiceId, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		
		return new DeveloperService();
	}



	@RequestMapping(value = "/{serviceId}/trustedApps", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_TRUSTEDAPP_FOR_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApp createTrustedAppForService(@PathVariable("serviceId") String externalServiceId,
											  @RequestBody TrustedApp trustedApp,
											  HttpServletRequest request) throws Exception {

		Session session=sessionHelper.getSession(request);
	
		return serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(trustedApp, externalServiceId, session.getAccount().getUsername(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}


	@RequestMapping(value = "/{serviceId}/approvalsubmission", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_SERVICE_APPROVAL_SUBMISSION",checkSessionToken=true, checkTrustedApp=true)
	public ServiceStatus createApprovalSubmission(@PathVariable("serviceId") String externalServiceId,@RequestBody ServiceStatus serviceStatus,HttpServletRequest request) throws Exception {
		
	
		Session session=sessionHelper.getSession(request);
		return serviceFactory.getDeveloperCompanyService().processApprovalSubmission(externalServiceId, serviceStatus, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}

	@RequestMapping(value = "/{serviceId}/approvaldecision", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_SERVICE_APPROVAL_DECISION",checkSessionToken=true, checkTrustedApp=true)
	public ServiceStatus createApprovalDecision(@PathVariable("serviceId") String externalServiceId,@RequestBody ServiceStatus serviceStatus,HttpServletRequest request) throws Exception {
		
		Session session=sessionHelper.getSession(request);
		
		return	serviceFactory.getDeveloperCompanyService().processApprovalDecision(externalServiceId, serviceStatus, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		
	}
	
	@RequestMapping(value = "/{serviceId}/trustedApps", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_TRUSTEDAPPS_FOR_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApps getTrustedAppsForService(@PathVariable("serviceId") String externalServiceId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);

		List<TrustedApp> trustedApps = serviceFactory.getTrustedAppService().getTrustedAppsUsingService(externalServiceId, session.getAccount().getUsername(), Constants.DEVELOPER_CONSOLE_SERVICE);

		TrustedApps trustedAppsObj = new TrustedApps();
		trustedAppsObj.setTrustedApps(trustedApps);
		return trustedAppsObj;
	}
	
}
