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
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestEmploymentAPIMethods {

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
    public void TestEmploymentAPIMethods_1_create_Employment_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
   }

    @Test
    public void TestEmploymentAPIMethods_2_update_Employment_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       // set new values for update the data
       employment= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Employment.class);
   }

    @Test
    public void TestEmploymentAPIMethods_3_delete_Employment_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       employment= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Employment.class);
       Assert.assertNull(employment.getEmploymentId()); 
   }

    @Test
    public void TestEmploymentAPIMethods_4_getById_Employment_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       Employment newemployment = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Employment.class);
       Assert.assertEquals(employment.getEmploymentId(),newemployment.getEmploymentId()); 
   }

    @Test
    public void TestEmploymentAPIMethods_5_getAllEnrollment_Employment_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       Employments employments = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Employments.class);
       Assert.assertEquals(employments.getEmployments().size(),1); 
       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       employments = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Employments.class);
       Assert.assertEquals(employments.getEmployments().size(),2); 
   }

    @Test
    public void TestEmploymentAPIMethods_6_create_Employment_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
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
       Employment employment = TestData.getEmployment();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_7_update_Employment_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_8_delete_Employment_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_9_getById_Employment_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_10_getAllEnrollment_Employment_with_unknowClient() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_11_create_Employment_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
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
       Employment employment = TestData.getEmployment();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_12_update_Employment_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_13_delete_Employment_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_14_getById_Employment_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_15_getAllEnrollment_Employment_with_unknowEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
