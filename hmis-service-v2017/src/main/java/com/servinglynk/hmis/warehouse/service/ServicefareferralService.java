package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Servicefareferral;
import com.servinglynk.hmis.warehouse.core.model.Servicefareferrals;
public interface ServicefareferralService {

   Servicefareferral createServicefareferral(Servicefareferral servicefareferral,UUID enrollmentId,String caller);
   Servicefareferral updateServicefareferral(Servicefareferral servicefareferral,UUID enrollmentId,String caller);
   Servicefareferral deleteServicefareferral(UUID servicefareferralId,String caller);
   Servicefareferral getServicefareferralById(UUID servicefareferralId);
   Servicefareferrals getAllEnrollmentServicefareferrals(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
