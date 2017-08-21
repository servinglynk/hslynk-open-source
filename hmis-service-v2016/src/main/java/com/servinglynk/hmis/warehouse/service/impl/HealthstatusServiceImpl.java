package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Healthstatuses;
import com.servinglynk.hmis.warehouse.service.HealthstatusService;
import com.servinglynk.hmis.warehouse.service.converter.HealthstatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.HealthstatusNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class HealthstatusServiceImpl extends ServiceBase implements HealthstatusService  {

   @Transactional
   public Healthstatus createHealthstatus(Healthstatus healthstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.HealthStatus pHealthstatus = HealthstatusConverter.modelToEntity(healthstatus, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pHealthstatus.setEnrollmentid(pEnrollment);
       pHealthstatus.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pHealthstatus, caller);
       daoFactory.getHealthStatusDao().createHealthStatus(pHealthstatus);
       healthstatus.setHealthstatusId(pHealthstatus.getId());
       return healthstatus;
   }


   @Transactional
   public Healthstatus updateHealthstatus(Healthstatus healthstatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.HealthStatus pHealthstatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthstatus.getHealthstatusId());
       if(pHealthstatus==null) throw new HealthstatusNotFoundException();

       HealthstatusConverter.modelToEntity(healthstatus, pHealthstatus);
       pHealthstatus.setEnrollmentid(pEnrollment);
       pHealthstatus.setDateUpdated(LocalDateTime.now());
       pHealthstatus.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getHealthStatusDao().updateHealthStatus(pHealthstatus);
       healthstatus.setHealthstatusId(pHealthstatus.getId());
       return healthstatus;
   }


   @Transactional
   public Healthstatus deleteHealthstatus(UUID healthstatusId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.HealthStatus pHealthstatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthstatusId);
       if(pHealthstatus==null) throw new HealthstatusNotFoundException();

       daoFactory.getHealthStatusDao().deleteHealthStatus(pHealthstatus);
       return new Healthstatus();
   }


   @Transactional
   public Healthstatus getHealthstatusById(UUID healthstatusId){
       com.servinglynk.hmis.warehouse.model.v2017.HealthStatus pHealthstatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthstatusId);
       if(pHealthstatus==null) throw new HealthstatusNotFoundException();

       return HealthstatusConverter.entityToModel( pHealthstatus );
   }


   @Transactional
   public Healthstatuses getAllEnrollmentHealthstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Healthstatuses healthstatuss = new Healthstatuses();
        List<com.servinglynk.hmis.warehouse.model.v2017.HealthStatus> entities = daoFactory.getHealthStatusDao().getAllEnrollmentHealthStatuses(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.HealthStatus entity : entities){
           healthstatuss.addHealthstatus(HealthstatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getHealthStatusDao().getEnrollmentHealthStatusesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(healthstatuss.getHealthstatuses().size());
        pagination.setTotal((int)count);
        healthstatuss.setPagination(pagination);
        return healthstatuss;
   }


}
