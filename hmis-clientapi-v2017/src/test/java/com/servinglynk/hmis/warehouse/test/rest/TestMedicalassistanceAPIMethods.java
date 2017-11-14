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
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
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
public class TestMedicalassistanceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_MEDICALASSISTANCE","CLIENT_API_UPDATE_MEDICALASSISTANCE","CLIENT_API_DELETE_MEDICALASSISTANCE","CLIENT_API_GET_MEDICALASSISTANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestMedicalassistanceAPIMethods_1_create_Medicalassistance_testcase() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_2_update_Medicalassistance_testcase() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_3_delete_Medicalassistance_testcase() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_4_getById_Medicalassistance_testcase() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       Medicalassistance newmedicalassistance = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),Medicalassistance.class);
       Assert.assertEquals(medicalassistance.getMedicalassistanceId(),newmedicalassistance.getMedicalassistanceId()); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_5_getAllEnrollment_Medicalassistance_testcase() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       Medicalassistances medicalassistances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",Medicalassistances.class);
       Assert.assertEquals(medicalassistances.getMedicalassistances().size(),1); 
       // creating another record     
       medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       medicalassistances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",Medicalassistances.class);
       Assert.assertEquals(medicalassistances.getMedicalassistances().size(),2); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_6_create_Medicalassistance_with_unknownClinet() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_7_update_Medicalassistance_with_unknownClinet() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_8_delete_Medicalassistance_with_unknownClinet() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_9_getById_Medicalassistance_with_unknownClinet() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_10_getAllEnrollment_Medicalassistance_with_unknowClient() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       // creating another record     
       medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_11_create_Medicalassistance_with_unknownEnrollment() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_12_update_Medicalassistance_with_unknownEnrollment() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_13_delete_Medicalassistance_with_unknownEnrollment() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),medicalassistance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_14_getById_Medicalassistance_with_unknownEnrollment() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances/"+medicalassistance.getMedicalassistanceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestMedicalassistanceAPIMethods_15_getAllEnrollment_Medicalassistance_with_unknowEnrollment() throws Exception {
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
       Medicalassistance medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       // creating another record     
       medicalassistance = TestData.getmedicalassistance();

       medicalassistance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",medicalassistance,Medicalassistance.class);
       Assert.assertNotNull(medicalassistance.getMedicalassistanceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/medicalassistances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
