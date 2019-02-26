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
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
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
public class TestResidentialmoveindateAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

      String[] methods = {"CLIENT_API_CREATE_RESIDENTIALMOVEINDATE","CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE","CLIENT_API_DELETE_RESIDENTIALMOVEINDATE","CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE" };


    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }
    @Test
    public void TestResidentialmoveindateAPIMethods_1_create_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_2_update_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       // set new values for update the data
       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate);
       Assert.assertEquals(response.getStatus(),200); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_3_delete_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       MockHttpServletResponse response = (MockHttpServletResponse)  executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate);
       Assert.assertEquals(response.getStatus(),204); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_4_getById_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       Residentialmoveindate newresidentialmoveindate = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Residentialmoveindate.class);
       Assert.assertEquals(residentialmoveindate.getResidentialmoveindateId(),newresidentialmoveindate.getResidentialmoveindateId()); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_5_getAllEnrollment_Residentialmoveindate_testcase() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       Residentialmoveindates residentialmoveindates = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Residentialmoveindates.class);
       Assert.assertEquals(residentialmoveindates.getResidentialmoveindates().size(),1); 
       // creating another record     
       residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       residentialmoveindates = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Residentialmoveindates.class);
       Assert.assertEquals(residentialmoveindates.getResidentialmoveindates().size(),2); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_6_create_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_7_update_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_8_delete_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_9_getById_Residentialmoveindate_with_unknownClinet() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_10_getAllEnrollment_Residentialmoveindate_with_unknowClient() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       // creating another record     
       residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_11_create_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_12_update_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_13_delete_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),residentialmoveindate,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_14_getById_Residentialmoveindate_with_unknownEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates/"+residentialmoveindate.getResidentialmoveindateId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestResidentialmoveindateAPIMethods_15_getAllEnrollment_Residentialmoveindate_with_unknowEnrollment() throws Exception {
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
       Residentialmoveindate residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       // creating another record     
       residentialmoveindate = TestData.getresidentialmoveindate();

       residentialmoveindate= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",residentialmoveindate,Residentialmoveindate.class);
       Assert.assertNotNull(residentialmoveindate.getResidentialmoveindateId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/residentialmoveindates",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
