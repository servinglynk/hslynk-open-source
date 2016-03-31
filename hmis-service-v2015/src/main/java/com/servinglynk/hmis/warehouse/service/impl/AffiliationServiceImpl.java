package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Affiliation;
import com.servinglynk.hmis.warehouse.core.model.Affiliations;
import com.servinglynk.hmis.warehouse.service.AffiliationService;
import com.servinglynk.hmis.warehouse.service.converter.AffiliationConverter;
import com.servinglynk.hmis.warehouse.service.exception.AffiliationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;


public class AffiliationServiceImpl extends ServiceBase implements AffiliationService  {

   @Transactional
   public Affiliation createAffiliation(Affiliation affiliation,UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Affiliation pAffiliation = AffiliationConverter.modelToEntity(affiliation, null);
       com.servinglynk.hmis.warehouse.model.v2015.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException(); 
       pAffiliation.setProjectid(pProject); 
       pAffiliation.setDateCreated(LocalDateTime.now());
    //   pAffiliation.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getAffiliationDao().createAffiliation(pAffiliation);
       affiliation.setAffiliationId(pAffiliation.getId());
       return affiliation;
   }


   @Transactional
   public Affiliation updateAffiliation(Affiliation affiliation,UUID projectId,String caller){
	   com.servinglynk.hmis.warehouse.model.v2015.Project pProject = daoFactory.getProjectDao().getProjectById(projectId); 
       if(pProject == null) throw new ProjectNotFoundException(); 
       com.servinglynk.hmis.warehouse.model.v2015.Affiliation pAffiliation = daoFactory.getAffiliationDao().getAffiliationById(affiliation.getAffiliationId());
       if(pAffiliation==null) throw new AffiliationNotFoundException();

       AffiliationConverter.modelToEntity(affiliation, pAffiliation);
       pAffiliation.setProjectid(pProject); 
       pAffiliation.setDateUpdated(LocalDateTime.now());
   //    pAffiliation.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getAffiliationDao().updateAffiliation(pAffiliation);
       affiliation.setAffiliationId(pAffiliation.getId());
       return affiliation;
   }


   @Transactional
   public Affiliation deleteAffiliation(UUID affiliationId,String caller){
       com.servinglynk.hmis.warehouse.model.v2015.Affiliation pAffiliation = daoFactory.getAffiliationDao().getAffiliationById(affiliationId);
       if(pAffiliation==null) throw new AffiliationNotFoundException();

       daoFactory.getAffiliationDao().deleteAffiliation(pAffiliation);
       return new Affiliation();
   }


   @Transactional
   public Affiliation getAffiliationById(UUID affiliationId){
       com.servinglynk.hmis.warehouse.model.v2015.Affiliation pAffiliation = daoFactory.getAffiliationDao().getAffiliationById(affiliationId);
       if(pAffiliation==null) throw new AffiliationNotFoundException();

       return AffiliationConverter.entityToModel( pAffiliation );
   }


   @Transactional
   public Affiliations getAllProjectAffiliations(UUID projectId,Integer startIndex, Integer maxItems){
       Affiliations affiliations = new Affiliations();
        List<com.servinglynk.hmis.warehouse.model.v2015.Affiliation> entities = daoFactory.getAffiliationDao().getAllProjectAffiliations(projectId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2015.Affiliation entity : entities){
           affiliations.addAffiliation(AffiliationConverter.entityToModel(entity));
        }
        long count = daoFactory.getAffiliationDao().getProjectAffiliationsCount(projectId);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(affiliations.getAffiliations().size());
        pagination.setTotal((int)count);
        affiliations.setPagination(pagination);
        return affiliations; 
   }


}
