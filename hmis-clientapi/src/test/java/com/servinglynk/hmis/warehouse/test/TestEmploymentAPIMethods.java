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
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.test.core.BasicTestMethods;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientAPIConfig.class})
@WebAppConfiguration
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestEmploymentAPIMethods {

    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;
    
    BasicTestMethods basicTestMethods= null;
    @Before
    public void create() throws Exception {
    	basicTestMethods= new BasicTestMethods(wac,serviceFactory);
    }

	
	
    @Test
    public void TestEmploymentAPIMethods_1_create_Employment_testcase() throws Exception {
        BasicTestMethods basicTestMethods= new BasicTestMethods(wac,serviceFactory);
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
   }

    

    @Test
    public void TestEmploymentAPIMethods_2_update_Employment_testcase() throws Exception {    
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();
      
       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       System.out.println("insert json "+employment.toJSONString());
       employment.setEmployed(8);
       System.out.println("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId());
       // set new values for update the data
       employment= executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Employment.class);
   }

    @Test
    public void TestEmploymentAPIMethods_3_delete_Employment_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       employment= executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Employment.class);
       Assert.assertNull(employment.getEmploymentId()); 
   }

    @Test
    public void TestEmploymentAPIMethods_4_getById_Employment_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       Employment newemployment = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Employment.class);
       Assert.assertEquals(employment.getEmploymentId(),newemployment.getEmploymentId()); 
   }

    @Test
    public void TestEmploymentAPIMethods_5_getAllEnrollment_Employment_testcase() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       Employments employments = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Employments.class);
       Assert.assertEquals(employments.getEmployments().size(),1); 
       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       employments = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Employments.class);
       Assert.assertEquals(employments.getEmployments().size(),2); 
   }

    @Test
    public void TestEmploymentAPIMethods_6_create_Employment_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
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
       Employment employment = TestData.getEmployment();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_7_update_Employment_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       clientId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_8_delete_Employment_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_9_getById_Employment_with_unknownClinet() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_10_getAllEnrollment_Employment_with_unknowClient() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       clientId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"CLIENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_11_create_Employment_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
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
       Employment employment = TestData.getEmployment();

       Errors errors = executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_12_update_Employment_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 
       enrollmentId = UUID.randomUUID();
       // set new values for update the data
       Errors errors = executor.executePut("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment, Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_13_delete_Employment_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeDelete("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),employment,Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_14_getById_Employment_with_unknownEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments/"+employment.getEmploymentId(),Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

    @Test
    public void TestEmploymentAPIMethods_15_getAllEnrollment_Employment_with_unknowEnrollment() throws Exception {
       Account account = basicTestMethods.createAccount();
       String[] methods = {"CLIENT_API_CREATE_EMPLOYMENT","CLIENT_API_UPDATE_EMPLOYMENT","CLIENT_API_DELETE_EMPLOYMENT","CLIENT_API_GET_EMPLOYMENT_BY_ID","CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS"};
       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
       executor.setAcceptHeaderAsJson();
       executor.setContentTypeHeaderAsJson();
       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());

       UUID clientId = basicTestMethods.createClient(); 
       UUID enrollmentId = basicTestMethods.createEnrollment(clientId); 
       Employment employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       // creating another record     
       employment = TestData.getEmployment();

       employment= executor.executePost("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",employment,Employment.class);
       Assert.assertNotNull(employment.getEmploymentId()); 

       enrollmentId = UUID.randomUUID();
       Errors errors = executor.executeGet("/clients/"+clientId+"/enrollments/"+enrollmentId+"/employments",Errors.class);
       Assert.assertNotNull(errors);
       Assert.assertEquals(errors.getError().get(0).getCode(),"ENROLLMENT_NOT_FOUND"); 
   }

}
