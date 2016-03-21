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
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
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
public class TestDisabilitiesAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    
    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }


    
    @Test
    public void TestDisabilitiesAPIMethods_1_create_Disabilities_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_2_update_Disabilities_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 
       // set new values for update the data
       disabilities= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities,Disabilities.class);
   }

    @Test
    public void TestDisabilitiesAPIMethods_3_delete_Disabilities_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       disabilities= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities,Disabilities.class);
       Assert.assertNull(disabilities.getDisabilitiesId()); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_4_getById_Disabilities_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       Disabilities newdisabilities = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),Disabilities.class);
       Assert.assertEquals(disabilities.getDisabilitiesId(),newdisabilities.getDisabilitiesId()); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_5_getAllEnrollment_Disabilities_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       DisabilitiesList disabilitiess = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",DisabilitiesList.class);
       Assert.assertEquals(disabilitiess.getDisabilitiesList().size(),1); 
       // creating another record     
       disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       disabilitiess = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",DisabilitiesList.class);
       Assert.assertEquals(disabilitiess.getDisabilitiesList().size(),2); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_6_create_Disabilities_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
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
       Disabilities disabilities = TestData.getDisabilities();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_7_update_Disabilities_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_8_delete_Disabilities_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_9_getById_Disabilities_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_10_getAllEnrollment_Disabilities_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       // creating another record     
       disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_11_create_Disabilities_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
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
       Disabilities disabilities = TestData.getDisabilities();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_12_update_Disabilities_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_13_delete_Disabilities_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),disabilities,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_14_getById_Disabilities_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess/"+disabilities.getDisabilitiesId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestDisabilitiesAPIMethods_15_getAllEnrollment_Disabilities_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_DISABILITIES","CLIENT_API_UPDATE_DISABILITIES","CLIENT_API_DELETE_DISABILITIES","CLIENT_API_GET_DISABILITIES_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Disabilities disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       // creating another record     
       disabilities = TestData.getDisabilities();

       disabilities= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",disabilities,Disabilities.class);
       Assert.assertNotNull(disabilities.getDisabilitiesId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/disabilitiess",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
