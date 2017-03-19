package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Referralsource;
import com.servinglynk.hmis.warehouse.core.model.Referralsources;
import com.servinglynk.hmis.warehouse.service.ReferralsourceService;
import com.servinglynk.hmis.warehouse.service.converter.ReferralsourceConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ReferralsourceNotFoundException;


public class ReferralsourceServiceImpl extends ServiceBase implements ReferralsourceService  {

   @Transactional
   public Referralsource createReferralsource(Referralsource referralsource,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Referralsource pReferralsource = ReferralsourceConverter.modelToEntity(referralsource, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pReferralsource.setEnrollmentid(pEnrollment); 
       pReferralsource.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pReferralsource, caller);
       daoFactory.getReferralsourceDao().createReferralsource(pReferralsource);
       referralsource.setReferralsourceId(pReferralsource.getId());
       return referralsource;
   }


   @Transactional
   public Referralsource updateReferralsource(Referralsource referralsource,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Referralsource pReferralsource = daoFactory.getReferralsourceDao().getReferralsourceById(referralsource.getReferralsourceId());
       if(pReferralsource==null) throw new ReferralsourceNotFoundException();

       ReferralsourceConverter.modelToEntity(referralsource, pReferralsource);
       pReferralsource.setEnrollmentid(pEnrollment); 
       pReferralsource.setDateUpdated(LocalDateTime.now());
  //     pReferralsource.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getReferralsourceDao().updateReferralsource(pReferralsource);
       referralsource.setReferralsourceId(pReferralsource.getId());
       return referralsource;
   }


   @Transactional
   public Referralsource deleteReferralsource(UUID referralsourceId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Referralsource pReferralsource = daoFactory.getReferralsourceDao().getReferralsourceById(referralsourceId);
       if(pReferralsource==null) throw new ReferralsourceNotFoundException();

       daoFactory.getReferralsourceDao().deleteReferralsource(pReferralsource);
       return new Referralsource();
   }


   @Transactional
   public Referralsource getReferralsourceById(UUID referralsourceId){
       com.servinglynk.hmis.warehouse.model.v2014.Referralsource pReferralsource = daoFactory.getReferralsourceDao().getReferralsourceById(referralsourceId);
       if(pReferralsource==null) throw new ReferralsourceNotFoundException();

       return ReferralsourceConverter.entityToModel( pReferralsource );
   }


   @Transactional
   public Referralsources getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Referralsources referralsources = new Referralsources();
        List<com.servinglynk.hmis.warehouse.model.v2014.Referralsource> entities = daoFactory.getReferralsourceDao().getAllEnrollmentReferralsources(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Referralsource entity : entities){
           referralsources.addReferralsource(ReferralsourceConverter.entityToModel(entity));
        }
        long count = daoFactory.getReferralsourceDao().getEnrollmentReferralsourcesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(referralsources.getReferralsources().size());
        pagination.setTotal((int)count);
        referralsources.setPagination(pagination);
        return referralsources; 
   }


}
