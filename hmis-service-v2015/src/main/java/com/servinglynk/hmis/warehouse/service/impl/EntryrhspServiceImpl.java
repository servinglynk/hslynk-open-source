package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Entryrhsp;
import com.servinglynk.hmis.warehouse.core.model.Entryrhsps;
import com.servinglynk.hmis.warehouse.service.EntryrhspService;
import com.servinglynk.hmis.warehouse.service.converter.EntryrhspConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EntryrhspNotFoundException;


public class EntryrhspServiceImpl extends ServiceBase implements EntryrhspService  {

   @Transactional
   public Entryrhsp createEntryrhsp(Entryrhsp entryrhsp,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp pEntryrhsp = EntryrhspConverter.modelToEntity(entryrhsp, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pEntryrhsp.setEnrollmentid(pEnrollment); 
       pEntryrhsp.setDateCreated(LocalDateTime.now());
//       pEntryrhsp.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getEntryrhspDao().createEntryrhsp(pEntryrhsp);
       entryrhsp.setEntryrhspId(pEntryrhsp.getId());
       return entryrhsp;
   }


   @Transactional
   public Entryrhsp updateEntryrhsp(Entryrhsp entryrhsp,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp pEntryrhsp = daoFactory.getEntryrhspDao().getEntryrhspById(entryrhsp.getEntryrhspId());
       if(pEntryrhsp==null) throw new EntryrhspNotFoundException();

       EntryrhspConverter.modelToEntity(entryrhsp, pEntryrhsp);
       pEntryrhsp.setEnrollmentid(pEnrollment); 
       pEntryrhsp.setDateUpdated(LocalDateTime.now());
 //      pEntryrhsp.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getEntryrhspDao().updateEntryrhsp(pEntryrhsp);
       entryrhsp.setEntryrhspId(pEntryrhsp.getId());
       return entryrhsp;
   }


   @Transactional
   public Entryrhsp deleteEntryrhsp(UUID entryrhspId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp pEntryrhsp = daoFactory.getEntryrhspDao().getEntryrhspById(entryrhspId);
       if(pEntryrhsp==null) throw new EntryrhspNotFoundException();

       daoFactory.getEntryrhspDao().deleteEntryrhsp(pEntryrhsp);
       return new Entryrhsp();
   }


   @Transactional
   public Entryrhsp getEntryrhspById(UUID entryrhspId){
       com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp pEntryrhsp = daoFactory.getEntryrhspDao().getEntryrhspById(entryrhspId);
       if(pEntryrhsp==null) throw new EntryrhspNotFoundException();

       return EntryrhspConverter.entityToModel( pEntryrhsp );
   }


   @Transactional
   public Entryrhsps getAllEnrollmentEntryrhsps(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Entryrhsps entryrhsps = new Entryrhsps();
        List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entities = daoFactory.getEntryrhspDao().getAllEnrollmentEntryrhsps(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entity : entities){
           entryrhsps.addEntryrhsp(EntryrhspConverter.entityToModel(entity));
        }
        long count = daoFactory.getEntryrhspDao().getEnrollmentEntryrhspsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(entryrhsps.getEntryrhsps().size());
        pagination.setTotal((int)count);
        entryrhsps.setPagination(pagination);
        return entryrhsps; 
   }


}
