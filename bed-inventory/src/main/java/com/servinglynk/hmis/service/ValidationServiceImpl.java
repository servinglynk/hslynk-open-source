package com.servinglynk.hmis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.servinglynk.hmis.warehouse.client.search.ISearchServiceClient;
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
import com.servinglynk.hmis.service.exception.RestClientException;
import com.servinglynk.hmis.warehouse.client.model.SearchRequest;

@Service
public class ValidationServiceImpl implements ValidationService {
	
	@Autowired ISearchServiceClient searchServiceClient;

	
	public UUID validateCleintId(UUID clientId) throws Exception {
		JSONObjectMapper mapper = new JSONObjectMapper();
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setSessionToken(SecurityContextUtil.getSessionToken());
		searchRequest.setTrustedAppId(SecurityContextUtil.getCleintTypeId());
		searchRequest.setSearchEntity("clients");
		searchRequest.getSearchParams().put("q", clientId);
		List<BaseClient> clients=new ArrayList<BaseClient>();
		
		try {
			clients = (List<BaseClient>) searchServiceClient.search(searchRequest);
		}catch (HttpClientErrorException e) {
			Errors errors = mapper.readValue(e.getResponseBodyAsString(),Errors.class);
			throw new RestClientException(errors.getError().get(0).getMessage(), errors.getError().get(0).getCode(),e.getRawStatusCode());
		} catch (Exception e) {
			throw e;
		}
		
		if(clients.isEmpty()){

		throw	new ResourceNotFoundException(" Invalid Client Identification "+clientId);

		}else{
			BaseClient client = clients.get(0);
			return client.getDedupClientId();
		}
	}
	
	public String validateEnrillment(UUID enrollmentId) {
		return null;
	}
}
