package com.servinglynk.hmis.warehouse.test.rest;

import java.util.UUID;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_MISSING_PARAMETER;
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

import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.ReleaseOfInfo;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.rest.common.ExceptionMapper;
import com.servinglynk.hmis.warehouse.test.core.CreateMasterData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestEnrollmentRestEndpoint {

	
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
	public void TestEnrollmentRestEndpoint_1_Create_Releae_Of_Info() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
	}
	
	@Test
	public void TestEnrollmentRestEndpoint_2_update_Releae_Of_Info() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
		
		releaseOfInfo.setConsented(false);
		releaseOfInfo =  executor.executePut("/enrollments/"+releaseOfInfo.getEnrollmentId(), releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertEquals(releaseOfInfo.isConsented(),false);
	}
	
	@Test
	public void TestEnrollmentRestEndpoint_3_delete_Releae_Of_Info() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
		
		releaseOfInfo.setConsented(false);
		releaseOfInfo =  executor.executeDelete("/enrollments/"+releaseOfInfo.getEnrollmentId(),ReleaseOfInfo.class);
		Assert.assertNull(releaseOfInfo.getRoleaseOfInfoId());
	}
	
	@Test
	public void TestEnrollmentRestEndpoint_4_create_Releae_Of_Info_without_Enrollment() throws Exception {
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		//releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		Errors errors  = executor.executePost("/enrollments", releaseOfInfo,Errors.class);
		Assert.assertEquals(errors.getError().get(0).getCode(),ERR_CODE_MISSING_PARAMETER);
		Assert.assertEquals(errors.getError().get(0).getMessage(),"Enrollment Id required");
		endSession(session);
	}
	
	
	@Test
	public void TestEnrollmentRestEndpoint_5_create_Releae_Of_Info_without_Consent() throws Exception {
		
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		//releaseOfInfo.setConsented(true);
		Errors errors  = executor.executePost("/enrollments", releaseOfInfo,Errors.class);
		Assert.assertEquals(errors.getError().get(0).getCode(),ERR_CODE_MISSING_PARAMETER);
		Assert.assertEquals(errors.getError().get(0).getMessage(),"Consented required");
		endSession(session);
	}
	
	@Test
	public void TestEnrollmentRestEndpoint_6_update_Releae_Of_Info_without_Enrollment() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
		
		ReleaseOfInfo releaseOfInfo1 = new ReleaseOfInfo();
		//releaseOfInfo1.setEnrollmentId(enrollmentId);
		releaseOfInfo1.setConsented(true);
		releaseOfInfo1.setRoleaseOfInfoId(releaseOfInfo.getRoleaseOfInfoId());
		Errors errors  =  executor.executePut("/enrollments/"+releaseOfInfo.getEnrollmentId(), releaseOfInfo1,Errors.class);
		Assert.assertEquals(errors.getError().get(0).getCode(),ERR_CODE_MISSING_PARAMETER);
		Assert.assertEquals(errors.getError().get(0).getMessage(),"Enrollment Id required");
		endSession(session);
	}
	
	
	@Test
	public void TestEnrollmentRestEndpoint_7_update_Releae_Of_Info_with_wrong_enrollment_id() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
		
		ReleaseOfInfo releaseOfInfo1 = new ReleaseOfInfo();
		releaseOfInfo1.setEnrollmentId(UUID.randomUUID());
		releaseOfInfo1.setConsented(true);
		releaseOfInfo1.setRoleaseOfInfoId(releaseOfInfo.getRoleaseOfInfoId());
		Errors errors  =  executor.executePut("/enrollments/"+UUID.randomUUID(), releaseOfInfo1,Errors.class);
		Assert.assertEquals(errors.getError().get(0).getCode(),ExceptionMapper.ERR_CODE_RELEASE_OF_INFO_NOT_FOUND);
		Assert.assertEquals(errors.getError().get(0).getMessage(),"Release Of Info not found");
		endSession(session);
	}
	
	@Test
	public void TestEnrollmentRestEndpoint_8_delete_Releae_Of_Info_with_wrong_enrollment_id() throws Exception {
		CreateMasterData data = new CreateMasterData();
		UUID organizationId = data.createOrganizations("Organization_"+System.currentTimeMillis());
		UUID projectId 	= data.createProjects(organizationId);
		UUID enrollmentId = data.createEnrollment(projectId);
		
		Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		ReleaseOfInfo releaseOfInfo = new ReleaseOfInfo();
		releaseOfInfo.setEnrollmentId(enrollmentId);
		releaseOfInfo.setConsented(true);
		releaseOfInfo = executor.executePost("/enrollments", releaseOfInfo,ReleaseOfInfo.class);
		Assert.assertNotNull(releaseOfInfo.getRoleaseOfInfoId());
		
		ReleaseOfInfo releaseOfInfo1 = new ReleaseOfInfo();
		releaseOfInfo1.setEnrollmentId(UUID.randomUUID());
		releaseOfInfo1.setConsented(true);
		releaseOfInfo1.setRoleaseOfInfoId(releaseOfInfo.getRoleaseOfInfoId());
		Errors errors  =  executor.executeDelete("/enrollments/"+UUID.randomUUID(), releaseOfInfo1,Errors.class);
		Assert.assertEquals(errors.getError().get(0).getCode(),ExceptionMapper.ERR_CODE_RELEASE_OF_INFO_NOT_FOUND);
		Assert.assertEquals(errors.getError().get(0).getMessage(),"Release Of Info not found");
		endSession(session);
	}
}
