package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolences;
import com.servinglynk.hmis.warehouse.service.DomesticViolenceService;
import com.servinglynk.hmis.warehouse.service.converter.DomesticViolenceConverter;
import com.servinglynk.hmis.warehouse.service.exception.DomesticViolenceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class DomesticViolenceServiceImpl extends ServiceBase implements DomesticViolenceService  {

   @Transactional
   public DomesticViolence createDomesticViolence(DomesticViolence domesticViolence,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Domesticviolence pDomesticViolence = DomesticViolenceConverter.modelToEntity(domesticViolence, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pDomesticViolence.setEnrollmentid(pEnrollment); 
       pDomesticViolence.setDateCreated(LocalDateTime.now());
    //   pDomesticViolence.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getDomesticviolenceDao().createDomesticViolence(pDomesticViolence);
       domesticViolence.setDomesticViolenceId(pDomesticViolence.getId());
       return domesticViolence;
   }


   @Transactional
   public DomesticViolence updateDomesticViolence(DomesticViolence domesticViolence,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Domesticviolence pDomesticViolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticViolence.getDomesticViolenceId());
       if(pDomesticViolence==null) throw new DomesticViolenceNotFoundException();

       DomesticViolenceConverter.modelToEntity(domesticViolence, pDomesticViolence);
       pDomesticViolence.setEnrollmentid(pEnrollment); 
       pDomesticViolence.setDateUpdated(LocalDateTime.now());
  //     pDomesticViolence.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getDomesticviolenceDao().updateDomesticViolence(pDomesticViolence);
       domesticViolence.setDomesticViolenceId(pDomesticViolence.getId());
       return domesticViolence;
   }


   @Transactional
   public DomesticViolence deleteDomesticViolence(UUID domesticViolenceId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Domesticviolence pDomesticViolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticViolenceId);
       if(pDomesticViolence==null) throw new DomesticViolenceNotFoundException();

       daoFactory.getDomesticviolenceDao().deleteDomesticViolence(pDomesticViolence);
       return new DomesticViolence();
   }


   @Transactional
   public DomesticViolence getDomesticViolenceById(UUID domesticViolenceId){
       com.servinglynk.hmis.warehouse.model.live.Domesticviolence pDomesticViolence = daoFactory.getDomesticviolenceDao().getDomesticViolenceById(domesticViolenceId);
       if(pDomesticViolence==null) throw new DomesticViolenceNotFoundException();

       return DomesticViolenceConverter.entityToModel( pDomesticViolence );
   }


   @Transactional
   public DomesticViolences getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
       DomesticViolences domesticViolences = new DomesticViolences();
        List<com.servinglynk.hmis.warehouse.model.live.Domesticviolence> entities = daoFactory.getDomesticviolenceDao().getAllEnrollmentDomesticViolences(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Domesticviolence entity : entities){
           domesticViolences.addDomesticViolence(DomesticViolenceConverter.entityToModel(entity));
        }
        long count = daoFactory.getDomesticviolenceDao().getEnrollmentDomesticViolencesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(domesticViolences.getDomesticViolences().size());
        pagination.setTotal((int)count);
        domesticViolences.setPagination(pagination);
        return domesticViolences; 
   }


}
