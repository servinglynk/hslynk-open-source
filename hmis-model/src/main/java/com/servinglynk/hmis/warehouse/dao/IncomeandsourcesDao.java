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
public interface IncomeandsourcesDao extends ParentDao {

	
	
	   com.servinglynk.hmis.warehouse.model.live.Incomeandsources createIncomeAndSource(com.servinglynk.hmis.warehouse.model.live.Incomeandsources incomeAndSource);
	   com.servinglynk.hmis.warehouse.model.live.Incomeandsources updateIncomeAndSource(com.servinglynk.hmis.warehouse.model.live.Incomeandsources incomeAndSource);
	   void deleteIncomeAndSource(com.servinglynk.hmis.warehouse.model.live.Incomeandsources incomeAndSource);
	   com.servinglynk.hmis.warehouse.model.live.Incomeandsources getIncomeAndSourceById(UUID incomeAndSourceId);
	   List<com.servinglynk.hmis.warehouse.model.live.Incomeandsources> getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentIncomeAndSourcesCount(UUID enrollmentId);
}
