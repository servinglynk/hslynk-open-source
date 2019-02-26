package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientations;
public interface SexualorientationService {

   Sexualorientation createSexualorientation(Sexualorientation sexualorientation,UUID enrollmentId,String caller);
   Sexualorientation updateSexualorientation(Sexualorientation sexualorientation,UUID enrollmentId,String caller);
   Sexualorientation deleteSexualorientation(UUID sexualorientationId,String caller);
   Sexualorientation getSexualorientationById(UUID sexualorientationId);
   Sexualorientations getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
