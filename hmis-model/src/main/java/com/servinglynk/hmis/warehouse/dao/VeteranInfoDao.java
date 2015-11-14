/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.staging.Client;

/**
 * @author Sandeep
 *
 */
public interface VeteranInfoDao extends ParentDao {
	public void hydrateLive(Client client);
	
	   com.servinglynk.hmis.warehouse.model.live.VeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.live.VeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.live.VeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.live.VeteranInfo veteranInfo);
	   void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.live.VeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.live.VeteranInfo getVeteranInfoById(UUID veteranInfoId);
	   List<com.servinglynk.hmis.warehouse.model.live.VeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
	   long getClientVeteranInfosCount(UUID clientId);
}
