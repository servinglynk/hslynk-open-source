package com.servinglynk.hmis.warehouse.client.search;

import java.util.List;

import com.servinglynk.hmis.warehouse.client.model.SearchRequest;

public interface ISearchServiceClient {

	List<?> search(SearchRequest request) throws Exception ;
}