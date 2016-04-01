package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
public class ExitrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Exitrhy modelToEntity (Exitrhy model ,com.servinglynk.hmis.warehouse.model.v2015.Exitrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Exitrhy();
       entity.setId(model.getExitrhyId());
       entity.setProjectCompletionStatus(model.getProjectCompletionStatus());
       entity.setEarlyExitReason(model.getEarlyExitReason());
       entity.setFamilyReunificationAchieved(model.getFamilyReunificationAchieved());
       entity.setWrittenAfterCarePlan(model.getWrittenAfterCarePlan());
       entity.setAssistanceMainStreamBenefits(model.getAssistanceMainStreamBenefits());
       entity.setPermenantHousingPlacement(model.getPermenantHousingPlacement());
       entity.setTempShelterPlacement(model.getTempShelterPlacement());
       entity.setExitCounseling(model.getExitCounseling());
       entity.setFurtherFollowupServices(model.getFurtherFollowupServices());
       entity.setScheduledFollowupContacts(model.getScheduledFollowupContacts());
       entity.setResourcePackage(model.getResourcePackage());
       entity.setOtherAftercarePlanOrAction(model.getOtherAftercarePlanOrAction());
       return entity;    
   }


   public static Exitrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Exitrhy entity) {
       Exitrhy model = new Exitrhy();
       model.setExitrhyId(entity.getId());
       model.setProjectCompletionStatus(entity.getProjectCompletionStatus());
       model.setEarlyExitReason(entity.getEarlyExitReason());
       model.setFamilyReunificationAchieved(entity.getFamilyReunificationAchieved());
       model.setWrittenAfterCarePlan(entity.getWrittenAfterCarePlan());
       model.setAssistanceMainStreamBenefits(entity.getAssistanceMainStreamBenefits());
       model.setPermenantHousingPlacement(entity.getPermenantHousingPlacement());
       model.setTempShelterPlacement(entity.getTempShelterPlacement());
       model.setExitCounseling(entity.getExitCounseling());
       model.setFurtherFollowupServices(entity.getFurtherFollowupServices());
       model.setScheduledFollowupContacts(entity.getScheduledFollowupContacts());
       model.setResourcePackage(entity.getResourcePackage());
       model.setOtherAftercarePlanOrAction(entity.getOtherAftercarePlanOrAction());
       return model;
   }


}
