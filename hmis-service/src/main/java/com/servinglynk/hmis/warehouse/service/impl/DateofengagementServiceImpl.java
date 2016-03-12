package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagements;
import com.servinglynk.hmis.warehouse.service.DateofengagementService;
import com.servinglynk.hmis.warehouse.service.converter.DateofengagementConverter;
import com.servinglynk.hmis.warehouse.service.exception.DateofengagementNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class DateofengagementServiceImpl extends ServiceBase implements DateofengagementService  {

   @Transactional
   public Dateofengagement createDateofengagement(Dateofengagement dateofengagement,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Dateofengagement pDateofengagement = DateofengagementConverter.modelToEntity(dateofengagement, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pDateofengagement.setEnrollmentid(pEnrollment); 
       pDateofengagement.setDateCreated(LocalDateTime.now());
  //     pDateofengagement.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getDateofengagementDao().createDateofengagement(pDateofengagement);
       dateofengagement.setDateofengagementId(pDateofengagement.getId());
       return dateofengagement;
   }


   @Transactional
   public Dateofengagement updateDateofengagement(Dateofengagement dateofengagement,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Dateofengagement pDateofengagement = daoFactory.getDateofengagementDao().getDateofengagementById(dateofengagement.getDateofengagementId());
       if(pDateofengagement==null) throw new DateofengagementNotFoundException();

       DateofengagementConverter.modelToEntity(dateofengagement, pDateofengagement);
       pDateofengagement.setEnrollmentid(pEnrollment); 
       pDateofengagement.setDateUpdated(LocalDateTime.now());
   //    pDateofengagement.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getDateofengagementDao().updateDateofengagement(pDateofengagement);
       dateofengagement.setDateofengagementId(pDateofengagement.getId());
       return dateofengagement;
   }


   @Transactional
   public Dateofengagement deleteDateofengagement(UUID dateofengagementId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Dateofengagement pDateofengagement = daoFactory.getDateofengagementDao().getDateofengagementById(dateofengagementId);
       if(pDateofengagement==null) throw new DateofengagementNotFoundException();

       daoFactory.getDateofengagementDao().deleteDateofengagement(pDateofengagement);
       return new Dateofengagement();
   }


   @Transactional
   public Dateofengagement getDateofengagementById(UUID dateofengagementId){
       com.servinglynk.hmis.warehouse.model.live.Dateofengagement pDateofengagement = daoFactory.getDateofengagementDao().getDateofengagementById(dateofengagementId);
       if(pDateofengagement==null) throw new DateofengagementNotFoundException();

       return DateofengagementConverter.entityToModel( pDateofengagement );
   }


   @Transactional
   public Dateofengagements getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Dateofengagements dateofengagements = new Dateofengagements();
        List<com.servinglynk.hmis.warehouse.model.live.Dateofengagement> entities = daoFactory.getDateofengagementDao().getAllEnrollmentDateofengagements(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Dateofengagement entity : entities){
           dateofengagements.addDateofengagement(DateofengagementConverter.entityToModel(entity));
        }
        long count = daoFactory.getDateofengagementDao().getEnrollmentDateofengagementsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(dateofengagements.getDateofengagements().size());
        pagination.setTotal((int)count);
        dateofengagements.setPagination(pagination);
        return dateofengagements; 
   }


}
