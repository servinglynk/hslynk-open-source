package com.servinglynk.hmis.warehouse.service;


import com.servinglynk.hmis.warehouse.model.SearchRequest;
import com.servinglynk.hmis.warehouse.model.SearchResults;
import com.servinglynk.hmis.warehouse.model.base.Client;

public interface SearchService {
	
		//public void createOrUpdateCleint(Client client);
		SearchResults searcClients(SearchRequest searchRequest);
		
		 void cacheClients() throws Exception;
}
