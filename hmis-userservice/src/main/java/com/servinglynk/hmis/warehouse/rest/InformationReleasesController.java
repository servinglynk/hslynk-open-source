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
import com.servinglynk.hmis.warehouse.core.model.InformationRelease;

@RestController()
@RequestMapping(value="/informationreleases")
public class InformationReleasesController extends ControllerBase {
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="CREATE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)	
	public InformationRelease createReleaseOfInformation(@RequestBody InformationRelease releaseOfInfo, HttpServletRequest request) throws Exception {
		return serviceFactory.getInformationReleasesService().createReleaseOfInfo(releaseOfInfo,USER_SERVICE);
	}

	@RequestMapping(value="/{enrollmentId}",method=RequestMethod.PUT)
	@APIMapping(value="UPDATE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)
	public InformationRelease updateReleaseOfInformation(@PathVariable("enrollmentId") UUID enrollmentId,@RequestBody InformationRelease releaseOfInfo, HttpServletRequest request) throws Exception {
		return serviceFactory.getInformationReleasesService().updateReleaseOfInfo(releaseOfInfo,USER_SERVICE);
	}
	
	@RequestMapping(value="/{enrollmentId}",method=RequestMethod.DELETE)
	@APIMapping(value="DELETE_RELEASE_OF_INFO",checkTrustedApp=true,checkSessionToken=true)
	public InformationRelease deleteReleaseOfInformation(@PathVariable("enrollmentId") UUID enrollmentId, HttpServletRequest request) throws Exception {
		return serviceFactory.getInformationReleasesService().deleteReleaseOfInfo(enrollmentId);
	}
}
