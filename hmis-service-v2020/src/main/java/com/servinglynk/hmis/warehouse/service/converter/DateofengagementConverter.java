package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
public class DateofengagementConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement modelToEntity (Dateofengagement model ,com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement();
       entity.setId(model.getDateofengagementId());
       entity.setDateofengagement(model.getDateofengagement());
		if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Dateofengagement entityToModel (com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement entity) {
       Dateofengagement model = new Dateofengagement();
       model.setDateofengagementId(entity.getId());
       model.setDateofengagement(entity.getDateofengagement());
       
       if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       return model;
   }


}
