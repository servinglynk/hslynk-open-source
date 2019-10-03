package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.enums.ExitRHYAssistanceMainstreamBenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYEarlyExitReasonEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYExitCounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFamilyReunificationAchievedEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFurtherFollowUpServicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYOtherAftercarePlanOrActionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYPermanentHousingPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYResourcePackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYScheduledFollowUpContactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYTemporaryShelterPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYWrittenAfterCarePlanEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
public class ExitrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Exitrhy modelToEntity (Exitrhy model ,com.servinglynk.hmis.warehouse.model.v2015.Exitrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Exitrhy();
       entity.setId(model.getExitrhyId());
       if(model.getProjectCompletionStatus()!=null)
       entity.setProjectCompletionStatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(model.getProjectCompletionStatus()+""));
       if(model.getEarlyExitReason()!=null)
       entity.setEarlyExitReason(ExitRHYEarlyExitReasonEnum.lookupEnum(model.getEarlyExitReason()+""));
       if(model.getFamilyReunificationAchieved()!=null)
       entity.setFamilyReunificationAchieved(ExitRHYFamilyReunificationAchievedEnum.lookupEnum(model.getFamilyReunificationAchieved()+""));
       if(model.getWrittenAfterCarePlan()!=null)
       entity.setWrittenAfterCarePlan(ExitRHYWrittenAfterCarePlanEnum.lookupEnum(model.getWrittenAfterCarePlan()+""));
       if(model.getAssistanceMainStreamBenefits()!=null)
       entity.setAssistanceMainStreamBenefits(ExitRHYAssistanceMainstreamBenefitsEnum.lookupEnum(model.getAssistanceMainStreamBenefits()+""));
       if(model.getPermenantHousingPlacement()!=null)
       entity.setPermenantHousingPlacement(ExitRHYPermanentHousingPlacementEnum.lookupEnum(model.getPermenantHousingPlacement()+""));
       if(model.getTempShelterPlacement()!=null)
       entity.setTempShelterPlacement(ExitRHYTemporaryShelterPlacementEnum.lookupEnum(model.getTempShelterPlacement()+""));
       if(model.getExitCounseling()!=null)
       entity.setExitCounseling(ExitRHYExitCounselingEnum.lookupEnum(model.getExitCounseling()+""));
       if(model.getFurtherFollowupServices()!=null)
       entity.setFurtherFollowupServices(ExitRHYFurtherFollowUpServicesEnum.lookupEnum(model.getFurtherFollowupServices()+""));
       if(model.getScheduledFollowupContacts()!=null)
       entity.setScheduledFollowupContacts(ExitRHYScheduledFollowUpContactsEnum.lookupEnum(model.getScheduledFollowupContacts()+""));
       if(model.getResourcePackage()!=null)
       entity.setResourcePackage(ExitRHYResourcePackageEnum.lookupEnum(model.getResourcePackage()+""));
       if(model.getOtherAftercarePlanOrAction()!=null)
       entity.setOtherAftercarePlanOrAction(ExitRHYOtherAftercarePlanOrActionEnum.lookupEnum(model.getOtherAftercarePlanOrAction()+""));
       return entity;    
   }


   public static Exitrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Exitrhy entity) {
       Exitrhy model = new Exitrhy();
       model.setExitrhyId(entity.getId());
       if(entity.getProjectCompletionStatus()!=null)
       model.setProjectCompletionStatus(Integer.parseInt(entity.getProjectCompletionStatus().getValue()));
       if(entity.getEarlyExitReason()!=null)
       model.setEarlyExitReason(Integer.parseInt(entity.getEarlyExitReason().getValue()));
       if(entity.getFamilyReunificationAchieved()!=null)
       model.setFamilyReunificationAchieved(Integer.parseInt(entity.getFamilyReunificationAchieved().getValue()));
       if(entity.getWrittenAfterCarePlan()!=null)
       model.setWrittenAfterCarePlan(Integer.parseInt(entity.getWrittenAfterCarePlan().getValue()));
       if(entity.getAssistanceMainStreamBenefits()!=null)
       model.setAssistanceMainStreamBenefits(Integer.parseInt(entity.getAssistanceMainStreamBenefits().getValue()));
       if(entity.getPermenantHousingPlacement()!=null)
       model.setPermenantHousingPlacement(Integer.parseInt(entity.getPermenantHousingPlacement().getValue()));
       if(entity.getTempShelterPlacement()!=null)
       model.setTempShelterPlacement(Integer.parseInt(entity.getTempShelterPlacement().getValue()));
       if(entity.getExitCounseling()!=null)
       model.setExitCounseling(Integer.parseInt(entity.getExitCounseling().getValue()));
       if(entity.getFurtherFollowupServices()!=null)
       model.setFurtherFollowupServices(Integer.parseInt(entity.getFurtherFollowupServices().getValue()));
       if(entity.getScheduledFollowupContacts()!=null)
       model.setScheduledFollowupContacts(Integer.parseInt(entity.getScheduledFollowupContacts().getValue()));
       if(entity.getResourcePackage()!=null)
       model.setResourcePackage(Integer.parseInt(entity.getResourcePackage().getValue()));
       if(entity.getOtherAftercarePlanOrAction()!=null)
       model.setOtherAftercarePlanOrAction(Integer.parseInt(entity.getOtherAftercarePlanOrAction().getValue()));
       
       if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/exitrhys/"+entity.getId()+"/history"));
       }
       
       return model;
   }


}
