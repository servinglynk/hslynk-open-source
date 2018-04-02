package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Education;
import com.servinglynk.hmis.warehouse.core.model.Educations;
import com.servinglynk.hmis.warehouse.service.EducationService;
import com.servinglynk.hmis.warehouse.service.converter.EducationConverter;
import com.servinglynk.hmis.warehouse.service.exception.EducationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class EducationServiceImpl extends ServiceBase implements EducationService  {

   @Transactional
   public Education createEducation(Education education,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Education pEducation = EducationConverter.modelToEntity(education, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEducation.setEnrollmentid(pEnrollment);
       pEducation.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEducation, caller);
       daoFactory.getEducationDao().createEducation(pEducation);
       education.setEducationId(pEducation.getId());
       return education;
   }


   @Transactional
   public Education updateEducation(Education education,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.Education pEducation = daoFactory.getEducationDao().getEducationById(education.getEducationId());
       if(pEducation==null) throw new EducationNotFoundException();

       EducationConverter.modelToEntity(education, pEducation);
       pEducation.setEnrollmentid(pEnrollment);
       pEducation.setDateUpdated(LocalDateTime.now());
       pEducation.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEducationDao().updateEducation(pEducation);
       education.setEducationId(pEducation.getId());
       return education;
   }


   @Transactional
   public Education deleteEducation(UUID educationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Education pEducation = daoFactory.getEducationDao().getEducationById(educationId);
       if(pEducation==null) throw new EducationNotFoundException();

       daoFactory.getEducationDao().deleteEducation(pEducation);
       return new Education();
   }


   @Transactional
   public Education getEducationById(UUID educationId){
       com.servinglynk.hmis.warehouse.model.v2017.Education pEducation = daoFactory.getEducationDao().getEducationById(educationId);
       if(pEducation==null) throw new EducationNotFoundException();

       return EducationConverter.entityToModel( pEducation );
   }


   @Transactional
   public Educations getAllEnrollmentEducations(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Educations educations = new Educations();
        List<com.servinglynk.hmis.warehouse.model.v2017.Education> entities = daoFactory.getEducationDao().getAllEnrollmentEducations(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Education entity : entities){
           educations.addEducation(EducationConverter.entityToModel(entity));
        }
        long count = daoFactory.getEducationDao().getEnrollmentEducationsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(educations.getEducations().size());
        pagination.setTotal((int)count);
        educations.setPagination(pagination);
        return educations;
   }


}
