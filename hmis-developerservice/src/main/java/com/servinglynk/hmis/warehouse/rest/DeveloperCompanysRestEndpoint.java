package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanies;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccounts;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.DeveloperServices;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyStatus;


@RestController
@RequestMapping("/developercompanies")
public class DeveloperCompanysRestEndpoint extends RestEndpointBase {
	
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_DEVELOPER_COMPANY",checkSessionToken=false, checkTrustedApp=false)
	public DeveloperCompany createDeveloperCompany( @RequestBody DeveloperCompany developerCompany, HttpServletRequest request) throws Exception {
		return	serviceFactory.getDeveloperCompanyService().createDeveloperCompany(developerCompany, Constants.DEVELOPER_CONSOLE_SERVICE);
	}

	

	@RequestMapping(value = "/{developerCompanyId:.*}", method = RequestMethod.PUT)
	@APIMapping(value="DCS_UPDATE_DEVELOPER_COMPANY",checkSessionToken=false, checkTrustedApp=false)
	public DeveloperCompany updateDeveloperCompany(@PathVariable("developerCompanyId") String externalDeveloperCompanyId, @RequestBody DeveloperCompany developerCompany, HttpServletRequest request) throws Exception {
	
		
		serviceFactory.getDeveloperCompanyService().updateDeveloperCompany(externalDeveloperCompanyId, developerCompany, developerCompany.getOwner(), Constants.DEVELOPER_CONSOLE_SERVICE);
		
		return developerCompany;
	}
	

	@RequestMapping(value = "/{developerCompanyId}/accounts", method = RequestMethod.POST)
	@APIMapping(value="DCS_ASSOCIATE_DEVELOPER_ACCOUNT",checkSessionToken=false, checkTrustedApp=false)
	public DeveloperCompanyAccount associateDeveloperAccount(@PathVariable("developerCompanyId") String externalDeveloperCompanyId,
															  @RequestBody DeveloperCompanyAccount developerAccount,
															  HttpServletRequest request) throws Exception {
		
		 serviceFactory.getDeveloperCompanyService().associateAccountAndDeveloperCompany(externalDeveloperCompanyId, developerAccount, developerAccount.getAccount(),Constants.DEVELOPER_CONSOLE_SERVICE);
		return new DeveloperCompanyAccount();
	}
	
	
	@RequestMapping(value = "/{developerCompanyId}/accounts/{username:.*}", method = RequestMethod.DELETE)
	@APIMapping(value="DCS_DISASSOCIATE_DEVELOPER_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperCompanyAccount dissociateDeveloperAccount(@PathVariable("developerCompanyId") String externalDeveloperCompanyId,
															  @PathVariable("username") String username,
															  HttpServletRequest request) throws Exception {
		
		Session session=sessionHelper.getSession(request);
		
		serviceFactory.getDeveloperCompanyService().dissociateAccountAndDeveloperCompany(externalDeveloperCompanyId, username, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		return new DeveloperCompanyAccount();
	}
	
	
	@RequestMapping(value = "/{developerCompanyId}/services", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_SERVICE",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperService createService(@PathVariable("developerCompanyId") String externalDeveloperCompanyId,
							     @RequestBody DeveloperService service,
								 HttpServletRequest request) throws Exception {
		
		Session session=sessionHelper.getSession(request);
		return	serviceFactory.getDeveloperCompanyService().addNewService(externalDeveloperCompanyId, service, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}
	
	
	/* Developer company >  HMIS Service - upload API , register API > 1. HMIS Androiod Trusted App 2. HMIS IOS Trusted App */
	
	
	@RequestMapping(value = "/{developerCompanyId:.*}", method = RequestMethod.DELETE)
	@APIMapping(value="DCS_DELETE_DEVELOPER_COMPANY",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperCompany deleteDeveloperCompany(@PathVariable("developerCompanyId") String externalDeveloperCompanyId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		
	serviceFactory.getDeveloperCompanyService().deleteDeveloperCompany(externalDeveloperCompanyId, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		return new DeveloperCompany();
	}
	
	
	@RequestMapping(value = "/{developerCompanyId:.*}", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_DEVELOPER_COMPANY",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperCompany getDeveloperCompany(@PathVariable("developerCompanyId") String externalDeveloperCompanyId, HttpServletRequest request) throws Exception {

	Session session=sessionHelper.getSession(request);
		
		return serviceFactory.getDeveloperCompanyService().getDeveloperCompany(externalDeveloperCompanyId, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}
	
	
	
	@RequestMapping(value = "/{developerCompanyId}/accounts", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_DEVELOPER_COMPANY_ACCOUNTS",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperCompanyAccounts getDeveloperCompanyAccounts(@PathVariable("developerCompanyId") String externalDeveloperCompanyId, HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		
		return serviceFactory.getDeveloperCompanyService().getDeveloperCompanyAccounts(externalDeveloperCompanyId, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
	}
	
	
	@RequestMapping(value = "/{developerCompanyId}/services", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_SERVICES",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperServices getServices(HttpServletRequest request,
							       @PathVariable("developerCompanyId") String externalDeveloperCompanyId,
					               @RequestParam(value="startIndex", required=false) Integer startIndex,
					               @RequestParam(value="maxItems", required=false) Integer maxItems) throws Exception {

		Session session = sessionHelper.getSession(request);

		if (startIndex == null)	{
			startIndex = 0;
		}

		if (maxItems == null)	{
			maxItems = 30;
		}

		return serviceFactory.getDeveloperCompanyService().getServices(externalDeveloperCompanyId, session.getAccount(), startIndex, maxItems, Constants.DEVELOPER_CONSOLE_SERVICE);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_ALL_DEVELOPER_COMPANY",checkSessionToken=true, checkTrustedApp=true)
	public DeveloperCompanies getAllDeveloperCompanies( @RequestParam(value="service.status", required=false) String serviceStatus, 
		@RequestParam(value="trustedApp.status", required=false) String trustedAppStatus,
		@RequestParam(value="startIndex", required=false) Integer startIndex,
        @RequestParam(value="maxItems", required=false) Integer maxItems, HttpServletRequest request) throws Exception {
		

		if (startIndex == null)	{
			startIndex = 0;
		}

		if (maxItems == null)	{
			maxItems = 30;
		}

		Session session = sessionHelper.getSession(request);
		return serviceFactory.getDeveloperCompanyService().getAllDeveloperCompanies(session.getAccount().getUsername(),serviceStatus,trustedAppStatus,startIndex, maxItems, Constants.DEVELOPER_CONSOLE_SERVICE);
		
	}
	
	@RequestMapping(value = "/{developerCompanyId}/approvaldecision", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_DEVELOPER_APPROVAL_DECISION",checkSessionToken=false, checkTrustedApp=false)
	public DeveloperCompanyStatus createApprovalDecision(@PathVariable("developerCompanyId") String developerCompanyId, @RequestBody DeveloperCompanyStatus developerCompanyStatus,
			HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getDeveloperCompanyService().processDCApprovalDecision(developerCompanyId, developerCompanyStatus, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		return new DeveloperCompanyStatus();
	}
	
	
}
