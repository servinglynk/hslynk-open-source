package com.servinglynk.hmis.warehouse.test.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.RedirectUris;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutorOld;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestTrustedAppRestEndpoint extends WebserviceTestExecutorOld {
	
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
		Account account = TestData.getAccount();
		//account.setProfile(standardProfile);

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
	
	
	
	@Test
	public void testUpdateTrustedApp() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_UPDATE_TRUSTEDAPP"};
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
		
		trustedApp.setVersion("2.0.0");
		
		TrustedApp upatedTrustedApp = executor.executePut("/trustedApp/"+trustedApp.getTrustedAppId(), trustedApp, TrustedApp.class);
		
		assertEquals(upatedTrustedApp.getVersion(),trustedApp.getVersion());
		assertEquals(trustedApp.getTrustedAppId(),upatedTrustedApp.getTrustedAppId());
		
	}

	
	@Test
	public void testDeleteTrustedApp() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_DELETE_TRUSTEDAPP"};
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
		
		TrustedApp respTrustedApp1 = executor.executeDelete("/trustedApp/"+trustedApp.getTrustedAppId(),  TrustedApp.class);
	     
		assertEquals(respTrustedApp1.getTrustedAppId(),null);
	
	}
	
	@Test
	public void testRegenerateTrustedAppSecret() throws Exception {
		
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_REGENERATE_TRUSTEDAPP_SECRETE"};
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
		
		TrustedApp respTrustedApp1 = executor.executePut("/trustedApp/"+trustedApp.getTrustedAppId()+"/trustedAppsecret", null, TrustedApp.class);
		
		assertNotEquals(respTrustedApp1.getTrustedAppSecret(), trustedApp.getTrustedAppSecret());
	}
	
	
	@Test
	public void testApprovalsubmission() throws Exception {
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
  		
		DeveloperCompany company = executePost("/developercompanies", developerCompany,  DeveloperCompany.class, developerCompany.getOwner().getUsername());
		
		System.out.println(company.toJSONString());
		
		
		DeveloperService developerService = TestData.getDeveloperService();
		developerService.setDeveloperCompany(company);
		
		DeveloperService service = executePost("/developercompanies/"+company.getDeveloperCompanyId()+"/services", developerService, DeveloperService.class, company.getOwner().getUsername());
		
		System.out.println(service.toJSONString());
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(service);
		
		TrustedApp respTrustedApp = executePost("/services/"+service.getServiceId()+"/trustedApps", trustedApp,TrustedApp.class,developerCompany.getOwner().getUsername());
		
		System.out.println(respTrustedApp.toJSONString());
		
		
		TrustedAppStatus trustedAppStatus = TestData.getTrustedAppStatus(true);
		trustedAppStatus.setTrustedAppId(respTrustedApp.getTrustedAppId());
		
		TrustedAppStatus  respTrustedAppStatus = executePost("/trustedApp/"+respTrustedApp.getTrustedAppId()+"/approvalsubmission", trustedAppStatus, TrustedAppStatus.class, developerCompany.getOwner().getUsername());
		
		
	}
	
	
	/* 
	 * 
	 *   Need to clarification on status values
	 * */
	
	@Test
	public void testApprovaldecision() throws Exception {
		
		
		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
  		
		DeveloperCompany company = executePost("/developercompanies", developerCompany,  DeveloperCompany.class, developerCompany.getOwner().getUsername());
		
		System.out.println(company.toJSONString());
		
		
		DeveloperService developerService = TestData.getDeveloperService();
		developerService.setDeveloperCompany(company);
		
		DeveloperService service = executePost("/developercompanies/"+company.getDeveloperCompanyId()+"/services", developerService, DeveloperService.class, company.getOwner().getUsername());
		
		System.out.println(service.toJSONString());
		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(service);
		
		TrustedApp respTrustedApp = executePost("/services/"+service.getServiceId()+"/trustedApps", trustedApp,TrustedApp.class,developerCompany.getOwner().getUsername());
		
		System.out.println(respTrustedApp.toJSONString());
		
		
		TrustedAppStatus trustedAppStatus = TestData.getTrustedAppStatus(true);
		trustedAppStatus.setTrustedAppId(respTrustedApp.getTrustedAppId());
		
		TrustedAppStatus  respTrustedAppStatus = executePost("/trustedApp/"+respTrustedApp.getTrustedAppId()+"/approvalsubmission", trustedAppStatus, TrustedAppStatus.class, developerCompany.getOwner().getUsername());
		
		System.out.println(respTrustedAppStatus.toJSONString());
		respTrustedAppStatus.setStatus(Constants.SERVICE_STATUS_APPROVED);
		
		TrustedAppStatus approvedTrustedApp = executePost("/trustedApp/"+respTrustedApp.getTrustedAppId()+"/approvaldecision", respTrustedAppStatus, TrustedAppStatus.class, developerCompany.getOwner().getUsername());
		
		System.out.println(approvedTrustedApp.toJSONString());
	}
	
	
	@Test
	public void testRegisterRedirectUris() throws Exception {
		Account account = createAccount();
		String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICE","DCS_CREATE_TRUSTEDAPP_FOR_SERVICE","DCS_REGISTER_REDIRECT_URI"};
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
		
		RedirectUris redirectUris = TestData.getRedirectUris(5);
		
		RedirectUris respRedirectUris = executor.executePost("/trustedApp/"+trustedApp.getTrustedAppId()+"/redirecturis", redirectUris, RedirectUris.class);
		

	}
	
	
	
}
