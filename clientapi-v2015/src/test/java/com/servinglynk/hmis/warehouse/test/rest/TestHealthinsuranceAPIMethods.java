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
import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurances;
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
public class TestHealthinsuranceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestHealthinsuranceAPIMethods_1_create_Healthinsurance_testcase() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_2_update_Healthinsurance_testcase() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_3_delete_Healthinsurance_testcase() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_4_getById_Healthinsurance_testcase() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       Healthinsurance newhealthinsurance = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),Healthinsurance.class);
       Assert.assertEquals(healthinsurance.getHealthinsuranceId(),newhealthinsurance.getHealthinsuranceId()); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_5_getAllEnrollment_Healthinsurance_testcase() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       Healthinsurances healthinsurances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",Healthinsurances.class);
       Assert.assertEquals(healthinsurances.getHealthinsurances().size(),1); 
       // creating another record     
       healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       healthinsurances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",Healthinsurances.class);
       Assert.assertEquals(healthinsurances.getHealthinsurances().size(),2); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_6_create_Healthinsurance_with_unknownClinet() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_7_update_Healthinsurance_with_unknownClinet() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_8_delete_Healthinsurance_with_unknownClinet() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_9_getById_Healthinsurance_with_unknownClinet() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_10_getAllEnrollment_Healthinsurance_with_unknowClient() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       // creating another record     
       healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_11_create_Healthinsurance_with_unknownEnrollment() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_12_update_Healthinsurance_with_unknownEnrollment() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_13_delete_Healthinsurance_with_unknownEnrollment() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),healthinsurance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_14_getById_Healthinsurance_with_unknownEnrollment() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances/"+healthinsurance.getHealthinsuranceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthinsuranceAPIMethods_15_getAllEnrollment_Healthinsurance_with_unknowEnrollment() throws Exception {
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
       Healthinsurance healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       // creating another record     
       healthinsurance = TestData.gethealthinsurance();

       healthinsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",healthinsurance,Healthinsurance.class);
       Assert.assertNotNull(healthinsurance.getHealthinsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthinsurances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
