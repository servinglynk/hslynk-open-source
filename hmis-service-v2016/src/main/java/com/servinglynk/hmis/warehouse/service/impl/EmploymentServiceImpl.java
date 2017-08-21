package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Employments;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.converter.EmploymentConverter;
import com.servinglynk.hmis.warehouse.service.exception.EmploymentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;


public class EmploymentServiceImpl extends ServiceBase implements EmploymentService  {

   @Transactional
   public Employment createEmployment(Employment employment,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Employment pEmployment = EmploymentConverter.modelToEntity(employment, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEmployment.setEnrollmentid(pEnrollment);
       pEmployment.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEmployment, caller);
       daoFactory.getEmploymentDao().createEmployment(pEmployment);
       employment.setEmploymentId(pEmployment.getId());
       return employment;
   }


   @Transactional
   public Employment updateEmployment(Employment employment,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.Employment pEmployment = daoFactory.getEmploymentDao().getEmploymentById(employment.getEmploymentId());
       if(pEmployment==null) throw new EmploymentNotFoundException();

       EmploymentConverter.modelToEntity(employment, pEmployment);
       pEmployment.setEnrollmentid(pEnrollment);
       pEmployment.setDateUpdated(LocalDateTime.now());
       pEmployment.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEmploymentDao().updateEmployment(pEmployment);
       employment.setEmploymentId(pEmployment.getId());
       return employment;
   }


   @Transactional
   public Employment deleteEmployment(UUID employmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Employment pEmployment = daoFactory.getEmploymentDao().getEmploymentById(employmentId);
       if(pEmployment==null) throw new EmploymentNotFoundException();

       daoFactory.getEmploymentDao().deleteEmployment(pEmployment);
       return new Employment();
   }


   @Transactional
   public Employment getEmploymentById(UUID employmentId){
       com.servinglynk.hmis.warehouse.model.v2017.Employment pEmployment = daoFactory.getEmploymentDao().getEmploymentById(employmentId);
       if(pEmployment==null) throw new EmploymentNotFoundException();

       return EmploymentConverter.entityToModel( pEmployment );
   }


   @Transactional
   public Employments getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Employments employments = new Employments();
        List<com.servinglynk.hmis.warehouse.model.v2017.Employment> entities = daoFactory.getEmploymentDao().getAllEnrollmentEmployments(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Employment entity : entities){
           employments.addEmployment(EmploymentConverter.entityToModel(entity));
        }
        long count = daoFactory.getEmploymentDao().getEnrollmentEmploymentsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(employments.getEmployments().size());
        pagination.setTotal((int)count);
        employments.setPagination(pagination);
        return employments;
   }


}
