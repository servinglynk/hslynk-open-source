package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
public class ResidentialmoveindateConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Moveindate modelToEntity (Residentialmoveindate model ,com.servinglynk.hmis.warehouse.model.v2020.Moveindate entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Moveindate();
       entity.setId(model.getResidentialmoveindateId());
       entity.setMoveindate(model.getResidentialmoveindate());
       entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Residentialmoveindate entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Moveindate entity) {
       Residentialmoveindate model = new Residentialmoveindate();
       model.setResidentialmoveindateId(entity.getId());
       model.setResidentialmoveindate(entity.getMoveindate());
       if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       return model;
   }


}
