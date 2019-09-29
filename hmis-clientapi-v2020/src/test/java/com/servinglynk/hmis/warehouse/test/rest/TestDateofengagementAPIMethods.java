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
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
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
public class TestDateofengagementAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_DATEOFENGAGEMENT","CLIENT_API_UPDATE_DATEOFENGAGEMENT","CLIENT_API_DELETE_DATEOFENGAGEMENT","CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestDateofengagementAPIMethods_1_create_Dateofengagement_testcase() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();
       System.out.println("json request "+dateofengagement.toJSONString());
       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       System.out.println("json response "+dateofengagement.toJSONString());
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 
   }

    @Test
    public void TestDateofengagementAPIMethods_2_update_Dateofengagement_testcase() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestDateofengagementAPIMethods_3_delete_Dateofengagement_testcase() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestDateofengagementAPIMethods_4_getById_Dateofengagement_testcase() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       Dateofengagement newdateofengagement = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),Dateofengagement.class);
       Assert.assertEquals(dateofengagement.getDateofengagementId(),newdateofengagement.getDateofengagementId()); 
   }

    @Test
    public void TestDateofengagementAPIMethods_5_getAllEnrollment_Dateofengagement_testcase() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       Dateofengagements dateofengagements = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",Dateofengagements.class);
       Assert.assertEquals(dateofengagements.getDateofengagements().size(),1); 
       // creating another record     
       dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       dateofengagements = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",Dateofengagements.class);
       Assert.assertEquals(dateofengagements.getDateofengagements().size(),2); 
   }

    @Test
    public void TestDateofengagementAPIMethods_6_create_Dateofengagement_with_unknownClinet() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_7_update_Dateofengagement_with_unknownClinet() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_8_delete_Dateofengagement_with_unknownClinet() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_9_getById_Dateofengagement_with_unknownClinet() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_10_getAllEnrollment_Dateofengagement_with_unknowClient() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       // creating another record     
       dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_11_create_Dateofengagement_with_unknownEnrollment() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_12_update_Dateofengagement_with_unknownEnrollment() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_13_delete_Dateofengagement_with_unknownEnrollment() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),dateofengagement,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_14_getById_Dateofengagement_with_unknownEnrollment() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements/"+dateofengagement.getDateofengagementId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDateofengagementAPIMethods_15_getAllEnrollment_Dateofengagement_with_unknowEnrollment() throws Exception {
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
       Dateofengagement dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       // creating another record     
       dateofengagement = TestData.getDateofengagement();

       dateofengagement= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",dateofengagement,Dateofengagement.class);
       Assert.assertNotNull(dateofengagement.getDateofengagementId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/dateofengagements",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
