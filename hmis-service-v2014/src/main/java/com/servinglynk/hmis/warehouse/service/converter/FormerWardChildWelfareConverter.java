package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
public class FormerWardChildWelfareConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare modelToEntity (FormerWardChildWelfare model ,com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare();
       if(model.getChildwelfaremonths()!=null)
       entity.setChildwelfaremonths(model.getChildwelfaremonths());
       if(model.getChildwelfareyears()!=null)
       entity.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(model.getChildwelfareyears().toString()));
       if(model.getFormerwardchildwelfare()!=null)
       entity.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(model.getFormerwardchildwelfare().toString()));
       return entity;    
   }


   public static FormerWardChildWelfare entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare entity) {
       FormerWardChildWelfare model = new FormerWardChildWelfare();
       if(entity.getId()!=null)
       model.setFormerWardChildWelfareId(entity.getId());
       if(entity.getChildwelfaremonths()!=null)
       model.setChildwelfaremonths(entity.getChildwelfaremonths());
       if(entity.getChildwelfareyears()!=null)
       model.setChildwelfareyears(Integer.parseInt(entity.getChildwelfareyears().getValue()));
       if(entity.getFormerwardchildwelfare()!=null)
       model.setFormerwardchildwelfare(Integer.parseInt(entity.getFormerwardchildwelfare().getValue()));
       copyBeanProperties(entity, model);
       return model;
   }


}
