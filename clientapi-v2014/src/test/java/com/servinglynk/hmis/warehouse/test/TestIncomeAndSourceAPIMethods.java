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
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSources;
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
public class TestIncomeAndSourceAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }

    
    @Test
    public void TestIncomeAndSourceAPIMethods_1_create_IncomeAndSource_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_2_update_IncomeAndSource_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 
       // set new values for update the data
       incomeAndSource= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource,IncomeAndSource.class);
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_3_delete_IncomeAndSource_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       incomeAndSource= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource,IncomeAndSource.class);
       Assert.assertNull(incomeAndSource.getIncomeAndSourceId()); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_4_getById_IncomeAndSource_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       IncomeAndSource newincomeAndSource = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),IncomeAndSource.class);
       Assert.assertEquals(incomeAndSource.getIncomeAndSourceId(),newincomeAndSource.getIncomeAndSourceId()); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_5_getAllEnrollment_IncomeAndSource_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       IncomeAndSources incomeAndSources = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",IncomeAndSources.class);
       Assert.assertEquals(incomeAndSources.getIncomeAndSources().size(),1); 
       // creating another record     
       incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       incomeAndSources = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",IncomeAndSources.class);
       Assert.assertEquals(incomeAndSources.getIncomeAndSources().size(),2); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_6_create_IncomeAndSource_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       clientId = UUID.randomUUID();
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_7_update_IncomeAndSource_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_8_delete_IncomeAndSource_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_9_getById_IncomeAndSource_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_10_getAllEnrollment_IncomeAndSource_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       // creating another record     
       incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_11_create_IncomeAndSource_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       enrollmentId = UUID.randomUUID();
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_12_update_IncomeAndSource_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_13_delete_IncomeAndSource_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),incomeAndSource,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_14_getById_IncomeAndSource_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources/"+incomeAndSource.getIncomeAndSourceId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestIncomeAndSourceAPIMethods_15_getAllEnrollment_IncomeAndSource_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_INCOMEANDSOURCE","CLIENT_API_UPDATE_INCOMEANDSOURCE","CLIENT_API_DELETE_INCOMEANDSOURCE","CLIENT_API_GET_INCOMEANDSOURCE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       IncomeAndSource incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       // creating another record     
       incomeAndSource = TestData.getIncomeAndSource();

       incomeAndSource= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",incomeAndSource,IncomeAndSource.class);
       Assert.assertNotNull(incomeAndSource.getIncomeAndSourceId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/incomeAndSources",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
