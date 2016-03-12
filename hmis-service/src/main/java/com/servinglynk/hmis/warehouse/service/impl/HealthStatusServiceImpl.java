package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.core.model.HealthStatuses;
import com.servinglynk.hmis.warehouse.service.HealthStatusService;
import com.servinglynk.hmis.warehouse.service.converter.HealthStatusConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.HealthStatusNotFoundException;


public class HealthStatusServiceImpl extends ServiceBase implements HealthStatusService  {

   @Transactional
   public HealthStatus createHealthStatus(HealthStatus healthStatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.HealthStatus pHealthStatus = HealthStatusConverter.modelToEntity(healthStatus, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pHealthStatus.setEnrollmentid(pEnrollment); 
       pHealthStatus.setDateCreated(LocalDateTime.now());
   //    pHealthStatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getHealthStatusDao().createHealthStatus(pHealthStatus);
       healthStatus.setHealthStatusId(pHealthStatus.getId());
       return healthStatus;
   }


   @Transactional
   public HealthStatus updateHealthStatus(HealthStatus healthStatus,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.HealthStatus pHealthStatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthStatus.getHealthStatusId());
       if(pHealthStatus==null) throw new HealthStatusNotFoundException();

       HealthStatusConverter.modelToEntity(healthStatus, pHealthStatus);
       pHealthStatus.setEnrollmentid(pEnrollment); 
       pHealthStatus.setDateUpdated(LocalDateTime.now());
    //   pHealthStatus.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getHealthStatusDao().updateHealthStatus(pHealthStatus);
       healthStatus.setHealthStatusId(pHealthStatus.getId());
       return healthStatus;
   }


   @Transactional
   public HealthStatus deleteHealthStatus(UUID healthStatusId,String caller){
       com.servinglynk.hmis.warehouse.model.live.HealthStatus pHealthStatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthStatusId);
       if(pHealthStatus==null) throw new HealthStatusNotFoundException();

       daoFactory.getHealthStatusDao().deleteHealthStatus(pHealthStatus);
       return new HealthStatus();
   }


   @Transactional
   public HealthStatus getHealthStatusById(UUID healthStatusId){
       com.servinglynk.hmis.warehouse.model.live.HealthStatus pHealthStatus = daoFactory.getHealthStatusDao().getHealthStatusById(healthStatusId);
       if(pHealthStatus==null) throw new HealthStatusNotFoundException();

       return HealthStatusConverter.entityToModel( pHealthStatus );
   }


   @Transactional
   public HealthStatuses getAllEnrollmentHealthStatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
       HealthStatuses healthStatuss = new HealthStatuses();
        List<com.servinglynk.hmis.warehouse.model.live.HealthStatus> entities = daoFactory.getHealthStatusDao().getAllEnrollmentHealthStatuses(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.HealthStatus entity : entities){
           healthStatuss.addHealthStatus(HealthStatusConverter.entityToModel(entity));
        }
        long count = daoFactory.getHealthStatusDao().getEnrollmentHealthStatusesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(healthStatuss.getHealthStatuses().size());
        pagination.setTotal((int)count);
        healthStatuss.setPagination(pagination);
        return healthStatuss; 
   }


}
