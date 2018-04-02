package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Education;
import com.servinglynk.hmis.warehouse.core.model.Educations;
public interface EducationService {

   Education createEducation(Education education,UUID enrollmentId,String caller);
   Education updateEducation(Education education,UUID enrollmentId,String caller);
   Education deleteEducation(UUID educationId,String caller);
   Education getEducationById(UUID educationId);
   Educations getAllEnrollmentEducations(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
