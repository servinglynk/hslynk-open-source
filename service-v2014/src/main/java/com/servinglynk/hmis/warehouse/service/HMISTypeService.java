package com.servinglynk.hmis.warehouse.service;

import com.servinglynk.hmis.warehouse.core.model.HMISTypes;

public interface HMISTypeService {
	
	HMISTypes getDataElementNames();
	HMISTypes getDataElements(String name);
}