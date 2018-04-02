package com.servinglynk.hmis.household.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.household.anntation.ValidateClient;
import com.servinglynk.hmis.warehouse.client.model.SearchRequest;
import com.servinglynk.hmis.warehouse.client.search.ISearchServiceClient;
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;

public class ClientValidator implements ConstraintValidator<ValidateClient,Object>  {
	
	 @Autowired
	 ISearchServiceClient searchServiceClient;
	 
	 @Autowired
	 SessionHelper sessionHelper;
	 
	 @Autowired
	 TrustedAppHelper trustedAppHelper;
	 
	 @Autowired
	 private HttpServletRequest request;
	 
	 String clientField;
	 String link;
	 String dedupClientId;
	 
	 
	@Override
	public void initialize(ValidateClient arg0) {
		clientField = arg0.clientIdField();	
		link = arg0.linkField();
		dedupClientId = arg0.dedupClientIdField();
	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		
		String clientId;
		try {
			clientId = BeanUtils.getProperty(arg0, clientField);
		
		
	
		String trustedApp= trustedAppHelper.retrieveTrustedAppId(request);
		Session session = sessionHelper.getSession(request);
		
		SearchRequest request = new SearchRequest();
		request.setTrustedAppId(trustedApp);
		request.setSearchEntity("clients");
		request.setSessionToken(session.getToken());
		request.addSearchParam("q", clientId);
		List<BaseClient> clients=new ArrayList<BaseClient>();
		clients = (List<BaseClient>) searchServiceClient.search(request);
	
		if(clients.isEmpty()){
			arg1.disableDefaultConstraintViolation();
			arg1.buildConstraintViolationWithTemplate(" Invalid Client Identification "+clientId).addConstraintViolation();
			return false;
		}else{
			BaseClient client = clients.get(0);
			BeanUtils.setProperty(arg0, link, client.getLink());
			BeanUtils.setProperty(arg0, dedupClientId, client.getDedupClientId());
			BeanUtils.setProperty(arg0, "schemaYear", this.getSchemaYear(client.getLink()));
			return true;
		}
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getSchemaYear(String link) {
		return link.substring(link.indexOf("/v")+2,link.indexOf("/clients"));
	}

}
