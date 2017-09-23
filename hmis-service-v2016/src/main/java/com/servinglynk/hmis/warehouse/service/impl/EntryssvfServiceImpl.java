package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Entryssvf;
import com.servinglynk.hmis.warehouse.service.EntryssvfService;
import com.servinglynk.hmis.warehouse.service.converter.EntryssvfConverter;
import com.servinglynk.hmis.warehouse.core.model.Entryssvfs;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EntryssvfNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class EntryssvfServiceImpl extends ServiceBase implements EntryssvfService  {

   @Transactional
   public Entryssvf createEntryssvf(Entryssvf entryssvf,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Entryssvf pEntryssvf = EntryssvfConverter.modelToEntity(entryssvf, null);
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEntryssvf.setEnrollmentid(pEnrollment);
       pEntryssvf.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEntryssvf, caller);
       daoFactory.getEntryssvfDao().createEntryssvf(pEntryssvf);
       entryssvf.setEntryssvfId(pEntryssvf.getId());
       return entryssvf;
   }


   @Transactional
   public Entryssvf updateEntryssvf(Entryssvf entryssvf,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2016.Entryssvf pEntryssvf = daoFactory.getEntryssvfDao().getEntryssvfById(entryssvf.getEntryssvfId());
       if(pEntryssvf==null) throw new EntryssvfNotFoundException();

       EntryssvfConverter.modelToEntity(entryssvf, pEntryssvf);
       pEntryssvf.setEnrollmentid(pEnrollment);
       pEntryssvf.setDateUpdated(LocalDateTime.now());
       pEntryssvf.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEntryssvfDao().updateEntryssvf(pEntryssvf);
       entryssvf.setEntryssvfId(pEntryssvf.getId());
       return entryssvf;
   }


   @Transactional
   public Entryssvf deleteEntryssvf(UUID entryssvfId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Entryssvf pEntryssvf = daoFactory.getEntryssvfDao().getEntryssvfById(entryssvfId);
       if(pEntryssvf==null) throw new EntryssvfNotFoundException();

       daoFactory.getEntryssvfDao().deleteEntryssvf(pEntryssvf);
       return new Entryssvf();
   }


   @Transactional
   public Entryssvf getEntryssvfById(UUID entryssvfId){
       com.servinglynk.hmis.warehouse.model.v2016.Entryssvf pEntryssvf = daoFactory.getEntryssvfDao().getEntryssvfById(entryssvfId);
       if(pEntryssvf==null) throw new EntryssvfNotFoundException();

       return EntryssvfConverter.entityToModel( pEntryssvf );
   }


   @Transactional
   public Entryssvfs getAllEnrollmentEntryssvfs(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Entryssvfs entryssvfs = new Entryssvfs();
        List<com.servinglynk.hmis.warehouse.model.v2016.Entryssvf> entities = daoFactory.getEntryssvfDao().getAllEnrollmentEntryssvfs(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2016.Entryssvf entity : entities){
           entryssvfs.addEntryssvf(EntryssvfConverter.entityToModel(entity));
        }
        long count = daoFactory.getEntryssvfDao().getEnrollmentEntryssvfsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(entryssvfs.getEntryssvfs().size());
        pagination.setTotal((int)count);
        entryssvfs.setPagination(pagination);
        return entryssvfs;
   }


}
