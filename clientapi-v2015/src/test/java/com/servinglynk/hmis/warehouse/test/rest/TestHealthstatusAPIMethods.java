package com.servinglynk.hmis.warehouse.test.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.config.ClientAPIConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
import com.servinglynk.hmis.warehouse.core.model.Errors;
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
public class TestHealthstatusAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_HEALTHSTATUS","CLIENT_API_UPDATE_HEALTHSTATUS","CLIENT_API_DELETE_HEALTHSTATUS","CLIENT_API_GET_HEALTHSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestHealthstatusAPIMethods_1_create_Healthstatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 
   }

    @Test
    public void TestHealthstatusAPIMethods_2_update_Healthstatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestHealthstatusAPIMethods_3_delete_Healthstatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestHealthstatusAPIMethods_4_getById_Healthstatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       Healthstatus newhealthstatus = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),Healthstatus.class);
       Assert.assertEquals(healthstatus.getHealthstatusId(),newhealthstatus.getHealthstatusId()); 
   }

    @Test
    public void TestHealthstatusAPIMethods_5_getAllEnrollment_Healthstatus_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       Healthstatuses healthstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",Healthstatuses.class);
       Assert.assertEquals(healthstatuss.getHealthstatuses().size(),1); 
       // creating another record     
       healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       healthstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",Healthstatuses.class);
       Assert.assertEquals(healthstatuss.getHealthstatuses().size(),2); 
   }

    @Test
    public void TestHealthstatusAPIMethods_6_create_Healthstatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       clientId = UUID.randomUUID();
       Healthstatus healthstatus = TestData.gethealthstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_7_update_Healthstatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_8_delete_Healthstatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_9_getById_Healthstatus_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_10_getAllEnrollment_Healthstatus_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       // creating another record     
       healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_11_create_Healthstatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       enrollmentId = UUID.randomUUID();
       Healthstatus healthstatus = TestData.gethealthstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_12_update_Healthstatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_13_delete_Healthstatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),healthstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_14_getById_Healthstatus_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss/"+healthstatus.getHealthstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthstatusAPIMethods_15_getAllEnrollment_Healthstatus_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Healthstatus healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       // creating another record     
       healthstatus = TestData.gethealthstatus();

       healthstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",healthstatus,Healthstatus.class);
       Assert.assertNotNull(healthstatus.getHealthstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
