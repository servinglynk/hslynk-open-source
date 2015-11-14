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

	
	   com.servinglynk.hmis.warehouse.model.live.Exitplansactions createExitPlansActions(com.servinglynk.hmis.warehouse.model.live.Exitplansactions exitPlansActions);
	   com.servinglynk.hmis.warehouse.model.live.Exitplansactions updateExitPlansActions(com.servinglynk.hmis.warehouse.model.live.Exitplansactions exitPlansActions);
	   void deleteExitPlansActions(com.servinglynk.hmis.warehouse.model.live.Exitplansactions exitPlansActions);
	   com.servinglynk.hmis.warehouse.model.live.Exitplansactions getExitPlansActionsById(UUID exitPlansActionsId);
	   List<com.servinglynk.hmis.warehouse.model.live.Exitplansactions> getAllExitExitPlansActionss(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getExitExitPlansActionssCount(UUID enrollmentId);
}
