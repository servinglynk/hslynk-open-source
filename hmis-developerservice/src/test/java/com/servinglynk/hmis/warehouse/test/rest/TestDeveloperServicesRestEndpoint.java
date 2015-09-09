package com.servinglynk.hmis.warehouse.test.rest;


import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.DeveloperServices;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedApps;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutorOld;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestDeveloperServicesRestEndpoint extends WebserviceTestExecutorOld  {
	
protected final Log LOG = LogFactory.getLog(getClass());
	
	@Autowired WebApplicationContext wac;
	
	@Autowired ParentServiceFactory serviceFactory;
	
	WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	
	
	public Session createSession(String username,String pwd) throws Exception {
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Session session = new Session();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(pwd);
		session.setAccount(account);
		
		serviceFactory.getSessionService().createSession(session, "MASTER_TRUSTED_APP",Constants.AUDIT_USER_UNIT_TEST);
		Assert.assertNotNull(session.getToken());
		return session;
	}
	
	public void endSession(Session session) throws Exception {
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		executor.executeDelete("/sessions/"+session.getToken());
	}
	

	public Account createAccount() throws Exception {
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Profile standardProfile = TestData.getProfile();
		standardProfile = serviceFactory.getProfileService().createProfile(standardProfile, Constants.AUDIT_USER_UNIT_TEST);
		Account account = TestData.getAccountWithoutProfile();
		account.setProfile(standardProfile);

		account = serviceFactory.getAccountService().createAccount(account, Constants.AUDIT_USER_UNIT_TEST,null);
		
		Parameter parameter=new Parameter();
		parameter.setKey("username");
		parameter.setValue(account.getUsername().toLowerCase());
		
		Verification verification = new Verification();
		verification.setType(VERIFICATION_TYPE_ACCOUNT_CREATION);
		verification.setStatus(VERIFICATION_STATUS_ACCEPTED);
		verification.setToken(account.getVerificationToken());
		verification.addParameter(parameter);
		
		serviceFactory.getVerificationService().updateVerificationStatus(verification,Constants.AUDIT_USER_UNIT_TEST);
		assertNotNull(account.getAccountId());
		return account;
	}
	
	public void addingMethodAccessUsingPermissionSet(String[] methods,String userName) throws Exception {
		PermissionSet permissionSet = TestData.getPermissionSet();
		for(int i=0;i<methods.length;i++){
			ApiMethod apiMethod= new ApiMethod();
			apiMethod.setExternalId(methods[i]);
			permissionSet.addApiMethod(apiMethod);
		}
		serviceFactory.getPermissionSetService().createPermissionSet(permissionSet, Constants.AUDIT_USER_UNIT_TEST);
		serviceFactory.getPermissionSetService().assignPermissionSetTOUser(userName, permissionSet, Constants.AUDIT_USER_UNIT_TEST);
		
	}
	
	

	public DeveloperCompany createDeveloperCompany(Account account) throws Exception{
		
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		return developerCompany;
	}
	
	
	
	
	
	
	@Test
	public void testGetService() throws Exception {
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_GET_SERVICES"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		DeveloperService resp =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(resp.getServiceId(),null);

		DeveloperServices services = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", DeveloperServices.class);
		assertEquals(services.getServices().size(), 1);
		
		DeveloperService service2 = executor.executeGet("/services/"+resp.getServiceId(),DeveloperService.class);
		assertEquals(service.getFriendlyName(), service2.getFriendlyName());
	}
	
	
	@Test
	public void testUpdateService() throws Exception{
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_UPDATE_SERVICE"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		DeveloperService resp =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(resp.getServiceId(),null);
		
		resp.setDescription("My First Test Service to Implement");
		
		DeveloperService service2  = executor.executePut("/services/"+resp.getServiceId(),resp, DeveloperService.class);
		
		
		assertEquals(service2.getDescription(),"My First Test Service to Implement");
	}
	
	
	@Test
	public void testDeleteService() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_DELETE_SERVICE"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		DeveloperService resp =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(resp.getServiceId(),null);
		
		DeveloperService ds =  executor.executeDelete("/services/"+resp.getServiceId(), DeveloperService.class);
		
		System.out.println(ds.toJSONString());
		
		assertEquals(ds.getFriendlyName(),null);
	}
	
	
	
	@Test
	public void testCreateTrustedAppForService() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		DeveloperService resp =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(resp.getServiceId(),null);
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		
		trustedApp =  executor.executePost("/services/"+resp.getServiceId()+"/trustedApps", trustedApp, TrustedApp.class);
		
		assertNotEquals(trustedApp.getTrustedAppId(),null);
	}
	
	@Test
	public void testApprovalsubmission() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_CREATE_SERVICE_APPROVAL_SUBMISSION"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		service =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(service.getServiceId(),null);
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(service);
		
		
		trustedApp =  executor.executePost("/services/"+service.getServiceId()+"/trustedApps", trustedApp, TrustedApp.class);
		
		assertNotEquals(trustedApp.getTrustedAppId(),null);
		
		
		ServiceStatus serviceStatus=TestData.getServiceStatus(true);
		
		serviceStatus.setService(service);
				
		ServiceStatus status= executor.executePost("/services/"+service.getServiceId()+"/approvalsubmission", serviceStatus, ServiceStatus.class);
	
		assertEquals(status.getStatus(),"SUBMITTED");		
	}
	
	
	
	@Test
	public void testCreateApprovalDecision() throws Exception {
		
	
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_CREATE_SERVICE_APPROVAL_SUBMISSION","DCS_CREATE_SERVICE_APPROVAL_DECISION"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		service =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(service.getServiceId(),null);
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(service);
		
		
		trustedApp =  executor.executePost("/services/"+service.getServiceId()+"/trustedApps", trustedApp, TrustedApp.class);
		
		assertNotEquals(trustedApp.getTrustedAppId(),null);
		
		
		ServiceStatus serviceStatus=TestData.getServiceStatus(true);
		
		serviceStatus.setService(service);
				
		ServiceStatus status= executor.executePost("/services/"+service.getServiceId()+"/approvalsubmission", serviceStatus, ServiceStatus.class);
	
		assertEquals(status.getStatus(),"SUBMITTED");
		
		status.setStatus(Constants.SERVICE_STATUS_ACTIVE);
	    
	    ServiceStatus respServiceStatus2 = executor.executePost("/services/"+service.getServiceId()+"/approvaldecision",status, ServiceStatus.class);
	    
	    assertEquals(respServiceStatus2.getStatus(), Constants.SERVICE_STATUS_ACTIVE);
	
	}
	
	@Test
	public void testGetTrustedAppsForService() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_GET_TRUSTEDAPPS_FOR_SERVICE"};
		addingMethodAccessUsingPermissionSet(methods, account.getUsername());
		Session session = createSession(account.getUsername(),account.getPassword());
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompanyWithOwner(account);
		developerCompany =	executor.executePost("/developercompanies",developerCompany, DeveloperCompany.class);
		assertNotEquals(developerCompany.getDeveloperCompanyId(), null);
		assertEquals(developerCompany.getStatus(), "SUBMITTED");
		
		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(developerCompany);
		
		DeveloperService resp =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service, DeveloperService.class);

		assertNotEquals(resp.getServiceId(),null);
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		
		trustedApp =  executor.executePost("/services/"+resp.getServiceId()+"/trustedApps", trustedApp, TrustedApp.class);
		
		assertNotEquals(trustedApp.getTrustedAppId(),null);
		
		trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		
		trustedApp =  executor.executePost("/services/"+resp.getServiceId()+"/trustedApps", trustedApp, TrustedApp.class);
		
		assertNotEquals(trustedApp.getTrustedAppId(),null);
		
		TrustedApps trustedApps = executor.executeGet("/services/"+resp.getServiceId()+"/trustedApps",TrustedApps.class);
		
		assertEquals(trustedApps.getTrustedApps().size(),2);
		
	}
}