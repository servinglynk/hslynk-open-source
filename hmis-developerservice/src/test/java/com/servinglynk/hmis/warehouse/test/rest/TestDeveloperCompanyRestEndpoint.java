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
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccount;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanyAccounts;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.DeveloperServices;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestDeveloperCompanyRestEndpoint {
	
	
	protected final Log LOG = LogFactory.getLog(getClass());
	
	@Autowired WebApplicationContext wac;
	
	@Autowired ParentServiceFactory serviceFactory;
	
	
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
	
		@Test
		public void testCreateDeveloperCompany() throws Exception{
			
			Account account = createAccount();
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
		}
		
		@Test
		public void testUpdateDeveloperCompany() throws Exception {
			
		
			Account account = createAccount();
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
			
			developerCompany.setCompanySize(20);
			
	  		DeveloperCompany company = executor.executePut("/developercompanies/"+developerCompany.getDeveloperCompanyId(), developerCompany, DeveloperCompany.class);
			
	  		assertEquals(company.getCompanySize(),20);
			
		}
		
		
		@Test
		public void testAssociateDeveloperAccount() throws Exception {
			
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_ASSOCIATE_DEVELOPER_ACCOUNT","DCS_GET_DEVELOPER_COMPANY_ACCOUNTS"};
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
			
			Account userAccount = createAccount();
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(userAccount);
			dca.setOwner(false);
			
			executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class);	
			
			DeveloperCompanyAccounts accounts = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", DeveloperCompanyAccounts.class);
			assertEquals(accounts.getDeveloperCompanyAccounts().size(),2);
		}
		
		

		@Test
		public void testDissociateDeveloperAccount() throws Exception {
			
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_ASSOCIATE_DEVELOPER_ACCOUNT","DCS_GET_DEVELOPER_COMPANY_ACCOUNTS","DCS_DISASSOCIATE_DEVELOPER_ACCOUNT"};
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
			
			Account userAccount = createAccount();
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(userAccount);
			dca.setOwner(false);
			
			executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class);	
			
			DeveloperCompanyAccounts accounts = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", DeveloperCompanyAccounts.class);
			assertEquals(accounts.getDeveloperCompanyAccounts().size(),2);
			
			Account userAccount1 = createAccount();
			
			DeveloperCompanyAccount dca1 =new DeveloperCompanyAccount();
			dca1.setAccount(userAccount1);
			dca1.setOwner(false);
			
			executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", dca1, DeveloperCompanyAccount.class);	
			
			DeveloperCompanyAccounts developerCompanyAccounts = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", DeveloperCompanyAccounts.class);
			assertEquals(developerCompanyAccounts.getDeveloperCompanyAccounts().size(),3);
			
			executor.executeDelete("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts/"+userAccount1.getUsername());
			
			developerCompanyAccounts = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/accounts", DeveloperCompanyAccounts.class);
			assertEquals(developerCompanyAccounts.getDeveloperCompanyAccounts().size(),2);
			
			
		}
		
		
 		
		
		@Test
		public void testCreateService() throws Exception {
			
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICES"};
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
			
		}
		
		
		@Test
		public void testDeleteDeveloperCompany() throws Exception {
			
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_DELETE_DEVELOPER_COMPANY"};
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
			DeveloperCompany dc = executor.executeDelete("/developercompanies/"+developerCompany.getDeveloperCompanyId(), DeveloperCompany.class);
			
			assertEquals(dc.getDeveloperCompanyId(),null);			
			
		}
		
		
		@Test
		public void testGetDeveloperCompany() throws Exception {
	
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_GET_DEVELOPER_COMPANY"};
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
			
			DeveloperCompany company = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId(), DeveloperCompany.class);
			assertEquals(company.getDeveloperCompanyId(), developerCompany.getDeveloperCompanyId());
		}
		
		
		@Test
		public void testGetServices() throws Exception{
			
			Account account = createAccount();
			String[] methods = {"DCS_CREATE_DEVELOPER_COMPANY","DCS_CREATE_SERVICE","DCS_GET_SERVICES"};
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
			
			DeveloperService service1 = TestData.getDeveloperService();
			service.setDeveloperCompany(developerCompany);
			
			DeveloperService resp1 =	executor.executePost("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", service1, DeveloperService.class);
			assertNotEquals(resp1.getServiceId(),null);

			DeveloperServices services = executor.executeGet("/developercompanies/"+developerCompany.getDeveloperCompanyId()+"/services", DeveloperServices.class);
			assertEquals(services.getServices().size(), 2);
			
		}
		
		/* Negative Test Cases Start  */		
		/*

		
		@Test
		public void testAssociateDeveloperAccountWithoutAccount() throws Exception {
			
			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = TestData.getAccount();
			account.setUsername("");
			Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class, null);	
		}
		
		@Test
		public void testAssociateDeveloperAccountWithoutDeveloperCompany() throws Exception  {
			
			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = TestData.getAccount();
			Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+1+"/accounts", dca, DeveloperCompanyAccount.class, responce.getOwner().getUsername());
			
		}
		
		@Test
		public void testAssociateDeveloperAccountWithWrongUser() throws Exception  {
			
			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = TestData.getAccount();
		//	Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class, responce.getOwner().getUsername());
			
		}
		
		
		@Test
		public void testAssociateDeveloperAccountWithAssociatedAccount() throws Exception  {
			
			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = developerCompany.getOwner();
		//	Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class, responce.getOwner().getUsername());
			
		}
		
		
		@Test
		public void testDissociateDeveloperAccountWithWrongDeveloperCompany() throws Exception {
			

			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = TestData.getAccount();
			Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class, null);	
			
			DeveloperCompanyAccount dcAccount = executeDelete("/developercompanies/"+responce.getDeveloperCompanyId()+1+"/accounts/"+account.getUsername(), null, DeveloperCompanyAccount.class, responce.getOwner().getUsername());
		
		}
		 
		
		@Test
		public void testDissociateDeveloperAccountWithWronguser() throws Exception {
			

			DeveloperCompany developerCompany=TestData.getDeveloperCompany();
			developerCompany.setOwner(TestData.getAccount());
	  		
			DeveloperCompany responce =	executePost("/developercompanies",developerCompany, DeveloperCompany.class,null); 
			Account account = TestData.getAccount();
		//	Account respAccount = executePost("/accounts",account, Account.class, null);
			
			DeveloperCompanyAccount dca =new DeveloperCompanyAccount();
			dca.setAccount(account);
			dca.setOwner(true);
			
			DeveloperCompanyAccount developerCompanyAccount = executePost("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts", dca, DeveloperCompanyAccount.class, null);	
			
			DeveloperCompanyAccount dcAccount = executeDelete("/developercompanies/"+responce.getDeveloperCompanyId()+"/accounts/"+account.getUsername(), null, DeveloperCompanyAccount.class, responce.getOwner().getUsername());
		
		}
		 */
		
		
}
