package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSources;
import com.servinglynk.hmis.warehouse.service.IncomeAndSourceService;
import com.servinglynk.hmis.warehouse.service.converter.IncomeAndSourceConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.IncomeAndSourceNotFoundException;


public class IncomeAndSourceServiceImpl extends ServiceBase implements IncomeAndSourceService  {

   @Transactional
   public IncomeAndSource createIncomeAndSource(IncomeAndSource incomeAndSource,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources pIncomeAndSource = IncomeAndSourceConverter.modelToEntity(incomeAndSource, null);
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       pIncomeAndSource.setEnrollmentid(pEnrollment); 
       pIncomeAndSource.setDateCreated(LocalDateTime.now());
   //    pIncomeAndSource.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getIncomeandsourcesDao().createIncomeAndSource(pIncomeAndSource);
       incomeAndSource.setIncomeAndSourceId(pIncomeAndSource.getId());
       return incomeAndSource;
   }


   @Transactional
   public IncomeAndSource updateIncomeAndSource(IncomeAndSource incomeAndSource,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
       if(pEnrollment == null) throw new EnrollmentNotFound(); 
       com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources pIncomeAndSource = daoFactory.getIncomeandsourcesDao().getIncomeAndSourceById(incomeAndSource.getIncomeAndSourceId());
       if(pIncomeAndSource==null) throw new IncomeAndSourceNotFoundException();

       IncomeAndSourceConverter.modelToEntity(incomeAndSource, pIncomeAndSource);
       pIncomeAndSource.setEnrollmentid(pEnrollment); 
       pIncomeAndSource.setDateUpdated(LocalDateTime.now());
  //     pIncomeAndSource.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getIncomeandsourcesDao().updateIncomeAndSource(pIncomeAndSource);
       incomeAndSource.setIncomeAndSourceId(pIncomeAndSource.getId());
       return incomeAndSource;
   }


   @Transactional
   public IncomeAndSource deleteIncomeAndSource(UUID incomeAndSourceId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources pIncomeAndSource = daoFactory.getIncomeandsourcesDao().getIncomeAndSourceById(incomeAndSourceId);
       if(pIncomeAndSource==null) throw new IncomeAndSourceNotFoundException();

       daoFactory.getIncomeandsourcesDao().deleteIncomeAndSource(pIncomeAndSource);
       return new IncomeAndSource();
   }


   @Transactional
   public IncomeAndSource getIncomeAndSourceById(UUID incomeAndSourceId){
       com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources pIncomeAndSource = daoFactory.getIncomeandsourcesDao().getIncomeAndSourceById(incomeAndSourceId);
       if(pIncomeAndSource==null) throw new IncomeAndSourceNotFoundException();

       return IncomeAndSourceConverter.entityToModel( pIncomeAndSource );
   }


   @Transactional
   public IncomeAndSources getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems){
       IncomeAndSources incomeAndSources = new IncomeAndSources();
        List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources> entities = daoFactory.getIncomeandsourcesDao().getAllEnrollmentIncomeAndSources(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources entity : entities){
           incomeAndSources.addIncomeAndSource(IncomeAndSourceConverter.entityToModel(entity));
        }
        long count = daoFactory.getIncomeandsourcesDao().getEnrollmentIncomeAndSourcesCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(incomeAndSources.getIncomeAndSources().size());
        pagination.setTotal((int)count);
        incomeAndSources.setPagination(pagination);
        return incomeAndSources; 
   }


}
