package com.servinglynk.hmis.warehouse.client.projects;

import com.servinglynk.hmis.warehouse.client.model.SearchRequest;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;

public interface ProjectSearchClient {

	BaseProject search(SearchRequest request) throws Exception;
	
}