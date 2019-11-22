package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/projects")
public class ProjectsController extends ControllerBase {

	@RequestMapping(method=RequestMethod.POST,value="/{projectId}/users")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CREATE_SHRING_RULE")
	public void addUsersToProject(@PathVariable("projectId")  UUID projectId,@RequestBody Account account,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getBaseProjectService().addUserToProject(projectId, account.getUsername(), session);
	}
	
	public void updateUsersToProject(@PathVariable("projectId")  UUID projectId,Accounts accounts) {
		
	}
	
	public void removeUserFromProject(@PathVariable("projectId")  UUID projectId,@PathVariable("userId") UUID userId) {
		
	}

	public Accounts getProjectUsers(@PathVariable("projectId")  UUID projectId) {
		return null;
	}
}
