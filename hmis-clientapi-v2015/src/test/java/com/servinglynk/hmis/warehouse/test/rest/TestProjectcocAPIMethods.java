package com.servinglynk.hmis.warehouse.test.rest;

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
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.Projectcocs;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestProjectcocAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    String[] methods = {"CLIENT_API_CREATE_PROJECTCOC","CLIENT_API_UPDATE_PROJECTCOC","CLIENT_API_DELETE_PROJECTCOC","CLIENT_API_GET_PROJECTCOC_BY_ID","CLIENT_API_GET_ALL_PROJECT_PROJECTCOC"};

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
	
	public UUID createProject() throws Exception{
		Project project = TestData.getProject();
		project = serviceFactory.getProjectService().createProject(project, createOrganization(), "UNIT TESING");
		return project.getProjectId();
	}
      
      
      
    @Test
    public void TestProjectcocAPIMethods_1_create_Projectcoc_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
   }

    @Test
    public void TestProjectcocAPIMethods_2_update_Projectcoc_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       projectcoc.setCoccode(TestData.generateRandomString(25));
       projectcoc= executor.executePut("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),projectcoc,Projectcoc.class);
   }

    @Test
    public void TestProjectcocAPIMethods_3_delete_Projectcoc_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 

       projectcoc= executor.executeDelete("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),projectcoc,Projectcoc.class);
       Assert.assertNull(projectcoc.getProjectcocId()); 
   }

    @Test
    public void TestProjectcocAPIMethods_4_getById_Projectcoc_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       
       
       Projectcoc newprojectcoc = executor.executeGet("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),Projectcoc.class);
       Assert.assertEquals(projectcoc.getProjectcocId(),newprojectcoc.getProjectcocId()); 
   }

    @Test
    public void TestProjectcocAPIMethods_5_getAllProject_Projectcoc_testcase() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 

       Projectcocs projectcocs = executor.executeGet("/projects/"+projectId+"/projectcocs",Projectcocs.class);
       Assert.assertEquals(projectcocs.getProjectcocs().size(),1); 
       // creating another record     
       projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 

       projectcocs = executor.executeGet("/projects/"+projectId+"/projectcocs",Projectcocs.class);
       Assert.assertEquals(projectcocs.getProjectcocs().size(),2); 
   }

    @Test
    public void TestProjectcocAPIMethods_6_create_Projectcoc_with_unknownProject() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());


       UUID projectId = UUID.randomUUID();
       Projectcoc projectcoc = TestData.getProjectcoc();

       Errors errors = executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"PROJECT_NOT_FOUND"); 
   }

    @Test
    public void TestProjectcocAPIMethods_7_update_Projectcoc_with_unknownProject() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
    
       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       
       projectId = UUID.randomUUID();
       
       projectcoc.setCoccode(TestData.generateRandomString(20));
       
       Errors errors = executor.executePut("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),projectcoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"PROJECT_NOT_FOUND"); 
   }

    @Test
    public void TestProjectcocAPIMethods_8_delete_Projectcoc_with_unknownProject() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       
       projectId = UUID.randomUUID();

       Errors errors = executor.executeDelete("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),projectcoc,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"PROJECT_NOT_FOUND"); 
   }

    @Test
    public void TestProjectcocAPIMethods_9_getById_Projectcoc_with_unknownProject() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       
       projectId = UUID.randomUUID();
       
       Errors errors = executor.executeGet("/projects/"+projectId+"/projectcocs/"+projectcoc.getProjectcocId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"PROJECT_NOT_FOUND"); 
   }

    @Test
    public void TestProjectcocAPIMethods_10_getAllProject_Projectcoc_with_unknowClient() throws Exception {
       Account account = createAccount();
       addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID projectId = createProject(); 
       Projectcoc projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 
       

       
       // creating another record     
       projectcoc = TestData.getProjectcoc();

       projectcoc= executor.executePost("/projects/"+projectId+"/projectcocs",projectcoc,Projectcoc.class);
       Assert.assertNotNull(projectcoc.getProjectcocId()); 

       projectId = UUID.randomUUID();
       
       Errors errors = executor.executeGet("/projects/"+projectId+"/projectcocs",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"PROJECT_NOT_FOUND"); 
   }

}