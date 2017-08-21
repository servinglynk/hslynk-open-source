package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface ConnectionWithSoarDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar createConnectionWithSoar(com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar connectionWithSoar);
	   com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar updateConnectionWithSoar(com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar connectionWithSoar);
	   void deleteConnectionWithSoar(com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar connectionWithSoar);
	   com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar getConnectionWithSoarById(UUID connectionWithSoarId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.ConnectionWithSoar> getAllConnectionWithSoar(String geoCode, Integer startIndex, Integer maxItems);
	   long getConnectionWithSoarCount(String connectionWithSoar);
	   
}
