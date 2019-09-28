package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessment;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
public class ExithousingassessmentConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Exithousingassessment modelToEntity (Exithousingassessment model ,com.servinglynk.hmis.warehouse.model.v2017.Exithousingassessment entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Exithousingassessment();
       entity.setId(model.getExithousingassessmentId());
 if(model.getHousingassessment()!=null)
       entity.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(model.getHousingassessment().toString()));
 if(model.getSubsidyinformation()!=null)
       entity.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(model.getSubsidyinformation().toString()));
	if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Exithousingassessment entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Exithousingassessment entity) {
       Exithousingassessment model = new Exithousingassessment();
       model.setExithousingassessmentId(entity.getId());
if(entity.getHousingassessment()!=null)
       model.setHousingassessment(Integer.parseInt(entity.getHousingassessment().getValue()));
if(entity.getSubsidyinformation()!=null)
       model.setSubsidyinformation(Integer.parseInt(entity.getSubsidyinformation().getValue()));

if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/exithousingassesments/"+entity.getId()+"/history"));
}
       return model;
   }


}
