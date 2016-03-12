package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Inventories;
import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.service.InventoryService;
import com.servinglynk.hmis.warehouse.service.converter.InventoryConverter;
import com.servinglynk.hmis.warehouse.service.exception.InventoryNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectcocNotFoundException;


public class InventoryServiceImpl extends ServiceBase implements InventoryService  {

   @Transactional
   public Inventory createInventory(Inventory inventory,UUID projectCocId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Inventory pInventory = InventoryConverter.modelToEntity(inventory, null);
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = daoFactory.getProjectcocDao().getProjectcocById(projectCocId);
       if(pProjectcoc == null) throw new ProjectcocNotFoundException(); 
       pInventory.setProjectCoc(pProjectcoc);
       pInventory.setDateCreated(LocalDateTime.now());
    //   pInventory.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getInventoryDao().createInventory(pInventory);
       inventory.setInventoryId(pInventory.getId());
       return inventory;
   }


   @Transactional
   public Inventory updateInventory(Inventory inventory,UUID projectCocId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Projectcoc pProjectcoc = daoFactory.getProjectcocDao().getProjectcocById(projectCocId);
       if(pProjectcoc == null) throw new ProjectcocNotFoundException(); 
       
       com.servinglynk.hmis.warehouse.model.live.Inventory pInventory = daoFactory.getInventoryDao().getInventoryById(inventory.getInventoryId());
       if(pInventory==null) throw new InventoryNotFoundException();

       InventoryConverter.modelToEntity(inventory, pInventory);
       pInventory.setProjectCoc(pProjectcoc); 
       pInventory.setDateUpdated(LocalDateTime.now());
  //     pInventory.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getInventoryDao().updateInventory(pInventory);
       inventory.setInventoryId(pInventory.getId());
       return inventory;
   }


   @Transactional
   public Inventory deleteInventory(UUID inventoryId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Inventory pInventory = daoFactory.getInventoryDao().getInventoryById(inventoryId);
       if(pInventory==null) throw new InventoryNotFoundException();

       daoFactory.getInventoryDao().deleteInventory(pInventory);
       return new Inventory();
   }


   @Transactional
   public Inventory getInventoryById(UUID inventoryId){
       com.servinglynk.hmis.warehouse.model.live.Inventory pInventory = daoFactory.getInventoryDao().getInventoryById(inventoryId);
       if(pInventory==null) throw new InventoryNotFoundException();

       return InventoryConverter.entityToModel( pInventory );
   }


   @Transactional
   public Inventories getAllProjectCocInventories(UUID projectCocId,Integer startIndex, Integer maxItems){
	   Inventories inventorys = new Inventories();
        List<com.servinglynk.hmis.warehouse.model.live.Inventory> entities = daoFactory.getInventoryDao().getAllProjectCocInventories(projectCocId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Inventory entity : entities){
           inventorys.addInventory(InventoryConverter.entityToModel(entity));
        }
        long count = daoFactory.getInventoryDao().getProjectCocInventoriesCount(projectCocId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(inventorys.getInventories().size());
        pagination.setTotal((int)count);
        inventorys.setPagination(pagination);
        return inventorys; 
   }


}
