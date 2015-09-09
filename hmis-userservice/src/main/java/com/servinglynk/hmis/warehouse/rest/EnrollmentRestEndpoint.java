package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.ReleaseOfInfo;

@RestController()
@RequestMapping(value="/enrollments")
public class EnrollmentRestEndpoint extends RestEndpointBase {
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CREATE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)	
	public ReleaseOfInfo createReleaseOfInformation(@RequestBody ReleaseOfInfo releaseOfInfo, HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().createReleaseOfInfo(releaseOfInfo,USER_SERVICE);
	}

	@RequestMapping(value="/{enrollmentId}",method=RequestMethod.PUT)
	@APIMapping(value="UPDATE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)
	public ReleaseOfInfo updateReleaseOfInformation(@PathVariable("enrollmentId") UUID enrollmentId,@RequestBody ReleaseOfInfo releaseOfInfo, HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().updateReleaseOfInfo(releaseOfInfo,USER_SERVICE);
	}
	
	@RequestMapping(value="/{enrollmentId}",method=RequestMethod.DELETE)
	@APIMapping(value="DELETE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)
	public ReleaseOfInfo deleteReleaseOfInformation(@PathVariable("enrollmentId") UUID enrollmentId, HttpServletRequest request) throws Exception {
		return serviceFactory.getEnrollmentService().deleteReleaseOfInfo(enrollmentId);
	}
}
