/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;

/**
 * @author Sandeep
 *
 */
public interface DisabilitiesDao extends ParentDao {

	
	
	   com.servinglynk.hmis.warehouse.model.v2014.Disabilities createDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities);
	   com.servinglynk.hmis.warehouse.model.v2014.Disabilities updateDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities);
	   void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities);
	   com.servinglynk.hmis.warehouse.model.v2014.Disabilities getDisabilitiesById(UUID disabilitiesId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDisabilitiessCount(UUID enrollmentId);
	   public void hydrate(ExportDomain domain,Map<String, HmisBaseModel> exportModelMap,Map<String,HmisBaseModel> relatedModelMap) throws Exception;
}
