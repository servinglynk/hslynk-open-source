package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;
import java.util.List;

import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
public interface MedicalassistanceService {

   Medicalassistance createMedicalassistance(Medicalassistance medicalassistance,UUID enrollmentId,String caller);
   Medicalassistance updateMedicalassistance(Medicalassistance medicalassistance,UUID enrollmentId,String caller);
   Medicalassistance deleteMedicalassistance(UUID medicalassistanceId,String caller);
   Medicalassistance getMedicalassistanceById(UUID medicalassistanceId);
   Medicalassistances getAllEnrollmentMedicalassistances(UUID enrollmentId,Integer startIndex, Integer maxItems);
}
