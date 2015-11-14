package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
public interface EmploymentService {

   Employment createEmployment(Employment employment,UUID enrollmentId,String caller);
   Employment updateEmployment(Employment employment,UUID enrollmentId,String caller);
   Employment deleteEmployment(UUID employmentId,String caller);
   Employment getEmploymentById(UUID employmentId);
   Employments getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
