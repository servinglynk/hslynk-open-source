package com.servinglynk.hmis.warehouse.test.rest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Parameter;
import com.servinglynk.hmis.warehouse.core.model.Verification;
import com.servinglynk.hmis.warehouse.test.core.TestData;
import com.servinglynk.hmis.warehouse.test.core.WebserviceTestExecutor;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
public class TestVerificationsRestEndpoint extends WebserviceTestExecutor {
	
	@Test
	public void testCreateVerification() throws Exception {
		
		Account account = TestData.getAccount();

		Account newAccount = executePost("/accounts/u", account, Account.class, null);

		Parameter param = new Parameter();
		param.setKey("username");
		param.setValue(newAccount.getUsername());
		
		List<Parameter> parameters = new java.util.ArrayList<Parameter>();
		parameters.add(param);
		
		Verification verification = new Verification();
		verification.setStatus(Constants.VERIFICATION_TYPE_ACCOUNT_CREATION);
		verification.setType(Constants.VERIFICATION_TYPE_ACCOUNT_CREATION);
		
		verification.setParameters(parameters);
		
		Verification resp = executePost("/verifications",verification,Verification.class, newAccount.getUsername());
		
		System.out.println(resp.toJSONString());
		
	//	Verification verification2 = executePut("/verifications/test/status",verification,Verification.class, newAccount.getUsername());
		
		
	}
	
	
	

}
