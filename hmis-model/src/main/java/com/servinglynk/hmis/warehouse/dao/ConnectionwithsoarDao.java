/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface ConnectionwithsoarDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar createConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar);
	   com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar updateConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar);
	   void deleteConnectionwithsoar(com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar connectionwithsoar);
	   com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar getConnectionwithsoarById(UUID connectionwithsoarId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar> getAllExitConnectionwithsoars(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitConnectionwithsoarsCount(UUID exitId);
}
