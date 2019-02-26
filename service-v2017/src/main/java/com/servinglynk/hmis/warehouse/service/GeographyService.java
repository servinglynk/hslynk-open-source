package com.servinglynk.hmis.warehouse.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Geographies;
import com.servinglynk.hmis.warehouse.core.model.Geography;

public interface GeographyService {

	   Geography createGeography(Geography Geography,UUID projectId,String caller);
	   Geography updateGeography(Geography Geography,UUID projectId,String caller);
	   Geography deleteGeography(UUID GeographyId,String caller);
	   Geography getGeographyById(UUID GeographyId);
	   Geographies getAllCocGeographys(UUID projectId,Integer startIndex, Integer maxItems);
}
