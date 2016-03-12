package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituations;
import com.servinglynk.hmis.warehouse.service.WorstHousingSituationService;
import com.servinglynk.hmis.warehouse.service.converter.WorstHousingSituationConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.WorstHousingSituationNotFoundException;


public class WorstHousingSituationServiceImpl extends ServiceBase implements WorstHousingSituationService  {

   @Transactional
   public WorstHousingSituation createWorstHousingSituation(WorstHousingSituation worstHousingSituation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation pWorstHousingSituation = WorstHousingSituationConverter.modelToEntity(worstHousingSituation, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pWorstHousingSituation.setEnrollmentid(pEnrollment); 
       pWorstHousingSituation.setDateCreated(LocalDateTime.now());
  //     pWorstHousingSituation.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getWorsthousingsituationDao().createWorsthousingsituation(pWorstHousingSituation);
       worstHousingSituation.setWorstHousingSituationId(pWorstHousingSituation.getId());
       return worstHousingSituation;
   }


   @Transactional
   public WorstHousingSituation updateWorstHousingSituation(WorstHousingSituation worstHousingSituation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation pWorstHousingSituation = daoFactory.getWorsthousingsituationDao().getWorsthousingsituationById(worstHousingSituation.getWorstHousingSituationId());
       if(pWorstHousingSituation==null) throw new WorstHousingSituationNotFoundException();

       WorstHousingSituationConverter.modelToEntity(worstHousingSituation, pWorstHousingSituation);
       pWorstHousingSituation.setEnrollmentid(pEnrollment); 
       pWorstHousingSituation.setDateUpdated(LocalDateTime.now());
   //    pWorstHousingSituation.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getWorsthousingsituationDao().updateWorsthousingsituation(pWorstHousingSituation);
       worstHousingSituation.setWorstHousingSituationId(pWorstHousingSituation.getId());
       return worstHousingSituation;
   }


   @Transactional
   public WorstHousingSituation deleteWorstHousingSituation(UUID worstHousingSituationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation pWorstHousingSituation = daoFactory.getWorsthousingsituationDao().getWorsthousingsituationById(worstHousingSituationId);
       if(pWorstHousingSituation==null) throw new WorstHousingSituationNotFoundException();

       daoFactory.getWorsthousingsituationDao().deleteWorsthousingsituation(pWorstHousingSituation);
       return new WorstHousingSituation();
   }


   @Transactional
   public WorstHousingSituation getWorstHousingSituationById(UUID worstHousingSituationId){
       com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation pWorstHousingSituation = daoFactory.getWorsthousingsituationDao().getWorsthousingsituationById(worstHousingSituationId);
       if(pWorstHousingSituation==null) throw new WorstHousingSituationNotFoundException();

       return WorstHousingSituationConverter.entityToModel( pWorstHousingSituation );
   }


   @Transactional
   public WorstHousingSituations getAllEnrollmentWorstHousingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
       WorstHousingSituations worstHousingSituations = new WorstHousingSituations();
        List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation> entities = daoFactory.getWorsthousingsituationDao().getAllEnrollmentWorsthousingsituations(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation entity : entities){
           worstHousingSituations.addWorstHousingSituation(WorstHousingSituationConverter.entityToModel(entity));
        }
        long count = daoFactory.getWorsthousingsituationDao().getEnrollmentWorsthousingsituationsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(worstHousingSituations.getWorstHousingSituations().size());
        pagination.setTotal((int)count);
        worstHousingSituations.setPagination(pagination);
        return worstHousingSituations; 
   }


}
