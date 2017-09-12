package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface GeographyDao extends ParentDao{
	
	 com.servinglynk.hmis.warehouse.model.v2017.Geography createGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   com.servinglynk.hmis.warehouse.model.v2017.Geography updateGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   void deleteGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography);
	   com.servinglynk.hmis.warehouse.model.v2017.Geography getGeographyById(UUID geographyId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Geography> getAllGeography(String geoCode, Integer startIndex, Integer maxItems);
	   long getGeographyCount(String geoCode);

}
