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
public interface HousingassessmentdispositionDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition createHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition);
	   com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition updateHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition);
	   void deleteHousingAssessmentDisposition(com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition housingAssessmentDisposition);
	   com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition getHousingAssessmentDispositionById(UUID housingAssessmentDispositionId);
	   List<com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition> getAllExitHousingAssessmentDispositions(UUID exitId,Integer startIndex, Integer maxItems);
	   long getExitHousingAssessmentDispositionsCount(UUID exitId);
}
