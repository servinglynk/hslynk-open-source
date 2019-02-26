/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface SiteDao extends ParentDao {


	   com.servinglynk.hmis.warehouse.model.v2015.Site createSite(com.servinglynk.hmis.warehouse.model.v2015.Site site);
	   com.servinglynk.hmis.warehouse.model.v2015.Site updateSite(com.servinglynk.hmis.warehouse.model.v2015.Site site);
	   void deleteSite(com.servinglynk.hmis.warehouse.model.v2015.Site site);
	   com.servinglynk.hmis.warehouse.model.v2015.Site getSiteById(UUID siteId);
	   List<com.servinglynk.hmis.warehouse.model.v2015.Site> getAllProjectCOCSites(UUID projectCocId,Integer startIndex, Integer maxItems);
	   long getProjectCOCSitesCount(UUID projectCocId);
}
