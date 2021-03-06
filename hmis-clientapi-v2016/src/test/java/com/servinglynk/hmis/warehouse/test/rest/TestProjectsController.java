package com.servinglynk.hmis.warehouse.test.rest;

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
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projects;
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
public class TestProjectsController {

	
	
    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired WebApplicationContext wac;

    @Autowired ParentServiceFactory serviceFactory;

    BasicTestMethods basicTestMethods= null;
    @Before
    public void init() throws Exception {
        basicTestMethods= new BasicTestMethods(wac,serviceFactory); 
    }

	
	@Test
	public void testCreateProject() throws Exception {
		   Account account = basicTestMethods.createAccount();
	       String[] methods = {"CLIENT_API_CREATE_PROJECT"};
	       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
	       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	       executor.setAcceptHeaderAsJson();
	       executor.setContentTypeHeaderAsJson();
	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());
	       
	       Project project = TestData.getProject();

	       project= executor.executePost("/projects",project,Project.class);
	       Assert.assertNotNull(project.getProjectId()); 
	}
	
	@Test
	public void testUpdateProject() throws Exception {
		   Account account = basicTestMethods.createAccount();
	       String[] methods = {"CLIENT_API_CREATE_PROJECT","CLIENT_API_UPDATE_PROJECT"};
	       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
	       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	       executor.setAcceptHeaderAsJson();
	       executor.setContentTypeHeaderAsJson();
	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());
	       
	       Project project = TestData.getProject();

	       project= executor.executePost("/projects",project,Project.class);
	       
	       Assert.assertNotNull(project.getProjectId()); 
	     
	       project.setProjectCommonName("New Common Name");
	       
	       project = executor.executePut("/projects/"+project.getProjectId(), project,Project.class);
	       
	       Assert.assertEquals(project.getProjectCommonName(),"New Common Name");
	}
	
	@Test
	public void testDeleteProject() throws Exception {
		   Account account = basicTestMethods.createAccount();
	       String[] methods = {"CLIENT_API_CREATE_PROJECT","CLIENT_API_DELETE_PROJECT"};
	       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
	       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	       executor.setAcceptHeaderAsJson();
	       executor.setContentTypeHeaderAsJson();
	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());
	       
	       Project project = TestData.getProject();

	       project= executor.executePost("/projects",project,Project.class);
	       
	       Assert.assertNotNull(project.getProjectId()); 
	     
	       project = executor.executeDelete("/projects/"+project.getProjectId(),Project.class);
	       
	       Assert.assertNull(project.getProjectCommonName());
	       Assert.assertNull(project.getProjectId());
	}
	
	@Test
	public void testGetProjectById() throws Exception {
		   Account account = basicTestMethods.createAccount();
	       String[] methods = {"CLIENT_API_CREATE_PROJECT","CLIENT_API_GET_PROJECT_BY_ID"};
	       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
	       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	       executor.setAcceptHeaderAsJson();
	       executor.setContentTypeHeaderAsJson();
	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());
	       
	       Project project = TestData.getProject();

	       project= executor.executePost("/projects",project,Project.class);
	       
	       Assert.assertNotNull(project.getProjectId()); 
	     
	       Project newProject = executor.executeGet("/projects/"+project.getProjectId(),Project.class);
	       
	       Assert.assertEquals(newProject.getProjectCommonName(),project.getProjectCommonName());
	       Assert.assertEquals(newProject.getProjectId(), project.getProjectId());
	}
	
	@Test
	public void testGetAllProjects() throws Exception {
		   Account account = basicTestMethods.createAccount();
	       String[] methods = {"CLIENT_API_CREATE_PROJECT","CLIENT_API_GET_ALL_PROJECTS"};
	       basicTestMethods.addingMethodAccessUsingPermissionSet(methods, account.getUsername());
	       Session session = basicTestMethods.createSession(account.getUsername(),account.getPassword());

	       WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
	       executor.setAcceptHeaderAsJson();
	       executor.setContentTypeHeaderAsJson();
	       executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
	       executor.setHeaderValue("Authorization","HMISUserAuth session_token="+session.getToken());
	       
	       Project project = TestData.getProject();

	       project= executor.executePost("/projects",project,Project.class);
	       
	       Assert.assertNotNull(project.getProjectId()); 
	     
	       Projects projects = executor.executeGet("/projects",Projects.class);
	       
	       Assert.assertEquals(projects.getProjects().size(),1);
	       
	       executor.executePost("/projects",TestData.getProject(),Project.class);

	       projects = executor.executeGet("/projects",Projects.class);
	       
	       Assert.assertEquals(projects.getProjects().size(),2);
	}
	
}