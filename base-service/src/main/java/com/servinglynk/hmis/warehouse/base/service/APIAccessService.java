package com.servinglynk.hmis.warehouse.base.service;

import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.APIAccess;

public interface APIAccessService {

	List<APIAccess> getAPIAccessDetails(String filter, String q);
}