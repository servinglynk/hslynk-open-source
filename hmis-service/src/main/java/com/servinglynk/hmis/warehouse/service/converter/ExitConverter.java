package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
public class ExitConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Exit modelToEntity (Exit model ,com.servinglynk.hmis.warehouse.model.live.Exit entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Exit();
       entity.setDestination(ExitDestinationEnum.valueOf(model.getOtherDestination()));
       entity.setExitdate(model.getExitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
       return entity;    
   }


   public static Exit entityToModel (com.servinglynk.hmis.warehouse.model.live.Exit entity) {
       Exit exit= new Exit();
       exit.setExitId(entity.getId());
       exit.setExitDate(Date.from(entity.getExitdate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
       exit.setOtherDestination(entity.getOtherdestination());
       return exit;
   }


}
