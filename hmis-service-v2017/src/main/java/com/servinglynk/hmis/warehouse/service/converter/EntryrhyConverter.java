package com.servinglynk.hmis.warehouse.service.converter;

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAbuseAndNeglectFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAbuseAndNeglectYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYActiveMilitaryParentEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAlcoholDrugAbuseFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAlcoholDrugAbuseYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYChildWelfareYearsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYCoercedToContinueWorkEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYFormerWardChildWelfareEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYFormerWardJuvenileJusticeEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHealthIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHealthIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHouseholdDynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHousingIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYHousingIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYIncarceratedParentEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYIncarceratedParentStatusEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYInsufficientIncomeEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYJuvenileJusticeYearsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalDisabilityFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalDisabilityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalHealthIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYMentalHealthIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYPhysicalDisabilityFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYPhysicalDisabilityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSchoolEducationalIssuesFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSchoolEducationalIssuesYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSexualOrientationGenderIDFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYSexualOrientationGenderIdentityYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYUnemploymentFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYUnemploymentYouthEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkPlaceViolenceThreatsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYWorkplacePromiseDifferenceEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYcountOfExchangeForSexpEnum;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
public class EntryrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2017.Entryrhy modelToEntity (Entryrhy model ,com.servinglynk.hmis.warehouse.model.v2017.Entryrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2017.Entryrhy();
       if(model.getEntryrhyId()!=null)
       entity.setId(model.getEntryrhyId());
       if(model.getSexualOrientation()!=null)
       entity.setSexualOrientation(SexualorientationSexualorientationEnum.lookupEnum(model.getSexualOrientation()+""));
       if(model.getFormerlyWardChildWelfrForestCare()!=null)
       entity.setFormerlyWardChildWelfrForestCare(EntryRHYFormerWardChildWelfareEnum.lookupEnum(model.getFormerlyWardChildWelfrForestCare()+""));
       if(model.getYearsChildWelfrForestCare()!=null)
       entity.setYearsChildWelfrForestCare(EntryRHYChildWelfareYearsEnum.lookupEnum(model.getYearsChildWelfrForestCare()+""));
       if(model.getMonthsChildWelfrForestCare()!=null)
       entity.setMonthsChildWelfrForestCare(model.getMonthsChildWelfrForestCare());
       if(model.getFormerlyWardOfJuvenileJustice()!=null)
       entity.setFormerlyWardOfJuvenileJustice(EntryRHYFormerWardJuvenileJusticeEnum.lookupEnum(model.getFormerlyWardOfJuvenileJustice()+""));
       if(model.getYearsJuvenileJustice()!=null)
       entity.setYearsJuvenileJustice(EntryRHYJuvenileJusticeYearsEnum.lookupEnum(model.getYearsJuvenileJustice()+""));
       if(model.getUnemployementFamilyMbr()!=null)
       entity.setUnemployementFamilyMbr(EntryRHYUnemploymentFamEnum.lookupEnum(model.getUnemployementFamilyMbr()+""));
       if(model.getMentalHealthIssuesFamilyMbr()!=null)
       entity.setMentalHealthIssuesFamilyMbr(EntryRHYMentalHealthIssuesFamEnum.lookupEnum(model.getMentalHealthIssuesFamilyMbr()+""));
       if(model.getPhysicalDisabilityFamilyMbr()!=null)
       entity.setPhysicalDisabilityFamilyMbr(EntryRHYPhysicalDisabilityFamEnum.lookupEnum(model.getPhysicalDisabilityFamilyMbr()+""));
       if(model.getAlcoholDrugAbuseFamilyMbr()!=null)
       entity.setAlcoholDrugAbuseFamilyMbr(EntryRHYAlcoholDrugAbuseFamEnum.lookupEnum(model.getAlcoholDrugAbuseFamilyMbr()+""));
       if(model.getInsufficientIncomeToSupportYouth()!=null)
       entity.setInsufficientIncomeToSupportYouth(EntryRHYInsufficientIncomeEnum.lookupEnum(model.getInsufficientIncomeToSupportYouth()+""));
       if(model.getIncarceratedParent()!=null)
       entity.setIncarceratedParent(EntryRHYIncarceratedParentEnum.lookupEnum(model.getIncarceratedParent()+""));
       if(model.getCountOutReachReferralApproaches()!=null)
       entity.setCountOutReachReferralApproaches(model.getCountOutReachReferralApproaches());
       if(model.getDataCollectionStage() !=null)
    	  entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));
       if(model.getInformationDate()!=null)
    	  entity.setInformationDate(model.getInformationDate());
		if(model.getSubmissionDate()!=null) entity.setSubmissionDate(model.getSubmissionDate());
       return entity;
   }


   public static Entryrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2017.Entryrhy entity) {
       Entryrhy model = new Entryrhy();
       if(entity.getId()!=null)
       model.setEntryrhyId(entity.getId());
       if(entity.getSexualOrientation()!=null)
       model.setSexualOrientation(Integer.parseInt(entity.getSexualOrientation().getValue()));
       if(entity.getFormerlyWardChildWelfrForestCare()!=null)
       model.setFormerlyWardChildWelfrForestCare(Integer.parseInt(entity.getFormerlyWardChildWelfrForestCare().getValue()));
       if(entity.getYearsChildWelfrForestCare()!=null)
       model.setYearsChildWelfrForestCare(Integer.parseInt(entity.getYearsChildWelfrForestCare().getValue()));
       if(entity.getMonthsChildWelfrForestCare()!=null)
       model.setMonthsChildWelfrForestCare(entity.getMonthsChildWelfrForestCare());
       if(entity.getFormerlyWardOfJuvenileJustice()!=null)
       model.setFormerlyWardOfJuvenileJustice(Integer.parseInt(entity.getFormerlyWardOfJuvenileJustice().getValue()));
       if(entity.getYearsJuvenileJustice()!=null)
       model.setYearsJuvenileJustice(Integer.parseInt(entity.getYearsJuvenileJustice().getValue()));
       if(entity.getUnemployementFamilyMbr()!=null)
    	   model.setUnemployementFamilyMbr(Integer.parseInt(entity.getUnemployementFamilyMbr().getValue()));
           if(entity.getMentalHealthIssuesFamilyMbr()!=null)
        	   model.setMentalHealthIssuesFamilyMbr(Integer.parseInt(entity.getMentalHealthIssuesFamilyMbr().getValue()));
           if(entity.getPhysicalDisabilityFamilyMbr()!=null)
        	   model.setPhysicalDisabilityFamilyMbr(Integer.parseInt(entity.getPhysicalDisabilityFamilyMbr().getValue()));
           if(entity.getAlcoholDrugAbuseFamilyMbr()!=null)
        	   model.setAlcoholDrugAbuseFamilyMbr(Integer.parseInt(entity.getAlcoholDrugAbuseFamilyMbr().getValue()));
           if(entity.getInsufficientIncomeToSupportYouth()!=null)
        	   model.setInsufficientIncomeToSupportYouth(Integer.parseInt(entity.getInsufficientIncomeToSupportYouth().getValue()));
           if(entity.getIncarceratedParent()!=null)
        	   model.setIncarceratedParent(Integer.parseInt(entity.getIncarceratedParent().getValue()));
           if(entity.getCountOutReachReferralApproaches()!=null)
        	   model.setCountOutReachReferralApproaches(entity.getCountOutReachReferralApproaches());
           if(entity.getDataCollectionStage() !=null)
        	   model.setDataCollectionStage(Integer.parseInt(entity.getDataCollectionStage().getValue()));
           if(entity.getInformationDate()!=null)
        	   model.setInformationDate(entity.getInformationDate());
           if(entity.getSubmissionDate()!=null) model.setSubmissionDate(entity.getSubmissionDate());
           
           if(entity.getParentId() ==null && entity.getEnrollmentid()!=null && entity.getEnrollmentid().getClient()!=null) {
          	   model.addLink(new ActionLink("history","/clients/"+entity.getEnrollmentid().getClient().getId()+"/enrollments/"+entity.getEnrollmentid().getId()+"/entryrhys/"+entity.getId()+"/history"));
             }      
           
       return model;
   }


}
