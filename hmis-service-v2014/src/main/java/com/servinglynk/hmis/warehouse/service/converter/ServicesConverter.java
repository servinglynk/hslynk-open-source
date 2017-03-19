package com.servinglynk.hmis.warehouse.service.converter; 

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;
public class ServicesConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Services modelToEntity (Services model ,com.servinglynk.hmis.warehouse.model.v2014.Services entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Services();
       if(model.getServicesId()!=null)
       entity.setId(model.getServicesId());
       if(model.getDateprovided()!=null)
       entity.setDateprovided(model.getDateprovided().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       entity.setFaamount(new BigDecimal(model.getFaamount()));
       if(model.getRecordtype()!=null)
       entity.setRecordtype(ServicesRecordtypeEnum.lookupEnum(model.getRecordtype().toString()));
       if(model.getReferraloutcome()!=null)
       entity.setReferraloutcome(ServicesReferraloutcomeEnum.lookupEnum(model.getReferraloutcome().toString()));
       if(model.getSubtypeprovided()!=null)
       entity.setSubtypeprovided(model.getSubtypeprovided());
       if(model.getTypeprovided()!=null)
       entity.setTypeprovided(model.getTypeprovided());
       return entity;    
   }


   public static Services entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Services entity) {
       Services model = new Services();
       if(entity.getId()!=null)
       model.setServicesId(entity.getId());
       if(entity.getDateprovided()!=null)
       model.setDateprovided(Date.from(entity.getDateprovided().atZone(ZoneId.systemDefault()).toInstant()));
       if(entity.getFaamount()!=null)
       model.setFaamount(entity.getFaamount().floatValue());
       if(entity.getRecordtype()!=null)
       model.setRecordtype(Integer.parseInt(entity.getRecordtype().getValue()));
       if(entity.getReferraloutcome()!=null)
       model.setReferraloutcome(Integer.parseInt(entity.getReferraloutcome().getValue()));
       if(entity.getSubtypeprovided()!=null)
       model.setSubtypeprovided(entity.getSubtypeprovided());
       if(entity.getTypeprovided()!=null)
       model.setTypeprovided(entity.getTypeprovided());
       copyBeanProperties(entity, model);
       return model;
   }


}
