package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
import com.servinglynk.hmis.warehouse.service.EntryrhyService;
import com.servinglynk.hmis.warehouse.service.converter.EntryrhyConverter;
import com.servinglynk.hmis.warehouse.core.model.Entryrhys;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EntryrhyNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class EntryrhyServiceImpl extends ServiceBase implements EntryrhyService  {

   @Transactional
   public Entryrhy createEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Entryrhy pEntryrhy = EntryrhyConverter.modelToEntity(entryrhy, null);
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEntryrhy.setEnrollmentid(pEnrollment);
       pEntryrhy.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEntryrhy, caller);
       daoFactory.getEntryrhyDao().createEntryrhy(pEntryrhy);
       entryrhy.setEntryrhyId(pEntryrhy.getId());
       return entryrhy;
   }


   @Transactional
   public Entryrhy updateEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2016.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhy.getEntryrhyId());
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       EntryrhyConverter.modelToEntity(entryrhy, pEntryrhy);
       pEntryrhy.setEnrollmentid(pEnrollment);
       pEntryrhy.setDateUpdated(LocalDateTime.now());
       pEntryrhy.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEntryrhyDao().updateEntryrhy(pEntryrhy);
       entryrhy.setEntryrhyId(pEntryrhy.getId());
       return entryrhy;
   }


   @Transactional
   public Entryrhy deleteEntryrhy(UUID entryrhyId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhyId);
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       daoFactory.getEntryrhyDao().deleteEntryrhy(pEntryrhy);
       return new Entryrhy();
   }


   @Transactional
   public Entryrhy getEntryrhyById(UUID entryrhyId){
       com.servinglynk.hmis.warehouse.model.v2016.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhyId);
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       return EntryrhyConverter.entityToModel( pEntryrhy );
   }


   @Transactional
   public Entryrhys getAllEnrollmentEntryrhys(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Entryrhys entryrhys = new Entryrhys();
        List<com.servinglynk.hmis.warehouse.model.v2016.Entryrhy> entities = daoFactory.getEntryrhyDao().getAllEnrollmentEntryrhys(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2016.Entryrhy entity : entities){
           entryrhys.addEntryrhy(EntryrhyConverter.entityToModel(entity));
        }
        long count = daoFactory.getEntryrhyDao().getEnrollmentEntryrhysCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(entryrhys.getEntryrhys().size());
        pagination.setTotal((int)count);
        entryrhys.setPagination(pagination);
        return entryrhys;
   }


}
