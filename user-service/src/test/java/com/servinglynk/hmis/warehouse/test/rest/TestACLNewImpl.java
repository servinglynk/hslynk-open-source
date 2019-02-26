package com.servinglynk.hmis.warehouse.test.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;

import java.util.UUID;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.common.ErrorCodes;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.test.core.CreateMasterData;
import com.servinglynk.hmis.warehouse.test.core.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestACLNewImpl {
	
	//protected final Log LOG = LogFactory.getLog(getClass());
	
	final static Logger LOG = Logger.getLogger(TestACLNewImpl.class);

	@Before
	public void init(){
		LOG.setLevel(Level.TRACE);
	}
	

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
	public void TestACLNewImpl_1_permissionset_testing_testcase() throws Exception {
		
		WebserviceTestExecutor noSessionExecutor= new WebserviceTestExecutor(wac);
		noSessionExecutor.setAcceptHeaderAsJson();
		noSessionExecutor.setContentTypeHeaderAsJson();
		
		
		// Step 1: Login as superadmin, With Super Admin Privileges
		Session superAdminSession = createSession("superadmin@hmis.com","password");
		LOG.error("Step 1: Logged with Super Admin Privileges");
		
		
		// Step 2: Creating Organization
		CreateMasterData data = new CreateMasterData();
		String orgnizationName="Organization 1_"+System.currentTimeMillis();
		UUID orgId = data.createOrganizations(orgnizationName);
		LOG.error("Step 2: Organiation Created. Organization Name :"+orgnizationName);
		
		
		// Step 3: Creating Standard Profile using superadmin session
		Profile standardProfile = TestData.getProfile("StandardProfile");
		ApiMethod logoutMethod = new ApiMethod();
		logoutMethod.setExternalId("USR_END_SESSION");
		ApiMethod accStatustMethod = new ApiMethod();
		accStatustMethod.setExternalId("USR_GET_ACCOUNT_STATUS");
		standardProfile.addApiMethod(logoutMethod);
		standardProfile.addApiMethod(accStatustMethod);
		
		WebserviceTestExecutor superAdminexecutor = new WebserviceTestExecutor(wac);
		superAdminexecutor.setAcceptHeaderAsJson();
		superAdminexecutor.setContentTypeHeaderAsJson();
		superAdminexecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		superAdminexecutor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+superAdminSession.getToken());
		standardProfile = superAdminexecutor.executePost("/profiles", standardProfile ,Profile.class);  // Profile Created
		LOG.error("Step 3: Profile Created. Profile Name :"+standardProfile.getProfileName());
		
		
		// Step 4: Creating cmUser using superadmin session
		Account cmuser = TestData.getAccount("cmuser");
		cmuser.setOrganizationId(orgId);
		cmuser.setProfile(standardProfile);
		cmuser = superAdminexecutor.executePost("/accounts",cmuser,Account.class); // User Created
		LOG.error("step 4: User Created. User Name :"+cmuser.getUsername()+"  With Profile "+standardProfile.getProfileName());
		
		
		// Step 5 : Activating newly created user using with out session
		Parameter parameter=new Parameter();
		parameter.setKey("username");
		parameter.setValue(cmuser.getUsername().toLowerCase());
		
		Verification verification = new Verification();
		verification.setType(VERIFICATION_TYPE_ACCOUNT_CREATION);
		verification.setStatus(VERIFICATION_STATUS_ACCEPTED);
		verification.addParameter(parameter);
		
		superAdminexecutor.executePut("/verifications/"+cmuser.getVerificationToken()+"/status", verification,Verification.class); // User Activated
		LOG.error("Step 5: User Activated. User name "+cmuser.getUsername()+" Activated");
	//	endSession(session);  // Closing super admin session
		
		// Checking Access Without permission to access a method 
		
		// Step 6: Login as cmuser credentials 
		Session cmuserSession = createSession(cmuser.getUsername(),"password"); // Login with cmuser
		LOG.error("Step 6: cmuser LOgged in.");
		
		//Step 7: Creating executor for cmuser.
		WebserviceTestExecutor cmuserExecutor = new WebserviceTestExecutor(wac);
		cmuserExecutor.setAcceptHeaderAsJson();
		cmuserExecutor.setContentTypeHeaderAsJson();
		cmuserExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		cmuserExecutor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+cmuserSession.getToken());
		LOG.error("Step 7: Executor created.");

		
		// Step 8: Getting cmuser account status using cmuser session. cmuser having permission to access account status endpoint
		Account statusAccount = cmuserExecutor.executeGet("/accounts/"+cmuser.getUsername()+"/status", Account.class); // Accounts Status
		
		Assert.assertEquals(statusAccount.getStatus(), "ACTIVE");
		LOG.error("Step 8: User able to got user's status. User Name "+cmuser.getUsername()+" status "+statusAccount.getStatus());
		
		
		// Step 9: Updating cmuser account using cmuser session. cmuser don't have permission to access update endpoint.
		// So, error response will come.
		cmuser.setFirstName("Updated First Name");
		
		Errors errors = cmuserExecutor.executePut("/accounts/"+cmuser.getUsername(),cmuser,Errors.class);  // Updating a account (User don't have access API Method)
		
		Assert.assertNotNull(errors);
		Assert.assertEquals(errors.getError().get(0).getCode(),ErrorCodes.ERR_CODE_ACCESS_DENIED);
		
		LOG.error("Step 9: cmuser got error responce. Error message is - "+errors.getError().get(0).getMessage());
	//	endSession(userSession); // Closing cmuser user session
		
		
		// Step 10: Creating Permission set with updateuser endpoint. PermissionSet is creating using superadmin  session
		PermissionSet testPermissionSet =new PermissionSet();
		testPermissionSet.setPermissionSetName("Test Permission Set");
		testPermissionSet.setPermissionSetDescription("Test Permission Set");
		
		ApiMethod apiMethod = new ApiMethod();
		apiMethod.setExternalId("USR_UPDATE_ACCOUNT");
		testPermissionSet.addApiMethod(apiMethod);
		
		testPermissionSet =superAdminexecutor.executePost("/permissionsets",testPermissionSet,PermissionSet.class);
		LOG.error("Step 10: PermissionSet created. PermissionSet name is "+testPermissionSet.getPermissionSetName());
		
		
		//Step 11: Assigning testpemissionset to cmuser using superadmin session
		superAdminexecutor.executePost("/permissionsets/"+cmuser.getUsername()+"/assignpermissionset",testPermissionSet); //  Assigning Permission Set to create User
		LOG.error("Step 11: "+testPermissionSet.getPermissionSetName()+" permissionset is assigned to user "+cmuser.getUsername());
		
		
		// Step 12: Again cmuser is updating user account with cmuser session. 
		// Now cmuser having permission to access this endpoint through permissionn set.
		Account updAccount = cmuserExecutor.executePut("/accounts/self",cmuser,Account.class);  // Updating a account ( Access API Method granted through Permission Set)
		Assert.assertEquals(updAccount.getFirstName(),"Updated First Name");
		LOG.error("Step 12: User updated.");
	}

	
	@Test
	public void TestACLNewImpl_1_creating_sharingrule_testing_testcase() throws Exception {
		
		CreateMasterData data = new CreateMasterData();
		
		// Step 1: creating 2 Organizations 
		UUID org1=data.createOrganizations("Organization 1");
		UUID org2=data.createOrganizations("Organization 2");
		LOG.error("Step 1: Organizations are created.");
		
		// Step 2: Creating 2 Projects for each organization
		UUID proj1= data.createProjects(org1);
		UUID proj2=data.createProjects(org1);
		UUID proj3= data.createProjects(org2);
		UUID proj4=data.createProjects(org2);
		LOG.error("Step 2: Projects are created.");
		
		// Step 3: 4 enrollments are creating for project 1 and organization 1 
		UUID enroll1=data.createEnrollment(proj1);
		UUID enroll2=data.createEnrollment(proj1);
		UUID enroll3=data.createEnrollment(proj1);
		UUID enroll4=data.createEnrollment(proj1);
		LOG.error("Step 3: Enrollments are created");
		
		// Step 4: Login with superadmin user
		Session superAdminSession= createSession("superadmin@hmis.com", "password");
		LOG.error("Step 4: super admin loggedin.");
		
		// Step 5: Creating superadmin executor
		WebserviceTestExecutor superadminExecutor = new WebserviceTestExecutor(wac);
		superadminExecutor.setAcceptHeaderAsJson();
		superadminExecutor.setContentTypeHeaderAsJson();
		superadminExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		superadminExecutor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+superAdminSession.getToken());
		LOG.error("Step 5: superadmin executor created.");
		
		
		//Step 6: Creating Project Manager Role using superadmin session
		Role projectManagerRole = TestData.getRole("Project Manager");
		
		projectManagerRole = superadminExecutor.executePost("/roles",projectManagerRole,Role.class);
		LOG.error("Step 6: Role Created. Role Name is  "+projectManagerRole.getRoleName());
		
		//Step 7: Creating Standard User with Project Manager Role as parent role using superadmin session
		Role standardRole = TestData.getRole("Standard");
		standardRole.setParentRole(projectManagerRole);
		
		standardRole = superadminExecutor.executePost("/roles",standardRole,Role.class);
		LOG.error("Step 7: Role Created. Role Name is  "+standardRole.getRoleName());
		
		
		// Step 8: Creating sharingrule for standard role with superadmin session 
	/*	SharingRule sharingRule = new SharingRule();
		sharingRule.setFromOrganization(org1);
		sharingRule.setToOrganization(org2);
		sharingRule.addProject(new Project(proj2));
		sharingRule.addEnrollment(new Enrollment(enroll1));		
		sharingRule.addRole(standardRole);
		sharingRule.setActiveFrom(new Date());
		sharingRule.setActiveTo(DateUtils.addDays(new Date(), 20));
		
		superadminExecutor.executePost("/sharingrules", sharingRule);*/
		LOG.info("Step 8: Sharing rule created.");
		
	}
}
