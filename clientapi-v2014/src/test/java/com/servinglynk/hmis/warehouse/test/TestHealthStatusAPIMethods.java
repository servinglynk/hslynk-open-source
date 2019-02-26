package com.servinglynk.hmis.warehouse.test;

import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_STATUS_ACCEPTED;
import static com.servinglynk.hmis.warehouse.common.Constants.VERIFICATION_TYPE_ACCOUNT_CREATION;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
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
import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.core.model.HealthStatuses;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.BasicTestMethods;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestHealthStatusAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;
    
    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }


    
    @Test
    public void TestHealthStatusAPIMethods_1_create_HealthStatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 
   }

    @Test
    public void TestHealthStatusAPIMethods_2_update_HealthStatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 
       // set new values for update the data
       healthStatus= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus,HealthStatus.class);
   }

    @Test
    public void TestHealthStatusAPIMethods_3_delete_HealthStatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       healthStatus= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus,HealthStatus.class);
       Assert.assertNull(healthStatus.getHealthStatusId()); 
   }

    @Test
    public void TestHealthStatusAPIMethods_4_getById_HealthStatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       HealthStatus newhealthStatus = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),HealthStatus.class);
       Assert.assertEquals(healthStatus.getHealthStatusId(),newhealthStatus.getHealthStatusId()); 
   }

    @Test
    public void TestHealthStatusAPIMethods_5_getAllEnrollment_HealthStatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       HealthStatuses healthStatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",HealthStatuses.class);
       Assert.assertEquals(healthStatuss.getHealthStatuses().size(),1); 
       // creating another record     
       healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       healthStatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",HealthStatuses.class);
       Assert.assertEquals(healthStatuss.getHealthStatuses().size(),2); 
   }

    @Test
    public void TestHealthStatusAPIMethods_6_create_HealthStatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       clientId = UUID.randomUUID();
       HealthStatus healthStatus = TestData.getHealthStatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_7_update_HealthStatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_8_delete_HealthStatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_9_getById_HealthStatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_10_getAllEnrollment_HealthStatus_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       // creating another record     
       healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_11_create_HealthStatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       enrollmentId = UUID.randomUUID();
       HealthStatus healthStatus = TestData.getHealthStatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_12_update_HealthStatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_13_delete_HealthStatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),healthStatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_14_getById_HealthStatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses//"+healthStatus.getHealthStatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthStatusAPIMethods_15_getAllEnrollment_HealthStatus_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthStatus healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       // creating another record     
       healthStatus = TestData.getHealthStatus();

       healthStatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",healthStatus,HealthStatus.class);
       Assert.assertNotNull(healthStatus.getHealthStatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthStatuses/",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
