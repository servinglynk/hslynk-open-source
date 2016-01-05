package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.PasswordReset;
import com.servinglynk.hmis.warehouse.core.model.Preferences;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedApps;
import com.servinglynk.hmis.warehouse.core.model.UsernameChange;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.enums.HmisUserGenderEnum;
import com.servinglynk.hmis.warehouse.service.exception.AccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.AccountDisabledException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;

@RestController
@RequestMapping("/accounts")
public class AccountsController extends ControllerBase {

	@APIMapping(value="USR_CREATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	@RequestMapping(method = RequestMethod.POST)
	public Account createAccount(@RequestBody Account account, @RequestParam(value="purpose",required= false,defaultValue="" ) String purpose, HttpServletRequest request) throws Exception {
	
		Session session = sessionHelper.getSession(request);
		return createAccount(account, request,session ,purpose);
	}
	
			
	private Account createAccount(Account account, HttpServletRequest request,Session session ,String purpose) throws Exception{
				// checks for existing account
		

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
	public Account createDeveloperAccount(@RequestBody Account account, @RequestParam(value="purpose",required= false,defaultValue="" ) String purpose, HttpServletRequest request) throws Exception {
		Session session = new Session();
		session.setAccount(account);
		account.setOrganizationId(UUID.fromString("b5598c6c-d021-4f5f-9695-77f7f4685ed2"));
		Profile profile = new Profile();
		profile.setId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setProfile(profile);
		Role role =new Role();
		role.setId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setRole(role);	
		account.setGender(HmisUserGenderEnum.valueOf("ONE").name());
		ProjectGroup projectGroup=new ProjectGroup();
		projectGroup.setProjectGroupId(UUID.fromString("1ebd9476-600c-463f-8c3d-bf8accad472b"));
		account.setProjectGroup(projectGroup);
		return createAccount(account, request,session ,purpose);
	}
	


	/**
	 * HTTP GET handler for /accounts/{username}/emailaddress REST requests. It retrieves the account for the currently logged-in user.
	 */
	@RequestMapping(value = "/{username}/emailaddress", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT_EMAIL_ADDRESS",checkSessionToken=true, checkTrustedApp=true)
	public Account getAccountEmailAddress(@PathVariable("username") String usernamePathVar, HttpServletRequest request) throws Exception {
		if (!usernamePathVar.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}

		Session session = sessionHelper.getSession(request);
		return  serviceFactory.getAccountService().loadAccountBasicInfoByUsername(session.getAccount().getUsername());

	}

	/**
	 * HTTP GET handler for /accounts/{username}/basicinfo REST requests. It retrieves the account for the currently logged-in user.
	 */
	@RequestMapping(value = "/{username}/basicinfo", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT_BASIC_INFO",checkSessionToken=true, checkTrustedApp=true)
	public Account getAccountBasicInfo(@PathVariable("username") String usernamePathVar, HttpServletRequest request) throws Exception {
		if (!usernamePathVar.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}

		Session session = sessionHelper.getSession(request);
		Account account = serviceFactory.getAccountService().loadAccountBasicInfoByUsername(session.getAccount().getUsername());
		return account;
	}


	@RequestMapping(value = "/{username}/trustedapps", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_AUTHORIZED_TRUSTEDAPPS",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApps getAuthorizedTrustedApps(@PathVariable("username") String usernamePathVar, HttpServletRequest request) throws Exception {
		if (!usernamePathVar.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}

		Session session = sessionHelper.getSession(request);

		List<TrustedApp> trustedAppList = serviceFactory.getTrustedAppService().getAuthorizedTrustedApps(session.getAccount().getUsername(),
				Constants.USER_SERVICE);

		TrustedApps trustedApps = new TrustedApps();
		trustedApps.setTrustedApps(trustedAppList);

		return trustedApps;
	}

	/**
	 * HTTP GET handler for /accounts/{username} REST requests. It retrieves the account for the currently logged-in user.
	 */
	@RequestMapping(value = "/{username:.*}", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public Account getAccount(@PathVariable("username") String usernamePathVar, HttpServletRequest request) throws Exception {
		if (!usernamePathVar.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}
		Session session = sessionHelper.getSession(request);
		return serviceFactory.getAccountService().findAccountByUsername(session.getAccount().getUsername());
	}

	/**
	 * HTTP PUT handler for /accounts/{username} REST requests. It updates the account for the currently logged-in user.
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	@APIMapping(value="USR_UPDATE_ACCOUNT",checkSessionToken=true, checkTrustedApp=true)
	public Account updateAccount(@PathVariable("username") String username, @RequestBody Account account, HttpServletRequest request)
			throws Exception {
		if (!username.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}
		// Retrieve the accountId and the username from session
		Session session = sessionHelper.getSession(request);
		account.setAccountId(session.getAccount().getAccountId());
		account.setUsername(session.getAccount().getUsername());

		return serviceFactory.getAccountService().updateAccount(account, USER_SERVICE);
	}

	/**
	 * HTTP GET handler for /accounts/{username}/status REST requests. It retrieves the current status of an account.
	 */
	@RequestMapping(value = "/{username}/status", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT_STATUS",checkSessionToken=false, checkTrustedApp=true)
	public Account getAccountStatus(@PathVariable("username") String username, HttpServletRequest request) throws Exception {
		String status = null;
		try {
			status = serviceFactory.getAccountService().getAccountStatus(username);
		} catch (AccountNotFoundException e) {
			status = Constants.ACCOUNT_STATUS_NONEXISTENT;
		}
		Account account = new Account();
		account.setStatus(status);
		return account;
	}

	/**
	 * HTTP GET handler for /accounts/{username}/status REST requests. It retrieves the current status of an account.
	 */
	@RequestMapping(value = "/{username}/preferences", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ACCOUNT_PREFERENCES",checkSessionToken=true, checkTrustedApp=true)
	public Preferences getAccountPreferences(@PathVariable("username") String username, HttpServletRequest request) throws Exception {
		if (!username.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}
		// Retrieve the accountId and the username from session
		Session session = sessionHelper.getSession(request);
		Preferences preferences = session.getAccount().getPreferences();
		if (preferences == null)
			preferences = new Preferences();
		return preferences;
	}

	/**
	 * HTTP GET handler for /accounts/{username}/status REST requests. It retrieves the current status of an account.
	 */
	@RequestMapping(value = "/{username}/preferences", method = RequestMethod.PUT)
	@APIMapping(value="USR_UPDATE_ACCOUNT_PREFERENCES",checkSessionToken=true, checkTrustedApp=true)
	public Preferences updateAccountPreferences(@PathVariable("username") String username, @RequestBody Preferences preferences,
			HttpServletRequest request) throws Exception {
		if (!username.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}
		Session session = sessionHelper.getSession(request);
		session.getAccount().setPreferences(preferences);
		preferences = serviceFactory.getAccountService().updatePreferences(session.getAccount(), USER_SERVICE);
		return preferences;
	}

	/**
	 * HTTP Post handler for /accounts/{username}/passwordresets REST requests. It sends a password reset notification to reset users
	 * password. i.e forgot password
	 */
	@RequestMapping(value = "/{username}/passwordresets", method = RequestMethod.POST)
	@APIMapping(value="USR_PASSWORD_RESET",checkSessionToken=false, checkTrustedApp=true)
	public PasswordReset passwordReset(@PathVariable("username") String username,  @RequestParam(value="caller", required=false ) String redirectURL, HttpServletRequest request) throws Exception {

		serviceFactory.getAccountService().findAccountByUsername(username);

		// Check is account is disabled
		if (serviceFactory.getAccountService().getAccountStatus(username).toLowerCase() == "disabled") {
			throw new AccountDisabledException();
		}

		serviceFactory.getPasswordResetService().createPasswordReset(username, USER_SERVICE,redirectURL);
		PasswordReset returnPasswordReset = new PasswordReset();
		return returnPasswordReset;
	}

	/**
	 * HTTP Post handler for /accounts/{username}/passwordchanges REST requests. Updates the users password with valid session. i.e my
	 * account update password
	 */
	@RequestMapping(value = "/{username}/passwordchanges", method = RequestMethod.POST)
	@APIMapping(value="USR_PASSWORD_UPDATE",checkSessionToken=true, checkTrustedApp=true)
	public PasswordChange passwordUpdate(@PathVariable("username") String username, @RequestBody PasswordChange passwordChange,
			HttpServletRequest request) throws Exception {

		if (!username.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}

		Session session = sessionHelper.getSession(request);
		serviceFactory.getAccountService().updatePassword(session.getAccount().getUsername(), passwordChange, USER_SERVICE);
		return new PasswordChange();

	}
	
	/**
	 * HTTP Post handler for /accounts/{username}/usernamechanges REST requests. Changes username for an account.
	 * To change the username, the user must be logged-in and provide his/her current password. The status of the account will become PENDING.
	 * The status is changed to ACTIVE when the user verifies the username change by clicking the link embedded in the email.
	 * An e-mail will be sent to the old account e-mail as well notifying of this change.
	 */
	@RequestMapping(value = "/{username}/usernamechanges", method = RequestMethod.POST)
	@APIMapping(value="USR_USERNAME_CHANGE",checkSessionToken=true, checkTrustedApp=true)
	public UsernameChange usernameChange(@PathVariable("username") String username, @RequestBody UsernameChange usernameChange,
			HttpServletRequest request) throws Exception {

		if (!username.equalsIgnoreCase("self")) {
			throw new AccessDeniedException("only self is allowed as the username in the URI");
		}

		Session session = sessionHelper.getSession(request);
		serviceFactory.getUsernameChangeService().createUsernameChange(session.getAccount().getUsername(), usernameChange, USER_SERVICE);

		return usernameChange;

	}
	
	@RequestMapping(value = "/{username}/roles", method = RequestMethod.POST)
	@APIMapping(value="ACL_CREATE_USER_ROLE",checkSessionToken=false, checkTrustedApp=false)	
	public void createUserRole(@PathVariable("username") String username,@RequestBody Role role,HttpServletRequest request) throws Exception {
		serviceFactory.getAccountService().createUserRole(username,role);
	}
	
	@RequestMapping(value = "/{username}/roles", method = RequestMethod.PUT)
	@APIMapping(value="ACL_UPDATE_USER_ROLE",checkSessionToken=false, checkTrustedApp=false)	
	public void updateUserRole(@PathVariable("username") String username,@RequestBody Role role,HttpServletRequest request) throws Exception {
		serviceFactory.getAccountService().updateUserRole(username,role);
	}
	
	@RequestMapping(value = "/{organizationId}/users", method = RequestMethod.GET)
	@APIMapping(value="USR_GET_ORGANIZATION_USERS",checkSessionToken=true, checkTrustedApp=true)	
	public Accounts getUserByOrganization(@PathVariable("organizationId") UUID organizationId,HttpServletRequest request) throws Exception {
		return serviceFactory.getAccountService().getUsersByOrganization(organizationId);
	}
}
