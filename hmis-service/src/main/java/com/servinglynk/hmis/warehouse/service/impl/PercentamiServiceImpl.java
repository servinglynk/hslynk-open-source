package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Percentami;
import com.servinglynk.hmis.warehouse.core.model.Percentamis;
import com.servinglynk.hmis.warehouse.service.PercentamiService;
import com.servinglynk.hmis.warehouse.service.converter.PercentamiConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.PercentamiNotFoundException;


public class PercentamiServiceImpl extends ServiceBase implements PercentamiService  {

   @Transactional
   public Percentami createPercentami(Percentami percentami,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Percentami pPercentami = PercentamiConverter.modelToEntity(percentami, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pPercentami.setEnrollmentid(pEnrollment); 
       pPercentami.setDateCreated(LocalDateTime.now());
       pPercentami.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getPercentamiDao().createPercentami(pPercentami);
       percentami.setPercentamiId(pPercentami.getId());
       return percentami;
   }


   @Transactional
   public Percentami updatePercentami(Percentami percentami,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Percentami pPercentami = daoFactory.getPercentamiDao().getPercentamiById(percentami.getPercentamiId());
       if(pPercentami==null) throw new PercentamiNotFoundException();

       PercentamiConverter.modelToEntity(percentami, pPercentami);
       pPercentami.setEnrollmentid(pEnrollment); 
       pPercentami.setDateUpdated(LocalDateTime.now());
       pPercentami.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getPercentamiDao().updatePercentami(pPercentami);
       percentami.setPercentamiId(pPercentami.getId());
       return percentami;
   }


   @Transactional
   public Percentami deletePercentami(UUID percentamiId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Percentami pPercentami = daoFactory.getPercentamiDao().getPercentamiById(percentamiId);
       if(pPercentami==null) throw new PercentamiNotFoundException();

       daoFactory.getPercentamiDao().deletePercentami(pPercentami);
       return new Percentami();
   }


   @Transactional
   public Percentami getPercentamiById(UUID percentamiId){
       com.servinglynk.hmis.warehouse.model.live.Percentami pPercentami = daoFactory.getPercentamiDao().getPercentamiById(percentamiId);
       if(pPercentami==null) throw new PercentamiNotFoundException();

       return PercentamiConverter.entityToModel( pPercentami );
   }


   @Transactional
   public Percentamis getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Percentamis percentamis = new Percentamis();
        List<com.servinglynk.hmis.warehouse.model.live.Percentami> entities = daoFactory.getPercentamiDao().getAllEnrollmentPercentamis(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Percentami entity : entities){
           percentamis.addPercentami(PercentamiConverter.entityToModel(entity));
        }
        long count = daoFactory.getPercentamiDao().getEnrollmentPercentamisCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(percentamis.getPercentamis().size());
        pagination.setTotal((int)count);
        percentamis.setPagination(pagination);
        return percentamis; 
   }


}
