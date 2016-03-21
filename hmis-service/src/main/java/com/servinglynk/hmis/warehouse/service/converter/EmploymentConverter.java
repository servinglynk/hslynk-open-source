package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
public class EmploymentConverter extends BaseConveter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Employment modelToEntity (Employment model ,com.servinglynk.hmis.warehouse.model.v2014.Employment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Employment();
       entity.setEmployed(EmploymentEmployedEnum.lookupEnum(model.getEmployed().toString()));
       entity.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(model.getEmploymentType().toString()));
       entity.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(model.getNotEmployedReason().toString()));
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Employment entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Employment entity) {
       Employment employment= new Employment();
       
       employment.setEmployed(Integer.parseInt(entity.getEmployed().getValue()));
       employment.setEmploymentId(entity.getId());
       employment.setEmploymentType(Integer.parseInt(entity.getEmploymentType().getValue()));
       employment.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       employment.setNotEmployedReason(Integer.parseInt(entity.getNotEmployedReason().getValue()));
       copyBeanProperties(entity, employment);
       return employment;
   }


}
