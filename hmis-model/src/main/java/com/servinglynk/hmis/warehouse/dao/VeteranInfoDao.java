/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.stagv2014.Client;

/**
 * @author Sandeep
 *
 */
public interface VeteranInfoDao extends ParentDao {
	public void hydrateLive(Client client);
	
	   com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo);
	   void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo getVeteranInfoById(UUID veteranInfoId);
	   List<com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
	   long getClientVeteranInfosCount(UUID clientId);
}
