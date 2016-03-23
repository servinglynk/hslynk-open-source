package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
public class InventoryConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Inventory modelToEntity (Inventory model ,com.servinglynk.hmis.warehouse.model.v2014.Inventory entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Inventory();
       entity.setId(model.getInventoryId());
       entity.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(model.getAvailabilty().toString()));

       entity.setBedtype(InventoryBedtypeEnum.lookupEnum(model.getBedtype().toString()));
       entity.setHmisparticipatingbeds(model.getHmisparticipatingbeds());
       entity.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum(model.getHouseholdtype().toString()));
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
       model.setBedtype(Integer.parseInt(entity.getBedtype().getValue()));
       model.setHmisparticipatingbeds(entity.getHmisparticipatingbeds());
       model.setHouseholdtype(Integer.parseInt(entity.getHouseholdtype().getValue()));
       model.setInventoryenddate(entity.getInventoryenddate());
       model.setInventorystartdate(entity.getInventorystartdate());
       model.setUnitinventory(entity.getUnitinventory());
       copyBeanProperties(entity, model);
       return model;
   }


}
