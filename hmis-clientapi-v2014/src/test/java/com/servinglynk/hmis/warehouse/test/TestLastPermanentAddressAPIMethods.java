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
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddresses;
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
public class TestLastPermanentAddressAPIMethods {

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
    public void TestLastPermanentAddressAPIMethods_1_create_LastPermanentAddress_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_2_update_LastPermanentAddress_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 
       // set new values for update the data
       lastPermanentAddress= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress,LastPermanentAddress.class);
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_3_delete_LastPermanentAddress_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       lastPermanentAddress= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNull(lastPermanentAddress.getLastPermanentAddressId()); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_4_getById_LastPermanentAddress_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       LastPermanentAddress newlastPermanentAddress = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),LastPermanentAddress.class);
       Assert.assertEquals(lastPermanentAddress.getLastPermanentAddressId(),newlastPermanentAddress.getLastPermanentAddressId()); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_5_getAllEnrollment_LastPermanentAddress_testcase() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       LastPermanentAddresses lastPermanentAddresss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",LastPermanentAddresses.class);
       Assert.assertEquals(lastPermanentAddresss.getLastPermanentAddresses().size(),1); 
       // creating another record     
       lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       lastPermanentAddresss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",LastPermanentAddresses.class);
       Assert.assertEquals(lastPermanentAddresss.getLastPermanentAddresses().size(),2); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_6_create_LastPermanentAddress_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
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
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_7_update_LastPermanentAddress_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_8_delete_LastPermanentAddress_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_9_getById_LastPermanentAddress_with_unknownClinet() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_10_getAllEnrollment_LastPermanentAddress_with_unknowClient() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       // creating another record     
       lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_11_create_LastPermanentAddress_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
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
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_12_update_LastPermanentAddress_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_13_delete_LastPermanentAddress_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),lastPermanentAddress,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_14_getById_LastPermanentAddress_with_unknownEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses/"+lastPermanentAddress.getLastPermanentAddressId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestLastPermanentAddressAPIMethods_15_getAllEnrollment_LastPermanentAddress_with_unknowEnrollment() throws Exception {
       Account account = createAccount();
       String[] methods = {"CLIENT_API_CREATE_LASTPERMANENTADDRESS","CLIENT_API_UPDATE_LASTPERMANENTADDRESS","CLIENT_API_DELETE_LASTPERMANENTADDRESS","CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS"};
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = createClient(); 
       UUID enrollmentId = createEnrollment(clientId); 
       LastPermanentAddress lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       // creating another record     
       lastPermanentAddress = TestData.getLastPermanentAddress();

       lastPermanentAddress= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",lastPermanentAddress,LastPermanentAddress.class);
       Assert.assertNotNull(lastPermanentAddress.getLastPermanentAddressId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/lastpermanentaddresses",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
