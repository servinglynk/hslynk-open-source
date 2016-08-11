package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional; 

import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.service.NoncashbenefitsService;
import com.servinglynk.hmis.warehouse.service.converter.NoncashbenefitsConverter;
import com.servinglynk.hmis.warehouse.core.model.NoncashbenefitsList;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.NoncashbenefitsNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class NoncashbenefitsServiceImpl extends ServiceBase implements NoncashbenefitsService  {

   @Transactional
   public Noncashbenefits createNoncashbenefits(Noncashbenefits noncashbenefits,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits pNoncashbenefits = NoncashbenefitsConverter.modelToEntity(noncashbenefits, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pNoncashbenefits.setEnrollmentid(pEnrollment); 
       pNoncashbenefits.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pNoncashbenefits, caller);
       daoFactory.getNoncashbenefitsDao().createNoncashbenefits(pNoncashbenefits);
       noncashbenefits.setNoncashbenefitsID(pNoncashbenefits.getId());
       return noncashbenefits;
   }


   @Transactional
   public Noncashbenefits updateNoncashbenefits(Noncashbenefits noncashbenefits,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits pNoncashbenefits = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(noncashbenefits.getNoncashbenefitsID());
       if(pNoncashbenefits==null) throw new NoncashbenefitsNotFoundException();

       NoncashbenefitsConverter.modelToEntity(noncashbenefits, pNoncashbenefits);
       pNoncashbenefits.setEnrollmentid(pEnrollment); 
       pNoncashbenefits.setDateUpdated(LocalDateTime.now());
       pNoncashbenefits.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getNoncashbenefitsDao().updateNoncashbenefits(pNoncashbenefits);
       noncashbenefits.setNoncashbenefitsID(pNoncashbenefits.getId());
       return noncashbenefits;
   }


   @Transactional
   public Noncashbenefits deleteNoncashbenefits(UUID noncashbenefitsId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits pNoncashbenefits = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(noncashbenefitsId);
       if(pNoncashbenefits==null) throw new NoncashbenefitsNotFoundException();

       daoFactory.getNoncashbenefitsDao().deleteNoncashbenefits(pNoncashbenefits);
       return new Noncashbenefits();
   }


   @Transactional
   public Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId){
       com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits pNoncashbenefits = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(noncashbenefitsId);
       if(pNoncashbenefits==null) throw new NoncashbenefitsNotFoundException();

       return NoncashbenefitsConverter.entityToModel( pNoncashbenefits );
   }


   @Transactional
   public NoncashbenefitsList getAllEnrollmentNoncashbenefitss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	   NoncashbenefitsList noncashbenefitss = new NoncashbenefitsList();
        List<com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits> entities = daoFactory.getNoncashbenefitsDao().getAllEnrollmentNoncashbenefits(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits entity : entities){
           noncashbenefitss.addNoncashbenefits(NoncashbenefitsConverter.entityToModel(entity));
        }
        long count = daoFactory.getNoncashbenefitsDao().getEnrollmentNoncashbenefitsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(noncashbenefitss.getNoncashbenefitsList().size());
        pagination.setTotal((int)count);
        noncashbenefitss.setPagination(pagination);
        return noncashbenefitss; 
   }


}
