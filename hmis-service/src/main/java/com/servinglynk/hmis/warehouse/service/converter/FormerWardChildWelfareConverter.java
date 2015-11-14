package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
public class FormerWardChildWelfareConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare modelToEntity (FormerWardChildWelfare model ,com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare();
       entity.setChildwelfaremonths(model.getChildwelfaremonths());
       entity.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.valueOf(model.getChildwelfareyears()));
       entity.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.valueOf(model.getFormerwardchildwelfare()));
       return entity;    
   }


   public static FormerWardChildWelfare entityToModel (com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare entity) {
       FormerWardChildWelfare model = new FormerWardChildWelfare();
       model.setFormerWardChildWelfareId(entity.getId());
       model.setChildwelfaremonths(entity.getChildwelfaremonths());
       model.setChildwelfareyears(entity.getChildwelfareyears().name());
       model.setFormerwardchildwelfare(entity.getFormerwardchildwelfare().name());
       return model;
   }


}
