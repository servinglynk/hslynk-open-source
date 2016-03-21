package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
public class FormerWardChildWelfareConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare modelToEntity (FormerWardChildWelfare model ,com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare();
       entity.setChildwelfaremonths(model.getChildwelfaremonths());
       entity.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(model.getChildwelfareyears().toString()));
       entity.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(model.getFormerwardchildwelfare().toString()));
       return entity;    
   }


   public static FormerWardChildWelfare entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare entity) {
       FormerWardChildWelfare model = new FormerWardChildWelfare();
       model.setFormerWardChildWelfareId(entity.getId());
       model.setChildwelfaremonths(entity.getChildwelfaremonths());
       model.setChildwelfareyears(Integer.parseInt(entity.getChildwelfareyears().getValue()));
       model.setFormerwardchildwelfare(Integer.parseInt(entity.getFormerwardchildwelfare().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
