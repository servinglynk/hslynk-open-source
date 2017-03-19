package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientations;
import com.servinglynk.hmis.warehouse.service.SexualorientationService;
import com.servinglynk.hmis.warehouse.service.converter.SexualorientationConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.SexualorientationNotFoundException;


public class SexualorientationServiceImpl extends ServiceBase implements SexualorientationService  {

   @Transactional
   public Sexualorientation createSexualorientation(Sexualorientation sexualorientation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation pSexualorientation = SexualorientationConverter.modelToEntity(sexualorientation, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pSexualorientation.setEnrollmentid(pEnrollment); 
       pSexualorientation.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pSexualorientation, caller);
       daoFactory.getSexualorientationDao().createSexualorientation(pSexualorientation);
       sexualorientation.setSexualorientationId(pSexualorientation.getId());
       return sexualorientation;
   }


   @Transactional
   public Sexualorientation updateSexualorientation(Sexualorientation sexualorientation,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation pSexualorientation = daoFactory.getSexualorientationDao().getSexualorientationById(sexualorientation.getSexualorientationId());
       if(pSexualorientation==null) throw new SexualorientationNotFoundException();

       SexualorientationConverter.modelToEntity(sexualorientation, pSexualorientation);
       pSexualorientation.setEnrollmentid(pEnrollment); 
       pSexualorientation.setDateUpdated(LocalDateTime.now());
   //    pSexualorientation.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getSexualorientationDao().updateSexualorientation(pSexualorientation);
       sexualorientation.setSexualorientationId(pSexualorientation.getId());
       return sexualorientation;
   }


   @Transactional
   public Sexualorientation deleteSexualorientation(UUID sexualorientationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation pSexualorientation = daoFactory.getSexualorientationDao().getSexualorientationById(sexualorientationId);
       if(pSexualorientation==null) throw new SexualorientationNotFoundException();

       daoFactory.getSexualorientationDao().deleteSexualorientation(pSexualorientation);
       return new Sexualorientation();
   }


   @Transactional
   public Sexualorientation getSexualorientationById(UUID sexualorientationId){
       com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation pSexualorientation = daoFactory.getSexualorientationDao().getSexualorientationById(sexualorientationId);
       if(pSexualorientation==null) throw new SexualorientationNotFoundException();

       return SexualorientationConverter.entityToModel( pSexualorientation );
   }


   @Transactional
   public Sexualorientations getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Sexualorientations sexualorientations = new Sexualorientations();
        List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> entities = daoFactory.getSexualorientationDao().getAllEnrollmentSexualorientations(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation entity : entities){
           sexualorientations.addSexualorientation(SexualorientationConverter.entityToModel(entity));
        }
        long count = daoFactory.getSexualorientationDao().getEnrollmentSexualorientationsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(sexualorientations.getSexualorientations().size());
        pagination.setTotal((int)count);
        sexualorientations.setPagination(pagination);
        return sexualorientations; 
   }


}
