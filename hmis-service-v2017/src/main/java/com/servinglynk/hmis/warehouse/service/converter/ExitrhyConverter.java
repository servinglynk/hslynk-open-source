package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Exitrhy;
import com.servinglynk.hmis.warehouse.enums.EntryRHYcountOfExchangeForSexpEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYEarlyExitReasonEnum;
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
public class ExitrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Exitrhy modelToEntity (Exitrhy model ,com.servinglynk.hmis.warehouse.model.v2017.Exitrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Exitrhy();
       entity.setId(model.getExitrhyId());
       if(model.getEarlyExitReason()!=null)
    	   entity.setEarlyExitReason(ExitRHYEarlyExitReasonEnum.lookupEnum(model.getEarlyExitReason()+""));
       if(model.getProjectCompletionStatus()!=null)
       entity.setProjectCompletionStatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(model.getProjectCompletionStatus()+""));
       if(model.getExchangeForSex()!=null)
           entity.setExchangeForSex(NoYesEnum.lookupEnum(model.getExchangeForSex()+""));
       if(model.getExchangeForSexPastThreeMonths()!=null)
           entity.setExchangeForSexPastThreeMonths(NoYesEnum.lookupEnum(model.getExchangeForSexPastThreeMonths()+""));
       if(model.getCountOfExchangeForSex()!=null)
           entity.setCountOfExchangeForSex(EntryRHYcountOfExchangeForSexpEnum.lookupEnum(model.getCountOfExchangeForSex()+""));
       if(model.getAskedOrForcedToExchangeForSex() !=null) 
    	   entity.setAskedOrForcedToExchangeForSex(NoYesEnum.lookupEnum(model.getAskedOrForcedToExchangeForSex()+""));
       if(model.getAskedOrForcedToExchangeForSexPastThreeMonths() !=null)
    	   entity.setAskedOrForcedToExchangeForSexPastThreeMonths(NoYesEnum.lookupEnum(model.getAskedOrForcedToExchangeForSexPastThreeMonths()+""));
       if(model.getWorkPlaceViolenceThreats() !=null)
    	   entity.setWorkPlaceViolenceThreats(NoYesEnum.lookupEnum(model.getWorkPlaceViolenceThreats()+""));
       if(model.getWorkPlacePromiseDifference()!=null)
           entity.setWorkPlacePromiseDifference(NoYesEnum.lookupEnum(model.getWorkPlacePromiseDifference()+""));
       if(model.getCoercedToContinueWork()!=null)
           entity.setCoercedToContinueWork(NoYesEnum.lookupEnum(model.getCoercedToContinueWork()+""));
       if(model.getLaborExploitPastThreeMonths()!=null)
           entity.setLaborExploitPastThreeMonths(NoYesEnum.lookupEnum(model.getLaborExploitPastThreeMonths()+""));
       if(model.getCounselingReceived() !=null)
    	   entity.setCounselingReceived(NoYesEnum.lookupEnum(model.getCounselingReceived()+""));
       if(model.getIndividualCounseling() !=null)
    	   entity.setIndividualCounseling(NoYesEnum.lookupEnum(model.getIndividualCounseling()+""));
       if(model.getFamilyCounseling() !=null)
    	   entity.setFamilyCounseling(NoYesEnum.lookupEnum(model.getFamilyCounseling()+""));
       if(model.getGroupCounseling() !=null)
    	   entity.setGroupCounseling(NoYesEnum.lookupEnum(model.getGroupCounseling()+""));
       if(model.getSessionCountAtExit() !=null)
    	   entity.setSessionCountAtExit(model.getSessionCountAtExit());
       if(model.getSessionsInPlan() !=null)
    	   entity.setSessionsInPlan(model.getSessionsInPlan());
       if(model.getPostExitCounselingPlan() !=null)
    	   entity.setPostExitCounselingPlan(NoYesEnum.lookupEnum(model.getPostExitCounselingPlan()+""));
       if(model.getDestinationSafeClient() !=null)
    	   entity.setDestinationSafeClient(NoYesEnum.lookupEnum(model.getDestinationSafeClient()+""));
       if(model.getDestinationSafeWorker() !=null)
    	   entity.setDestinationSafeWorker(NoYesEnum.lookupEnum(model.getDestinationSafeWorker()+""));
       if(model.getPosAdultConnections() !=null)
    	   entity.setPosAdultConnections(NoYesEnum.lookupEnum(model.getPosAdultConnections()+""));
       if(model.getPosCommunityConnections() !=null)
    	   entity.setPosCommunityConnections(NoYesEnum.lookupEnum(model.getPosCommunityConnections()+""));
       if(model.getPosPeerConnections() !=null)
    	   entity.setPosPeerConnections(NoYesEnum.lookupEnum(model.getPosPeerConnections()+""));
       
		if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Exitrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Exitrhy entity) {
       Exitrhy model = new Exitrhy();
       model.setExitrhyId(entity.getId());
       if(entity.getProjectCompletionStatus()!=null)
       model.setProjectCompletionStatus(Integer.parseInt(entity.getProjectCompletionStatus().getValue()));
       if(entity.getEarlyExitReason()!=null)
       model.setEarlyExitReason(Integer.parseInt(entity.getEarlyExitReason().getValue()));
       if(entity.getExchangeForSex() !=null)
    	   model.setExchangeForSex(Integer.parseInt(entity.getExchangeForSex().getValue()));
       if(entity.getExchangeForSexPastThreeMonths() != null)
    	   model.setExchangeForSexPastThreeMonths(Integer.parseInt(entity.getExchangeForSexPastThreeMonths().getValue()));
       if(entity.getCountOfExchangeForSex() !=null)
    	   model.setCountOfExchangeForSex(Integer.parseInt(entity.getCountOfExchangeForSex().getValue()));
       if(entity.getAskedOrForcedToExchangeForSex() !=null)
    	   model.setAskedOrForcedToExchangeForSex(Integer.parseInt(entity.getAskedOrForcedToExchangeForSex().getValue()));
       if(entity.getAskedOrForcedToExchangeForSexPastThreeMonths() !=null)
    	   model.setAskedOrForcedToExchangeForSexPastThreeMonths(Integer.parseInt(entity.getAskedOrForcedToExchangeForSexPastThreeMonths().getValue()));
       if(entity.getWorkPlacePromiseDifference() !=null)
    	   model.setWorkPlacePromiseDifference(Integer.parseInt(entity.getWorkPlacePromiseDifference().getValue()));
       if(entity.getWorkPlaceViolenceThreats() !=null)
    	   model.setWorkPlaceViolenceThreats(Integer.parseInt(entity.getWorkPlaceViolenceThreats().getValue()));
       if(entity.getCoercedToContinueWork() !=null)
    	   model.setCoercedToContinueWork(Integer.parseInt(entity.getCoercedToContinueWork().getValue()));
       if(entity.getLaborExploitPastThreeMonths() !=null)
    	   model.setLaborExploitPastThreeMonths(Integer.parseInt(entity.getLaborExploitPastThreeMonths().getValue()));
       if(entity.getCounselingReceived() !=null)
    	   model.setCounselingReceived(Integer.parseInt(entity.getCounselingReceived().getValue()));
       if(entity.getIndividualCounseling() !=null)
    	   model.setIndividualCounseling(Integer.parseInt(entity.getIndividualCounseling().getValue()));
       if(entity.getFamilyCounseling() !=null)
    	   model.setFamilyCounseling(Integer.parseInt(entity.getFamilyCounseling().getValue()));
       if(entity.getGroupCounseling() !=null)
    	   model.setGroupCounseling(Integer.parseInt(entity.getGroupCounseling().getValue()));
       if(entity.getSessionCountAtExit() !=null)
    	   model.setSessionCountAtExit(entity.getSessionCountAtExit());
       if(entity.getSessionsInPlan() !=null)
    	   model.setSessionsInPlan(entity.getSessionsInPlan());
       if(entity.getPostExitCounselingPlan() !=null)
    	   model.setPostExitCounselingPlan(Integer.parseInt(entity.getPostExitCounselingPlan().getValue()));
       if(entity.getDestinationSafeClient() !=null)
    	   model.setDestinationSafeClient(Integer.parseInt(entity.getDestinationSafeClient().getValue()));
       if(entity.getDestinationSafeWorker() !=null)
    	   model.setDestinationSafeWorker(Integer.parseInt(entity.getDestinationSafeWorker().getValue()));
       if(entity.getPosAdultConnections() !=null)
    	   model.setPosAdultConnections(Integer.parseInt(entity.getPosAdultConnections().getValue()));
       if(entity.getPosPeerConnections() !=null)
    	   model.setPosPeerConnections(Integer.parseInt(entity.getPosPeerConnections().getValue()));
       if(entity.getPosCommunityConnections() !=null)
    	   model.setPosCommunityConnections(Integer.parseInt(entity.getPosCommunityConnections().getValue()));
       if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
       
       if(entity.getParentId() ==null && entity.getExitid()!=null && entity.getExitid().getEnrollmentid()!=null && entity.getExitid().getEnrollmentid().getClient()!=null) {
    	   model.addLink(new ActionLink("history","/clients/"+entity.getExitid().getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getExitid().getEnrollmentid().getId()+"/exits/"+entity.getExitid().getId()+"/exitrhys/"+entity.getId()+"/history"));
       }
       return model;
   }
}
