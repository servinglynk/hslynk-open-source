package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
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
    	   entity.setInformationDate(model.getInformationDate());
       if(model.getDataCollectionStage() !=null)
    	   entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
    
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
       employment.setInformationDate(entity.getInformationDate());
       if(entity.getNotEmployedReason()!=null)
       employment.setNotEmployedReason(Integer.parseInt(entity.getNotEmployedReason().getValue()));
       if(entity.getInformationDate()!=null)
	       employment.setInformationDate(entity.getInformationDate());
       if(entity.getDataCollectionStage() !=null)
    	   	employment.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));

       copyBeanProperties(entity, employment);
       
       if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
    	   employment.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/employments/"+entity.getId()+"/history"));
       }
       return employment;
   }


}
