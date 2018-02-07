package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollments;
import com.servinglynk.hmis.warehouse.core.model.GlobalEnrollmentsMap;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RequestMapping("/clients/{clientDedupId}/global-enrollments")
@RestController
public class GlobalEnrollmentsController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	GlobalEnrollment create(@PathVariable("clientDedupId") UUID clientDedupId,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		GlobalEnrollment model = new GlobalEnrollment();
		model.setDedupClientId(clientDedupId);
		return serviceFactory.getGlobalEnrollmentService().create(model, session.getAccount());
	}
	void update(GlobalEnrollment model) {
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{global-enrollmentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	GlobalEnrollment getById(@PathVariable("global-enrollmentId") UUID id) {
		return serviceFactory.getGlobalEnrollmentService().getById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	GlobalEnrollments getAllGlobalEnrollments(@PathVariable("clientDedupId") UUID dedupClientId,
			@RequestParam("startIndex") Integer start,
			@RequestParam("maxItems") Integer maxItems) {
		
		return serviceFactory.getGlobalEnrollmentService().getAllGlobalEnrollments(dedupClientId, start, maxItems);
	}

	@RequestMapping(method=RequestMethod.PUT,value="/{global-enrollmentId}/enrollments")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
    void mapEnrollmentsToGlobalEnrollment(@PathVariable("clientDedupId") UUID dedupClientId,
    		@PathVariable("global-enrollmentId") UUID globalEnrollmentId, 
    		@Valid @RequestBody GlobalEnrollmentsMap enrollments,HttpServletRequest request) {
		Session session = sessionHelper.getSession(request);
		serviceFactory.getGlobalEnrollmentService().mapEnrollmentsToGlobalEnrollment(globalEnrollmentId, enrollments,
				session.getAccount());
    }

	@RequestMapping(method=RequestMethod.DELETE,value="/{global-enrollmentId}/enrollments/{enrollmentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
    void removeEnrollmentsFromGlobalEnrollment(@PathVariable("clientDedupId") UUID dedupClientId,
    		@PathVariable("global-enrollmentId") UUID globalEnrollmentId,
    		@PathVariable("enrollmentId") UUID enrollmentMapId) {
    	serviceFactory.getGlobalEnrollmentService().removeEnrollmentsFromGlobalEnrollment(globalEnrollmentId, enrollmentMapId);
    }
}