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
public interface ReferralsourceDao extends ParentDao {

	   com.servinglynk.hmis.warehouse.model.live.Referralsource createReferralsource(com.servinglynk.hmis.warehouse.model.live.Referralsource referralsource);
	   com.servinglynk.hmis.warehouse.model.live.Referralsource updateReferralsource(com.servinglynk.hmis.warehouse.model.live.Referralsource referralsource);
	   void deleteReferralsource(com.servinglynk.hmis.warehouse.model.live.Referralsource referralsource);
	   com.servinglynk.hmis.warehouse.model.live.Referralsource getReferralsourceById(UUID referralsourceId);
	   List<com.servinglynk.hmis.warehouse.model.live.Referralsource> getAllEnrollmentReferralsources(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentReferralsourcesCount(UUID enrollmentId);
}
