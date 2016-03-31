package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindates;
public interface ResidentialmoveindateService {

   Residentialmoveindate createResidentialmoveindate(Residentialmoveindate residentialmoveindate,UUID enrollmentId,String caller);
   Residentialmoveindate updateResidentialmoveindate(Residentialmoveindate residentialmoveindate,UUID enrollmentId,String caller);
   Residentialmoveindate deleteResidentialmoveindate(UUID residentialmoveindateId,String caller);
   Residentialmoveindate getResidentialmoveindateById(UUID residentialmoveindateId);
   Residentialmoveindates getAllEnrollmentResidentialmoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
