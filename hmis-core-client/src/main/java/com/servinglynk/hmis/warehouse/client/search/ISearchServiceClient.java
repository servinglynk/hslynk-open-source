package com.servinglynk.hmis.warehouse.client.search;

import java.util.List;

import com.servinglynk.hmis.warehouse.client.model.SearchRequest;
import com.servinglynk.hmis.warehouse.client.model.SearchResults;

public interface ISearchServiceClient {

	List<?> search(SearchRequest request) throws Exception ;
}