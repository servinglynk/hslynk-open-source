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
import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.core.model.NoncashbenefitsList;
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
public class TestNoncashbenefitsAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_NONCASHBENEFITS","CLIENT_API_UPDATE_NONCASHBENEFITS","CLIENT_API_DELETE_NONCASHBENEFITS","CLIENT_API_GET_NONCASHBENEFITS_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFITS" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestNoncashbenefitsAPIMethods_1_create_Noncashbenefits_testcase() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_2_update_Noncashbenefits_testcase() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_3_delete_Noncashbenefits_testcase() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_4_getById_Noncashbenefits_testcase() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       Noncashbenefits newnoncashbenefits = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),Noncashbenefits.class);
       Assert.assertEquals(noncashbenefits.getNoncashbenefitsID(),newnoncashbenefits.getNoncashbenefitsID()); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_5_getAllEnrollment_Noncashbenefits_testcase() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       NoncashbenefitsList noncashbenefitss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",NoncashbenefitsList.class);
       Assert.assertEquals(noncashbenefitss.getNoncashbenefitsList().size(),1); 
       // creating another record     
       noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       noncashbenefitss = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",NoncashbenefitsList.class);
       Assert.assertEquals(noncashbenefitss.getNoncashbenefitsList().size(),2); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_6_create_Noncashbenefits_with_unknownClinet() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_7_update_Noncashbenefits_with_unknownClinet() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_8_delete_Noncashbenefits_with_unknownClinet() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_9_getById_Noncashbenefits_with_unknownClinet() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_10_getAllEnrollment_Noncashbenefits_with_unknowClient() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       // creating another record     
       noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_11_create_Noncashbenefits_with_unknownEnrollment() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_12_update_Noncashbenefits_with_unknownEnrollment() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_13_delete_Noncashbenefits_with_unknownEnrollment() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),noncashbenefits,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_14_getById_Noncashbenefits_with_unknownEnrollment() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss/"+noncashbenefits.getNoncashbenefitsID(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestNoncashbenefitsAPIMethods_15_getAllEnrollment_Noncashbenefits_with_unknowEnrollment() throws Exception {
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
       Noncashbenefits noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       // creating another record     
       noncashbenefits = TestData.getnoncashbenefits();

       noncashbenefits= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",noncashbenefits,Noncashbenefits.class);
       Assert.assertNotNull(noncashbenefits.getNoncashbenefitsID()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/noncashbenefitss",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
