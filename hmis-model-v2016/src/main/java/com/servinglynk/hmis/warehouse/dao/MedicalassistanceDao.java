package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

public interface MedicalassistanceDao extends ParentDao {


	   com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance createMedicalassistance(com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance medicalassistance);
	   com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance updateMedicalassistance(com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance medicalassistance);
	   void deleteMedicalassistance(com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance medicalassistance);
	   com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance getMedicalassistanceById(UUID medicalassistanceId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance> getAllEnrollmentMedicalassistances(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentMedicalassistancesCount(UUID enrollmentId);
}
