package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.CurrentLivingSituation;
import com.servinglynk.hmis.warehouse.core.model.CurrentLivingSituations;
import com.servinglynk.hmis.warehouse.service.CurrentLivingSituationService;
import com.servinglynk.hmis.warehouse.service.converter.CurrentLivingSituationConverter;
import com.servinglynk.hmis.warehouse.service.exception.CurrentLivingSituationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class CurrentLivingSituationServiceImpl extends ServiceBase implements CurrentLivingSituationService  {

   @Transactional
   public CurrentLivingSituation createCurrentLivingSituation(CurrentLivingSituation CurrentLivingSituation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation pCurrentLivingSituation = CurrentLivingSituationConverter.modelToEntity(CurrentLivingSituation, null);
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pCurrentLivingSituation.setEnrollmentid(pEnrollment);
       pCurrentLivingSituation.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pCurrentLivingSituation, caller);
       daoFactory.getCurrentLivingSituationDao().createCurrentLivingSituation(pCurrentLivingSituation);
       pCurrentLivingSituation.setId(pCurrentLivingSituation.getId());
       CurrentLivingSituation entityToModel = CurrentLivingSituationConverter.entityToModel(pCurrentLivingSituation);
       return entityToModel;
   }


   @Transactional
   public CurrentLivingSituation updateCurrentLivingSituation(CurrentLivingSituation CurrentLivingSituation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation pCurrentLivingSituation = daoFactory.getCurrentLivingSituationDao().getCurrentLivingSituationById(CurrentLivingSituation.getCurrentLivingSituationId());
       if(pCurrentLivingSituation==null) throw new CurrentLivingSituationNotFoundException();

       CurrentLivingSituationConverter.modelToEntity(CurrentLivingSituation, pCurrentLivingSituation);
       pCurrentLivingSituation.setEnrollmentid(pEnrollment);
       pCurrentLivingSituation.setDateUpdated(LocalDateTime.now());
       pCurrentLivingSituation.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getCurrentLivingSituationDao().updateCurrentLivingSituation(pCurrentLivingSituation);
       CurrentLivingSituation.setCurrentLivingSituationId(pCurrentLivingSituation.getId());
       return CurrentLivingSituation;
   }


   @Transactional
   public CurrentLivingSituation deleteCurrentLivingSituation(UUID CurrentLivingSituationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation pCurrentLivingSituation = daoFactory.getCurrentLivingSituationDao().getCurrentLivingSituationById(CurrentLivingSituationId);
       if(pCurrentLivingSituation==null) throw new CurrentLivingSituationNotFoundException();

       daoFactory.getCurrentLivingSituationDao().deleteCurrentLivingSituation(pCurrentLivingSituation);
       return new CurrentLivingSituation();
   }


   @Transactional
   public CurrentLivingSituation getCurrentLivingSituationById(UUID CurrentLivingSituationId){
       com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation pCurrentLivingSituation = daoFactory.getCurrentLivingSituationDao().getCurrentLivingSituationById(CurrentLivingSituationId);
       if(pCurrentLivingSituation==null) throw new CurrentLivingSituationNotFoundException();
       return CurrentLivingSituationConverter.entityToModel( pCurrentLivingSituation );
   }


   @Transactional
   public CurrentLivingSituations getAllEnrollmentCurrentLivingSituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
       CurrentLivingSituations currentLivingSituations = new CurrentLivingSituations();
        List<com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation> entities = daoFactory.getCurrentLivingSituationDao().getAllEnrollmentCurrentLivingSituations(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2020.CurrentLivingSituation entity : entities){
           currentLivingSituations.addCurrentLivingSituation(CurrentLivingSituationConverter.entityToModel(entity));
        }
        long count = daoFactory.getCurrentLivingSituationDao().getEnrollmentCurrentLivingSituationsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(currentLivingSituations.getCurrentLivingSituations().size());
        pagination.setTotal((int)count);
        currentLivingSituations.setPagination(pagination);
        return currentLivingSituations;
   }


}
