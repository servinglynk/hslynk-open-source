package com.servinglynk.hmis.warehouse.test.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.ApiMethodAuthorizationCheck;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestApiMethodAuthorizationChecksRestEndpoint {
	
	@Autowired ParentServiceFactory serviceFactory;
	
	protected final Log LOG = LogFactory.getLog(getClass());
	

	@Autowired WebApplicationContext wac;
	
	
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
		
		Session sess = executor.executePost("/sessions",session,Session.class);
		Assert.assertNotNull(sess.getToken());
		return sess;
	}
	
	public void endSession(Session session) throws Exception {
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		executor.executeDelete("/sessions/"+session.getToken());
	}


	
	@Test
	public void testCheckApiAuthorization() throws Exception {
		
		Profile profile = TestData.getProfile("APIAuthorizationTestUser"+System.currentTimeMillis());
		ApiMethod method = new ApiMethod();
		method.setExternalId("");
		profile.addApiMethod(method);
		Account account = TestData.getAccount();
		account.setProfile(profile);
		Account newAccount =  serviceFactory.getAccountService().createAccount(account,USER_SERVICE,"Tesing");
	

		DeveloperCompany developerCompany=TestData.getDeveloperCompany();
		developerCompany.setOwner(TestData.getAccount());
 
  		DeveloperCompany responce = serviceFactory.getDeveloperCompanyService().createDeveloperCompany(developerCompany, Constants.USER_SERVICE);
 		
		DeveloperService service = TestData.getDeveloperService();
		service.setDeveloperCompany(responce);
		
		
		DeveloperService resp = serviceFactory.getDeveloperCompanyService().addNewService(responce.getDeveloperCompanyId(), service, newAccount,Constants.USER_SERVICE);

		
		TrustedApp trustedApp = TestData.getTrustedApp();
		trustedApp.setService(resp);
		
		TrustedApp trustedApp2 = serviceFactory.getTrustedAppService().createTrustedAppForDevelopers(trustedApp, resp.getServiceId(),newAccount.getUsername(),Constants.USER_SERVICE);
		
		Assert.assertNotEquals(trustedApp2.getTrustedAppId(),null);
		
		
		Session session = createSession(newAccount.getUsername(),account.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ApiMethod apiMethod = TestData.getApiMethod();
		ApiMethod newApiMethod = executor.executePost("/apiMethod/createMethod",apiMethod, ApiMethod.class);
		Assert.assertNotEquals(newApiMethod.getExternalId(),null);
		
		executor.executePost("/apiMethod/"+resp.getServiceId()+"/"+newApiMethod.getExternalId(),null);
		
		
		ApiMethodAuthorizationCheck check = new ApiMethodAuthorizationCheck();
		check.setAccount(newAccount);
		check.setApiMethodId(newApiMethod.getExternalId());
		check.setCheckSessionToken(false);
		check.setTrustedApp(trustedApp2);
		check.setTrustedAppId(trustedApp2.getTrustedAppId());
		
		ApiMethodAuthorizationCheck newCheck  =  executor.executePost("/apimethodauthcheck", check, ApiMethodAuthorizationCheck.class);
		
		System.out.println("New Check details "+newCheck.toJSONString());
		
		
	}
	
	
	
	@Test
	public void createApiMethod() throws Exception {
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ApiMethod apiMethod = TestData.getApiMethod();
		ApiMethod newApiMethod = executor.executePost("/apiMethod/createMethod",apiMethod, ApiMethod.class);
		Assert.assertNotEquals(newApiMethod.getExternalId(),null);
	}

}
