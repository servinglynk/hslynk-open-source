package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Entryrhsp;
public class EntryrhspConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Entryrhsp modelToEntity (Entryrhsp model ,com.servinglynk.hmis.warehouse.model.v2016.Entryrhsp entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Entryrhsp();
       if(model.getEntryrhspId()!=null)
       entity.setId(model.getEntryrhspId());
       if(model.getWorstHousingSituation()!=null)
       entity.setWorstHousingSituation(model.getWorstHousingSituation());
       return entity;
   }


   public static Entryrhsp entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Entryrhsp entity) {
       Entryrhsp model = new Entryrhsp();
       if(entity.getId()!=null)
       model.setEntryrhspId(entity.getId());
       if(entity.getWorstHousingSituation()!=null)
       model.setWorstHousingSituation(entity.getWorstHousingSituation());
       return model;
   }


}
