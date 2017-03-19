/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2016.Client;

/**
 * @author Sandeep
 *
 */
public interface ClientVeteranInfoDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo veteranInfo);
	   void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo getVeteranInfoById(UUID veteranInfoId);
	   List<com.servinglynk.hmis.warehouse.model.v2016.ClientVeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
	   long getClientVeteranInfosCount(UUID clientId);
}
