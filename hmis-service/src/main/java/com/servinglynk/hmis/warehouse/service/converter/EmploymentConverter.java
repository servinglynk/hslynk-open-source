package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
public class EmploymentConverter {

   public static com.servinglynk.hmis.warehouse.model.live.Employment modelToEntity (Employment model ,com.servinglynk.hmis.warehouse.model.live.Employment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.live.Employment();
       entity.setEmployed(EmploymentEmployedEnum.valueOf(model.getEmployed()));
       entity.setEmploymentType(EmploymentEmploymentTypeEnum.valueOf(model.getEmploymentType()));
       entity.setNotEmployedReason(EmploymentNotEmployedReasonEnum.valueOf(model.getNotEmployedReason()));
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Employment entityToModel (com.servinglynk.hmis.warehouse.model.live.Employment entity) {
       Employment employment= new Employment();
       
       employment.setEmployed(entity.getEmployed().name());
       employment.setEmploymentId(entity.getId());
       employment.setEmploymentType(entity.getEmploymentType().name());
       employment.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       employment.setNotEmployedReason(entity.getNotEmployedReason().name());
       return employment;
   }


}
