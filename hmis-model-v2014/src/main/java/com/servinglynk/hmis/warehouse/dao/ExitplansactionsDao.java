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
public interface ExitplansactionsDao extends ParentDao {

	
	   com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions createExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions);
	   com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions updateExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions);
	   void deleteExitPlansActions(com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions exitPlansActions);
	   com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions getExitPlansActionsById(UUID exitPlansActionsId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions> getAllExitExitPlansActionss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getExitExitPlansActionssCount(UUID enrollmentId);
}
