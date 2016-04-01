package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
public class EntryrhyConverter  extends BaseConverter {

   public static com.servinglynk.hmis.warehouse.model.v2015.Entryrhy modelToEntity (Entryrhy model ,com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entity) {
       if(entity==null) entity = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhy();
       entity.setId(model.getEntryrhyId());
       entity.setSexualOrientation(model.getSexualOrientation());
       entity.setFormerlyWardChildWelfrForestCare(model.getFormerlyWardChildWelfrForestCare());
       entity.setYearsChildWelfrForestCare(model.getYearsChildWelfrForestCare());
       entity.setMonthsChildWelfrForestCare(model.getMonthsChildWelfrForestCare());
       entity.setFormerlyWardOfJuvenileJustice(model.getFormerlyWardOfJuvenileJustice());
       entity.setYearsJuvenileJustice(model.getYearsJuvenileJustice());
       entity.setHouseHoldDynamics(model.getHouseHoldDynamics());
       entity.setSexualOrientatiionGenderIdentityYouth(model.getSexualOrientatiionGenderIdentityYouth());
       entity.setSexualOrientatiionGenderIdentityFamilyMbr(model.getSexualOrientatiionGenderIdentityFamilyMbr());
       entity.setHousingIssuesYouth(model.getHousingIssuesYouth());
       entity.setHousingIssuesFamilyMbr(model.getHousingIssuesFamilyMbr());
       entity.setSchoolEducationIssuesYouth(model.getSchoolEducationIssuesYouth());
       entity.setSchoolEducationIssuesFamilyMbr(model.getSchoolEducationIssuesFamilyMbr());
       entity.setUnemployementYouth(model.getUnemployementYouth());
       entity.setUnemployementFamilyMbr(model.getUnemployementFamilyMbr());
       entity.setMentalHealthIssuesYouth(model.getMentalHealthIssuesYouth());
       entity.setMentalHealthIssuesFamilyMbr(model.getMentalHealthIssuesFamilyMbr());
       entity.setHealthIssuesYouth(model.getHealthIssuesYouth());
       entity.setHealthIssuesFamilyMbr(model.getHealthIssuesFamilyMbr());
       entity.setPhysicalDisabilityYouth(model.getPhysicalDisabilityYouth());
       entity.setPhysicalDisabilityFamilyMbr(model.getPhysicalDisabilityFamilyMbr());
       entity.setMentalDisabilityYouth(model.getMentalDisabilityYouth());
       entity.setMentalDisabilityFamilyMbr(model.getMentalDisabilityFamilyMbr());
       entity.setAbuseAndNeglectYouth(model.getAbuseAndNeglectYouth());
       entity.setAbuseAndNeglectFamilyMbr(model.getAbuseAndNeglectFamilyMbr());
       entity.setAlcoholDrugAbuseYouth(model.getAlcoholDrugAbuseYouth());
       entity.setAlcoholDrugAbuseFamilyMbr(model.getAlcoholDrugAbuseFamilyMbr());
       entity.setInsufficientIncomeToSupportYouth(model.getInsufficientIncomeToSupportYouth());
       entity.setActiveMilitaryParent(model.getActiveMilitaryParent());
       entity.setIncarceratedParent(model.getIncarceratedParent());
       entity.setIncarceratedParentStatus(model.getIncarceratedParentStatus());
       entity.setReferralSource(model.getReferralSource());
       entity.setCountOutReachReferralApproaches(model.getCountOutReachReferralApproaches());
       entity.setExchangeForSex(model.getExchangeForSex());
       entity.setExchangeForSexPastThreeMonths(model.getExchangeForSexPastThreeMonths());
       entity.setCountOfExchangeForSex(model.getCountOfExchangeForSex());
       entity.setAskedOfForcedToExchangeForSex(model.getAskedOfForcedToExchangeForSex());
       entity.setAskedOfForcedToExchangeForSexPastThreeMonths(model.getAskedOfForcedToExchangeForSexPastThreeMonths());
       entity.setWorkPlaceViolenceThreat(model.getWorkPlaceViolenceThreat());
       entity.setWorkPlacePromiseDifference(model.getWorkPlacePromiseDifference());
       entity.setCoercedToContinueWork(model.getCoercedToContinueWork());
       entity.setLaborExploitPastThreeMonths(model.getLaborExploitPastThreeMonths());
       return entity;    
   }


   public static Entryrhy entityToModel (com.servinglynk.hmis.warehouse.model.v2015.Entryrhy entity) {
       Entryrhy model = new Entryrhy();
       model.setEntryrhyId(entity.getId());
       model.setSexualOrientation(entity.getSexualOrientation());
       model.setFormerlyWardChildWelfrForestCare(entity.getFormerlyWardChildWelfrForestCare());
       model.setYearsChildWelfrForestCare(entity.getYearsChildWelfrForestCare());
       model.setMonthsChildWelfrForestCare(entity.getMonthsChildWelfrForestCare());
       model.setFormerlyWardOfJuvenileJustice(entity.getFormerlyWardOfJuvenileJustice());
       model.setYearsJuvenileJustice(entity.getYearsJuvenileJustice());
       model.setHouseHoldDynamics(entity.getHouseHoldDynamics());
       model.setSexualOrientatiionGenderIdentityYouth(entity.getSexualOrientatiionGenderIdentityYouth());
       model.setSexualOrientatiionGenderIdentityFamilyMbr(entity.getSexualOrientatiionGenderIdentityFamilyMbr());
       model.setHousingIssuesYouth(entity.getHousingIssuesYouth());
       model.setHousingIssuesFamilyMbr(entity.getHousingIssuesFamilyMbr());
       model.setSchoolEducationIssuesYouth(entity.getSchoolEducationIssuesYouth());
       model.setSchoolEducationIssuesFamilyMbr(entity.getSchoolEducationIssuesFamilyMbr());
       model.setUnemployementYouth(entity.getUnemployementYouth());
       model.setUnemployementFamilyMbr(entity.getUnemployementFamilyMbr());
       model.setMentalHealthIssuesYouth(entity.getMentalHealthIssuesYouth());
       model.setMentalHealthIssuesFamilyMbr(entity.getMentalHealthIssuesFamilyMbr());
       model.setHealthIssuesYouth(entity.getHealthIssuesYouth());
       model.setHealthIssuesFamilyMbr(entity.getHealthIssuesFamilyMbr());
       model.setPhysicalDisabilityYouth(entity.getPhysicalDisabilityYouth());
       model.setPhysicalDisabilityFamilyMbr(entity.getPhysicalDisabilityFamilyMbr());
       model.setMentalDisabilityYouth(entity.getMentalDisabilityYouth());
       model.setMentalDisabilityFamilyMbr(entity.getMentalDisabilityFamilyMbr());
       model.setAbuseAndNeglectYouth(entity.getAbuseAndNeglectYouth());
       model.setAbuseAndNeglectFamilyMbr(entity.getAbuseAndNeglectFamilyMbr());
       model.setAlcoholDrugAbuseYouth(entity.getAlcoholDrugAbuseYouth());
       model.setAlcoholDrugAbuseFamilyMbr(entity.getAlcoholDrugAbuseFamilyMbr());
       model.setInsufficientIncomeToSupportYouth(entity.getInsufficientIncomeToSupportYouth());
       model.setActiveMilitaryParent(entity.getActiveMilitaryParent());
       model.setIncarceratedParent(entity.getIncarceratedParent());
       model.setIncarceratedParentStatus(entity.getIncarceratedParentStatus());
       model.setReferralSource(entity.getReferralSource());
       model.setCountOutReachReferralApproaches(entity.getCountOutReachReferralApproaches());
       model.setExchangeForSex(entity.getExchangeForSex());
       model.setExchangeForSexPastThreeMonths(entity.getExchangeForSexPastThreeMonths());
       model.setCountOfExchangeForSex(entity.getCountOfExchangeForSex());
       model.setAskedOfForcedToExchangeForSex(entity.getAskedOfForcedToExchangeForSex());
       model.setAskedOfForcedToExchangeForSexPastThreeMonths(entity.getAskedOfForcedToExchangeForSexPastThreeMonths());
       model.setWorkPlaceViolenceThreat(entity.getWorkPlaceViolenceThreat());
       model.setWorkPlacePromiseDifference(entity.getWorkPlacePromiseDifference());
       model.setCoercedToContinueWork(entity.getCoercedToContinueWork());
       model.setLaborExploitPastThreeMonths(entity.getLaborExploitPastThreeMonths());
       return model;
   }


}
