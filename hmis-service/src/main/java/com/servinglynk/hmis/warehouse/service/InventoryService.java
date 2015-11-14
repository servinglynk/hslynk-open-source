package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Inventories;
import com.servinglynk.hmis.warehouse.core.model.Inventory;
public interface InventoryService {

   Inventory createInventory(Inventory inventory,UUID projectCocId,String caller);
   Inventory updateInventory(Inventory inventory,UUID projectCocId,String caller);
   Inventory deleteInventory(UUID inventoryId,String caller);
   Inventory getInventoryById(UUID inventoryId);
   Inventories getAllProjectCocInventories(UUID projectCocId,Integer startIndex, Integer maxItems);
}
