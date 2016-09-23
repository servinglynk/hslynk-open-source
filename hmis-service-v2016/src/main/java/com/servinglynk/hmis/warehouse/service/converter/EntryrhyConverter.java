package com.servinglynk.hmis.warehouse.service.converter;

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

   public static com.servinglynk.hmis.warehouse.model.v2016.Entryrhy modelToEntity (Entryrhy model ,com.servinglynk.hmis.warehouse.model.v2016.Entryrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2016.Entryrhy();
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
       if(model.getHouseHoldDynamics()!=null)
       entity.setHouseHoldDynamics(EntryRHYHouseholdDynamicsEnum.lookupEnum(model.getHouseHoldDynamics()+""));
       if(model.getSexualOrientatiionGenderIdentityYouth()!=null)
       entity.setSexualOrientatiionGenderIdentityYouth(EntryRHYSexualOrientationGenderIdentityYouthEnum.lookupEnum(model.getSexualOrientatiionGenderIdentityYouth()+""));
       if(model.getSexualOrientatiionGenderIdentityFamilyMbr()!=null)
       entity.setSexualOrientatiionGenderIdentityFamilyMbr(EntryRHYSexualOrientationGenderIDFamEnum.lookupEnum(model.getSexualOrientatiionGenderIdentityFamilyMbr()+""));
       if(model.getHousingIssuesYouth()!=null)
       entity.setHousingIssuesYouth(EntryRHYHousingIssuesYouthEnum.lookupEnum(model.getHousingIssuesYouth()+""));
       if(model.getHousingIssuesFamilyMbr()!=null)
       entity.setHousingIssuesFamilyMbr(EntryRHYHousingIssuesFamEnum.lookupEnum(model.getHousingIssuesFamilyMbr()+""));
       if(model.getSchoolEducationIssuesYouth()!=null)
       entity.setSchoolEducationIssuesYouth(EntryRHYSchoolEducationalIssuesYouthEnum.lookupEnum(model.getSchoolEducationIssuesYouth()+""));
       if(model.getSchoolEducationIssuesFamilyMbr()!=null)
       entity.setSchoolEducationIssuesFamilyMbr(EntryRHYSchoolEducationalIssuesFamEnum.lookupEnum(model.getSchoolEducationIssuesFamilyMbr()+""));
       if(model.getUnemployementYouth()!=null)
       entity.setUnemployementYouth(EntryRHYUnemploymentYouthEnum.lookupEnum(model.getUnemployementYouth()+""));
       if(model.getUnemployementFamilyMbr()!=null)
       entity.setUnemployementFamilyMbr(EntryRHYUnemploymentFamEnum.lookupEnum(model.getUnemployementFamilyMbr()+""));
       if(model.getMentalHealthIssuesYouth()!=null)
       entity.setMentalHealthIssuesYouth(EntryRHYMentalHealthIssuesYouthEnum.lookupEnum(model.getMentalHealthIssuesYouth()+""));
       if(model.getMentalHealthIssuesFamilyMbr()!=null)
       entity.setMentalHealthIssuesFamilyMbr(EntryRHYMentalHealthIssuesFamEnum.lookupEnum(model.getMentalHealthIssuesFamilyMbr()+""));
       if(model.getHealthIssuesYouth()!=null)
       entity.setHealthIssuesYouth(EntryRHYHealthIssuesYouthEnum.lookupEnum(model.getHealthIssuesYouth()+""));
       if(model.getHealthIssuesFamilyMbr()!=null)
       entity.setHealthIssuesFamilyMbr(EntryRHYHealthIssuesFamEnum.lookupEnum(model.getHealthIssuesFamilyMbr()+""));
       if(model.getPhysicalDisabilityYouth()!=null)
       entity.setPhysicalDisabilityYouth(EntryRHYPhysicalDisabilityYouthEnum.lookupEnum(model.getPhysicalDisabilityYouth()+""));
       if(model.getPhysicalDisabilityFamilyMbr()!=null)
       entity.setPhysicalDisabilityFamilyMbr(EntryRHYPhysicalDisabilityFamEnum.lookupEnum(model.getPhysicalDisabilityFamilyMbr()+""));
       if(model.getMentalDisabilityYouth()!=null)
       entity.setMentalDisabilityYouth(EntryRHYMentalDisabilityYouthEnum.lookupEnum(model.getMentalDisabilityYouth()+""));
       if(model.getMentalDisabilityFamilyMbr()!=null)
       entity.setMentalDisabilityFamilyMbr(EntryRHYMentalDisabilityFamEnum.lookupEnum(model.getMentalDisabilityFamilyMbr()+""));
       if(model.getAbuseAndNeglectYouth()!=null)
       entity.setAbuseAndNeglectYouth(EntryRHYAbuseAndNeglectYouthEnum.lookupEnum(model.getAbuseAndNeglectYouth()+""));
       if(model.getAbuseAndNeglectFamilyMbr()!=null)
       entity.setAbuseAndNeglectFamilyMbr(EntryRHYAbuseAndNeglectFamEnum.lookupEnum(model.getAbuseAndNeglectFamilyMbr()+""));
       if(model.getAlcoholDrugAbuseYouth()!=null)
       entity.setAlcoholDrugAbuseYouth(EntryRHYAlcoholDrugAbuseYouthEnum.lookupEnum(model.getAlcoholDrugAbuseYouth()+""));
       if(model.getAlcoholDrugAbuseFamilyMbr()!=null)
       entity.setAlcoholDrugAbuseFamilyMbr(EntryRHYAlcoholDrugAbuseFamEnum.lookupEnum(model.getAlcoholDrugAbuseFamilyMbr()+""));
       if(model.getInsufficientIncomeToSupportYouth()!=null)
       entity.setInsufficientIncomeToSupportYouth(EntryRHYInsufficientIncomeEnum.lookupEnum(model.getInsufficientIncomeToSupportYouth()+""));
       if(model.getActiveMilitaryParent()!=null)
       entity.setActiveMilitaryParent(EntryRHYActiveMilitaryParentEnum.lookupEnum(model.getActiveMilitaryParent()+""));
       if(model.getIncarceratedParent()!=null)
       entity.setIncarceratedParent(EntryRHYIncarceratedParentEnum.lookupEnum(model.getIncarceratedParent()+""));
       if(model.getIncarceratedParentStatus()!=null)
       entity.setIncarceratedParentStatus(EntryRHYIncarceratedParentStatusEnum.lookupEnum(model.getIncarceratedParentStatus()+""));
       if(model.getReferralSource()!=null)
       entity.setReferralSource(model.getReferralSource());
       if(model.getCountOutReachReferralApproaches()!=null)
       entity.setCountOutReachReferralApproaches(model.getCountOutReachReferralApproaches());
       if(model.getExchangeForSex()!=null)
       entity.setExchangeForSex(EntryRHYExchangeForSexEnum.lookupEnum(model.getExchangeForSex()+""));
       if(model.getExchangeForSexPastThreeMonths()!=null)
       entity.setExchangeForSexPastThreeMonths(EntryRHYExchangeForSexPastThreeMonthsEnum.lookupEnum(model.getExchangeForSexPastThreeMonths()+""));
       if(model.getCountOfExchangeForSex()!=null)
       entity.setCountOfExchangeForSex(EntryRHYcountOfExchangeForSexpEnum.lookupEnum(model.getCountOfExchangeForSex()+""));
       if(model.getAskedOfForcedToExchangeForSex()!=null)
       entity.setAskedOfForcedToExchangeForSex(EntryRHYAskedOrForcedToExchangeForSexEnum.lookupEnum(model.getAskedOfForcedToExchangeForSex()+""));
       if(model.getAskedOfForcedToExchangeForSexPastThreeMonths()!=null)
       entity.setAskedOfForcedToExchangeForSexPastThreeMonths(EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum.lookupEnum(model.getAskedOfForcedToExchangeForSexPastThreeMonths()+""));
       if(model.getWorkPlaceViolenceThreat()!=null)
       entity.setWorkPlaceViolenceThreat(EntryRHYWorkPlaceViolenceThreatsEnum.lookupEnum(model.getWorkPlaceViolenceThreat()+""));
       if(model.getWorkPlacePromiseDifference()!=null)
       entity.setWorkPlacePromiseDifference(EntryRHYWorkplacePromiseDifferenceEnum.lookupEnum(model.getWorkPlacePromiseDifference()+""));
       if(model.getCoercedToContinueWork()!=null)
       entity.setCoercedToContinueWork(EntryRHYCoercedToContinueWorkEnum.lookupEnum(model.getCoercedToContinueWork()+""));
       if(model.getLaborExploitPastThreeMonths()!=null)
       entity.setLaborExploitPastThreeMonths(model.getLaborExploitPastThreeMonths());
       if(model.getDataCollectionStage() !=null)
    	  entity.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(model.getDataCollectionStage().toString()));

       if(model.getInformationDate()!=null)
    	  entity.setInformationDate(model.getInformationDate());
       return entity;
   }


   public static Entryrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2016.Entryrhy entity) {
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
       if(entity.getHouseHoldDynamics()!=null)
       model.setHouseHoldDynamics(Integer.parseInt(entity.getHouseHoldDynamics().getValue()));
       if(entity.getSexualOrientatiionGenderIdentityYouth()!=null)
       model.setSexualOrientatiionGenderIdentityYouth(Integer.parseInt(entity.getSexualOrientatiionGenderIdentityYouth().getValue()));
       if(entity.getSexualOrientatiionGenderIdentityFamilyMbr()!=null)
       model.setSexualOrientatiionGenderIdentityFamilyMbr(Integer.parseInt(entity.getSexualOrientatiionGenderIdentityFamilyMbr().getValue()));
       if(entity.getSexualOrientatiionGenderIdentityFamilyMbr()!=null)
       model.setHousingIssuesYouth(Integer.parseInt(entity.getHousingIssuesYouth().getValue()));
       if(entity.getHousingIssuesFamilyMbr()!=null)
       model.setHousingIssuesFamilyMbr(Integer.parseInt(entity.getHousingIssuesFamilyMbr().getValue()));
       if(entity.getSchoolEducationIssuesYouth()!=null)
       model.setSchoolEducationIssuesYouth(Integer.parseInt(entity.getSchoolEducationIssuesYouth().getValue()));
       if(entity.getSchoolEducationIssuesFamilyMbr()!=null)
       model.setSchoolEducationIssuesFamilyMbr(Integer.parseInt(entity.getSchoolEducationIssuesFamilyMbr().getValue()));
       if(entity.getSchoolEducationIssuesFamilyMbr()!=null)
       model.setUnemployementYouth(Integer.parseInt(entity.getUnemployementYouth().getValue()));
       if(entity.getUnemployementFamilyMbr()!=null)
       model.setUnemployementFamilyMbr(Integer.parseInt(entity.getUnemployementFamilyMbr().getValue()));
       if(entity.getMentalHealthIssuesYouth()!=null)
       model.setMentalHealthIssuesYouth(Integer.parseInt(entity.getMentalHealthIssuesYouth().getValue()));
       if(entity.getMentalHealthIssuesFamilyMbr()!=null)
       model.setMentalHealthIssuesFamilyMbr(Integer.parseInt(entity.getMentalHealthIssuesFamilyMbr().getValue()));
       if(entity.getHealthIssuesYouth()!=null)
       model.setHealthIssuesYouth(Integer.parseInt(entity.getHealthIssuesYouth().getValue()));
       if(entity.getHealthIssuesFamilyMbr()!=null)
       model.setHealthIssuesFamilyMbr(Integer.parseInt(entity.getHealthIssuesFamilyMbr().getValue()));
       if(entity.getPhysicalDisabilityYouth()!=null)
       model.setPhysicalDisabilityYouth(Integer.parseInt(entity.getPhysicalDisabilityYouth().getValue()));
       if(entity.getPhysicalDisabilityYouth()!=null)
       model.setPhysicalDisabilityFamilyMbr(Integer.parseInt(entity.getPhysicalDisabilityFamilyMbr().getValue()));
       if(entity.getMentalDisabilityYouth()!=null)
       model.setMentalDisabilityYouth(Integer.parseInt(entity.getMentalDisabilityYouth().getValue()));
       if(entity.getMentalDisabilityFamilyMbr()!=null)
       model.setMentalDisabilityFamilyMbr(Integer.parseInt(entity.getMentalDisabilityFamilyMbr().getValue()));
       if(entity.getAbuseAndNeglectYouth()!=null)
       model.setAbuseAndNeglectYouth(Integer.parseInt(entity.getAbuseAndNeglectYouth().getValue()));
       if(entity.getAbuseAndNeglectFamilyMbr()!=null)
       model.setAbuseAndNeglectFamilyMbr(Integer.parseInt(entity.getAbuseAndNeglectFamilyMbr().getValue()));
       if(entity.getAlcoholDrugAbuseYouth()!=null)
       model.setAlcoholDrugAbuseYouth(Integer.parseInt(entity.getAlcoholDrugAbuseYouth().getValue()));
       if(entity.getAlcoholDrugAbuseFamilyMbr()!=null)
       model.setAlcoholDrugAbuseFamilyMbr(Integer.parseInt(entity.getAlcoholDrugAbuseFamilyMbr().getValue()));
       if(entity.getInsufficientIncomeToSupportYouth()!=null)
       model.setInsufficientIncomeToSupportYouth(Integer.parseInt(entity.getInsufficientIncomeToSupportYouth().getValue()));
       if(entity.getActiveMilitaryParent()!=null)
       model.setActiveMilitaryParent(Integer.parseInt(entity.getActiveMilitaryParent().getValue()));
       if(entity.getIncarceratedParent()!=null)
       model.setIncarceratedParent(Integer.parseInt(entity.getIncarceratedParent().getValue()));
       if(entity.getIncarceratedParentStatus()!=null)
       model.setIncarceratedParentStatus(Integer.parseInt(entity.getIncarceratedParentStatus().getValue()));
       if(entity.getReferralSource()!=null)
       model.setReferralSource(entity.getReferralSource());
       if(entity.getCountOutReachReferralApproaches()!=null)
       model.setCountOutReachReferralApproaches(entity.getCountOutReachReferralApproaches());
       if(entity.getExchangeForSex()!=null)
       model.setExchangeForSex(Integer.parseInt(entity.getExchangeForSex().getValue()));
       if(entity.getExchangeForSexPastThreeMonths()!=null)
       model.setExchangeForSexPastThreeMonths(Integer.parseInt(entity.getExchangeForSexPastThreeMonths().getValue()));
       if(entity.getCountOfExchangeForSex()!=null)
       model.setCountOfExchangeForSex(Integer.parseInt(entity.getCountOfExchangeForSex().getValue()));
       if(entity.getAskedOfForcedToExchangeForSex()!=null)
       model.setAskedOfForcedToExchangeForSex(Integer.parseInt(entity.getAskedOfForcedToExchangeForSex().getValue()));
       if(entity.getAskedOfForcedToExchangeForSex()!=null)
       model.setAskedOfForcedToExchangeForSexPastThreeMonths(Integer.parseInt(entity.getAskedOfForcedToExchangeForSexPastThreeMonths().getValue()));
       if(entity.getWorkPlaceViolenceThreat()!=null)
       model.setWorkPlaceViolenceThreat(Integer.parseInt(entity.getWorkPlaceViolenceThreat().getValue()));
       if(entity.getWorkPlacePromiseDifference()!=null)
       model.setWorkPlacePromiseDifference(Integer.parseInt(entity.getWorkPlacePromiseDifference().getValue()));
       if(entity.getCoercedToContinueWork()!=null)
       model.setCoercedToContinueWork(Integer.parseInt(entity.getCoercedToContinueWork().getValue()));
       if(entity.getLaborExploitPastThreeMonths()!=null)
       model.setLaborExploitPastThreeMonths(entity.getLaborExploitPastThreeMonths());
       return model;
   }


}
