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
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatuses;
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
public class TestRhybcpstatusAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_RHYBCPSTATUS","CLIENT_API_UPDATE_RHYBCPSTATUS","CLIENT_API_DELETE_RHYBCPSTATUS","CLIENT_API_GET_RHYBCPSTATUS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestRhybcpstatusAPIMethods_1_create_Rhybcpstatus_testcase() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_2_update_Rhybcpstatus_testcase() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_3_delete_Rhybcpstatus_testcase() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_4_getById_Rhybcpstatus_testcase() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       Rhybcpstatus newrhybcpstatus = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),Rhybcpstatus.class);
       Assert.assertEquals(rhybcpstatus.getRhybcpstatusId(),newrhybcpstatus.getRhybcpstatusId()); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_5_getAllEnrollment_Rhybcpstatus_testcase() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       Rhybcpstatuses rhybcpstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",Rhybcpstatuses.class);
       Assert.assertEquals(rhybcpstatuss.getRhybcpstatuses().size(),1); 
       // creating another record     
       rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       rhybcpstatuss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",Rhybcpstatuses.class);
       Assert.assertEquals(rhybcpstatuss.getRhybcpstatuses().size(),2); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_6_create_Rhybcpstatus_with_unknownClinet() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_7_update_Rhybcpstatus_with_unknownClinet() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_8_delete_Rhybcpstatus_with_unknownClinet() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_9_getById_Rhybcpstatus_with_unknownClinet() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_10_getAllEnrollment_Rhybcpstatus_with_unknowClient() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       // creating another record     
       rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_11_create_Rhybcpstatus_with_unknownEnrollment() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_12_update_Rhybcpstatus_with_unknownEnrollment() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_13_delete_Rhybcpstatus_with_unknownEnrollment() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),rhybcpstatus,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_14_getById_Rhybcpstatus_with_unknownEnrollment() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss/"+rhybcpstatus.getRhybcpstatusId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestRhybcpstatusAPIMethods_15_getAllEnrollment_Rhybcpstatus_with_unknowEnrollment() throws Exception {
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
       Rhybcpstatus rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       // creating another record     
       rhybcpstatus = TestData.getrhybcpstatus();

       rhybcpstatus= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",rhybcpstatus,Rhybcpstatus.class);
       Assert.assertNotNull(rhybcpstatus.getRhybcpstatusId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/rhybcpstatuss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
