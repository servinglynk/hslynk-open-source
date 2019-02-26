package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunification;
import com.servinglynk.hmis.warehouse.core.model.FamilyReunifications;
import com.servinglynk.hmis.warehouse.service.FamilyReunificationService;
import com.servinglynk.hmis.warehouse.service.converter.FamilyReunificationConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.FamilyReunificationNotFoundException;


public class FamilyReunificationServiceImpl extends ServiceBase implements FamilyReunificationService  {

   @Transactional
   public FamilyReunification createFamilyReunification(FamilyReunification familyReunification,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Familyreunification pFamilyReunification = FamilyReunificationConverter.modelToEntity(familyReunification, null);
       com.servinglynk.hmis.warehouse.model.v2014.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitNotFoundException(); 
       pFamilyReunification.setExitid(pExit); 
       pFamilyReunification.setDateCreated(LocalDateTime.now());
   //    pFamilyReunification.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectDao().populateUserProjectGroupCode(pFamilyReunification, caller);
       daoFactory.getFamilyreunificationDao().createFamilyReunification(pFamilyReunification);
       familyReunification.setFamilyReunificationId(pFamilyReunification.getId());
       return familyReunification;
   }


   @Transactional
   public FamilyReunification updateFamilyReunification(FamilyReunification familyReunification,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Exit pExit = daoFactory.getExitDao().getExitById(exitId); 
       if(pExit == null) throw new ExitNotFoundException(); 
       com.servinglynk.hmis.warehouse.model.v2014.Familyreunification pFamilyReunification = daoFactory.getFamilyreunificationDao().getFamilyReunificationById(familyReunification.getFamilyReunificationId());
       if(pFamilyReunification==null) throw new FamilyReunificationNotFoundException();

       FamilyReunificationConverter.modelToEntity(familyReunification, pFamilyReunification);
       pFamilyReunification.setExitid(pExit); 
       pFamilyReunification.setDateUpdated(LocalDateTime.now());
  //     pFamilyReunification.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getFamilyreunificationDao().updateFamilyReunification(pFamilyReunification);
       familyReunification.setFamilyReunificationId(pFamilyReunification.getId());
       return familyReunification;
   }


   @Transactional
   public FamilyReunification deleteFamilyReunification(UUID familyReunificationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Familyreunification pFamilyReunification = daoFactory.getFamilyreunificationDao().getFamilyReunificationById(familyReunificationId);
       if(pFamilyReunification==null) throw new FamilyReunificationNotFoundException();

       daoFactory.getFamilyreunificationDao().deleteFamilyReunification(pFamilyReunification);
       return new FamilyReunification();
   }


   @Transactional
   public FamilyReunification getFamilyReunificationById(UUID familyReunificationId){
       com.servinglynk.hmis.warehouse.model.v2014.Familyreunification pFamilyReunification = daoFactory.getFamilyreunificationDao().getFamilyReunificationById(familyReunificationId);
       if(pFamilyReunification==null) throw new FamilyReunificationNotFoundException();

       return FamilyReunificationConverter.entityToModel( pFamilyReunification );
   }


   @Transactional
   public FamilyReunifications getAllEnrollmentFamilyReunifications(UUID enrollmentId,Integer startIndex, Integer maxItems){
       FamilyReunifications familyReunifications = new FamilyReunifications();
        List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification> entities = daoFactory.getFamilyreunificationDao().getAllExitFamilyReunifications(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification entity : entities){
           familyReunifications.addFamilyReunification(FamilyReunificationConverter.entityToModel(entity));
        }
        long count = daoFactory.getFamilyreunificationDao().getExitFamilyReunificationsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(familyReunifications.getFamilyReunifications().size());
        pagination.setTotal((int)count);
        familyReunifications.setPagination(pagination);
        return familyReunifications; 
   }


}
