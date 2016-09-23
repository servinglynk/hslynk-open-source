/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2016.Inventory;

/**
 * @author Sandeep
 *
 */
public interface InventoryDao extends ParentDao {


	   Inventory createInventory(Inventory inventory);
	   Inventory updateInventory(Inventory inventory);
	   void deleteInventory(Inventory inventory);
	   Inventory getInventoryById(UUID inventoryId);
	   public Inventory getInventoryByDedupInventoryId(UUID id,String projectGroupCode);
	   List<Inventory> getAllInventories(Integer startIndex, Integer maxItems);
	   long getIventoriesCount();
	List<com.servinglynk.hmis.warehouse.model.v2016.Inventory> getAllCocInventories(UUID projectCocId,
			Integer startIndex, Integer maxItems);
	long getCocInventoriesCount(UUID projectCocId);
	   
}
