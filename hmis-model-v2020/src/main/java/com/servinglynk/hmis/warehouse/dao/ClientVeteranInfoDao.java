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
public interface ClientVeteranInfoDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo);
	   void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo);
	   com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo getVeteranInfoById(UUID veteranInfoId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems);
	   long getClientVeteranInfosCount(UUID clientId);
}
