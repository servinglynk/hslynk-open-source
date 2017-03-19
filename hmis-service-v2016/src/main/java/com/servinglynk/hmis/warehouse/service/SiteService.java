package com.servinglynk.hmis.warehouse.service; 

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Site;
import com.servinglynk.hmis.warehouse.core.model.Sites;
public interface SiteService {

   Site createSite(Site site,UUID projectCocId,String caller);
   Site updateSite(Site site,UUID projectCocId,String caller);
   Site deleteSite(UUID siteId,String caller);
   Site getSiteById(UUID siteId);
   Sites getAllProjectCocSites(UUID projectCocId,Integer startIndex, Integer maxItems);
}
