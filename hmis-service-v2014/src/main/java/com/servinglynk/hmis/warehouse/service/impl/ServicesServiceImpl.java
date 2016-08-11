package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.core.model.ServicesList;
import com.servinglynk.hmis.warehouse.service.ServicesService;
import com.servinglynk.hmis.warehouse.service.converter.ServicesConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ServicesNotFoundException;


public class ServicesServiceImpl extends ServiceBase implements ServicesService  {

   @Transactional
   public Services createServices(Services services,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Services pServices = ServicesConverter.modelToEntity(services, null);
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pServices.setEnrollmentid(pEnrollment); 
       pServices.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pServices, caller);
       daoFactory.getServicesDao().createServices(pServices);
       services.setServicesId(pServices.getId());
       return services;
   }


   @Transactional
   public Services updateServices(Services services,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2014.Services pServices = daoFactory.getServicesDao().getServicesById(services.getServicesId());
       if(pServices==null) throw new ServicesNotFoundException();

       ServicesConverter.modelToEntity(services, pServices);
       pServices.setEnrollmentid(pEnrollment); 
       pServices.setDateUpdated(LocalDateTime.now());
   //    pServices.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getServicesDao().updateServices(pServices);
       services.setServicesId(pServices.getId());
       return services;
   }


   @Transactional
   public Services deleteServices(UUID servicesId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Services pServices = daoFactory.getServicesDao().getServicesById(servicesId);
       if(pServices==null) throw new ServicesNotFoundException();

       daoFactory.getServicesDao().deleteServices(pServices);
       return new Services();
   }


   @Transactional
   public Services getServicesById(UUID servicesId){
       com.servinglynk.hmis.warehouse.model.v2014.Services pServices = daoFactory.getServicesDao().getServicesById(servicesId);
       if(pServices==null) throw new ServicesNotFoundException();

       return ServicesConverter.entityToModel( pServices );
   }


   @Transactional
   public ServicesList getAllEnrollmentServicess(UUID enrollmentId,Integer startIndex, Integer maxItems){
       ServicesList servicess = new ServicesList();
        List<com.servinglynk.hmis.warehouse.model.v2014.Services> entities = daoFactory.getServicesDao().getAllEnrollmentServicess(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Services entity : entities){
           servicess.addServices(ServicesConverter.entityToModel(entity));
        }
        long count = daoFactory.getServicesDao().getEnrollmentServicessCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(servicess.getServicesList().size());
        pagination.setTotal((int)count);
        servicess.setPagination(pagination);
        return servicess; 
   }


}
