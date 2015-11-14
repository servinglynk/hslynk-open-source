package com.servinglynk.hmis.warehouse.service.converter; 

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
public class ServicesConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Services modelToEntity (Services model ,com.servinglynk.hmis.warehouse.model.live.Services entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Services();
       entity.setId(model.getServicesId());
       entity.setDateprovided(model.getDateprovided().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       entity.setFaamount(new BigDecimal(model.getFaamount()));
       entity.setRecordtype(ServicesRecordtypeEnum.valueOf(model.getRecordtype()));
       entity.setReferraloutcome(ServicesReferraloutcomeEnum.valueOf(model.getReferraloutcome()));
       entity.setSubtypeprovided(model.getSubtypeprovided());
       entity.setTypeprovided(model.getTypeprovided());
       return entity;    
   }


   public static Services entityToModel (com.servinglynk.hmis.warehouse.model.live.Services entity) {
       Services model = new Services();
       model.setServicesId(entity.getId());
       model.setDateprovided(Date.from(entity.getDateprovided().atZone(ZoneId.systemDefault()).toInstant()));
       model.setFaamount(entity.getFaamount().floatValue());
       model.setRecordtype(entity.getRecordtype().name());
       model.setReferraloutcome(entity.getReferraloutcome().name());
       model.setSubtypeprovided(entity.getSubtypeprovided());
       model.setTypeprovided(entity.getTypeprovided());
       return model;
   }


}
