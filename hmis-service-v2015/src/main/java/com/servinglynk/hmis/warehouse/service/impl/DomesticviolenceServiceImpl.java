package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional; 

import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.service.DomesticviolenceService;
import com.servinglynk.hmis.warehouse.service.converter.DomesticviolenceConverter;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolences;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.DomesticviolenceNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class DomesticviolenceServiceImpl extends ServiceBase implements DomesticviolenceService  {

   @Transactional
   public Domesticviolence createDomesticviolence(Domesticviolence domesticviolence,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence pDomesticviolence = DomesticviolenceConverter.modelToEntity(domesticviolence, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pDomesticviolence.setEnrollmentid(pEnrollment); 
       pDomesticviolence.setDateCreated(LocalDateTime.now());
       pDomesticviolence.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getDomesticviolenceDao().createDomesticViolence(pDomesticviolence);
       domesticviolence.setDomesticviolenceId(pDomesticviolence.getId());
       return domesticviolence;
   }


   @Transactional
   public Domesticviolence updateDomesticviolence(Domesticviolence domesticviolence,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence pDomesticviolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticviolence.getDomesticviolenceId());
       if(pDomesticviolence==null) throw new DomesticviolenceNotFoundException();

       DomesticviolenceConverter.modelToEntity(domesticviolence, pDomesticviolence);
       pDomesticviolence.setEnrollmentid(pEnrollment); 
       pDomesticviolence.setDateUpdated(LocalDateTime.now());
       pDomesticviolence.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getDomesticviolenceDao().updateDomesticViolence(pDomesticviolence);
       domesticviolence.setDomesticviolenceId(pDomesticviolence.getId());
       return domesticviolence;
   }


   @Transactional
   public Domesticviolence deleteDomesticviolence(UUID domesticviolenceId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence pDomesticviolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticviolenceId);
       if(pDomesticviolence==null) throw new DomesticviolenceNotFoundException();

       daoFactory.getDomesticviolenceDao().deleteDomesticViolence(pDomesticviolence);
       return new Domesticviolence();
   }


   @Transactional
   public Domesticviolence getDomesticviolenceById(UUID domesticviolenceId){
       com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence pDomesticviolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticviolenceId);
       if(pDomesticviolence==null) throw new DomesticviolenceNotFoundException();

       return DomesticviolenceConverter.entityToModel( pDomesticviolence );
   }


   @Transactional
   public Domesticviolences getAllEnrollmentDomesticviolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Domesticviolences domesticviolences = new Domesticviolences();
        List<com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence> entities = daoFactory.getDomesticviolenceDao().getAllEnrollmentDomesticViolences(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence entity : entities){
           domesticviolences.addDomesticviolence(DomesticviolenceConverter.entityToModel(entity));
        }
        long count = daoFactory.getDomesticviolenceDao().getEnrollmentDomesticViolencesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(domesticviolences.getDomesticviolences().size());
        pagination.setTotal((int)count);
        domesticviolences.setPagination(pagination);
        return domesticviolences; 
   }


}
