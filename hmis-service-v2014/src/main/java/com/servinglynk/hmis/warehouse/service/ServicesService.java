package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.core.model.ServicesList;
public interface ServicesService {

   Services createServices(Services services,UUID enrollmentId,String caller);
   Services updateServices(Services services,UUID enrollmentId,String caller);
   Services deleteServices(UUID servicesId,String caller);
   Services getServicesById(UUID servicesId);
   ServicesList getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
