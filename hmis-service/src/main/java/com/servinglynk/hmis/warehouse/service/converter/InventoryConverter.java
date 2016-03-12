package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
public class InventoryConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Inventory modelToEntity (Inventory model ,com.servinglynk.hmis.warehouse.model.v2014.Inventory entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Inventory();
       entity.setId(model.getInventoryId());
       entity.setAvailabilty(InventoryAvailabiltyEnum.valueOf(model.getAvailabilty()));

       entity.setBedtype(InventoryBedtypeEnum.valueOf(model.getBedtype()));
       entity.setHmisparticipatingbeds(model.getHmisparticipatingbeds());
       entity.setHouseholdtype(InventoryHouseholdtypeEnum.valueOf(model.getHouseholdtype()));
       entity.setInventoryenddate(model.getInventoryenddate());
       entity.setInventorystartdate(model.getInventorystartdate());
       entity.setUnitinventory(model.getUnitinventory());
       return entity;    
   }


   public static Inventory entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Inventory entity) {
       Inventory model = new Inventory();
       model.setInventoryId(entity.getId());
       model.setAvailabilty(entity.getAvailabilty().name());
       if(entity.getBedinventory() != null)   model.setBedinventory(entity.getBedinventory().getId());
       model.setBedtype(entity.getBedtype().name());
       model.setHmisparticipatingbeds(entity.getHmisparticipatingbeds());
       model.setHouseholdtype(entity.getHouseholdtype().name());
       model.setInventoryenddate(entity.getInventoryenddate());
       model.setInventorystartdate(entity.getInventorystartdate());
       model.setUnitinventory(entity.getUnitinventory());
       return model;
   }


}
