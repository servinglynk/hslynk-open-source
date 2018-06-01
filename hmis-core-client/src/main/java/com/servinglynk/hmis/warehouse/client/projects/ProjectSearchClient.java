package com.servinglynk.hmis.warehouse.client.projects;

import java.util.List;

import com.servinglynk.hmis.warehouse.client.model.SearchRequest;

public interface ProjectSearchClient {

	List<?> search(SearchRequest request) throws Exception;
	
}