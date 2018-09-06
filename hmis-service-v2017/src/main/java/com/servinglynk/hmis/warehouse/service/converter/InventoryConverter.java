package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;
public class InventoryConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Inventory modelToEntity (Inventory model ,com.servinglynk.hmis.warehouse.model.v2017.Inventory entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Inventory();
       if(model.getInventoryId()!=null)
       entity.setId(model.getInventoryId());
       if(model.getAvailabilty()!=null)
       entity.setAvailabilty(InventoryAvailabiltyEnum.lookupEnum(model.getAvailabilty().toString()));
       if(model.getBedinventory()!=null)
           entity.setBedInventory(model.getBedinventory());
       if(model.getBedtype()!=null)
       entity.setBedtype(InventoryBedtypeEnum.lookupEnum(model.getBedtype().toString()));
       if(model.getHmisparticipatingbeds()!=null)
       entity.setHmisparticipatingbeds(model.getHmisparticipatingbeds());
       if(model.getHouseholdtype()!=null)
       entity.setHouseholdtype(InventoryHouseholdtypeEnum.lookupEnum(model.getHouseholdtype().toString()));
       if(model.getInventoryenddate()!=null)
       entity.setInventoryenddate(model.getInventoryenddate());
       if(model.getInventorystartdate()!=null)
       entity.setInventorystartdate(model.getInventorystartdate());
       if(model.getUnitinventory()!=null)
       entity.setUnitinventory(model.getUnitinventory());
     //  if(model.getBedinventory()!=null)
     //  entity.setBedinventory(model.getBedinventory());
       if(model.getChbedinventory()!=null)
       entity.setChBedInventory(model.getChbedinventory());
       if(model.getVetbedinventory()!=null)
       entity.setVetBedInventory(model.getVetbedinventory());
       if(model.getYouthbedinventory()!=null)
       entity.setYouthBedInventory(model.getYouthbedinventory());
       return entity;
   }


   public static Inventory entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Inventory entity) {
       Inventory model = new Inventory();
       if(entity.getId()!=null)
       model.setInventoryId(entity.getId());
		if(entity.getAvailabilty()!=null)
       model.setAvailabilty(Integer.parseInt(entity.getAvailabilty().getValue()));
 		if(entity.getBedtype()!=null)
       model.setBedtype(Integer.parseInt(entity.getBedtype().getValue()));
       if(entity.getHmisparticipatingbeds()!=null)
       model.setHmisparticipatingbeds(entity.getHmisparticipatingbeds());
       if(entity.getHouseholdtype()!=null)
       model.setHouseholdtype(Integer.parseInt(entity.getHouseholdtype().getValue()));
       if(entity.getInventoryenddate()!=null)
       model.setInventoryenddate(entity.getInventoryenddate());
       if(entity.getInventorystartdate()!=null)
       model.setInventorystartdate(entity.getInventorystartdate());
       if(entity.getUnitinventory()!=null)
       model.setUnitinventory(entity.getUnitinventory());
   /*    if(entity.getBedinventory()!=null)
       model.setBedinventory(entity.getBedinventory());*/
       if(entity.getChBedInventory()!=null)
       model.setchbedinventory(entity.getChBedInventory());
       if(entity.getYouthBedInventory()!=null)
       model.setYouthbedinventory(entity.getYouthBedInventory());
       if(entity.getVetBedInventory()!=null)
       model.setVetbedinventory(entity.getVetBedInventory());
       copyBeanProperties(entity, model);
       return model;
   }


}
