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
import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolences;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Errors;
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
public class TestDomesticViolenceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }
    
    @Test
    public void TestDomesticViolenceAPIMethods_1_create_DomesticViolence_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_2_update_DomesticViolence_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 
       // set new values for update the data
       domesticViolence= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence,DomesticViolence.class);
   }

    @Test
    public void TestDomesticViolenceAPIMethods_3_delete_DomesticViolence_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       domesticViolence= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence,DomesticViolence.class);
       Assert.assertNull(domesticViolence.getDomesticViolenceId()); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_4_getById_DomesticViolence_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       DomesticViolence newdomesticViolence = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),DomesticViolence.class);
       Assert.assertEquals(domesticViolence.getDomesticViolenceId(),newdomesticViolence.getDomesticViolenceId()); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_5_getAllEnrollment_DomesticViolence_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       DomesticViolences domesticViolences = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",DomesticViolences.class);
       Assert.assertEquals(domesticViolences.getDomesticViolences().size(),1); 
       // creating another record     
       domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       domesticViolences = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",DomesticViolences.class);
       Assert.assertEquals(domesticViolences.getDomesticViolences().size(),2); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_6_create_DomesticViolence_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
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
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_7_update_DomesticViolence_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_8_delete_DomesticViolence_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_9_getById_DomesticViolence_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_10_getAllEnrollment_DomesticViolence_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       // creating another record     
       domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_11_create_DomesticViolence_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
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
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_12_update_DomesticViolence_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_13_delete_DomesticViolence_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),domesticViolence,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_14_getById_DomesticViolence_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences/"+domesticViolence.getDomesticViolenceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDomesticViolenceAPIMethods_15_getAllEnrollment_DomesticViolence_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DOMESTICVIOLENCE","CLIENT_API_UPDATE_DOMESTICVIOLENCE","CLIENT_API_DELETE_DOMESTICVIOLENCE","CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       DomesticViolence domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       // creating another record     
       domesticViolence = TestData.getDomesticViolence();

       domesticViolence= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",domesticViolence,DomesticViolence.class);
       Assert.assertNotNull(domesticViolence.getDomesticViolenceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/domesticViolences",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
