package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.service.MedicalassistanceService;
import com.servinglynk.hmis.warehouse.service.converter.MedicalassistanceConverter;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistances;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.MedicalassistanceNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class MedicalassistanceServiceImpl extends ServiceBase implements MedicalassistanceService  {

   @Transactional
   public Medicalassistance createMedicalassistance(Medicalassistance medicalassistance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance pMedicalassistance = MedicalassistanceConverter.modelToEntity(medicalassistance, null);
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pMedicalassistance.setEnrollmentid(pEnrollment);
       pMedicalassistance.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pMedicalassistance, caller);
       daoFactory.getMedicalassistanceDao().createMedicalassistance(pMedicalassistance);
       medicalassistance.setMedicalassistanceId(pMedicalassistance.getId());
       return medicalassistance;
   }


   @Transactional
   public Medicalassistance updateMedicalassistance(Medicalassistance medicalassistance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance pMedicalassistance = daoFactory.getMedicalassistanceDao().getMedicalassistanceById(medicalassistance.getMedicalassistanceId());
       if(pMedicalassistance==null) throw new MedicalassistanceNotFoundException();

       MedicalassistanceConverter.modelToEntity(medicalassistance, pMedicalassistance);
       pMedicalassistance.setEnrollmentid(pEnrollment);
       pMedicalassistance.setDateUpdated(LocalDateTime.now());
       pMedicalassistance.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getMedicalassistanceDao().updateMedicalassistance(pMedicalassistance);
       medicalassistance.setMedicalassistanceId(pMedicalassistance.getId());
       return medicalassistance;
   }


   @Transactional
   public Medicalassistance deleteMedicalassistance(UUID medicalassistanceId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance pMedicalassistance = daoFactory.getMedicalassistanceDao().getMedicalassistanceById(medicalassistanceId);
       if(pMedicalassistance==null) throw new MedicalassistanceNotFoundException();

       daoFactory.getMedicalassistanceDao().deleteMedicalassistance(pMedicalassistance);
       return new Medicalassistance();
   }


   @Transactional
   public Medicalassistance getMedicalassistanceById(UUID medicalassistanceId){
       com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance pMedicalassistance = daoFactory.getMedicalassistanceDao().getMedicalassistanceById(medicalassistanceId);
       if(pMedicalassistance==null) throw new MedicalassistanceNotFoundException();

       return MedicalassistanceConverter.entityToModel( pMedicalassistance );
   }


   @Transactional
   public Medicalassistances getAllEnrollmentMedicalassistances(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Medicalassistances medicalassistances = new Medicalassistances();
        List<com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance> entities = daoFactory.getMedicalassistanceDao().getAllEnrollmentMedicalassistances(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2016.Medicalassistance entity : entities){
           medicalassistances.addMedicalassistance(MedicalassistanceConverter.entityToModel(entity));
        }
        long count = daoFactory.getMedicalassistanceDao().getEnrollmentMedicalassistancesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(medicalassistances.getMedicalassistances().size());
        pagination.setTotal((int)count);
        medicalassistances.setPagination(pagination);
        return medicalassistances;
   }


}
