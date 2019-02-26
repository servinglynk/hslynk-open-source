package com.servinglynk.hmis.warehouse.service.converter;

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
public class ExitConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Exit modelToEntity (Exit model ,com.servinglynk.hmis.warehouse.model.v2016.Exit entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Exit();
       if(model.getDestination()!=null)
       entity.setDestination(ExitDestinationEnum.lookupEnum(model.getDestination().toString()));
       if(model.getExitDate()!=null)
       entity.setExitdate(model.getExitDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       if(model.getOtherDestination()!=null)
       entity.setOtherdestination(model.getOtherDestination());
       return entity;
   }


   public static Exit entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Exit entity) {
       Exit exit= new Exit();
       if(entity.getId()!=null)
       exit.setExitId(entity.getId());
       if(entity.getExitdate()!=null)
       exit.setExitDate(Date.from(entity.getExitdate().atZone(ZoneId.systemDefault()).toInstant()));
       if(entity.getDestination()!=null)
       exit.setDestination(Integer.parseInt(entity.getDestination().getValue()));
       if(entity.getOtherdestination()!=null)
       exit.setOtherDestination(entity.getOtherdestination());
       copyBeanProperties(entity, exit);
       return exit;
   }


}
