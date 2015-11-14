package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurances;
import com.servinglynk.hmis.warehouse.service.HealthInsuranceService;
import com.servinglynk.hmis.warehouse.service.converter.HealthInsuranceConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.HealthInsuranceNotFoundException;


public class HealthInsuranceServiceImpl extends ServiceBase implements HealthInsuranceService  {

   @Transactional
   public HealthInsurance createHealthInsurance(HealthInsurance healthInsurance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Healthinsurance pHealthInsurance = HealthInsuranceConverter.modelToEntity(healthInsurance, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pHealthInsurance.setEnrollmentid(pEnrollment); 
       pHealthInsurance.setDateCreated(LocalDateTime.now());
       pHealthInsurance.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getHealthinsuranceDao().createHealthInsurance(pHealthInsurance);
       healthInsurance.setHealthInsuranceId(pHealthInsurance.getId());
       return healthInsurance;
   }


   @Transactional
   public HealthInsurance updateHealthInsurance(HealthInsurance healthInsurance,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Healthinsurance pHealthInsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthInsurance.getHealthInsuranceId());
       if(pHealthInsurance==null) throw new HealthInsuranceNotFoundException();

       HealthInsuranceConverter.modelToEntity(healthInsurance, pHealthInsurance);
       pHealthInsurance.setEnrollmentid(pEnrollment); 
       pHealthInsurance.setDateUpdated(LocalDateTime.now());
       pHealthInsurance.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getHealthinsuranceDao().updateHealthInsurance(pHealthInsurance);
       healthInsurance.setHealthInsuranceId(pHealthInsurance.getId());
       return healthInsurance;
   }


   @Transactional
   public HealthInsurance deleteHealthInsurance(UUID healthInsuranceId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Healthinsurance pHealthInsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthInsuranceId);
       if(pHealthInsurance==null) throw new HealthInsuranceNotFoundException();

       daoFactory.getHealthinsuranceDao().deleteHealthInsurance(pHealthInsurance);
       return new HealthInsurance();
   }


   @Transactional
   public HealthInsurance getHealthInsuranceById(UUID healthInsuranceId){
       com.servinglynk.hmis.warehouse.model.live.Healthinsurance pHealthInsurance = daoFactory.getHealthinsuranceDao().getHealthInsuranceById(healthInsuranceId);
       if(pHealthInsurance==null) throw new HealthInsuranceNotFoundException();

       return HealthInsuranceConverter.entityToModel( pHealthInsurance );
   }


   @Transactional
   public HealthInsurances getAllEnrollmentHealthInsurances(UUID enrollmentId,Integer startIndex, Integer maxItems){
       HealthInsurances healthInsurances = new HealthInsurances();
        List<com.servinglynk.hmis.warehouse.model.live.Healthinsurance> entities = daoFactory.getHealthinsuranceDao().getAllEnrollmentHealthInsurances(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Healthinsurance entity : entities){
           healthInsurances.addHealthInsurance(HealthInsuranceConverter.entityToModel(entity));
        }
        long count = daoFactory.getHealthinsuranceDao().getEnrollmentHealthInsurancesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(healthInsurances.getHealthInsurances().size());
        pagination.setTotal((int)count);
        healthInsurances.setPagination(pagination);
        return healthInsurances; 
   }


}
