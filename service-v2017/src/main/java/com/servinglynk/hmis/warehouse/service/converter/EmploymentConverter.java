package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
public class EmploymentConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Employment modelToEntity (Employment model ,com.servinglynk.hmis.warehouse.model.v2017.Employment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Employment();
       entity.setId(model.getEmploymentId());
       entity.setInformationDate(model.getInformationDate());
       if(model.getDataCollectionStage() !=null)
    	   	entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getEmployed()!=null)
       entity.setEmployed(EmploymentEmployedEnum.lookupEnum(model.getEmployed().toString()));
       if(model.getEmploymentType()!=null)
       entity.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(model.getEmploymentType().toString()));
       if(model.getNotEmployedReason()!=null)
       entity.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(model.getNotEmployedReason().toString()));
		if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Employment entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Employment entity) {
       Employment model = new Employment();
       model.setEmploymentId(entity.getId());
       if(entity.getInformationDate()!=null)
           model.setInformationDate(entity.getInformationDate());
        if(entity.getDataCollectionStage() !=null)
            model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));

       if(entity.getEmployed()!=null)
       model.setEmployed(Integer.parseInt(entity.getEmployed().getValue()));
       if(entity.getEmploymentType()!=null)
       model.setEmploymentType(Integer.parseInt(entity.getEmploymentType().getValue()));
       if(entity.getNotEmployedReason()!=null)
       model.setNotEmployedReason(Integer.parseInt(entity.getNotEmployedReason().getValue()));
       if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       return model;
   }


}
