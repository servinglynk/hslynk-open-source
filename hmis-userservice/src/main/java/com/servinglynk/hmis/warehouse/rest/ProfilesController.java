package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Profiles;

@RestController
@RequestMapping("/profiles")
public class ProfilesController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="ACL_CREATE_PROFILE",checkTrustedApp=true,checkSessionToken=true)
	public Profile createProfile(@RequestBody Profile profile,HttpServletRequest request){
		return serviceFactory.getProfileService().createProfile(profile,USER_SERVICE);
	}

	@RequestMapping(value="/{profileId}",method=RequestMethod.PUT)
	@APIMapping(value="ACL_UPDATE_PROFILE",checkTrustedApp=true,checkSessionToken=true)	
	public Profile updateProfile(@PathVariable("profileId") UUID profileId,@RequestBody Profile profile,HttpServletRequest request){
		return serviceFactory.getProfileService().updateProfile(profile,USER_SERVICE);
	}
	
	@RequestMapping(value="/{profileId}",method=RequestMethod.DELETE)
	@APIMapping(value="ACL_DELETE_PROFILE",checkTrustedApp=true,checkSessionToken=true)	
	public Profile deleteProfile(@PathVariable("profileId") UUID profileId,HttpServletRequest request){
		return serviceFactory.getProfileService().deleteProfile(profileId,USER_SERVICE);
	}
	
	@RequestMapping(value="/{profileId}",method=RequestMethod.GET)
	@APIMapping(value="ACL_GET_PROFILE",checkTrustedApp=true,checkSessionToken=true)	
	public Profile getProfile(@PathVariable("profileId") UUID profileId, HttpServletRequest request) throws Exception {
		return serviceFactory.getProfileService().getProfile(profileId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="ACL_GET_ALL_PROFILES",checkTrustedApp=true,checkSessionToken=true)
	public Profiles getAllProfiles( @RequestParam(value="startIndex", required=false) Integer startIndex,
	         						@RequestParam(value="maxItems", required=false) Integer maxItems,
	         						HttpServletRequest request) throws Exception {
		
		if (startIndex == null)	{
			startIndex = 0;
		}

		if (maxItems == null)	{
			maxItems = 30;
		}
		
		return serviceFactory.getProfileService().getAllProfiles(startIndex,maxItems);
	}
	
	
}
