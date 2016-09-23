package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.service.HealthinsuranceService;
import com.servinglynk.hmis.warehouse.service.converter.HealthinsuranceConverter;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurances;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.HealthinsuranceNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class HealthinsuranceServiceImpl extends ServiceBase implements HealthinsuranceService  {

   @Transactional
   public Healthinsurance createHealthinsurance(Healthinsurance healthinsurance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance pHealthinsurance = HealthinsuranceConverter.modelToEntity(healthinsurance, null);
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pHealthinsurance.setEnrollmentid(pEnrollment);
       pHealthinsurance.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pHealthinsurance, caller);
       daoFactory.getHealthinsuranceDao().createHealthInsurance(pHealthinsurance);
       healthinsurance.setHealthinsuranceId(pHealthinsurance.getId());
       return healthinsurance;
   }


   @Transactional
   public Healthinsurance updateHealthinsurance(Healthinsurance healthinsurance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance pHealthinsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthinsurance.getHealthinsuranceId());
       if(pHealthinsurance==null) throw new HealthinsuranceNotFoundException();

       HealthinsuranceConverter.modelToEntity(healthinsurance, pHealthinsurance);
       pHealthinsurance.setEnrollmentid(pEnrollment);
       pHealthinsurance.setDateUpdated(LocalDateTime.now());
       pHealthinsurance.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getHealthinsuranceDao().updateHealthInsurance(pHealthinsurance);
       healthinsurance.setHealthinsuranceId(pHealthinsurance.getId());
       return healthinsurance;
   }


   @Transactional
   public Healthinsurance deleteHealthinsurance(UUID healthinsuranceId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance pHealthinsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthinsuranceId);
       if(pHealthinsurance==null) throw new HealthinsuranceNotFoundException();

       daoFactory.getHealthinsuranceDao().deleteHealthInsurance(pHealthinsurance);
       return new Healthinsurance();
   }


   @Transactional
   public Healthinsurance getHealthinsuranceById(UUID healthinsuranceId){
       com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance pHealthinsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthinsuranceId);
       if(pHealthinsurance==null) throw new HealthinsuranceNotFoundException();

       return HealthinsuranceConverter.entityToModel( pHealthinsurance );
   }


   @Transactional
   public Healthinsurances getAllEnrollmentHealthinsurances(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Healthinsurances healthinsurances = new Healthinsurances();
        List<com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance> entities = daoFactory.getHealthinsuranceDao().getAllEnrollmentHealthInsurances(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2016.Healthinsurance entity : entities){
           healthinsurances.addHealthinsurance(HealthinsuranceConverter.entityToModel(entity));
        }
        long count = daoFactory.getHealthinsuranceDao().getEnrollmentHealthInsurancesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(healthinsurances.getHealthinsurances().size());
        pagination.setTotal((int)count);
        healthinsurances.setPagination(pagination);
        return healthinsurances;
   }


}
