package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefits;
public interface NonCashBenefitService {

   NonCashBenefit createNonCashBenefit(NonCashBenefit nonCashBenefit,UUID enrollmentId,String caller);
   NonCashBenefit updateNonCashBenefit(NonCashBenefit nonCashBenefit,UUID enrollmentId,String caller);
   NonCashBenefit deleteNonCashBenefit(UUID nonCashBenefitId,String caller);
   NonCashBenefit getNonCashBenefitById(UUID nonCashBenefitId);
   NonCashBenefits getAllEnrollmentNonCashBenefits(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
