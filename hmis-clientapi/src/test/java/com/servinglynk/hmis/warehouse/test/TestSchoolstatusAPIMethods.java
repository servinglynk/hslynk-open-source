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
import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatuses;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestSchoolstatusAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    String[] methods = {"CLIENT_API_CREATE_SCHOOLSTATUS","CLIENT_API_UPDATE_SCHOOLSTATUS","CLIENT_API_DELETE_SCHOOLSTATUS","CLIENT_API_GET_SCHOOLSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_SCHOOLSTATUS"};

      
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
    public void TestSchoolstatusAPIMethods_1_create_Schoolstatus_testcase() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_2_update_Schoolstatus_testcase() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 
       // set new values for update the data
       schoolstatus= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus,Schoolstatus.class);
   }

    @Test
    public void TestSchoolstatusAPIMethods_3_delete_Schoolstatus_testcase() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       schoolstatus= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus,Schoolstatus.class);
       Assert.assertNull(schoolstatus.getSchoolstatusId()); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_4_getById_Schoolstatus_testcase() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       Schoolstatus newschoolstatus = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),Schoolstatus.class);
       Assert.assertEquals(schoolstatus.getSchoolstatusId(),newschoolstatus.getSchoolstatusId()); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_5_getAllEnrollment_Schoolstatus_testcase() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       Schoolstatuses schoolstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",Schoolstatuses.class);
       Assert.assertEquals(schoolstatuss.getSchoolstatuses().size(),1); 
       // creating another record     
       schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       schoolstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",Schoolstatuses.class);
       Assert.assertEquals(schoolstatuss.getSchoolstatuses().size(),2); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_6_create_Schoolstatus_with_unknownClinet() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_7_update_Schoolstatus_with_unknownClinet() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_8_delete_Schoolstatus_with_unknownClinet() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_9_getById_Schoolstatus_with_unknownClinet() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_10_getAllEnrollment_Schoolstatus_with_unknowClient() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       // creating another record     
       schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_11_create_Schoolstatus_with_unknownEnrollment() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_12_update_Schoolstatus_with_unknownEnrollment() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_13_delete_Schoolstatus_with_unknownEnrollment() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),schoolstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_14_getById_Schoolstatus_with_unknownEnrollment() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss/"+schoolstatus.getSchoolstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestSchoolstatusAPIMethods_15_getAllEnrollment_Schoolstatus_with_unknowEnrollment() throws Exception {
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
       Schoolstatus schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       // creating another record     
       schoolstatus = TestData.getSchoolstatus();

       schoolstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",schoolstatus,Schoolstatus.class);
       Assert.assertNotNull(schoolstatus.getSchoolstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/schoolstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
