package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DisabilitiesList;
import com.servinglynk.hmis.warehouse.service.DisabilitiesService;
import com.servinglynk.hmis.warehouse.service.converter.DisabilitiesConverter;
import com.servinglynk.hmis.warehouse.service.exception.DisabilitiesNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class DisabilitiesServiceImpl extends ServiceBase implements DisabilitiesService  {

   @Transactional
   public Disabilities createDisabilities(Disabilities disabilities,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Disabilities pDisabilities = DisabilitiesConverter.modelToEntity(disabilities, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pDisabilities.setEnrollmentid(pEnrollment);
       pDisabilities.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pDisabilities, caller);
       daoFactory.getDisabilitiesDao().createDisabilities(pDisabilities);
       disabilities.setDisabilitiesId(pDisabilities.getId());
       return disabilities;
   }


   @Transactional
   public Disabilities updateDisabilities(Disabilities disabilities,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.Disabilities pDisabilities = daoFactory.getDisabilitiesDao().getDisabilitiesById(disabilities.getDisabilitiesId());
       if(pDisabilities==null) throw new DisabilitiesNotFoundException();

       DisabilitiesConverter.modelToEntity(disabilities, pDisabilities);
       pDisabilities.setEnrollmentid(pEnrollment);
       pDisabilities.setDateUpdated(LocalDateTime.now());
       pDisabilities.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getDisabilitiesDao().updateDisabilities(pDisabilities);
       disabilities.setDisabilitiesId(pDisabilities.getId());
       return disabilities;
   }


   @Transactional
   public Disabilities deleteDisabilities(UUID disabilitiesId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Disabilities pDisabilities = daoFactory.getDisabilitiesDao().getDisabilitiesById(disabilitiesId);
       if(pDisabilities==null) throw new DisabilitiesNotFoundException();

       daoFactory.getDisabilitiesDao().deleteDisabilities(pDisabilities);
       return new Disabilities();
   }


   @Transactional
   public Disabilities getDisabilitiesById(UUID disabilitiesId){
       com.servinglynk.hmis.warehouse.model.v2017.Disabilities pDisabilities = daoFactory.getDisabilitiesDao().getDisabilitiesById(disabilitiesId);
       if(pDisabilities==null) throw new DisabilitiesNotFoundException();

       return DisabilitiesConverter.entityToModel( pDisabilities );
   }


   @Transactional
   public DisabilitiesList getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	   DisabilitiesList disabilities = new DisabilitiesList();
        List<com.servinglynk.hmis.warehouse.model.v2017.Disabilities> entities = daoFactory.getDisabilitiesDao().getAllEnrollmentDisabilitiess(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Disabilities entity : entities){
           disabilities.addDisabilities(DisabilitiesConverter.entityToModel(entity));
        }
        long count = daoFactory.getDisabilitiesDao().getEnrollmentDisabilitiessCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(disabilities.getDisabilitiesList().size());
        pagination.setTotal((int)count);
        disabilities.setPagination(pagination);
        return disabilities;
   }


}
