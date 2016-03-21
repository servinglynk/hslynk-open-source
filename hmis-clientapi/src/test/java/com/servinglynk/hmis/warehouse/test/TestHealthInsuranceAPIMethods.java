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
import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurances;
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
public class TestHealthInsuranceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;
    
    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }

    
    
    @Test
    public void TestHealthInsuranceAPIMethods_1_create_HealthInsurance_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_2_update_HealthInsurance_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 
       // set new values for update the data
       healthInsurance= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance,HealthInsurance.class);
   }

    @Test
    public void TestHealthInsuranceAPIMethods_3_delete_HealthInsurance_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       healthInsurance= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance,HealthInsurance.class);
       Assert.assertNull(healthInsurance.getHealthInsuranceId()); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_4_getById_HealthInsurance_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       HealthInsurance newhealthInsurance = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),HealthInsurance.class);
       Assert.assertEquals(healthInsurance.getHealthInsuranceId(),newhealthInsurance.getHealthInsuranceId()); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_5_getAllEnrollment_HealthInsurance_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       HealthInsurances healthInsurances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",HealthInsurances.class);
       Assert.assertEquals(healthInsurances.getHealthInsurances().size(),1); 
       // creating another record     
       healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       healthInsurances = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",HealthInsurances.class);
       Assert.assertEquals(healthInsurances.getHealthInsurances().size(),2); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_6_create_HealthInsurance_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
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
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_7_update_HealthInsurance_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_8_delete_HealthInsurance_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_9_getById_HealthInsurance_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_10_getAllEnrollment_HealthInsurance_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       // creating another record     
       healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_11_create_HealthInsurance_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
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
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_12_update_HealthInsurance_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_13_delete_HealthInsurance_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),healthInsurance,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_14_getById_HealthInsurance_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances/"+healthInsurance.getHealthInsuranceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestHealthInsuranceAPIMethods_15_getAllEnrollment_HealthInsurance_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       		    String[] methods = {"CLIENT_API_CREATE_HEALTHINSURANCE","CLIENT_API_UPDATE_HEALTHINSURANCE","CLIENT_API_DELETE_HEALTHINSURANCE","CLIENT_API_GET_HEALTHINSURANCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       HealthInsurance healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       // creating another record     
       healthInsurance = TestData.getHealthInsurance();

       healthInsurance= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",healthInsurance,HealthInsurance.class);
       Assert.assertNotNull(healthInsurance.getHealthInsuranceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/healthInsurances",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
