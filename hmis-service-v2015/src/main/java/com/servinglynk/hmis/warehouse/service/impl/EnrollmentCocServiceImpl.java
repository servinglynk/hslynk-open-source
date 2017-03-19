package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional; 

import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.service.EnrollmentCocService;
import com.servinglynk.hmis.warehouse.service.converter.EnrollmentCocConverter;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCocs;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentCocNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class EnrollmentCocServiceImpl extends ServiceBase implements EnrollmentCocService  {

   @Transactional
   public EnrollmentCoc createEnrollmentCoc(EnrollmentCoc enrollmentCoc,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc pEnrollmentCoc = EnrollmentCocConverter.modelToEntity(enrollmentCoc, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pEnrollmentCoc.setEnrollmentid(pEnrollment); 
       pEnrollmentCoc.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEnrollmentCoc, caller);
       daoFactory.getEnrollmentCocDao().createEnrollmentCoc(pEnrollmentCoc);
       enrollmentCoc.setEnrollmentCocId(pEnrollmentCoc.getId());
       return enrollmentCoc;
   }


   @Transactional
   public EnrollmentCoc updateEnrollmentCoc(EnrollmentCoc enrollmentCoc,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc pEnrollmentCoc = daoFactory.getEnrollmentCocDao().getEnrollmentCocById(enrollmentCoc.getEnrollmentCocId());
       if(pEnrollmentCoc==null) throw new EnrollmentCocNotFoundException();

       EnrollmentCocConverter.modelToEntity(enrollmentCoc, pEnrollmentCoc);
       pEnrollmentCoc.setEnrollmentid(pEnrollment); 
       pEnrollmentCoc.setDateUpdated(LocalDateTime.now());
       pEnrollmentCoc.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEnrollmentCocDao().updateEnrollmentCoc(pEnrollmentCoc);
       enrollmentCoc.setEnrollmentCocId(pEnrollmentCoc.getId());
       return enrollmentCoc;
   }


   @Transactional
   public EnrollmentCoc deleteEnrollmentCoc(UUID enrollmentCocId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc pEnrollmentCoc = daoFactory.getEnrollmentCocDao().getEnrollmentCocById(enrollmentCocId);
       if(pEnrollmentCoc==null) throw new EnrollmentCocNotFoundException();

       daoFactory.getEnrollmentCocDao().deleteEnrollmentCoc(pEnrollmentCoc);
       return new EnrollmentCoc();
   }


   @Transactional
   public EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId){
       com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc pEnrollmentCoc = daoFactory.getEnrollmentCocDao().getEnrollmentCocById(enrollmentCocId);
       if(pEnrollmentCoc==null) throw new EnrollmentCocNotFoundException();

       return EnrollmentCocConverter.entityToModel( pEnrollmentCoc );
   }


   @Transactional
   public EnrollmentCocs getAllEnrollmentEnrollmentCocs(UUID enrollmentId,Integer startIndex, Integer maxItems){
       EnrollmentCocs enrollmentCocs = new EnrollmentCocs();
        List<com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc> entities = daoFactory.getEnrollmentCocDao().getAllEnrollmentEnrollmentCocs(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc entity : entities){
           enrollmentCocs.addEnrollmentCoc(EnrollmentCocConverter.entityToModel(entity));
        }
        long count = daoFactory.getEnrollmentCocDao().getEnrollmentEnrollmentCocsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(enrollmentCocs.getEnrollmentCocs().size());
        pagination.setTotal((int)count);
        enrollmentCocs.setPagination(pagination);
        return enrollmentCocs; 
   }


}
