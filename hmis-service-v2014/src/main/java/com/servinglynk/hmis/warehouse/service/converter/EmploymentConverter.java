package com.servinglynk.hmis.warehouse.service.converter; 

import java.time.ZoneId;
import java.util.Date;

import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
public class EmploymentConverter extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2014.Employment modelToEntity (Employment model ,com.servinglynk.hmis.warehouse.model.v2014.Employment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2014.Employment();
       if(model.getEmployed()!=null)
       entity.setEmployed(EmploymentEmployedEnum.lookupEnum(model.getEmployed().toString()));
       if(model.getEmploymentType()!=null)
       entity.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(model.getEmploymentType().toString()));
       if(model.getNotEmployedReason()!=null)
       entity.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(model.getNotEmployedReason().toString()));
       if(model.getInformationDate()!=null)
       entity.setInformationDate(model.getInformationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       return entity;    
   }


   public static Employment entityToModel (com.servinglynk.hmis.warehouse.model.v2014.Employment entity) {
       Employment employment= new Employment();
       if(entity.getEmployed()!=null)
       employment.setEmployed(Integer.parseInt(entity.getEmployed().getValue()));
       if(entity.getId()!=null)
       employment.setEmploymentId(entity.getId());
       if(entity.getEmploymentType()!=null)
       employment.setEmploymentType(Integer.parseInt(entity.getEmploymentType().getValue()));
       if(entity.getInformationDate()!=null)
       employment.setInformationDate(Date.from(entity.getInformationDate().atZone(ZoneId.systemDefault()).toInstant()));
       if(entity.getNotEmployedReason()!=null)
       employment.setNotEmployedReason(Integer.parseInt(entity.getNotEmployedReason().getValue()));
       copyBeanProperties(entity, employment);
       return employment;
   }


}
