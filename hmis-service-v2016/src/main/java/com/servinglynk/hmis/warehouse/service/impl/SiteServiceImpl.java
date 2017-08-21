package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.Site;
import com.servinglynk.hmis.warehouse.core.model.Sites;
import com.servinglynk.hmis.warehouse.service.SiteService;
import com.servinglynk.hmis.warehouse.service.converter.SiteConverter;
import com.servinglynk.hmis.warehouse.service.exception.CocNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SiteNotFoundException;


public class SiteServiceImpl extends ServiceBase implements SiteService  {

   @Transactional
   public Site createSite(Site site,UUID projectCocId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Site pSite = SiteConverter.modelToEntity(site, null);
       com.servinglynk.hmis.warehouse.model.v2017.Coc pProjectcoc = daoFactory.getCocDao().getCocById(projectCocId);
       if(pProjectcoc == null) throw new CocNotFoundException();
       pSite.setCoc(pProjectcoc);
       pSite.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pSite, caller);
       daoFactory.getSiteDao().createSite(pSite);
       site.setSiteId(pSite.getId());
       return site;
   }


   @Transactional
   public Site updateSite(Site site,UUID projectCocId,String caller){
	   com.servinglynk.hmis.warehouse.model.v2017.Coc pProjectcoc = daoFactory.getCocDao().getCocById(projectCocId);
       if(pProjectcoc == null) throw new CocNotFoundException();
       com.servinglynk.hmis.warehouse.model.v2017.Site pSite = daoFactory.getSiteDao().getSiteById(site.getSiteId());
       if(pSite==null) throw new SiteNotFoundException();

       SiteConverter.modelToEntity(site, pSite);
       pSite.setCoc(pProjectcoc);
       pSite.setDateUpdated(LocalDateTime.now());
       pSite.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getSiteDao().updateSite(pSite);
       site.setSiteId(pSite.getId());
       return site;
   }


   @Transactional
   public Site deleteSite(UUID siteId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Site pSite = daoFactory.getSiteDao().getSiteById(siteId);
       if(pSite==null) throw new SiteNotFoundException();

       daoFactory.getSiteDao().deleteSite(pSite);
       return new Site();
   }


   @Transactional
   public Site getSiteById(UUID siteId){
       com.servinglynk.hmis.warehouse.model.v2017.Site pSite = daoFactory.getSiteDao().getSiteById(siteId);
       if(pSite==null) throw new SiteNotFoundException();

       return SiteConverter.entityToModel( pSite );
   }


   @Transactional
   public Sites getAllProjectCocSites(UUID projectCocId,Integer startIndex, Integer maxItems){
       Sites sites = new Sites();
        List<com.servinglynk.hmis.warehouse.model.v2017.Site> entities = daoFactory.getSiteDao().getAllProjectCOCSites(projectCocId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Site entity : entities){
           sites.addSite(SiteConverter.entityToModel(entity));
        }
        long count = daoFactory.getSiteDao().getProjectCOCSitesCount(projectCocId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(sites.getSites().size());
        pagination.setTotal((int)count);
        sites.setPagination(pagination);
        return sites;
   }


}
