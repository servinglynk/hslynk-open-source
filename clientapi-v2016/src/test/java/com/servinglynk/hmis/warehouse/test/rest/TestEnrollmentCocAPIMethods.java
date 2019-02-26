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
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
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
public class TestEnrollmentCocAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_ENROLLMENTCOC","CLIENT_API_UPDATE_ENROLLMENTCOC","CLIENT_API_DELETE_ENROLLMENTCOC","CLIENT_API_GET_ENROLLMENTCOC_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestEnrollmentCocAPIMethods_1_create_EnrollmentCoc_testcase() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_2_update_EnrollmentCoc_testcase() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_3_delete_EnrollmentCoc_testcase() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_4_getById_EnrollmentCoc_testcase() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       EnrollmentCoc newenrollmentCoc = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),EnrollmentCoc.class);
       Assert.assertEquals(enrollmentCoc.getEnrollmentCocId(),newenrollmentCoc.getEnrollmentCocId()); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_5_getAllEnrollment_EnrollmentCoc_testcase() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       EnrollmentCocs enrollmentCocs = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",EnrollmentCocs.class);
       Assert.assertEquals(enrollmentCocs.getEnrollmentCocs().size(),1); 
       // creating another record     
       enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       enrollmentCocs = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",EnrollmentCocs.class);
       Assert.assertEquals(enrollmentCocs.getEnrollmentCocs().size(),2); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_6_create_EnrollmentCoc_with_unknownClinet() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_7_update_EnrollmentCoc_with_unknownClinet() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_8_delete_EnrollmentCoc_with_unknownClinet() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_9_getById_EnrollmentCoc_with_unknownClinet() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_10_getAllEnrollment_EnrollmentCoc_with_unknowClient() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       // creating another record     
       enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_11_create_EnrollmentCoc_with_unknownEnrollment() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_12_update_EnrollmentCoc_with_unknownEnrollment() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_13_delete_EnrollmentCoc_with_unknownEnrollment() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),enrollmentCoc,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_14_getById_EnrollmentCoc_with_unknownEnrollment() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs/"+enrollmentCoc.getEnrollmentCocId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEnrollmentCocAPIMethods_15_getAllEnrollment_EnrollmentCoc_with_unknowEnrollment() throws Exception {
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
       EnrollmentCoc enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       // creating another record     
       enrollmentCoc = TestData.getenrollmentCoc();

       enrollmentCoc= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",enrollmentCoc,EnrollmentCoc.class);
       Assert.assertNotNull(enrollmentCoc.getEnrollmentCocId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/enrollmentcocs",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
