package com.servinglynk.hmis.warehouse.rest;

import java.util.UUID;
import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;

@RestController
@RequestMapping("/permissionsets")
public class PermissionSetsController extends ControllerBase {

	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="ACL_CREATE_PRMISSION_SET",checkTrustedApp=true,checkSessionToken=true)
	public PermissionSet createPermissionSet(@RequestBody PermissionSet permissionSet,HttpServletRequest request) throws Exception {
		return serviceFactory.getPermissionSetService().createPermissionSet(permissionSet,USER_SERVICE);
	}
	
	@RequestMapping(value="/{permissionsetid}",method=RequestMethod.PUT)
	@APIMapping(value="ACL_UPDATE_PRMISSION_SET",checkTrustedApp=true,checkSessionToken=true)
	public PermissionSet updatePermissionSet(@PathVariable("permissionsetid") UUID permissionSetId ,@RequestBody PermissionSet permissionSet,HttpServletRequest request) throws Exception {
		return serviceFactory.getPermissionSetService().updatePermissionSet(permissionSet,USER_SERVICE);
	}
	
	
	@RequestMapping(value="/{permissionsetid}",method=RequestMethod.DELETE)
	@APIMapping(value="ACL_DELETE_PRMISSION_SET",checkTrustedApp=true,checkSessionToken=true)
	public PermissionSet deletePermissionSet(@PathVariable("permissionsetid") UUID permissionSetId ,HttpServletRequest request) throws Exception {
		return serviceFactory.getPermissionSetService().deletePermissionSet(permissionSetId,USER_SERVICE);
	}
	
	
	@RequestMapping(value="/{permissionsetid}",method=RequestMethod.GET)
	@APIMapping(value="ACL_GET_PRMISSION_SET",checkTrustedApp=true,checkSessionToken=true)
	public PermissionSet getPermissionSet(@PathVariable("permissionsetid") UUID permissionSetId ,HttpServletRequest request) throws Exception {
		return serviceFactory.getPermissionSetService().getPermissionSetById(permissionSetId);
	}
	
	@RequestMapping(value="/{username}/permissionsetassignments",method=RequestMethod.POST)
	@APIMapping(value="ACL_ASSIGN_PRMISSION_SET",checkTrustedApp=true,checkSessionToken=true)
	public PermissionSet assignPermissionSet(@PathVariable("username") String username ,@RequestBody PermissionSet permissionSet,HttpServletRequest request) throws Exception {
		 serviceFactory.getPermissionSetService().assignPermissionSetTOUser(username, permissionSet,USER_SERVICE);
		 return new PermissionSet();
	}
}
