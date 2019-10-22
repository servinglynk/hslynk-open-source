package com.servinglynk.hmis.warehouse.service.converter;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.enums.GeographyTypeEnum;
public class CocConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Coc modelToEntity (Projectcoc model ,com.servinglynk.hmis.warehouse.model.v2020.Coc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Coc();
       if(model.getCoccode()!=null)
       entity.setCoccode(model.getCoccode());
       entity.setAddress1(model.getAddress1());
       entity.setAddress2(model.getAddress2());
       entity.setCity(model.getCity());
       entity.setGeoCode(model.getGeocode());
       if(StringUtils.isNotEmpty(model.getGeographyType()))
    	   entity.setGeographyType(GeographyTypeEnum.lookupEnum(model.getGeographyType()));
       entity.setState(model.getState());
       entity.setZip(model.getZip());
       return entity;
   }


   public static Projectcoc entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Coc entity) {
       Projectcoc model = new Projectcoc();
       if(entity.getId()!=null)
       model.setProjectcocId(entity.getId());
       if(entity.getCoccode()!=null)
       model.setCoccode(entity.getCoccode());
       copyBeanProperties(entity, model);
       model.setAddress1(entity.getAddress1());
       model.setAddress2(entity.getAddress2());
       model.setCity(entity.getCity());
       model.setGeocode(entity.getGeoCode());
       if(entity.getGeographyType() !=null)
    	   model.setGeographyType(entity.getGeographyType().getValue());
       model.setState(entity.getState());
       model.setZip(entity.getZip());
       return model;
   }


}
