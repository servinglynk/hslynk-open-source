package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollment;
import com.servinglynk.hmis.warehouse.core.model.GenericEnrollments;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RequestMapping({"/generic-enrollments","/genericenrollments"})
@RestController
public class GenericEnrollmentsController extends ControllerBase {
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public GenericEnrollment createGenericEnrollment(@RequestBody GenericEnrollment genericEnrollment,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getGenericEnrollmentService().create(genericEnrollment, session.getAccount());		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{genericEnrollmentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void updateGenericEnrollment(@PathVariable("genericEnrollmentId") UUID genericEnrollmentId,@RequestBody GenericEnrollment genericEnrollment,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		genericEnrollment.setId(genericEnrollmentId);
		serviceFactory.getGenericEnrollmentService().update(genericEnrollment, session.getAccount());
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{genericEnrollmentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	public void deleteGenericEnrollment(@PathVariable("genericEnrollmentId") UUID id) {
			serviceFactory.getGenericEnrollmentService().delete(id);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/{genericEnrollmentId}")
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	GenericEnrollment getById(@PathVariable("genericEnrollmentId") UUID id) {
		return serviceFactory.getGenericEnrollmentService().getById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true,value="CLIENT_API_SEARCH")
	GenericEnrollments getAllGlobalEnrollments(
			@RequestParam(value="startIndex",defaultValue="0",required=false) Integer start,
			@RequestParam(value="maxItems",defaultValue="200",required=false) Integer maxItems) {
		
		return serviceFactory.getGenericEnrollmentService().getAllGlobalEnrollments(start, maxItems);
	}
}