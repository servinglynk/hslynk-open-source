package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Servicefareferral;
import com.servinglynk.hmis.warehouse.service.ServicefareferralService;
import com.servinglynk.hmis.warehouse.service.converter.ServicefareferralConverter;
import com.servinglynk.hmis.warehouse.core.model.Servicefareferrals;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ServicefareferralNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class ServicefareferralServiceImpl extends ServiceBase implements ServicefareferralService  {

   @Transactional
   public Servicefareferral createServicefareferral(Servicefareferral servicefareferral,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral pServicefareferral = ServicefareferralConverter.modelToEntity(servicefareferral, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pServicefareferral.setEnrollmentid(pEnrollment);
       pServicefareferral.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pServicefareferral, caller);
       daoFactory.getServiceFaReferralDao().createServiceFaReferral(pServicefareferral);
       servicefareferral.setServicefareferralId(pServicefareferral.getId());
       return servicefareferral;
   }


   @Transactional
   public Servicefareferral updateServicefareferral(Servicefareferral servicefareferral,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral pServicefareferral = daoFactory.getServiceFaReferralDao().getServiceFaReferralById(servicefareferral.getServicefareferralId());
       if(pServicefareferral==null) throw new ServicefareferralNotFoundException();

       ServicefareferralConverter.modelToEntity(servicefareferral, pServicefareferral);
       pServicefareferral.setEnrollmentid(pEnrollment);
       pServicefareferral.setDateUpdated(LocalDateTime.now());
       pServicefareferral.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getServiceFaReferralDao().updateServiceFaReferral(pServicefareferral);
       servicefareferral.setServicefareferralId(pServicefareferral.getId());
       return servicefareferral;
   }


   @Transactional
   public Servicefareferral deleteServicefareferral(UUID servicefareferralId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral pServicefareferral = daoFactory.getServiceFaReferralDao().getServiceFaReferralById(servicefareferralId);
       if(pServicefareferral==null) throw new ServicefareferralNotFoundException();

       daoFactory.getServiceFaReferralDao().deleteServiceFaReferral(pServicefareferral);
       return new Servicefareferral();
   }


   @Transactional
   public Servicefareferral getServicefareferralById(UUID servicefareferralId){
       com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral pServicefareferral = daoFactory.getServiceFaReferralDao().getServiceFaReferralById(servicefareferralId);
       if(pServicefareferral==null) throw new ServicefareferralNotFoundException();

       return ServicefareferralConverter.entityToModel( pServicefareferral );
   }


   @Transactional
   public Servicefareferrals getAllEnrollmentServicefareferrals(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Servicefareferrals servicefareferrals = new Servicefareferrals();
        List<com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral> entities = daoFactory.getServiceFaReferralDao().getAllEnrollmentServiceFaReferrals(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.ServiceFaReferral entity : entities){
           servicefareferrals.addServicefareferral(ServicefareferralConverter.entityToModel(entity));
        }
        long count = daoFactory.getServiceFaReferralDao().getEnrollmentServiceFaReferralsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(servicefareferrals.getServicefareferrals().size());
        pagination.setTotal((int)count);
        servicefareferrals.setPagination(pagination);
        return servicefareferrals;
   }


}
