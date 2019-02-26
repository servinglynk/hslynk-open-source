package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfares;
public interface FormerWardChildWelfareService {

   FormerWardChildWelfare createFormerWardChildWelfare(FormerWardChildWelfare formerWardChildWelfare,UUID enrollmentId,String caller);
   FormerWardChildWelfare updateFormerWardChildWelfare(FormerWardChildWelfare formerWardChildWelfare,UUID enrollmentId,String caller);
   FormerWardChildWelfare deleteFormerWardChildWelfare(UUID formerWardChildWelfareId,String caller);
   FormerWardChildWelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId);
   FormerWardChildWelfares getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
