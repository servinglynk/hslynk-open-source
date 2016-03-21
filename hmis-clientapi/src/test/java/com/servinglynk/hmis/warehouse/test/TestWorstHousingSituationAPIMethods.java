package com.servinglynk.hmis.warehouse.test;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

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
import com.servinglynk.hmis.warehouse.config.ClientAPIConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituations;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestWorstHousingSituationAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    String[] methods = {"CLIENT_API_CREATE_WORSTHOUSINGSITUATION","CLIENT_API_UPDATE_WORSTHOUSINGSITUATION","CLIENT_API_DELETE_WORSTHOUSINGSITUATION","CLIENT_API_GET_WORSTHOUSINGSITUATION_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_WORSTHOUSINGSITUATION"};

      
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
  		account.setOrganizationId(createOrganization());
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
  	
  	public UUID createClient() throws Exception{
  		
  		   Account account = createAccount();
  	       String[] methods = {"CLIENT_API_CREATE_CLIENT"};
  	       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
  	       Session session = createSession(account.getUsername(),account.getPassword());

  	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
  	       executor.setAcceptHeaderAsJson();
  	       executor.setContentTypeHeaderAsJson();
  	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
  	       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
  	       
  	       Client client = TestData.getClient();
  	       client = executor.executePost("/clients", client, Client.class);
  	       assertNotNull(client.getClientId());
  		
  		return client.getClientId();
  	}
  	
  	public UUID createEnrollment(UUID clientId) throws Exception{

  		   Account account = createAccount();
  	       String[] methods = {"CLIENT_API_CREATE_ENROLLMENT"};
  	       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
  	       Session session = createSession(account.getUsername(),account.getPassword());

  	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
  	       executor.setAcceptHeaderAsJson();
  	       executor.setContentTypeHeaderAsJson();
  	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
  	       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
  	       
  	       Enrollment enrollment = TestData.getEnrollment(clientId);
  	       enrollment = executor.executePost("/clients/"+clientId+"/enrollments", enrollment, Enrollment.class);
  	       assertNotNull(enrollment.getClientId());

  		return enrollment.getEnrollmentId();
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
      
  	
  	public UUID createOrganization() throws Exception {
  		 Organization organization = TestData.getOrganization();
  		 organization =serviceFactory.getOrganizationService().createOrganization(organization, "UNIT TESTING");
  		 return organization.getOrganizationId();
  	}   
      
    @Test
    public void TestWorstHousingSituationAPIMethods_1_create_WorstHousingSituation_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_2_update_WorstHousingSituation_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 
       // set new values for update the data
       worstHousingSituation= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation,WorstHousingSituation.class);
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_3_delete_WorstHousingSituation_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       worstHousingSituation= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNull(worstHousingSituation.getWorstHousingSituationId()); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_4_getById_WorstHousingSituation_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       WorstHousingSituation newworstHousingSituation = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),WorstHousingSituation.class);
       Assert.assertEquals(worstHousingSituation.getWorstHousingSituationId(),newworstHousingSituation.getWorstHousingSituationId()); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_5_getAllEnrollment_WorstHousingSituation_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       WorstHousingSituations worstHousingSituations = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",WorstHousingSituations.class);
       Assert.assertEquals(worstHousingSituations.getWorstHousingSituations().size(),1); 
       // creating another record     
       worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       worstHousingSituations = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",WorstHousingSituations.class);
       Assert.assertEquals(worstHousingSituations.getWorstHousingSituations().size(),2); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_6_create_WorstHousingSituation_with_unknownClinet() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       clientId = UUID.randomUUID();
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_7_update_WorstHousingSituation_with_unknownClinet() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_8_delete_WorstHousingSituation_with_unknownClinet() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_9_getById_WorstHousingSituation_with_unknownClinet() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_10_getAllEnrollment_WorstHousingSituation_with_unknowClient() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       // creating another record     
       worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_11_create_WorstHousingSituation_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       enrollmentId = UUID.randomUUID();
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_12_update_WorstHousingSituation_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_13_delete_WorstHousingSituation_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),worstHousingSituation,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_14_getById_WorstHousingSituation_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations/"+worstHousingSituation.getWorstHousingSituationId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestWorstHousingSituationAPIMethods_15_getAllEnrollment_WorstHousingSituation_with_unknowEnrollment() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       WorstHousingSituation worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       // creating another record     
       worstHousingSituation = TestData.getWorstHousingSituation();

       worstHousingSituation= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",worstHousingSituation,WorstHousingSituation.class);
       Assert.assertNotNull(worstHousingSituation.getWorstHousingSituationId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/worsthousingsituations",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
