/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2017.Client;

/**
 * @author Sandeep
 *
 */
public interface ClientVeteranInfoDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo veteranInfo);
	   void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo getVeteranInfoById(UUID veteranInfoId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.ClientVeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
	   long getClientVeteranInfosCount(UUID clientId);
}
