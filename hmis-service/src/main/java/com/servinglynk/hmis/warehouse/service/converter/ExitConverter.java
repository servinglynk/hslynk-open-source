package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
public class ExitConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Exit modelToEntity (Exit model ,com.servinglynk.hmis.warehouse.model.v2014.Exit entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
       entity.setDestination(ExitDestinationEnum.valueOf(model.getOtherDestination()));
       entity.setExitdate(model.getExitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Exit entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Exit entity) {
       Exit exit= new Exit();
       exit.setExitId(entity.getId());
       exit.setExitDate(Date.from(entity.getExitdate().atZone(ZoneId.systemDefault()).toInstant()));
       exit.setOtherDestination(entity.getOtherdestination());
       return exit;
   }


}
