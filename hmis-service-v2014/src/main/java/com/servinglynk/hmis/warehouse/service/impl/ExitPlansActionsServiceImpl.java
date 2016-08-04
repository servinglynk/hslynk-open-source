package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActions;
import com.servinglynk.hmis.warehouse.core.model.ExitPlansActionsList;
import com.servinglynk.hmis.warehouse.service.ExitPlansActionsService;
import com.servinglynk.hmis.warehouse.service.converter.ExitPlansActionsConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitPlansActionsNotFoundException;


public class ExitPlansActionsServiceImpl extends ServiceBase implements ExitPlansActionsService  {

   @Transactional
   public ExitPlansActions createExitPlansActions(ExitPlansActions exitPlansActions,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions pExitPlansActions = ExitPlansActionsConverter.modelToEntity(exitPlansActions, null);
      
       com.servinglynk.hmis.warehouse.model.v2014.Exit pExit = daoFactory.getExitDao().getExitById(exitId);

       if(pExit == null) throw new ExitNotFoundException();
       
       pExitPlansActions.setExitid(pExit);
       pExitPlansActions.setDateCreated(LocalDateTime.now());
   //    pExitPlansActions.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectDao().populateUserProjectGroupCode(pExitPlansActions, caller);
       daoFactory.getExitplansactionsDao().createExitPlansActions(pExitPlansActions);
       exitPlansActions.setExitPlansActionsId(pExitPlansActions.getId());
       return exitPlansActions;
   }


   @Transactional
   public ExitPlansActions updateExitPlansActions(ExitPlansActions exitPlansActions,UUID exitId,String caller){
       
       com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions pExitPlansActions = daoFactory.getExitplansactionsDao().getExitPlansActionsById(exitPlansActions.getExitPlansActionsId());
       if(pExitPlansActions==null) throw new ExitPlansActionsNotFoundException();

       com.servinglynk.hmis.warehouse.model.v2014.Exit pExit = daoFactory.getExitDao().getExitById(exitId);

       if(pExit == null) throw new ExitNotFoundException();
       
       pExitPlansActions.setExitid(pExit);
       
       ExitPlansActionsConverter.modelToEntity(exitPlansActions, pExitPlansActions);
       pExitPlansActions.setDateUpdated(LocalDateTime.now());
     //  pExitPlansActions.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getExitplansactionsDao().updateExitPlansActions(pExitPlansActions);
       exitPlansActions.setExitPlansActionsId(pExitPlansActions.getId());
       return exitPlansActions;
   }


   @Transactional
   public ExitPlansActions deleteExitPlansActions(UUID exitPlansActionsId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions pExitPlansActions = daoFactory.getExitplansactionsDao().getExitPlansActionsById(exitPlansActionsId);
       if(pExitPlansActions==null) throw new ExitPlansActionsNotFoundException();

       daoFactory.getExitplansactionsDao().deleteExitPlansActions(pExitPlansActions);
       return new ExitPlansActions();
   }


   @Transactional
   public ExitPlansActions getExitPlansActionsById(UUID exitPlansActionsId){
       com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions pExitPlansActions = daoFactory.getExitplansactionsDao().getExitPlansActionsById(exitPlansActionsId);
       if(pExitPlansActions==null) throw new ExitPlansActionsNotFoundException();

       return ExitPlansActionsConverter.entityToModel( pExitPlansActions );
   }


   @Transactional
   public ExitPlansActionsList getAllExitExitPlansActionss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	   ExitPlansActionsList exitPlansActionss = new ExitPlansActionsList();
        List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions> entities = daoFactory.getExitplansactionsDao().getAllExitExitPlansActionss(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions entity : entities){
           exitPlansActionss.addExitPlansActions(ExitPlansActionsConverter.entityToModel(entity));
        }
        long count = daoFactory.getExitplansactionsDao().getExitExitPlansActionssCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(exitPlansActionss.getExitPlansActionsList().size());
        pagination.setTotal((int)count);
        exitPlansActionss.setPagination(pagination);
        return exitPlansActionss; 
   }


}
