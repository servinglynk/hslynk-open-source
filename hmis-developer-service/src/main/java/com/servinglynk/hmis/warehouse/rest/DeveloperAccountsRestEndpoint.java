package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompanies;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;

@RestController
@RequestMapping("/accounts")
public class DeveloperAccountsRestEndpoint extends ControllerBase {

	@RequestMapping(value = "/{username}/owneddevelopercompanies", method = RequestMethod.GET)
	@APIMapping(checkSessionToken=true,checkTrustedApp=true)
	public DeveloperCompanies getOwnedDeveloperCompanies(@PathVariable("username") String username, HttpServletRequest request) throws Exception {

		Account account = null;
		if (!username.equalsIgnoreCase("self")) {
				account = serviceFactory.getAccountService().findAccountByUsername(username);
				if(account==null){
					throw new AccountNotFoundException("specified account doesn't exist");
			 }
			/* 09/06/2012 - making the API flexible to not no restrict for self , after meeting with Amrit and Daniel. 
			 * This should be back once user level authorization is in place.*/
			
		}else{
			Session session = sessionHelper.getSession(request);
			username = session.getAccount().getUsername();
			account = session.getAccount();
		}
		
		return serviceFactory.getDeveloperCompanyService().getOwnedDeveloperCompanies(username, account, Constants.DEVELOPER_CONSOLE_SERVICE);
	}
}