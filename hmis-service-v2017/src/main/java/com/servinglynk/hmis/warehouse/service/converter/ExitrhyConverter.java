package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYCoercedToContinueWorkEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkPlaceViolenceThreatsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkplacePromiseDifferenceEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYcountOfExchangeForSexpEnum;
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
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
public class ExitrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Exitrhy modelToEntity (Exitrhy model ,com.servinglynk.hmis.warehouse.model.v2017.Exitrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Exitrhy();
       entity.setId(model.getExitrhyId());
       if(model.getProjectCompletionStatus()!=null)
       entity.setProjectCompletionStatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(model.getProjectCompletionStatus()+""));
       if(model.getEarlyExitReason()!=null)
    	   entity.setEarlyExitReason(ExitRHYEarlyExitReasonEnum.lookupEnum(model.getEarlyExitReason()+""));
       if(model.getExchangeForSex()!=null)
           entity.setExchangeForSex(NoYesEnum.lookupEnum(model.getExchangeForSex()+""));
           if(model.getExchangeForSexPastThreeMonths()!=null)
           entity.setExchangeForSexPastThreeMonths(NoYesEnum.lookupEnum(model.getExchangeForSexPastThreeMonths()+""));
           if(model.getCountOfExchangeForSex()!=null)
           entity.setCountOfExchangeForSex(EntryRHYcountOfExchangeForSexpEnum.lookupEnum(model.getCountOfExchangeForSex()+""));
           if(model.getWorkPlacePromiseDifference()!=null)
           entity.setWorkPlacePromiseDifference(NoYesEnum.lookupEnum(model.getWorkPlacePromiseDifference()+""));
           if(model.getCoercedToContinueWork()!=null)
           entity.setCoercedToContinueWork(NoYesEnum.lookupEnum(model.getCoercedToContinueWork()+""));
           if(model.getLaborExploitPastThreeMonths()!=null)
           entity.setLaborExploitPastThreeMonths(NoYesEnum.lookupEnum(model.getLaborExploitPastThreeMonths()+""));
       return entity;
   }


   public static Exitrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Exitrhy entity) {
       Exitrhy model = new Exitrhy();
       model.setExitrhyId(entity.getId());
       if(entity.getProjectCompletionStatus()!=null)
       model.setProjectCompletionStatus(Integer.parseInt(entity.getProjectCompletionStatus().getValue()));
       if(entity.getEarlyExitReason()!=null)
       model.setEarlyExitReason(Integer.parseInt(entity.getEarlyExitReason().getValue()));
       return model;
   }


}
