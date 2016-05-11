package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.core.model.Funders;
import com.servinglynk.hmis.warehouse.service.FunderService;
import com.servinglynk.hmis.warehouse.service.converter.FunderConverter;
import com.servinglynk.hmis.warehouse.service.exception.FunderNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;


public class FunderServiceImpl extends ServiceBase implements FunderService  {

   @Transactional
   public Funder createFunder(Funder funder,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Funder pFunder = FunderConverter.modelToEntity(funder, null);
       com.servinglynk.hmis.warehouse.model.v2015.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException(); 
       pFunder.setProjectid(pProject); 
       pFunder.setDateCreated(LocalDateTime.now());
       pFunder.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getFunderDao().createFunder(pFunder);
       funder.setFunderId(pFunder.getId());
       return funder;
   }


   @Transactional
   public Funder updateFunder(Funder funder,UUID projectId,String caller){
	   com.servinglynk.hmis.warehouse.model.v2015.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException();  
       com.servinglynk.hmis.warehouse.model.v2015.Funder pFunder = daoFactory.getFunderDao().getFunderById(funder.getFunderId());
       if(pFunder==null) throw new FunderNotFoundException();

       FunderConverter.modelToEntity(funder, pFunder);
       pFunder.setProjectid(pProject);
       pFunder.setDateUpdated(LocalDateTime.now());
       pFunder.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getFunderDao().updateFunder(pFunder);
       funder.setFunderId(pFunder.getId());
       return funder;
   }


   @Transactional
   public Funder deleteFunder(UUID funderId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Funder pFunder = daoFactory.getFunderDao().getFunderById(funderId);
       if(pFunder==null) throw new FunderNotFoundException();

       daoFactory.getFunderDao().deleteFunder(pFunder);
       return new Funder();
   }


   @Transactional
   public Funder getFunderById(UUID funderId){
       com.servinglynk.hmis.warehouse.model.v2015.Funder pFunder = daoFactory.getFunderDao().getFunderById(funderId);
       if(pFunder==null) throw new FunderNotFoundException();

       return FunderConverter.entityToModel( pFunder );
   }


   @Transactional
   public Funders getAllProjectFunders(UUID projectId,Integer startIndex, Integer maxItems){
       Funders funders = new Funders();
        List<com.servinglynk.hmis.warehouse.model.v2015.Funder> entities = daoFactory.getFunderDao().getAllProjectFunders(projectId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Funder entity : entities){
           funders.addFunder(FunderConverter.entityToModel(entity));
        }
        long count = daoFactory.getFunderDao().getProjectFundersCount(projectId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(funders.getFunders().size());
        pagination.setTotal((int)count);
        funders.setPagination(pagination);
        return funders; 
   }


}
