package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.PasswordReset;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.service.exception.AccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;

@RestController
@RequestMapping("/accounts")
public class AccountsController extends ControllerBase {

	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	@RequestMapping(method = RequestMethod.POST)
	public Account createAccount(@Valid @RequestBody Account account, @RequestParam(value="purpose",required= false,defaultValue="" ) String purpose, HttpServletRequest request) throws Exception {
	
		Session session = sessionHelper.getSession(request);
		return createAccount(account, request,session ,purpose);
	}
	
			
	private Account createAccount(Account account, HttpServletRequest request,Session session ,String purpose) throws Exception{
				if (account.getUsername() != null) {
					Account existingAccount = serviceFactory.getAccountService().findAccountByUsername(account.getUsername());
					if (existingAccount != null) {
						throw new AccountAlreadyExistsException("An account with the specified username already exists. username: "
								+ account.getUsername());
					}
				}
				
		
			return serviceFactory.getAccountService().createAccount(account, session.getAccount().getUsername(), purpose);
	 }
	
	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=false, checkTrustedApp=false)
	@RequestMapping(method = RequestMethod.POST,value="/developeraccount")
	public Account createDeveloperAccount(@RequestBody @Valid Account account, @RequestParam(value="purpose",required= false,defaultValue="" ) String purpose, HttpServletRequest request) throws Exception {
		Session session = new Session();
		session.setAccount(account);
		Profile profile = new Profile();
		profile.setId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setProfile(profile);
		Role role =new Role();
		role.setId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setRole(role);	
		ProjectGroup projectGroup=new ProjectGroup();
		projectGroup.setProjectGroupId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setProjectGroup(projectGroup);
		return createAccount(account, request,session ,purpose);
	}
	

	@RequestMapping(value = "/{userid}", method = RequestMethod.PUT)
	@APIMapping(value="USR_UPDATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public Account updateAccount(@PathVariable("userid") String userid, @RequestBody Account account, HttpServletRequest request)
			throws Exception {
		Session session = sessionHelper.getSession(request);		
		validateAccess(account, session.getAccount(), userid);
		return serviceFactory.getAccountService().updateAccount(account, USER_SERVICE);
	}

	@RequestMapping(value = "/{userid}/activate", method = RequestMethod.PUT)
	@APIMapping(value="USR_UPDATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public Account activateAccount(@PathVariable("userid") UUID userid, HttpServletRequest request)
			throws Exception {
		Session session = sessionHelper.getSession(request);	
		Account account = new Account();
		account.setAccountId(userid);
//		validateAccess(account, session.getAccount(), userid);
		return serviceFactory.getAccountService().activateAccount(account, USER_SERVICE);
	}

	
	@RequestMapping(value = "/{userid}/basicinfo", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT_BASIC_INFO",checkSessionToken=true, checkTrustedApp=true)
	public Account getAccountBasicInfo(@PathVariable("userid") String userid, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		validateAccess(new Account(), session.getAccount(), userid);
		return serviceFactory.getAccountService().getAccount(session.getAccount(),true);
	}

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public Account getAccount(@PathVariable("userid") String userid, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		Account account = new Account();
		validateAccess(account, session.getAccount(), userid);
		return serviceFactory.getAccountService().getAccount(account,false);
	}
	
	@RequestMapping(value = "/{userid}", method = RequestMethod.DELETE)
	@APIMapping(value="USR_GET_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public void deleteAccount(@PathVariable("userid") String userid, HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		Account account = new Account();
		validateAccess(account, session.getAccount(), userid);
		serviceFactory.getAccountService().deleteAccount(account, session.getAccount());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value="USR_GET_USERS",checkSessionToken=true, checkTrustedApp=true)	
	public Accounts getUserByOrganization(HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getAccountService().getUsersByProjectGroup(session.getAccount().getProjectGroup().getProjectGroupCode());
	}
	
	
	@RequestMapping(value="/{organizationid}/users",method = RequestMethod.GET)
	@APIMapping(value="USR_GET_USERS",checkSessionToken=true, checkTrustedApp=true)	
	public Accounts getOrganizationUsera(@PathVariable("organizationid") UUID organizationid,HttpServletRequest request) throws Exception {
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getAccountService().getUsersByProjectGroup(session.getAccount().getProjectGroup().getProjectGroupCode());
	}


	@RequestMapping(value = "/{username}/forgotpassword", method = RequestMethod.POST)
	@APIMapping(value="USR_PASSWORD_RESET",checkSessionToken=false, checkTrustedApp=false)
	public PasswordReset passwordReset(@PathVariable("username") String username,  HttpServletRequest request) throws Exception {
		Account account = new Account();
		account.setUsername(username);
		serviceFactory.getPasswordResetService().createPasswordReset(username, USER_SERVICE,"");
		PasswordReset returnPasswordReset = new PasswordReset();
		return returnPasswordReset;
	}
	
	
	@RequestMapping(value="/{userid}/roles",method=RequestMethod.PUT)
	@APIMapping(value="ACL_ADD_USER_ROLE",checkSessionToken=true,checkTrustedApp=true)
	public void addRoleToUser(@PathVariable("userid") UUID userid,@RequestBody Roles roles) throws Exception {
		serviceFactory.getAccountService().addRoleToUser(userid, roles);
	}
	
	@RequestMapping(value="/{userid}/roles/{roleid}",method=RequestMethod.DELETE)
	@APIMapping(value="ACL_DELETE_USER_ROLE",checkSessionToken=true,checkTrustedApp=true)	
	public void removeRoleFromUser(@PathVariable("userid") UUID userid,@PathVariable("roleid") UUID roleid) throws Exception {
	serviceFactory.getAccountService().removeRoleFromUser(userid, roleid);	
	}
	

	@RequestMapping(value = "/{userid}/passwordchanges", method = RequestMethod.PUT)
	@APIMapping(value="USR_PASSWORD_UPDATE",checkSessionToken=true, checkTrustedApp=true)
	public PasswordChange passwordUpdate( @PathVariable("userid") String userid,@Valid @RequestBody PasswordChange passwordChange,
			HttpServletRequest request) throws Exception {

		Session session = sessionHelper.getSession(request);
		Account account = new Account();
		validateAccess(account, session.getAccount(),userid);
		serviceFactory.getAccountService().updatePassword(account, passwordChange, session.getAccount().getUsername());
		return new PasswordChange();
	}
				
	public void validateAccess(Account requestAccount,Account loginUser,String userId) throws Exception {
		if(userId.equals("self")){
			requestAccount.setAccountId(loginUser.getAccountId());
		}else{
			try{
				UUID.fromString(userId);
			}catch (Exception e) {
				throw new AccountNotFoundException("Invalida user identification");
			}
			requestAccount.setAccountId(UUID.fromString(userId));
		}
	}
}
