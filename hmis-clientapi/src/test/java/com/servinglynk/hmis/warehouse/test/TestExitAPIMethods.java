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
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Exits;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Role;
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
public class TestExitAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }
	


    
    @Test
    public void TestExitAPIMethods_1_create_Exit_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 
   }

    @Test
    public void TestExitAPIMethods_2_update_Exit_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 
       // set new values for update the data
       exit= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit,Exit.class);
   }

    @Test
    public void TestExitAPIMethods_3_delete_Exit_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       exit= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit,Exit.class);
       Assert.assertNull(exit.getExitId()); 
   }

    @Test
    public void TestExitAPIMethods_4_getById_Exit_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       Exit newexit = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),Exit.class);
       Assert.assertEquals(exit.getExitId(),newexit.getExitId()); 
   }

    @Test
    public void TestExitAPIMethods_5_getAllEnrollment_Exit_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       Exits exits = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",Exits.class);
       Assert.assertEquals(exits.getExits().size(),1); 
       // creating another record     
       exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       exits = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",Exits.class);
       Assert.assertEquals(exits.getExits().size(),2); 
   }

    @Test
    public void TestExitAPIMethods_6_create_Exit_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
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
       Exit exit = TestData.getExit();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_7_update_Exit_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_8_delete_Exit_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_9_getById_Exit_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_10_getAllEnrollment_Exit_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       // creating another record     
       exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_11_create_Exit_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
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
       Exit exit = TestData.getExit();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_12_update_Exit_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_13_delete_Exit_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),exit,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_14_getById_Exit_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits/"+exit.getExitId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestExitAPIMethods_15_getAllEnrollment_Exit_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_GET_ALL_ENROLLMENT_EXITS","CLIENT_API_GET_EXIT_BY_ID","CLIENT_API_DELETE_EXIT","CLIENT_API_UPDATE_EXIT","CLIENT_API_CREATE_EXIT"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Exit exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       // creating another record     
       exit = TestData.getExit();

       exit= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",exit,Exit.class);
       Assert.assertNotNull(exit.getExitId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/exits",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
