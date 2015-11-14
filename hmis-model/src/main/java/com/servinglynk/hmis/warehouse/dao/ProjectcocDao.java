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

	   com.servinglynk.hmis.warehouse.model.live.Projectcoc createProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc);
	   com.servinglynk.hmis.warehouse.model.live.Projectcoc updateProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc);
	   void deleteProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc);
	   com.servinglynk.hmis.warehouse.model.live.Projectcoc getProjectcocById(UUID projectcocId);
	   List<com.servinglynk.hmis.warehouse.model.live.Projectcoc> getAllProjectProjectcocs(UUID projectId,Integer startIndex, Integer maxItems);
	   long getProjectProjectcocsCount(UUID projectId);

}
