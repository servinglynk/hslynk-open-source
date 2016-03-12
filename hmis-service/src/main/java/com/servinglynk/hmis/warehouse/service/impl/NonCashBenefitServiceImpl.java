package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefits;
import com.servinglynk.hmis.warehouse.service.NonCashBenefitService;
import com.servinglynk.hmis.warehouse.service.converter.NonCashBenefitConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.NonCashBenefitNotFoundException;


public class NonCashBenefitServiceImpl extends ServiceBase implements NonCashBenefitService  {

   @Transactional
   public NonCashBenefit createNonCashBenefit(NonCashBenefit nonCashBenefit,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Noncashbenefits pNonCashBenefit = NonCashBenefitConverter.modelToEntity(nonCashBenefit, null);
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pNonCashBenefit.setEnrollmentid(pEnrollment); 
       pNonCashBenefit.setDateCreated(LocalDateTime.now());
  //     pNonCashBenefit.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getNoncashbenefitsDao().createNoncashbenefits(pNonCashBenefit);
       nonCashBenefit.setNonCashBenefitId(pNonCashBenefit.getId());
       return nonCashBenefit;
   }


   @Transactional
   public NonCashBenefit updateNonCashBenefit(NonCashBenefit nonCashBenefit,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.live.Noncashbenefits pNonCashBenefit = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(nonCashBenefit.getNonCashBenefitId());
       if(pNonCashBenefit==null) throw new NonCashBenefitNotFoundException();

       NonCashBenefitConverter.modelToEntity(nonCashBenefit, pNonCashBenefit);
       pNonCashBenefit.setEnrollmentid(pEnrollment); 
       pNonCashBenefit.setDateUpdated(LocalDateTime.now());
  //     pNonCashBenefit.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getNoncashbenefitsDao().updateNoncashbenefits(pNonCashBenefit);
       nonCashBenefit.setNonCashBenefitId(pNonCashBenefit.getId());
       return nonCashBenefit;
   }


   @Transactional
   public NonCashBenefit deleteNonCashBenefit(UUID nonCashBenefitId,String caller){
       com.servinglynk.hmis.warehouse.model.live.Noncashbenefits pNonCashBenefit = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(nonCashBenefitId);
       if(pNonCashBenefit==null) throw new NonCashBenefitNotFoundException();

       daoFactory.getNoncashbenefitsDao().deleteNoncashbenefits(pNonCashBenefit);
       return new NonCashBenefit();
   }


   @Transactional
   public NonCashBenefit getNonCashBenefitById(UUID nonCashBenefitId){
       com.servinglynk.hmis.warehouse.model.live.Noncashbenefits pNonCashBenefit = daoFactory.getNoncashbenefitsDao().getNoncashbenefitsById(nonCashBenefitId);
       if(pNonCashBenefit==null) throw new NonCashBenefitNotFoundException();

       return NonCashBenefitConverter.entityToModel( pNonCashBenefit );
   }


   @Transactional
   public NonCashBenefits getAllEnrollmentNonCashBenefits(UUID enrollmentId,Integer startIndex, Integer maxItems){
       NonCashBenefits nonCashBenefits = new NonCashBenefits();
        List<com.servinglynk.hmis.warehouse.model.live.Noncashbenefits> entities = daoFactory.getNoncashbenefitsDao().getAllEnrollmentNoncashbenefits(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.live.Noncashbenefits entity : entities){
           nonCashBenefits.addNonCashBenefit(NonCashBenefitConverter.entityToModel(entity));
        }
        long count = daoFactory.getNoncashbenefitsDao().getEnrollmentNoncashbenefitsCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(nonCashBenefits.getNonCashBenefits().size());
        pagination.setTotal((int)count);
        nonCashBenefits.setPagination(pagination);
        return nonCashBenefits; 
   }


}
