package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.core.model.HousingAssessmentDispositions;
import com.servinglynk.hmis.warehouse.service.HousingAssessmentDispositionService;
import com.servinglynk.hmis.warehouse.service.converter.HousingAssessmentDispositionConverter;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HousingAssessmentDispositionNotFoundException;


public class HousingAssessmentDispositionServiceImpl extends ServiceBase implements HousingAssessmentDispositionService  {

   @Transactional
   public HousingAssessmentDisposition createHousingAssessmentDisposition(HousingAssessmentDisposition housingAssessmentDisposition,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition pHousingAssessmentDisposition = HousingAssessmentDispositionConverter.modelToEntity(housingAssessmentDisposition, null);
       com.servinglynk.hmis.warehouse.model.v2016.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       pHousingAssessmentDisposition.setExitid(pExit);
       pHousingAssessmentDisposition.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pHousingAssessmentDisposition, caller);
       daoFactory.getHousingassessmentdispositionDao().createHousingAssessmentDisposition(pHousingAssessmentDisposition);
       housingAssessmentDisposition.setHousingAssessmentDispositionId(pHousingAssessmentDisposition.getId());
       return housingAssessmentDisposition;
   }


   @Transactional
   public HousingAssessmentDisposition updateHousingAssessmentDisposition(HousingAssessmentDisposition housingAssessmentDisposition,UUID exitId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Exit pExit = daoFactory.getExitDao().getExitById(exitId);
       if(pExit == null) throw new ExitNotFoundException();
       com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition pHousingAssessmentDisposition = daoFactory.getHousingassessmentdispositionDao().getHousingAssessmentDispositionById(housingAssessmentDisposition.getHousingAssessmentDispositionId());
       if(pHousingAssessmentDisposition==null) throw new HousingAssessmentDispositionNotFoundException();

       HousingAssessmentDispositionConverter.modelToEntity(housingAssessmentDisposition, pHousingAssessmentDisposition);
       pHousingAssessmentDisposition.setExitid(pExit);
       pHousingAssessmentDisposition.setDateUpdated(LocalDateTime.now());
       pHousingAssessmentDisposition.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getHousingassessmentdispositionDao().updateHousingAssessmentDisposition(pHousingAssessmentDisposition);
       housingAssessmentDisposition.setHousingAssessmentDispositionId(pHousingAssessmentDisposition.getId());
       return housingAssessmentDisposition;
   }


   @Transactional
   public HousingAssessmentDisposition deleteHousingAssessmentDisposition(UUID housingAssessmentDispositionId,String caller){
       com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition pHousingAssessmentDisposition = daoFactory.getHousingassessmentdispositionDao().getHousingAssessmentDispositionById(housingAssessmentDispositionId);
       if(pHousingAssessmentDisposition==null) throw new HousingAssessmentDispositionNotFoundException();

       daoFactory.getHousingassessmentdispositionDao().deleteHousingAssessmentDisposition(pHousingAssessmentDisposition);
       return new HousingAssessmentDisposition();
   }


   @Transactional
   public HousingAssessmentDisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId){
       com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition pHousingAssessmentDisposition = daoFactory.getHousingassessmentdispositionDao().getHousingAssessmentDispositionById(housingAssessmentDispositionId);
       if(pHousingAssessmentDisposition==null) throw new HousingAssessmentDispositionNotFoundException();

       return HousingAssessmentDispositionConverter.entityToModel( pHousingAssessmentDisposition );
   }


   @Transactional
   public HousingAssessmentDispositions getAllEnrollmentHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems){
       HousingAssessmentDispositions housingAssessmentDispositions = new HousingAssessmentDispositions();
        List<com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition> entities = daoFactory.getHousingassessmentdispositionDao().getAllExitHousingAssessmentDispositions(exitId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2016.Housingassessmentdisposition entity : entities){
           housingAssessmentDispositions.addHousingAssessmentDisposition(HousingAssessmentDispositionConverter.entityToModel(entity));
        }
        long count = daoFactory.getHousingassessmentdispositionDao().getExitHousingAssessmentDispositionsCount(exitId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(housingAssessmentDispositions.getHousingAssessmentDispositions().size());
        pagination.setTotal((int)count);
        housingAssessmentDispositions.setPagination(pagination);
        return housingAssessmentDispositions;
   }


}
