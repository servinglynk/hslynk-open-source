package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
public class CocConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2016.Coc modelToEntity (Projectcoc model ,com.servinglynk.hmis.warehouse.model.v2016.Coc entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Coc();
       if(model.getCoccode()!=null)
       entity.setCoccode(model.getCoccode());
       return entity;
   }


   public static Projectcoc entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Coc entity) {
       Projectcoc model = new Projectcoc();
       if(entity.getId()!=null)
       model.setProjectcocId(entity.getId());
       if(entity.getCoccode()!=null)
       model.setCoccode(entity.getCoccode());
       copyBeanProperties(entity, model);
       return model;
   }


}
