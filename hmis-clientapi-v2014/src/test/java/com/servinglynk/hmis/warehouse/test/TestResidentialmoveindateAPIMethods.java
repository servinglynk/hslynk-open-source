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
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestResidentialmoveindateAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    String[] methods = {"CLIENT_API_CREATE_RESIDENTIALMOVEINDATE","CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE","CLIENT_API_DELETE_RESIDENTIALMOVEINDATE","CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE"};

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
    public void TestResidentialmoveindateAPIMethods_1_create_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_2_update_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       // set new values for update the data
       residentialmoveindate= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Residentialmoveindate.class);
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_3_delete_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       residentialmoveindate= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNull(residentialmoveindate.getResidentialmoveindateId()); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_4_getById_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       Residentialmoveindate newresidentialmoveindate = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Residentialmoveindate.class);
       Assert.assertEquals(residentialmoveindate.getResidentialmoveindateId(),newresidentialmoveindate.getResidentialmoveindateId()); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_5_getAllEnrollment_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       Residentialmoveindates residentialmoveindates = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Residentialmoveindates.class);
       Assert.assertEquals(residentialmoveindates.getResidentialmoveindates().size(),1); 
       // creating another record     
       residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       residentialmoveindates = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Residentialmoveindates.class);
       Assert.assertEquals(residentialmoveindates.getResidentialmoveindates().size(),2); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_6_create_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_7_update_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_8_delete_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_9_getById_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_10_getAllEnrollment_Residentialmoveindate_with_unknowClient() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       // creating another record     
       residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_11_create_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_12_update_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_13_delete_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_14_getById_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_15_getAllEnrollment_Residentialmoveindate_with_unknowEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       // creating another record     
       residentialmoveindate = TestData.getResidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
