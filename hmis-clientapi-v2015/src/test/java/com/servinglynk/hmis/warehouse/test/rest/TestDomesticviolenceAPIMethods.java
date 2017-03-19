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
import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolences;
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
public class TestDomesticviolenceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestDomesticviolenceAPIMethods_1_create_Domesticviolence_testcase() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_2_update_Domesticviolence_testcase() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_3_delete_Domesticviolence_testcase() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_4_getById_Domesticviolence_testcase() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       Domesticviolence newdomesticviolence = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),Domesticviolence.class);
       Assert.assertEquals(domesticviolence.getDomesticviolenceId(),newdomesticviolence.getDomesticviolenceId()); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_5_getAllEnrollment_Domesticviolence_testcase() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       Domesticviolences domesticviolences = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",Domesticviolences.class);
       Assert.assertEquals(domesticviolences.getDomesticviolences().size(),1); 
       // creating another record     
       domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       domesticviolences = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",Domesticviolences.class);
       Assert.assertEquals(domesticviolences.getDomesticviolences().size(),2); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_6_create_Domesticviolence_with_unknownClinet() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_7_update_Domesticviolence_with_unknownClinet() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_8_delete_Domesticviolence_with_unknownClinet() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_9_getById_Domesticviolence_with_unknownClinet() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_10_getAllEnrollment_Domesticviolence_with_unknowClient() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       // creating another record     
       domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_11_create_Domesticviolence_with_unknownEnrollment() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_12_update_Domesticviolence_with_unknownEnrollment() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_13_delete_Domesticviolence_with_unknownEnrollment() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),domesticviolence,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_14_getById_Domesticviolence_with_unknownEnrollment() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences/"+domesticviolence.getDomesticviolenceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticviolenceAPIMethods_15_getAllEnrollment_Domesticviolence_with_unknowEnrollment() throws Exception {
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
       Domesticviolence domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       // creating another record     
       domesticviolence = TestData.getdomesticviolence();

       domesticviolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",domesticviolence,Domesticviolence.class);
       Assert.assertNotNull(domesticviolence.getDomesticviolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticviolences",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
