package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Entryrhsp;
public class EntryrhspConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp modelToEntity (Entryrhsp model ,com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
       entity.setId(model.getEntryrhspId());
       entity.setWorstHousingSituation(model.getWorstHousingSituation());
       return entity;    
   }


   public static Entryrhsp entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entity) {
       Entryrhsp model = new Entryrhsp();
       model.setEntryrhspId(entity.getId());
       model.setWorstHousingSituation(entity.getWorstHousingSituation());
       return model;
   }


}
