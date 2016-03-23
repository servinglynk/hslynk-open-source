package com.servinglynk.hmis.warehouse.test.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.test.core.TestData;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@WebAppConfiguration
public class TestSessionsRestEndpoint {
	
	
	@Autowired
	public BaseServiceFactory serviceFactory;
	
	@Autowired WebApplicationContext wac;
	
	@Test
	public void TestSessionsRestEndpoint_1_create_session() throws Exception {
		WebserviceTestExecutor nosessionExecutor = new WebserviceTestExecutor(wac);
		nosessionExecutor.setAcceptHeaderAsJson();
		nosessionExecutor.setContentTypeHeaderAsJson();
		nosessionExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account = nosessionExecutor.executePost("/accounts", TestData.getAccount(),Account.class);
		
		DeveloperCompany developerCompany = serviceFactory.getDeveloperCompanyService().createDeveloperCompany(TestData.getDeveloperCompanyWithOwner(account), Constants.AUDIT_USER_UNIT_TEST);

		DeveloperService developerService = serviceFactory.getDeveloperCompanyService().addNewService(developerCompany.getDeveloperCompanyId(), TestData.getDeveloperServiceForDC(developerCompany),
										account, Constants.AUDIT_USER_UNIT_TEST);
	
		
		
	
		TrustedApp trustedApp = serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(TestData.getTrustedAppForService(developerService), developerService.getServiceId(),account.getUsername(),Constants.USER_SERVICE);
	
		TrustedAppStatus trustedAppStatus = new TrustedAppStatus();
		trustedAppStatus.setTrustedAppId(trustedApp.getTrustedAppId());
		trustedAppStatus.setComment("Testing for approval submission");
				
		
		serviceFactory.getTrustedAppService().processApprovalSubmission(trustedApp.getTrustedAppId(), trustedAppStatus, account, Constants.USER_SERVICE);
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", trustedApp.getFriendlyName());
		
		Session session = new Session();
		session.setAccount(account);
		
		Session newSession = executor.executePost("/sessions", session,Session.class);

		Assert.assertNotNull(newSession.getToken());
	
	}
	
	
	
	/*
	@Test
	public void testCreateSession() throws Exception {
		Account account = TestData.getAccount();

		Account newAccount = executePost("/accounts", account, Account.class, null);
	

		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
 
  		DeveloperCompany responce = serviceFactory.getDeveloperCompanyService().createDeveloperCompany(developerCompany, Constants.USER_SERVICE);
 		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(responce);
		
		
		DeveloperService resp = serviceFactory.getDeveloperCompanyService().addNewService(responce.getDeveloperCompanyId(), service, newAccount,Constants.USER_SERVICE);

		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		TrustedApp trustedApp2 = serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(trustedApp, resp.getServiceId(),newAccount.getUsername(),Constants.USER_SERVICE);
		
		assertNotEquals(trustedApp2.getTrustedAppId(),null);
		
		Session session = new Session();
		session.setAccount(newAccount);
		
		
		Session newSession = executePost("/sessions", session, Session.class, newAccount.getUsername());
		
		assertNotEquals(newSession.getToken(), null);
		
	}
	
	@Test
	public void testEndSession() throws Exception {
		
		Account account = TestData.getAccount();

		Account newAccount = executePost("/accounts/u", account, Account.class, null);
	

		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
 
  		DeveloperCompany responce = serviceFactory.getDeveloperCompanyService().createDeveloperCompany(developerCompany, Constants.USER_SERVICE);
 		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(responce);
		
		
		DeveloperService resp = serviceFactory.getDeveloperCompanyService().addNewService(responce.getDeveloperCompanyId(), service, newAccount,Constants.USER_SERVICE);

		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		TrustedApp trustedApp2 = serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(trustedApp, resp.getServiceId(),newAccount.getUsername(),Constants.USER_SERVICE);
		
		assertNotEquals(trustedApp2.getTrustedAppId(),null);
		
		Session session = new Session();
		session.setAccount(newAccount);
		
		
		Session newSession = executePost("/sessions?", session, Session.class, newAccount.getUsername());
		
		System.out.println(newSession.toJSONString());
		
		Session endSession = executeDelete("/sessions/"+newSession.getToken(),newSession, Session.class, newAccount.getUsername());
		
		assertEquals(endSession.getToken(), null);
		
	}
	
	
	@Test
	public void testCreateSessionWithWrongPWD() throws Exception {
		Account account = TestData.getAccount();

		Account newAccount = executePost("/accounts/u", account, Account.class, null);
	

		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
 
  		DeveloperCompany responce = serviceFactory.getDeveloperCompanyService().createDeveloperCompany(developerCompany, Constants.USER_SERVICE);
 		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(responce);
		
		
		DeveloperService resp = serviceFactory.getDeveloperCompanyService().addNewService(responce.getDeveloperCompanyId(), service, newAccount,Constants.USER_SERVICE);

		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		TrustedApp trustedApp2 = serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(trustedApp, resp.getServiceId(),newAccount.getUsername(),Constants.USER_SERVICE);
		
		assertNotEquals(trustedApp2.getTrustedAppId(),null);
		
		Session session = new Session();
		session.setAccount(newAccount);
		session.getAccount().setPassword("testpassword");
		
		
		Error error = executePost("/sessions?clientTypeId="+trustedApp2.getTrustedAppId(), session, Error.class, newAccount.getUsername());
		assertEquals("ERR_CODE_INVALID_ACCOUNT_CREDENTIALS",error.getCode());
		
	}
	*/
}
