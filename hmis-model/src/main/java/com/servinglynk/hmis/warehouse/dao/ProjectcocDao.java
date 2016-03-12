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
public interface ProjectcocDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.v2014.Projectcoc createProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc);
	   com.servinglynk.hmis.warehouse.model.v2014.Projectcoc updateProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc);
	   void deleteProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc);
	   com.servinglynk.hmis.warehouse.model.v2014.Projectcoc getProjectcocById(UUID projectcocId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Projectcoc> getAllProjectProjectcocs(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectProjectcocsCount(UUID projectId);

}
