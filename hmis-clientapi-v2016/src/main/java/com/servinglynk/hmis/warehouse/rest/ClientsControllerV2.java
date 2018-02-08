package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Enrollments;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
@RequestMapping("/v2/clients")
public class ClientsControllerV2 extends ControllerBase {


	@RequestMapping(value = "/{clientid}/enrollments/{enrollmentid}", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ENROLLMENT_BY_ID", checkSessionToken = true, checkTrustedApp = true)
	public Enrollment getClientEnrollmentById(@PathVariable("clientid") UUID clientId,
			@PathVariable("enrollmentid") UUID enrollmentId, HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentServiceV2().getEnrollmentByClientIdAndEnrollmentId(enrollmentId, clientId);
	}
	
	
	@RequestMapping(value = "/{clientid}/enrollments", method = RequestMethod.GET)
	@APIMapping(value = "CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS", checkSessionToken = true, checkTrustedApp = true)
	public Enrollments getAllClientEnrollments(@PathVariable("clientid") UUID clientId,
			@RequestParam(value = "startIndex", required = false) Integer startIndex,
			@RequestParam(value = "maxItems", required = false) Integer maxItems, HttpServletRequest request)
					throws Exception {
		Session session = sessionHelper.getSession(request);
		if (startIndex == null)
			startIndex = 0;
		if (maxItems == null)
			maxItems = 30;

		return serviceFactory.getEnrollmentServiceV2().getEnrollmentsByClientId(clientId,
				session.getAccount().getUsername(), startIndex, maxItems);
	}


}