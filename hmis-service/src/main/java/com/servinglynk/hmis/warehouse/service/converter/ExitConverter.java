package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
public class ExitConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Exit modelToEntity (Exit model ,com.servinglynk.hmis.warehouse.model.v2014.Exit entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
       entity.setDestination(ExitDestinationEnum.lookupEnum(model.getDestination().toString()));
       entity.setExitdate(model.getExitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       entity.setOtherdestination(model.getOtherDestination());
       return entity;    
   }


   public static Exit entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Exit entity) {
       Exit exit= new Exit();
       exit.setExitId(entity.getId());
       exit.setExitDate(Date.from(entity.getExitdate().atZone(ZoneId.systemDefault()).toInstant()));
       exit.setDestination(Integer.parseInt(entity.getDestination().getValue()));
       exit.setOtherDestination(entity.getOtherdestination());
       copyBeanProperties(entity, exit);
       return exit;
   }


}
