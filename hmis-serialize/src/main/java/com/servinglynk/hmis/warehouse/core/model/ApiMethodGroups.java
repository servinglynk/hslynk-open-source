package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class ApiMethodGroups extends PaginatedModel {

	public List<ApiMethodGroup> apiMethodGroups = new ArrayList<ApiMethodGroup>();

	public List<ApiMethodGroup> getApiMethodGroups() {
		return apiMethodGroups;
	}

	public void setApiMethodGroups(List<ApiMethodGroup> apiMethodGroups) {
		this.apiMethodGroups = apiMethodGroups;
	}
	
	public void add(ApiMethodGroup apiMethodGroup){
		this.apiMethodGroups.add(apiMethodGroup);
	}
}