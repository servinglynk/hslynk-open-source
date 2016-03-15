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
public interface InventoryDao extends ParentDao {


	   com.servinglynk.hmis.warehouse.model.v2015.Inventory createInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory);
	   com.servinglynk.hmis.warehouse.model.v2015.Inventory updateInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory);
	   void deleteInventory(com.servinglynk.hmis.warehouse.model.v2015.Inventory inventory);
	   com.servinglynk.hmis.warehouse.model.v2015.Inventory getInventoryById(UUID inventoryId);
	   List<com.servinglynk.hmis.warehouse.model.v2015.Inventory> getAllProjectCocInventories(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getProjectCocInventoriesCount(UUID enrollmentId);
}
