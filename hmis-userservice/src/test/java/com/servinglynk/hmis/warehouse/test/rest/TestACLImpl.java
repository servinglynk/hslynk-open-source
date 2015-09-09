package com.servinglynk.hmis.warehouse.test.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.servinglynk.hmis.warehouse.common.ErrorCodes;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.SharingRules;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.test.core.CreateMasterData;
import com.servinglynk.hmis.warehouse.test.core.TestCaseExecutor;
import com.servinglynk.hmis.warehouse.test.core.TestData;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestACLImpl extends TestCaseExecutor {
		
	@Test
	public void createCaseManagerRole() throws Exception {
		Session session = new Session();
		Account account = new Account();
		account.setUsername("superadmin@hmis.com");
		account.setPassword("password");
		session.setAccount(account);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");

		Session sesResp = executeTest(HttpMethod.POST,"/sessions",session,Session.class, headers);
		
		System.out.println("Session token is "+sesResp.getToken());
		
		headers.put("Authorization","HMISHNUserAuth session_token="+sesResp.getToken());
		Role role = TestData.getRole("CaseManager");
		
		Role roleResp = executeTest(HttpMethod.POST,"/roles",role,Role.class, headers);
		
		executeTest(HttpMethod.DELETE,"/sessions/"+sesResp.getToken(), null, Session.class, headers);
		
	}
	
	
	
	public Session createSession(String userName,String password) throws Exception {
		Session session = new Session();
		Account account = new Account();
		account.setUsername(userName);
		account.setPassword(password);
		session.setAccount(account);
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");

		Session sesResp = executeTest(HttpMethod.POST,"/sessions",session,Session.class, headers);
		return sesResp;

	}
	
	public void endSession(String token) throws Exception {

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+token);
		executeTest(HttpMethod.DELETE,"/sessions/"+token, null, Session.class, headers);
		
	}
	
	@Test
	public void createStandardProfile() throws Exception {
		
		Session session= createSession("superadmin@hmis.com", "password");
		
		Profile profile = TestData.getProfile("Standard Profile");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		 
		Profile restProfile = executeTest(HttpMethod.POST,"/profiles", profile,Profile.class, headers);
		Assert.assertNotNull(restProfile.getId());
		endSession(session.getToken());
		
	}
	
	@Test
	public void createTestProfile() throws Exception {
		
		Session session= createSession("superadmin@hmis.com", "password");
		
		Profile profile = TestData.getProfile("Test Profile");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		 
		Profile restProfile = executeTest(HttpMethod.POST,"/profiles", profile,Profile.class, headers);
		Assert.assertNotNull(restProfile.getId());
		
		
		
		endSession(session.getToken());
		
	}
	
	@Test
	public void createOrg1CMUserWithStandardProfile() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID org1=data.createOrganizations("Organization 1");
		Session session= createSession("superadmin@hmis.com", "password");
		
		Profile profile = TestData.getProfile("Standard Profile");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		 
		Profile restProfile = executeTest(HttpMethod.POST,"/profiles", profile,Profile.class, headers);
		Assert.assertNotNull(restProfile.getId());
		
		Account account = TestData.getAccount("CMUser");
		account.setProfile(restProfile);
		account.setOrganizationId(org1);

		Account respAccount = executeTest(HttpMethod.POST, "/accounts", account, Account.class, headers);
		
		Parameter parameter=new Parameter();
		parameter.setKey("username");
		parameter.setValue(respAccount.getUsername().toLowerCase());
		
		Verification verification = new Verification();
		//verification.setToken("85DA684D51394E02BB3091154A5BC5870A7A79A68FB343409E3EAEE5D6C7E574");
		verification.setType(VERIFICATION_TYPE_ACCOUNT_CREATION);
		verification.addParameter(parameter);
		
	
		executeTest(HttpMethod.POST,"/verifications", verification,Verification.class, headers);
		
		verification.setStatus(VERIFICATION_STATUS_ACCEPTED);
		
		executeTest(HttpMethod.PUT,"/verifications/"+respAccount.getVerificationToken()+"/status", verification,Verification.class, headers);
		
		endSession(session.getToken());
		
	}
	
/*	@Test
	public void activateUserWithVerification() throws Exception{
		Session session= createSession("superadmin@hmis.com", "password");
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
	
		Verification verification = new Verification();
		verification.setStatus(VERIFICATION_STATUS_ACCEPTED);
		
	
		String verificationToken = "B802EAE3A0A44B569ECEC6308E8E37AFD135E55FFB094C1D902B81C5653F9547";
		
		
		executeTest(HttpMethod.PUT,"/verifications/"+verificationToken+"/status", verification,Verification.class, headers);
	}*/

	
	@Test
	public void checkAccessMethodWithoutPermission() throws Exception {
		
//		String userName = "cmuser_1440599592680@hmis.com";

		String userName = "superadmin@hmis.com";
	
		Session session = createSession(userName, "password");
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Errors errors = executeTest(HttpMethod.GET,"/accounts/"+userName+"/emailaddress", null, Errors.class, headers);
		
		Assert.assertEquals(errors.getError().get(0).getCode(),ErrorCodes.ERR_CODE_ACCESS_DENIED);

		endSession(session.getToken());

	}
	
	@Test
	public void addingPermisstionAndTrying() throws Exception {
		
		String userName = "cmuser_1440599592680@hmis.com";
		
		PermissionSet permissionSet = new PermissionSet();
		permissionSet.setPermissionSetName("Permissionset to access User Email Address method");
		permissionSet.setPermissionSetDescription("Desc Permissionset to access User Email Address method");
		
		ApiMethod apiMethod = new ApiMethod();
		apiMethod.setExternalId("USR_GET_ACCOUNT_EMAIL_ADDRESS");
		permissionSet.addApiMethod(apiMethod);
		
		
		Session session= createSession("superadmin@hmis.com", "password");
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		PermissionSet respPerSet = executeTest(HttpMethod.POST,"/permissionsets", permissionSet, PermissionSet.class, headers);
		
		 executeTest(HttpMethod.POST,"/permissionsets/"+userName+"/assignpermissionset", respPerSet,null, headers);
	
		 endSession(session.getToken());
		
	}
	
	@Test
	public void tryingToAccessUsingPermissionSet() throws Exception {
	
	String userName = "cmuser_1440599592680@hmis.com";
	
	Session session1 = createSession(userName, "password");
	
	Map<String, String> headers1 = new HashMap<String, String>();
	headers1.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	headers1.put("Authorization","HMISHNUserAuth session_token="+session1.getToken());
	
	Account account = executeTest(HttpMethod.GET,"/accounts/self/emailaddress", null, Account.class, headers1);
	System.out.println(account.toJSONString());
	Assert.assertEquals(account.getEmailAddress(),userName);

	//endSession(session1.getToken());

	}
	
	@Test
	public void createSharingRule() throws Exception {
		
		CreateMasterData data = new CreateMasterData();
		
		
		UUID org1=data.createOrganizations("Organization 1");
		UUID org2=data.createOrganizations("Organization 2");
		UUID proj1= data.createProjects(org1);
		UUID proj2=data.createProjects(org1);
		UUID proj3= data.createProjects(org2);
		UUID proj4=data.createProjects(org2);
		UUID enroll1=data.createEnrollment(proj1);
		UUID enroll2=data.createEnrollment(proj1);
		UUID enroll3=data.createEnrollment(proj1);
		UUID enroll4=data.createEnrollment(proj1);
		
		SharingRule sharingRule = new SharingRule();
		sharingRule.setFromOrganization(org1);
		sharingRule.setToOrganization(org2);
		sharingRule.addProject(new Project(proj2));
		sharingRule.addEnrollment(new Enrollment(enroll1));
		
		Session session= createSession("superadmin@hmis.com", "password");
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");

		
		headers.put("Authorization","HMISHNUserAuth session_token="+session.getToken());
		Role role = TestData.getRole("Project Manager");
		
		Role pRole = executeTest(HttpMethod.POST,"/roles",role,Role.class, headers);
		
		Role crole = TestData.getRole("Project Manager");
		crole.setParentRole(pRole);
		
		Role cpRole = executeTest(HttpMethod.POST,"/roles",crole,Role.class, headers);
		
		sharingRule.addRole(cpRole);
		
		executeTest(HttpMethod.POST,"/sharingrules", sharingRule,SharingRules.class, headers);
		
		endSession(session.getToken());
		
	}
	
}
