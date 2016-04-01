package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Exithousingassessment;
import com.servinglynk.hmis.warehouse.core.model.Exithousingassessments;
public interface ExithousingassessmentService {

   Exithousingassessment createExithousingassessment(Exithousingassessment exithousingassessment,UUID enrollmentId,String caller);
   Exithousingassessment updateExithousingassessment(Exithousingassessment exithousingassessment,UUID enrollmentId,String caller);
   Exithousingassessment deleteExithousingassessment(UUID exithousingassessmentId,String caller);
   Exithousingassessment getExithousingassessmentById(UUID exithousingassessmentId);
   Exithousingassessments getAllEnrollmentExithousingassessments(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
